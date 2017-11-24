package com.gmcc.pboss.web.sales.order;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.sunrise.jop.ui.User;

public class RecordedCheck extends BaseCheckFormat{

	@Override
	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		// TODO Auto-generated method stub
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	@Override
	public void checkLine(String line, int rowCount ,User user) throws Exception {
		// TODO Auto-generated method stub
//		�������Ҫ���ַ����ͣ���󳤶�18λ�����ͨ���������һ������ͨ������ʾ�����ļ��кʹ�����������ֹ�ļ��ϴ���
		String item[] = StringUtils.splitPreserveAllTokens(line,"|");
		if(item.length>2)
			throw new Exception("��"+rowCount+"��:[ "+line+ " ] , �������ֻ��һ��");
		if (line.length() > 18) {
			throw new Exception("��"+rowCount+"��:[ "+line+ " ] , �������Ҫ���ַ����ͣ���󳤶�18λ");
		}
		
	}

	
	
}
