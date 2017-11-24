/**
* auto-generated code
* Fri Feb 01 18:05:53 CST 2008
*/
package com.sunrise.boss.delegate.cms.stdreward;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.stdreward.control.StdrewardControl;
import com.sunrise.boss.business.cms.stdreward.control.StdrewardControlBean;
import com.sunrise.boss.business.cms.stdreward.persistent.StdrewardVO;
import com.sunrise.boss.business.cms.stdreward.persistent.StdrewardListVO;

import java.io.Serializable;

/**
 * <p>Title: StdrewardDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class StdrewardDelegate {

    private static StdrewardControl control;

    public StdrewardDelegate() throws Exception {
        control = (StdrewardControl) ControlFactory.build(StdrewardControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public StdrewardVO doCreate(StdrewardVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(StdrewardVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public StdrewardVO doUpdate(StdrewardVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public StdrewardVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (StdrewardVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(StdrewardListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
    public DataPackage doQueryfor5455(StdrewardListVO params, User user )
    throws Exception {
    return control.doQueryfor5455(params, user);
}
}
