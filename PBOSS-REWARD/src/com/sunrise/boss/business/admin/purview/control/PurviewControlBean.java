/**
 * auto-generated code
 * Sat Jul 29 16:54:43 CST 2006
 */
package com.sunrise.boss.business.admin.purview.control;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.utils.CacheSinglton;
import com.sunrise.boss.common.utils.sysinfo.SysInfo;
import com.sunrise.boss.business.admin.purview.persistent.*;

/**
 * <p>
 * Title: CompanyControlBean
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @version 1.0 duhuazheng
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/admin/purview/control/PurviewControlBean"
 *           name="PurviewControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class PurviewControlBean extends AbstractControlBean implements
		PurviewControl {

	public boolean checkPurview(String operId, String purviewId)
			throws Exception {
		return getDAO().checkPurview(operId, purviewId);
	}

	private PurviewDAO getDAO() throws Exception {
		return new PurviewDAO() ;
	}


}