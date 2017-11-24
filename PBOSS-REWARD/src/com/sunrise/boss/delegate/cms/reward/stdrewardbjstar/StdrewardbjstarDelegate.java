/**
* auto-generated code
* Sat Oct 10 09:26:17 CST 2009
*/
package com.sunrise.boss.delegate.cms.reward.stdrewardbjstar;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.stdrewardbjstar.persistent.StdrewardbjstarVO;
import com.sunrise.boss.business.cms.reward.stdrewardbjstar.persistent.StdrewardbjstarListVO;
import com.sunrise.boss.business.cms.reward.stdrewardbjstar.control.StdrewardbjstarControlBean;
import com.sunrise.boss.business.cms.reward.stdrewardbjstar.control.StdrewardbjstarControl;

import java.io.Serializable;

/**
 * <p>Title: StdrewardbjstarDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class StdrewardbjstarDelegate {

    private static StdrewardbjstarControl control;

    public StdrewardbjstarDelegate() throws Exception {
        control = (StdrewardbjstarControl) ControlFactory.build(StdrewardbjstarControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public StdrewardbjstarVO doCreate(StdrewardbjstarVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(StdrewardbjstarVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public StdrewardbjstarVO doUpdate(StdrewardbjstarVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public StdrewardbjstarVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (StdrewardbjstarVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(StdrewardbjstarListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
