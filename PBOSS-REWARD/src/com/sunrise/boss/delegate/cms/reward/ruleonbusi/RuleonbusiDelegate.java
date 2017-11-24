/**
* auto-generated code
* Fri Apr 18 17:02:15 CST 2008
*/
package com.sunrise.boss.delegate.cms.reward.ruleonbusi;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.ruleonbusi.control.RuleonbusiControl;
import com.sunrise.boss.business.cms.reward.ruleonbusi.control.RuleonbusiControlBean;
import com.sunrise.boss.business.cms.reward.ruleonbusi.persistent.RuleonbusiVO;
import com.sunrise.boss.business.cms.reward.ruleonbusi.persistent.RuleonbusiListVO;

import java.io.Serializable;

/**
 * <p>Title: RuleonbusiDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p><p>Company: SUNRISE Tech Ltd.</p>
 * @author Zhang Fengchao
 * @version 1.0
 */
public class RuleonbusiDelegate {

    private static RuleonbusiControl control;

    public RuleonbusiDelegate() throws Exception {
        control = (RuleonbusiControl) ControlFactory.build(RuleonbusiControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public RuleonbusiVO doCreate(RuleonbusiVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(RuleonbusiVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public RuleonbusiVO doUpdate(RuleonbusiVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public RuleonbusiVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (RuleonbusiVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(RuleonbusiListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
    
    public DataPackage doQuery1(RuleonbusiListVO params, User user )
    throws Exception {
    return control.doQuery1(params, user);
}
}
