package com.sunrise.boss.ui.cms.zjty.zjtybusyxplan;

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

public class ZjtyBusyxplanCheck extends BaseCheckFormat {
	public ZjtyBusyxplanCheck() {
		// TODO Auto-generated constructor stub
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
			throw new BusinessException("","业务编码不能为空");
		}
		if(StringUtils.isEmpty(content[1])){
			throw new BusinessException("","映射类型不能为空");
		}
		if(StringUtils.isEmpty(content[2])){
			throw new BusinessException("","产品编码不能为空");
		}
		
		// 结算月份
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMM");
		for (int i = 0; i < content.length-1; i++) {
			switch (i) {
			case 0:
				if (!CheckUtil.checkString(content[i], 18, true)) {
					throw new Exception("[业务编码]不能大于18位");
				}
				break;
			case 1:
				if (!CheckUtil.checkString(content[i], 32,true)) {
					throw new Exception("[映射类型]不能大于32位");
				}
				break;
			case 2:
				if (!CheckUtil.checkString(content[i], 32,true)) {
					throw new Exception("[产品编码]不能大于32位");
				}
				break;
			case 3:
				if (!"".equals(content[i].trim()) && !CheckUtil.checkDouble(content[i], 8, 2)) {
					throw new Exception("[套餐值]最大只能8位整数，2位小数");
				}
				break;
			}
		}
	}
	
	
}
