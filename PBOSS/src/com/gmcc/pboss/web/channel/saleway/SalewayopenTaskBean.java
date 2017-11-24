package com.gmcc.pboss.web.channel.saleway;

import org.apache.commons.lang.StringUtils;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.channel.way.AGWay;
import com.gmcc.pboss.control.channel.way.AGWayBO;
import com.sunrise.jop.infrastructure.control.BOFactory;

public class SalewayopenTaskBean extends BaseBatchTaskBean {
	AGWay delegate;
	public SalewayopenTaskBean() throws Exception{
		// TODO Auto-generated constructor stub
		super.setBatchName("�������������ͨ");
		super.setWriteLog(true);
		delegate=(AGWay)BOFactory.build(AGWayBO.class, user);
	}
	protected String doStart() {
		// TODO Auto-generated method stub
		return "���|��������|������\r\n";
	}
	protected ResultVO processLine(String line, int rowCount) {
		// TODO Auto-generated method stub
		ResultVO vo=new ResultVO();
		String[] content=new String[2];
		if(line.indexOf('|')>0){
			content=StringUtils.splitPreserveAllTokens(line,'|');
		}else{
			content[0]=line;
		}
		
		try {
			delegate.doSetservice(content[0], user);
			vo.setOk(true);
			vo.setInfo(rowCount+"|"+content[0]+"|"+"��ͨ����ɹ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			vo.setInfo(rowCount+"|"+content[0]+"|"+"������Ϣ:"+e.getMessage());
			vo.setOk(false);
		}
		return vo;
	}
	
}
