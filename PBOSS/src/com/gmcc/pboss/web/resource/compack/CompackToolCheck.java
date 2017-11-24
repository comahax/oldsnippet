package com.gmcc.pboss.web.resource.compack;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.control.resource.com.Com;
import com.gmcc.pboss.control.resource.com.ComBO;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class CompackToolCheck extends BaseCheckFormat {

	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		// TODO Auto-generated method stub
		// ��Ʒ��Դ���|�ִ�����|
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length < 1) {
			throw new Exception("�ϴ������ݸ�ʽ����ȷ,��鿴����˵��!");
		}
		if (!PublicUtils.isInteger(content[0]) || content[0].length() != 11)
			throw new Exception("��Ʒ��Դ���Ҫ�󳤶�11λ������,��鿴����˵��!");
		
	}

	private boolean isEmpty(String checkStr) throws Exception {
		if (checkStr != null) {
			return StringUtils.isBlank(checkStr);
		} else {
			throw new Exception("����ַ���Ϊ��!");
		}
	}
}
