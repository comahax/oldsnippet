package com.sunrise.boss.ui.kdkhzld.chpwbroadlist;

import java.text.SimpleDateFormat;

import com.sunrise.boss.business.kdkhzld.chpwbroadlist.persistent.ChPwBroadlistVO;
import com.sunrise.boss.delegate.kdkhzld.chpwbroadlist.ChPwBroadlistDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.pub.tools.StringSplit;

public class ChPwBroadlistTaskBean extends BaseBatchTaskBean {
	
	public ChPwBroadlistTaskBean() throws Exception{
		
	}
	
	protected String doStart() {
		
		
		return "����������|������Ϣ \r\n";
	}
	
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO=new ResultVO();
		String[] content = StringSplit.split(line, "|");
		
		try{
			ChPwBroadlistDelegate chPwBroadlistDelegate = new ChPwBroadlistDelegate();
			ChPwBroadlistVO chPwBroadlistVO = new ChPwBroadlistVO();
			chPwBroadlistVO.setMobile(content[0]);
			
			chPwBroadlistDelegate.doCreate(chPwBroadlistVO, user);
			
			
			resultVO.setOk(true);
			resultVO.setInfo(rowCount+"|"+line+"�ɹ�");
		}catch(Exception e){
			line = rowCount + "|" + line + "    ������Ϣ:" + e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
}
