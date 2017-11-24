package com.sunrise.jop.infrastructure.control;

import com.sunrise.jop.infrastructure.db.DBAccessUser;

/**
 * <p>
 * Title: ����ControlBean��
 * </p>
 * 
 * <p>
 * Description: ��װ��SessionBean��EJBLocalObject�ӿڱ���ʵ�ֵķ���
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * 
 * <p>
 * Company: sunrise
 * </p>
 * 
 * @author DuHuazheng && HuangBaiming
 * @author He Kun
 * 
 * @version 1.0
 * @version 1.2 He Kun 2007-12, ʵ�� Authorizable �ӿڣ��������� user����
 */
public class AbstractControlBean implements Authorizable {

	protected DBAccessUser user;

	public DBAccessUser getUser() {
		return user;
	}

	public void setUser(DBAccessUser user) {
		this.user = user;
	}

}
