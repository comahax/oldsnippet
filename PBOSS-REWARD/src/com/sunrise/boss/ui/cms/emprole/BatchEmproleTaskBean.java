package com.sunrise.boss.ui.cms.emprole;
import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.emprole.persistent.EmproleVO;
import com.sunrise.boss.delegate.cms.emprole.EmproleDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class BatchEmproleTaskBean extends BaseBatchTaskBean {
	private EmproleDelegate delegate;

	public BatchEmproleTaskBean() throws Exception {
		super.setBatchName("社区经理管理导入结果");
		super.setWriteLog(true);
		delegate = new EmproleDelegate();
		// TODO Auto-generated constructor stub
	}

	protected String doStart() {
		return "社区经理管理导入结果 \r\n";
	}

	/**
	 * 处理一条记录
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

		line = rowCount + "   " + line + "    成功";
		rvo.setInfo(line);
		rvo.setOk(true);
		return rvo;
	}

}
