/**
* auto-generated code
* Tue Oct 31 14:19:29 CST 2006
*/
package com.sunrise.boss.business.rightmanage.rightitem.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.rightmanage.rightitem.persistent.RightitemVO;
import com.sunrise.boss.business.rightmanage.rightitem.persistent.RightitemListVO;

import java.io.Serializable;

/**
 * <p>Title: RightitemControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface RightitemControl extends AbstractControl {
    public RightitemVO doCreate(RightitemVO vo, User user)
        throws Exception;

    public void doRemove(RightitemVO vo, User user)
        throws Exception;

    public RightitemVO doUpdate(RightitemVO vo, User user)
        throws Exception;

    public RightitemVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RightitemListVO params, User user)
        throws Exception;
    public void doBatchin(RightitemVO vo, User user)
    throws Exception ;
}
