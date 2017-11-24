/**
* auto-generated code
* Wed Aug 26 15:55:18 CST 2009
*/
package com.sunrise.boss.delegate.cms.bbc.bbcadjustlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.bbcadjustlog.persistent.BbcadjustlogVO;
import com.sunrise.boss.business.cms.bbc.bbcadjustlog.persistent.BbcadjustlogListVO;
import com.sunrise.boss.business.cms.bbc.bbcadjustlog.control.BbcadjustlogControlBean;
import com.sunrise.boss.business.cms.bbc.bbcadjustlog.control.BbcadjustlogControl;

import java.io.Serializable;

/**
 * <p>Title: BbcadjustlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class BbcadjustlogDelegate {

    private static BbcadjustlogControl control;

    public BbcadjustlogDelegate() throws Exception {
        control = (BbcadjustlogControl) ControlFactory.build(BbcadjustlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public BbcadjustlogVO doCreate(BbcadjustlogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(BbcadjustlogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public BbcadjustlogVO doUpdate(BbcadjustlogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public BbcadjustlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (BbcadjustlogVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(BbcadjustlogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
