package com.sunrise.boss.ui.cms.waystrarewardstd;

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

public class WaystrarewardstdCheck extends BaseCheckFormat {
	public WaystrarewardstdCheck() {
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
			throw new BusinessException("","渠道编码不能为空");
		}
		if(StringUtils.isEmpty(content[1])){
			throw new BusinessException("","酬金标准不能为空");
		}
		if(StringUtils.isEmpty(content[2])){
			throw new BusinessException("","酬金类型不能为空");
		}
		if(StringUtils.isEmpty(content[3])){
			throw new BusinessException("","说明备注不能为空");
		}
		
		for (int i = 0; i < content.length-1; i++) {
			switch (i) {
			case 0:
				if (!CheckUtil.checkString(content[i], 20, true)) {
					throw new Exception("[渠道编码]不能大于18位");
				}
				break;
			case 1:
				if (!CheckUtil.checkDouble(content[i], 8, 2)) {
					throw new Exception("[酬金标准]整数部分不能超过8位,小数部分不能超过2位");
				}
				
				break;
			case 2:
				if (!CheckUtil.checkString(content[i], 2,true)) {
					throw new Exception("[酬金类型]不能大于2位");
				}
				break;
			case 3:
				if (!CheckUtil.checkString(content[i], 256,true)) {
					throw new Exception("[说明备注]不能超过256个字符");
				}
				break;
			
			
			}
		}
	}
	
	
}
