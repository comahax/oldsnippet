package com.gmcc.pboss.web.sales.order;

import java.io.File;
import java.util.HashMap;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.sunrise.jop.ui.User;

public class OrderCheck extends BaseCheckFormat {

	@Override
	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	@Override
	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		if (line != null && line.trim().equals("")) {
			throw new Exception("订单编号不能为空");
		} else if (line.length() > 18) {
			throw new Exception("订单编号最大长度为18位的字符");
		}
	}

}
