/**
* auto-generated code
* Mon Aug 11 11:30:37 CST 2014
*/
package com.sunrise.boss.delegate.cms.chbbcmarketact;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chbbcmarketact.persistent.ChBbcMarketactVO;
import com.sunrise.boss.business.cms.chbbcmarketact.persistent.ChBbcMarketactListVO;
import com.sunrise.boss.business.cms.chbbcmarketact.control.ChBbcMarketactControlBean;
import com.sunrise.boss.business.cms.chbbcmarketact.control.ChBbcMarketactControl;

import java.io.Serializable;

/**
 * <p>Title: ChBbcMarketactDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ChBbcMarketactDelegate {

    private static ChBbcMarketactControl control;

    public ChBbcMarketactDelegate() throws Exception {
        control = (ChBbcMarketactControl) ControlFactory.build(ChBbcMarketactControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChBbcMarketactVO doCreate(ChBbcMarketactVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChBbcMarketactVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChBbcMarketactVO doUpdate(ChBbcMarketactVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChBbcMarketactVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChBbcMarketactVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChBbcMarketactListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
