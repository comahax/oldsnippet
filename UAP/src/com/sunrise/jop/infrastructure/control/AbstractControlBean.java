package com.sunrise.jop.infrastructure.control;

import com.sunrise.jop.infrastructure.db.DBAccessUser;

/**
 * <p>Title: 抽象ControlBean类</p>
 *
 * <p>Description: 封装了SessionBean、EJBLocalObject接口必须实现的方法</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: sunrise</p>
 *
 * @author DuHuazheng && HuangBaiming
 * @author He Kun
 *
 * @version 1.0
 * @version 1.2 He Kun 2007-12, 实现 Authorizable 接口，用于设置 user参数
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
