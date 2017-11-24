package com.gmcc.pboss.web.sales.canorderinfo;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.sunrise.jop.ui.User;

public class CanorderinfoNoticeCheck extends BaseCheckFormat{

	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) 
		{
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		} 
   }

	 
	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length !=1) 
		{
			throw new Exception("第"+rowCount+"行:[ "+line+ " ] ,列数不正确,正确列数为1");
		}
		
		if(content[0]==null && content[0].equals("")){
			throw new Exception("第"+rowCount+"行:[ "+line+ " ] ,合作商编码不能为空");			
		}
	}
}
