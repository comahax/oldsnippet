/**
* auto-generated code
* Fri Aug 17 16:14:58 CST 2012
*/
package com.sunrise.boss.business.cms.adjustment.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.adjustment.persistent.AdjustmentVO;
import com.sunrise.boss.business.cms.adjustment.persistent.AdjustmentListVO;
import com.sunrise.boss.business.cms.adjustment.persistent.VAdjustmentListVO;

import java.io.Serializable;

/**
 * <p>Title: AdjustmentControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public interface AdjustmentControl extends AbstractControl {
    public AdjustmentVO doCreate(AdjustmentVO vo, User user)
        throws Exception;

    public void doRemove(AdjustmentVO vo, User user)
        throws Exception;

    public AdjustmentVO doUpdate(AdjustmentVO vo, User user)
        throws Exception;

    public AdjustmentVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(AdjustmentListVO params, User user)
        throws Exception;
    
    public DataPackage doQuery(VAdjustmentListVO params, User user)
    throws Exception;
    
    public String doSaveUnchecked(VAdjustmentListVO params, User user)
    throws Exception;
    
    public String doSaveAllUnchecked(VAdjustmentListVO params, User user)
    throws Exception;
    
    public String doDeleteAllChecked(VAdjustmentListVO params, User user)
    throws Exception;
    
    public String doCreatereport(VAdjustmentListVO params, User user) 
    throws Exception;
}
