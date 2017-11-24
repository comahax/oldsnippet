package com.sunrise.jop.common.businesslog;

import com.sunrise.jop.common.commoncontrol.CommonBO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.db.BaseDAO;
import com.sunrise.jop.infrastructure.db.DAOFactory;

public class BusinessLogBO extends CommonBO implements BusinessLogControl {
	
	public BusinessLogBO(){
	}
	
	public Object doLogCreate(Object vo) throws Exception {
		BaseDAO ordinaryDAO = DAOFactory.buildCommonDAO(voClass, user);
		try {
			vo = ordinaryDAO.create(vo);
			return vo;
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public Class getVoClass() {
		return voClass;
	}

	public void setVoClass(Class voClass) {
		this.voClass = voClass;
	}

	private Class voClass;
	
}
