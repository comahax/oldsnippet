package com.sunrise.boss.business.cms.audit.common;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.utils.sysinfo.SysInfo;

public class CityIDMap {

	
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

	public static HashMap cityidMap; //例子: key:750,value:JM
	
	private static Map citynameMap = new HashMap(22); 
	
	static {
		try {
			citynameMap.put("999","广东");
			citynameMap.put("200","广州");
			citynameMap.put("755","深圳");
			citynameMap.put("756","珠海");
			citynameMap.put("757","佛山");
			citynameMap.put("754","汕头");
			citynameMap.put("752","惠州");
			citynameMap.put("759","湛江");
			citynameMap.put("750","江门");
			citynameMap.put("758","肇庆");
			citynameMap.put("751","韶关");
			citynameMap.put("753","梅州");
			citynameMap.put("769","东莞");
			citynameMap.put("760","中山");
			citynameMap.put("668","茂名");
			citynameMap.put("660","汕尾");
			citynameMap.put("768","潮州");
			citynameMap.put("663","揭阳");
			citynameMap.put("662","阳江");
			citynameMap.put("763","清远");
			citynameMap.put("762","河源");
			citynameMap.put("766","云浮");

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
	 * 把cityid的数字代码转成字母代码，举例：750  ->  JM
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
