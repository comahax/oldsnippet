package com.sunrise.boss.ui.cms.chadtclassplatformtdinfo;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class ChAdtClassplatformtdinfoCheck extends BaseCheckFormat {
	public ChAdtClassplatformtdinfoCheck() {
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
			throw new BusinessException("","终端品牌ID不能为空");
		}
		if(StringUtils.isEmpty(content[2])){
			throw new BusinessException("","BOSS商品ID不能为空");
		}
		if(StringUtils.isEmpty(content[3])){
			throw new BusinessException("","合作期开始时间不能为空");
		}
		if(StringUtils.isEmpty(content[4])){
			throw new BusinessException("","合作期结束时间不能为空");
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		// 合作期开始时间
		if (content[3] != null && !"".equals(content[3])) {
			try {
				format.parse(content[3]);
			} catch (Exception e) {
				throw new Exception("合作期开始时间格式不对，正确格式为[yyyy-MM-dd]");
			}
		} else {
			throw new Exception("合作期开始时间不对，正确格式为[yyyy-MM-dd]");
		}
		
		//合作期结束时间
		if (content[4] != null && !"".equals(content[4])) {
			try {
				format.parse(content[4]);
			} catch (Exception e) {
				throw new Exception("合作期结束时间格式不对，正确格式为[yyyy-MM-dd]");
			}
		} else {
			throw new Exception("合作期结束时间不对，正确格式为[yyyy-MM-dd]");
		}
		
		
		if (!CheckUtil.checkString(content[5], 256,true)) {
			throw new Exception("[备注]不能超过256个字符");
		}
		
	
	}
	
	
}
