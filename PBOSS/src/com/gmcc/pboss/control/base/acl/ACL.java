package com.gmcc.pboss.control.base.acl;

import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface ACL extends AbstractControl{
	
	public boolean doCheckPermission(String operId,String tokenId) throws Exception;
	
}
