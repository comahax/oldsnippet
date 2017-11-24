/**
* auto-generated code
* Mon Jun 29 11:25:27 CST 2009
*/
package com.sunrise.boss.business.cms.nasrwdtotal.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.nasrwdtotal.persistent.NasrwdtotalVO;
import com.sunrise.boss.business.cms.nasrwdtotal.persistent.NasrwdtotalListVO;

import java.io.Serializable;

/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/nasrwdtotal/control/NasrwdtotalControlBean"
 *           name="NasrwdtotalControl" 
 *           view-type="local" 
 *           type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public interface NasrwdtotalControl extends AbstractControl {
    public NasrwdtotalVO doCreate(NasrwdtotalVO vo, User user)
        throws Exception;

    public void doRemove(NasrwdtotalVO vo, User user)
        throws Exception;

    public NasrwdtotalVO doUpdate(NasrwdtotalVO vo, User user)
        throws Exception;

    public NasrwdtotalVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(NasrwdtotalListVO params, User user)
        throws Exception;

}
