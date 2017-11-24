package com.sunrise.boss.ui.cms.zjty.zjtyrewarddetail;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.sunrise.boss.business.cms.zjty.zjtyrewarddetail.persistent.ZjtyRewarddetailVO;

import com.sunrise.boss.delegate.cms.zjty.zjtyrewarddetail.ZjtyRewarddetailDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.pub.tools.StringSplit;

public class ZjtyRewarddetailTaskBean extends BaseBatchTaskBean {

	private ZjtyRewarddetailDelegate delegate;

	public ZjtyRewarddetailTaskBean() throws Exception {
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
			
			if(content[0].trim().equals("")){
				createvo.setOperseq(new Long("-1"));
			}else{
				createvo.setOperseq(new Long(content[0]));
			}
			
			createvo.setOpnid(content[1]);
			createvo.setWayid(content[2]);
			
			if(content[3].trim().equals("")){
				createvo.setWayopercode("-1");
			}else{
				createvo.setWayopercode(content[3]);
			}
			if(content[4].trim().equals("")){
				createvo.setRewardid(new Long("-1"));
			}else{
				createvo.setRewardid(new Long(content[4]));
			}
			
			createvo.setRewardtype(new Short(content[5]));
			
			if(content[6].trim().equals("")){
				createvo.setRewardstd(new Double("-1"));
			}else{
				createvo.setRewardstd(new Double(content[6]));
			}
			
			createvo.setAcctype(new Short(content[7]));
			
			if(content[8].trim().equals("")){
				createvo.setCoef1(new Double("-1"));
			}else{
				createvo.setCoef1(new Double(content[8]));
			}
			
			if(content[9].trim().equals("")){
				createvo.setCoef2(new Double("-1"));
			}else{
				createvo.setCoef2(new Double(content[9]));
			}
			
			if(content[10].trim().equals("")){
				createvo.setCoef3(new Double("-1"));
			}else{
				createvo.setCoef3(new Double(content[10]));
			}
			
			if(content[11].trim().equals("")){
				createvo.setCoef4(new Double("-1"));
			}else{
				createvo.setCoef4(new Double(content[11]));
			}
			
			createvo.setRewardmont(content[12]);
			
			if(content[13].trim().equals("")){
				createvo.setTotalsum(new Double("-1"));
			}else{
				createvo.setTotalsum(new Double(content[13]));
			}
			createvo.setPaysum(new Double(content[14]));
			Calendar cld = Calendar.getInstance();
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
			String day = df.format(cld.getTime());
			createvo.setBatchnum(day);
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
