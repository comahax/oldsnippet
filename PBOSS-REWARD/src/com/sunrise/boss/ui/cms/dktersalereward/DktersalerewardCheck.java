package com.sunrise.boss.ui.cms.dktersalereward;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;
import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class DktersalerewardCheck extends BaseCheckFormat {

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
		if (content.length != 8) {
			throw new Exception("�ϴ�������������,ӦΪ7��");
		}
		if (StringUtils.isEmpty(content[0])) {
			throw new Exception("[�·�]����Ϊ��");
		}
		if (!checkDate(content[0])) {
			throw new Exception("[�·�]���ڸ�ʽ����ȷ,��ʽӦΪyyyyMM,��:201301");
		}
		if (StringUtils.isNotEmpty(content[1]) && content[1].getBytes("GBK").length > 100) {
			throw new Exception("[ECP����]�������Ϊ100");
		}
		if (StringUtils.isNotEmpty(content[2]) && content[2].getBytes("GBK").length > 256) {
			throw new Exception("[��������]�������Ϊ256");
		}
		if (StringUtils.isNotEmpty(content[3]) && !CheckUtil.checkNum(content[3], 14)) {
			throw new Exception("[���۳ɹ���(T-1����)]����Ϊ����,�ҳ��Ȳ��ܴ���14");
		}
		if (StringUtils.isNotEmpty(content[4]) && !CheckUtil.checkNum(content[4], 14)) {
			throw new Exception("[���˳ɹ���(T-4����)]����Ϊ����,�ҳ��Ȳ��ܴ���14");
		}
		if (StringUtils.isNotEmpty(content[5]) && !CheckUtil.checkDouble(content[5], 12, 2)) {
			throw new Exception("[�������]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
		}
		if (StringUtils.isNotEmpty(content[6]) && !CheckUtil.checkDouble(content[6], 12, 2)) {
			throw new Exception("[���˳��]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���2λ");
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
