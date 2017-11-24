package com.sunrise.boss.ui.cms.bbc.subtracti;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.bbc.subtract.persistent.SubtractVO;
import com.sunrise.boss.business.cms.operation.persistent.OperationVO;
import com.sunrise.boss.delegate.cms.bbc.subtract.SubtractDelegate;
import com.sunrise.boss.delegate.cms.operation.OperationDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class SubtractiTaskBean extends BaseBatchTaskBean {

	public SubtractiTaskBean() throws Exception{
		super.setBatchName("����֧�����ҵ�����õ���");
		super.setWriteLog(true);
	}

	@Override
	protected String doStart() {
		// TODO Auto-generated method stub
		return "����֧�����ҵ�����õ��� \r\n";
	}

	@Override
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		
		try {
			OperationDelegate delegate=new OperationDelegate();
			OperationVO vo = delegate.doFindByPk(content[0], user);
			if (vo == null) {
				throw new Exception("�������[����֧�����ҵ�����]������");
			}
			
			SubtractDelegate sDelegate=new SubtractDelegate();			
			SubtractVO sVO=new SubtractVO();
			sVO.setIntvopnid(content[0]);
			sVO.setCalcmonth(content[1]);
			
			sDelegate.doCreate(sVO, user);
			
			line = rowCount + "   " + line + "    �����ɹ�";
			resultVO.setOk(true);
			resultVO.setInfo(line);
			return resultVO;
		} catch (Exception e) {
			line = rowCount + "   " + line + "    ������Ϣ:" + e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		
		return resultVO;
	}
	
}
