/**
* auto-generated code
* Fri Feb 13 16:55:58 CST 2009
*/
package com.sunrise.boss.delegate.cms.zjty.chzjtyopendate;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtyopendate.persistent.ChZjtyOpendateVO;
import com.sunrise.boss.business.cms.zjty.chzjtyopendate.persistent.ChZjtyOpendateListVO;
import com.sunrise.boss.business.cms.zjty.chzjtyopendate.control.ChZjtyOpendateControlBean;
import com.sunrise.boss.business.cms.zjty.chzjtyopendate.control.ChZjtyOpendateControl;

import java.io.Serializable;

/**
 * <p>Title: ChZjtyOpendateDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wanghua
 * @version 1.0
 */
public class ChZjtyOpendateDelegate {

    private static ChZjtyOpendateControl control;

    public ChZjtyOpendateDelegate() throws Exception {
        control = (ChZjtyOpendateControl) ControlFactory.build(ChZjtyOpendateControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public ChZjtyOpendateVO doCreate(ChZjtyOpendateVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(ChZjtyOpendateVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public ChZjtyOpendateVO doUpdate(ChZjtyOpendateVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public ChZjtyOpendateVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChZjtyOpendateVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(ChZjtyOpendateListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
