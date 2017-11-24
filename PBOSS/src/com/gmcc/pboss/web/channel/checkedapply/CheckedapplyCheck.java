package com.gmcc.pboss.web.channel.checkedapply;

import java.io.File;
import java.util.HashMap; 
import org.apache.commons.lang.StringUtils; 

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.sunrise.jop.ui.User;

public class CheckedapplyCheck extends BaseCheckFormat {
	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
		 
	}
	public void checkLine(String line, int rowCount, User user)throws Exception {

		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
//		if(("1").equals(content[2])){
	    if (content.length != 5) {
		   throw new Exception("[ " + line
				+ " ] ,列数不正确,正确列数为4");
	     } 
//		}else{
//			if(content.length != 4 && content.length != 5){
//			  throw new Exception("第" + rowCount + "行:[ " + line
//						+ " ] ,列数不正确,申请类型不为1时正确列数最多3列，调整内容非必填");	
//			} 
//		} 
		if (content[0]!=null && content[0].trim().equals("")) {
			throw new Exception("渠道编码不能为空");
		}
		if (content[1]!=null && content[1].trim().equals("")) {
			throw new Exception("考核方式不能为空");
		} else if (!("0").equals(content[1]) && !("1").equals(content[1])){
			throw new Exception("考核方式格式不对必须是0或者1");
		}
		if (content[2]!=null && content[2].trim().equals("")) {
			throw new Exception("申请类型不能为空");
		}else if(!("0").equals(content[2]) && !("1").equals(content[2])){
			throw new Exception("申请类型格式不对必须是0或者1");
		}
		if(("1").equals(content[2])){
		   if(content[3]!=null && content[3].trim().equals("")){
			   throw new Exception("申请类型为退出申请时，调整内容不能为空");	
			}else if(!("0").equals(content[3]) && !("1").equals(content[3])){
				throw new Exception("调整内容格式不对必须是0或者1");
			}
		} 
}

}
