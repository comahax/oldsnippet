package com.gmcc.pboss.web.sales.salesstd;

import java.io.File;
import java.util.HashMap;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.ui.User;

public class SalesstdCheck extends BaseCheckFormat {
	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		//�ֹ�˾|΢����|�Ǽ�|������ֵ
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 5) {
			throw new Exception("�ϴ�������������,ӦΪ4��,��鿴˵������!");
		}
		if (StringUtils.isEmpty(content[0])) {
			throw new Exception("�ֹ�˾����Ϊ��");
		}
		if (StringUtils.isEmpty(content[1])) {
			throw new Exception("΢������Ϊ��");
		}
		if (StringUtils.isEmpty(content[2])) {
			throw new Exception("�Ǽ�����Ϊ��");
		}
		try{
			Integer.parseInt(content[2]);
		}catch(Exception e){
			throw new Exception("�Ǽ�ֻ��������");
		} 
		if (StringUtils.isEmpty(content[3])) {
			throw new Exception("������ֵ����Ϊ��");
		}
	}
}
