package com.sunrise.boss.ui.cms.zjty.zjtyimportrec;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.pub.tools.StringSplit;

public class ZjtyImportrecCheck extends BaseCheckFormat {
	public ZjtyImportrecCheck() {
		// TODO Auto-generated constructor stub
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("","要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	public void checkLine(String line, int rowCount, User user) throws Exception {
		String[] content =StringUtils.splitPreserveAllTokens(line, "|");
		
		if (content.length != 8) {
			throw new Exception("上传数据列数不对,应为7列,请查看说明帮助!");
		}
		if(StringUtils.isEmpty(content[0])){
			throw new BusinessException("","结算月份");
		}
		if(StringUtils.isEmpty(content[1])){
			throw new BusinessException("","发生业务编码");
		}
		if(StringUtils.isEmpty(content[2])){
			throw new BusinessException("","业务发生渠道");
		}
		if(StringUtils.isEmpty(content[3])){
			throw new BusinessException("","业务发生时间");
		}
		
		// 结算月份
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMM");
		for (int i = 0; i < content.length-1; i++) {
			switch (i) {
			case 0:
				if (content[i].trim().length() != 6){
					throw new Exception("[结算月份]长度必须为6位.");
				}
				String regex = "^([1-9]\\d{3}[0][1-9])|([1-9]\\d{3}[1][0-2])$";
				if (!content[i].matches(regex)) {
					throw new BusinessException("", "[结算月份]不合法,月份范围应为[01-12]!");
				}
				try {
					sf.parse(content[i]);
				} catch (Exception pe) {
					throw new Exception("[结算月份]格式不对,应为yyyyMM");
				}
				break;
			case 1:
				if (!CheckUtil.checkString(content[i], 18,true)) {
					throw new Exception("[发生业务编码]不能大于18位");
				}
				break;
			case 2:
				if (!CheckUtil.checkString(content[i], 18,true)) {
					throw new Exception("[业务发生渠道]不能大于18位");
				}
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				if(content[i].trim().length() > 0 && content[i].trim().length() != 11){
					throw new Exception("[业务发生号码]长度必须为11位.");
				}
				break;
			case 6:
				break;
			case 7:
				break;
			
			}
		}
	}
	
	
}
