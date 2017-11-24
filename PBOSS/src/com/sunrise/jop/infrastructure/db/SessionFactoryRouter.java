package com.sunrise.jop.infrastructure.db;

/**
 * �����ݿ�ת��·�����ӿ�
 * @author 1.0 Huang Baiming 
 * @author 1.1 He Kun (Sunrise,Guangzhou, CN)
 *
 */
public interface SessionFactoryRouter {	
	
	public static final String DB_FLAG_COMMON = "DB_COMMON"; // ������,Ҳ��Ĭ�����ݿ��ʶ
	public static final String DB_FLAG_GD = "GD"; // �㶫999
	public static final String COMMON_CITY_MODE = "COMMON_CITY_MODE"; //����+���п�ģʽ COMMON_CITY_MODE�� ƽ�п�ģʽ:BROTHERS_MODE -->
	public static final String BROTHERS_MODE = "BROTHERS_MODE"; // ������
	

	public void setSessionFactoryConfig(String configFile);
	
	public SessionManager getSessionManager(Class voClass,String dbFlag);
	
	public SessionManager getSessionManager(String dbFlag);
	
	public SessionManager getSessionManager();
	
	
}
