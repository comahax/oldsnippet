package com.sunrise.jop.ui.struts2;

import com.sunrise.jop.infrastructure.db.*;

/**
 * �û��ṩ�߽ӿڡ���ȡ�û�ʵ�������ڱ�ʾ���ײ���ݾ��������ȡ��ǰ�Ự���û�
 * @author He Kun
 *
 */
public interface UserProvider {
	
	/**
	 * ��ȡ�û�ʵ����
	 * @return
	 */
	DBAccessUser getUser();
}
