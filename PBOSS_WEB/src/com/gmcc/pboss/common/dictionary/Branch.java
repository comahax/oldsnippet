package com.gmcc.pboss.common.dictionary;

import java.util.Hashtable;
import java.util.Map;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-8-18
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：
 */
public class Branch {
	private static Map<String, String> branchHash = new Hashtable<String, String>(3);
	private static Map<String, Integer> branchIDHash = new Hashtable<String, Integer>();
	private static Map<Integer, String> branchCodeHash = new Hashtable<Integer, String>();
	
	static{
		branchHash.put("GZ","广州");
		branchHash.put("SZ","深圳");
		branchHash.put("DG","东莞");
		branchHash.put("FS","佛山");
		branchHash.put("ST","汕头");
		branchHash.put("JM","江门");
		branchHash.put("SG","韶关");
		branchHash.put("QY","清远");
		branchHash.put("ZQ","肇庆");
		branchHash.put("YF","云浮");
		branchHash.put("MZ","梅州");
		branchHash.put("HY","河源");
		branchHash.put("HZ","惠州");
		branchHash.put("ZH","珠海");
		branchHash.put("ZS","中山");
		branchHash.put("JY","揭阳");
		branchHash.put("CZ","潮州");
		branchHash.put("SW","汕尾");
		branchHash.put("MM","茂名");
		branchHash.put("YJ","阳江");
		branchHash.put("ZJ","湛江");		

		branchCodeHash.put(new Integer(1),"GZ");
		branchCodeHash.put(new Integer(2),"SZ");
		branchCodeHash.put(new Integer(13),"DG");
		branchCodeHash.put(new Integer(5),"FS");
		branchCodeHash.put(new Integer(3),"ST");
		branchCodeHash.put(new Integer(16),"JM");
		branchCodeHash.put(new Integer(6),"SG");
		branchCodeHash.put(new Integer(8),"QY");
		branchCodeHash.put(new Integer(11),"ZQ");
		branchCodeHash.put(new Integer(15),"YF");
		branchCodeHash.put(new Integer(7),"MZ");
		branchCodeHash.put(new Integer(14),"HY");
		branchCodeHash.put(new Integer(19),"HZ");
		branchCodeHash.put(new Integer(4),"ZH");
		branchCodeHash.put(new Integer(17),"ZS");
		branchCodeHash.put(new Integer(9),"JY");
		branchCodeHash.put(new Integer(10),"CZ");
		branchCodeHash.put(new Integer(20),"SW");
		branchCodeHash.put(new Integer(21),"MM");
		branchCodeHash.put(new Integer(22),"YJ");
		branchCodeHash.put(new Integer(23),"ZJ");
		
		branchIDHash.put("GZ",new Integer(1));
		branchIDHash.put("SZ",new Integer(2));
		branchIDHash.put("DG",new Integer(13));
		branchIDHash.put("FS",new Integer(5));
		branchIDHash.put("ST",new Integer(3));
		branchIDHash.put("JM",new Integer(16));
		branchIDHash.put("SG",new Integer(6));
		branchIDHash.put("QY",new Integer(8));
		branchIDHash.put("ZQ",new Integer(11));
		branchIDHash.put("YF",new Integer(15));
		branchIDHash.put("MZ",new Integer(7));
		branchIDHash.put("HY",new Integer(14));
		branchIDHash.put("HZ",new Integer(19));
		branchIDHash.put("ZH",new Integer(4));
		branchIDHash.put("ZS",new Integer(17));
		branchIDHash.put("JY",new Integer(9));
		branchIDHash.put("CZ",new Integer(10));
		branchIDHash.put("SW",new Integer(20));
		branchIDHash.put("MM",new Integer(21));
		branchIDHash.put("YJ",new Integer(22));
		branchIDHash.put("ZJ",new Integer(23));
	}
	/**
	 * 获得地市中文名称
	 * @param branchCode
	 * @return
	 */
	public static String getBranchName(String branchCode){
		return (String) branchHash.get(branchCode);
	}
	/*
	public static int getBranchID(String branchCode){
		int branchID = ((Integer)branchIDHash.get(branchCode)).intValue();
		return branchID;
	}
	*/
	/**
	 * 根据地市ID获得地市英文缩写
	 */
	public static String getBranchCode(int branchId){
		return (String)branchCodeHash.get(new Integer(branchId));
	}
}
