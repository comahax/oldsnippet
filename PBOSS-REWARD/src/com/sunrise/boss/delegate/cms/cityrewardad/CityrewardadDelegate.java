/**
 * auto-generated code
 * Sun Feb 01 10:31:20 CST 2009
 */
package com.sunrise.boss.delegate.cms.cityrewardad;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.cityrewardad.persistent.CityrewardadVO;
import com.sunrise.boss.business.cms.cityrewardad.persistent.CityrewardadListVO;
import com.sunrise.boss.business.cms.cityrewardad.control.CityrewardadControlBean;
import com.sunrise.boss.business.cms.cityrewardad.control.CityrewardadControl;

import java.io.Serializable;

/**
 * <p>Title: CityrewardadDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class CityrewardadDelegate {

	private static CityrewardadControl control;

	public CityrewardadDelegate() throws Exception {
		control = (CityrewardadControl) ControlFactory
				.build(CityrewardadControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public CityrewardadVO doCreate(CityrewardadVO vo, User user)
			throws Exception {
		return control.doCreate(vo, user);
	}

	public void doRemove(CityrewardadVO vo, User user) throws Exception {
		control.doRemove(vo, user);
	}

	public CityrewardadVO doUpdate(CityrewardadVO vo, User user)
			throws Exception {
		return control.doUpdate(vo, user);
	}

	public CityrewardadVO doFindByPk(Serializable pk, User user)
			throws Exception {
		return (CityrewardadVO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(CityrewardadListVO params, User user)
			throws Exception {
		return control.doQuery(params, user);
	}
}
