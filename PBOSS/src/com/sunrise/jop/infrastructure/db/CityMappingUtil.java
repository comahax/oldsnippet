package com.sunrise.jop.infrastructure.db;

import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.bidimap.DualHashBidiMap;
/**
 * 地市标识转换
 * @author xy
 *
 */
public class CityMappingUtil {
	private static final BidiMap map = new DualHashBidiMap( );
	static{
		map.put("GD", "999");
		map.put("GZ", "200");
		map.put("SZ", "755");
		map.put("ZH", "756");
		map.put("FS", "757");
		map.put("ST", "754");
		map.put("HZ", "752");
		map.put("ZJ", "759");
		map.put("JM", "750");
		map.put("ZQ", "758");
		map.put("SG", "751");
		map.put("MZ", "753");
		map.put("DG", "769");
		map.put("ZS", "760");
		map.put("MM", "668");
		map.put("SW", "660");
		map.put("CZ", "768");
		map.put("JY", "663");
		map.put("YJ", "662");
		map.put("QY", "763");
		map.put("HY", "762");
		map.put("YF", "766");
		map.put("DB_COMMON", "000");
	}
	public CityMappingUtil() {
		// TODO Auto-generated constructor stub
	}
	public static String getCityNo(String cityid) throws Exception{
		return map.get(cityid)==null?"000":map.get(cityid).toString();
	}
	public static String getCityid(String cityno) throws Exception{
		return map.inverseBidiMap().get(cityno)==null?"DB_COMMON":map.inverseBidiMap().get(cityno).toString();
	}
}
