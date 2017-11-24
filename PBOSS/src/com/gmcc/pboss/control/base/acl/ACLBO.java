package com.gmcc.pboss.control.base.acl;

import com.gmcc.pboss.business.base.acl.ACLDAO;
import com.sunrise.jop.infrastructure.config.CoreConfigInfo;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
/**
 * @ejb.bean local-jndi-name="com/gmcc/pboss/control/base/acl/ACLBO"
 *           name="ACL" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class ACLBO extends AbstractControlBean implements ACL{

	public boolean doCheckPermission(String operId, String tokenId)
			throws Exception {
		ACLDAO dao = new ACLDAO();
		return dao.checkPermission(operId, tokenId);
	}
	
}
