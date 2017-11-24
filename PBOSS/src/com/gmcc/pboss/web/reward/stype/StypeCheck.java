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
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	private List<String> getOptypeList() {
		List<String> list = new ArrayList(5);
		list.add("个人业务");
		list.add("数据业务");
		list.add("集团业务");
		list.add("税金业务");
		list.add("其他业务");

		return list;
	}

	@Override
	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 4) {
			throw new Exception("上传列数不正确，应为3列!");
		}

		if (StringUtils.isBlank(content[0])
				|| content[0].getBytes("GBK").length > 16) {
			throw new Exception("业务类型不能为空且长度不能大于16");
		}

		String optype = content[0].trim();
		List<String> allList = getOptypeList();
		if (!allList.contains(optype)) {
			throw new Exception(
					"[业务类型]只能是“个人业务”、“数据业务”、“集团业务”、“税金业务”、“其他业务”中的一种；");
		}

		if (StringUtils.isBlank(content[1])
				|| content[1].getBytes("GBK").length > 128) {
			throw new Exception("酬金大类不能为空且长度不能大于128");
		}

		if (StringUtils.isBlank(content[2])
				|| content[1].getBytes("GBK").length > 128) {
			throw new Exception("酬金小类不能为空且长度不能大于128");
		}
	}

}
