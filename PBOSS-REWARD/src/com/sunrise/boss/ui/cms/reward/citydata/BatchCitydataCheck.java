package com.sunrise.boss.ui.cms.reward.citydata;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class BatchCitydataCheck extends BaseCheckFormat {

	private User user;

	public BatchCitydataCheck() {
		super();
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		user = (User) parameterMap.get("user");
		String fileName = file.getFileName();
		if (!fileName.substring(fileName.length() - 4).equalsIgnoreCase(".txt")) {
			// if (!file.getContentType().equals("text/plain"))
			// {System.out.println("file.getContentType()="+file.getContentType());
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	/**
	 * ����ҵ�����|ҵ��������|ҵ����ʱ��|ҵ����BOSS����|ҵ��������|���뷢��ҵ����|Ʒ��|�������
	 */
	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
		if (rowCount > 10000) {
			throw new Exception("�ļ��������ܳ���10000��");
		}
		if (null == line || "".equals(line)) {
			return;
		}
		String[] fields = StringUtils.splitPreserveAllTokens(line, "|");
		// �������
		if (fields.length != 8) {
			throw new Exception("�ϴ�������������,ӦΪ8��,��鿴˵������!");
		}

		if (fields[0].trim().equals("") || fields[0].trim().length() > 18) {
			throw new Exception("[����ҵ�����]����Ϊ�ջ����18λ");
		}

		if (fields[7].trim().equals("") || !fields[7].matches("[0-8]{1}")) {
			throw new Exception("[�������]Ҫ��Ϊ0-8֮��һλ���֣��Ҳ���Ϊ��");
		}
		if ("5".equals(fields[7]) || "6".equals(fields[7])) {
			if (fields[3].length() > 15 || fields[3].trim().equals("")) {
				throw new Exception(
						"��������͡���BOSS��Ȩ�ࣨȫ��ͨ��ҵ���𣨻�����𡢽�����𣩣�����¼�롰ҵ����BOSS���š����ҳ��Ȳ�����15λ");
			}
		}
		if (fields[1].trim().equals("") || fields[1].trim().length() > 18) {
			throw new Exception("[ҵ��������]����Ϊ�ջ����18λ");
		}
		try {
			date.parse(fields[2]);
		} catch (ParseException pe) {
			throw new Exception("[ҵ����ʱ��]��ʽ����,ӦΪyyyyMMdd");
		}
		if (fields[4].trim().equals("") || fields[4].trim().length() > 11
				|| !StringUtils.isNumeric(fields[4])) {
			throw new Exception("[ҵ��������]����Ϊ�ջ����11λ�����ұ��������ִ�");
		}
//		if (fields[5].trim().equals("")
//				|| !fields[5].matches("[0-9]{1,14}(.?)[0-9]{0,2}")) {
//			throw new Exception("[���뷢��ҵ����]����Ϊ�ջ����14λ");
//		}
		if (fields[5].trim().length() == 0) {
			throw new Exception("[���뷢��ҵ����]����Ϊ��");
		}
		try{
			NumberFormat f = new DecimalFormat("0.00");
			String s = f.format(new Double(fields[5].trim()));
			if (s.length() > 15) {
				throw new Exception("[���뷢��ҵ����]��ʽ��鲻ͨ����Ҫ��Ϊ��������������λ���ܴ���12λ��");
			}
		} catch (Exception ex) {
			throw new Exception("[���뷢��ҵ����]��ʽ��鲻ͨ����Ҫ��Ϊ��������������λ���ܴ���12λ��");
		}
		if (fields[6].trim().equals("") || fields[6].trim().length() > 1
				|| !StringUtils.isNumeric(fields[6])) {
			throw new Exception("[Ʒ��]����Ϊ�ջ����1λ");
		}
	}
}
