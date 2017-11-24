package com.sunrise.boss.ui.commons.multiselect;

import java.util.Collection;

import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: Multiselect
 * </p>
 * <p>
 * Description: ��ѡ���������ݻ�ȡ�ӿ�
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company: Sunrise Tech Ltd.
 * </p>
 * 
 * @author Zhang Fengchao
 * @since 1.0
 * @version 1.0
 * @date 2008-08-28
 */
public interface Multiselect {
	/**
	 * ��ȡ��ʼ��ѡ����
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Collection getInitSource(User user) throws Exception;

	/**
	 * ��ȡ��ʼ��ѡ����
	 * 
	 * @param codes
	 * @param user
	 * @return
	 * @throws Exception
	 */

	public Collection getInitExist(String[] codes, User user) throws Exception;

	/**
	 * ��ѯ��ѡ����
	 * 
	 * @param code
	 *            ��ѯ����
	 * @param name
	 *            ��ѯ����
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Collection querySource(String code, String name, User user)
			throws Exception;
}
