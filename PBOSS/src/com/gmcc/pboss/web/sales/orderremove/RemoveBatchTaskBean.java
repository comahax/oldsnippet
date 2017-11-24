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
		super.setBatchName("订单批量作废");
		super.setOprtype("导入");
//		super.setWriteLog(true);
	}
	protected String doStart() {
		return "序号|订单编号|作废原因|说明|处理结果\r\n";
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
				throw new Exception("订单不存在");
			}
			// 订购作废后
			delegate.cancleOrder(orderid, content[1], content[2]);
			//订购作废后，短信通知,涉及数据库变更操作的步骤要求包含在一个事务中，
			//包括订单数据修改、实时订购量更新、订单资源释放、配送单作废等步骤。
			//不包括发送短信通知
			delegate.doSmsAfterCancel(orderid, content[1], content[2]);
			
			// 结果输出
			vo.setInfo(rowCount+"|"+content[0]+"|"+content[1]+"|"+content[2]+"|"+"作废成功");
			vo.setOk(true);

			return vo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			vo.setInfo(rowCount+"|"+content[0]+"|"+content[1]+"|"+content[2]+"|"+"错误信息:"+e.getMessage());
			vo.setOk(false);
			return vo;
		}		
	}

}
