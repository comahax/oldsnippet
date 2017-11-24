package com.gmcc.pboss.web.sales.order;

import java.io.File;
import java.util.HashMap;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.sunrise.jop.ui.User;

public class OrderCheck extends BaseCheckFormat {

	@Override
	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	@Override
	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		if (line != null && line.trim().equals("")) {
			throw new Exception("������Ų���Ϊ��");
		} else if (line.length() > 18) {
			throw new Exception("���������󳤶�Ϊ18λ���ַ�");
		}
	}

}
