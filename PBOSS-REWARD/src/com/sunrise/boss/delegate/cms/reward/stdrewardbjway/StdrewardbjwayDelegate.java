/**
* auto-generated code
* Tue Jan 05 10:01:34 CST 2010
*/
package com.sunrise.boss.delegate.cms.reward.stdrewardbjway;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.stdrewardbjway.persistent.StdrewardbjwayVO;
import com.sunrise.boss.business.cms.reward.stdrewardbjway.persistent.StdrewardbjwayListVO;
import com.sunrise.boss.business.cms.reward.stdrewardbjway.control.StdrewardbjwayControlBean;
import com.sunrise.boss.business.cms.reward.stdrewardbjway.control.StdrewardbjwayControl;

import java.io.Serializable;

/**
 * <p>Title: StdrewardbjwayDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Canigar
 * @version 1.0
 */
public class StdrewardbjwayDelegate {

    private static StdrewardbjwayControl control;

    public StdrewardbjwayDelegate() throws Exception {
        control = (StdrewardbjwayControl) ControlFactory.build(StdrewardbjwayControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public StdrewardbjwayVO doCreate(StdrewardbjwayVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(StdrewardbjwayVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public StdrewardbjwayVO doUpdate(StdrewardbjwayVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public StdrewardbjwayVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (StdrewardbjwayVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(StdrewardbjwayListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
