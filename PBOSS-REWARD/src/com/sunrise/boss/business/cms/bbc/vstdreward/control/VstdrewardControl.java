/**
 * auto-generated code
 * Sun Sep 27 11:45:09 CST 2009
 */
package com.sunrise.boss.business.cms.bbc.vstdreward.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.vstdreward.persistent.VstdrewardVO;
import com.sunrise.boss.business.cms.bbc.vstdreward.persistent.VstdrewardListVO;

import java.io.Serializable;

/**
 * <p>
 * Title: vstdrewardControl
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
 * @author Jerimy
 * @version 1.0
 */
public interface VstdrewardControl extends AbstractControl {
	public VstdrewardVO doCreate(VstdrewardVO vo, User user) throws Exception;

	public void doRemove(VstdrewardVO vo, User user) throws Exception;

	public VstdrewardVO doUpdate(VstdrewardVO vo, User user) throws Exception;

	public VstdrewardVO doFindByPk(Serializable pk, User user) throws Exception;

	public DataPackage doQuery(VstdrewardListVO params, User user) throws Exception;

	public DataPackage doQueryDesc(VstdrewardListVO params, User user) throws Exception;
	
	public DataPackage doQuery2(VstdrewardListVO params, User user) throws Exception;

}
