package com.sunrise.boss.business.resmanage.common.control;

import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.ui.commons.User;

public interface CommonMethodControl extends AbstractControl {

	public SysparamVO doGetResSysparamVO(Long systemid, User user)
			throws Exception;

	public boolean isUseRessend(User user) throws Exception;

	public int doUpdateComstateToSale(Object req, User user) throws Exception;
}
