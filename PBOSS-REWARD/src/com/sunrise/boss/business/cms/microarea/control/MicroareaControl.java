/**
 * auto-generated code
 * Wed Apr 11 10:59:58 CST 2007
 */
package com.sunrise.boss.business.cms.microarea.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.microarea.persistent.MicroareaVO;
import com.sunrise.boss.business.cms.microarea.persistent.MicroareaListVO;

import java.io.Serializable;

/**
 * <p>
 * Title: MicroareaControl
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author Ye Daoe
 * @version 1.0
 */
public interface MicroareaControl extends AbstractControl {
	public MicroareaVO doCreate(MicroareaVO vo, User user) throws Exception;

	public void doRemove(MicroareaVO vo, User user) throws Exception;

	public MicroareaVO doUpdate(MicroareaVO vo, User user) throws Exception;

	public MicroareaVO doFindByPk(Serializable pk, User user) throws Exception;

	public DataPackage doQuery(MicroareaListVO params, User user)
			throws Exception;

	public DataPackage doQueryByOprcode(MicroareaListVO params, User user)
			throws Exception;
	
    public boolean doIfOrgcodenull(String adacode, User user) throws Exception;
    
    public void doUpdateOrgcode(String adacode, String orgcode, User user)
		throws Exception;
    
    public String doGetOrgcode(String adacode, User user) throws Exception ;
}
