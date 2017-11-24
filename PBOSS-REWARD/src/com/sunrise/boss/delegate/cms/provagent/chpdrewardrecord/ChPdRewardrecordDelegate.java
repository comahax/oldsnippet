/**
* auto-generated code
* Wed Sep 04 21:04:55 CST 2013
*/
package com.sunrise.boss.delegate.cms.provagent.chpdrewardrecord;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.provagent.chpdrewardrecord.persistent.ChPdRewardrecordVO;
import com.sunrise.boss.business.cms.provagent.chpdrewardrecord.persistent.ChPdRewardrecordListVO;
import com.sunrise.boss.business.cms.provagent.chpdrewardrecord.control.ChPdRewardrecordControlBean;
import com.sunrise.boss.business.cms.provagent.chpdrewardrecord.control.ChPdRewardrecordControl;

import java.io.Serializable;

/**
 * <p>Title: ChPdRewardrecordDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChPdRewardrecordDelegate {

    private static ChPdRewardrecordControl control;

    public ChPdRewardrecordDelegate() throws Exception {
        control = (ChPdRewardrecordControl) ControlFactory.build(ChPdRewardrecordControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChPdRewardrecordVO doCreate(ChPdRewardrecordVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChPdRewardrecordVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChPdRewardrecordVO doUpdate(ChPdRewardrecordVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChPdRewardrecordVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChPdRewardrecordVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChPdRewardrecordListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
