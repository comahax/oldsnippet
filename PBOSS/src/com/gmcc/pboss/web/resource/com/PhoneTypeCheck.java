package com.gmcc.pboss.web.resource.com;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.sunrise.jop.ui.User;

public class PhoneTypeCheck extends BaseCheckFormat{	
	public void checkFile(File file, HashMap parameterMap, String contentType)
	throws Exception {
	if (!"text/plain".equalsIgnoreCase(contentType)) {
		throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
	}
	
}

	
//	�������Ϊ11λ�������ͣ���а���Ϊ���Ȳ�����32λ���ַ����͡����ͨ���������һ����
//	��ͨ������ʾ�����ļ��кʹ�����������ֹ�ļ��ϴ���
public void checkLine(String line, int rowCount, User user)
	throws Exception {
	// TODO Auto-generated method stub
	String[] content = StringUtils.splitPreserveAllTokens(line, "|");
	if (content.length !=3) {
		throw new Exception("�ϴ������ݸ�ʽ����ȷ,��鿴����˵��!");
	}
	if(content[0].trim().length()!=11)
		throw new Exception("����Ϊ11λ������,��鿴����˵��!");
	try{
		Long.parseLong(content[0]);
	}catch(Exception e){
		throw new Exception("����Ϊ11λ������,��鿴����˵��!");
	}
	if (content[1].length()> 32 )
		throw new Exception("��а���Ϊ���Ȳ�����32λ,��鿴����˵��!");
}

private boolean isEmpty(String checkStr) throws Exception {
	if (checkStr != null) {
		return StringUtils.isBlank(checkStr);
	} else {
		throw new Exception("����ַ���Ϊ��!");
	}
	}
}
