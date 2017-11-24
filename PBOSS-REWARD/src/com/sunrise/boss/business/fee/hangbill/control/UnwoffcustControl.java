package com.sunrise.boss.business.fee.hangbill.control;

import java.rmi.*;
import java.io.Serializable;
import javax.ejb.*;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.fee.hangbill.persistent.*;

public interface UnwoffcustControl extends AbstractControl {
	public UnwoffcustVO doCreate(UnwoffcustVO vo, User user)
    	throws Exception;

	public void doRemove(UnwoffcustVO vo, User user)
    	throws Exception;

	public UnwoffcustVO doUpdate(UnwoffcustVO vo, User user)
    	throws Exception;

	public UnwoffcustVO doFindByPk(Serializable pk, User user)
    	throws Exception;

	public DataPackage doQuery(UnwoffcustListVO params, User user)
    	throws Exception;

}