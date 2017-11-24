package com.gmcc.pboss.business.base.config;

import com.sunrise.jop.infrastructure.db.AbstractDAO;


/**
 * <p>Title: ConfigDAO</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author caiwr
 * @version 1.0
 */
public class ConfigDAO extends AbstractDAO {
	
	public ConfigDAO() {
		super(ConfigVO.class);
	}
}
