/**
* auto-generated code
* Thu Jul 28 10:25:58 CST 2011
*/
package com.sunrise.boss.delegate.cms.rewardsms;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.rewardsms.persistent.RewardsmsVO;
import com.sunrise.boss.business.cms.rewardsms.persistent.RewardsmsListVO;
import com.sunrise.boss.business.cms.rewardsms.control.RewardsmsControlBean;
import com.sunrise.boss.business.cms.rewardsms.control.RewardsmsControl;

import java.io.Serializable;

/**
 * <p>Title: RewardsmsDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class RewardsmsDelegate {

    private static RewardsmsControl control;

    public RewardsmsDelegate() throws Exception {
        control = (RewardsmsControl) ControlFactory.build(RewardsmsControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public RewardsmsVO doCreate(RewardsmsVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(RewardsmsVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public RewardsmsVO doUpdate(RewardsmsVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public RewardsmsVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (RewardsmsVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(RewardsmsListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

    public RewardsmsVO doCreate1(RewardsmsVO vo, User user)
	    throws Exception {
	    return control.doCreate1(vo, user);
	}
}
