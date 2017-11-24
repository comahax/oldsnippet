/**
* auto-generated code
* Tue Mar 10 18:21:48 CST 2009
*/
package com.sunrise.boss.business.zifee.prodservset.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.prodservset.persistent.ProdservsetVO;
import com.sunrise.boss.business.zifee.prodservset.persistent.ProdservsetListVO;

import java.io.Serializable;

/**
 * <p>Title: ProdservsetControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public interface ProdservsetControl extends AbstractControl {
    public ProdservsetVO doCreate(ProdservsetVO vo, User user)
        throws Exception;

    public void doRemove(ProdservsetVO vo, User user)
        throws Exception;

    public ProdservsetVO doUpdate(ProdservsetVO vo, User user)
        throws Exception;

    public ProdservsetVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ProdservsetListVO params, User user)
        throws Exception;

}
