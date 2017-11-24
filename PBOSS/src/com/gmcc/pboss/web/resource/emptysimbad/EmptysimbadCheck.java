package com.gmcc.pboss.web.resource.emptysimbad;

import java.io.File;
import java.util.HashMap;
import org.apache.commons.lang.StringUtils;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.common.utils.tools.CheckUtil;
import com.sunrise.jop.ui.User;

public class EmptysimbadCheck extends BaseCheckFormat {

	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ��ֻ�ܵ���ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 3) {
			throw new Exception("��" + rowCount + "��:[ " + line + " ] ,��������ȷ,��ȷ����Ϊ2");
		}
		if (!CheckUtil.checkString(content[0], 21, false)) {
			throw new Exception("[�հ�SIM�����к�]����Ϊ�գ�����󳤶�Ϊ21");
		}
		if (!CheckUtil.checkString(content[1], 18, false)) {
			throw new Exception("[��������]����Ϊ�գ�����󳤶�Ϊ18");
		}
	}

}
