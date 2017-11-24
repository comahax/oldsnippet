/**
* auto-generated code
* Thu Jul 03 15:10:27 CST 2014
*/
package com.sunrise.boss.business.cms.chpwfiletransfer.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.chpwfiletransfer.persistent.ChPwFiletransferListVO;
import com.sunrise.boss.business.cms.chpwfiletransfer.persistent.ChPwFiletransferVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: ChPwFiletransferControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public interface ChPwFiletransferControl extends AbstractControl {
    public ChPwFiletransferVO doCreate(ChPwFiletransferVO vo, User user)
        throws Exception;

    public void doRemove(ChPwFiletransferVO vo, User user)
        throws Exception;

    public ChPwFiletransferVO doUpdate(ChPwFiletransferVO vo, User user)
        throws Exception;

    public ChPwFiletransferVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChPwFiletransferListVO params, User user)
        throws Exception;

}
