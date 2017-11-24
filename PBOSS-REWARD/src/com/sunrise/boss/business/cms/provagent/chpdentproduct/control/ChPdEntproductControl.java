/**
* auto-generated code
* Tue Sep 03 17:48:46 CST 2013
*/
package com.sunrise.boss.business.cms.provagent.chpdentproduct.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.provagent.chpdentproduct.persistent.ChPdEntproductListVO;
import com.sunrise.boss.business.cms.provagent.chpdentproduct.persistent.ChPdEntproductVO;

import java.io.Serializable;

/**
 * <p>Title: ChPdEntproductControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public interface ChPdEntproductControl extends AbstractControl {
    public ChPdEntproductVO doCreate(ChPdEntproductVO vo, User user)
        throws Exception;

    public void doRemove(ChPdEntproductVO vo, User user)
        throws Exception;

    public ChPdEntproductVO doUpdate(ChPdEntproductVO vo, User user)
        throws Exception;

    public ChPdEntproductVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChPdEntproductListVO params, User user)
        throws Exception;

}
