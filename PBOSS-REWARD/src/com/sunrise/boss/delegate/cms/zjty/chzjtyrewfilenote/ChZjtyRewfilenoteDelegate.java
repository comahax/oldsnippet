/**
* auto-generated code
* Thu Jul 12 15:24:43 CST 2012
*/
package com.sunrise.boss.delegate.cms.zjty.chzjtyrewfilenote;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtyrewfilenote.persistent.ChZjtyRewfilenoteVO;
import com.sunrise.boss.business.cms.zjty.chzjtyrewfilenote.persistent.ChZjtyRewfilenoteListVO;
import com.sunrise.boss.business.cms.zjty.chzjtyrewfilenote.control.ChZjtyRewfilenoteControlBean;
import com.sunrise.boss.business.cms.zjty.chzjtyrewfilenote.control.ChZjtyRewfilenoteControl;

import java.io.Serializable;

/**
 * <p>Title: ChZjtyRewfilenoteDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxx
 * @version 1.0
 */
public class ChZjtyRewfilenoteDelegate {

    private static ChZjtyRewfilenoteControl control;

    public ChZjtyRewfilenoteDelegate() throws Exception {
        control = (ChZjtyRewfilenoteControl) ControlFactory.build(ChZjtyRewfilenoteControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChZjtyRewfilenoteVO doCreate(ChZjtyRewfilenoteVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChZjtyRewfilenoteVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChZjtyRewfilenoteVO doUpdate(ChZjtyRewfilenoteVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChZjtyRewfilenoteVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChZjtyRewfilenoteVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChZjtyRewfilenoteListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
