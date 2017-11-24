package com.gmcc.pboss.web.sales.order;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.common.utils.tools.CheckUtil;
import com.sunrise.jop.ui.User;

public class OrderBatchAllocateCheck extends BaseCheckFormat{
	public OrderBatchAllocateCheck() {
		// TODO Auto-generated constructor stub
	}

	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 3) {
			throw new Exception("[ " + line+ " ] ,��������ȷ,��ȷ����Ϊ2");
		} 
		if (!CheckUtil.checkString(content[0],18,false)) {
			throw new Exception( "�������Ҫ���ַ����ͣ��18λ���Ҳ���Ϊ��");
		}
		if (CheckUtil.isEmpty(content[1])){
			throw new Exception("��Ʒ���༰��������Ϊ��");
		}
	}  

}
