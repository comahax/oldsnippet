package com.sunrise.jop.infrastructure.db;

/**
 * 多数据库转发路由器接口
 * @author 1.0 Huang Baiming 
 * @author 1.1 He Kun (Sunrise,Guangzhou, CN)
 *
 */
public interface SessionFactoryRouter {	

	public void setSessionFactoryConfig(String configFile);
	
	public SessionManager getSessionManager(Class voClass,String dbFlag);
	
	public SessionManager getSessionManager(String dbFlag);
	
	public SessionManager getSessionManager();
	
	
}
