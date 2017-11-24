/**
* auto-generated code
* Tue Feb 05 10:11:13 CST 2008
*/
package com.sunrise.boss.delegate.cms.busicityload;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.busicityload.control.BusicityloadControl;
import com.sunrise.boss.business.cms.busicityload.control.BusicityloadControlBean;
import com.sunrise.boss.business.cms.busicityload.persistent.BusicityloadVO;
import com.sunrise.boss.business.cms.busicityload.persistent.BusicityloadListVO;

import java.io.Serializable;

/**
 * <p>Title: BusicityloadDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class BusicityloadDelegate {

    private static BusicityloadControl control;

    public BusicityloadDelegate() throws Exception {
        control = (BusicityloadControl) ControlFactory.build(BusicityloadControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public BusicityloadVO doCreate(BusicityloadVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(BusicityloadVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public BusicityloadVO doUpdate(BusicityloadVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public BusicityloadVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (BusicityloadVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(BusicityloadListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
