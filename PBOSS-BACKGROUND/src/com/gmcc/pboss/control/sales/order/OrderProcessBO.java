package com.gmcc.pboss.control.sales.order;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.orderproce.OrderproceDBParam;
import com.gmcc.pboss.business.sales.orderproce.OrderproceVO;
import com.gmcc.pboss.business.sales.ordertask.OrdertaskDBParam;
import com.gmcc.pboss.business.sales.ordertask.OrdertaskVO;
import com.gmcc.pboss.business.sales.process.ProcessVO;
import com.gmcc.pboss.control.sales.autodeal.OrderDeal;
import com.gmcc.pboss.control.sales.orderproce.Orderproce;
import com.gmcc.pboss.control.sales.orderproce.OrderproceBO;
import com.gmcc.pboss.control.sales.ordertask.Ordertask;
import com.gmcc.pboss.control.sales.ordertask.OrdertaskBO;
import com.gmcc.pboss.control.sales.process.ProcessBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class OrderProcessBO extends AbstractControlBean implements OrderProcess {
	private Log log = LogFactory.getLog(OrderProcessBO.class);

	public void process(int intervalMin) throws Exception {
		while(true) {
			// TODO Auto-generated method stub
			// 查询订单任务表（FX_SW_ORDERTASK），匹配地市标识为入口参数地市标识
			// ,匹配有效性为有效，如果无数据则进入休眠，否则对结果数据逐条处理
			Ordertask ordertaskBO = (OrdertaskBO) BOFactory.build(OrdertaskBO.class, user);
			OrdertaskDBParam ordertaskParam = new OrdertaskDBParam();
			ordertaskParam.setQueryAll(true);
			ordertaskParam.setDataOnly(true);
			ordertaskParam.set_se_cityid(user.getCityid());
			ordertaskParam.set_ne_effective("1");
			ordertaskParam.set_orderby("recid");
			ordertaskParam.set_desc("0");
			DataPackage ordertaskDP = ordertaskBO.doQuery(ordertaskParam);
			if (null != ordertaskDP && null != ordertaskDP.getDatas()
					&& 0 < ordertaskDP.getDatas().size()) {
				for (int i = 0; i < ordertaskDP.getDatas().size(); i++) {
					try {
						OrdertaskVO ordertaskVO = (OrdertaskVO) ((List) ordertaskDP.getDatas()).get(i);
						this.doAutoProcess(ordertaskVO);
					} catch (Exception e) {
						LoggerUtils.error(e, log);
					}
				}
			} else {
				log.info("==============休眠 "+intervalMin+" 分钟=====================");
				Thread.sleep(intervalMin*60000);
			}
		}
	}


	public void doAutoProcess(OrdertaskVO ordertaskVO) throws Exception {
		Ordertask ordertaskBO = (OrdertaskBO) BOFactory.build(OrdertaskBO.class, user);
		Orderproce orderProceBO = (OrderproceBO) BOFactory.build(OrderproceBO.class, user);
		ProcessBO processBO = (ProcessBO) BOFactory.build(ProcessBO.class, user);
		Order orderBO = (OrderBO) BOFactory.build(OrderBO.class, user);
		// 1) 根据订单编号查询订单表（FX_SW_ORDER），如果无数据，则修改订单任务表中有效性为无效，
		// 备注为“订单信息不存在”，返回处理下一条数据；否则继续。
		OrderVO orderVO = orderBO.doFindByPk(ordertaskVO.getOrderid());
		if (null != orderVO) {
			// 2) 根据订单流程编号和订单状态查询订单流程步骤表（FX_RU_ORDERPROCE），匹配入口状态为当前订单状态，如果无数据，
			// 则修改订单任务表中有效性为无效，备注为“当前订单无下一步操作”，返回处理下一条数据；否则继续。
			OrderproceDBParam orderproceParam = new OrderproceDBParam();
			orderproceParam.setQueryAll(true);
			orderproceParam.setDataOnly(true);
			orderproceParam.set_ne_flowid("" + orderVO.getFlowid());
			orderproceParam.set_se_instate(orderVO.getOrderstate());
			DataPackage orderproceDP = orderProceBO.doQuery(orderproceParam);
			if (null != orderproceDP && null != orderproceDP.getDatas()
					&& 0 < orderproceDP.getDatas().size()) {
				try {
					for (int j = 0; j < orderproceDP.getDatas().size(); j++) {
						try {
							OrderproceVO orderproceVO = (OrderproceVO) ((List) orderproceDP.getDatas()).get(j);
							// 3)
							// 如果订单步骤处理模式为人工，则修改订单任务表中有效性为无效，备注为“下一步人工处理步骤”，返回处理下一条数据；否则继续。
							if ("MANUAL".equals(orderproceVO.getDismode())) {
								String date1 = new Date().toLocaleString();
								ordertaskVO.setEffective(new Short("0"));
								ordertaskVO.setMemo("下一步人工处理步骤");
								ordertaskBO.doUpdate(ordertaskVO);
								String date2 = new Date().toLocaleString();
								log.info("ORDERID："+ordertaskVO.getOrderid()+"; DISMODE:MANUAL" + "; DEALBEGIN:"+date1+"; DEALEND:"+date2);
							} else if ("AUTO".equals(orderproceVO.getDismode())) {
								// 4)
								// 如果订单步骤处理模式为自动，调用处理类对该订单进行处理，如果处理失败，则修改订单任务表中有效性为无效，
								// 备注为“[订单步骤名称]处理失败”；如果处理成功，则修改订单任务表中有效性为无效,则继续下一条记录处理。
								ProcessVO processVO = processBO.doFindByPk(orderproceVO.getProcessid());
								try {
									OrderDeal orderDeal = (OrderDeal) Class.forName(processVO.getClasspath()).newInstance();
									String date1 = new Date().toLocaleString();
									boolean result = orderDeal.doDeal(orderVO,user); 
									if (!result) {
										ordertaskVO.setEffective(new Short("0"));
										ordertaskVO.setMemo("["+ processVO.getProcessname()+ "] 处理失败--"+orderVO.getMemo());
										ordertaskBO.doUpdate(ordertaskVO);
									}else{
										ordertaskVO.setEffective(new Short("0"));
										ordertaskVO.setMemo("成功");
										ordertaskBO.doUpdate(ordertaskVO);
										
										orderBO.doNextProcess(orderVO.getOrderid());
										
									}
									String date2 = new Date().toLocaleString();
									log.info("ORDERID："+ordertaskVO.getOrderid()+"; DISMODE:AUTO" +" DEALCLASS:"+processVO.getClasspath() + "; DEALBEGIN:"+date1+"; DEALEND:"+date2);
								} catch (Exception e) {
									e.printStackTrace();
									ordertaskVO.setEffective(new Short("0"));
									ordertaskVO.setMemo("["+ processVO.getProcessname()+ "] 处理失败");
									ordertaskBO.doUpdate(ordertaskVO);
									log.error(e);
								}
							}
						} catch (Exception e) {
							LoggerUtils.error(e, log);
						}
					}
				} catch (Exception e) {
					LoggerUtils.error(e, log);
				}
			} else {
				ordertaskVO.setEffective(new Short("0"));
				ordertaskVO.setMemo("当前订单无下一步操作");
				ordertaskBO.doUpdate(ordertaskVO);
			}
		} else {
			ordertaskVO.setEffective(new Short("0"));
			ordertaskVO.setMemo("订单信息不存在");
			ordertaskBO.doUpdate(ordertaskVO);
		}
	}

}
