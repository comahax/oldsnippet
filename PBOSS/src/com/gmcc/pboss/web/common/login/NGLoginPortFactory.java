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
		if(CITYCRMtype.isEmpty()){//���Ϊ�գ�ˢ�µ�¼���е�WSDLЭ���URL��ַ
			NGLoginPortFactory.reloadCRMtype();
		}
		if(URLMap.isEmpty()){//���Ϊ�գ�ˢ�µ���CRM������Ϣ
			NGLoginPortFactory.reloadURL();
		}
		String crmtype = CITYCRMtype.get(cityid+COMMON_TAIL);
		if(crmtype==null){
			System.err.println("����"+cityid+"δ��CRMCityPortState.properties����CRM���ͻ���CRM��������Ϊ��");
			throw new Exception("����"+cityid+"δ����CRM���ͻ���CRM��������Ϊ��");
		}
		URL url = URLMap.get(cityid);
		if(CRM_CX.equals(crmtype)){//CX
			return new NGAuthLoginCheckCX(url);
		}else if(CRM_HW.equals(crmtype)){//HW
			return new NGAuthLoginCheckHW(url);
		}else{//����������Ϣ
			System.err.println("����"+cityid+"��CRMCityPortState.properties����CRM���ʹ��󣬱���ΪCX����HW");
			throw new Exception("����"+cityid+"����CRM���ʹ���");
		}		
	}
	
	private static void reloadURL(){
		try{//���ص�¼���е�WSDLЭ���URL��ַ
			InputStream in = NGLoginPortFactory.class.getClassLoader().getResourceAsStream("data/NGLoginCheckURL.properties");
			Properties prop = new Properties();
			prop.load(in);
			Set keyset = prop.keySet();
			for(Iterator ite = keyset.iterator();ite.hasNext();){
				String currentKey = (String)ite.next();
				try{//���һ������WSDL����ʧ�ܣ�����Ӱ�����������WSDL�ļ���
					URLMap.put(currentKey, new URL(prop.getProperty(currentKey)));
				}catch(MalformedURLException ex){
					System.err.println("��ȡ����WSDL��¼Э��ʧ�ܣ�"+currentKey);
					ex.printStackTrace();
				}				
			}
		}catch(IOException ex){//����WSDL�����ļ�NGLoginCheckURL.properties�쳣
			System.err.println("��ȡNG��ӵ���URL�����ļ�NGLoginCheckURL.propertiesʧ��");
			ex.printStackTrace();
		}	
	}
	
	private static void reloadCRMtype(){
		try{//���ص���CRM������Ϣ
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
			System.err.println("��ȡNG��ӵ���CRM���������ļ�CRMCityPortState.propertiesʧ��");
			ex.printStackTrace();
		}
	}

}
