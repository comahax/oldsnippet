package com.gmcc.pboss.web.sales.order;

import java.io.File;
import java.util.HashMap; 
import org.apache.commons.lang.StringUtils; 
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.common.utils.tools.CheckUtil;
import com.sunrise.jop.ui.User;

public class OrderBatchReviewCheck extends BaseCheckFormat{
	public OrderBatchReviewCheck() {
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
		if (content.length != 1) {
			throw new Exception("��" + rowCount + "��:[ " + line
					+ " ] ,��������ȷ,��ȷ����Ϊ1");
		} 
		if (!CheckUtil.checkString(content[0],18,false)) {
			throw new Exception("��" + rowCount + "��:[ " + content[0] + " ] �������Ҫ���ַ����ͣ��18λ���Ҳ���Ϊ��");
		}  
	}  
}
