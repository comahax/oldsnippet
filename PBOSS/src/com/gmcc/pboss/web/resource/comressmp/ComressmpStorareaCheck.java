package com.gmcc.pboss.web.resource.comressmp;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.ui.User;

public class ComressmpStorareaCheck extends BaseCheckFormat {
public void checkFile(File file, HashMap parameterMap, String contentType)
	throws Exception {
	if (!"text/plain".equalsIgnoreCase(contentType)) {
		throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
	}
	if(parameterMap.get("storarea")==null || "".equals(parameterMap.get("storarea")))
		throw new Exception("��ѡ��Ҫ���µ���Դ����!");
}

public void checkLine(String line, int rowCount, User user)
	throws Exception {
// TODO Auto-generated method stub
	String[] content = StringUtils.splitPreserveAllTokens(line, "|");
	if (content.length!=3) {
		throw new Exception("�ϴ������ݸ�ʽ����ȷ,��鿴����˵��!");
	}
	if(content[0].length()>30)
		throw new Exception("��Ʒ���β��ܳ���30λ,��鿴����˵��!");
	if (content[1].length()> 30 )
		throw new Exception("������󳤶�Ϊ30λ,��鿴����˵��!");
}

private boolean isEmpty(String checkStr) throws Exception {
if (checkStr != null) {
	return StringUtils.isBlank(checkStr);
} else {
	throw new Exception("����ַ���Ϊ��!");
}
}
}
