/**
* auto-generated code
* Wed Sep 04 21:22:46 CST 2013
*/
package com.sunrise.boss.delegate.cms.provagent.chpdrewardadc;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.provagent.chpdrewardadc.persistent.ChPdRewardadcVO;
import com.sunrise.boss.business.cms.provagent.chpdrewardadc.persistent.ChPdRewardadcListVO;
import com.sunrise.boss.business.cms.provagent.chpdrewardadc.control.ChPdRewardadcControlBean;
import com.sunrise.boss.business.cms.provagent.chpdrewardadc.control.ChPdRewardadcControl;

import java.io.Serializable;

/**
 * <p>Title: ChPdRewardadcDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChPdRewardadcDelegate {

    private static ChPdRewardadcControl control;

    public ChPdRewardadcDelegate() throws Exception {
        control = (ChPdRewardadcControl) ControlFactory.build(ChPdRewardadcControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChPdRewardadcVO doCreate(ChPdRewardadcVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChPdRewardadcVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChPdRewardadcVO doUpdate(ChPdRewardadcVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChPdRewardadcVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChPdRewardadcVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChPdRewardadcListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
