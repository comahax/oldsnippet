/**
* auto-generated code
* Wed Mar 05 16:44:25 CST 2008
*/
package com.sunrise.boss.delegate.cms.reward.stdrewardbjlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.stdrewardbjlog.control.StdrewardbjlogControl;
import com.sunrise.boss.business.cms.reward.stdrewardbjlog.control.StdrewardbjlogControlBean;
import com.sunrise.boss.business.cms.reward.stdrewardbjlog.persistent.StdrewardbjlogVO;
import com.sunrise.boss.business.cms.reward.stdrewardbjlog.persistent.StdrewardbjlogListVO;

import java.io.Serializable;

/**
 * <p>Title: StdrewardbjlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p><p>Company: SUNRISE Tech Ltd.</p>
 * @author Zhang Fengchao
 * @version 1.0
 */
public class StdrewardbjlogDelegate {

    private static StdrewardbjlogControl control;

    public StdrewardbjlogDelegate() throws Exception {
        control = (StdrewardbjlogControl) ControlFactory.build(StdrewardbjlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public StdrewardbjlogVO doCreate(StdrewardbjlogVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(StdrewardbjlogVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public StdrewardbjlogVO doUpdate(StdrewardbjlogVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public StdrewardbjlogVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (StdrewardbjlogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(StdrewardbjlogListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
