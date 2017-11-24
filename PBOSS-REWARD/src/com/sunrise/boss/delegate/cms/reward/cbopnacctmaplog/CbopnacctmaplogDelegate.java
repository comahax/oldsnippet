/**
* auto-generated code
* Mon Sep 22 09:03:07 CST 2008
*/
package com.sunrise.boss.delegate.cms.reward.cbopnacctmaplog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.cbopnacctmaplog.persistent.CbopnacctmaplogVO;
import com.sunrise.boss.business.cms.reward.cbopnacctmaplog.persistent.CbopnacctmaplogListVO;
import com.sunrise.boss.business.cms.reward.cbopnacctmaplog.control.CbopnacctmaplogControlBean;
import com.sunrise.boss.business.cms.reward.cbopnacctmaplog.control.CbopnacctmaplogControl;

import java.io.Serializable;

/**
 * <p>Title: CbopnacctmaplogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class CbopnacctmaplogDelegate {

    private static CbopnacctmaplogControl control;

    public CbopnacctmaplogDelegate() throws Exception {
        control = (CbopnacctmaplogControl) ControlFactory.build(CbopnacctmaplogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public CbopnacctmaplogVO doCreate(CbopnacctmaplogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(CbopnacctmaplogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public CbopnacctmaplogVO doUpdate(CbopnacctmaplogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public CbopnacctmaplogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (CbopnacctmaplogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(CbopnacctmaplogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
