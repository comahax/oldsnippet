/**
* auto-generated code
* Thu Jul 12 15:25:29 CST 2012
*/
package com.sunrise.boss.delegate.cms.zjty.chzjtyrewfilenotelog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtyrewfilenotelog.persistent.ChZjtyRewfilenotelogVO;
import com.sunrise.boss.business.cms.zjty.chzjtyrewfilenotelog.persistent.ChZjtyRewfilenotelogListVO;
import com.sunrise.boss.business.cms.zjty.chzjtyrewfilenotelog.control.ChZjtyRewfilenotelogControlBean;
import com.sunrise.boss.business.cms.zjty.chzjtyrewfilenotelog.control.ChZjtyRewfilenotelogControl;

import java.io.Serializable;

/**
 * <p>Title: ChZjtyRewfilenotelogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxx
 * @version 1.0
 */
public class ChZjtyRewfilenotelogDelegate {

    private static ChZjtyRewfilenotelogControl control;

    public ChZjtyRewfilenotelogDelegate() throws Exception {
        control = (ChZjtyRewfilenotelogControl) ControlFactory.build(ChZjtyRewfilenotelogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChZjtyRewfilenotelogVO doCreate(ChZjtyRewfilenotelogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChZjtyRewfilenotelogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChZjtyRewfilenotelogVO doUpdate(ChZjtyRewfilenotelogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChZjtyRewfilenotelogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChZjtyRewfilenotelogVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChZjtyRewfilenotelogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
