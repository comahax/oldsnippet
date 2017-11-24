package com.gmcc.pboss.web.common.login;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class NGLoginPortFactory {
	private static final String COMMON_TAIL = "_CRM";
	private static final String CRM_CX = "CX";
	private static final String CRM_HW = "HW";
	private static Map<String,URL> URLMap= new HashMap<String,URL>();
	private static Map<String,String> CITYCRMtype = new HashMap<String,String>();
	static {
		NGLoginPortFactory.reloadURL();
		NGLoginPortFactory.reloadCRMtype();
	}
	
	public static INGLoginCheck createPort(String cityid)throws Exception{
		if(CITYCRMtype.isEmpty()){//如果为空，刷新登录地市的WSDL协议的URL地址
			NGLoginPortFactory.reloadCRMtype();
		}
		if(URLMap.isEmpty()){//如果为空，刷新地市CRM类型信息
			NGLoginPortFactory.reloadURL();
		}
		String crmtype = CITYCRMtype.get(cityid+COMMON_TAIL);
		if(crmtype==null){
			System.err.println("地市"+cityid+"未在CRMCityPortState.properties配置CRM类型或者CRM类型配置为空");
			throw new Exception("地市"+cityid+"未配置CRM类型或者CRM类型配置为空");
		}
		URL url = URLMap.get(cityid);
		if(CRM_CX.equals(crmtype)){//CX
			return new NGAuthLoginCheckCX(url);
		}else if(CRM_HW.equals(crmtype)){//HW
			return new NGAuthLoginCheckHW(url);
		}else{//错误配置信息
			System.err.println("地市"+cityid+"在CRMCityPortState.properties配置CRM类型错误，必须为CX或者HW");
			throw new Exception("地市"+cityid+"配置CRM类型错误");
		}		
	}
	
	private static void reloadURL(){
		try{//加载登录地市的WSDL协议的URL地址
			InputStream in = NGLoginPortFactory.class.getClassLoader().getResourceAsStream("data/NGLoginCheckURL.properties");
			Properties prop = new Properties();
			prop.load(in);
			Set keyset = prop.keySet();
			for(Iterator ite = keyset.iterator();ite.hasNext();){
				String currentKey = (String)ite.next();
				try{//如果一个地市WSDL加载失败，不会影响对其他地市WSDL的加载
					URLMap.put(currentKey, new URL(prop.getProperty(currentKey)));
				}catch(MalformedURLException ex){
					System.err.println("获取地市WSDL登录协议失败："+currentKey);
					ex.printStackTrace();
				}				
			}
		}catch(IOException ex){//加载WSDL配置文件NGLoginCheckURL.properties异常
			System.err.println("读取NG割接地市URL配置文件NGLoginCheckURL.properties失败");
			ex.printStackTrace();
		}	
	}
	
	private static void reloadCRMtype(){
		try{//加载地市CRM类型信息
			InputStream in = NGLoginPortFactory.class.getClassLoader().getResourceAsStream("data/CRMCityPortState.properties");
			Properties prop = new Properties();
			prop.load(in);
			Set keyset = prop.keySet();
			for(Iterator ite = keyset.iterator();ite.hasNext();){
				String currentKey = (String)ite.next();
				if(currentKey.endsWith(COMMON_TAIL)){
					CITYCRMtype.put(currentKey, prop.getProperty(currentKey));
				}
			}
		}catch(Exception ex){
			System.err.println("读取NG割接地市CRM类型配置文件CRMCityPortState.properties失败");
			ex.printStackTrace();
		}
	}

}
