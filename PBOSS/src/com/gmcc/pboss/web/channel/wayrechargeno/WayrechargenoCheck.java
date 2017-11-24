package com.gmcc.pboss.web.channel.wayrechargeno;

import java.io.File;
import java.util.HashMap;

import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class WayrechargenoCheck extends BaseCheckFormat {

	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
//		������split�ķ���
//		String[] fields = StringUtils.splitPreserveAllTokens(line, "|");
//		String[] content = StringUtils.split(line, "|");
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != (2+1)) {
			throw new Exception("�ϴ�������������,ӦΪ2��,��鿴˵������!");
		}
		if (StringUtils.isEmpty(content[0])) {
			throw new Exception("�������벻��Ϊ��");
		}
		if (StringUtils.isEmpty(content[1])) {
			throw new Exception("���г�ֵ���벻��Ϊ��");
		}
		if (content[1].trim().length()!=11) {
			throw new Exception("���г�ֵ�������Ϊ11λ");
		}
		
		
	}
}