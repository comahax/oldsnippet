package com.gmcc.pboss.web.resource.com;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.sunrise.jop.ui.User;

public class PhoneTypeCheck extends BaseCheckFormat{	
	public void checkFile(File file, HashMap parameterMap, String contentType)
	throws Exception {
	if (!"text/plain".equalsIgnoreCase(contentType)) {
		throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
	}
	
}

	
//	号码必须为11位数字类型，箱盒包号为长度不超过32位的字符类型。检查通过则进入下一步，
//	不通过则提示出错文件行和错误描述，终止文件上传。
public void checkLine(String line, int rowCount, User user)
	throws Exception {
	// TODO Auto-generated method stub
	String[] content = StringUtils.splitPreserveAllTokens(line, "|");
	if (content.length !=3) {
		throw new Exception("上传的数据格式不正确,请查看补充说明!");
	}
	if(content[0].trim().length()!=11)
		throw new Exception("号码为11位的数字,请查看补充说明!");
	try{
		Long.parseLong(content[0]);
	}catch(Exception e){
		throw new Exception("号码为11位的数字,请查看补充说明!");
	}
	if (content[1].length()> 32 )
		throw new Exception("箱盒包号为长度不超过32位,请查看补充说明!");
}

private boolean isEmpty(String checkStr) throws Exception {
	if (checkStr != null) {
		return StringUtils.isBlank(checkStr);
	} else {
		throw new Exception("检查字符串为空!");
	}
	}
}
