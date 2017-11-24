package com.sunrise.boss.ui.zifee.yxplansplitbatch;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.pub.tools.PublicUtils;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;



public class YxPlanSplitBatchCheck extends BaseCheckFormat {

	public YxPlanSplitBatchCheck() {
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
		String[] items = line.split("\\|");		
		// 检查列数
		if ( items.length != 5) {
			throw new Exception("上传数据列数不对,应为5列,请查看说明帮助!");
		}
		// 检查位数
		if (items[0].length() != 8) {
			throw new Exception("帐务周期不对，应该为8位数字!");
		}		

		// 检查类型
		try {
			Long temp = Long.valueOf(items[0]);
		} catch (Exception e) {
			throw new Exception("上传数据的帐务周期数据类型不对(" + items[0] + "),应该是数字字符串!");
		}
		//品牌标识
		if(!PublicUtils.isInteger(items[1])){
			if(!items[1].trim().startsWith("Brand"))
			{
				throw new Exception("上传数据的品牌标识数据类型不对(" + items[1] + "),应该是数字字符串或者以Brand开头的字符串!");
			}
		}		
		/*
		try { // 检查items[2]是否为数字
			Long temp = Long.valueOf(items[2]);
		} catch (Exception e) {
			throw new Exception("上传数据的费项标识数据类型不对(" + items[2] + "),应该是数字字符串!");
		}*/
		
		try { // 检查items[2]是否为正数[语音基本通话月使用费]
			Double temp = Double.valueOf(items[2]);
			
			if(temp.doubleValue() <= 0)throw new Exception("上传数据的第3列[语音基本通话月使用费]金额类型不对(" + items[2] + "),应该是数字字符串，并且是正数!");		
		
		} catch (Exception e) {
			throw new Exception("上传数据的第3列[语音基本通话月使用费]金额类型不对(" + items[2] + "),应该是数字字符串!");
		}
		try { // 检查items[2]是否为合法
						
			if(!(checkAmtFormat(items[2],14))) throw new Exception("上传数据的第3列[语音基本通话月使用费]金额格式不对(" + items[2] + "),整数部分最多14位，小数部分一定是2位!"); 
			
		} catch (Exception e) {
			throw new Exception("上传数据的第3列[语音基本通话月使用费]金额格式不对(" + items[2] + "),整数部分最多14位，小数部分一定是2位!"); 
		}
		try { // 检查items[3]是否为正数[语音漫游通话月使用费]
			Double temp = Double.valueOf(items[3]);
			
			if(temp.doubleValue() <= 0)throw new Exception("上传数据的第4列[语音漫游通话月使用费]金额类型不对(" + items[3] + "),应该是数字字符串，并且是正数!");		
		
		} catch (Exception e) {
			throw new Exception("上传数据的第4列[语音漫游通话月使用费]金额类型不对(" + items[3] + "),应该是数字字符串!");
		}
		try { // 检查items[3]是否为合法
						
			if(!(checkAmtFormat(items[3],14))) throw new Exception("上传数据的第4列[语音漫游通话月使用费]金额格式不对(" + items[3] + "),整数部分最多14位，小数部分一定是2位!"); 
			
		} catch (Exception e) {
			throw new Exception("上传数据的第4列[语音漫游通话月使用费]金额格式不对(" + items[3] + "),整数部分最多14位，小数部分一定是2位!"); 
		}
		try { // 检查items[4]是否为正数第5列[语音长途通话月使用费]
			Double temp = Double.valueOf(items[4]);
			
			if(temp.doubleValue() <= 0)throw new Exception("上传数据的第5列[语音长途通话月使用费]金额类型不对(" + items[4] + "),应该是数字字符串，并且是正数!");		
		
		} catch (Exception e) {
			throw new Exception("上传数据的第5列[语音长途通话月使用费]金额类型不对(" + items[4] + "),应该是数字字符串!");
		}
		try { // 检查items[1]是否为合法
						
			if(!(checkAmtFormat(items[4],14))) throw new Exception("上传数据的第5列[语音长途通话月使用费]金额格式不对(" + items[4] + "),整数部分最多14位，小数部分一定是2位!"); 
			
		} catch (Exception e) {
			throw new Exception("上传数据的第5列[语音长途通话月使用费]金额格式不对(" + items[4] + "),整数部分最多14位，小数部分一定是2位!"); 
		}
	}
	public boolean checkAmtFormat(String amt,int length){
		amt=amt.trim();
		if(amt.indexOf(".")!=-1){
			if(amt.indexOf(".")==0) return false;
			if(amt.indexOf(".")>length) return false;
			if((amt.length()-amt.indexOf("."))!=3) return false;
		}else{
			if(amt.length()>length) return false;
		}
		return true;
	}
	

	public static void main(String[] args) {
			
		YxPlanSplitBatchCheck check = new YxPlanSplitBatchCheck();
		
	}
}
