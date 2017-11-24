package com.sunrise.boss.ui.commons.taglib.code2name.impl;

import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.taglib.code2name.Code2name;

/**
 * �����example���벻Ҫ����ʽ����ʹ��
 * 
 * @author baiming
 * 
 */
public class Sex implements Code2name {

	public String translate(Object code,User user) {
		/**
		 * �Զ���������4ʵ�ֱȽϸ��ӵĲ����:��������ⲿϵͳ�ӿڣ�����ѯ��
		 * ������subid���mobileno��Ҫ���û�Ϊ�Ľӿڣ�

        	try {
            	HuaWeiInterface huawei = factroy.build(); 
				return huawei.getMobileno(subid);
			} catch (Exception e) {
				log.error("translate error",e);
				return code.toString();
			} 

		 */
		
		/**
		 * ����ķ�����޴#���Ҳ�Ҫѧ����ֻ��һ�����ӣ�
		 */
		if ("1".equals(code)) {
			return "��";
		} else if ("2".equals(code)) {
			return "Ů";
		} else {
			return code.toString();
		}

	}
}
