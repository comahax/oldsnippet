package com.gmcc.pboss.control.base.role;

import java.io.Serializable;

import com.gmcc.pboss.business.base.role.RoleDBParam;
import com.gmcc.pboss.business.base.role.RoleVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public interface Role extends AbstractControl{
	
	public RoleVO doCreate(RoleVO vo) throws Exception;

	public void doRemoveByVO(RoleVO vo) throws Exception;

	public void doRemoveByPK(Serializable pk) throws Exception;

	public RoleVO doUpdate(RoleVO vo) throws Exception;

	public RoleVO doFindByPk(Serializable pk) throws Exception;

	public DataPackage doQuery(RoleDBParam params,User user) throws Exception;
	
	public boolean doIfAdmin() throws Exception ;
}
