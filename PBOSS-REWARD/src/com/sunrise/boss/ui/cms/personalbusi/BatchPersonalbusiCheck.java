package com.sunrise.boss.ui.cms.personalbusi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class BatchPersonalbusiCheck extends BaseCheckFormat {
	public BatchPersonalbusiCheck() {
		super();
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
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
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		// 检查列数
		if (items.length != 7) {
			throw new Exception("上传数据列数不对,应为6列,请查看说明帮助!");
		}
		String[] columns = { "[号码]", "[渠道编码]", "[业务分类信息编码]", "[品牌]", "[办理时间]", "[操作类型]","[处理类型]" };
		for (int i = 0; i < items.length - 1; i++) {
			if ("".equals(items[i].trim()) || items[i] == null) {
				throw new Exception(columns[i] + "不能为空");
			}
		}
		try { // 
			if (!"".equals(items[0].trim())) {
				new Long(items[0].trim());
				if (items[0].trim().length() != 11) {
					throw new Exception("[号码]应该为11位数字");
				}
			}
		} catch (Exception e) {
			throw new Exception("[号码]应该为11位数字");
		}
		if (items[1].trim().length() > 18)
			throw new Exception("[渠道编码]长度不能大于18位");
		if (items[2].trim().length() > 18) {
			throw new Exception("[业务分类信息编码]不能大于18位");
		}
		try { //  
			new Integer(items[3].trim());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("[品牌]类型不对(" + items[3] + "),应该是整型数字!");
		}
		try { //  
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			df.parse(items[4].trim());
		} catch (Exception e) {
			throw new Exception("[办理时间]类型不对[" + items[4]
					+ "],应该是[yyyy-MM-dd HH:mm:ss]型!");
		}
		if(items[5].trim().length()>1)
		{
			throw new Exception("[操作类型]长度不对[" + items[5]
			                      					+ "],应该是1位");
		}
		if (!items[3].trim().matches("[123]")){
			throw new Exception("[品牌]格式不对:取值应是:1(全球通)2(神州行)3(动感地带)之一");
		}
		if(!items[5].trim().matches("[IUD]")){
			throw new Exception("[操作类型]格式不对:取值应是:I(新增)U(修改)D(删除或取消)之一");
		}
	}
}
