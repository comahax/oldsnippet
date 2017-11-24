/**
* auto-generated code
* Wed Sep 02 10:14:50 CST 2009
*/
package com.sunrise.boss.delegate.cms.bbc.unvrewardtotal;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.unvrewardtotal.persistent.UnvRewardtotalVO;
import com.sunrise.boss.business.cms.bbc.unvrewardtotal.persistent.UnvRewardtotalListVO;
import com.sunrise.boss.business.cms.bbc.unvrewardtotal.control.UnvRewardtotalControlBean;
import com.sunrise.boss.business.cms.bbc.unvrewardtotal.control.UnvRewardtotalControl;

import java.io.Serializable;

/**
 * <p>Title: UnvRewardtotalDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class UnvRewardtotalDelegate {

    private static UnvRewardtotalControl control;

    public UnvRewardtotalDelegate() throws Exception {
        control = (UnvRewardtotalControl) ControlFactory.build(UnvRewardtotalControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public UnvRewardtotalVO doCreate(UnvRewardtotalVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(UnvRewardtotalVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public UnvRewardtotalVO doUpdate(UnvRewardtotalVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public UnvRewardtotalVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (UnvRewardtotalVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(UnvRewardtotalListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
