package com.gmcc.pboss.common.sms.support;

import com.gmcc.pboss.common.config.FileConfigAdapter;
import com.gmcc.pboss.common.dictionary.Regex;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-11-25
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：
 */
public class SMSUtil {
	/**
	 * 获得SMProxy配置文件路径
	 * @return
	 */
	public static String getSMProxyPath(){
		StringBuffer sb = new StringBuffer();
		
		String common = FileConfigAdapter.getCommonPath();
		sb.append(common);
		if(common.endsWith(Regex.SKEWLINE)){
			sb.append(Regex.SKEWLINE);
		}
		sb.append("SMProxy30.xml");
		return sb.toString();
	}
}
