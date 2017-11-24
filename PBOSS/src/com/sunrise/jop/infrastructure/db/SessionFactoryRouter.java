package com.sunrise.jop.infrastructure.db;

/**
 * 多数据库转发路由器接口
 * @author 1.0 Huang Baiming 
 * @author 1.1 He Kun (Sunrise,Guangzhou, CN)
 *
 */
public interface SessionFactoryRouter {	
	
	public static final String DB_FLAG_COMMON = "DB_COMMON"; // 公共库,也是默认数据库标识
	public static final String DB_FLAG_GD = "GD"; // 广东999
	public static final String COMMON_CITY_MODE = "COMMON_CITY_MODE"; //公共+地市库模式 COMMON_CITY_MODE， 平行库模式:BROTHERS_MODE -->
	public static final String BROTHERS_MODE = "BROTHERS_MODE"; // 公共库
	

	public void setSessionFactoryConfig(String configFile);
	
	public SessionManager getSessionManager(Class voClass,String dbFlag);
	
	public SessionManager getSessionManager(String dbFlag);
	
	public SessionManager getSessionManager();
	
	
}
