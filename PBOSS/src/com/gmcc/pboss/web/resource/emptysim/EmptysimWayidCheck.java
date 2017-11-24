package com.gmcc.pboss.web.resource.emptysim;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.sunrise.jop.ui.User;

public class EmptysimWayidCheck extends BaseCheckFormat {
	public void checkFile(File file, HashMap parameterMap, String contentType)throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}
	 
	public void checkLine(String line, int rowCount, User user)	throws Exception {
		// TODO Auto-generated method stub
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length!=4) {
			throw new Exception("�ϴ������ݸ�ʽ����ȷ,��鿴����˵��!");
		}
		if(content[0].equals("")){
			throw new Exception("�տ����кŲ���Ϊ�գ�");
		}
		
		if(content[1].equals("")){
			throw new Exception("��Ʒ��ʶ����Ϊ��!");
		}
		
		if(content[2].equals("")){
			throw new Exception("���������벻��Ϊ�գ�");
		}
	}
	
	private boolean isEmpty(String checkStr)throws Exception {
		if (checkStr != null) {
			return StringUtils.isBlank(checkStr);
		} else {
			throw new Exception("����ַ���Ϊ��!");
		}
	}
}
