/**
* auto-generated code
* Sat Jun 25 17:13:50 CST 2011
*/
package com.sunrise.boss.delegate.cms.reward.assess;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.assess.persistent.AssessVO;
import com.sunrise.boss.business.cms.reward.assess.persistent.AssessListVO;
import com.sunrise.boss.business.cms.reward.assess.control.AssessControlBean;
import com.sunrise.boss.business.cms.reward.assess.control.AssessControl;

import java.io.Serializable;

/**
 * <p>Title: AssessDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class AssessDelegate {

    private static AssessControl control;

    public AssessDelegate() throws Exception {
        control = (AssessControl) ControlFactory.build(AssessControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public AssessVO doCreate(AssessVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(AssessVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public AssessVO doUpdate(AssessVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public AssessVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (AssessVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(AssessListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
