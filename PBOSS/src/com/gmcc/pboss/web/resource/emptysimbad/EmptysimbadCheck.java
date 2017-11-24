package com.gmcc.pboss.web.resource.emptysimbad;

import java.io.File;
import java.util.HashMap;
import org.apache.commons.lang.StringUtils;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.common.utils.tools.CheckUtil;
import com.sunrise.jop.ui.User;

public class EmptysimbadCheck extends BaseCheckFormat {

	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("要导入的文件类型不正确，只能导入指定的文件格式：txt文本文件!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 3) {
			throw new Exception("第" + rowCount + "行:[ " + line + " ] ,列数不正确,正确列数为2");
		}
		if (!CheckUtil.checkString(content[0], 21, false)) {
			throw new Exception("[空白SIM卡序列号]不能为空，且最大长度为21");
		}
		if (!CheckUtil.checkString(content[1], 18, false)) {
			throw new Exception("[渠道编码]不能为空，且最大长度为18");
		}
	}

}
