package com.gmcc.pboss.web.resource.numtypedef;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.ui.User;

public class NumtypedefCheck extends BaseCheckFormat {
	private Properties property=null;
	public void checkFile(File file, HashMap parameterMap, String contentType)
		throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
		
	}
	
	public void checkLine(String line, int rowCount, User user)
		throws Exception {
		// TODO Auto-generated method stub
			//规则表达式
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 1) {
			throw new Exception("规则表达式不能为空,请查看补充说明!");
		}
		String prop=getRuleProperty(content[0]);
		if(prop==null){
			if(content[0].indexOf("*")==0){
				String num=content[0].substring(1, content[0].length());
				if(num.length()>9)
					throw new Exception("表达式错误，请检查!");
			}else{
				throw new Exception("表达式错误，请检查!");
			}
		}
	
	}
	/**
	 * 从规则配置文件中读取内容
	 * @param content
	 * @return
	 * @throws Exception
	 */
	private String getRuleProperty(String content)throws Exception{
		if(property==null){
			property=new Properties();
		}
		if(property.isEmpty()){
			URL url = NumtypedefCheck.class.getClassLoader()
			.getResource("numrule.properties");
			File file=new File(url.getFile());
			property.load(new FileInputStream(file));
		}
		return property.getProperty(content);
	}
	
	
	private boolean isEmpty(String checkStr) throws Exception {
	if (checkStr != null) {
		return StringUtils.isBlank(checkStr);
	} else {
		throw new Exception("检查字符串为空!");
	}
	}
}
