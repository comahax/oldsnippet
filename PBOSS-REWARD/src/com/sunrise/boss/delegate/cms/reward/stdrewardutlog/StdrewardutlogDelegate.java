/**
* auto-generated code
* Fri Oct 08 15:00:14 CST 2010
*/
package com.sunrise.boss.delegate.cms.reward.stdrewardutlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.stdrewardutlog.persistent.StdrewardutlogVO;
import com.sunrise.boss.business.cms.reward.stdrewardutlog.persistent.StdrewardutlogListVO;
import com.sunrise.boss.business.cms.reward.stdrewardutlog.control.StdrewardutlogControlBean;
import com.sunrise.boss.business.cms.reward.stdrewardutlog.control.StdrewardutlogControl;

import java.io.Serializable;

/**
 * <p>Title: StdrewardutlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class StdrewardutlogDelegate {

    private static StdrewardutlogControl control;

    public StdrewardutlogDelegate() throws Exception {
        control = (StdrewardutlogControl) ControlFactory.build(StdrewardutlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public StdrewardutlogVO doCreate(StdrewardutlogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(StdrewardutlogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public StdrewardutlogVO doUpdate(StdrewardutlogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public StdrewardutlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (StdrewardutlogVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(StdrewardutlogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
