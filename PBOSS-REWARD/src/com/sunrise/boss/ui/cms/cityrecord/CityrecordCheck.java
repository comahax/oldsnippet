package com.sunrise.boss.ui.cms.cityrecord;

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

public class CityrecordCheck extends BaseCheckFormat {
	public CityrecordCheck() {
		// TODO Auto-generated constructor stub
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("","要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	public void checkLine(String line, int rowCount, User user) throws Exception {
		String[] content =StringUtils.splitPreserveAllTokens(line, "|");
		
		if (content.length != 11) {
			throw new Exception("上传数据列数不对,应为10列,请查看说明帮助!");
		}
		if(StringUtils.isEmpty(content[0])){
			throw new BusinessException("","渠道编码不能为空");
		}
		if(StringUtils.isEmpty(content[1])){
			throw new BusinessException("","业务编码不能为空");
		}
		if(StringUtils.isEmpty(content[2])){
			throw new BusinessException("","酬金期数不能为空");
		}
		if(StringUtils.isEmpty(content[4])){
			throw new BusinessException("","结算月份不能为空");
		}
		if(StringUtils.isEmpty(content[5])){
			throw new BusinessException("","业务发生时间不能为空");
		}
		if(StringUtils.isEmpty(content[6])){
			throw new BusinessException("","业务量或业务发生金额不能为空");
		}
		if(StringUtils.isEmpty(content[7])){
			throw new BusinessException("","应发酬金合计不能为空");
		}
		if(StringUtils.isEmpty(content[8])){
			throw new BusinessException("","本期应发酬金不能为空");
		}
		if(StringUtils.isEmpty(content[9])){
			throw new BusinessException("","审批编码不能为空");
		}
		
		for (int i = 0; i < content.length-1; i++) {
			switch (i) {
			case 0:
				if (!CheckUtil.checkString(content[i], 18, true)) {
					throw new Exception("[渠道编码]不能大于18位");
				}
				break;
			case 1:
				if (!CheckUtil.checkString(content[i], 18, true)) {
					throw new Exception("[业务编码]不能大于18位");
				}
				
				break;
			case 2:
				if (!CheckUtil.checkString(content[i], 3,true)) {
					throw new Exception("[酬金期数]不能大于3位");
				}
				break;
			case 3:
				if (!CheckUtil.checkString(content[i], 32,true)) {
					throw new Exception("[手机号码或IMEI号]不能超过32个字符");
				}
				break;
			case 4:
				if (!CheckUtil.checkString(content[i], 6,true)) {
					throw new Exception("[结算月份]不能超过6个字符");
				}
				break;
			
			
			
			}
		}
	}
	
	
}
