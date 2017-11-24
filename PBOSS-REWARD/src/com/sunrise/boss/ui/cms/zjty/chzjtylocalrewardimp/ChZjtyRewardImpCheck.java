package com.sunrise.boss.ui.cms.zjty.chzjtylocalrewardimp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import jxl.Cell;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;
import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class ChZjtyRewardImpCheck extends BaseCheckFormat {
	private String reward_zjtyreport;

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		reward_zjtyreport = parameterMap.get("rewardzjtyreport").toString();
		if ("GOTONEDETAIL".equals(reward_zjtyreport) 
				|| "NOGOTONEDETAIL".equals(reward_zjtyreport)) {
			if (!"application/vnd.ms-excel".equalsIgnoreCase(file.getContentType())) {
				throw new BusinessException("", "要导入的文件类型不正确，只能导入指定的文件格式：xls文件!");
			}
		} else {
			if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
				throw new BusinessException("", "要导入的文件类型不正确，只能导入指定的文件格式：txt文本文件!");
			}
		}
	}

	public void checkLine(String line, int rowCount, User user) throws Exception {
		if (null == line || "".equals(line)) {
			return;
		}
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (reward_zjtyreport.equals("REWARDTOTAL")) { // 酬金汇总
			if (content.length != 10) {
				throw new Exception("[酬金汇总]上传数据列数不对,应为10列,请查看说明帮助!");
			}
			if (StringUtils.isNotEmpty(content[2]) && content[2].getBytes("GBK").length > 10) {
				throw new Exception("[市公司]长度最大为10");
			}
			if (StringUtils.isNotEmpty(content[4]) && content[4].getBytes("GBK").length > 18) {
				throw new Exception("[BOSS渠道编码]长度最大为18");
			}
			if (StringUtils.isNotEmpty(content[5]) && !CheckUtil.checkDouble(content[5], 12, 2)) {
				throw new Exception("[固定酬金总额]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[6]) && !CheckUtil.checkDouble(content[6], 12, 2)) {
				throw new Exception("[计件酬金总额]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[7]) && !CheckUtil.checkDouble(content[7], 12, 2)) {
				throw new Exception("[超额酬金扣减]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[8]) && !CheckUtil.checkDouble(content[8], 12, 2)) {
				throw new Exception("[业务扣减]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[9]) && !CheckUtil.checkDouble(content[9], 12, 2)) {
				throw new Exception("[酬金总计]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
		} else if (reward_zjtyreport.equals("GDREWARDTOTAL")) { // 固定酬金汇总
			if (content.length != 9) {
				throw new Exception("[固定酬金汇总]上传数据列数不对,应为9列,请查看说明帮助!");
			}
			if (StringUtils.isNotEmpty(content[2]) && content[2].getBytes("GBK").length > 10) {
				throw new Exception("[市公司]长度最大为10");
			}
			if (StringUtils.isNotEmpty(content[4]) && !checkDate(content[4], "yyyy-MM-dd")) {
				throw new Exception("[交接日期]日期格式不正确，格式应为2013-01-01");
			}
			if (StringUtils.isNotEmpty(content[5]) && !CheckUtil.checkNum(content[5], 14)) {
				throw new Exception("[配置人员总计]必需为整数,且长度不能大于14");
			}
			if (StringUtils.isNotEmpty(content[6]) && !CheckUtil.checkDouble(content[6], 12, 2)) {
				throw new Exception("[固定酬金额度]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[7]) && !CheckUtil.checkDouble(content[7], 12, 2)) {
				throw new Exception("[运营管理费用扣除]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[8]) && !CheckUtil.checkDouble(content[8], 12, 2)) {
				throw new Exception("[小计]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
		} else if (reward_zjtyreport.equals("PERCONFIGTOTAL")) { // 人员配置总计
			if (content.length != 6) {
				throw new Exception("[人员配置总计]上传数据列数不对,应为6列,请查看说明帮助!");
			}
			if (StringUtils.isNotEmpty(content[2]) && content[2].getBytes("GBK").length > 10) {
				throw new Exception("[市公司]长度最大为10");
			}
			if (StringUtils.isNotEmpty(content[4]) && !checkDate(content[4], "yyyy-MM-dd")) {
				throw new Exception("[交接日期]日期格式不正确，格式应为2013-01-01");
			}
			if (StringUtils.isNotEmpty(content[5]) && !CheckUtil.checkNum(content[5], 14)) {
				throw new Exception("[配置人员总计]必需为整数,且长度不能大于14");
			}
		} else if (reward_zjtyreport.equals("PERCONFIGDETAIL")) { // 人员配置明细
			if (content.length != 11) {
				throw new Exception("[人员配置明细]上传数据列数不对,应为11列,请查看说明帮助!");
			}
			if (StringUtils.isNotEmpty(content[1]) && content[1].getBytes("GBK").length > 10) {
				throw new Exception("[市公司]长度最大为10");
			}
			if (StringUtils.isNotEmpty(content[2]) && content[2].getBytes("GBK").length > 14) {
				throw new Exception("[分公司]长度最大为14");
			}
			if (StringUtils.isNotEmpty(content[3]) && content[3].getBytes("GBK").length > 18) {
				throw new Exception("[渠道编码]长度最大为18");
			}
			if (StringUtils.isNotEmpty(content[5]) && content[5].getBytes("GBK").length > 18) {
				throw new Exception("[姓名]长度最大为18");
			}
			if (StringUtils.isNotEmpty(content[6]) && content[6].getBytes("GBK").length > 18) {
				throw new Exception("[职位]长度最大为18");
			}
			if (StringUtils.isNotEmpty(content[7]) && content[7].getBytes("GBK").length > 18) {
				throw new Exception("[BOSS工号]长度最大为18");
			}
			if (StringUtils.isNotEmpty(content[8]) && !checkDate(content[8], "yyyy-MM-dd")) {
				throw new Exception("[工号开通时间]日期格式不正确，格式应为2013-01-01");
			}
			if (StringUtils.isNotEmpty(content[10]) && !CheckUtil.checkNum(content[10], 14)) {
				throw new Exception("[联系电话]必需为整数,且长度不能大于14");
			}
		} else if (reward_zjtyreport.equals("JJREWARDTOTAL")) { // 计件酬金分项汇总
			if (content.length != 19) {
				throw new Exception("[计件酬金分项汇总]上传数据列数不对,应为19列,请查看说明帮助!");
			}
			if (StringUtils.isNotEmpty(content[2]) && content[2].getBytes("GBK").length > 10) {
				throw new Exception("[市公司]长度最大为10");
			}
			if (StringUtils.isNotEmpty(content[4]) && !CheckUtil.checkDouble(content[4], 12, 2)) {
				throw new Exception("[全球通新增放号酬金]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[5]) && !CheckUtil.checkDouble(content[5], 12, 2)) {
				throw new Exception("[预付费转全球通酬金]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[6]) && !CheckUtil.checkDouble(content[6], 12, 2)) {
				throw new Exception("[动感地带套卡销售酬金]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[7]) && !CheckUtil.checkDouble(content[7], 12, 2)) {
				throw new Exception("[神州行套卡销售酬金]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[8]) && !CheckUtil.checkDouble(content[8], 12, 2)) {
				throw new Exception("[充值业务酬金]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[9]) && !CheckUtil.checkDouble(content[9], 12, 2)) {
				throw new Exception("[定制终端酬金]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[10]) && !CheckUtil.checkDouble(content[10], 12, 2)) {
				throw new Exception("[综合业务酬金]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[11]) && !CheckUtil.checkDouble(content[11], 12, 2)) {
				throw new Exception("[自助业务酬金]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[12]) && !CheckUtil.checkDouble(content[12], 12, 2)) {
				throw new Exception("[动感地带网聊卡、信息机套卡、欢乐在线酬金]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[13]) && !CheckUtil.checkDouble(content[13], 12, 2)) {
				throw new Exception("[家庭宽带开户酬金]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[14]) && !CheckUtil.checkDouble(content[14], 12, 2)) {
				throw new Exception("[数据业务酬金]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[15]) && !CheckUtil.checkDouble(content[15], 12, 2)) {
				throw new Exception("[集团业务酬金]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[16]) && !CheckUtil.checkDouble(content[16], 12, 2)) {
				throw new Exception("[地市公司营销重点类业务酬金]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[17]) && !CheckUtil.checkDouble(content[17], 12, 2)) {
				throw new Exception("[全球通放号酬金扣减]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[18]) && !CheckUtil.checkDouble(content[18], 12, 2)) {
				throw new Exception("[合计]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
		} else if (reward_zjtyreport.equals("REWARDBUSINESS")) { // 计件酬金分项业务量数据
			if (content.length != 18) {
				throw new Exception("[计件酬金分项业务量数据]上传数据列数不对,应为18列,请查看说明帮助!");
			}
			if (StringUtils.isNotEmpty(content[2]) && content[2].getBytes("GBK").length > 10) {
				throw new Exception("[市公司]长度最大为10");
			}
			if (StringUtils.isNotEmpty(content[4]) && !CheckUtil.checkDouble(content[4], 12, 2)) {
				throw new Exception("[全球通新增放号酬金]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[5]) && !CheckUtil.checkDouble(content[5], 12, 2)) {
				throw new Exception("[预付费转全球通]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[6]) && !CheckUtil.checkDouble(content[6], 12, 2)) {
				throw new Exception("[动感地带套卡销售酬金]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[7]) && !CheckUtil.checkDouble(content[7], 12, 2)) {
				throw new Exception("[神州行套卡销售酬金]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[8]) && !CheckUtil.checkDouble(content[8], 12, 2)) {
				throw new Exception("[充值业务酬金]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[9]) && !CheckUtil.checkDouble(content[9], 12, 2)) {
				throw new Exception("[定制终端酬金]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[10]) && !CheckUtil.checkDouble(content[10], 12, 2)) {
				throw new Exception("[综合业务酬金]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[11]) && !CheckUtil.checkDouble(content[11], 12, 2)) {
				throw new Exception("[自助业务酬金]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[12]) && !CheckUtil.checkDouble(content[12], 12, 2)) {
				throw new Exception("[动感地带网聊卡、信息机套卡、欢乐在线酬金]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[13]) && !CheckUtil.checkDouble(content[13], 12, 2)) {
				throw new Exception("[家庭宽带开户酬金]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[14]) && !CheckUtil.checkDouble(content[14], 12, 2)) {
				throw new Exception("[数据业务酬金]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[15]) && !CheckUtil.checkDouble(content[15], 12, 2)) {
				throw new Exception("[集团业务酬金]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[16]) && !CheckUtil.checkDouble(content[16], 12, 2)) {
				throw new Exception("[地市公司营销重点类业务酬金]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[17]) && !CheckUtil.checkDouble(content[17], 12, 2)) {
				throw new Exception("[合计]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
		} else if (reward_zjtyreport.equals("ZDSALEREWARD")) { // 终端销量及酬金
			if (content.length != 19) {
				throw new Exception("[终端销量及酬金]上传数据列数不对,应为19列,请查看说明帮助!");
			}
			if (StringUtils.isNotEmpty(content[1]) && content[1].getBytes("GBK").length > 10) {
				throw new Exception("[地市]长度最大为10");
			}
			if (StringUtils.isNotEmpty(content[3]) && !CheckUtil.checkNum(content[3], 14)) {
				throw new Exception("[定制终端销量合约机]必需为整数,且长度不能大于14");
			}
			if (StringUtils.isNotEmpty(content[4]) && !CheckUtil.checkNum(content[4], 14)) {
				throw new Exception("[定制终端销量零合约]必需为整数,且长度不能大于14");
			}
			if (StringUtils.isNotEmpty(content[5]) && !CheckUtil.checkNum(content[5], 14)) {
				throw new Exception("[定制终端销量裸机]必需为整数,且长度不能大于14");
			}
			if (StringUtils.isNotEmpty(content[6]) && !CheckUtil.checkNum(content[6], 14)) {
				throw new Exception("[定制终端销量合计]必需为整数,且长度不能大于14");
			}
			if (StringUtils.isNotEmpty(content[7]) && !CheckUtil.checkNum(content[7], 14)) {
				throw new Exception("[引商入柜定制终端销量合约机]必需为整数,且长度不能大于14");
			}
			if (StringUtils.isNotEmpty(content[8]) && !CheckUtil.checkNum(content[8], 14)) {
				throw new Exception("[引商入柜定制终端销量零合约]必需为整数,且长度不能大于14");
			}
			if (StringUtils.isNotEmpty(content[9]) && !CheckUtil.checkNum(content[9], 14)) {
				throw new Exception("[引商入柜定制终端销量裸机]必需为整数,且长度不能大于14");
			}
			if (StringUtils.isNotEmpty(content[10]) && !CheckUtil.checkNum(content[10], 14)) {
				throw new Exception("[引商入柜定制终端销量合计]必需为整数,且长度不能大于14");
			}
			if (StringUtils.isNotEmpty(content[11]) && !CheckUtil.checkDouble(content[11], 12, 2)) {
				throw new Exception("[定制终端酬金合约机]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[12]) && !CheckUtil.checkDouble(content[12], 12, 2)) {
				throw new Exception("[定制终端酬金零合约]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[13]) && !CheckUtil.checkDouble(content[13], 12, 2)) {
				throw new Exception("[定制终端酬金裸机]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[14]) && !CheckUtil.checkDouble(content[14], 12, 2)) {
				throw new Exception("[定制终端酬金合计]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[15]) && !CheckUtil.checkDouble(content[15], 12, 2)) {
				throw new Exception("[引商入柜定制终端酬金合约机]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[16]) && !CheckUtil.checkDouble(content[16], 12, 2)) {
				throw new Exception("[引商入柜定制终端酬金零合约]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[17]) && !CheckUtil.checkDouble(content[17], 12, 2)) {
				throw new Exception("[引商入柜定制终端酬金裸机]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
			if (StringUtils.isNotEmpty(content[18]) && !CheckUtil.checkDouble(content[18], 12, 2)) {
				throw new Exception("[引商入柜定制终端酬金合计]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
			}
		}
	}
	
	public void checkLine(Cell[] cell, int count) throws Exception {
		if (reward_zjtyreport.equals("GOTONEDETAIL") && count >= 4) { // 全球通基础酬金明细
			if (cell.length == 0 || cell.length > 174) {
				throw new Exception("[全球通基础酬金明细]上传数据列数不对,应为174列!");
			}
		} else if (reward_zjtyreport.equals("NOGOTONEDETAIL") && count >= 5) { // 非全球通基础酬金明细
			if (cell.length == 0 || cell.length > 134) {
				throw new Exception("[非全球通基础酬金明细]上传数据列数不对,应为134列!");
			}
		}
	}

	private boolean checkDate(String date, String pattern) {
		DateFormat dateFormat = new SimpleDateFormat(pattern);
		try {
			dateFormat.parse(date);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

}
