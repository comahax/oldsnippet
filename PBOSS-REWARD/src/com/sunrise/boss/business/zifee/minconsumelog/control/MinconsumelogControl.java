/**
* auto-generated code
* Fri Aug 08 15:19:24 CST 2008
*/
package com.sunrise.boss.business.zifee.minconsumelog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.minconsumelog.persistent.MinconsumelogVO;
import com.sunrise.boss.business.zifee.minconsumelog.persistent.MinconsumelogListVO;

import java.io.Serializable;

/**
 * <p>Title: MinconsumelogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface MinconsumelogControl extends AbstractControl {
    public MinconsumelogVO doCreate(MinconsumelogVO vo, User user)
        throws Exception;

    public void doRemove(MinconsumelogVO vo, User user)
        throws Exception;

    public MinconsumelogVO doUpdate(MinconsumelogVO vo, User user)
        throws Exception;

    public MinconsumelogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(MinconsumelogListVO params, User user)
        throws Exception;

}
