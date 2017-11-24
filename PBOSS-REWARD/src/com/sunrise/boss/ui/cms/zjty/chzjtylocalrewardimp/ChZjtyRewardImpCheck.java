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
				throw new BusinessException("", "Ҫ������ļ����Ͳ���ȷ��ֻ�ܵ���ָ�����ļ���ʽ��xls�ļ�!");
			}
		} else {
			if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
				throw new BusinessException("", "Ҫ������ļ����Ͳ���ȷ��ֻ�ܵ���ָ�����ļ���ʽ��txt�ı��ļ�!");
			}
		}
	}

	public void checkLine(String line, int rowCount, User user) throws Exception {
		if (null == line || "".equals(line)) {
			return;
		}
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (reward_zjtyreport.equals("REWARDTOTAL")) { // ������
			if (content.length != 10) {
				throw new Exception("[������]�ϴ�������������,ӦΪ10��,��鿴˵������!");
			}
			if (StringUtils.isNotEmpty(content[2]) && content[2].getBytes("GBK").length > 10) {
				throw new Exception("[�й�˾]�������Ϊ10");
			}
			if (StringUtils.isNotEmpty(content[4]) && content[4].getBytes("GBK").length > 18) {
				throw new Exception("[BOSS��������]�������Ϊ18");
			}
			if (StringUtils.isNotEmpty(content[5]) && !CheckUtil.checkDouble(content[5], 12, 2)) {
				throw new Exception("[�̶�����ܶ�]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[6]) && !CheckUtil.checkDouble(content[6], 12, 2)) {
				throw new Exception("[�Ƽ�����ܶ�]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[7]) && !CheckUtil.checkDouble(content[7], 12, 2)) {
				throw new Exception("[������ۼ�]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[8]) && !CheckUtil.checkDouble(content[8], 12, 2)) {
				throw new Exception("[ҵ��ۼ�]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[9]) && !CheckUtil.checkDouble(content[9], 12, 2)) {
				throw new Exception("[����ܼ�]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
		} else if (reward_zjtyreport.equals("GDREWARDTOTAL")) { // �̶�������
			if (content.length != 9) {
				throw new Exception("[�̶�������]�ϴ�������������,ӦΪ9��,��鿴˵������!");
			}
			if (StringUtils.isNotEmpty(content[2]) && content[2].getBytes("GBK").length > 10) {
				throw new Exception("[�й�˾]�������Ϊ10");
			}
			if (StringUtils.isNotEmpty(content[4]) && !checkDate(content[4], "yyyy-MM-dd")) {
				throw new Exception("[��������]���ڸ�ʽ����ȷ����ʽӦΪ2013-01-01");
			}
			if (StringUtils.isNotEmpty(content[5]) && !CheckUtil.checkNum(content[5], 14)) {
				throw new Exception("[������Ա�ܼ�]����Ϊ����,�ҳ��Ȳ��ܴ���14");
			}
			if (StringUtils.isNotEmpty(content[6]) && !CheckUtil.checkDouble(content[6], 12, 2)) {
				throw new Exception("[�̶������]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[7]) && !CheckUtil.checkDouble(content[7], 12, 2)) {
				throw new Exception("[��Ӫ������ÿ۳�]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[8]) && !CheckUtil.checkDouble(content[8], 12, 2)) {
				throw new Exception("[С��]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
		} else if (reward_zjtyreport.equals("PERCONFIGTOTAL")) { // ��Ա�����ܼ�
			if (content.length != 6) {
				throw new Exception("[��Ա�����ܼ�]�ϴ�������������,ӦΪ6��,��鿴˵������!");
			}
			if (StringUtils.isNotEmpty(content[2]) && content[2].getBytes("GBK").length > 10) {
				throw new Exception("[�й�˾]�������Ϊ10");
			}
			if (StringUtils.isNotEmpty(content[4]) && !checkDate(content[4], "yyyy-MM-dd")) {
				throw new Exception("[��������]���ڸ�ʽ����ȷ����ʽӦΪ2013-01-01");
			}
			if (StringUtils.isNotEmpty(content[5]) && !CheckUtil.checkNum(content[5], 14)) {
				throw new Exception("[������Ա�ܼ�]����Ϊ����,�ҳ��Ȳ��ܴ���14");
			}
		} else if (reward_zjtyreport.equals("PERCONFIGDETAIL")) { // ��Ա������ϸ
			if (content.length != 11) {
				throw new Exception("[��Ա������ϸ]�ϴ�������������,ӦΪ11��,��鿴˵������!");
			}
			if (StringUtils.isNotEmpty(content[1]) && content[1].getBytes("GBK").length > 10) {
				throw new Exception("[�й�˾]�������Ϊ10");
			}
			if (StringUtils.isNotEmpty(content[2]) && content[2].getBytes("GBK").length > 14) {
				throw new Exception("[�ֹ�˾]�������Ϊ14");
			}
			if (StringUtils.isNotEmpty(content[3]) && content[3].getBytes("GBK").length > 18) {
				throw new Exception("[��������]�������Ϊ18");
			}
			if (StringUtils.isNotEmpty(content[5]) && content[5].getBytes("GBK").length > 18) {
				throw new Exception("[����]�������Ϊ18");
			}
			if (StringUtils.isNotEmpty(content[6]) && content[6].getBytes("GBK").length > 18) {
				throw new Exception("[ְλ]�������Ϊ18");
			}
			if (StringUtils.isNotEmpty(content[7]) && content[7].getBytes("GBK").length > 18) {
				throw new Exception("[BOSS����]�������Ϊ18");
			}
			if (StringUtils.isNotEmpty(content[8]) && !checkDate(content[8], "yyyy-MM-dd")) {
				throw new Exception("[���ſ�ͨʱ��]���ڸ�ʽ����ȷ����ʽӦΪ2013-01-01");
			}
			if (StringUtils.isNotEmpty(content[10]) && !CheckUtil.checkNum(content[10], 14)) {
				throw new Exception("[��ϵ�绰]����Ϊ����,�ҳ��Ȳ��ܴ���14");
			}
		} else if (reward_zjtyreport.equals("JJREWARDTOTAL")) { // �Ƽ����������
			if (content.length != 19) {
				throw new Exception("[�Ƽ����������]�ϴ�������������,ӦΪ19��,��鿴˵������!");
			}
			if (StringUtils.isNotEmpty(content[2]) && content[2].getBytes("GBK").length > 10) {
				throw new Exception("[�й�˾]�������Ϊ10");
			}
			if (StringUtils.isNotEmpty(content[4]) && !CheckUtil.checkDouble(content[4], 12, 2)) {
				throw new Exception("[ȫ��ͨ�����źų��]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[5]) && !CheckUtil.checkDouble(content[5], 12, 2)) {
				throw new Exception("[Ԥ����תȫ��ͨ���]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[6]) && !CheckUtil.checkDouble(content[6], 12, 2)) {
				throw new Exception("[���еش��׿����۳��]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[7]) && !CheckUtil.checkDouble(content[7], 12, 2)) {
				throw new Exception("[�������׿����۳��]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[8]) && !CheckUtil.checkDouble(content[8], 12, 2)) {
				throw new Exception("[��ֵҵ����]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[9]) && !CheckUtil.checkDouble(content[9], 12, 2)) {
				throw new Exception("[�����ն˳��]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[10]) && !CheckUtil.checkDouble(content[10], 12, 2)) {
				throw new Exception("[�ۺ�ҵ����]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[11]) && !CheckUtil.checkDouble(content[11], 12, 2)) {
				throw new Exception("[����ҵ����]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[12]) && !CheckUtil.checkDouble(content[12], 12, 2)) {
				throw new Exception("[���еش����Ŀ�����Ϣ���׿����������߳��]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[13]) && !CheckUtil.checkDouble(content[13], 12, 2)) {
				throw new Exception("[��ͥ����������]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[14]) && !CheckUtil.checkDouble(content[14], 12, 2)) {
				throw new Exception("[����ҵ����]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[15]) && !CheckUtil.checkDouble(content[15], 12, 2)) {
				throw new Exception("[����ҵ����]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[16]) && !CheckUtil.checkDouble(content[16], 12, 2)) {
				throw new Exception("[���й�˾Ӫ���ص���ҵ����]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[17]) && !CheckUtil.checkDouble(content[17], 12, 2)) {
				throw new Exception("[ȫ��ͨ�źų��ۼ�]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[18]) && !CheckUtil.checkDouble(content[18], 12, 2)) {
				throw new Exception("[�ϼ�]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
		} else if (reward_zjtyreport.equals("REWARDBUSINESS")) { // �Ƽ�������ҵ��������
			if (content.length != 18) {
				throw new Exception("[�Ƽ�������ҵ��������]�ϴ�������������,ӦΪ18��,��鿴˵������!");
			}
			if (StringUtils.isNotEmpty(content[2]) && content[2].getBytes("GBK").length > 10) {
				throw new Exception("[�й�˾]�������Ϊ10");
			}
			if (StringUtils.isNotEmpty(content[4]) && !CheckUtil.checkDouble(content[4], 12, 2)) {
				throw new Exception("[ȫ��ͨ�����źų��]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[5]) && !CheckUtil.checkDouble(content[5], 12, 2)) {
				throw new Exception("[Ԥ����תȫ��ͨ]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[6]) && !CheckUtil.checkDouble(content[6], 12, 2)) {
				throw new Exception("[���еش��׿����۳��]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[7]) && !CheckUtil.checkDouble(content[7], 12, 2)) {
				throw new Exception("[�������׿����۳��]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[8]) && !CheckUtil.checkDouble(content[8], 12, 2)) {
				throw new Exception("[��ֵҵ����]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[9]) && !CheckUtil.checkDouble(content[9], 12, 2)) {
				throw new Exception("[�����ն˳��]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[10]) && !CheckUtil.checkDouble(content[10], 12, 2)) {
				throw new Exception("[�ۺ�ҵ����]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[11]) && !CheckUtil.checkDouble(content[11], 12, 2)) {
				throw new Exception("[����ҵ����]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[12]) && !CheckUtil.checkDouble(content[12], 12, 2)) {
				throw new Exception("[���еش����Ŀ�����Ϣ���׿����������߳��]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[13]) && !CheckUtil.checkDouble(content[13], 12, 2)) {
				throw new Exception("[��ͥ����������]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[14]) && !CheckUtil.checkDouble(content[14], 12, 2)) {
				throw new Exception("[����ҵ����]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[15]) && !CheckUtil.checkDouble(content[15], 12, 2)) {
				throw new Exception("[����ҵ����]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[16]) && !CheckUtil.checkDouble(content[16], 12, 2)) {
				throw new Exception("[���й�˾Ӫ���ص���ҵ����]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[17]) && !CheckUtil.checkDouble(content[17], 12, 2)) {
				throw new Exception("[�ϼ�]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
		} else if (reward_zjtyreport.equals("ZDSALEREWARD")) { // �ն����������
			if (content.length != 19) {
				throw new Exception("[�ն����������]�ϴ�������������,ӦΪ19��,��鿴˵������!");
			}
			if (StringUtils.isNotEmpty(content[1]) && content[1].getBytes("GBK").length > 10) {
				throw new Exception("[����]�������Ϊ10");
			}
			if (StringUtils.isNotEmpty(content[3]) && !CheckUtil.checkNum(content[3], 14)) {
				throw new Exception("[�����ն�������Լ��]����Ϊ����,�ҳ��Ȳ��ܴ���14");
			}
			if (StringUtils.isNotEmpty(content[4]) && !CheckUtil.checkNum(content[4], 14)) {
				throw new Exception("[�����ն��������Լ]����Ϊ����,�ҳ��Ȳ��ܴ���14");
			}
			if (StringUtils.isNotEmpty(content[5]) && !CheckUtil.checkNum(content[5], 14)) {
				throw new Exception("[�����ն��������]����Ϊ����,�ҳ��Ȳ��ܴ���14");
			}
			if (StringUtils.isNotEmpty(content[6]) && !CheckUtil.checkNum(content[6], 14)) {
				throw new Exception("[�����ն������ϼ�]����Ϊ����,�ҳ��Ȳ��ܴ���14");
			}
			if (StringUtils.isNotEmpty(content[7]) && !CheckUtil.checkNum(content[7], 14)) {
				throw new Exception("[����������ն�������Լ��]����Ϊ����,�ҳ��Ȳ��ܴ���14");
			}
			if (StringUtils.isNotEmpty(content[8]) && !CheckUtil.checkNum(content[8], 14)) {
				throw new Exception("[����������ն��������Լ]����Ϊ����,�ҳ��Ȳ��ܴ���14");
			}
			if (StringUtils.isNotEmpty(content[9]) && !CheckUtil.checkNum(content[9], 14)) {
				throw new Exception("[����������ն��������]����Ϊ����,�ҳ��Ȳ��ܴ���14");
			}
			if (StringUtils.isNotEmpty(content[10]) && !CheckUtil.checkNum(content[10], 14)) {
				throw new Exception("[����������ն������ϼ�]����Ϊ����,�ҳ��Ȳ��ܴ���14");
			}
			if (StringUtils.isNotEmpty(content[11]) && !CheckUtil.checkDouble(content[11], 12, 2)) {
				throw new Exception("[�����ն˳���Լ��]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[12]) && !CheckUtil.checkDouble(content[12], 12, 2)) {
				throw new Exception("[�����ն˳�����Լ]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[13]) && !CheckUtil.checkDouble(content[13], 12, 2)) {
				throw new Exception("[�����ն˳�����]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[14]) && !CheckUtil.checkDouble(content[14], 12, 2)) {
				throw new Exception("[�����ն˳��ϼ�]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[15]) && !CheckUtil.checkDouble(content[15], 12, 2)) {
				throw new Exception("[����������ն˳���Լ��]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[16]) && !CheckUtil.checkDouble(content[16], 12, 2)) {
				throw new Exception("[����������ն˳�����Լ]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[17]) && !CheckUtil.checkDouble(content[17], 12, 2)) {
				throw new Exception("[����������ն˳�����]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
			if (StringUtils.isNotEmpty(content[18]) && !CheckUtil.checkDouble(content[18], 12, 2)) {
				throw new Exception("[����������ն˳��ϼ�]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
			}
		}
	}
	
	public void checkLine(Cell[] cell, int count) throws Exception {
		if (reward_zjtyreport.equals("GOTONEDETAIL") && count >= 4) { // ȫ��ͨ���������ϸ
			if (cell.length == 0 || cell.length > 174) {
				throw new Exception("[ȫ��ͨ���������ϸ]�ϴ�������������,ӦΪ174��!");
			}
		} else if (reward_zjtyreport.equals("NOGOTONEDETAIL") && count >= 5) { // ��ȫ��ͨ���������ϸ
			if (cell.length == 0 || cell.length > 134) {
				throw new Exception("[��ȫ��ͨ���������ϸ]�ϴ�������������,ӦΪ134��!");
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
