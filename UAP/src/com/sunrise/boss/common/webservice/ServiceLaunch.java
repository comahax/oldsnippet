package com.sunrise.boss.common.webservice;


import javax.xml.ws.Endpoint;

import com.sunrise.jop.infrastructure.config.CoreConfigInfo;

public class ServiceLaunch {
	
	public static void main(String[] args) {  
        
        String address = "http://172.20.36.27:8088/uap/services/tokenValidateService"; 
        // 生成客户端 wsimport -keep http://172.20.36.27:8088/uap/services/tokenValidateService?wsdl
         Endpoint endpoint = Endpoint.publish(address, new AccessAuthImpl()); 
    }  
	
	public ServiceLaunch(){
		init();
	}
	
	private void init(){
		System.out.println("webservice 服务初始化...............");
		
//		String address = "http://172.20.36.27:8088/uap/services/tokenValidateService";   
		String address = CoreConfigInfo.getRuntimeParam("uap.webservice.url");
        Endpoint.publish(address, new AccessAuthImpl()); 
        System.out.println("webservice 服务发布成功...............");
	}

}
