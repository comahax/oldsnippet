package com.gmcc.pboss.web.sales.disform;

import java.io.File;
import java.util.HashMap;
import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.sales.disform.DisformVO;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.common.utils.tools.CheckUtil;
import com.gmcc.pboss.control.sales.disform.Disform;
import com.gmcc.pboss.control.sales.disform.DisformBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

public class BatchLogisticsCheck extends BaseCheckFormat {
	public BatchLogisticsCheck() {
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
			throw new Exception("��" + rowCount + "��:[ " + line
					+ " ] ,��������ȷ,��ȷ����Ϊ2");
		}
		if (!CheckUtil.checkNum(content[0],14,false)) {
			throw new Exception("��" + rowCount + "��:[ " + content[0] + " ] ,�����̱��Ҫ���������ͣ����14λ���Ҳ���Ϊ��");
		} 
		if (!CheckUtil.checkString(content[1],32,false)) {
			throw new Exception("��" + rowCount + "��:[ " + content[1] + " ] ,��������Ҫ���ַ����ͣ��32λ���Ҳ���Ϊ��");
		}  
	} 
	private boolean isEmpty(String checkStr) throws Exception {
		if (checkStr != null) {
			return StringUtils.isBlank(checkStr);
		} else {
			throw new Exception("����ַ���Ϊ��!");
		}
	}
}
