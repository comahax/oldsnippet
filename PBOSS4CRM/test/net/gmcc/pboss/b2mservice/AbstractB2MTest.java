package net.gmcc.pboss.b2mservice;

import java.net.URL;

public abstract class AbstractB2MTest {
	public static B2MServicePort client = null;	
	static{
		try{
			URL wsdl = new URL("http://127.0.0.1:9083/services/B2MService?wsdl");
			client = new B2MService(wsdl).getB2MServiceSoap();
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println("无法建立客户端");
		}
	}
	
	public void service(){
		if(client != null){
			//消息头格式异常测试
			System.out.println("**************************消息头格式异常测试************************************************");
			this.testHead();
			//消息体格式异常测试
			System.out.println("**************************消息体格式异常测试************************************************");
			this.testBody();
			//逻辑失败测试
			System.out.println("**************************逻辑失败测试************************************************");
			this.testLogicFail();
			//逻辑成功测试
			System.out.println("**************************逻辑成功测试************************************************");
			this.testLogicSucc();
		}else{
			System.out.println("客户端为空");
		}
	}
	
	abstract protected Object buildRequest();
	abstract protected void parseResponse(Object rsp);
	
	abstract protected void testHead();
	abstract protected void testBody();
	abstract protected void testLogicFail();
	abstract protected void testLogicSucc();
}
