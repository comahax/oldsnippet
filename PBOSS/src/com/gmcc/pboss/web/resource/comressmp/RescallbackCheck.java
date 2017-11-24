package com.gmcc.pboss.web.resource.comressmp;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.sunrise.jop.ui.User;

public class RescallbackCheck extends BaseCheckFormat {

	String flag = "";
	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
		flag = parameterMap.get("callbacktype").toString();
		if ( flag == null
				|| "".equals(flag))
			throw new Exception("��ѡ��Ҫ���յ���Դ���!");
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		// TODO Auto-generated method stub
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 3) {
			throw new Exception("�ϴ������ݸ�ʽ����ȷ,��鿴����˵��!");
		}
		if(flag.equals("EMPTYSIM")){
			 if (content[0].length() > 21)
					throw new Exception("�հ׿����кŲ��ܳ���21λ,��鿴����˵��!");
		}else{	
		 if (content[0].length() > 32)
			throw new Exception("��Ʒ��Դ��Ų��ܳ���32λ,��鿴����˵��!");
		}
		if (content[1].length() > 18)
			throw new Exception("��Ʒ��ʶ��󳤶�Ϊ18λ,��鿴����˵��!");
	}

	private boolean isEmpty(String checkStr) throws Exception {
		if (checkStr != null) {
			return StringUtils.isBlank(checkStr);
		} else {
			throw new Exception("����ַ���Ϊ��!");
		}
	}

}
