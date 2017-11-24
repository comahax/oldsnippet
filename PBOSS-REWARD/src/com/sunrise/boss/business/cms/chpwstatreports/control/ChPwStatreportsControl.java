/**
* auto-generated code
* Thu Jul 03 15:10:27 CST 2014
*/
package com.sunrise.boss.business.cms.chpwstatreports.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chpwstatreports.persistent.ChPwStatreportsVO;
import com.sunrise.boss.business.cms.chpwstatreports.persistent.ChPwStatreportsListVO;

import java.io.Serializable;

/**
 * <p>Title: ChPwStatreportsControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public interface ChPwStatreportsControl extends AbstractControl {
    public ChPwStatreportsVO doCreate(ChPwStatreportsVO vo, User user)
        throws Exception;

    public void doRemove(ChPwStatreportsVO vo, User user)
        throws Exception;

    public ChPwStatreportsVO doUpdate(ChPwStatreportsVO vo, User user)
        throws Exception;

    public ChPwStatreportsVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChPwStatreportsListVO params, User user)
        throws Exception;

}
