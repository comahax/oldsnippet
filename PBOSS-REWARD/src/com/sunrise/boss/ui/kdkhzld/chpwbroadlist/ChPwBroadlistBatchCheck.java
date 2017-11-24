package com.sunrise.boss.ui.kdkhzld.chpwbroadlist;

import java.util.HashMap;

import org.apache.struts.upload.FormFile;

import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.pub.tools.StringSplit;

public class ChPwBroadlistBatchCheck extends BaseCheckFormat {
	
	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("","要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
		
	}
	
	public void checkLine(String line, int rowCount, User user) throws Exception {
		
		String[] content =StringSplit.split(line, "|");
		
		if (content.length != 1) {
			throw new BusinessException("","文件格式不对，有且只有1项");
		}
		
		if(content[0] == null || "".equals(content[0])){
			throw new BusinessException("","白名单号码不能为空");
		}
		
		if(content[0].length() > 11){
			throw new BusinessException("","白名单号码，不能超过11位");
		}
		try {
			Long.parseLong(content[0]);
		} catch (Exception e) {
			throw new BusinessException("","白名单号码，只能为11位数字");
		}
	}
}
