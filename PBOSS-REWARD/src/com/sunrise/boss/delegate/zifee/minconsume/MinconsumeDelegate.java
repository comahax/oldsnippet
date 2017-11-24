/**
 * auto-generated code
 * Fri Aug 08 14:58:15 CST 2008
 */
package com.sunrise.boss.delegate.zifee.minconsume;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.minconsume.control.MinconsumeControl;
import com.sunrise.boss.business.zifee.minconsume.control.MinconsumeControlBean;
import com.sunrise.boss.business.zifee.minconsume.persistent.MinconsumeVO;
import com.sunrise.boss.business.zifee.minconsume.persistent.MinconsumeListVO;

import java.io.Serializable;

/**
 * <p>
 * Title: MinconsumeDelegate
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
public class MinconsumeDelegate {

	private static MinconsumeControl control;

	public MinconsumeDelegate() throws Exception {
		control = (MinconsumeControl) ControlFactory
				.build(MinconsumeControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public MinconsumeVO doCreate(MinconsumeVO vo, User user) throws Exception {
		return control.doCreate(vo, user);
	}

	public void doRemove(MinconsumeVO vo, User user) throws Exception {
		control.doRemove(vo, user);
	}

	public MinconsumeVO doUpdate(MinconsumeVO vo, User user) throws Exception {
		return control.doUpdate(vo, user);
	}

	public MinconsumeVO doFindByPk(Serializable pk, User user) throws Exception {
		return (MinconsumeVO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(MinconsumeListVO params, User user)
			throws Exception {
		return control.doQuery(params, user);
	}

	public int calcResult(String yxplanid, User user) throws Exception {
		return control.calcResult(yxplanid, user);
	}

	public boolean hasCyclecount(String yxplanid, User user) throws Exception {
		return control.hasCyclecount(yxplanid, user);
	}

	public boolean canRemove(String yxplanid, String effectiveinterval,
			User user) throws Exception {
		return control.canRemove(yxplanid, effectiveinterval, user);
	}

	public int getNextIntevalValue(String yxplanid, String effectiveinterval,
			User user) throws Exception {
		return control.getNextIntevalValue(yxplanid, effectiveinterval, user);
	}
}
