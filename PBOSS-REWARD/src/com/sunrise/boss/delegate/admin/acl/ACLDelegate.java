package com.sunrise.boss.delegate.admin.acl;

import com.sunrise.boss.business.admin.acl.control.ACLControl;
import com.sunrise.boss.business.admin.acl.control.ACLControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.exception.delegate.DelegateException;

public class ACLDelegate {
	private ACLControl control;

	public ACLDelegate() throws Exception {
		control = (ACLControl) ControlFactory.build(ACLControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public boolean checkPermission(String operId, String PurviewId)
			throws Exception {
		return control.checkPermission(operId, PurviewId);
	}
}
