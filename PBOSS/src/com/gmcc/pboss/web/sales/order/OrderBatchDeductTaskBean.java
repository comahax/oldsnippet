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
		super.setBatchName("�����۷ѽ������");
		super.setOprtype("����");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub

	}

	protected String doStart() {
		return "�к�|�������|������|  \r\n";
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
			orderlogDBParam.set_se_orderid(items[0]);//�����ţ�ORDERID��
			//orderlogDBParam.set_se_orderstate("CHARGED");//���շѣ�CHARGED�� 
			DataPackage orderlogDP = orderlogBO.doQuery(orderlogDBParam);
			OrderlogVO orderlogVO = null;
			if(orderlogDP.getRowCount() > 0){
				orderlogVO = (OrderlogVO)orderlogDP.getDatas().get(0);
			}
			
			if (null == orderVo || ("").equals(orderVo)) {//������Ϣ���
				throw new Exception("����������");
			} else if (!( ("BANK").equals(orderVo.getPaytype()) || ("CASH").equals(orderVo.getPaytype()) )) {
				throw new Exception("�����շѷ�ʽ��Ϊ���л��ۻ��ֽ�");
			} else if (orderlogVO == null) { //��������״̬���
				throw new Exception("����δ���п۷Ѳ���");
			} else {
				String result = "";
				String reason = "";
				if("CASH".equals(optype)){
					result = items[1];
					reason = items[2];
				}
				order.doDeductSendMsg(orderVo, optype, result, reason);
			}

			line = rowCount + "|" + items[0] + "|" + "���ͳɹ�" + "|";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		} catch (Exception e) {
			line = rowCount + "|" + line + "|" + "����ԭ��:" + e.getMessage() + "|";
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
}
