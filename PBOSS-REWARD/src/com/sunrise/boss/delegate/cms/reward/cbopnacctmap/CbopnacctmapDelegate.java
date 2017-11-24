/**
* auto-generated code
* Mon Sep 22 09:01:03 CST 2008
*/
package com.sunrise.boss.delegate.cms.reward.cbopnacctmap;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.cbopnacctmap.persistent.CbopnacctmapVO;
import com.sunrise.boss.business.cms.reward.cbopnacctmap.persistent.CbopnacctmapListVO;
import com.sunrise.boss.business.cms.reward.cbopnacctmap.control.CbopnacctmapControlBean;
import com.sunrise.boss.business.cms.reward.cbopnacctmap.control.CbopnacctmapControl;

import java.io.Serializable;

/**
 * <p>Title: CbopnacctmapDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class CbopnacctmapDelegate {

    private static CbopnacctmapControl control;

    public CbopnacctmapDelegate() throws Exception {
        control = (CbopnacctmapControl) ControlFactory.build(CbopnacctmapControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public CbopnacctmapVO doCreate(CbopnacctmapVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(CbopnacctmapVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public CbopnacctmapVO doUpdate(CbopnacctmapVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public CbopnacctmapVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (CbopnacctmapVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(CbopnacctmapListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
