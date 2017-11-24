package com.sunrise.boss.business.admin.acl.control;

import com.sunrise.boss.common.base.control.AbstractControl;

public interface ACLControl extends AbstractControl{
	public boolean checkPermission(String operId,String tokenId) throws Exception;
}
