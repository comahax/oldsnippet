package com.sunrise.boss.delegate.resmanage.resparams;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.resmanage.resparams.persistent.ResparamsVO;
import com.sunrise.boss.business.resmanage.resparams.persistent.ResparamsListVO;
import com.sunrise.boss.business.resmanage.resparams.control.ResparamsControlBean;
import com.sunrise.boss.business.resmanage.resparams.control.ResparamsControl;

import java.io.Serializable;

public class ResparamsDelegate {

	private static ResparamsControl control;

	public ResparamsDelegate() throws Exception {
		control = (ResparamsControl) ControlFactory
				.build(ResparamsControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public ResparamsVO doCreate(ResparamsVO vo, User user) throws Exception {
		return control.doCreate(vo, user);
	}

	public void doRemove(ResparamsVO vo, User user) throws Exception {
		control.doRemove(vo, user);
	}

	public ResparamsVO doUpdate(ResparamsVO vo, User user) throws Exception {
		return control.doUpdate(vo, user);
	}

	public ResparamsVO doFindByPk(Serializable pk, User user) throws Exception {
		return (ResparamsVO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(ResparamsListVO params, User user)
			throws Exception {
		return control.doQuery(params, user);
	}

	public void doLog4create(String tablename, Object obj, User user)
			throws Exception {
		control.doLog4create(tablename, obj, user);
	}

	public void doLog4delete(String tablename, Object obj, User user)
			throws Exception {
		control.doLog4delete(tablename, obj, user);
	}

	public void doLog4update(String tablename, Object newobj, Object oldobj,
			User user) throws Exception {
		control.doLog4update(tablename, newobj, oldobj, user);
	}
}
