package com.gmcc.pboss.web.sales.orderremove;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.sunrise.jop.infrastructure.control.BOFactory;

public class RemoveBatchTaskBean extends BaseBatchTaskBean {
	
	public RemoveBatchTaskBean() throws Exception{
		// 
		super.setBatchName("������������");
		super.setOprtype("����");
//		super.setWriteLog(true);
	}
	protected String doStart() {
		return "���|�������|����ԭ��|˵��|������\r\n";
	}
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO vo=new ResultVO();
		String[] content=new String[3];
		if(line.indexOf('|')>0){
			content=StringUtils.splitPreserveAllTokens(line,'|');
		}else{
			content[0]=line;
		}
		
		try {
			String [] orderid = new String[1];
			orderid[0] = content[0];
			Order delegate = (Order) BOFactory.build(OrderBO.class,user);
			if (delegate.doFindByPk(content[0]) == null) {
				throw new Exception("����������");
			}
			// �������Ϻ�
			delegate.cancleOrder(orderid, content[1], content[2]);
			//�������Ϻ󣬶���֪ͨ,�漰���ݿ��������Ĳ���Ҫ�������һ�������У�
			//�������������޸ġ�ʵʱ���������¡�������Դ�ͷš����͵����ϵȲ��衣
			//���������Ͷ���֪ͨ
			delegate.doSmsAfterCancel(orderid, content[1], content[2]);
			
			// ������
			vo.setInfo(rowCount+"|"+content[0]+"|"+content[1]+"|"+content[2]+"|"+"���ϳɹ�");
			vo.setOk(true);

			return vo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			vo.setInfo(rowCount+"|"+content[0]+"|"+content[1]+"|"+content[2]+"|"+"������Ϣ:"+e.getMessage());
			vo.setOk(false);
			return vo;
		}		
	}

}
