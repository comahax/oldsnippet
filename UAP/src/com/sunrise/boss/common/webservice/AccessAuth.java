package com.sunrise.boss.common.webservice;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(serviceName="Zw2UapSoap",targetNamespace="http://www.gmcc.net/Esop2CRM/")
public interface AccessAuth {
	@WebResult(name="RetResult") //在生成wsdl文件时，返回值显示成为receiveMsg  
	public RetResult receiveRequestToken(@WebParam(name="region")String region,@WebParam(name="token")String token,@WebParam(name="system")String system);
	

}
