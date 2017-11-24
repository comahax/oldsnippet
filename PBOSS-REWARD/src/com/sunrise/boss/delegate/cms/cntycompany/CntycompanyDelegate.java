/**
 * auto-generated code
 * Fri Aug 25 11:16:40 CST 2006
 */
package com.sunrise.boss.delegate.cms.cntycompany;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.cntycompany.control.CntycompanyControl;
import com.sunrise.boss.business.cms.cntycompany.control.CntycompanyControlBean;
import com.sunrise.boss.business.cms.cntycompany.persistent.CntycompanyVO;
import com.sunrise.boss.business.cms.cntycompany.persistent.CntycompanyListVO;

import java.io.Serializable;

/**
 * <p>
 * Title: CntycompanyDelegate
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
 * @author yjr
 * @version 1.0
 */
public class CntycompanyDelegate {

	private static CntycompanyControl control;

	public CntycompanyDelegate() throws Exception {
		control = (CntycompanyControl) ControlFactory
				.build(CntycompanyControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public CntycompanyVO doCreate(CntycompanyVO vo, User user) throws Exception {
		return control.doCreate(vo, user);
	}

	public void doRemove(CntycompanyVO vo, User user) throws Exception {
		control.doRemove(vo, user);
	}

	public CntycompanyVO doUpdate(CntycompanyVO vo, User user) throws Exception {
		return control.doUpdate(vo, user);
	}

	public CntycompanyVO doFindByPk(Serializable pk, User user)
			throws Exception {
		return (CntycompanyVO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(CntycompanyListVO params, User user)
			throws Exception {
		return control.doQuery(params, user);
	}

	public DataPackage getCntycompanysOfCity(String cityid, User user)
			throws Exception {
		return control.getCntycompanysOfCity(cityid, user);
	}

	public DataPackage doQueryByOprcode(CntycompanyListVO params, User user)
			throws Exception {
		return control.doQueryByOprcode(params, user);
	}
	
    public boolean doIfOrgcodenull(String adacode, User user) throws Exception{
    	return control.doIfOrgcodenull(adacode, user);
    }
    public void doUpdateOrgcode(String adacode, String orgcode, User user)throws Exception{
    	control.doUpdateOrgcode(adacode, orgcode, user);
    }
    public String doGetOrgcode(String adacode, User user) throws Exception {
    	return control.doGetOrgcode(adacode, user);
    }
}
