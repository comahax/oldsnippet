package com.gmcc.pboss.web.resource.compack;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.control.resource.com.Com;
import com.gmcc.pboss.control.resource.com.ComBO;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class CompackToolCheck extends BaseCheckFormat {

	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		// TODO Auto-generated method stub
		// 商品资源编号|仓储包号|
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length < 1) {
			throw new Exception("上传的数据格式不正确,请查看补充说明!");
		}
		if (!PublicUtils.isInteger(content[0]) || content[0].length() != 11)
			throw new Exception("商品资源编号要求长度11位的数字,请查看补充说明!");
		
	}

	private boolean isEmpty(String checkStr) throws Exception {
		if (checkStr != null) {
			return StringUtils.isBlank(checkStr);
		} else {
			throw new Exception("检查字符串为空!");
		}
	}
}
