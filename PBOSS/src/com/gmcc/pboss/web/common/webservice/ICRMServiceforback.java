package com.gmcc.pboss.web.common.webservice;

import net.gmcc.ngcrm.GDProdPort;

public interface ICRMServiceforback {
	public Object getServicePort(String cityid)throws Exception;
	public boolean isCRMCityPort(String cityid)throws Exception;
	/**
	 * ȷ������CRM��ʶ
	 * @param cityid ���б�ʶ GZ��ZS
	 * @return CX-����CRM     HW-��ΪCRM
	 * @throws Exception
	 */
	public String getCityCRMMark(String cityid)throws Exception;
}