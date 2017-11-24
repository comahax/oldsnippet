package com.gmcc.pboss.web.common.webservice;

import net.gmcc.ngcrm.GDProdPort;

public interface ICRMServiceforback {
	public Object getServicePort(String cityid)throws Exception;
	public boolean isCRMCityPort(String cityid)throws Exception;
	/**
	 * 确定地市CRM标识
	 * @param cityid 地市标识 GZ、ZS
	 * @return CX-从兴CRM     HW-华为CRM
	 * @throws Exception
	 */
	public String getCityCRMMark(String cityid)throws Exception;
}