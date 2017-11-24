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
		super.setBatchName("����������������"); 
		super.setOprtype("����");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub

	}

	protected String doStart() {
		return "�к�|���͵����|��������|����ԭ��|  \r\n";
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
				  throw new Exception("���͵�������"); 
			  } else {
				  diformVo.setLogisticsno(items[1]);
				  disform.doUpdate(diformVo); 
			  }     
			
			line = rowCount
			+ "|" + items[0]+ "|"+items[1] + "|"+"¼��ɹ�"+"|";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		} catch (Exception e) { 
			line = rowCount + "|" + line +"������Ϣ:" + e.getMessage()+"|";
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}

}
