package net.gmcc.pboss.common.dynamicds;

/**
 * 动态数据源帮助类
 * 用于动态切换数据源地市
 */
public class DynamicSourceHelper {

	//保存动态类的当前数据源用户标识
	private static ThreadLocal<String> dataSourceSect = new ThreadLocal<String>();
	
	public static void setDataSourceUser(String dbuser){
	    dataSourceSect.set(dbuser);
	}
	
	public static String getDataSourceUser(){
		return (String)dataSourceSect.get();
	}
	
	public static void removeDataSurceUser(){
		dataSourceSect.remove();
		//System.out.println("---------------------------清理数据源");
	}
}
