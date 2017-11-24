package net.gmcc.pboss.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;


public class ParamsUtil {
	protected static final Logger log = Logger.getLogger(ParamsUtil.class);
	
	private static final HashMap<String,String> REGION_LETTER_MAP;//地区号和地市号(字母)对应表;
	
	private static final Map<String,String> LETTER_NUMBER_CITY;// 交换局(字母:数字)
	
	private static final List<String> BRAND_LIST;	
	static{		
		REGION_LETTER_MAP = new HashMap<String,String>();     
		REGION_LETTER_MAP.put("200", "GZ");  
		REGION_LETTER_MAP.put("751", "SG");  
		REGION_LETTER_MAP.put("763", "QY");  
		REGION_LETTER_MAP.put("758", "ZQ");  
		REGION_LETTER_MAP.put("766", "YF");  
		REGION_LETTER_MAP.put("755", "SZ");  
		REGION_LETTER_MAP.put("757", "FS");  
		REGION_LETTER_MAP.put("760", "ZS");  
		REGION_LETTER_MAP.put("756", "ZH");  
		REGION_LETTER_MAP.put("769", "DG");  
		REGION_LETTER_MAP.put("762", "HY");  
		REGION_LETTER_MAP.put("752", "HZ");  
		REGION_LETTER_MAP.put("753", "MZ");
		REGION_LETTER_MAP.put("750", "JM");  
		REGION_LETTER_MAP.put("668", "MM");  
		REGION_LETTER_MAP.put("662", "YJ");  
		REGION_LETTER_MAP.put("768", "CZ");  
		REGION_LETTER_MAP.put("663", "JY");  
		REGION_LETTER_MAP.put("754", "ST");  
		REGION_LETTER_MAP.put("660", "SW");  
		REGION_LETTER_MAP.put("759", "ZJ");  
		
		
		LETTER_NUMBER_CITY = new HashMap<String,String>();
	    LETTER_NUMBER_CITY.put("GZ", "200");
		LETTER_NUMBER_CITY.put("SG", "751");
		LETTER_NUMBER_CITY.put("QY", "763");
		LETTER_NUMBER_CITY.put("ZQ", "758");
		LETTER_NUMBER_CITY.put("YF", "766");
		LETTER_NUMBER_CITY.put("SZ", "755");
		LETTER_NUMBER_CITY.put("FS", "757");
		LETTER_NUMBER_CITY.put("ZS", "760");
		LETTER_NUMBER_CITY.put("ZH", "756");
		LETTER_NUMBER_CITY.put("DG", "769");
		LETTER_NUMBER_CITY.put("HY", "762");
		LETTER_NUMBER_CITY.put("HZ", "752");
		LETTER_NUMBER_CITY.put("MZ", "753");
		LETTER_NUMBER_CITY.put("JM", "750");
		LETTER_NUMBER_CITY.put("MM", "668");
		LETTER_NUMBER_CITY.put("YJ", "662");
		LETTER_NUMBER_CITY.put("CZ", "768");
		LETTER_NUMBER_CITY.put("JY", "663");
		LETTER_NUMBER_CITY.put("ST", "754");
		LETTER_NUMBER_CITY.put("SW", "660");
		LETTER_NUMBER_CITY.put("ZJ", "759");
		
		BRAND_LIST = new ArrayList<String>();
		BRAND_LIST.add("BrandMzone"); //动感
		BRAND_LIST.add("BrandTD");    //TD? 
		BRAND_LIST.add("BrandSzx");   //神州行
		BRAND_LIST.add("BrandGotone");//全球通
		BRAND_LIST.add("BrandDzk");   //大众卡
	}	
	
	public static Map<String, String> getRegionLetterMap(){
		return REGION_LETTER_MAP;
	}
	
	public static Map<String, String> getLetterNumberCity(){
		return LETTER_NUMBER_CITY;
	}
}
