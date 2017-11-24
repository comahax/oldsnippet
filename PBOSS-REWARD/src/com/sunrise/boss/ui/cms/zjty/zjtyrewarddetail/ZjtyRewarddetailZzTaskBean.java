package com.sunrise.boss.ui.cms.zjty.zjtyrewarddetail;

import com.sunrise.boss.business.cms.zjty.zjtyrewarddetail.persistent.ZjtyRewarddetailVO;
import com.sunrise.boss.delegate.cms.zjty.zjtyrewarddetail.ZjtyRewarddetailDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.pub.tools.StringSplit;

public class ZjtyRewarddetailZzTaskBean extends BaseBatchTaskBean {

	private ZjtyRewarddetailDelegate delegate;

	public ZjtyRewarddetailZzTaskBean() throws Exception {
		// TODO Auto-generated constructor stub
		delegate = new ZjtyRewarddetailDelegate();
		super.setBatchName("自建他营酬金明细批量导入日志查询");
		super.setWriteLog(true);
	}

	protected String doStart() {
		return "自建他营酬金明细批量导入结果 \r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String[] content = StringSplit.split(line, "|");

		try {

			ZjtyRewarddetailVO createvo = new ZjtyRewarddetailVO();
			
			createvo.setOpnid(content[0]);
			createvo.setWayid(content[1]);
			createvo.setAcctype(new Short(content[2]));
			createvo.setRewardmont(content[3]);
			createvo.setPaysum(new Double(content[4]));
			createvo.setWayopercode("-1");
			createvo.setOperseq(new Long("-1"));
			createvo.setRewardid(new Long("-1"));
			createvo.setRewardstd(new Double("-1"));
			createvo.setCoef1(new Double("-1"));
			createvo.setCoef2(new Double("-1"));
			createvo.setCoef3(new Double("-1"));
			createvo.setCoef4(new Double("-1"));
			createvo.setTotalsum(new Double("-1"));
			createvo.setRewardtype(new Short("89"));
			createvo.setBatchnum("-1");
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
