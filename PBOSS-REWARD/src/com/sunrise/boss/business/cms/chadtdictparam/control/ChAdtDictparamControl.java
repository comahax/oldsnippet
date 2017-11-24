/**
* auto-generated code
* Tue Feb 22 09:29:17 CST 2011
*/
package com.sunrise.boss.business.cms.chadtdictparam.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chadtdictparam.persistent.ChAdtDictparamVO;
import com.sunrise.boss.business.cms.chadtdictparam.persistent.ChAdtDictparamListVO;

import java.io.Serializable;

/**
 * <p>Title: ChAdtDictparamControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public interface ChAdtDictparamControl extends AbstractControl {
    public ChAdtDictparamVO doCreate(ChAdtDictparamVO vo, User user)
        throws Exception;

    public void doRemove(ChAdtDictparamVO vo, User user)
        throws Exception;

    public ChAdtDictparamVO doUpdate(ChAdtDictparamVO vo, User user)
        throws Exception;

    public ChAdtDictparamVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChAdtDictparamListVO params, User user)
        throws Exception;

}
