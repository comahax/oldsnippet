package com.gmcc.pboss.web.sales.disformintervaltime;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.sunrise.jop.ui.User;

public class DisformintervaltimeImportCheck extends BaseCheckFormat {
	
	//配送单配送时限设置批量上传
	
	public void checkFile(File file, HashMap parameterMap, String contentType)throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}
	
	public void checkLine(String line, int rowCount, User user)	throws Exception {
		// TODO Auto-generated method stub
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length!=5) {
			throw new Exception("上传的数据格式不正确,请查看补充说明!");
		}
		if(content[0].equals("")){
			throw new Exception("分公司编码不能为空！");
		}
		
		if(content[1].equals("")){
			throw new Exception("微区域编码不能为空!");
		}
		
		if(content[2].equals("")){
			throw new Exception("星级不能为空！");
		}else{
			try{
				int starleve = Integer.parseInt(content[2]);
				if(starleve<0 || starleve>6){
					throw new Exception("星级必须是0到6之间的数字！");
				}
			}catch(Exception e){
				throw new Exception("星级必须是0到6之间的数字！");
			}
		}
		
		if(content[3].equals("")){
			throw new Exception("配送时限不能为空！");
		}else{
			try{
				int interval = Integer.parseInt(content[3]);
				if(interval<0){
					throw new Exception("配送时限不能为负数！");
				}
			}catch(Exception e){
				throw new Exception("配送时限必须为数字！");
			}
		}
	}
}
