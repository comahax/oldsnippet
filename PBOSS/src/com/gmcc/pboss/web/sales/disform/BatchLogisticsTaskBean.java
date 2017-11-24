package com.gmcc.pboss.web.sales.disform;

import org.apache.commons.lang.StringUtils;  
import com.gmcc.pboss.business.sales.disform.DisformVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;  
import com.gmcc.pboss.control.sales.disform.Disform;
import com.gmcc.pboss.control.sales.disform.DisformBO;
import com.sunrise.jop.infrastructure.control.BOFactory;

public class BatchLogisticsTaskBean extends BaseBatchTaskBean {
	 
	public BatchLogisticsTaskBean() throws Exception {
		super.setBatchName("物流单号批量导入"); 
		super.setOprtype("导入");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub

	}

	protected String doStart() {
		return "行号|配送单编号|物流单号|出错原因|  \r\n";
	}

	@Override
	protected ResultVO processLine(String line, int rowCount) { 
		ResultVO resultVO = new ResultVO();
		try {
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");
			  Disform disform = (Disform) BOFactory.build(DisformBO.class,user);
			  DisformVO diformVo = new DisformVO(); 
			  diformVo = disform.doFindByPk(Long.parseLong(items[0]));
			  if ( null == diformVo ||("").equals(diformVo) ) {
				  throw new Exception("配送单不存在"); 
			  } else {
				  diformVo.setLogisticsno(items[1]);
				  disform.doUpdate(diformVo); 
			  }     
			
			line = rowCount
			+ "|" + items[0]+ "|"+items[1] + "|"+"录入成功"+"|";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		} catch (Exception e) { 
			line = rowCount + "|" + line +"错误信息:" + e.getMessage()+"|";
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}

}
