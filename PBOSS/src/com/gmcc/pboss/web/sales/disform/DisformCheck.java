package com.gmcc.pboss.web.sales.disform;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.ui.User;

public class DisformCheck extends BaseCheckFormat {

	public DisformCheck() {
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
		if (content.length >= 2) {
			throw new Exception("上传数据列数不对,应为1列,请查看说明帮助!");
		}
		
		if(!PublicUtils.isInteger(content[0])||content[0].length()>14){
			throw new Exception("配送单编号要求长度不超过14位的数字,请查看补充说明!");
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
