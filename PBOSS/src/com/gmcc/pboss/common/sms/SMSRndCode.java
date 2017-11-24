package com.gmcc.pboss.common.sms;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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
	
	private static long LIMIT_TIME;/*����ʱ��*/
	private static int MIN_NUMBER;/*�������Ƹ���*/
	private static int MAX_NUMBER;/*�û������Է��͸���*/
	private static String SMS_MSG;
	public static String getSMS_MSG() {
		return SMS_MSG;
	}


	static{
		try{
			InputStream in = SMSRndCode.class.getResourceAsStream("/data/RandomSms.properties");
			Properties p = new Properties();
			p.load(in);
			in.close();
			LIMIT_TIME = Long.parseLong(p.getProperty("SMS_LIMIT_TIME"))*60*1000;
			MIN_NUMBER = Integer.parseInt(p.getProperty("SMS_MIN_NUM"));
			MAX_NUMBER = Integer.parseInt(p.getProperty("SMS_MAX_NUM"));
			SMS_MSG = p.getProperty("SMS_RND_MSG");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("��SMSRndCode���������ļ�[/data/RandomSms.properties]����ʹ�ó������趨��Ĭ��ֵ��");
			LIMIT_TIME = 600000;
			MIN_NUMBER = 3;
			MAX_NUMBER = 20;
			SMS_MSG = "�𾴵Ŀͻ���$Ϊ�����ε�½�㶫�ƶ�������Ӫ����ϵͳ(COMS)������������룬�й��㶫�ƶ���˾��";
		}
	}
	
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
//		/*����ʱ��*/
//		long LIMIT_TIME = Long.parseLong(ConfigUtil.getCommonConfig(FileDictionary.COMMON_NAME, CommonConfig.SMS_RND_LIMIT_TIME))*60*1000;
//		/*�������Ƹ���*/
//		int MIN_NUMBER = Integer.parseInt(ConfigUtil.getCommonConfig(FileDictionary.COMMON_NAME, CommonConfig.SMS_RND_MIN_NUM));
//		/*�û������Է��͸���*/
//		int MAX_NUMBER = Integer.parseInt(ConfigUtil.getCommonConfig(FileDictionary.COMMON_NAME, CommonConfig.SMS_RND_MAX_NUM));
		
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
