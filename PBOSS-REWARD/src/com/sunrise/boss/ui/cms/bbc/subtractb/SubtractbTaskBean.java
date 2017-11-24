package com.sunrise.boss.ui.cms.bbc.subtractb;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.bbc.subtract.persistent.SubtractVO;
import com.sunrise.boss.delegate.cms.bbc.subtract.SubtractDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class SubtractbTaskBean extends BaseBatchTaskBean {

	public SubtractbTaskBean() throws Exception{
		super.setBatchName("黑名单号码设置导入");
		super.setWriteLog(true);
	}

	@Override
	protected String doStart() {
		// TODO Auto-generated method stub
		return "黑名单号码设置导入 \r\n";
	}

	@Override
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		
		try {
			SubtractDelegate sDelegate=new SubtractDelegate();			
			SubtractVO sVO=new SubtractVO();
			sVO.setBlackmobile(content[0]);
			sVO.setCalcmonth(content[1]);
			
			sDelegate.doCreate(sVO, user);
			
			line = rowCount + "   " + line + "    操作成功";
			resultVO.setOk(true);
			resultVO.setInfo(line);
			return resultVO;
		} catch (Exception e) {
			line = rowCount + "   " + line + "    错误信息:" + e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		
		return resultVO;
	}
	
}
