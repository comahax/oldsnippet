package com.gmcc.pboss.web.sales.order;

import org.apache.commons.lang.StringUtils; 
import com.gmcc.pboss.business.sales.order.OrderVO; 
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO; 
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.sunrise.jop.infrastructure.control.BOFactory;

public class OrderBatchReviewTaskBean extends BaseBatchTaskBean{
	public OrderBatchReviewTaskBean() throws Exception {
		super.setBatchName("订单批量复核"); 
		super.setOprtype("导入");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub

	}

	protected String doStart() {
		return "行号|订单编号|出错信息|  \r\n";
	}

	@Override
	protected ResultVO processLine(String line, int rowCount) { 
		ResultVO resultVO = new ResultVO();
		try {
			 String items[] = StringUtils.splitPreserveAllTokens(line, "|");
			  Order order = (Order) BOFactory.build(OrderBO.class,user);
              OrderVO orderVo = new OrderVO(); 
              orderVo = order.doFindByPk(items[0]);
			  if ( null == orderVo ||("").equals(orderVo) ) {    //订单信息检查
				  throw new Exception("订单不存在"); 
			  } else if (!orderVo.getOrderstate().equals("FINISHED"))  {  //订单状态检查
				  throw new Exception("订单状态不正确"); 
			  } else if (new Integer("1").equals(orderVo.getReviewstate())) {
				  throw new Exception("该订单已复核"); 
			  }else {
				  orderVo.setReviewstate(1);
				  order.doUpdate(orderVo);
			  }
			
			line = rowCount
					+ "|" + items[0]+ "|"+"复核成功"+"|";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		} catch (Exception e) { 
			line = rowCount + "|" + line +"|"+"出错原因:" + e.getMessage()+"|";
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}

}
