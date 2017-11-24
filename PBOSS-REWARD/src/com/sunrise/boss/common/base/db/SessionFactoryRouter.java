package com.sunrise.boss.common.base.db;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.sunrise.boss.common.utils.sysinfo.SysInfo;
import com.sunrise.boss.ui.commons.User;

public class SessionFactoryRouter {

	public static final String DB_FLAG_COMMON = "DB_COMMON"; // ������
	
	public static final String DB_FLAG_BOSSCOMMON = "BOSSCOMMON"; // ������

	public static final String DB_FLAG_GD = "GD"; // �㶫999

	public static final String DB_FLAG_GZ = "GZ"; // ����200

	public static final String DB_FLAG_SZ = "SZ"; // ����755

	public static final String DB_FLAG_ZH = "ZH"; // �麣756

	public static final String DB_FLAG_FS = "FS"; // ��ɽ757

	public static final String DB_FLAG_ST = "ST"; // ��ͷ754

	public static final String DB_FLAG_HZ = "HZ"; // ����752

	public static final String DB_FLAG_ZJ = "ZJ"; // տ��759

	public static final String DB_FLAG_JM = "JM"; // ����750

	public static final String DB_FLAG_ZQ = "ZQ"; // ����758

	public static final String DB_FLAG_SG = "SG"; // �ع�751

	public static final String DB_FLAG_MZ = "MZ"; // ÷��753

	public static final String DB_FLAG_DG = "DG"; // ��ݸ769

	public static final String DB_FLAG_ZS = "ZS"; // ��ɽ760

	public static final String DB_FLAG_MM = "MM"; // ï��668

	public static final String DB_FLAG_SW = "SW"; // ��β660

	public static final String DB_FLAG_CZ = "CZ"; // ����768

	public static final String DB_FLAG_JY = "JY"; // ����663

	public static final String DB_FLAG_YJ = "YJ"; // ����662

	public static final String DB_FLAG_QY = "QY"; // ��Զ763

	public static final String DB_FLAG_HY = "HY"; // ��Դ762

	public static final String DB_FLAG_YF = "YF"; // �Ƹ�766

	private static Logger log = Logger.getRootLogger();

	static HashMap dbMap;
	static HashMap cityidMap; // ����: key:750,value:JM
	static HashMap numidMap; // ����: key:JM,value:750
	static HashMap commonDaoMap;
	static HashMap cityidTTMap; // �ڴ����ݿ� ����: key:750,value:TTDB_JMZW
	static HashMap nodeidTTMap; // �ڴ����ݿ� ����: ***

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

			/** ����cityid��Ӧ���ڴ����ݿ�dbflag Map **/
			in = SessionFactoryRouter.class.getResourceAsStream(SysInfo.CITYIDTT_MAPPING_FILE_PATH);
			properties = new Properties();
			properties.load(in);
			in.close();
			cityidTTMap = new HashMap(properties);

			/** ���Ŷ�ȡ�ڴ����ݿ�dbflag Map add by mys 20090212 **/
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
	 * ת��������������� 1.��cityIDתΪdbFlag 2.ֱ����dbFlag������Ա��ȷ�Լ�Ҫ�����ĸ��⣩
	 * 
	 * @param dbFlag
	 * @return
	 */
	public static String conversionDbFlag(String dbFlag) {
		if (dbFlag == null || dbFlag.trim().length() <= 0)
			return null;
		if (dbMap.containsKey(dbFlag)) { // �ڴ����ݿ�ֻ�ܹ�ͨ���������ȡ��dbflag
			return dbFlag;
		} else {// ƥ��ӳ���ϵ����cityIDת��ΪdbFlag��
			String newDbFlag = dbFlag; // ����ʱ�õ��ı�ʶ����ʽ��������
			// String newDbFlag = forTestDbFlag(dbFlag); // ����ʱ�õ��ı�ʶ����ʽ��������
			if (cityidMap.containsKey(dbFlag)) {
				newDbFlag = "DB_" + (String) cityidMap.get(dbFlag) + "ZW";
			}

			if (dbMap.containsKey(newDbFlag)) {
				return newDbFlag;
			} else {
				if (SysInfo.getInstance().getTestFlag()) {
					return forTestDbFlag(dbFlag); // ����ʱ�õ��ı�ʶ����ʽ��������
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
	 * ��cityid�����ִ���ת����ĸ���룬������750 -> JM
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
	 * ��cityid����ĸ����ת�����ִ��룬������JM -> 750
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
	 * �ж��Ƿ����COMMON�������DAO
	 */
	public static boolean containsCommonDAO(String dao) {
		return commonDaoMap.containsValue(dao);
	}

	/*
	 * �ж��Ƿ����COMMON�������VO
	 */
	public static boolean containsCommonVO(String vo) {
		return commonDaoMap.containsKey(vo);
	}

	/**
	 * �ж�voClass�Ƿ��ӦCOMMON������Ŀ��,����ǵĻ�����"DB_COMMON",����Ļ�����dbFlag
	 */
	public static String checkIsCommonDB(Class voClass, String dbFlag) {
		return checkIsCommonDB(voClass.getName(), dbFlag);
	}

	/**
	 * �ж�voName�Ƿ��ӦCOMMON������Ŀ��,����ǵĻ�����"DB_COMMON",����Ļ�����dbFlag
	 */
	public static String checkIsCommonDB(String voName, String dbFlag) {
		if (containsCommonVO(voName)) {
			return DB_FLAG_COMMON;
		} else {
			return dbFlag;
		}
	}
	
	/**
	 * ͨ��cityid(��ʽ:JM/750)ȡ�����Ӧ���ڴ����ݿ�dbflag
	 */
	public static String getTTDbfalg(String dbFlag) {
		String cityid = conversionCityid2Num(dbFlag);
		
		if (SysInfo.getInstance().getTestFlag()) {
			return forTestTTDbFlag(cityid); // ����ʱ�õ��ı�ʶ����ʽ��������
		} 
		
		if(cityidTTMap.containsKey(cityid)){
			return (String) cityidTTMap.get(cityid);
		}else{
			return dbFlag;
		}
	}
	
	/**
	 * ͨ��cityid(��ʽ:JM/750)ȡ�����Ӧ���ڴ����ݿ�dbflag
	 */
	public static String getTTDbfalgByNodeid(String nodeid) {
		
		if (SysInfo.getInstance().getTestFlag()) {
			return forTestTTDbFlag(nodeid); // ����ʱ�õ��ı�ʶ����ʽ��������
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
