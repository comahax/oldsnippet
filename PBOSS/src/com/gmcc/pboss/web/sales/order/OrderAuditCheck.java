package com.gmcc.pboss.web.sales.order;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.sunrise.jop.ui.User;

public class OrderAuditCheck extends BaseCheckFormat {

	@Override
	public void checkFile(File file, HashMap parameterMap, String contentType) throws Exception {
		// TODO Auto-generated method stub
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	@Override
	public void checkLine(String line, int rowCount, User user) throws Exception {
		// TODO Auto-generated method stub
		// �������Ҫ���ַ����ͣ���󳤶�18λ�����ͨ���������һ������ͨ������ʾ�����ļ��кʹ�����������ֹ�ļ��ϴ���
		if (StringUtils.isBlank(line) || line.length() <= 0) {
			throw new Exception("��" + rowCount + "��:[ " + line + " ] , �������Ϊ�գ�Ҫ���ַ����ͣ�������󳤶�18λ");
		}
		String item[] = StringUtils.split(line, "|");
		if (item.length > 1) {
			throw new Exception("��" + rowCount + "��:[ " + line + " ] , ��������,ӦΪ1��,��鿴˵������!");
		}
		if (line.endsWith("|")) {
			throw new Exception("��" + rowCount + "��:[ " + line + " ] , ������ | ����,��鿴˵������!");
		}
		if (line.length() > 18) {
			throw new Exception("��" + rowCount + "��:[ " + line + " ] , �������Ҫ���ַ����ͣ���󳤶�18λ");
		}
	}

}
