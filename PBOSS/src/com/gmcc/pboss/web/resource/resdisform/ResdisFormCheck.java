package com.gmcc.pboss.web.resource.resdisform;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.sunrise.jop.ui.User;

public class ResdisFormCheck extends BaseCheckFormat {

	public void checkFile(File file, HashMap parameterMap, String contentType)
	throws Exception {
	if (!"text/plain".equalsIgnoreCase(contentType)) {
		throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		
	}
}
	

	public void checkLine(String line, int rowCount, User user)
		throws Exception {
		String[] item = StringUtils.splitPreserveAllTokens(line, "|");
		if(item.length!=4)
			throw new Exception("上传数据第"+rowCount+"行:"+line+" 数据列数不对,应为3列,最后应用|结尾!");
		//配送商编码要求不能超过18位，商品批次不能超过30位，包号不能超过30位。
		if(item[0].length()>18 || item[1].length()>30 || item[2].length()>30)
			throw new Exception("上传数据第"+rowCount+"行:"+line+" 数据不正确,配送商编码要求不能超过18位，商品批次不能超过30位，包号不能超过30位!");
	}
}
