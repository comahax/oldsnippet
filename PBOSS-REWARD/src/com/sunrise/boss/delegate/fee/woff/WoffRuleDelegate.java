package com.sunrise.boss.delegate.fee.woff;


import java.io.Serializable;

import com.sunrise.boss.business.fee.woff.woffrule.control.WoffRuleControl;
import com.sunrise.boss.business.fee.woff.woffrule.control.WoffRuleControlBean;
import com.sunrise.boss.business.fee.woff.woffrule.persistent.WoffRuleListVO;
import com.sunrise.boss.business.fee.woff.woffrule.persistent.WoffRuleVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;



/**
 * <p>Title: IbRuWoffruleVoDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author liwenjing
 * @version 1.0
 */
public class WoffRuleDelegate {

    private  WoffRuleControl control;

    public WoffRuleDelegate() throws Exception {
        control = (WoffRuleControl) ControlFactory.build(WoffRuleControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public WoffRuleVO doCreate(WoffRuleVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(WoffRuleVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public WoffRuleVO doUpdate(WoffRuleVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public WoffRuleVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (WoffRuleVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(WoffRuleListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
