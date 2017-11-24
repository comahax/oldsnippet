/**
* auto-generated code
* Thu Dec 22 09:33:15 CST 2011
*/
package com.sunrise.boss.delegate.cms.reward.stdrewardcq;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.stdrewardcq.persistent.StdrewardcqVO;
import com.sunrise.boss.business.cms.reward.stdrewardcq.persistent.StdrewardcqListVO;
import com.sunrise.boss.business.cms.reward.stdrewardcq.control.StdrewardcqControlBean;
import com.sunrise.boss.business.cms.reward.stdrewardcq.control.StdrewardcqControl;

import java.io.Serializable;

/**
 * <p>Title: StdrewardcqDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class StdrewardcqDelegate {

    private static StdrewardcqControl control;

    public StdrewardcqDelegate() throws Exception {
        control = (StdrewardcqControl) ControlFactory.build(StdrewardcqControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public StdrewardcqVO doCreate(StdrewardcqVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(StdrewardcqVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public StdrewardcqVO doUpdate(StdrewardcqVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public StdrewardcqVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (StdrewardcqVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(StdrewardcqListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

    public DataPackage doQuery2(StdrewardcqListVO params, User user)
    throws Exception {
    return control.doQuery2(params, user);
}
}
