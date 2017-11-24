package com.sunrise.boss.ui.cms.fee.bail;

import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;


public class BailBatchCheck extends BaseCheckFormat {

	public BailBatchCheck(){
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
		String[] items = StringUtils.split(line, "|");
		// 检查列数
		if (items.length != 8) {
			throw new Exception("上传数据列数不对,应为8列,请查看说明帮助!");
		}
		if (items[0].getBytes().length > 18)
			throw new Exception("[渠道代码]过长！必须不大于18");	
		if (items[1].getBytes().length == 0 || "0,1".indexOf(items[1])==-1)
			throw new Exception("[保证金类型]不正确！应为数字0或1，(0营业保证金,1其他保证金)");	

		try { // 检查items[2]是否为正数
			Double temp = Double.valueOf(items[2]);
			
			if(temp.doubleValue() <= 0)throw new Exception("[金额]不正确(" + items[2] + "),应该是数字字符串，并且是正数!");		
		
		} catch (Exception e) {
			throw new Exception("[金额]不正确(" + items[2] + "),应该是数字字符串，并且是正数!");
		}
		try { // 检查items[2]是否为合法
						
			if(!(checkAmtFormat(items[2],14))) throw new Exception("[金额]格式不对(" + items[2] + "),整数部分最多14位，小数部分一定是2位!"); 
			
		} catch (Exception e) {
			throw new Exception("[金额]格式不对(" + items[2] + "),整数部分最多14位，小数部分一定是2位!"); 
		}
		
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyyMMdd");		
		if(items[3].length()>0){
			try{
			  format.parse(items[3]);
			}catch (Exception e){
				throw new Exception("[缴纳日期]格式不正确，应该为yyyyMMdd");
			}
		}else{
			throw new Exception("[缴纳日期]正确，不能为空！");		
		}
		if (items[4].getBytes().length == 0 || "0,1,2,3,4".indexOf(items[1])==-1)
			throw new Exception("[保证金类型]不正确！应为数字以下其中一种类型0,1,2,3,4，(0收取,1追加,2扣款,3返销,4清退)");	
		
		if (items[5].getBytes().length == 0)
			throw new Exception("[收费员工工号]为空，应不为空");	
		if (items[5].getBytes().length > 15)
			throw new Exception("[收费员工工号]过长！必须不大于15");	
		if(items[6].length()>0){
			try{
			  format.parse(items[6]);
			}catch (Exception e){
				throw new Exception("[收费日期]格式不正确，应该为yyyyMMdd");
			}
		}else{
			throw new Exception("[收费日期]正确，不能为空！");		
		}
		if (items[7].getBytes().length > 255)
			throw new Exception("[备注]过长！必须不大于255");	
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
	

}
