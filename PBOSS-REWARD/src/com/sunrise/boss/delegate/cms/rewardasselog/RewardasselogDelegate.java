/**
* auto-generated code
* Thu Jan 31 17:14:30 CST 2008
*/
package com.sunrise.boss.delegate.cms.rewardasselog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.rewardasselog.control.RewardasselogControl;
import com.sunrise.boss.business.cms.rewardasselog.control.RewardasselogControlBean;
import com.sunrise.boss.business.cms.rewardasselog.persistent.RewardasselogVO;
import com.sunrise.boss.business.cms.rewardasselog.persistent.RewardasselogListVO;

import java.io.Serializable;

/**
 * <p>Title: RewardasselogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author xiangyin
 * @version 1.0
 */
public class RewardasselogDelegate {

    private static RewardasselogControl control;

    public RewardasselogDelegate() throws Exception {
        control = (RewardasselogControl) ControlFactory.build(RewardasselogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public RewardasselogVO doCreate(RewardasselogVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(RewardasselogVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public RewardasselogVO doUpdate(RewardasselogVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public RewardasselogVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (RewardasselogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(RewardasselogListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
