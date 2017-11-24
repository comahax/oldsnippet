/**
* auto-generated code
* Wed Sep 02 10:03:26 CST 2009
*/
package com.sunrise.boss.delegate.cms.bbc.unvrc;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.unvrc.persistent.UnvrcVO;
import com.sunrise.boss.business.cms.bbc.unvrc.persistent.UnvrcListVO;
import com.sunrise.boss.business.cms.bbc.unvrc.control.UnvrcControlBean;
import com.sunrise.boss.business.cms.bbc.unvrc.control.UnvrcControl;

import java.io.Serializable;

/**
 * <p>Title: UnvrcDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class UnvrcDelegate {

    private static UnvrcControl control;

    public UnvrcDelegate() throws Exception {
        control = (UnvrcControl) ControlFactory.build(UnvrcControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public UnvrcVO doCreate(UnvrcVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(UnvrcVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public UnvrcVO doUpdate(UnvrcVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public UnvrcVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (UnvrcVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(UnvrcListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
