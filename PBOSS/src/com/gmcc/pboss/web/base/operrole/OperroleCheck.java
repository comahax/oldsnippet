package com.gmcc.pboss.web.base.operrole;

import java.io.File;
import java.util.HashMap;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.ui.User;

public class OperroleCheck extends BaseCheckFormat {

	public OperroleCheck() {
		// TODO Auto-generated constructor stub
	}

	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		// TODO Auto-generated method stub
		String[] content = StringUtils.split(line, "|");
		if (content.length != 4) {
			throw new Exception("上传数据列数不对,应为4列,请查看说明帮助!");
		}
		if (!"".equals(content[2])
				&& !content[2].matches("[0,1]{1}")) {
			throw new Exception("[状态]只能为0或1");
		}

	}

	private boolean isEmpty(String checkStr) throws Exception {
		if (checkStr != null) {
			return StringUtils.isBlank(checkStr);
		} else {
			throw new Exception("检查字符串为空!");
		}
	}
}