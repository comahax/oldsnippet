package com.sunrise.boss.ui.zifee.yxplangroup;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;



public class YxplanGroupCheck extends BaseCheckFormat {
	
	private String type=null;
	
	public YxplanGroupCheck(String type) {
		super();
		this.type=type;
	}
 
	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}
	
	/**
	 * 文件行的内容检查
	 */
	public void checkLine(String line, int rowCount) throws Exception {

		if (rowCount > 10000) {
			throw new Exception("文件行数不能超过10000行");
		}
		if (null == line || "".equals(line)) {
			return;
		}
		String[] items = StringUtils.split(line,"|");
		
		if(this.type.equals("ADD")||this.type.equals("DELETE")){
//			 检查列数
			if (items.length != 2) {
				throw new Exception("上传数据列数不对,应为2列,请查看说明帮助!");
			}
			for (int i=0;i<items.length;i++){
				switch(i){
				case 0:
					if (!items[i].matches("[0-9]{1,14}")){
						throw new Exception("[营销方案组标识]出错，必须为数字");
					}
					break;
				
				//营销方案标识1
				case 1:
					if (!items[i].matches("[0-9]{14}")){
						throw new Exception("[营销方案标识]出错，必须为14位数字");
					}
				break;
				}
			}
		}else if(this.type.equals("QUERY_GROUP")){
//			 检查列数
			if(!line.endsWith("|")){
				throw new Exception("上传数据列数不对,应为1列,并以‘|’结尾,请查看说明帮助!");
			}
			if (items.length != 1) {
				throw new Exception("上传数据列数不对,应为1列,请查看说明帮助!");
			}
			if (!items[0].matches("[0-9]{1,14}")){
				throw new Exception("[营销方案组标识]出错，必须为数字");
			}
		}else if(this.type.equals("QUERY_MEM")){
//			 检查列数
			if(!line.endsWith("|")){
				throw new Exception("上传数据列数不对,应为1列,并以‘|’结尾,请查看说明帮助!");
			}
			if (items.length != 1) {
				throw new Exception("上传数据列数不对,应为1列,请查看说明帮助!");
			}
			if (!items[0].matches("[0-9]{1,14}")){
				throw new Exception("[营销方案标识]出错，必须为数字");
			}
		}else if(this.type.equals("QUERY_ALL")){
			
		}
	}
}
