package com.gmcc.pboss.control.base.config;

import java.io.Serializable;

import com.gmcc.pboss.business.base.config.ConfigDAO;
import com.gmcc.pboss.business.base.config.ConfigDBParam;
import com.gmcc.pboss.business.base.config.ConfigVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class ConfigBO extends AbstractControlBean implements Config {

	private static final long serialVersionUID = 6091562314274350430L;

	public DataPackage doQuery(ConfigDBParam params) throws Exception {
		try {
			ConfigDAO dao = (ConfigDAO) DAOFactory.build(ConfigDAO.class, user);
			return dao.query(params);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ConfigVO doFindByPk(Serializable pk) throws Exception {
		ConfigDAO dao = (ConfigDAO) DAOFactory.build(ConfigDAO.class, user);
		return (ConfigVO) dao.findByPk(pk);
	}
}
