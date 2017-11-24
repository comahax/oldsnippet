package com.gmcc.pboss.common.bean;

import java.util.ArrayList;
import java.util.List;

import com.gmcc.pboss.common.config.ConfigUtil;
import com.gmcc.pboss.common.dictionary.CommonConfig;
import com.gmcc.pboss.common.dictionary.FileDictionary;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-9-11
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ���������������֤��
 */
public class SMSRndCode {
	
	/**���ŷ��ͽ�ֹ��10�����ڳ���3��*/
	public static final String FORBIDDEN = "FORBIDDEN";
	/**���ŷ���ͨ����10������С��3���������10����*/
	public static final String PASS = "PASS";
	
	/**���ܺ���*/
	private String mobile;
	/**����ʱ��*/
	private long buildTime;
	/**����뼯��*/
	private List<String> codeList;
	
	
	public SMSRndCode(String mobile) {
		this.mobile = mobile;
		this.buildTime = System.currentTimeMillis();
	}


	/**
	 * �������֤�����List�С�
	 * ���ʱ����<= 10min ���ֻ�ܷ���3������롣
	 * ���ʱ���� > 10min ���ֻ�ܷ���20������롣
	 * @param rndCode
	 */
	public String addRndCode(String rndCode){
		if(codeList == null){
			codeList = new ArrayList<String>();
		}
		/*����ʱ��*/
		long LIMIT_TIME = Long.parseLong(ConfigUtil.getCommonConfig(FileDictionary.COMMON_NAME, CommonConfig.SMS_RND_LIMIT_TIME))*60*1000;
		/*�������Ƹ���*/
		int MIN_NUMBER = Integer.parseInt(ConfigUtil.getCommonConfig(FileDictionary.COMMON_NAME, CommonConfig.SMS_RND_MIN_NUM));
		/*�û������Է��͸���*/
		int MAX_NUMBER = Integer.parseInt(ConfigUtil.getCommonConfig(FileDictionary.COMMON_NAME, CommonConfig.SMS_RND_MAX_NUM));
		
		long now = System.currentTimeMillis();
		if(((now - buildTime) <= LIMIT_TIME && codeList.size() < MIN_NUMBER ) 
		|| ((now - buildTime) > LIMIT_TIME) && codeList.size() < MAX_NUMBER ){
			codeList.add(rndCode);
			return PASS;
		}
		else{
			return FORBIDDEN;
		}
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public List<String> getCodeList() {
		return codeList;
	}
	
	
}
