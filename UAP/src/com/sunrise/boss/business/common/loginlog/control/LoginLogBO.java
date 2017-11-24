package com.sunrise.boss.business.common.loginlog.control;

import java.io.Serializable;

import com.sunrise.boss.business.common.loginlog.persistent.LoginLogDAO;
import com.sunrise.boss.business.common.loginlog.persistent.LoginLogDBParam;
import com.sunrise.boss.business.common.loginlog.persistent.LoginLogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class LoginLogBO extends AbstractControlBean implements LoginLog{

	public LoginLogVO doCreate(LoginLogVO vo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public LoginLogVO doFindByPk(Serializable pk) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public DataPackage doQuery(LoginLogDBParam params) throws Exception {
		LoginLogDAO dao = (LoginLogDAO) BOFactory.build(LoginLogDAO.class);
		
		DataPackage dp = dao.query(params);
		
		if(dp!= null && dp.getDatas() !=null && dp.getDatas().size()>0){
			return dp;
			
		}
		
		//dao.setDbFlag(dbFlag);
		return null;
	}

}
