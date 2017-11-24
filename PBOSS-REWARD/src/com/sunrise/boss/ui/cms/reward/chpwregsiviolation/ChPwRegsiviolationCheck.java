package com.sunrise.boss.ui.cms.reward.chpwregsiviolation;

import java.util.HashMap;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class ChPwRegsiviolationCheck extends BaseCheckFormat {

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("", "Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		if (null == line || "".equals(line)) {
			return;
		}
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 4) {
			throw new Exception("�ϴ�������������,ӦΪ3��");
		}
		if (StringUtils.isBlank(content[0])) {
			throw new Exception("[����]����Ϊ��");
		}
		if (!content[0].trim().matches("^\\d{11}$")) {
			throw new Exception("[����]������11λ����");
		}
		if (StringUtils.isBlank(content[1])) {
			throw new Exception("[Υ���·�]����Ϊ��");
		}
		if (!checkDate(content[1])) {
			throw new Exception("[Υ���·�]���ڸ�ʽ����ȷ,��ʽӦΪYYYYMM,��:201301");
		}
		if (StringUtils.isNotEmpty(content[2]) && content[2].trim().getBytes("GBK").length > 64) {
			throw new Exception("[��ע]�������Ϊ64,��������ռ2������");
		}
	}

	private boolean checkDate(String date) {
		if (date.trim().length() != 6) {
			return false;
		}
		try {
			int year = Integer.parseInt(date.substring(0, 4));
			int month = Integer.parseInt(date.substring(4));
			if (year < 1000 || year > 9999) {
				return false;
			} else if (month < 1 || month > 12) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
