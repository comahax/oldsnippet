/**
* auto-generated code
* Sat Dec 08 10:23:53 CST 2012
*/
package com.sunrise.boss.delegate.cms.reward.creditstd3g;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.creditstd3g.persistent.Creditstd3gVO;
import com.sunrise.boss.business.cms.reward.creditstd3g.persistent.Creditstd3gListVO;
import com.sunrise.boss.business.cms.reward.creditstd3g.control.Creditstd3gControlBean;
import com.sunrise.boss.business.cms.reward.creditstd3g.control.Creditstd3gControl;

import java.io.Serializable;

/**
 * <p>Title: Creditstd3gDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class Creditstd3gDelegate {

    private static Creditstd3gControl control;

    public Creditstd3gDelegate() throws Exception {
        control = (Creditstd3gControl) ControlFactory.build(Creditstd3gControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public Creditstd3gVO doCreate(Creditstd3gVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(Creditstd3gVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public Creditstd3gVO doUpdate(Creditstd3gVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public Creditstd3gVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (Creditstd3gVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(Creditstd3gListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    
    public DataPackage doQuerystdset(Creditstd3gListVO params, User user)
    throws Exception {
    return control.doQuerystdset(params, user);
}

}
