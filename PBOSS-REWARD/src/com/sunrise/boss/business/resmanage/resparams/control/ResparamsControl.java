package com.sunrise.boss.business.resmanage.resparams.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.resmanage.resparams.persistent.ResparamsVO;
import com.sunrise.boss.business.resmanage.resparams.persistent.ResparamsListVO;

import java.io.Serializable;

public interface ResparamsControl extends AbstractControl {
	public ResparamsVO doCreate(ResparamsVO vo, User user) throws Exception;

	public void doRemove(ResparamsVO vo, User user) throws Exception;

	public ResparamsVO doUpdate(ResparamsVO vo, User user) throws Exception;

	public ResparamsVO doFindByPk(Serializable pk, User user) throws Exception;

	public DataPackage doQuery(ResparamsListVO params, User user)
			throws Exception;

	public void doLog4create(String tablename, Object obj, User user)
			throws Exception;

	public void doLog4delete(String tablename, Object obj, User user)
			throws Exception;

	public void doLog4update(String tablename, Object newobj, Object oldobj,
			User user) throws Exception;
}
