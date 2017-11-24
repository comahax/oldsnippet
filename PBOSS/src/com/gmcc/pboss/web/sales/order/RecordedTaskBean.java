package com.gmcc.pboss.web.sales.order;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.orderproce.OrderproceDBParam;
import com.gmcc.pboss.business.sales.orderproce.OrderproceVO;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetDBParam;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.orderproce.Orderproce;
import com.gmcc.pboss.control.sales.orderproce.OrderproceBO;
import com.gmcc.pboss.control.sales.orderresdet.Orderresdet;
import com.gmcc.pboss.control.sales.orderresdet.OrderresdetBO;
import com.gmcc.pboss.web.common.webservice.CRMService;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class RecordedTaskBean extends BaseBatchTaskBean {

	public RecordedTaskBean() throws Exception {
		super.setBatchName("订单批量入帐");
	}

	@Override
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String step = (String) super.parameterMap.get("step");
		String wayid = (String) super.parameterMap.get("wayid");
		// 系统入账
		Order bo = null;
		OrderVO orderVO = null;
		if (StringUtils.isEmpty(step)) {
			try {
				// 订单信息检查：根据订单编号查询订单表（FX_SW_ORDER），如果无数据则填写出错原因“订单不存在”，返回处理下一条记录；否则继续下一步。

				bo = (Order) BOFactory.build(OrderBO.class, user);
				orderVO = bo.doFindByPk(line);
				if (null == orderVO)
					throw new Exception("系统入账失败（编号为 [" + line + "] 订单不存在）");

				// 订单状态检查：根据订单流程编号查询订单流程步骤表（FX_RU_ORDERPROCE），匹配出口状态为“已完成”，如果当前订单状态和入口状态一致，则通过检查，继续下一步；否则填写错误原因“订单状态不正确”，返回处理一下条记录。
				// 通过检查后进行订单入账处理，参照【订单入账】逻辑。
				Orderproce orderProceBO = (OrderproceBO) BOFactory.build(
						OrderproceBO.class, user);
				OrderproceDBParam orderproceParam = new OrderproceDBParam();
				orderproceParam.setDataOnly(true);
				orderproceParam.set_ne_flowid("" + orderVO.getFlowid());
				orderproceParam.set_se_instate(orderVO.getOrderstate());
				DataPackage orderproceDP = orderProceBO.doQuery(orderproceParam);
				if (null == orderproceDP || null == orderproceDP.getDatas()
						|| 0 == orderproceDP.getDatas().size()) {
					log.info("订单["+orderVO.getOrderid()+"]订单状态不正确");
					throw new JOPException(" 订单状态不正确 ");
				}
				OrderproceVO orderproceVO = (OrderproceVO) orderproceDP.getDatas()
						.get(0);
				if (!"FINISHED".equals(orderproceVO.getOutstate())){
					log.info("订单["+orderVO.getOrderid()+"]订单状态不正确");
					throw new JOPException(" 订单状态不正确 ");
				}				
				
				
				
//				Orderproce orderproceBO = (OrderproceBO) BOFactory.build(
//						OrderproceBO.class, user);
//				OrderproceDBParam orderproceParam = new OrderproceDBParam();
//				orderproceParam.set_ne_flowid(orderVO.getFlowid().toString());
//				orderproceParam.set_se_outstate("FINISHED");
//				DataPackage dp = orderproceBO.doQuery(orderproceParam);
//
//				if (null == dp
//						|| null == dp.getDatas()
//						|| dp.getDatas().size() == 0
//						|| orderVO.getOrderstate() == null
//						|| !orderVO.getOrderstate().equalsIgnoreCase(
//								((OrderproceVO) dp.getDatas().get(0))
//										.getInstate()))
//					throw new Exception("系统入账失败（订单状态不正确）");

				bo.recorded(line, wayid,"-1");
				line = line + "|1|系统入账成功";
				resultVO.setInfo(line);
				resultVO.setOk(true);
			} catch (Exception e) {
				e.printStackTrace();
				line = line + "|0|" + e.getMessage();
				resultVO.setInfo(line);
				resultVO.setOk(false);
			}
		}
		// boss入账
		else if (null != step && step.equals("2")) {
			// line 的信息形式为
			// orderid|成功失败状态位|提示信息，状态位1成功0失败
			String[] info = line.split("\\|");
			if (info.length == 3) {
				// 系统入账成功
				if (null != info[1] && info[1].equals("1")) {
					try {
						Orderresdet orderdet = (OrderresdetBO) BOFactory.build(	OrderresdetBO.class, user);
						// 根据订单编号和资源类别不等于空白SIM卡为条件查询订单资源明细表（FX_SW_ORDERRESDET）如果没数据，跳过以下BOSS/CRM入账操作。
						OrderresdetDBParam orderresdet = new OrderresdetDBParam();
						orderresdet.setQueryAll(true);
						orderresdet.setDataOnly(true);
						orderresdet.set_se_orderid(info[0]);
						orderresdet.set_sne_restype("EMPTYSIM");
						DataPackage orderresdetdp = orderdet.doQuery(orderresdet);
						if (orderresdetdp != null && orderresdetdp.getDatas() != null && orderresdetdp.getDatas().size() > 0) {//明细包含非空白卡
							String orderid = info[0];
							bo = (Order) BOFactory.build(OrderBO.class, user);
							OrderVO orderVOt = bo.recordByBoss(orderid, wayid);
							line = info[0] + "|" + info[2] + "，" + "boss接口入账成功";							
							if (!new CRMService().isCRMCityPort(user.getCityid())) {//BOSS入账则发送短信，CRM入账不发送
								// 发送售卡短信.
								Order boSms = (Order) BOFactory.build(OrderBO.class, user);
								boSms.doSmsForSale(orderVOt);
							}							
						}else{//明细均为空白卡
							line = info[0] + "|" + info[2] + "，" + "订购空白卡无需boss入账";
						}
						resultVO.setInfo(line);
						resultVO.setOk(true);
					} catch (Exception e) {
						e.printStackTrace();
						line = info[0] + "|" + info[2] + "，" + "boss接口入账失败（"	+ e.getMessage() + "）";
						resultVO.setInfo(line);
						resultVO.setOk(false);
					}
				}
				// 去掉状态位
				else {
					line = info[0] + "|" + info[2];
					resultVO.setInfo(line);
					resultVO.setOk(false);
				}
			}
		}

		return resultVO;
	}
}
