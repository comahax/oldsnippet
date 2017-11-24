package com.sunrise.boss.ui.cms.mendregister;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class BatchMendregisterCheck extends BaseCheckFormat {
	public BatchMendregisterCheck() {
		super();
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		if (rowCount > 10000) {
			throw new Exception("�ļ��������ܳ���10000��");
		}
		if (null == line || "".equals(line)) {
			return;
		}
		// String[] items = line.split("\\|");
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		// �������
		if (items.length != 3) {
			throw new Exception("�ϴ�������������,ӦΪ3��,��鿴˵������!");
		}
		if(StringUtils.isBlank(items[0])){
			throw new Exception("�׿�����Ϊ������!");
		}
		if(StringUtils.isBlank(items[1])){
			throw new Exception("�׿�����ʱ��Ϊ������!");
		}
		if(StringUtils.isBlank(items[2])){
			throw new Exception("���������Ϊ������!");
		}
	}
}
