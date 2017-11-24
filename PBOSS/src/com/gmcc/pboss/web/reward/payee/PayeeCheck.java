package com.gmcc.pboss.web.reward.payee;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.sunrise.jop.ui.User;

public class PayeeCheck extends BaseCheckFormat {
	private User user;
	@Override
	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		user = (User) parameterMap.get("user");
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	@Override
	public void checkLine(String line, int rowCount, User user) throws Exception {
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 3) {
			throw new Exception("�ϴ���������ȷ��ӦΪ2��!");
		}
		if(StringUtils.isBlank(content[0]) || content[0].getBytes("GBK").length > 128) {
			throw new Exception("���λ���Ʋ���Ϊ���ҳ��Ȳ��ܴ���128");
		}

		if (!"�Թ�".equals(content[1].trim())
				&& !"��˽".equals(content[1].trim())) {
			throw new Exception("�Թ���˽��ֻ��¼��[�Թ����˽]��ֵ");
		}
		if (StringUtils.isBlank(content[1]) || content[1].getBytes("GBK").length >4) {
			throw new Exception("�Թ���˽��ʶ����Ϊ���ҳ��Ȳ��ܴ���4");
		}
	}
	
}
