package com.gmcc.pboss.web.sales.disform;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.ui.User;

public class DisformCheck extends BaseCheckFormat {

	public DisformCheck() {
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
		String[] content = StringUtils.split(line, "|");
		if (content.length >= 2) {
			throw new Exception("�ϴ�������������,ӦΪ1��,��鿴˵������!");
		}
		
		if(!PublicUtils.isInteger(content[0])||content[0].length()>14){
			throw new Exception("���͵����Ҫ�󳤶Ȳ�����14λ������,��鿴����˵��!");
		}
	}

	private boolean isEmpty(String checkStr) throws Exception {
		if (checkStr != null) {
			return StringUtils.isBlank(checkStr);
		} else {
			throw new Exception("����ַ���Ϊ��!");
		}
	}
}
