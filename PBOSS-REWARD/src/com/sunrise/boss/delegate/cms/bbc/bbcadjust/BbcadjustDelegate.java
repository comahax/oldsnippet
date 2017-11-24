/**
* auto-generated code
* Wed Aug 26 15:42:00 CST 2009
*/
package com.sunrise.boss.delegate.cms.bbc.bbcadjust;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.bbcadjust.persistent.BbcadjustVO;
import com.sunrise.boss.business.cms.bbc.bbcadjust.persistent.BbcadjustListVO;
import com.sunrise.boss.business.cms.bbc.bbcadjust.control.BbcadjustControlBean;
import com.sunrise.boss.business.cms.bbc.bbcadjust.control.BbcadjustControl;

import java.io.Serializable;

/**
 * <p>Title: BbcadjustDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class BbcadjustDelegate {

    private static BbcadjustControl control;

    public BbcadjustDelegate() throws Exception {
        control = (BbcadjustControl) ControlFactory.build(BbcadjustControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public BbcadjustVO doCreate(BbcadjustVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(BbcadjustVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public BbcadjustVO doUpdate(BbcadjustVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public BbcadjustVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (BbcadjustVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(BbcadjustListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
