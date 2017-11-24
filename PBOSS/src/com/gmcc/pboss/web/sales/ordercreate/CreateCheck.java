package com.gmcc.pboss.web.sales.ordercreate;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.sunrise.jop.ui.User;

public class CreateCheck extends BaseCheckFormat{

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
		if(item.length != 3)
			throw new Exception("�ϴ�������������,ӦΪ2��,��鿴˵������!");
		
		for (int i = 0; i < item.length; i++) {
			
			switch (i) {
			// ��������
			case 0:
				if ("".equals(item[i].trim())) {
					throw new Exception("[�����̱���]����Ϊ��");
				}
				break;
			
			case 1:
				if ("".equals(item[i].trim())) {
					throw new Exception("[������Դ����Ͷ�������]����Ϊ��");
				}
				break;
			}
		}
		
	}
	
}
