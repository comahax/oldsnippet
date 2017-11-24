package com.gmcc.pboss.web.sales.actrepair;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.common.utils.tools.CheckUtil;
import com.sunrise.jop.ui.User;

public class ActrepairCheck extends BaseCheckFormat {

	public ActrepairCheck() {
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
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 4) {
			throw new Exception("上传数据列数不对,应为3列,请查看说明帮助!");
		}
		if (!CheckUtil.checkNum(content[0], 11, false)) {
			throw new Exception("[号码]不能为空,必须为数字,且长度不能大于11位");
		}
		if (!CheckUtil.checkDate(content[1], "yyyy-MM-dd", false)) {
			throw new Exception("[激活日期]不能为空,且格式应该为[yyyy-MM-dd]");
		}
		if (!CheckUtil.checkString(content[2], 255, false)) {
			throw new Exception("[补录原因]不能为空,且长度不能大于255位");
		}

	}

}
