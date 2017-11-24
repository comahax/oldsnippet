package com.sunrise.boss.ui.cms.zjty.zjtyrewarddetail;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.sunrise.boss.business.cms.zjty.zjtyrewarddetail.persistent.ZjtyRewarddetailVO;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;

import com.sunrise.boss.delegate.cms.zjty.zjtyrewarddetail.ZjtyRewarddetailDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.pub.tools.StringSplit;

public class ZjtyRewarddetailCityTaskBean extends BaseBatchTaskBean {

	private ZjtyRewarddetailDelegate delegate;

	public ZjtyRewarddetailCityTaskBean() throws Exception {
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
			
			createvo.setRewardtype(new Short(content[0]));
			createvo.setWayid(content[1]);
			createvo.setRewardmont(content[2]);
			createvo.setPaysum(new Double(content[3]));
			createvo.setWayopercode("-1");
			createvo.setOperseq(new Long("-1"));
			createvo.setOpnid("-1");
			createvo.setRewardid(new Long("-1"));
			createvo.setRewardstd(new Double("-1"));
			createvo.setAcctype(new Short("-1"));
			createvo.setCoef1(new Double("-1"));
			createvo.setCoef2(new Double("-1"));
			createvo.setCoef3(new Double("-1"));
			createvo.setCoef4(new Double("-1"));
			
			createvo.setTotalsum(new Double("-1"));
			
			Calendar cld = Calendar.getInstance();
			SimpleDateFormat df = new SimpleDateFormat("yyMMddhhmmss");
			String day = df.format(cld.getTime());
			createvo.setBatchnum(SessionFactoryRouter.conversionCityid(user
					.getCityid())
					+ day);
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
