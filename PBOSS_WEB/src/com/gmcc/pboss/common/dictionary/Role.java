package com.gmcc.pboss.common.dictionary;

import java.util.HashMap;
import java.util.Map;

import com.gmcc.pboss.common.util.JSTLConstants;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-8-14
 * ������Ŀ��
 * ����ģ�飺
 * ��������ɫ
 */
public class Role extends JSTLConstants{
	
	public static Map<String,String> roleName;
	
	static{
		roleName = new HashMap<String,String>();
		roleName.put("0", "��Ա");
		roleName.put("1", "����");
		roleName.put("2", "�ƹ�רԱ");
		roleName.put("3", "������");
		roleName.put("4", "����");
		// 2014-10-14 a-biao
		roleName.put("5", "ʡ��˾����Ա");
		roleName.put("6", "�й�˾����Ա");
	}
	
	/**��Ա*/
	public static final int SHOP_ASSISTANT = 0 ;
	/**����*/
	public static final int SHOP_MASTER = 1 ;
	/**�ƹ�רԱ*/
	public static final int MISSIONER = 2 ;
	/**������*/
	public static final int DELIVERY_MAN = 3;
	/**����*/
	public static final int MANAGER = 4;
	// 2014-10-14 a-biao
	/**ʡ��˾����Ա*/
	public static final int GD_MANAGER = 5;
	/**�й�˾����Ա*/
	public static final int CITY_MANAGER = 6;
	
	/**��ְ*/
	public static final int INCUMBENCY  = 0;
	/**��ְ*/
	public static final int DIMISSION = 1;
	
	
	public static String getRoleName(int role ){
		String r = "δ֪��ɫ";
		r = (roleName.get(role+"") != null)?(String)roleName.get(role+""):r;
		return r;
	}
	
}
