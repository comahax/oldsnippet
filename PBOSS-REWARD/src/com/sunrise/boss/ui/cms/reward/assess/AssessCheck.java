package com.sunrise.boss.ui.cms.reward.assess;

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

public class AssessCheck extends BaseCheckFormat {
	public AssessCheck() {
		// TODO Auto-generated constructor stub
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
			throw new BusinessException("","渠道编码不能为空");
		}
		if(StringUtils.isEmpty(content[1])){
			throw new BusinessException("","考核类型不能为空");
		}
		if(StringUtils.isEmpty(content[2])){
			throw new BusinessException("","考核值不能为空");
		}
		if(StringUtils.isEmpty(content[3])){
			throw new BusinessException("","考核月份不能为空");
		}
//		if(StringUtils.isEmpty(content[4])){
//			throw new BusinessException("","说明备注不能为空");
//		}
		
		// 结算月份
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMM");
		for (int i = 0; i < content.length-1; i++) {
			switch (i) {
			case 0:
				if (!CheckUtil.checkString(content[i], 20, true)) {
					throw new Exception("[渠道编码]不能大于20位");
				}
				break;
			case 1:
				if (!CheckUtil.checkNum(content[i])) {
					throw new Exception("[考核类型]必须为数字类型");
				}
				break;
			case 2:
				if (!CheckUtil.checkDouble(content[i], 8, 2)) {
					throw new Exception("[考核值]整数部分不能超过8位,小数部分不能超过2位");
				}
				// 登录的工号是茂名市公司(668)的工号时
//				if ("668".equals(user.getCityid())) {
//					Double dble = new Double("80.00");
//					Double kvalue = new Double(content[i].trim());
//					if (Double.compare(kvalue, dble) > 0) {
//						throw new Exception("[考核值]不能大于80");
//					}
//				}
				break;
			case 3:
				if (content[i].trim().length() != 6){
					throw new Exception("[办理时间]长度必须为6位.");
				}
				String regex = "^([1-9]\\d{3}[0][1-9])|([1-9]\\d{3}[1][0-2])$";
				if (!content[i].matches(regex)) {
					throw new BusinessException("", "[办理时间]不合法,月份范围应为[01-12]!");
				}
				try {
					sf.parse(content[i]);
				} catch (Exception pe) {
					throw new Exception("[办理时间]格式不对,应为yyyyMM");
				}
				break;
			case 4:
				if(!StringUtils.isEmpty(content[4])){
					if (!CheckUtil.checkString(content[i], 256,true)) {
						throw new Exception("[说明备注]不能超过256个字符");
					}
				}
				break;
			
			
			}
		}
	}
	
	
}
