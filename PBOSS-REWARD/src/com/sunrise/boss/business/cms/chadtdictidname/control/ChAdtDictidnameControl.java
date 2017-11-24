/**
* auto-generated code
* Mon Dec 19 14:58:11 CST 2011
*/
package com.sunrise.boss.business.cms.chadtdictidname.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chadtdictidname.persistent.ChAdtDictidnameVO;
import com.sunrise.boss.business.cms.chadtdictidname.persistent.ChAdtDictidnameListVO;

import java.io.Serializable;

/**
 * <p>Title: ChAdtDictidnameControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public interface ChAdtDictidnameControl extends AbstractControl {
    public ChAdtDictidnameVO doCreate(ChAdtDictidnameVO vo, User user)
        throws Exception;

    public void doRemove(ChAdtDictidnameVO vo, User user)
        throws Exception;

    public ChAdtDictidnameVO doUpdate(ChAdtDictidnameVO vo, User user)
        throws Exception;

    public ChAdtDictidnameVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChAdtDictidnameListVO params, User user)
        throws Exception;
    
    public DataPackage doQuerySelf(ChAdtDictidnameListVO params, User user)
    throws Exception;

}
