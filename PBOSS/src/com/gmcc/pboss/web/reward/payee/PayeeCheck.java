package com.gmcc.pboss.web.reward.payee;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.sunrise.jop.ui.User;

public class PayeeCheck extends BaseCheckFormat {
	private User user;
	@Override
	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		user = (User) parameterMap.get("user");
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	@Override
	public void checkLine(String line, int rowCount, User user) throws Exception {
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 3) {
			throw new Exception("上传列数不正确，应为2列!");
		}
		if(StringUtils.isBlank(content[0]) || content[0].getBytes("GBK").length > 128) {
			throw new Exception("付款单位名称不能为空且长度不能大于128");
		}

		if (!"对公".equals(content[1].trim())
				&& !"对私".equals(content[1].trim())) {
			throw new Exception("对公对私列只能录入[对公或对私]的值");
		}
		if (StringUtils.isBlank(content[1]) || content[1].getBytes("GBK").length >4) {
			throw new Exception("对公对私标识不能为空且长度不能大于4");
		}
	}
	
}
