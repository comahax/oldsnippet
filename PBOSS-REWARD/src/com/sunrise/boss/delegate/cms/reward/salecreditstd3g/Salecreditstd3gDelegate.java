/**
* auto-generated code
* Tue Dec 11 09:30:18 CST 2012
*/
package com.sunrise.boss.delegate.cms.reward.salecreditstd3g;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.salecreditstd3g.persistent.Salecreditstd3gVO;
import com.sunrise.boss.business.cms.reward.salecreditstd3g.persistent.Salecreditstd3gListVO;
import com.sunrise.boss.business.cms.reward.salecreditstd3g.control.Salecreditstd3gControlBean;
import com.sunrise.boss.business.cms.reward.salecreditstd3g.control.Salecreditstd3gControl;

import java.io.Serializable;

/**
 * <p>Title: Salecreditstd3gDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class Salecreditstd3gDelegate {

    private static Salecreditstd3gControl control;

    public Salecreditstd3gDelegate() throws Exception {
        control = (Salecreditstd3gControl) ControlFactory.build(Salecreditstd3gControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public Salecreditstd3gVO doCreate(Salecreditstd3gVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(Salecreditstd3gVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    
    public void doRemoveByPk(Serializable pk, User user)throws Exception{
    	control.doRemoveByPk(pk, user);
    }

    public Salecreditstd3gVO doUpdate(Salecreditstd3gVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public Salecreditstd3gVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (Salecreditstd3gVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(Salecreditstd3gListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
