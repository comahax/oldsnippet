package com.gmcc.pboss.web.sales.canorderinfo;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.sunrise.jop.ui.User;

public class CanorderinfoNoticeCheck extends BaseCheckFormat{

	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) 
		{
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		} 
   }

	 
	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length !=1) 
		{
			throw new Exception("��"+rowCount+"��:[ "+line+ " ] ,��������ȷ,��ȷ����Ϊ1");
		}
		
		if(content[0]==null && content[0].equals("")){
			throw new Exception("��"+rowCount+"��:[ "+line+ " ] ,�����̱��벻��Ϊ��");			
		}
	}
}
