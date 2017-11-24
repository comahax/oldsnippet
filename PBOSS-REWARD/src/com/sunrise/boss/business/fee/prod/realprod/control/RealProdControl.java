/**
* auto-generated code
* Tue Jan 08 15:32:44 CST 2008
*/
package com.sunrise.boss.business.fee.prod.realprod.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.fee.prod.realprod.persistent.RealProdVO;
import com.sunrise.boss.business.fee.prod.realprod.persistent.RealProdListVO;

import java.io.Serializable;

/**
 * <p>Title: RealProdControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wkx
 * @version 1.0
 */
public interface RealProdControl extends AbstractControl {
    public RealProdVO doCreate(RealProdVO vo, User user)
        throws Exception;

    public void doRemove(RealProdVO vo, User user)
        throws Exception;

    public RealProdVO doUpdate(RealProdVO vo, User user)
        throws Exception;

    public RealProdVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RealProdListVO params, User user)
        throws Exception;

}
