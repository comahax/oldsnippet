package com.sunrise.boss.ui.cms.dktersalereward;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;
import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class DktersalerewardCheck extends BaseCheckFormat {

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("", "要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		if (null == line || "".equals(line)) {
			return;
		}
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 8) {
			throw new Exception("上传数据列数不对,应为7列");
		}
		if (StringUtils.isEmpty(content[0])) {
			throw new Exception("[月份]不能为空");
		}
		if (!checkDate(content[0])) {
			throw new Exception("[月份]日期格式不正确,格式应为yyyyMM,如:201301");
		}
		if (StringUtils.isNotEmpty(content[1]) && content[1].getBytes("GBK").length > 100) {
			throw new Exception("[ECP工号]长度最大为100");
		}
		if (StringUtils.isNotEmpty(content[2]) && content[2].getBytes("GBK").length > 256) {
			throw new Exception("[网点名称]长度最大为256");
		}
		if (StringUtils.isNotEmpty(content[3]) && !CheckUtil.checkNum(content[3], 14)) {
			throw new Exception("[销售成功量(T-1销售)]必需为整数,且长度不能大于14");
		}
		if (StringUtils.isNotEmpty(content[4]) && !CheckUtil.checkNum(content[4], 14)) {
			throw new Exception("[考核成功量(T-4销售)]必需为整数,且长度不能大于14");
		}
		if (StringUtils.isNotEmpty(content[5]) && !CheckUtil.checkDouble(content[5], 12, 2)) {
			throw new Exception("[基础酬金]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
		}
		if (StringUtils.isNotEmpty(content[6]) && !CheckUtil.checkDouble(content[6], 12, 2)) {
			throw new Exception("[考核酬金]必需为数字，并且整数部分不能超过12位,小数部分不能超过2位");
		}
	}

	private boolean checkDate(String date) {
		if (date.trim().length() != 6) {
			return false;
		}
		try {
			int year = Integer.parseInt(date.substring(0, 4));
			int month = Integer.parseInt(date.substring(4));
			if (year < 1000 || year > 9999) {
				return false;
			} else if (month < 1 || month > 12) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
