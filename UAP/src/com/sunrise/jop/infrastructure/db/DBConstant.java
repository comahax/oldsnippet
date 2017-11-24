package com.sunrise.jop.infrastructure.db;

public class DBConstant {
	
	public static final String MULTI_CITY_MODE = "MULTI_CITY_MODE"; //多数据库模式 MUTI_CITY_MODE， 平行库模式:BROTHERS_MODE -->
	public static final String BROTHERS_MODE = "BROTHERS_MODE"; // 公共库
	
	public static final String DB_FLAG_COMMON = "COMMON"; // 公共库数据源标识
	public static final String DB_FLAG_GDIB = "GDIB"; // 集团账务数据源标识
	public static final String DB_FLAG_IB = "IB";  // 个人账务数据源标识
	public static final String DB_FLAG_BILL = "BILL"; // 出账数据源标识
	
	public static final String QUERY_ALL = "0"; // 全部查询
}
