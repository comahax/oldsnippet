package com.sunrise.boss.ui.cms.chadtclassplatformtdstd;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class ChAdtClassplatformtdstdCheck extends BaseCheckFormat {
	public ChAdtClassplatformtdstdCheck() {
		// TODO Auto-generated constructor stub
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("","要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	public void checkLine(String line, int rowCount, User user) throws Exception {
		String[] content =StringUtils.splitPreserveAllTokens(line, "|");
		
		if (content.length != 7) {
			throw new Exception("上传数据列数不对,应为6列,请查看说明帮助!");
		}
		
		
		if(StringUtils.isEmpty(content[0])){
			throw new BusinessException("","BOSS商品ID不能为空");
		}
		if(StringUtils.isEmpty(content[1])){
			throw new BusinessException("","酬金类型不能为空");
		}
		if(StringUtils.isEmpty(content[2])){
			throw new BusinessException("","计酬标识不能为空");
		}
		
		if(StringUtils.isEmpty(content[5])){
			throw new BusinessException("","酬金标准不能为空");
		}
		
		//酬金类型
		if (content[1] != null && !"".equals(content[1])) {
			try {
				if(Short.parseShort(content[1]) != 1){
					if(Short.parseShort(content[1]) != 2){
						throw new Exception("酬金类型不对，正确为1或2");
					}					
				}
				
			} catch (Exception e) {
				throw new Exception("酬金类型不对，正确为1或2");
			}
		} else {
			throw new Exception("酬金类型不对，正确为1或2");
		}
		
		
		//计酬标识
		if (content[1] != null && !"".equals(content[1])) {
			try {
				if(Short.parseShort(content[1]) != 1){
					if(Short.parseShort(content[1]) != 2){
						throw new Exception("计酬标识不对，正确为1或2");
					}					
				}
			} catch (Exception e) {
				throw new Exception("计酬标识不对，正确为1或2");
			}
		} else {
			throw new Exception("计酬标识不对，正确为1或2");
		}

	}
	
	
}
