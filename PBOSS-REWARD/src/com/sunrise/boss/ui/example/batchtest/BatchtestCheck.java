package com.sunrise.boss.ui.example.batchtest;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.boss.ui.commons.batch.upload.ICheckFormat;

/**
 * 继承BaseCheckFormat或者实现ICheckFormat接口
 * @author liminghao
 */
public class BatchtestCheck extends BaseCheckFormat {
	public BatchtestCheck() {
		super();
	}

	public void checkFile(FormFile file,HashMap parameterMap) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	    if(null==parameterMap.get("oprtype")){
		      throw new Exception("请输入操作类型!");	
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
		if (items.length != 3) {
			throw new Exception("上传数据列数不对,应为3列,请查看说明帮助!");
		}
		// 检查位数
		if (items[0].length() != 11) {
			throw new Exception("号码位数不对，应该为11位的号码!");
		}

		// 检查类型
		try { // 检查items[0]是否为数字
			Long temp1 = Long.valueOf(items[0]);
		} catch (Exception e1) {
			throw new Exception("上传数据的号码数据类型不对(" + items[0] + "),应该是数字字符串!");
		}
		// 检查类型
		try { // 检查items[2]是否为数字
			Short temp = Short.valueOf(items[2]);
			if (temp.shortValue() != 0 && temp.shortValue() != 1) {
				throw new Exception("上传数据的状态不对,(" + items[2] + ")应为0或1");
			}
		} catch (Exception e1) {
			throw new Exception("上传数据的状态不对,(" + items[2] + ")应为0或1");
		}
	}
}