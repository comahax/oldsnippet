/**
 * auto-generated code
 * Sun Sep 27 11:45:09 CST 2009
 */
package com.sunrise.boss.delegate.cms.bbc.vstdreward;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.vstdreward.persistent.VstdrewardVO;
import com.sunrise.boss.business.cms.bbc.vstdreward.persistent.VstdrewardListVO;
import com.sunrise.boss.business.cms.bbc.vstdreward.control.VstdrewardControlBean;
import com.sunrise.boss.business.cms.bbc.vstdreward.control.VstdrewardControl;

import java.io.Serializable;

/**
 * <p>
 * Title: vstdrewardDelegate
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
public class VstdrewardDelegate {

	private static VstdrewardControl control;

	public VstdrewardDelegate() throws Exception {
		control = (VstdrewardControl) ControlFactory.build(VstdrewardControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public VstdrewardVO doCreate(VstdrewardVO vo, User user) throws Exception {
		return control.doCreate(vo, user);
	}

	public void doRemove(VstdrewardVO vo, User user) throws Exception {
		control.doRemove(vo, user);
	}

	public VstdrewardVO doUpdate(VstdrewardVO vo, User user) throws Exception {
		return control.doUpdate(vo, user);
	}

	public VstdrewardVO doFindByPk(Serializable pk, User user) throws Exception {
		return (VstdrewardVO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(VstdrewardListVO params, User user) throws Exception {
		return control.doQuery(params, user);
	}

	public DataPackage doQueryDesc(VstdrewardListVO params, User user) throws Exception {
		return control.doQueryDesc(params, user);
	}
	
	public DataPackage doQuery2(VstdrewardListVO params, User user) throws Exception {
		return control.doQuery2(params, user);
	}
}
