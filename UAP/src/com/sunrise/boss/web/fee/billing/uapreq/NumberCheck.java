package com.sunrise.boss.web.fee.billing.uapreq;

import com.sunrise.boss.web.common.batch.upload.BaseCheckFormat;
import com.sunrise.boss.web.common.batch.upload.FormFile;

/**
 * 继承BaseCheckFormat或者实现ICheckFormat接口
 * 
 * @author panmeifa
 */
public class NumberCheck extends BaseCheckFormat {
	public NumberCheck() {
		super();
	}
	
	public void checkFile(FormFile file) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	public void checkLine(String line, int rowCount) throws Exception {
		if (rowCount > 10000) {
			throw new Exception("文件行数不能超过10000行");
		}
		if (null == line || "".equals(line)) {
			return;
		}
		String[] items = line.split("\\|");
		// 检查列数
		if (items.length != 1) {
			throw new Exception("上传数据列数不对,应为1列,请查看说明帮助!");
		}
		try { // 检查items[0]是否为数字
			Long temp1 = Long.valueOf(items[0]);
		} catch (Exception e1) {
			throw new Exception("上传数据中号码的数据类型不对(" + items[0] + "),应该是数字字符串!");
		}
		if(items[0].length()!=11) {
			throw new Exception("上传数据中号码的长度不对(" + items[0] + "),应该是11位数字!");
		}
	
	}
}
