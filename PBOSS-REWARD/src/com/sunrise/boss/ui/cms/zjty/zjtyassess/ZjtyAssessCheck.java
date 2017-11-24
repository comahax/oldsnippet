package com.sunrise.boss.ui.cms.zjty.zjtyassess;

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

public class ZjtyAssessCheck extends BaseCheckFormat {
	public ZjtyAssessCheck() {
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
			throw new BusinessException("","渠道编码不能为空");
		}
		if(StringUtils.isEmpty(content[1])){
			throw new BusinessException("","计酬月份标识不能为空");
		}
		
		// 结算月份
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMM");
		for (int i = 0; i < content.length-1; i++) {
			switch (i) {
			case 0:
				if (!CheckUtil.checkString(content[i], 32, true)) {
					throw new Exception("[渠道编码]不能大于32位");
				}
				break;
			case 1:
				if (content[i].trim().length() != 6){
					throw new Exception("[计酬月份]长度必须为6位.");
				}
				String regex = "^([1-9]\\d{3}[0][1-9])|([1-9]\\d{3}[1][0-2])$";
				if (!content[i].matches(regex)) {
					throw new BusinessException("", "[计酬月份]不合法,月份范围应为[01-12]!");
				}
				try {
					sf.parse(content[i]);
				} catch (Exception pe) {
					throw new Exception("[计酬月份]格式不对,应为yyyyMM");
				}
				break;
			case 2:
//				int pos5 = content[5].trim().indexOf(".");
//				if (pos5 == -1) { 
//					if (content[5].trim().length() > 5)
//						throw new Exception("统一售价：数字类型，支持两位小数，整数位最大长度5位，小数位最大长度2位，要求大于等于0");
//				} else if (pos5 > 5) {
//					    throw new Exception("统一售价：数字类型，支持两位小数，整数位最大长度5位，小数位最大长度2位，要求大于等于0");
//				} else if (content[5].substring(pos5+1,content[5].length()).length()>2){
//					    throw new Exception("统一售价：数字类型，支持两位小数，整数位最大长度5位，小数位最大长度2位，要求大于等于0");
//				}
				if(StringUtils.isNotEmpty(content[i])){
//					if(content[i].trim().indexOf(".") == -1 && content[i].trim().length() > 1){
//						throw new Exception("[管理考核系数]整数部分不能超过1位");
//					}
					if (!CheckUtil.checkDouble(content[i], 1, 2)||((content[i].trim().indexOf(".") == -1 && content[i].trim().length() > 1))) {
						throw new Exception("[管理考核系数]整数部分不能超过1位,小数部分不能超过2位");
					}
				}
				break;
			case 3:
				if(StringUtils.isNotEmpty(content[i])){
					if (!CheckUtil.checkDouble(content[i], 1, 2)||((content[i].trim().indexOf(".") == -1 && content[i].trim().length() > 1))) {
						throw new Exception("[综合排名系数]整数部分不能超过1位,小数部分不能超过2位");
					}
				}
				break;
			case 4:
				if(StringUtils.isNotEmpty(content[i])){
					if (!CheckUtil.checkDouble(content[i], 1, 2)||((content[i].trim().indexOf(".") == -1 && content[i].trim().length() > 1))) {
						throw new Exception("[否决系数]整数部分不能超过1位,小数部分不能超过2位");
					}
				}
				break;
			case 5:
				if(StringUtils.isNotEmpty(content[i])){
					if(!CheckUtil.checkNum(content[i], 6) || Integer.parseInt(content[i])<0){
							throw new Exception("[人员数量]大于等于零的整数,且不能超过6位");
					}
				}
				break;
//			case 2:
//				if (!CheckUtil.checkDouble(content[i], 1, 1)) {
//					throw new Exception("[映射类型]整数部分不能超过1位,小数部分不能超过1位,且不能为空");
//				}
//				break;
			
			}
		}
	}
	
	
}
