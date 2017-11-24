package com.sunrise.boss.ui.cms.bbc.blacklist;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class BlacklistCheck extends BaseCheckFormat {

	public BlacklistCheck(){
		
	}
	
	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("","要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}
	
	public void checkLine(String line, int rowCount, User user) throws Exception {
		
		String[] content =StringUtils.splitPreserveAllTokens(line, "|");
		
		if (content.length != 6) {
			throw new Exception("上传数据列数不对,应为5列,请查看说明帮助!");
		}

		if(StringUtils.isEmpty(content[0])){
			throw new BusinessException("","业务名称不能为空");
		}
		if(StringUtils.isEmpty(content[1])){
			throw new BusinessException("","手机号码不能为空");
		}
		if(StringUtils.isEmpty(content[2])){
			throw new BusinessException("","过滤方式不能为空");
		}
		if(StringUtils.isEmpty(content[3])){
			throw new BusinessException("","启用时间不能为空");
		}
		if(StringUtils.isEmpty(content[4])){
			throw new BusinessException("","停用时间不能为空");
		}
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < content.length-1; i++) {
			switch (i) {
			case 0:
				if (!CheckUtil.checkString(content[i], 20, true)) {
					throw new Exception("[业务名称]不能大于20位");
				}
				break;
			case 1:
				if (!CheckUtil.checkString(content[i], 15, true)) {
					throw new Exception("[手机号码]不能大于15位");
				}
				break;
			case 2:
				if (!CheckUtil.checkString(content[i], 20, true)) {
					throw new Exception("[过滤方式]不能大于20位");
				}
				break;
			case 3:
				if (content[i].trim().length()!=10) {
					throw new Exception("[启用时间]长度必须为10位");
				}
				try {
					sf.parse(content[i]);
				} catch (Exception pe) {
					throw new Exception("[启用时间]格式不对,应为yyyy-MM-dd");
				}
				break;
			case 4:
				if (content[i].trim().length()!=10) {
					throw new Exception("[停用时间]长度必须为10位");
				}
				try {
					sf.parse(content[i]);
				} catch (Exception pe) {
					throw new Exception("[停用时间]格式不对,应为yyyy-MM-dd");
				}
				break;
			}
	}
	}
}
