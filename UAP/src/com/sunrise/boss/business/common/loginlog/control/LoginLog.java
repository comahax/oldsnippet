package com.sunrise.boss.business.common.loginlog.control;

import java.io.Serializable;

import com.sunrise.boss.business.common.loginlog.persistent.LoginLogDBParam;
import com.sunrise.boss.business.common.loginlog.persistent.LoginLogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

public interface LoginLog extends AbstractControl{
	
	 public LoginLogVO doFindByPk(Serializable pk) throws Exception;

	 public DataPackage doQuery(LoginLogDBParam params) throws Exception;
	 
	 public LoginLogVO doCreate(LoginLogVO vo) throws Exception;

}
