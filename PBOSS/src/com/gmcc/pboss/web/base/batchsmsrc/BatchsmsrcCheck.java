package com.gmcc.pboss.web.base.batchsmsrc;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.control.base.batchsmsrc.BatchsmsrcBO;
import com.gmcc.pboss.control.base.smstmpl.SmstmplBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

public class BatchsmsrcCheck extends BaseCheckFormat {
	
	public static final Map SmsCodeMap = new HashMap();
	static {
		for (int i = 1; i <= 9; i++) {
			SmsCodeMap.put("CJ_03"+i, "CJ_03"+i);
		}
	}
	
	public void checkFile(File file, HashMap parameterMap, String contentType)
		throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}	

	public void checkLine(String line, int rowCount, User user)
		throws Exception {
	// TODO Auto-generated method stub
	String[] content = StringUtils.splitPreserveAllTokens(line, "|");
	if (content.length !=4) {
		throw new Exception("��"+rowCount+"��:[ "+line+ " ] ,��������ȷ,��ȷ����Ϊ3");
	}
	if(StringUtils.isEmpty(content[0]))
		throw new Exception("��"+rowCount+"��:[ "+line+ " ] ,���պ��벻��Ϊ��");
	if(StringUtils.isEmpty(content[1]))
		throw new Exception("��"+rowCount+"��:[ "+line+ " ] ,���ű��벻��Ϊ��");
	if(StringUtils.isEmpty(content[2]))
		throw new Exception("��"+rowCount+"��:[ "+line+ " ] ,����ʱ�䲻��Ϊ��");
	checkParameter(content,user);
	}
	
	private void checkParameter(String[] fields, User user) throws Exception {
		
		// �ֻ�����	
		if (!StringUtils.isNumeric(fields[0]) || fields[0].length() != 11) {
			throw new Exception("������11λ���ֵ��ֻ����롣");
		}
		// ���ű���
		SmstmplBO bo = (SmstmplBO) BOFactory.build(SmstmplBO.class,user);
		if (bo.doFindByPk(fields[1]) == null) {
			throw new Exception("���ű����ڶ���ģ����в����ڡ�");
		}
		if (SmsCodeMap.get(fields[1]) == null) {
			throw new Exception("����CJ_031~CJ_039֮��Ķ��ű��롣");
		}
		// ����ʱ��
		check(fields[2]);
	}

	public void check(String checkStr) throws Exception {
		if (!StringUtils.isNumeric(checkStr))	
			throw new Exception("����ʱ���ʽ����ȷ������������");
		if (checkStr.getBytes("GBK").length != 6) 
			throw new Exception("����ʱ���ʽ����ȷ��Ӧ����6λ����");
		if (checkStr.substring(0, 2).compareTo("23") > 0)
			throw new Exception("����ʱ���ʽ����ȷ��Сʱ�����ܴ���23");
		if (checkStr.substring(2, 4).compareTo("59") > 0 || checkStr.substring(4).compareTo("59") > 0)
			throw new Exception("����ʱ���ʽ����ȷ���ֺ��������ܴ���59");
	}
}
