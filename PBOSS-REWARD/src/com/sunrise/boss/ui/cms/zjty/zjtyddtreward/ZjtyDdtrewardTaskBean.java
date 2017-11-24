package com.sunrise.boss.ui.cms.zjty.zjtyddtreward;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.sunrise.boss.business.cms.zjty.zjtyddtreward.persistent.ZjtyDdtrewardVO;

import com.sunrise.boss.delegate.cms.zjty.zjtyddtreward.ZjtyDdtrewardDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.pub.tools.StringSplit;

public class ZjtyDdtrewardTaskBean extends BaseBatchTaskBean {

	private ZjtyDdtrewardDelegate delegate;

	public ZjtyDdtrewardTaskBean() throws Exception {
		// TODO Auto-generated constructor stub
		delegate = new ZjtyDdtrewardDelegate();
		super.setBatchName("自建他营酬金扣减批量导入日志查询");
		super.setWriteLog(true);
	}

	protected String doStart() {
		return "自建他营酬金扣减批量导入结果 \r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String[] content = StringSplit.split(line, "|");

		try {

			ZjtyDdtrewardVO createvo = new ZjtyDdtrewardVO();
			createvo.setDdttype(new Short(content[0]));
			createvo.setWayid(content[1]);
			createvo.setRewardmont(content[2]);
			createvo.setAmount(new Double(content[3]));
			createvo.setRemark(content[4]);
			
			delegate.doCreate(createvo, user);
			line = rowCount + "   " + line + "   创建成功";
			resultVO.setInfo(line);
			resultVO.setOk(true);
			resultVO.setInfo(line);
			resultVO.setOk(true);

		} catch (Exception e) {
			line = rowCount + "   " + line + "    错误信息:" + e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
}
