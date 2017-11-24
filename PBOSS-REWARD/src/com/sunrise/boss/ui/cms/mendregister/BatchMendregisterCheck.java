package com.sunrise.boss.ui.cms.mendregister;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class BatchMendregisterCheck extends BaseCheckFormat {
	public BatchMendregisterCheck() {
		super();
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		if (rowCount > 10000) {
			throw new Exception("文件行数不能超过10000行");
		}
		if (null == line || "".equals(line)) {
			return;
		}
		// String[] items = line.split("\\|");
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		// 检查列数
		if (items.length != 3) {
			throw new Exception("上传数据列数不对,应为3列,请查看说明帮助!");
		}
		if(StringUtils.isBlank(items[0])){
			throw new Exception("套卡号码为必填项!");
		}
		if(StringUtils.isBlank(items[1])){
			throw new Exception("套卡销售时间为必填项!");
		}
		if(StringUtils.isBlank(items[2])){
			throw new Exception("公务机号码为必填项!");
		}
	}
}
