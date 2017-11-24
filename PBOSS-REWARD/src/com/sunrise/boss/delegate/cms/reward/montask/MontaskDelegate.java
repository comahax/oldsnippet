/**
* auto-generated code
* Thu Aug 20 16:16:59 CST 2009
*/
package com.sunrise.boss.delegate.cms.reward.montask;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.montask.persistent.MontaskVO;
import com.sunrise.boss.business.cms.reward.montask.persistent.MontaskListVO;
import com.sunrise.boss.business.cms.reward.montask.control.MontaskControlBean;
import com.sunrise.boss.business.cms.reward.montask.control.MontaskControl;

import java.io.Serializable;

/**
 * <p>Title: MontaskDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class MontaskDelegate {

    private static MontaskControl control;

    public MontaskDelegate() throws Exception {
        control = (MontaskControl) ControlFactory.build(MontaskControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public MontaskVO doCreate(MontaskVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(MontaskVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public MontaskVO doUpdate(MontaskVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public MontaskVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (MontaskVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(MontaskListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    
    public DataPackage doQuery2(MontaskListVO params, String value, String value0, User user)
    throws Exception {
    return control.doQuery2(params, value, value0, user);
}

}
