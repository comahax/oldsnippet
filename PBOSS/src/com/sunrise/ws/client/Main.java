package com.sunrise.ws.client;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//获取测试数据
		InputStream in = com.huawei.boss.webservice.echannel.EChannelService.class.getResourceAsStream("/test-content.properties");
		Properties p = new Properties();
		p.load(in);
		in.close();
		//初始化参数
		String operator = (String)p.get("operator");
		String password = (String)p.get("password");
		String challengeValue = (String)p.get("challengeValue");
		String safewordMessage = (String)p.get("safewordMessage");
		String password2 = (String)p.get("password2");
		
		
		Login service = new Login();
		
		Result res2 = service.queryUserType(operator);
		Result res3 = service.simpAuth(operator, password); 
		
		Result res4 = service.secSand(operator);
		Result res5 = service.secAuth(operator, password);
		
		Result res6 = service.queryChallengeValue(operator);
		Result res7 = service.authChallengeValue(operator, challengeValue, safewordMessage);

		Result res8 = service.dynamicPassAuth(operator, password);
		Result res9 = service.dynamicExcursionAuth(operator, password, password2);
		
		//打印结果
		System.out.println(res2);
		System.out.println(res3);
		System.out.println(res4);
		System.out.println(res5);
		System.out.println(res6);
		System.out.println(res7);
		System.out.println(res8);
		System.out.println(res9);
		
	}

}
