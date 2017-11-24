package com.gmcc.pboss.control.base.organization;


import java.io.Serializable;

import com.gmcc.pboss.business.base.organization.OrganizationDBParam;
import com.gmcc.pboss.business.base.organization.OrganizationVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: Cmpsmscon
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
 * @author 
 * @version 1.0
 */

public interface Organization extends AbstractControl{
	
	public OrganizationVO doCreate(OrganizationVO vo)throws Exception;
	
	public void doRemoveByVO(OrganizationVO vo)throws Exception;
	
	public void doRemoveByPK(Serializable pk)throws Exception;
	
	public OrganizationVO doUpdate(OrganizationVO vo)throws Exception;
	
	public OrganizationVO doFindByPk(Serializable pk)throws Exception;
	
	public DataPackage doQuery(OrganizationDBParam params)throws Exception;
}
