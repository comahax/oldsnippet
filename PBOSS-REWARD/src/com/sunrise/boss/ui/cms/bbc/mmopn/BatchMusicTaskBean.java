package com.sunrise.boss.ui.cms.bbc.mmopn;

import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.bbc.mmopn.persistent.MmopnVO;
import com.sunrise.boss.delegate.cms.bbc.mmopn.MmopnDelegate;
import com.sunrise.boss.delegate.cms.layout.LayoutDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class BatchMusicTaskBean extends BaseBatchTaskBean {
	private MmopnDelegate delegate;

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");

	public BatchMusicTaskBean() throws Exception {
		super.setBatchName("无线音乐管理导入结果");
		super.setWriteLog(true);
		delegate = new MmopnDelegate();
		// TODO Auto-generated constructor stub
	}

	protected String doStart() {
		return "无线音乐管理导入结果 \r\n";
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
				mmopnVO.setRewardstd(new Double(items[4].trim()));
			}
			if (!"".equals(items[5].trim())) {
				mmopnVO.setState(new Byte(items[5].trim()));
			}
			mmopnVO.setShortopn(items[6]);
			mmopnVO.setWapurl(items[7]);
			mmopnVO.setMemo(items[8]);
			delegate.doCreatemusic(mmopnVO, user);
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
