/**
* auto-generated code
* Sat Oct 10 09:27:09 CST 2009
*/
package com.sunrise.boss.delegate.cms.reward.stdrewardbjstarlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.stdrewardbjstarlog.persistent.StdrewardbjstarlogVO;
import com.sunrise.boss.business.cms.reward.stdrewardbjstarlog.persistent.StdrewardbjstarlogListVO;
import com.sunrise.boss.business.cms.reward.stdrewardbjstarlog.control.StdrewardbjstarlogControlBean;
import com.sunrise.boss.business.cms.reward.stdrewardbjstarlog.control.StdrewardbjstarlogControl;

import java.io.Serializable;

/**
 * <p>Title: StdrewardbjstarlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class StdrewardbjstarlogDelegate {

    private static StdrewardbjstarlogControl control;

    public StdrewardbjstarlogDelegate() throws Exception {
        control = (StdrewardbjstarlogControl) ControlFactory.build(StdrewardbjstarlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public StdrewardbjstarlogVO doCreate(StdrewardbjstarlogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(StdrewardbjstarlogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public StdrewardbjstarlogVO doUpdate(StdrewardbjstarlogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public StdrewardbjstarlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (StdrewardbjstarlogVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(StdrewardbjstarlogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
