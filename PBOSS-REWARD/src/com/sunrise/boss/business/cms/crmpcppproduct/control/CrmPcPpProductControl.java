/**
* auto-generated code
* Thu Dec 12 20:04:12 CST 2013
*/
package com.sunrise.boss.business.cms.crmpcppproduct.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.crmpcppproduct.persistent.CrmPcPpProductVO;
import com.sunrise.boss.business.cms.crmpcppproduct.persistent.CrmPcPpProductListVO;

import java.io.Serializable;

/**
 * <p>Title: CrmPcPpProductControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public interface CrmPcPpProductControl extends AbstractControl {
    public CrmPcPpProductVO doCreate(CrmPcPpProductVO vo, User user)
        throws Exception;

    public void doRemove(CrmPcPpProductVO vo, User user)
        throws Exception;

    public CrmPcPpProductVO doUpdate(CrmPcPpProductVO vo, User user)
        throws Exception;

    public CrmPcPpProductVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(CrmPcPpProductListVO params, User user)
        throws Exception;

}
