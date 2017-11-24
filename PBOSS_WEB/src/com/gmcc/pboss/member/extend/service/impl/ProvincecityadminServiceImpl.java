package com.gmcc.pboss.member.extend.service.impl;

import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.member.extend.dao.ProvincecityadminDao;
import com.gmcc.pboss.member.extend.model.ChPwEmployeeextend;
import com.gmcc.pboss.member.extend.model.Provincecityadmin;
import com.gmcc.pboss.member.extend.service.ProvincecityadminService;

public class ProvincecityadminServiceImpl extends BaseServiceImpl implements
		ProvincecityadminService {

	private ProvincecityadminDao provincecityadminDao;

	public Provincecityadmin getCityadminLogin(Long mobile){
		// TODO Auto-generated method stub
		return this.provincecityadminDao.getCityadminLogin(mobile);
	}

	public ProvincecityadminDao getProvincecityadminDao() {
		return provincecityadminDao;
	}

	public void setProvincecityadminDao(ProvincecityadminDao provincecityadminDao) {
		this.provincecityadminDao = provincecityadminDao;
	}
	
	

}
