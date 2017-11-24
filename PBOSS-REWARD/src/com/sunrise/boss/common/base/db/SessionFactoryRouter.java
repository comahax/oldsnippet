package com.sunrise.boss.common.base.db;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.sunrise.boss.common.utils.sysinfo.SysInfo;
import com.sunrise.boss.ui.commons.User;

public class SessionFactoryRouter {

	public static final String DB_FLAG_COMMON = "DB_COMMON"; // 公共库
	
	public static final String DB_FLAG_BOSSCOMMON = "BOSSCOMMON"; // 公共库

	public static final String DB_FLAG_GD = "GD"; // 广东999

	public static final String DB_FLAG_GZ = "GZ"; // 广州200

	public static final String DB_FLAG_SZ = "SZ"; // 深圳755

	public static final String DB_FLAG_ZH = "ZH"; // 珠海756

	public static final String DB_FLAG_FS = "FS"; // 佛山757

	public static final String DB_FLAG_ST = "ST"; // 汕头754

	public static final String DB_FLAG_HZ = "HZ"; // 惠州752

	public static final String DB_FLAG_ZJ = "ZJ"; // 湛江759

	public static final String DB_FLAG_JM = "JM"; // 江门750

	public static final String DB_FLAG_ZQ = "ZQ"; // 肇庆758

	public static final String DB_FLAG_SG = "SG"; // 韶关751

	public static final String DB_FLAG_MZ = "MZ"; // 梅州753

	public static final String DB_FLAG_DG = "DG"; // 东莞769

	public static final String DB_FLAG_ZS = "ZS"; // 中山760

	public static final String DB_FLAG_MM = "MM"; // 茂名668

	public static final String DB_FLAG_SW = "SW"; // 汕尾660

	public static final String DB_FLAG_CZ = "CZ"; // 潮州768

	public static final String DB_FLAG_JY = "JY"; // 揭阳663

	public static final String DB_FLAG_YJ = "YJ"; // 阳江662

	public static final String DB_FLAG_QY = "QY"; // 清远763

	public static final String DB_FLAG_HY = "HY"; // 河源762

	public static final String DB_FLAG_YF = "YF"; // 云浮766

	private static Logger log = Logger.getRootLogger();

	static HashMap dbMap;
	static HashMap cityidMap; // 例子: key:750,value:JM
	static HashMap numidMap; // 例子: key:JM,value:750
	static HashMap commonDaoMap;
	static HashMap cityidTTMap; // 内存数据库 例子: key:750,value:TTDB_JMZW
	static HashMap nodeidTTMap; // 内存数据库 例子: ***

	static {
		try {
			InputStream in = SessionFactoryRouter.class.getResourceAsStream(SysInfo.SESSION_FACTORY_FILE_PATH);
			Properties properties = new Properties();
			properties.load(in);
			in.close();
			dbMap = new HashMap(properties);

			in = SessionFactoryRouter.class.getResourceAsStream(SysInfo.CITYID_MAPPING_FILE_PATH);
			properties = new Properties();
			properties.load(in);
			in.close();
			cityidMap = new HashMap(properties);

			numidMap = new HashMap();
			Iterator iter = properties.keySet().iterator();
			while (iter.hasNext()) {
				Object key = iter.next();
				numidMap.put(properties.get(key), key);
			}

			/** 各个cityid对应的内存数据库dbflag Map **/
			in = SessionFactoryRouter.class.getResourceAsStream(SysInfo.CITYIDTT_MAPPING_FILE_PATH);
			properties = new Properties();
			properties.load(in);
			in.close();
			cityidTTMap = new HashMap(properties);

			/** 按号段取内存数据库dbflag Map add by mys 20090212 **/
			in = SessionFactoryRouter.class.getResourceAsStream(SysInfo.NODEIDTT_MAPPING_FILE_PATH);
			properties = new Properties();
			properties.load(in);
			in.close();
			nodeidTTMap = new HashMap(properties);

			in = SessionFactoryRouter.class.getResourceAsStream(SysInfo.COMMON_DAO_FILE_PATH);
			properties = new Properties();
			properties.load(in);
			in.close();
			commonDaoMap = new HashMap(properties);
		} catch (Exception ex) {
			log.fatal("SessionFactoryRouter init error!", ex);
//			System.out.println("*********************************");
//			System.out.println("SessionFactoryRouter init error!");
//			System.out.println("*********************************");
//			System.err.println("*********************************");
//			System.err.println("SessionFactoryRouter init error!");
//			System.err.println("*********************************");
		}
	}

	/**
	 * 转换规则（两种情况） 1.从cityID转为dbFlag 2.直接用dbFlag（程序员明确自己要操作哪个库）
	 * 
	 * @param dbFlag
	 * @return
	 */
	public static String conversionDbFlag(String dbFlag) {
		if (dbFlag == null || dbFlag.trim().length() <= 0)
			return null;
		if (dbMap.containsKey(dbFlag)) { // 内存数据库只能够通过这个方法取得dbflag
			return dbFlag;
		} else {// 匹配映射关系（从cityID转换为dbFlag）
			String newDbFlag = dbFlag; // 测试时用到的标识，正式环境不用
			// String newDbFlag = forTestDbFlag(dbFlag); // 测试时用到的标识，正式环境不用
			if (cityidMap.containsKey(dbFlag)) {
				newDbFlag = "DB_" + (String) cityidMap.get(dbFlag) + "ZW";
			}

			if (dbMap.containsKey(newDbFlag)) {
				return newDbFlag;
			} else {
				if (SysInfo.getInstance().getTestFlag()) {
					return forTestDbFlag(dbFlag); // 测试时用到的标识，正式环境不用
				} else {
					throw new RuntimeException(
							"multi-DataBase: dbFlag conversion error, the dbFlag "
									+ dbFlag + " is not exist!");
				}
			}
		}
	}

	public static String forTestDbFlag(String dbFlag) {
		return "DB_TEST";
	}

	public static String forTestTTDbFlag(String dbFlag) {
		return "TTDB_TEST";
	}

	/**
	 * 把cityid的数字代码转成字母代码，举例：750 -> JM
	 * 
	 * @param cityid
	 * @return
	 */
	public static String conversionCityid(String cityid) {
		if (cityidMap.containsKey(cityid)) {
			return (String) cityidMap.get(cityid);
		} else {
			return cityid;
		}
	}

	/**
	 * 把cityid的字母代码转成数字代码，举例：JM -> 750
	 * 
	 * @param cityid
	 * @return
	 */
	public static String conversionCityid2Num(String cityid) {
		if (numidMap.containsKey(cityid)) {
			return (String) numidMap.get(cityid);
		} else {
			return cityid;
		}
	}

	/*
	 * 判断是否包含COMMON库里面的DAO
	 */
	public static boolean containsCommonDAO(String dao) {
		return commonDaoMap.containsValue(dao);
	}

	/*
	 * 判断是否包含COMMON库里面的VO
	 */
	public static boolean containsCommonVO(String vo) {
		return commonDaoMap.containsKey(vo);
	}

	/**
	 * 判断voClass是否对应COMMON库里面的库表,如何是的话返回"DB_COMMON",否则的话返回dbFlag
	 */
	public static String checkIsCommonDB(Class voClass, String dbFlag) {
		return checkIsCommonDB(voClass.getName(), dbFlag);
	}

	/**
	 * 判断voName是否对应COMMON库里面的库表,如何是的话返回"DB_COMMON",否则的话返回dbFlag
	 */
	public static String checkIsCommonDB(String voName, String dbFlag) {
		if (containsCommonVO(voName)) {
			return DB_FLAG_COMMON;
		} else {
			return dbFlag;
		}
	}
	
	/**
	 * 通过cityid(格式:JM/750)取得相对应的内存数据库dbflag
	 */
	public static String getTTDbfalg(String dbFlag) {
		String cityid = conversionCityid2Num(dbFlag);
		
		if (SysInfo.getInstance().getTestFlag()) {
			return forTestTTDbFlag(cityid); // 测试时用到的标识，正式环境不用
		} 
		
		if(cityidTTMap.containsKey(cityid)){
			return (String) cityidTTMap.get(cityid);
		}else{
			return dbFlag;
		}
	}
	
	/**
	 * 通过cityid(格式:JM/750)取得相对应的内存数据库dbflag
	 */
	public static String getTTDbfalgByNodeid(String nodeid) {
		
		if (SysInfo.getInstance().getTestFlag()) {
			return forTestTTDbFlag(nodeid); // 测试时用到的标识，正式环境不用
		} 
		
		if(nodeidTTMap.containsKey(nodeid)){
			return (String) nodeidTTMap.get(nodeid);
		}else{
			return nodeid;
		}
	}

	public static HashMap getCityidMap() {
		return cityidMap;
	}

	public static void setCityidMap(HashMap cityidMap) {
		SessionFactoryRouter.cityidMap = cityidMap;
	}
}
