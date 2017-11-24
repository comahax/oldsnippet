package com.sunrise.boss.business.cms.audit.common;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.utils.sysinfo.SysInfo;

public class CityIDMap {

	
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

	public static HashMap cityidMap; //����: key:750,value:JM
	
	private static Map citynameMap = new HashMap(22); 
	
	static {
		try {
			citynameMap.put("999","�㶫");
			citynameMap.put("200","����");
			citynameMap.put("755","����");
			citynameMap.put("756","�麣");
			citynameMap.put("757","��ɽ");
			citynameMap.put("754","��ͷ");
			citynameMap.put("752","����");
			citynameMap.put("759","տ��");
			citynameMap.put("750","����");
			citynameMap.put("758","����");
			citynameMap.put("751","�ع�");
			citynameMap.put("753","÷��");
			citynameMap.put("769","��ݸ");
			citynameMap.put("760","��ɽ");
			citynameMap.put("668","ï��");
			citynameMap.put("660","��β");
			citynameMap.put("768","����");
			citynameMap.put("663","����");
			citynameMap.put("662","����");
			citynameMap.put("763","��Զ");
			citynameMap.put("762","��Դ");
			citynameMap.put("766","�Ƹ�");

			InputStream in = SessionFactoryRouter.class.getResourceAsStream(SysInfo.CITYID_MAPPING_FILE_PATH);
			Properties properties = new Properties();
			properties.load(in);
			in.close();
			cityidMap = new HashMap(properties);			
			
		} catch (Exception ex) {
			log.fatal("CityIDMap init error!", ex);
//			System.out.println("*********************************");
		}
	}
	
	/**
	 * ��cityid�����ִ���ת����ĸ���룬������750  ->  JM
	 * @param cityid
	 * @return
	 */
	public static String conversionCityid(String cityid) {
		if (cityidMap.containsKey(cityid)) {
			return (String) cityidMap.get(cityid);
		}else{
			return cityid;
		}
	}
	
	public static String getCityname(String cityid){
		return (String)citynameMap.get(cityid);
	}
}
