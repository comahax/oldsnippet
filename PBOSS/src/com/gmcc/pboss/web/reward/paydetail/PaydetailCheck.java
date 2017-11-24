package com.gmcc.pboss.web.reward.paydetail;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.common.utils.tools.DateUtil;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

public class PaydetailCheck extends BaseCheckFormat {

	private User user;

	@Override
	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		user = (User) parameterMap.get("user");
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}
	
	@Override
	public void checkLine(String line, int rowCount, User user) throws Exception {
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 5) {
			throw new Exception("�ϴ���������ȷ��ӦΪ4��!");
		}

		String wayid = content[0].trim();
		Way way = (Way)BOFactory.build(WayBO.class, user);
		if (way.doFindByPk(wayid) == null) {
			throw new Exception("������������BOSS�������룬�������������Ƿ���ȷ!");
		}
		
		
		String opmonth = content[2].trim();
		boolean flag = DateUtil.chkIfYmFormat(opmonth);
		if (!flag) {
			throw new Exception("��ҵ���¡�" + opmonth + "����ʽ����,ӦΪyyyyMM");
			
		}
		
		String calcmonth = content[3].trim();
		flag = DateUtil.chkIfYmFormat(calcmonth);
		if (!flag) {
			throw new Exception("�ý����¡�" + calcmonth + "����ʽ����,ӦΪyyyyMM");
			
		}
		
	}

}
