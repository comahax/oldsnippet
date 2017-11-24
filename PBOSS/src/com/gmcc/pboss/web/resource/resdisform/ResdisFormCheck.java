package com.gmcc.pboss.web.resource.resdisform;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.sunrise.jop.ui.User;

public class ResdisFormCheck extends BaseCheckFormat {

	public void checkFile(File file, HashMap parameterMap, String contentType)
	throws Exception {
	if (!"text/plain".equalsIgnoreCase(contentType)) {
		throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		
	}
}
	

	public void checkLine(String line, int rowCount, User user)
		throws Exception {
		String[] item = StringUtils.splitPreserveAllTokens(line, "|");
		if(item.length!=4)
			throw new Exception("�ϴ����ݵ�"+rowCount+"��:"+line+" ������������,ӦΪ3��,���Ӧ��|��β!");
		//�����̱���Ҫ���ܳ���18λ����Ʒ���β��ܳ���30λ�����Ų��ܳ���30λ��
		if(item[0].length()>18 || item[1].length()>30 || item[2].length()>30)
			throw new Exception("�ϴ����ݵ�"+rowCount+"��:"+line+" ���ݲ���ȷ,�����̱���Ҫ���ܳ���18λ����Ʒ���β��ܳ���30λ�����Ų��ܳ���30λ!");
	}
}
