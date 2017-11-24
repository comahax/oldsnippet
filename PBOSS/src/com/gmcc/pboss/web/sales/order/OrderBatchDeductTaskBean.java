package com.gmcc.pboss.web.sales.order;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.orderlog.OrderlogDBParam;
import com.gmcc.pboss.business.sales.orderlog.OrderlogVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.orderlog.Orderlog;
import com.gmcc.pboss.control.sales.orderlog.OrderlogBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class OrderBatchDeductTaskBean extends BaseBatchTaskBean {
	public OrderBatchDeductTaskBean() throws Exception {
		super.setBatchName("批量扣费结果短信");
		super.setOprtype("导入");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub

	}

	protected String doStart() {
		return "行号|订单编号|处理结果|  \r\n";
	}

	@Override
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try {
			String optype = (String)getParameterMap().get("optype");
			
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");
			Order order = (Order) BOFactory.build(OrderBO.class, user);
			OrderVO orderVo = new OrderVO();
			orderVo = order.doFindByPk(items[0]);
			
			Orderlog orderlogBO = (OrderlogBO)BOFactory.build(OrderlogBO.class, user);
			OrderlogDBParam orderlogDBParam = new OrderlogDBParam();
			orderlogDBParam.set_se_orderid(items[0]);//订单号（ORDERID）
			//orderlogDBParam.set_se_orderstate("CHARGED");//已收费（CHARGED） 
			DataPackage orderlogDP = orderlogBO.doQuery(orderlogDBParam);
			OrderlogVO orderlogVO = null;
			if(orderlogDP.getRowCount() > 0){
				orderlogVO = (OrderlogVO)orderlogDP.getDatas().get(0);
			}
			
			if (null == orderVo || ("").equals(orderVo)) {//订单信息检查
				throw new Exception("订单不存在");
			} else if (!( ("BANK").equals(orderVo.getPaytype()) || ("CASH").equals(orderVo.getPaytype()) )) {
				throw new Exception("订单收费方式不为银行划扣或现金");
			} else if (orderlogVO == null) { //订单划扣状态检查
				throw new Exception("订单未进行扣费操作");
			} else {
				String result = "";
				String reason = "";
				if("CASH".equals(optype)){
					result = items[1];
					reason = items[2];
				}
				order.doDeductSendMsg(orderVo, optype, result, reason);
			}

			line = rowCount + "|" + items[0] + "|" + "发送成功" + "|";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		} catch (Exception e) {
			line = rowCount + "|" + line + "|" + "出错原因:" + e.getMessage() + "|";
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
}
