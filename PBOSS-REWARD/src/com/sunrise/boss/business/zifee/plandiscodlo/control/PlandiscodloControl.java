/**
* auto-generated code
* Fri Oct 20 14:08:21 CST 2006
*/
package com.sunrise.boss.business.zifee.plandiscodlo.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.plandiscodlo.persistent.PlandiscodloVO;
import com.sunrise.boss.business.zifee.plandiscodlo.persistent.PlandiscodloListVO;

import java.io.Serializable;

/**
 * <p>Title: PlandiscodloControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author eboxdisc
 * @version 1.0
 */
public interface PlandiscodloControl extends AbstractControl {
    public PlandiscodloVO doCreate(PlandiscodloVO vo, User user)
        throws Exception;

    public void doRemove(PlandiscodloVO vo, User user)
        throws Exception;

    public PlandiscodloVO doUpdate(PlandiscodloVO vo, User user)
        throws Exception;

    public PlandiscodloVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(PlandiscodloListVO params, User user)
        throws Exception;

}
