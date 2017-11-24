/**
* auto-generated code
* Thu Feb 16 10:30:46 CST 2012
*/
package com.sunrise.boss.delegate.cms.reward.salepointflag;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.salepointflag.persistent.SalepointflagVO;
import com.sunrise.boss.business.cms.reward.salepointflag.persistent.SalepointflagListVO;
import com.sunrise.boss.business.cms.reward.salepointflag.control.SalepointflagControlBean;
import com.sunrise.boss.business.cms.reward.salepointflag.control.SalepointflagControl;

import java.io.Serializable;

/**
 * <p>Title: SalepointflagDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class SalepointflagDelegate {

    private static SalepointflagControl control;

    public SalepointflagDelegate() throws Exception {
        control = (SalepointflagControl) ControlFactory.build(SalepointflagControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public SalepointflagVO doCreate(SalepointflagVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(SalepointflagVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public SalepointflagVO doUpdate(SalepointflagVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public SalepointflagVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (SalepointflagVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(SalepointflagListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
