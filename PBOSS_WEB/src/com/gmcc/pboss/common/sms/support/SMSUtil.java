package com.gmcc.pboss.common.sms.support;

import com.gmcc.pboss.common.config.FileConfigAdapter;
import com.gmcc.pboss.common.dictionary.Regex;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-11-25
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ������
 */
public class SMSUtil {
	/**
	 * ���SMProxy�����ļ�·��
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
