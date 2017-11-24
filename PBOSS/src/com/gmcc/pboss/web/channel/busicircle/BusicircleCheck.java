package com.gmcc.pboss.web.channel.busicircle;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.sunrise.jop.ui.User;

public class BusicircleCheck extends BaseCheckFormat {
	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}

	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {

		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 6) {
			throw new Exception("上传数据列数不对,应为5列,请查看说明帮助!");
		}
		if (content[0] == null || "".equals(content[0])) {
			throw new Exception("商圈编码不能为空");
		}
		if (content[2] == null || "".equals(content[2])) {
			throw new Exception("商圈级别不能为空");
		} else if (!("A").equals(content[2]) && !("B").equals(content[2])&& !("C").equals(content[2])) {
			throw new Exception("商圈级别错误请核实");
		}  
		if (content[3] == null || "".equals(content[3])) {
			throw new Exception("分公司不能为空");
		}
		
	}

}
