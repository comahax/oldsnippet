package com.gmcc.pboss.web.reward.setcard;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.common.utils.tools.CityId;
import com.sunrise.jop.ui.User;

public class SetcardCheck extends BaseCheckFormat {
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
	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 7) {
			throw new Exception("�ϴ���������ȷ��ӦΪ6��!");
		}

		String wayid = content[0];
		if (StringUtils.isBlank(wayid)
				|| wayid.trim().getBytes("GBK").length > 30) {
			throw new Exception("�������벻��Ϊ���ҳ��Ȳ��ܴ���30");
		}
		
		String sctvday = content[1];
		if (StringUtils.isBlank(sctvday)
				|| sctvday.trim().getBytes("GBK").length > 8) {
			throw new Exception("����ʱ�䲻��Ϊ���ҳ��Ȳ��ܴ���8����ʽΪ:yyyyMMdd");
		}
		
		String mobile = content[2];
		if (StringUtils.isBlank(mobile)
				|| mobile.trim().getBytes("GBK").length != 11) {
			throw new Exception("���벻��Ϊ���ҳ���Ϊ11λ");
		}
		
		String cityid = content[3];
		if (StringUtils.isBlank(cityid)
				|| cityid.trim().getBytes("GBK").length > 2 ) {
			throw new Exception("���в���Ϊ���ҳ��ȳ��Ȳ��ܴ���2����ʽ�磺GZ");
		}
		
		if (!StringUtils.isBlank(cityid) 
				&& (CityId.getCityName(cityid)==null || CityId.getCityName(cityid)=="") ) {
			throw new Exception("���и�ʽ����ȷ��ӦΪ��дƴ������ĸ����ʽ�磺GZ");
		}
		
		String waytype = content[4];
		if (StringUtils.isBlank(waytype)
				|| waytype.trim().getBytes("GBK").length > 1) {
			throw new Exception("�������Ͳ���Ϊ���ҳ��ȳ��Ȳ��ܴ���1����ʽ�磺1(������������)��2(�����������)");
		}
	}
}
