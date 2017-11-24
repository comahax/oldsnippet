/**
* auto-generated code
* Wed Feb 23 10:33:30 CST 2011
*/
package com.sunrise.boss.business.cms.dictparam.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.dictparam.persistent.DictparamVO;
import com.sunrise.boss.business.cms.dictparam.persistent.DictparamListVO;

import java.io.Serializable;

/**
 * <p>Title: DictparamControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jemy
 * @version 1.0
 */
public interface DictparamControl extends AbstractControl {
    public DictparamVO doCreate(DictparamVO vo, User user)
        throws Exception;

    public void doRemove(DictparamVO vo, User user)
        throws Exception;

    public DictparamVO doUpdate(DictparamVO vo, User user)
        throws Exception;

    public DictparamVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(DictparamListVO params, User user)
        throws Exception;

}
