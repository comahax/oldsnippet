package com.gmcc.pboss.web.channel.busicircle;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.sunrise.jop.ui.User;

public class BusicircleCheck extends BaseCheckFormat {
	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}

	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {

		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 6) {
			throw new Exception("�ϴ�������������,ӦΪ5��,��鿴˵������!");
		}
		if (content[0] == null || "".equals(content[0])) {
			throw new Exception("��Ȧ���벻��Ϊ��");
		}
		if (content[2] == null || "".equals(content[2])) {
			throw new Exception("��Ȧ������Ϊ��");
		} else if (!("A").equals(content[2]) && !("B").equals(content[2])&& !("C").equals(content[2])) {
			throw new Exception("��Ȧ����������ʵ");
		}  
		if (content[3] == null || "".equals(content[3])) {
			throw new Exception("�ֹ�˾����Ϊ��");
		}
		
	}

}
