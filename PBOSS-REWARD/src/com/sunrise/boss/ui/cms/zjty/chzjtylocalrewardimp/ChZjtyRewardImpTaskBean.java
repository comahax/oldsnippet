package com.sunrise.boss.ui.cms.zjty.chzjtylocalrewardimp;

import java.text.SimpleDateFormat;
import org.apache.commons.lang.StringUtils;
import com.sunrise.boss.business.cms.zjty.chzjtygotonedetail.persistent.ChZjtyGotonedetailVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalgdrewardtotal.persistent.ChZjtyLocalgdrewardtotalVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocaljjrewardtotal.persistent.ChZjtyLocaljjrewardtotalVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalperconfigdetail.persistent.ChZjtyLocalperconfigdetailVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalperconfigtotal.persistent.ChZjtyLocalperconfigtotalVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalrewardbusiness.persistent.ChZjtyLocalrewardbusinessVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalrewardtotal.persistent.ChZjtyLocalrewardtotalVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalzdsalereward.persistent.ChZjtyLocalzdsalerewardVO;
import com.sunrise.boss.business.cms.zjty.chzjtynogotonedetail.persistent.ChZjtyNogotonedetailVO;
import com.sunrise.boss.delegate.cms.zjty.chzjtygotonedetail.ChZjtyGotonedetailDelegate;
import com.sunrise.boss.delegate.cms.zjty.chzjtylocalgdrewardtotal.ChZjtyLocalgdrewardtotalDelegate;
import com.sunrise.boss.delegate.cms.zjty.chzjtylocaljjrewardtotal.ChZjtyLocaljjrewardtotalDelegate;
import com.sunrise.boss.delegate.cms.zjty.chzjtylocalperconfigdetail.ChZjtyLocalperconfigdetailDelegate;
import com.sunrise.boss.delegate.cms.zjty.chzjtylocalperconfigtotal.ChZjtyLocalperconfigtotalDelegate;
import com.sunrise.boss.delegate.cms.zjty.chzjtylocalrewardbusiness.ChZjtyLocalrewardbusinessDelegate;
import com.sunrise.boss.delegate.cms.zjty.chzjtylocalrewardtotal.ChZjtyLocalrewardtotalDelegate;
import com.sunrise.boss.delegate.cms.zjty.chzjtylocalzdsalereward.ChZjtyLocalzdsalerewardDelegate;
import com.sunrise.boss.delegate.cms.zjty.chzjtynogotonedetail.ChZjtyNogotonedetailDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class ChZjtyRewardImpTaskBean extends BaseBatchTaskBean {
	String[] gotonedetailtype = {"cooperauid", "city", "wayname", "ywl58khcj", 
		"ywl58jlcj1", "ywl58jlcj2", "ywl58jlcj3", "ywl58jlcj4", "ywl58jlcj5", 
		"ywl58jlcj6", "ywl58jlcj7", "ywl58jlcj8", "ywl58jlcj9", "ywl58jlcj10", 
		"ywl58jlcj11", "ywl58jlcj12", "ywl88khcj", "ywl88jlcj1", "ywl88jlcj2", 
		"ywl88jlcj3", "ywl88jlcj4", "ywl88jlcj5", "ywl88jlcj6", "ywl88jlcj7", 
		"ywl88jlcj8", "ywl88jlcj9", "ywl88jlcj10", "ywl88jlcj11", "ywl88jlcj12", 
		"ywl128khcj", "ywl128jlcj1", "ywl128jlcj2", "ywl128jlcj3", "ywl128jlcj4", 
		"ywl128jlcj5", "ywl128jlcj6", "ywl128jlcj7", "ywl128jlcj8", "ywl128jlcj9", 
		"ywl128jlcj10", "ywl128jlcj11", "ywl128jlcj12", "ywl158khcj", "ywl158jlcj1", 
		"ywl158jlcj2", "ywl158jlcj3", "ywl158jlcj4", "ywl158jlcj5", "ywl158jlcj6", 
		"ywl158jlcj7", "ywl158jlcj8", "ywl158jlcj9", "ywl158jlcj10", "ywl158jlcj11", 
		"ywl158jlcj12", "ywl188khcj", "ywl188jlcj1", "ywl188jlcj2", "ywl188jlcj3", 
		"ywl188jlcj4", "ywl188jlcj5", "ywl188jlcj6", "ywl188jlcj7", "ywl188jlcj8", 
		"ywl188jlcj9", "ywl188jlcj10", "ywl188jlcj11", "ywl188jlcj12", "ywl288khcj", 
		"ywl288jlcj1", "ywl288jlcj2", "ywl288jlcj3", "ywl288jlcj4", "ywl288jlcj5", 
		"ywl288jlcj6", "ywl288jlcj7", "ywl288jlcj8", "ywl288jlcj9", "ywl288jlcj10", 
		"ywl288jlcj11", "ywl288jlcj12", "ywlmzonetogotone", "dwkhcj", "dw58cj", 
		"dw88cj", "dw128cj", "dw158cj", "dw188cj", "dw288cj", "dwmzonetogotone", 
		"cjtotal58khcj", "cjtotal58jlcj1", "cjtotal58jlcj2", "cjtotal58jlcj3", 
		"cjtotal58jlcj4", "cjtotal58jlcj5", "cjtotal58jlcj6", "cjtotal58jlcj7", 
		"cjtotal58jlcj8", "cjtotal58jlcj9", "cjtotal58jlcj10", "cjtotal58jlcj11", 
		"cjtotal58jlcj12", "cjtotal88khcj", "cjtotal88jlcj1", "cjtotal88jlcj2", 
		"cjtotal88jlcj3", "cjtotal88jlcj4", "cjtotal88jlcj5", "cjtotal88jlcj6", 
		"cjtotal88jlcj7", "cjtotal88jlcj8", "cjtotal88jlcj9", "cjtotal88jlcj10", 
		"cjtotal88jlcj11", "cjtotal88jlcj12", "cjtotal128khcj", "cjtotal128jlcj1", 
		"cjtotal128jlcj2", "cjtotal128jlcj3", "cjtotal128jlcj4", "cjtotal128jlcj5", 
		"cjtotal128jlcj6", "cjtotal128jlcj7", "cjtotal128jlcj8", "cjtotal128jlcj9", 
		"cjtotal128jlcj10", "cjtotal128jlcj11", "cjtotal128jlcj12", "cjtotal158khcj", 
		"cjtotal158jlcj1", "cjtotal158jlcj2", "cjtotal158jlcj3", "cjtotal158jlcj4", 
		"cjtotal158jlcj5", "cjtotal158jlcj6", "cjtotal158jlcj7", "cjtotal158jlcj8", 
		"cjtotal158jlcj9", "cjtotal158jlcj10", "cjtotal158jlcj11", "cjtotal158jlcj12", 
		"cjtotal188khcj", "cjtotal188jlcj1", "cjtotal188jlcj2", "cjtotal188jlcj3", 
		"cjtotal188jlcj4", "cjtotal188jlcj5", "cjtotal188jlcj6", "cjtotal188jlcj7", 
		"cjtotal188jlcj8", "cjtotal188jlcj9", "cjtotal188jlcj10", "cjtotal188jlcj11", 
		"cjtotal188jlcj12", "cjtotal288khcj", "cjtotal288jlcj1", "cjtotal288jlcj2", 
		"cjtotal288jlcj3", "cjtotal288jlcj4", "cjtotal288jlcj5", "cjtotal288jlcj6", 
		"cjtotal288jlcj7", "cjtotal288jlcj8", "cjtotal288jlcj9", "cjtotal288jlcj10", 
		"cjtotal288jlcj11", "cjtotal288jlcj12", "cjtotalmzonetogotone", "manageexamine", 
		"vetocoefficient", "ordercoefficient", "campaigncoefficient", "totalreward", 
		"rewardreporttime"};
	String[] nogotonedetailtype = {"cooperauid", "city", "wayname", "ywlmzone100", 
		"ywlmzone55", "ywlmzone25", "ywlsz100", "ywlsz55", "ywlcardtotal", "ywlmzonewl", 
		"ywlt52g", "ywlt53g", "ywlt102g", "ywlt103g", "ywlt152g", "ywlt153g", "ywlt202g", 
		"ywlt203g", "ywlt252g", "ywlt253g", "ywlt302g", "ywlt303g", "ywlt352g", "ywlt353g", 
		"ywlt402g", "ywlt403g", "ywlt502g", "ywlt503g", "ywlmifi", "ywlchangecard", 
		"ywlopenmobile", "ywlservicechange", "ywlpkchanlow", "ywlpkchanhigh", "ywlcash", 
		"ywlmoneyamount", "ywlpkchan", "ywlzuservicechange", "ywlcashamount", 
		"ywlfamilybroadband", "ywlhlzx51", "ywlhlzx53", "ywlhlzx101", "ywlhlzx103", 
		"ywlinfocomress", "dwmzone100", "dwmzone55", "dwmzone25", "dwsz100", "dwsz55", 
		"dwcardtotal", "dwmzonewl", "dwt52g", "dwt53g", "dwt102g", "dwt103g", "dwt152g", 
		"dwt153g", "dwt202g", "dwt203g", "dwt252g", "dwt253g", "dwt302g", "dwt303g", 
		"dwt352g", "dwt353g", "dwt402g", "dwt403g", "dwt502g", "dwt503g", "dwmifi", 
		"dwchangecard", "dwopenmobile", "dwservicechange", "dwpkchanlow", "dwpkchanhigh", 
		"dwcash", "dwmoneyamount", "dwpkchan", "dwzuservicechange", "dwcashamount", 
		"dwfamilybroadband", "dwhlzx51", "dwhlzx53", "dwhlzx101", "dwhlzx103", 
		"dwinfocomress", "cjtotalmzone100", "cjtotalmzone55", "cjtotalmzone25", 
		"cjtotalsz100", "cjtotalsz55", "cjtotalcardtotal", "cjtotalmzonewl", "cjtotalt52g", 
		"cjtotalt53g", "cjtotalt102g", "cjtotalt103g", "cjtotalt152g", "cjtotalt153g", 
		"cjtotalt202g", "cjtotalt203g", "cjtotalt252g", "cjtotalt253g", "cjtotalt302g", 
		"cjtotalt303g", "cjtotalt352g", "cjtotalt353g", "cjtotalt402g", "cjtotalt403g", 
		"cjtotalt502g", "cjtotalt503g", "cjtotalmifi", "cjtotalchangecard", 
		"cjtotalopenmobile", "cjtotalservicechange", "cjtotalpkchanlow", "cjtotalpkchanhigh", 
		"cjtotalcash", "cjtotalmoneyamount", "cjtotalpkchan", "cjtotalzuservicechange", 
		"cjtotalcashamount", "cjtotalfamilybroadband", "cjtotalhlzx51", "cjtotalhlzx53", 
		"cjtotalhlzx101", "cjtotalhlzx103", "cjtotalinfocomress", "manageexamine", 
		"vetocoefficient", "ordercoefficient", "campaigncoefficient", "totalreward", 
		"rewardreporttime"};

	public ChZjtyRewardImpTaskBean() {
		super.setBatchName("自建他营酬金报表导入");
		super.setWriteLog(true);
	}

	protected String doStart() {
		String reward_zjtyreport = parameterMap.get("rewardzjtyreport").toString();
		if (reward_zjtyreport.equals("REWARDTOTAL")) {
			return "行号|合作商|公司类别|市公司|自建他营厅名称|BOSS渠道编码|固定酬金总额|计件酬金总额|超额酬金扣减|业务扣减|酬金总计|处理结果 \r\n";
		} else if (reward_zjtyreport.equals("GDREWARDTOTAL")) {
			return "行号|合作商|公司类别|市公司|自建他营厅名称|交接日期|配置人员总计|固定酬金额度|运营管理费用扣除|小计|处理结果 \r\n";
		} else if (reward_zjtyreport.equals("PERCONFIGTOTAL")) {
			return "行号|合作商|公司类别|市公司|自建他营厅|交接日期|配置人员总计|处理结果 \r\n";
		} else if (reward_zjtyreport.equals("PERCONFIGDETAIL")) {
			return "行号|所属合作商|市公司|分公司|渠道编码|渠道名称|姓名|职位|BOSS工号|工号开通时间|认证情况|联系电话|处理结果 \r\n";
		} else if (reward_zjtyreport.equals("JJREWARDTOTAL")) {
			return "行号|合作商|公司类别|市公司|自建他营厅名称|全球通新增放号酬金|预付费转全球通酬金|动感地带套卡销售酬金|" +
				"神州行套卡销售酬金|充值业务酬金|定制终端酬金|综合业务酬金|自助业务酬金|动感地带网聊卡、信息机套卡、欢乐在线酬金|" +
				"家庭宽带开户酬金|数据业务酬金|集团业务酬金|地市公司营销重点类业务酬金|全球通放号酬金扣减|合计|处理结果 \r\n";
		} else if (reward_zjtyreport.equals("REWARDBUSINESS")) {
			return "行号|合作商|公司类别|市公司|自建他营厅名称|全球通新增放号酬金|预付费转全球通|动感地带套卡销售酬金|" +
				"神州行套卡销售酬金|充值业务酬金|定制终端酬金|综合业务酬金|自助业务酬金|动感地带网聊卡、信息机套卡、欢乐在线酬金|" +
				"家庭宽带开户酬金|数据业务酬金|集团业务酬金|地市公司营销重点类业务酬金|合计|处理结果 \r\n";
		} else if (reward_zjtyreport.equals("ZDSALEREWARD")) {
			return "行号|合作商|地市|营业厅名称|定制终端销量合约机|定制终端销量零合约|定制终端销量裸机|定制终端销量合计||" +
				"引商入柜定制终端销量合约机|引商入柜定制终端销量零合约|引商入柜定制终端销量裸机|引商入柜定制终端销量合计||" +
				"定制终端酬金合约机|定制终端酬金零合约|定制终端酬金裸机|定制终端酬金合计|引商入柜定制终端酬金合约机||" +
				"引商入柜定制终端酬金零合约|引商入柜定制终端酬金裸机|引商入柜定制终端酬金合计|处理结果 \r\n";
		} else if (reward_zjtyreport.equals("GOTONEDETAIL")) {
			this.countrecord = this.countrecord - 3;
			this.ok = this.ok - 3;
			this.currentrecord = this.currentrecord - 3;
			return "";
		} else if (reward_zjtyreport.equals("NOGOTONEDETAIL")) {
			this.countrecord = this.countrecord - 5;
			this.ok = this.ok - 5;
			this.currentrecord = this.currentrecord - 5;
			return "";
		}
		return "自建他营酬金报表导入结果 \r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try {
			String reward_zjtyreport = parameterMap.get("rewardzjtyreport").toString();
			String rewardreporttime = parameterMap.get("rewardreporttime").toString();
			String[] content = StringUtils.splitPreserveAllTokens(line, "|");
			if (reward_zjtyreport.equals("REWARDTOTAL")) {
				ChZjtyLocalrewardtotalVO vo = new ChZjtyLocalrewardtotalVO();
				ChZjtyLocalrewardtotalDelegate delegate = new ChZjtyLocalrewardtotalDelegate();
				vo.setWayname(StringUtils.isEmpty(content[0]) ? "" : content[0]);
				vo.setCompanytype(StringUtils.isEmpty(content[1]) ? "" : content[1]);
				vo.setCityid(StringUtils.isEmpty(content[2]) ? "" : content[2]);
				vo.setZjtyname(StringUtils.isEmpty(content[3]) ? "" : content[3]);
				vo.setWayid( StringUtils.isEmpty(content[4])? "" : content[4]);
				vo.setGdreward(StringUtils.isEmpty(content[5]) ? 0 : Double.valueOf(content[5]));
				vo.setJjreward(StringUtils.isEmpty(content[6]) ? 0 : Double.valueOf(content[6]));
				vo.setCereward(StringUtils.isEmpty(content[7]) ? 0 : Double.valueOf(content[7]));
				vo.setYwkj(StringUtils.isEmpty(content[8]) ? 0 : Double.valueOf(content[8]));
				vo.setTotal(StringUtils.isEmpty(content[9]) ? 0 : Double.valueOf(content[9]));
				vo.setRewardreporttime(rewardreporttime);
				delegate.doCreate(vo, user);
			} else if (reward_zjtyreport.equals("GDREWARDTOTAL")) {
				ChZjtyLocalgdrewardtotalVO vo = new ChZjtyLocalgdrewardtotalVO();
				ChZjtyLocalgdrewardtotalDelegate delegate = new ChZjtyLocalgdrewardtotalDelegate();
				vo.setWayname(StringUtils.isEmpty(content[0]) ? "" : content[0]);
				vo.setCompanytype(StringUtils.isEmpty(content[1]) ? "" : content[1]);
				vo.setCityid(StringUtils.isEmpty(content[2]) ? "" : content[2]);
				vo.setZjtyname(StringUtils.isEmpty(content[3]) ? "" : content[3]);
				vo.setConnecttime(StringUtils.isEmpty(content[4]) ? null : new SimpleDateFormat("yyyy-MM-dd").parse(content[4]));
				vo.setPetotal(StringUtils.isEmpty(content[5]) ? 0 : Long.valueOf(content[5]));
				vo.setGdreward(StringUtils.isEmpty(content[6]) ? 0 : Double.valueOf(content[6]));
				vo.setMgmenoykc(StringUtils.isEmpty(content[7]) ? 0 : Double.valueOf(content[7]));
				vo.setTotal(StringUtils.isEmpty(content[8]) ? 0 : Double.valueOf(content[8]));
				vo.setRewardreporttime(rewardreporttime);
				delegate.doCreate(vo, user);
			} else if (reward_zjtyreport.equals("PERCONFIGTOTAL")) {
				ChZjtyLocalperconfigtotalVO vo = new ChZjtyLocalperconfigtotalVO();
				ChZjtyLocalperconfigtotalDelegate delegate = new ChZjtyLocalperconfigtotalDelegate();
				vo.setWayname(StringUtils.isEmpty(content[0]) ? "" : content[0]);
				vo.setCompanytype(StringUtils.isEmpty(content[1]) ? "" : content[1]);
				vo.setCityid(StringUtils.isEmpty(content[2]) ? "" : content[2]);
				vo.setZjtyname(StringUtils.isEmpty(content[3]) ? "" : content[3]);
				vo.setConnecttime(StringUtils.isEmpty(content[4]) ? null : new SimpleDateFormat("yyyy-MM-dd").parse(content[4]));
				vo.setTotal(StringUtils.isEmpty(content[5]) ? 0 : Long.valueOf(content[5]));
				vo.setRewardreporttime(rewardreporttime);
				delegate.doCreate(vo, user);
			} else if (reward_zjtyreport.equals("PERCONFIGDETAIL")) {
				ChZjtyLocalperconfigdetailVO vo = new ChZjtyLocalperconfigdetailVO();
				ChZjtyLocalperconfigdetailDelegate delegate = new ChZjtyLocalperconfigdetailDelegate();
				vo.setUpperwayname(StringUtils.isEmpty(content[0]) ? "" : content[0]);
				vo.setCityid(StringUtils.isEmpty(content[1]) ? "" : content[1]);
				vo.setCountyid(StringUtils.isEmpty(content[2]) ? "" : content[2]);
				vo.setWayid(StringUtils.isEmpty(content[3]) ? "" : content[3]);
				vo.setWayname(StringUtils.isEmpty(content[4]) ? "" : content[4]);
				vo.setZjtypersonname(StringUtils.isEmpty(content[5]) ? "" : content[5]);
				vo.setStation(StringUtils.isEmpty(content[6]) ? "" : content[6]);
				vo.setOprcode(StringUtils.isEmpty(content[7]) ? "" : content[7]);
				vo.setRegdate(StringUtils.isEmpty(content[8]) ? null : new SimpleDateFormat("yyyy-MM-dd").parse(content[8]));
				vo.setCertification(StringUtils.isEmpty(content[9]) ? "" : content[9]);
				vo.setTel(StringUtils.isEmpty(content[10]) ? null : Long.parseLong(content[10]));
				vo.setRewardreporttime(rewardreporttime);
				delegate.doCreate(vo, user);
			} else if (reward_zjtyreport.equals("JJREWARDTOTAL")) {
				ChZjtyLocaljjrewardtotalVO vo = new ChZjtyLocaljjrewardtotalVO();
				ChZjtyLocaljjrewardtotalDelegate delegate = new ChZjtyLocaljjrewardtotalDelegate();
				vo.setWayname(StringUtils.isEmpty(content[0]) ? "" : content[0]);
				vo.setCompanytype(StringUtils.isEmpty(content[1]) ? "" : content[1]);
				vo.setCityid(StringUtils.isEmpty(content[2]) ? "" : content[2]);
				vo.setZjtywayname(StringUtils.isEmpty(content[3]) ? "" : content[3]);
				vo.setQqtxzfhcj(StringUtils.isEmpty(content[4]) ? 0 : Double.valueOf(content[4]));
				vo.setYffzqqtcj(StringUtils.isEmpty(content[5]) ? 0 : Double.valueOf(content[5]));
				vo.setDgddtkxscj(StringUtils.isEmpty(content[6]) ? 0 : Double.valueOf(content[6]));
				vo.setSzxtkxscj(StringUtils.isEmpty(content[7]) ? 0 : Double.valueOf(content[7]));
				vo.setCzywcj(StringUtils.isEmpty(content[8]) ? 0 : Double.valueOf(content[8]));
				vo.setDzzdcj(StringUtils.isEmpty(content[9]) ? 0 : Double.valueOf(content[9]));
				vo.setZhywcj(StringUtils.isEmpty(content[10]) ? 0 : Double.valueOf(content[10]));
				vo.setZzywcj(StringUtils.isEmpty(content[11]) ? 0 : Double.valueOf(content[11]));
				vo.setDgddwlk(StringUtils.isEmpty(content[12]) ? 0 : Double.valueOf(content[12]));
				vo.setJtkdkhcj(StringUtils.isEmpty(content[13]) ? 0 : Double.valueOf(content[13]));
				vo.setSjywcj(StringUtils.isEmpty(content[14]) ? 0 : Double.valueOf(content[14]));
				vo.setJtywcj(StringUtils.isEmpty(content[15]) ? 0 : Double.valueOf(content[15]));
				vo.setDsgsyxzd(StringUtils.isEmpty(content[16]) ? 0 : Double.valueOf(content[16]));
				vo.setQqtffcjkj(StringUtils.isEmpty(content[17]) ? 0 : Double.valueOf(content[17]));
				vo.setTotal(StringUtils.isEmpty(content[18]) ? 0 : Double.valueOf(content[18]));
				vo.setRewardreporttime(rewardreporttime);
				delegate.doCreate(vo, user);
			} else if (reward_zjtyreport.equals("REWARDBUSINESS")) {
				ChZjtyLocalrewardbusinessVO vo = new ChZjtyLocalrewardbusinessVO();
				ChZjtyLocalrewardbusinessDelegate delegate = new ChZjtyLocalrewardbusinessDelegate();
				vo.setWayname(StringUtils.isEmpty(content[0]) ? "" : content[0]);
				vo.setCompanytype(StringUtils.isEmpty(content[1]) ? "" : content[1]);
				vo.setCityid(StringUtils.isEmpty(content[2]) ? "" : content[2]);
				vo.setZjtyname(StringUtils.isEmpty(content[3]) ? "" : content[3]);
				vo.setQqtxzfh(StringUtils.isEmpty(content[4]) ? 0 : Double.valueOf(content[4]));
				vo.setYffzqqt(StringUtils.isEmpty(content[5]) ? 0 : Double.valueOf(content[5]));
				vo.setDgddtkxs(StringUtils.isEmpty(content[6]) ? 0 : Double.valueOf(content[6]));
				vo.setSzxtkxs(StringUtils.isEmpty(content[7]) ? 0 : Double.valueOf(content[7]));
				vo.setCzyw(StringUtils.isEmpty(content[8]) ? 0 : Double.valueOf(content[8]));
				vo.setDzzd(StringUtils.isEmpty(content[9]) ? 0 : Double.valueOf(content[9]));
				vo.setZhyw(StringUtils.isEmpty(content[10]) ? 0 : Double.valueOf(content[10]));
				vo.setZzyw(StringUtils.isEmpty(content[11]) ? 0 : Double.valueOf(content[11]));
				vo.setDgddwlk(StringUtils.isEmpty(content[12]) ? 0 : Double.valueOf(content[12]));
				vo.setJtkdkh(StringUtils.isEmpty(content[13]) ? 0 : Double.valueOf(content[13]));
				vo.setSjyw(StringUtils.isEmpty(content[14]) ? 0 : Double.valueOf(content[14]));
				vo.setJtyw(StringUtils.isEmpty(content[15]) ? 0 : Double.valueOf(content[15]));
				vo.setDsgsyxzdlyw(StringUtils.isEmpty(content[16]) ? 0 : Double.valueOf(content[16]));
				vo.setTotal(StringUtils.isEmpty(content[17]) ? 0 : Double.valueOf(content[17]));
				vo.setRewardreporttime(rewardreporttime);
				delegate.doCreate(vo, user);
			} else if (reward_zjtyreport.equals("ZDSALEREWARD")) {
				ChZjtyLocalzdsalerewardVO vo = new ChZjtyLocalzdsalerewardVO();
				ChZjtyLocalzdsalerewardDelegate delegate = new ChZjtyLocalzdsalerewardDelegate();
				vo.setWayname(StringUtils.isEmpty(content[0]) ? "" : content[0]);
				vo.setCityid(StringUtils.isEmpty(content[1]) ? "" : content[1]);
				vo.setZjtyname(StringUtils.isEmpty(content[2]) ? "" : content[2]);
				vo.setDzzdxlhyj(StringUtils.isEmpty(content[3]) ? 0 : Long.parseLong(content[3]));
				vo.setDzzdxllhy(StringUtils.isEmpty(content[4]) ? 0 : Long.parseLong(content[4]));
				vo.setDzzdxllj(StringUtils.isEmpty(content[5]) ? 0 : Long.parseLong(content[5]));
				vo.setDzzdxlhj(StringUtils.isEmpty(content[6]) ? 0 : Long.parseLong(content[6]));
				vo.setYsrgdzzdxlhyj(StringUtils.isEmpty(content[7]) ? 0 : Long.parseLong(content[7]));
				vo.setYsrgdzzdxllhy(StringUtils.isEmpty(content[8]) ? 0 : Long.parseLong(content[8]));
				vo.setYsrgdzzdxllj(StringUtils.isEmpty(content[9]) ? 0 : Long.parseLong(content[9]));
				vo.setYsrgdzzdxlhj(StringUtils.isEmpty(content[10]) ? 0 : Long.parseLong(content[10]));
				vo.setDzzdcjhyj(StringUtils.isEmpty(content[11]) ? 0 : Double.valueOf(content[11]));
				vo.setDzzdcjlhy(StringUtils.isEmpty(content[12]) ? 0 : Double.valueOf(content[12]));
				vo.setDzzdcjlj(StringUtils.isEmpty(content[13]) ? 0 : Double.valueOf(content[13]));
				vo.setDzzdcjhj(StringUtils.isEmpty(content[14]) ? 0 : Double.valueOf(content[14]));
				vo.setYsrgdzzdcjhyj(StringUtils.isEmpty(content[15]) ? 0 : Double.valueOf(content[15]));
				vo.setYsrgdzzdcjlhy(StringUtils.isEmpty(content[16]) ? 0 : Double.valueOf(content[16]));
				vo.setYsrgdzzdcjlj(StringUtils.isEmpty(content[17]) ? 0 : Double.valueOf(content[17]));
				vo.setYsrgdzzdcjhj(StringUtils.isEmpty(content[18]) ? 0 : Double.valueOf(content[18]));
				vo.setRewardreporttime(rewardreporttime);
				delegate.doCreate(vo, user);
			} else if (reward_zjtyreport.equals("GOTONEDETAIL") && rowCount >= 4) {
				if (!"".equals(line.replace("|", "").trim())) { // 如果是空行，则不入库
					ChZjtyGotonedetailDelegate delegate = new ChZjtyGotonedetailDelegate();
					long mark = delegate.doFindMaxMark(user) + 1;
					for (int i = 0; i < content.length-1; i++) {
						if (!StringUtils.isEmpty(content[i])) { // 如果列值为空，不插入数据库
							ChZjtyGotonedetailVO vo = new ChZjtyGotonedetailVO();
							vo.setMark(mark);
							vo.setDatacontent(StringUtils.isEmpty(content[i]) ? "" : content[i]);
							vo.setType(gotonedetailtype[i]);
							delegate.doCreate(vo, user);
						}
					}
					ChZjtyGotonedetailVO gotonedetailVO = new ChZjtyGotonedetailVO();
					gotonedetailVO.setMark(mark);
					gotonedetailVO.setDatacontent(rewardreporttime);
					gotonedetailVO.setType(gotonedetailtype[174]);
					delegate.doCreate(gotonedetailVO, user);
				}
			} else if (reward_zjtyreport.equals("NOGOTONEDETAIL") && rowCount >= 6) {
				if (!"".equals(line.replace("|", "").trim())) { // 如果是空行，则不入库
					ChZjtyNogotonedetailDelegate delegate = new ChZjtyNogotonedetailDelegate();
					long mark = delegate.doFindMaxMark(user) + 1;
					for (int i = 0; i < content.length-1; i++) {
						if (!StringUtils.isEmpty(content[i])) { // 如果列值为空，不插入数据库
							ChZjtyNogotonedetailVO vo = new ChZjtyNogotonedetailVO();
							vo.setMark(mark);
							vo.setDatacontent(StringUtils.isEmpty(content[i]) ? "" : content[i]);
							vo.setType(nogotonedetailtype[i]);
							delegate.doCreate(vo, user);
						}
					}
					ChZjtyNogotonedetailVO nogotonedetailVO = new ChZjtyNogotonedetailVO();
					nogotonedetailVO.setMark(mark);
					nogotonedetailVO.setDatacontent(rewardreporttime);
					nogotonedetailVO.setType(nogotonedetailtype[134]);
					delegate.doCreate(nogotonedetailVO, user);
				}
			}
			line = rowCount + "|" + line + "|操作成功";
			resultVO.setOk(true);
			resultVO.setInfo(line);
			return resultVO;
		} catch (Exception e) {
			line = rowCount + "|" + line + "|错误信息:" + e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}

}
