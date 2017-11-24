/**
* auto-generated code
* Thu Jul 03 15:10:27 CST 2014
*/
package com.sunrise.boss.delegate.cms.chpwfiletransfer;

import java.io.Serializable;

import com.sunrise.boss.business.cms.chpwfiletransfer.control.ChPwFiletransferControl;
import com.sunrise.boss.business.cms.chpwfiletransfer.control.ChPwFiletransferControlBean;
import com.sunrise.boss.business.cms.chpwfiletransfer.persistent.ChPwFiletransferListVO;
import com.sunrise.boss.business.cms.chpwfiletransfer.persistent.ChPwFiletransferVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: ChPwStatreportsDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChPwFiletransferDelegate {

    private static ChPwFiletransferControl control;

    public ChPwFiletransferDelegate() throws Exception {
        control = (ChPwFiletransferControl) ControlFactory.build(ChPwFiletransferControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChPwFiletransferVO doCreate(ChPwFiletransferVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChPwFiletransferVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChPwFiletransferVO doUpdate(ChPwFiletransferVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChPwFiletransferVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChPwFiletransferVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChPwFiletransferListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
