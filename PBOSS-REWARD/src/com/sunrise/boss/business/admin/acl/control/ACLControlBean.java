package com.sunrise.boss.business.admin.acl.control;

import com.sunrise.boss.business.admin.acl.persistent.ACLDAO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/admin/acl/control/ACLControlBean"
*    name="ACLControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class ACLControlBean extends AbstractControlBean implements ACLControl {

	public boolean checkPermission(String operId, String tokenId)
			throws Exception {
		return getDAO().checkPermission(operId, tokenId);
	}

	private ACLDAO getDAO() throws Exception {
		return new ACLDAO();
	}
}
