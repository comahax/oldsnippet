/**
* auto-generated code
* Wed Aug 27 09:24:49 CST 2008
*/
package com.sunrise.boss.delegate.cms.bbc.stdreward;

import java.io.Serializable;

import com.sunrise.boss.business.cms.bbc.stdreward.control.BBCstdrewardControl;
import com.sunrise.boss.business.cms.bbc.stdreward.control.BBCstdrewardControlBean;
import com.sunrise.boss.business.cms.bbc.stdreward.persistent.BBCstdrewardListVO;
import com.sunrise.boss.business.cms.bbc.stdreward.persistent.BBCstdrewardVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: BBCstdrewardDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class BBCstdrewardDelegate {

    private static BBCstdrewardControl control;

    public BBCstdrewardDelegate() throws Exception {
        control = (BBCstdrewardControl) ControlFactory.build(BBCstdrewardControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public BBCstdrewardVO doCreate(BBCstdrewardVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(BBCstdrewardVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public BBCstdrewardVO doUpdate(BBCstdrewardVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public BBCstdrewardVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (BBCstdrewardVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(BBCstdrewardListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
