/**
* auto-generated code
* Fri May 27 12:04:23 CST 2011
*/
package com.sunrise.boss.business.cms.reward.tax.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.tax.persistent.TaxVO;
import com.sunrise.boss.business.cms.reward.tax.persistent.TaxListVO;

import java.io.Serializable;

/**
 * <p>Title: TaxControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public interface TaxControl extends AbstractControl {
    public TaxVO doCreate(TaxVO vo, User user)
        throws Exception;

    public void doRemove(TaxVO vo, User user)
        throws Exception;

    public TaxVO doUpdate(TaxVO vo, User user)
        throws Exception;

    public TaxVO doFindByPk(Serializable pk, User user)
        throws Exception;
    
    public TaxVO doFindByPk2(Serializable pk, User user)
    	throws Exception;

    public DataPackage doQuery(TaxListVO params, User user)
        throws Exception;

}
