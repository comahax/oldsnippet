package com.gmcc.pboss.common.sms;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-9-11
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：随机短信验证码
 */
public class SMSRndCode {
	
	/**短信发送禁止：10分钟内超过3条*/
	public static final String FORBIDDEN = "FORBIDDEN";
	/**短信发送通过：10分钟内小于3条或则大于10分钟*/
	public static final String PASS = "PASS";
	
	private static long LIMIT_TIME;/*限制时间*/
	private static int MIN_NUMBER;/*最少限制个数*/
	private static int MAX_NUMBER;/*用户最多可以发送个数*/
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
			System.out.println("类SMSRndCode加载配置文件[/data/RandomSms.properties]出错，使用程序中设定的默认值。");
			LIMIT_TIME = 600000;
			MIN_NUMBER = 3;
			MAX_NUMBER = 20;
			SMS_MSG = "尊敬的客户，$为您本次登陆广东移动渠道运营管理系统(COMS)的随机短信密码，中国广东移动公司。";
		}
	}
	
	/**接受号码*/
	private String mobile;
	/**创建时间*/
	private long buildTime;
	/**随机码集合*/
	private List<String> codeList;
	
	
	public SMSRndCode(String mobile) {
		this.mobile = mobile;
		this.buildTime = System.currentTimeMillis();
	}


	/**
	 * 将随机验证码放入List中。
	 * 如果时间间隔<= 10min 最多只能发送3个随机码。
	 * 如果时间间隔 > 10min 最多只能发送20个随机码。
	 * @param rndCode
	 */
	public String addRndCode(String rndCode){
		if(codeList == null){
			codeList = new ArrayList<String>();
		}
//		/*限制时间*/
//		long LIMIT_TIME = Long.parseLong(ConfigUtil.getCommonConfig(FileDictionary.COMMON_NAME, CommonConfig.SMS_RND_LIMIT_TIME))*60*1000;
//		/*最少限制个数*/
//		int MIN_NUMBER = Integer.parseInt(ConfigUtil.getCommonConfig(FileDictionary.COMMON_NAME, CommonConfig.SMS_RND_MIN_NUM));
//		/*用户最多可以发送个数*/
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
