/**
* auto-generated code
* Sun Sep 14 16:17:55 CST 2008
*/
package com.sunrise.boss.delegate.cms.bbc.opnacctmaplog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.opnacctmaplog.persistent.OpnacctmaplogVO;
import com.sunrise.boss.business.cms.bbc.opnacctmaplog.persistent.OpnacctmaplogListVO;
import com.sunrise.boss.business.cms.bbc.opnacctmaplog.control.OpnacctmaplogControlBean;
import com.sunrise.boss.business.cms.bbc.opnacctmaplog.control.OpnacctmaplogControl;

import java.io.Serializable;

/**
 * <p>Title: OpnacctmaplogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class OpnacctmaplogDelegate {

    private static OpnacctmaplogControl control;

    public OpnacctmaplogDelegate() throws Exception {
        control = (OpnacctmaplogControl) ControlFactory.build(OpnacctmaplogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public OpnacctmaplogVO doCreate(OpnacctmaplogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(OpnacctmaplogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public OpnacctmaplogVO doUpdate(OpnacctmaplogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public OpnacctmaplogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (OpnacctmaplogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(OpnacctmaplogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
