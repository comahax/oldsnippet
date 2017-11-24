package com.gmcc.pboss.web.reward.stype;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.sunrise.jop.ui.User;

public class StypeCheck extends BaseCheckFormat {
	private User user;

	@Override
	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		user = (User) parameterMap.get("user");
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	private List<String> getOptypeList() {
		List<String> list = new ArrayList(5);
		list.add("����ҵ��");
		list.add("����ҵ��");
		list.add("����ҵ��");
		list.add("˰��ҵ��");
		list.add("����ҵ��");

		return list;
	}

	@Override
	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 4) {
			throw new Exception("�ϴ���������ȷ��ӦΪ3��!");
		}

		if (StringUtils.isBlank(content[0])
				|| content[0].getBytes("GBK").length > 16) {
			throw new Exception("ҵ�����Ͳ���Ϊ���ҳ��Ȳ��ܴ���16");
		}

		String optype = content[0].trim();
		List<String> allList = getOptypeList();
		if (!allList.contains(optype)) {
			throw new Exception(
					"[ҵ������]ֻ���ǡ�����ҵ�񡱡�������ҵ�񡱡�������ҵ�񡱡���˰��ҵ�񡱡�������ҵ���е�һ�֣�");
		}

		if (StringUtils.isBlank(content[1])
				|| content[1].getBytes("GBK").length > 128) {
			throw new Exception("�����಻��Ϊ���ҳ��Ȳ��ܴ���128");
		}

		if (StringUtils.isBlank(content[2])
				|| content[1].getBytes("GBK").length > 128) {
			throw new Exception("���С�಻��Ϊ���ҳ��Ȳ��ܴ���128");
		}
	}

}
