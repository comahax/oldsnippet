/**
* auto-generated code
* Mon Aug 02 10:12:57 CST 2010
*/
package com.sunrise.boss.delegate.cms.bbc.bbcwaylevel;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.bbcwaylevel.persistent.BbcWaylevelVO;
import com.sunrise.boss.business.cms.bbc.bbcwaylevel.persistent.BbcWaylevelListVO;
import com.sunrise.boss.business.cms.bbc.bbcwaylevel.control.BbcWaylevelControlBean;
import com.sunrise.boss.business.cms.bbc.bbcwaylevel.control.BbcWaylevelControl;

import java.io.Serializable;

/**
 * <p>Title: BbcWaylevelDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class BbcWaylevelDelegate {

    private static BbcWaylevelControl control;

    public BbcWaylevelDelegate() throws Exception {
        control = (BbcWaylevelControl) ControlFactory.build(BbcWaylevelControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public BbcWaylevelVO doCreate(BbcWaylevelVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(BbcWaylevelVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public BbcWaylevelVO doUpdate(BbcWaylevelVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public BbcWaylevelVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (BbcWaylevelVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(BbcWaylevelListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
