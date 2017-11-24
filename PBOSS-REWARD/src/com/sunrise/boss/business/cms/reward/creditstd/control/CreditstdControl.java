/**
* auto-generated code
* Wed May 18 15:47:28 CST 2011
*/
package com.sunrise.boss.business.cms.reward.creditstd.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.creditstd.persistent.CreditstdVO;
import com.sunrise.boss.business.cms.reward.creditstd.persistent.CreditstdListVO;

import java.io.Serializable;
import java.util.Map;

/**
 * <p>Title: CreditstdControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public interface CreditstdControl extends AbstractControl {
    public CreditstdVO doCreate(CreditstdVO vo, User user)
        throws Exception;

    public void doRemove(CreditstdVO vo, User user)
        throws Exception;

    public CreditstdVO doUpdate(CreditstdVO vo, User user)
        throws Exception;

    public CreditstdVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(CreditstdListVO params, User user)
        throws Exception;

    public DataPackage doQuery2(CreditstdListVO params, User user)
    throws Exception;
    
    public DataPackage doQuerystore(CreditstdListVO params, User user)
    throws Exception;
    
    public DataPackage doQuerystar(CreditstdListVO params, User user)
    throws Exception;
    
    public DataPackage doSave(Map  map, User user)
    throws Exception ;
    
    public DataPackage doQueryPro(CreditstdListVO params, User user)
    throws Exception;
    
    public Double doQuerysums(CreditstdListVO params, User user)
    throws Exception;
    public Double doQuerysums4singlton(CreditstdListVO params, User user)
    throws Exception;
    
    public boolean doCheckALevel(CreditstdListVO params, User user)
    throws Exception;
    
    public DataPackage doQuery4cqjl(CreditstdListVO params, User user)
    throws Exception;
    
}
