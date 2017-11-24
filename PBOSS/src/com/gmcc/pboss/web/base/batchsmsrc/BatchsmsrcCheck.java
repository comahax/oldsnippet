package com.gmcc.pboss.web.base.batchsmsrc;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.control.base.batchsmsrc.BatchsmsrcBO;
import com.gmcc.pboss.control.base.smstmpl.SmstmplBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

public class BatchsmsrcCheck extends BaseCheckFormat {
	
	public static final Map SmsCodeMap = new HashMap();
	static {
		for (int i = 1; i <= 9; i++) {
			SmsCodeMap.put("CJ_03"+i, "CJ_03"+i);
		}
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
	if (content.length !=4) {
		throw new Exception("第"+rowCount+"行:[ "+line+ " ] ,列数不正确,正确列数为3");
	}
	if(StringUtils.isEmpty(content[0]))
		throw new Exception("第"+rowCount+"行:[ "+line+ " ] ,接收号码不能为空");
	if(StringUtils.isEmpty(content[1]))
		throw new Exception("第"+rowCount+"行:[ "+line+ " ] ,短信编码不能为空");
	if(StringUtils.isEmpty(content[2]))
		throw new Exception("第"+rowCount+"行:[ "+line+ " ] ,发送时间不能为空");
	checkParameter(content,user);
	}
	
	private void checkParameter(String[] fields, User user) throws Exception {
		
		// 手机号码	
		if (!StringUtils.isNumeric(fields[0]) || fields[0].length() != 11) {
			throw new Exception("请输入11位数字的手机号码。");
		}
		// 短信编码
		SmstmplBO bo = (SmstmplBO) BOFactory.build(SmstmplBO.class,user);
		if (bo.doFindByPk(fields[1]) == null) {
			throw new Exception("短信编码在短信模板表中不存在。");
		}
		if (SmsCodeMap.get(fields[1]) == null) {
			throw new Exception("不是CJ_031~CJ_039之间的短信编码。");
		}
		// 发送时间
		check(fields[2]);
	}

	public void check(String checkStr) throws Exception {
		if (!StringUtils.isNumeric(checkStr))	
			throw new Exception("发送时间格式不正确，必须是数字");
		if (checkStr.getBytes("GBK").length != 6) 
			throw new Exception("发送时间格式不正确，应该是6位数字");
		if (checkStr.substring(0, 2).compareTo("23") > 0)
			throw new Exception("发送时间格式不正确，小时数不能大于23");
		if (checkStr.substring(2, 4).compareTo("59") > 0 || checkStr.substring(4).compareTo("59") > 0)
			throw new Exception("发送时间格式不正确，分和秒数不能大于59");
	}
}
