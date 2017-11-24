/**
* auto-generated code
* Thu Aug 24 15:33:39 CST 2006
*/
package com.sunrise.boss.business.zifee.plandisccode.control;

import java.rmi.*;
import java.io.Serializable;

import com.sunrise.boss.business.zifee.plandisccode.persistent.PlandisccodeListVO;
import com.sunrise.boss.business.zifee.plandisccode.persistent.PlandisccodeVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: PlandisccodeControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author plandisccode
 * @version 1.0
 */
public interface PlandisccodeControl extends AbstractControl {
    public PlandisccodeVO doCreate(PlandisccodeVO vo, User user)
        throws Exception;

    public void doRemove(PlandisccodeVO vo, User user)
        throws Exception;

    public PlandisccodeVO doUpdate(PlandisccodeVO vo, User user)
        throws Exception;

    public PlandisccodeVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(PlandisccodeListVO params, User user)
        throws Exception;

}
