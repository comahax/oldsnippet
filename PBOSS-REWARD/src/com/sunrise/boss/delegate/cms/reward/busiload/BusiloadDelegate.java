/**
* auto-generated code
* Fri Feb 15 15:21:19 CST 2008
*/
package com.sunrise.boss.delegate.cms.reward.busiload;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.busiload.control.BusiloadControl;
import com.sunrise.boss.business.cms.reward.busiload.control.BusiloadControlBean;
import com.sunrise.boss.business.cms.reward.busiload.persistent.BusiloadVO;
import com.sunrise.boss.business.cms.reward.busiload.persistent.BusiloadListVO;

import java.io.Serializable;

/**
 * <p>Title: BusiloadDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author zeng jianxin
 * @version 1.0
 */
public class BusiloadDelegate {

    private static BusiloadControl control;

    public BusiloadDelegate() throws Exception {
        control = (BusiloadControl) ControlFactory.build(BusiloadControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public BusiloadVO doCreate(BusiloadVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(BusiloadVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public BusiloadVO doUpdate(BusiloadVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public BusiloadVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (BusiloadVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(BusiloadListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
