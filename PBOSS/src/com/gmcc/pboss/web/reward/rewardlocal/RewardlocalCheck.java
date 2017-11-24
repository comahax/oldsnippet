package com.gmcc.pboss.web.reward.rewardlocal;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;

public class RewardlocalCheck extends BaseCheckFormat{

	private String rewardmonth;
	private String rpttype;
	public void checkFile(File file, HashMap parameterMap, String contentType)
	throws Exception {
	if (!"text/plain".equalsIgnoreCase(contentType)) {
		throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	rewardmonth = (String)parameterMap.get("rewardmonth");
	rpttype = (String)parameterMap.get("rpttype");
	}

	@Override
	public void checkLine(String line, int rowCount) throws Exception {
		// TODO Auto-generated method stub
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		if("RPWDLocalRPT".equals(rpttype)){
			if(rowCount>1 ){
				if(items.length< 3 || items[0].trim().length() == 0)
					throw new Exception("您选择的文件格式有误：数据必需>=3项并且第一项不能为空，各项中间用\"|\"分开");
			}
		}else{
			if(items.length<=6)
				throw new Exception("您选择的文件格式有误：数据必需>=7项，各项中间用\"|\"分开");
//			if(rowCount>1){
//				if(items[5].trim().length() >0){
//					if(!items[5].trim().matches("\\d{1,2}")){
//						throw new Exception("星级必需是1或2位的数字");
//					}
//				}
//			}		
		}				
	}
	
	
}
