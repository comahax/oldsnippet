package com.sunrise.boss.ui.cms.reward.disintegral;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.pub.tools.StringSplit;


public class DisintegralBatchCheck extends BaseCheckFormat {

	public DisintegralBatchCheck() {
		super();
	}
	
	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!file.getContentType().equals("text/plain")||(file.getFileName().substring(file.getFileName().length()-3, file.getFileName().length())).equals("sql")) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	/**
	 * �ļ��е����ݼ��
	 */
	public void checkLine(String line, int rowCount, User user) throws Exception {

		if (rowCount > 10000) {
			throw new Exception("�ļ��������ܳ���10000��");
		}
		if (null == line || "".equals(line.trim())) {
			return;
		}

		String[] items = StringSplit.split(line,"|");

		// �������
		if (items.length != 4) {
			throw new Exception("�ϴ�������������,ӦΪ4��,��鿴˵������!");
		}
		
		if (StringUtils.isEmpty(items[0])) {
			throw new BusinessException("", "��1�С������̱��롿����Ϊ��!");
		}
		
		if (items[0].length()>18){
			throw new BusinessException("", "��1�С������̱��롿���Ȳ��ܳ���18λ!");
		}
		if (StringUtils.isEmpty(items[1])) {
			throw new BusinessException("", "��2�С������·ݡ�����Ϊ��!");
		}
		if (!NumberUtils.isNumber(items[1])) {
			throw new BusinessException("", "��2�С������·ݡ�����Ϊ����");
		}
		if (!checkDate(items[1])) {
			throw new BusinessException("", "��2�С������·ݡ�����ΪYYYYMM��ʽ�ҳ���Ϊ6λ");
		}
		if (StringUtils.isEmpty(items[2])) {
			throw new BusinessException("", "��3�С��������͡�����Ϊ��!");
		}
		if (!items[2].matches("[0,1]{1}")) {
			throw new Exception("��3�С��������͡�ֻ��Ϊ0��1,��鿴����˵��");
		}
		if (StringUtils.isEmpty(items[3])) {
			throw new BusinessException("", "��4�С����֡�����Ϊ��!");
		}
		if (!NumberUtils.isNumber(items[3])) {
			throw new BusinessException("", "��4�С����֡�����Ϊ����");
		}
	}

	public static boolean checkDate(String date) {
		boolean ret = true;
		if (date.length() != 6)
			return false;
		try {
			SimpleDateFormat sd = new SimpleDateFormat("yyyyMM");
			sd.parse(date);
		} catch (Exception e) {
			return false;
		}
		return ret;
	}

	public static void main(String[] args) {

		DisintegralBatchCheck check = new DisintegralBatchCheck();

	}
}
