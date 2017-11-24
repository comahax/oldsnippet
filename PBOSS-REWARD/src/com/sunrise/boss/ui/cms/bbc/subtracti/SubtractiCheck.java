package com.sunrise.boss.ui.cms.bbc.subtracti;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts.upload.FormFile;
import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class SubtractiCheck extends BaseCheckFormat {

	public SubtractiCheck(){
		
	}
	
	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("","要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}
	
	public void checkLine(String line, int rowCount, User user) throws Exception {
		
		String[] content =StringUtils.splitPreserveAllTokens(line, "|");
		
		if (content.length != 3) {
			throw new Exception("上传数据列数不对,应为2列,请查看说明帮助!");
		}
		if(StringUtils.isEmpty(content[0].trim())){
			throw new BusinessException("","分月支付酬金业务编码不能为空");
		}
		if(StringUtils.isEmpty(content[1])){
			throw new BusinessException("","计酬月份不能为空");
		}
		
		for (int i = 0; i < content.length-1; i++) {
			switch (i) {
			case 0:
				if (!CheckUtil.checkString(content[i], 18, true)) {
					throw new Exception("[分月支付酬金业务编码]不能大于18位");
				}
				break;
			case 1:
				if (!CheckUtil.checkString(content[i], 6,true)) {
					throw new Exception("[计酬月份]不能大于6位");
				}
				SimpleDateFormat format=new SimpleDateFormat("yyyyMM");
				format.setLenient(false);
				if(content[i].length() != 6){
					throw new BusinessException("", "[计酬月份]不合法,长度必须为6位!");
				}
				
				if(!NumberUtils.isNumber(content[i])){
					throw new BusinessException("", "[计酬月份]不合法,只能为数字!");
				}
					
				try {
					format.parse(content[i]);
				} catch (Exception e) {
					throw new BusinessException("", "[计酬月份]不合法,应为6位年月数字!");
				}
				String regex = "^([1-9]\\d{3}[0][1-9])|([1-9]\\d{3}[1][0-2])$";
				if (!content[i].matches(regex)) {
					throw new BusinessException("", "[计酬月份]不合法,月份范围应为[01-12]!");
				}
				break;
			}	
		}
	}
	
}
