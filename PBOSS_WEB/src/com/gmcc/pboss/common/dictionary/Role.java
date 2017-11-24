package com.gmcc.pboss.common.dictionary;

import java.util.HashMap;
import java.util.Map;

import com.gmcc.pboss.common.util.JSTLConstants;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-8-14
 * 所属项目：
 * 所属模块：
 * 描述：角色
 */
public class Role extends JSTLConstants{
	
	public static Map<String,String> roleName;
	
	static{
		roleName = new HashMap<String,String>();
		roleName.put("0", "店员");
		roleName.put("1", "店主");
		roleName.put("2", "推广专员");
		roleName.put("3", "配送商");
		roleName.put("4", "经理");
		// 2014-10-14 a-biao
		roleName.put("5", "省公司管理员");
		roleName.put("6", "市公司管理员");
	}
	
	/**店员*/
	public static final int SHOP_ASSISTANT = 0 ;
	/**店主*/
	public static final int SHOP_MASTER = 1 ;
	/**推广专员*/
	public static final int MISSIONER = 2 ;
	/**配送商*/
	public static final int DELIVERY_MAN = 3;
	/**经理*/
	public static final int MANAGER = 4;
	// 2014-10-14 a-biao
	/**省公司管理员*/
	public static final int GD_MANAGER = 5;
	/**市公司管理员*/
	public static final int CITY_MANAGER = 6;
	
	/**在职*/
	public static final int INCUMBENCY  = 0;
	/**离职*/
	public static final int DIMISSION = 1;
	
	
	public static String getRoleName(int role ){
		String r = "未知角色";
		r = (roleName.get(role+"") != null)?(String)roleName.get(role+""):r;
		return r;
	}
	
}
