/**
 * auto-generated code
 * Wed Mar 05 16:41:04 CST 2008
 */
package com.sunrise.boss.delegate.cms.reward.rewardrulequery;

import java.io.Serializable;
import java.util.List;

import com.sunrise.boss.business.cms.reward.rewardrulequery.control.RewardrulequeryControl;
import com.sunrise.boss.business.cms.reward.rewardrulequery.control.RewardrulequeryControlBean;
import com.sunrise.boss.business.cms.reward.rewardrulequery.persistent.RewardrulequeryListVO;
import com.sunrise.boss.business.cms.reward.rewardrulequery.persistent.RewardrulequeryVO;
import com.sunrise.boss.business.cms.reward.stdrewardbj.persistent.StdrewardbjListVO;
import com.sunrise.boss.business.cms.reward.stdrewardbj.persistent.StdrewardbjVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: StdrewardbjDelegate
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * <p>
 * Company: SUNRISE Tech Ltd.
 * </p>
 * 
 * @author linli
 * @version 1.0
 */
public class RewardrulequeryDelegate {

	private static RewardrulequeryControl control;
	
	public RewardrulequeryDelegate() throws Exception {
        control = (RewardrulequeryControl) ControlFactory.build(RewardrulequeryControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

	public RewardrulequeryVO doCreate(RewardrulequeryVO vo, User user) throws Exception {
		return control.doCreate(vo, user);
	}

	public void doRemove(RewardrulequeryVO vo, User user) throws Exception {
		control.doRemove(vo, user);
	}

	public RewardrulequeryVO doUpdate(RewardrulequeryVO vo, User user) throws Exception {
		return control.doUpdate(vo, user);
	}

	public RewardrulequeryVO doFindByPk(Serializable pk, User user)
			throws Exception {
		return (RewardrulequeryVO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(RewardrulequeryListVO params, User user)
			throws Exception {
		return control.doQuery(params, user);
	}

}
