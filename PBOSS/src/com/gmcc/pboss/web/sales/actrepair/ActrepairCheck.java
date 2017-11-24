package com.gmcc.pboss.web.sales.actrepair;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.common.utils.tools.CheckUtil;
import com.sunrise.jop.ui.User;

public class ActrepairCheck extends BaseCheckFormat {

	public ActrepairCheck() {
		// TODO Auto-generated constructor stub
	}

	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		// TODO Auto-generated method stub
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 4) {
			throw new Exception("�ϴ�������������,ӦΪ3��,��鿴˵������!");
		}
		if (!CheckUtil.checkNum(content[0], 11, false)) {
			throw new Exception("[����]����Ϊ��,����Ϊ����,�ҳ��Ȳ��ܴ���11λ");
		}
		if (!CheckUtil.checkDate(content[1], "yyyy-MM-dd", false)) {
			throw new Exception("[��������]����Ϊ��,�Ҹ�ʽӦ��Ϊ[yyyy-MM-dd]");
		}
		if (!CheckUtil.checkString(content[2], 255, false)) {
			throw new Exception("[��¼ԭ��]����Ϊ��,�ҳ��Ȳ��ܴ���255λ");
		}

	}

}
