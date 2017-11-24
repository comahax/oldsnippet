package com.sunrise.boss.ui.cms.bbc.mmopn;

import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.bbc.mmopn.persistent.MmopnVO;
import com.sunrise.boss.delegate.cms.bbc.mmopn.MmopnDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class BatchMmopnTaskBean extends BaseBatchTaskBean {
	private MmopnDelegate delegate;

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");

	public BatchMmopnTaskBean() throws Exception {
		super.setBatchName("MM业务管理批量导入结果");
		super.setWriteLog(true);
		delegate = new MmopnDelegate();
		// TODO Auto-generated constructor stub
	}

	protected String doStart() {
		return "MM业务管理批量导入结果 \r\n";
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
		MmopnVO mmopnVO = new MmopnVO();
		try {
			mmopnVO.setOpnid(items[0]);
			mmopnVO.setName(items[1]);
			mmopnVO.setEntid(items[2]);
			mmopnVO.setBusiid(items[3]);
			if (!"".equals(items[4].trim())) {
				mmopnVO.setAcctype(new Short(items[4].trim()));
			}
			if (!"".equals(items[5].trim())) {
				mmopnVO.setRewardstd(new Double(items[5].trim()));
			}
			if (!"".equals(items[6].trim())) {
				mmopnVO.setState(new Byte(items[6].trim()));
			}
			if (!"".equals(items[7].trim())) {
				mmopnVO.setOssrc(new Short(items[7].trim()));
			}
			mmopnVO.setShortopn(items[8]);
			mmopnVO.setWapurl(items[9]);
			mmopnVO.setMemo(items[10]);
			mmopnVO.setOpnmon(items[11]);
			delegate.doCreate(mmopnVO, user);
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
