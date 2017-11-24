package com.sunrise.boss.ui.cms.emprole;
import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.emprole.persistent.EmproleVO;
import com.sunrise.boss.delegate.cms.emprole.EmproleDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class BatchEmproleTaskBean extends BaseBatchTaskBean {
	private EmproleDelegate delegate;

	public BatchEmproleTaskBean() throws Exception {
		super.setBatchName("���������������");
		super.setWriteLog(true);
		delegate = new EmproleDelegate();
		// TODO Auto-generated constructor stub
	}

	protected String doStart() {
		return "��������������� \r\n";
	}

	/**
	 * ����һ����¼
	 */
	public ResultVO processLine(String line, int rowCount) {
		if (null == line || "".equals(line)) {
			return null;
		}
		ResultVO rvo = new ResultVO();
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		EmproleVO roleVO = new EmproleVO();
		try {
			roleVO.setEmployeeid(items[0]);
			roleVO.setEkey("SQJL");
			delegate.doCreate(roleVO, user);
		} catch (Exception e) {
			rvo.setInfo(e.getMessage());
			rvo.setOk(false);
		}

		if (rvo.getInfo() != null) {
			line = rowCount + "   " + line + "    " + rvo.getInfo();
			rvo.setInfo(line);
			return rvo;
		}

		line = rowCount + "   " + line + "    �ɹ�";
		rvo.setInfo(line);
		rvo.setOk(true);
		return rvo;
	}

}
