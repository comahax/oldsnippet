/**
* auto-generated code
* Thu Sep 04 10:43:57 CST 2008
*/
package com.sunrise.boss.delegate.cms.bbc.opnacctmap;

import java.io.Serializable;

import com.sunrise.boss.business.cms.bbc.opnacctmap.control.OpnacctmapControl;
import com.sunrise.boss.business.cms.bbc.opnacctmap.control.OpnacctmapControlBean;
import com.sunrise.boss.business.cms.bbc.opnacctmap.persistent.OpnacctmapListVO;
import com.sunrise.boss.business.cms.bbc.opnacctmap.persistent.OpnacctmapVO;
import com.sunrise.boss.business.fee.woff.acct.persistent.AcctListVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: OpnacctmapDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class OpnacctmapDelegate {

    private static OpnacctmapControl control;

    public OpnacctmapDelegate() throws Exception {
        control = (OpnacctmapControl) ControlFactory.build(OpnacctmapControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public OpnacctmapVO doCreate(OpnacctmapVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(OpnacctmapVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public OpnacctmapVO doUpdate(OpnacctmapVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public OpnacctmapVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (OpnacctmapVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(OpnacctmapListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
