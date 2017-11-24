/**
* auto-generated code
* Tue Sep 18 16:24:42 CST 2012
*/
package com.sunrise.boss.delegate.cms.reward.stdrewardbjnoncyc;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.stdrewardbjnoncyc.persistent.StdrewardbjnoncycVO;
import com.sunrise.boss.business.cms.reward.stdrewardbjnoncyc.persistent.StdrewardbjnoncycListVO;
import com.sunrise.boss.business.cms.reward.stdrewardbjnoncyc.control.StdrewardbjnoncycControlBean;
import com.sunrise.boss.business.cms.reward.stdrewardbjnoncyc.control.StdrewardbjnoncycControl;

import java.io.Serializable;

/**
 * <p>Title: StdrewardbjnoncycDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class StdrewardbjnoncycDelegate {

    private static StdrewardbjnoncycControl control;

    public StdrewardbjnoncycDelegate() throws Exception {
        control = (StdrewardbjnoncycControl) ControlFactory.build(StdrewardbjnoncycControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public StdrewardbjnoncycVO doCreate(StdrewardbjnoncycVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(StdrewardbjnoncycVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public StdrewardbjnoncycVO doUpdate(StdrewardbjnoncycVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public StdrewardbjnoncycVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (StdrewardbjnoncycVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(StdrewardbjnoncycListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
