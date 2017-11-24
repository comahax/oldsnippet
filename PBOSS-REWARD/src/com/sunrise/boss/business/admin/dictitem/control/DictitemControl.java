/**
* auto-generated code
* Thu Sep 21 16:09:09 CST 2006
*/
package com.sunrise.boss.business.admin.dictitem.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;

import java.io.Serializable;
import java.util.Collection;

/**
 * <p>Title: DictitemControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author eboxdisc
 * @version 1.0
 */
public interface DictitemControl extends AbstractControl {
    public DictitemVO doCreate(DictitemVO vo, User user)
        throws Exception;

    public void doRemove(DictitemVO vo, User user)
        throws Exception;

    public DictitemVO doUpdate(DictitemVO vo, User user)
        throws Exception;

    public DictitemVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(DictitemListVO params, User user)
        throws Exception;

    public Collection doFindAll(User user) throws Exception;
}
