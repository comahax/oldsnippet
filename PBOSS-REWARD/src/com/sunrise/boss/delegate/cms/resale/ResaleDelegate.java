/**
 * auto-generated code
 * Fri Jan 04 15:56:32 CST 2008
 */
package com.sunrise.boss.delegate.cms.resale;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.resale.control.ResaleControl;
import com.sunrise.boss.business.cms.resale.control.ResaleControlBean;
import com.sunrise.boss.business.cms.resale.persistent.ResaleVO;
import com.sunrise.boss.business.cms.resale.persistent.ResaleListVO;

import java.io.Serializable;

/**
 * <p>
 * Title: ResaleDelegate
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
 * @author
 * @version 1.0
 */
public class ResaleDelegate {

	private static ResaleControl control;

	public ResaleDelegate() throws Exception {
		control = (ResaleControl) ControlFactory.build(ResaleControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public ResaleVO doCreate(ResaleVO vo, User user) throws Exception {
		return control.doCreate(vo, user);
	}

	public void doRemove(ResaleVO vo, User user) throws Exception {
		control.doRemove(vo, user);
	}

	public ResaleVO doUpdate(ResaleVO vo, User user) throws Exception {
		return control.doUpdate(vo, user);
	}

	public ResaleVO doFindByPk(Serializable pk, User user) throws Exception {
		return (ResaleVO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(ResaleListVO params, User user) throws Exception {
		return control.doQuery(params, user);
	}

	public DataPackage getMobileSequence(String sql,User user) throws Exception {
		return control.getMobileSequence(sql,user);
	}

	public String checkOpnID(String mobile, User user) throws Exception {
		return control.checkOpnID(mobile, user);
	}
	
}
