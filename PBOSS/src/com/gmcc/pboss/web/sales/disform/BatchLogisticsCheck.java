package com.gmcc.pboss.web.sales.disform;

import java.io.File;
import java.util.HashMap;
import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.sales.disform.DisformVO;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.common.utils.tools.CheckUtil;
import com.gmcc.pboss.control.sales.disform.Disform;
import com.gmcc.pboss.control.sales.disform.DisformBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

public class BatchLogisticsCheck extends BaseCheckFormat {
	public BatchLogisticsCheck() {
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
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 3) {
			throw new Exception("第" + rowCount + "行:[ " + line
					+ " ] ,列数不正确,正确列数为2");
		}
		if (!CheckUtil.checkNum(content[0],14,false)) {
			throw new Exception("第" + rowCount + "行:[ " + content[0] + " ] ,配送商编号要求数字类型，最大14位，且不能为空");
		} 
		if (!CheckUtil.checkString(content[1],32,false)) {
			throw new Exception("第" + rowCount + "行:[ " + content[1] + " ] ,物流单号要求字符类型，最长32位，且不能为空");
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
