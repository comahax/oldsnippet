package com.sunrise.boss.business.common.loginlog.persistent;


import com.sunrise.jop.infrastructure.db.AbstractDAO;

public class LoginLogDAO extends AbstractDAO {
	
	public LoginLogDAO() {
		super(LoginLogVO.class);
	}

}
