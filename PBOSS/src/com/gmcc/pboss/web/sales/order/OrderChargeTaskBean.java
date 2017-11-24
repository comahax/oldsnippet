package com.gmcc.pboss.web.sales.order;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.orderproce.OrderproceDBParam;
import com.gmcc.pboss.business.sales.orderproce.OrderproceVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.orderproce.Orderproce;
import com.gmcc.pboss.control.sales.orderproce.OrderproceBO;
import com.sunrise.jop.exception.BusinessException;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class OrderChargeTaskBean extends BaseBatchTaskBean{

	public OrderChargeTaskBean() throws Exception {
		super.setBatchName("订单批量入帐");
		// TODO Auto-generated constructor stub
	}

	
	@Override
	protected ResultVO processLine(String line, int rowCount) {
		// TODO Auto-generated method stub
		ResultVO resultVO = new ResultVO();
		String items[] = StringUtils.splitPreserveAllTokens(line, "|");
		try{
//			订单信息检查：根据订单编号查询订单表（FX_SW_ORDER），如果无数据则填写出错原因“订单不存在”，返回处理下一条记录；否则继续下一步。
			Order bo = (Order)BOFactory.build(OrderBO.class,user);
			OrderVO orderVO = bo.doFindByPk(items[0]);
			if(null == orderVO)
				throw new Exception(line+"|订单不存在|");
			
			//如果送货方式不是“货到付款”，则签收状态检查通过。
			//如果送货方式为“货到付款”，且签收状态为“已签收”，签收状态检查通过，否则返回提示“送货方式为货到付款，签收状态必须为已签收时，才允许执行收费操作。”。
			if("ARRIVEPAY".equals(orderVO.getDelitype()) && !"SIGNED".equals(orderVO.getSignstate())){
				throw new JOPException(line+"|送货方式为货到付款，签收状态必须为已签收时，才允许执行收费操作。| ");
			}
//			订单状态检查：根据订单流程编号查询订单流程步骤表（FX_RU_ORDERPROCE），匹配出口状态为“已收费”，如果当前订单状态和入口状态一致，则通过检查，继续下一步；否则填写错误原因“订单状态不正确”，返回处理一下条记录。
			Orderproce orderproceBO = (OrderproceBO)BOFactory.build(OrderproceBO.class,user);
			OrderproceDBParam orderproceParam = new OrderproceDBParam();
			orderproceParam.set_ne_flowid(orderVO.getFlowid().toString());
			orderproceParam.set_se_outstate("CHARGED");
			DataPackage dp = orderproceBO.doQuery(orderproceParam);
			
			//如果送货方式为“货到付款”，且签收状态为“已签收”，签收状态检查通过，否则返回提示“送货方式为货到付款，签收状态必须为已签收时，才允许执行收费操作。”。
			if("ARRIVEPAY".equals(orderVO.getDelitype()) && !"SIGNED".equals(orderVO.getSignstate())){
				throw new JOPException(" 送货方式为货到付款，签收状态必须为已签收时，才允许执行收费操作。 ");
			}
			

			if("POS".equals(orderVO.getPaytype())){
				if(StringUtils.isEmpty(items[1])){
					throw new Exception("缴费方式为POS时流水号为空!");
				} else {
					orderVO.setPosstream(items[1].trim());
				}
			}
			
			if( null == dp || null == dp.getDatas() || dp.getDatas().size()== 0 || orderVO.getOrderstate() == null ||  !orderVO.getOrderstate().equalsIgnoreCase(((OrderproceVO)dp.getDatas().get(0)).getInstate())){
				throw new Exception(line+"|订单状态不正确|");
			}
			
			//更新实收金额等于应收金额，更新订单状态为已收费，更新状态变更时间为当前时间，更新到账时间为当前时间。
			orderVO.setActamt(orderVO.getRecamt());
			orderVO.setOrderstate("CHARGED");
			Date nowdate=new Date();
			orderVO.setStatechgtime(nowdate);
			orderVO.setPaytime(nowdate);
			bo.doUpdate(orderVO);
			
			
			//调用【订单下一步处理公用方法】，不判断处理结果，返回处理下一条数据。
			bo.doNextProcess(orderVO.getOrderid());
			
			
			line = "第 "+rowCount+" 行 +"+line +" 处理成功";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		}catch(Exception e){
			e.printStackTrace();
			if( !(e instanceof BusinessException)){
			if(e.getCause() != null && e.getCause().getMessage() != null)
				line = items[0]+"|"+(StringUtils.isNotBlank(items[1])?items[1]:"")+"|"+e.getCause().getMessage()+"|";
			else
				line = items[0]+"|"+(StringUtils.isNotBlank(items[1])?items[1]:"")+"|"+e.getMessage()+"|";
			resultVO.setInfo(line);
			resultVO.setOk(false);
			}else{
				line = "第 "+rowCount+" 行  处理成功:"+e.getMessage();
				resultVO.setInfo(line);
				resultVO.setOk(true);
			}
		}
		return resultVO;
	}
}
