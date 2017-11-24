/**
* auto-generated code
* Wed Dec 14 10:29:07 CST 2011
*/
package com.sunrise.boss.delegate.cms.bbc.hpolregistersucc;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.hpolregistersucc.persistent.HpolregistersuccVO;
import com.sunrise.boss.business.cms.bbc.hpolregistersucc.persistent.HpolregistersuccListVO;
import com.sunrise.boss.business.cms.bbc.hpolregistersucc.control.HpolregistersuccControlBean;
import com.sunrise.boss.business.cms.bbc.hpolregistersucc.control.HpolregistersuccControl;

import java.io.Serializable;

/**
 * <p>Title: HpolregistersuccDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class HpolregistersuccDelegate {

    private static HpolregistersuccControl control;

    public HpolregistersuccDelegate() throws Exception {
        control = (HpolregistersuccControl) ControlFactory.build(HpolregistersuccControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public HpolregistersuccVO doCreate(HpolregistersuccVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(HpolregistersuccVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public HpolregistersuccVO doUpdate(HpolregistersuccVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public HpolregistersuccVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (HpolregistersuccVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(HpolregistersuccListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
