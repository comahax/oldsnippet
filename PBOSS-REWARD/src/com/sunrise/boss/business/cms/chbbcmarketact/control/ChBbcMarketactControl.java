/**
* auto-generated code
* Mon Aug 11 11:30:37 CST 2014
*/
package com.sunrise.boss.business.cms.chbbcmarketact.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chbbcmarketact.persistent.ChBbcMarketactVO;
import com.sunrise.boss.business.cms.chbbcmarketact.persistent.ChBbcMarketactListVO;

import java.io.Serializable;

/**
 * <p>Title: ChBbcMarketactControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public interface ChBbcMarketactControl extends AbstractControl {
    public ChBbcMarketactVO doCreate(ChBbcMarketactVO vo, User user)
        throws Exception;

    public void doRemove(ChBbcMarketactVO vo, User user)
        throws Exception;

    public ChBbcMarketactVO doUpdate(ChBbcMarketactVO vo, User user)
        throws Exception;

    public ChBbcMarketactVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChBbcMarketactListVO params, User user)
        throws Exception;

}
