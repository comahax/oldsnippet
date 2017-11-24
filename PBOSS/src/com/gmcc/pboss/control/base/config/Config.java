package com.gmcc.pboss.control.base.config;

import java.io.Serializable;

import com.gmcc.pboss.business.base.config.ConfigDBParam;
import com.gmcc.pboss.business.base.config.ConfigVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

public interface Config extends AbstractControl {
	public DataPackage doQuery(ConfigDBParam params) throws Exception;

	public ConfigVO doFindByPk(Serializable pk) throws Exception;
}
