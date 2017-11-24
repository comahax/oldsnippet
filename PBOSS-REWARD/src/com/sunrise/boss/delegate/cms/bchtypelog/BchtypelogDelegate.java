/**
* auto-generated code
* Tue Oct 17 17:36:16 CST 2006
*/
package com.sunrise.boss.delegate.cms.bchtypelog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bchtypelog.control.BchtypelogControl;
import com.sunrise.boss.business.cms.bchtypelog.control.BchtypelogControlBean;
import com.sunrise.boss.business.cms.bchtypelog.persistent.BchtypelogVO;
import com.sunrise.boss.business.cms.bchtypelog.persistent.BchtypelogListVO;

import java.io.Serializable;

/**
 * <p>Title: BchtypelogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class BchtypelogDelegate {

    private static BchtypelogControl control;

    public BchtypelogDelegate() throws Exception {
        control = (BchtypelogControl) ControlFactory.build(BchtypelogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public BchtypelogVO doCreate(BchtypelogVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(BchtypelogVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public BchtypelogVO doUpdate(BchtypelogVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public BchtypelogVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (BchtypelogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(BchtypelogListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
