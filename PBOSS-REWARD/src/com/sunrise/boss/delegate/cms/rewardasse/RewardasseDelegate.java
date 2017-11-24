/**
* auto-generated code
* Thu Jan 31 15:08:13 CST 2008
*/
package com.sunrise.boss.delegate.cms.rewardasse;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.rewardasse.control.RewardasseControl;
import com.sunrise.boss.business.cms.rewardasse.control.RewardasseControlBean;
import com.sunrise.boss.business.cms.rewardasse.persistent.RewardasseVO;
import com.sunrise.boss.business.cms.rewardasse.persistent.RewardasseListVO;

import java.io.Serializable;

/**
 * <p>Title: RewardasseDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author xiangyin
 * @version 1.0
 */
public class RewardasseDelegate {

    private static RewardasseControl control;

    public RewardasseDelegate() throws Exception {
        control = (RewardasseControl) ControlFactory.build(RewardasseControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public RewardasseVO doCreate(RewardasseVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(RewardasseVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public RewardasseVO doUpdate(RewardasseVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public RewardasseVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (RewardasseVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(RewardasseListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
    
    public boolean doQueryRewardtype(Integer rewardtype, User user)
	throws Exception{
    	return control.doQueryRewardtype(rewardtype, user);
    }
    
    public DataPackage doQuery4Syn(RewardasseListVO params, User user )
    throws Exception {
    return control.doQuery4Syn(params, user);
}
}
