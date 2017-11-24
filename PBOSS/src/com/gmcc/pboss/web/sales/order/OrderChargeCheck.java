package com.gmcc.pboss.web.sales.order;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.sunrise.jop.ui.User;

public class OrderChargeCheck extends BaseCheckFormat{

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
		String item[] = StringUtils.split(line,"|");
		if(item.length>3)
			throw new Exception("��"+rowCount+"��:[ "+line+ " ] , ��������,ӦΪ2��,��鿴˵������!");
		if(!line.endsWith("|"))
			throw new Exception("��"+rowCount+"��:[ "+line+ " ] , ������ | ����,��鿴˵������!");
		if (item[0].length() > 18) {
			throw new Exception("��"+rowCount+"��:[ "+line+ " ] , �������Ҫ���ַ����ͣ���󳤶�18λ");
		}
		if (item.length!=1){
			if(!StringUtils.isEmpty(item[1])){
				if(item[1].length() > 20){
					throw new Exception("POS��ˮ����󳤶�Ϊ20λ!");
				}
			}
		}
	}
}
