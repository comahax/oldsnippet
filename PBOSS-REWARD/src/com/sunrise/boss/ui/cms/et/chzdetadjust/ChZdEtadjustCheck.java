package com.sunrise.boss.ui.cms.et.chzdetadjust;

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

public class ChZdEtadjustCheck extends BaseCheckFormat {
	public ChZdEtadjustCheck() {
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
			throw new BusinessException("","平台商不能为空");
		}
		if(StringUtils.isEmpty(content[2])){
			throw new BusinessException("","终端型号不能为空");
		}
		if(StringUtils.isEmpty(content[3])){
			throw new BusinessException("","上期差异金额不能为空");
		}
		if(StringUtils.isEmpty(content[4])){
			throw new BusinessException("","调整生效批次不能为空");
		}
		
		// 结算月份
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMDD");
		for (int i = 0; i < content.length-1; i++) {
			switch (i) {
			case 0:
				if (!CheckUtil.checkString(content[i], 32, true)) {
					throw new Exception("[渠道编码]不能大于32位");
				}
				break;
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				if(StringUtils.isNotEmpty(content[i])){
					if (!CheckUtil.checkDouble(content[i], 10, 2)||((content[i].trim().indexOf(".") == -1 && content[i].trim().length() > 1))) {
						throw new Exception("[上期差异金额]整数部分不能超过10位,小数部分不能超过2位");
					}
				}
				break;
			case 4:
				if (content[i].trim().length() != 8){
					throw new Exception("[调整生效批次]长度必须为8位.");
				}
				String regex = "^([1-9]\\d{3}[0][1-9]([0][1]|[1][6]))|([1-9]\\d{3}[1][0-2]([0][1]|[1][6]))$";
				if (!content[i].matches(regex)) {
					throw new BusinessException("", "[调整生效批次]不合法,月份范围应为[01-12],限定最后两位为01或者16!");
				}
				try {
					sf.parse(content[i]);
				} catch (Exception pe) {
					throw new Exception("[调整生效批次]格式不对,应为yyyyMMDD");
				}
				break;
			case 5:
				
				break;

			
			}
		}
	}
	
	
}
