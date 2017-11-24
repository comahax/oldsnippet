package com.sunrise.boss.ui.cms.reward.disintegral;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.pub.tools.StringSplit;


public class DisintegralBatchCheck extends BaseCheckFormat {

	public DisintegralBatchCheck() {
		super();
	}
	
	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!file.getContentType().equals("text/plain")||(file.getFileName().substring(file.getFileName().length()-3, file.getFileName().length())).equals("sql")) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	/**
	 * 文件行的内容检查
	 */
	public void checkLine(String line, int rowCount, User user) throws Exception {

		if (rowCount > 10000) {
			throw new Exception("文件行数不能超过10000行");
		}
		if (null == line || "".equals(line.trim())) {
			return;
		}

		String[] items = StringSplit.split(line,"|");

		// 检查列数
		if (items.length != 4) {
			throw new Exception("上传数据列数不对,应为4列,请查看说明帮助!");
		}
		
		if (StringUtils.isEmpty(items[0])) {
			throw new BusinessException("", "第1列【合作商编码】不能为空!");
		}
		
		if (items[0].length()>18){
			throw new BusinessException("", "第1列【合作商编码】长度不能超过18位!");
		}
		if (StringUtils.isEmpty(items[1])) {
			throw new BusinessException("", "第2列【结算月份】不能为空!");
		}
		if (!NumberUtils.isNumber(items[1])) {
			throw new BusinessException("", "第2列【结算月份】必须为数字");
		}
		if (!checkDate(items[1])) {
			throw new BusinessException("", "第2列【结算月份】必须为YYYYMM格式且长度为6位");
		}
		if (StringUtils.isEmpty(items[2])) {
			throw new BusinessException("", "第3列【积分类型】不能为空!");
		}
		if (!items[2].matches("[0,1]{1}")) {
			throw new Exception("第3列【积分类型】只能为0或1,请查看补充说明");
		}
		if (StringUtils.isEmpty(items[3])) {
			throw new BusinessException("", "第4列【积分】不能为空!");
		}
		if (!NumberUtils.isNumber(items[3])) {
			throw new BusinessException("", "第4列【积分】必须为数字");
		}
	}

	public static boolean checkDate(String date) {
		boolean ret = true;
		if (date.length() != 6)
			return false;
		try {
			SimpleDateFormat sd = new SimpleDateFormat("yyyyMM");
			sd.parse(date);
		} catch (Exception e) {
			return false;
		}
		return ret;
	}

	public static void main(String[] args) {

		DisintegralBatchCheck check = new DisintegralBatchCheck();

	}
}
