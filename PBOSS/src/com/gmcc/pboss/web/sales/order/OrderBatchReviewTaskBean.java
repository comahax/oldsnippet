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
		super.setBatchName("������������"); 
		super.setOprtype("����");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub

	}

	protected String doStart() {
		return "�к�|�������|������Ϣ|  \r\n";
	}

	@Override
	protected ResultVO processLine(String line, int rowCount) { 
		ResultVO resultVO = new ResultVO();
		try {
			 String items[] = StringUtils.splitPreserveAllTokens(line, "|");
			  Order order = (Order) BOFactory.build(OrderBO.class,user);
              OrderVO orderVo = new OrderVO(); 
              orderVo = order.doFindByPk(items[0]);
			  if ( null == orderVo ||("").equals(orderVo) ) {    //������Ϣ���
				  throw new Exception("����������"); 
			  } else if (!orderVo.getOrderstate().equals("FINISHED"))  {  //����״̬���
				  throw new Exception("����״̬����ȷ"); 
			  } else if (new Integer("1").equals(orderVo.getReviewstate())) {
				  throw new Exception("�ö����Ѹ���"); 
			  }else {
				  orderVo.setReviewstate(1);
				  order.doUpdate(orderVo);
			  }
			
			line = rowCount
					+ "|" + items[0]+ "|"+"���˳ɹ�"+"|";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		} catch (Exception e) { 
			line = rowCount + "|" + line +"|"+"����ԭ��:" + e.getMessage()+"|";
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}

}
