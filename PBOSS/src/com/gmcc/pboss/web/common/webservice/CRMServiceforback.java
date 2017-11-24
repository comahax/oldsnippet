package com.gmcc.pboss.web.common.webservice;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import net.gmcc.ngcrm.GDProdPort;
import net.gmcc.ngcrm.GDProdServ;

import com.gmcc.pboss.common.sms.ComOrderSms;

public class CRMServiceforback implements ICRMServiceforback{
	private static Properties property = null;
	private static final String INFIX = "_CRM";
	public Object getServicePort(String cityid)throws Exception{
		try {
			if("Y".equals(getCRMCityPortState(cityid))){
				if("CX".equals(this.getCityCRMMark(cityid))){
					InputStream in = net.gmcc.ngcrm.pboss.GDProdServ.class.getResourceAsStream("/coreconfiginfo.properties");
					Properties p = new Properties();
					p.load(in);
					in.close();
					String path = (String) p.get("CRMService.path."+cityid);
					URL url = net.gmcc.ngcrm.pboss.GDProdServ.class.getClassLoader().getResource(path);
					
					net.gmcc.ngcrm.pboss.GDProdServ service = new net.gmcc.ngcrm.pboss.GDProdServ(url, net.gmcc.ngcrm.pboss.GDProdServ.SERVICE);
					net.gmcc.ngcrm.pboss.GDProdPort servicePort = service.getGDProdSOAP(); 
					return servicePort;
				}else{// "HW"
					InputStream in = GDProdServ.class.getResourceAsStream("/coreconfiginfo.properties");
					Properties p = new Properties();
					p.load(in);
					in.close();
					String path = (String) p.get("CRMService.path."+cityid);
					URL url = GDProdServ.class.getClassLoader().getResource(path);
					
					GDProdServ service = new GDProdServ(url, GDProdServ.SERVICE);
					GDProdPort servicePort = service.getGDProdSOAP(); 
					return servicePort;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return null;

	}
	public boolean isCRMCityPort(String cityid)throws Exception{
		if("Y".equals(getCRMCityPortState(cityid))){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 从规则配置文件中读取内容
	 * 
	 * @param content
	 * @return
	 * @throws Exception
	 */
	private String getCRMCityPortState(String cityid) throws Exception {
		if (property == null) {
			property = new Properties();
		}
		if (property.isEmpty()) {
			InputStream in = ComOrderSms.class
					.getResourceAsStream("/data/CRMCityPortState.properties");
			property.load(in);
		}
		return property.getProperty(cityid);
	}
	
	/**
	 * 确定地市CRM标识
	 * @param cityid 地市标识 GZ、ZS
	 * @return CX-从兴CRM     HW-华为CRM
	 * @throws Exception
	 */
	public String getCityCRMMark(String cityid) throws Exception{
		if (property == null) {
			property = new Properties();
		}
		if (property.isEmpty()) {
			InputStream in = ComOrderSms.class
					.getResourceAsStream("/data/CRMCityPortState.properties");
			property.load(in);
		}
		String mark = property.getProperty(cityid+this.INFIX);
		if(!"CX".equals(mark) && !"HW".equals(mark)){
			throw new Exception("配置文件错误，地市的CRM标识只能是字符CX或者HW.");
		}
		return mark;
	}
}