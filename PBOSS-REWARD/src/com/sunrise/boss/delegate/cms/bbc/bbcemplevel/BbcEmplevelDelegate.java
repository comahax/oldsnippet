/**
* auto-generated code
* Wed Aug 04 11:46:50 CST 2010
*/
package com.sunrise.boss.delegate.cms.bbc.bbcemplevel;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.bbcemplevel.persistent.BbcEmplevelVO;
import com.sunrise.boss.business.cms.bbc.bbcemplevel.persistent.BbcEmplevelListVO;
import com.sunrise.boss.business.cms.bbc.bbcemplevel.control.BbcEmplevelControlBean;
import com.sunrise.boss.business.cms.bbc.bbcemplevel.control.BbcEmplevelControl;

import java.io.Serializable;

/**
 * <p>Title: BbcEmplevelDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class BbcEmplevelDelegate {

    private static BbcEmplevelControl control;

    public BbcEmplevelDelegate() throws Exception {
        control = (BbcEmplevelControl) ControlFactory.build(BbcEmplevelControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public BbcEmplevelVO doCreate(BbcEmplevelVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(BbcEmplevelVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public BbcEmplevelVO doUpdate(BbcEmplevelVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public BbcEmplevelVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (BbcEmplevelVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(BbcEmplevelListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
