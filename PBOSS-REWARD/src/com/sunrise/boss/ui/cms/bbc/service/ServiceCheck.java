package com.sunrise.boss.ui.cms.bbc.service;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class ServiceCheck extends BaseCheckFormat {

	public ServiceCheck(){
		
	}
	
	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("","要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}
	
	public void checkLine(String line, int rowCount, User user) throws Exception {
		
		String[] content =StringUtils.splitPreserveAllTokens(line, "|");
		
		if (content.length != 5) {
			throw new Exception("上传数据列数不对,应为4列,请查看说明帮助!");
		}
		if(StringUtils.isEmpty(content[0])){
			throw new BusinessException("","业务名称不能为空");
		}
		if(StringUtils.isEmpty(content[1])){
			throw new BusinessException("","业务编码不能为空");
		}
		if(StringUtils.isEmpty(content[2])){
			throw new BusinessException("","基本酬金标准不能为空");
		}
		if(StringUtils.isEmpty(content[3])){
			throw new BusinessException("","奖励酬金标准不能为空");
		}
		
		for (int i = 0; i < content.length-1; i++) {
			switch (i) {
			case 0:
				if (!CheckUtil.checkString(content[i], 50, true)) {
					throw new Exception("[业务名称]不能大于50位");
				}
				break;
			case 1:
				if (!CheckUtil.checkString(content[i], 12,true)) {
					throw new Exception("[业务编码]不能大于12位");
				}
				break;
			case 2:
				if (!CheckUtil.checkDouble(content[i], 6, 2)) {
					throw new Exception("[基本酬金标准]整数部分不能超过6位,小数部分不能超过2位");
				}
				break;
			case 3:
				if (!CheckUtil.checkDouble(content[i], 6, 2)) {
					throw new Exception("[奖励酬金标准]整数部分不能超过6位,小数部分不能超过2位");
				}
				break;
			}	
		}
	}
	
}
