/**
* auto-generated code
* Fri Aug 17 16:14:58 CST 2012
*/
package com.sunrise.boss.delegate.cms.adjustment;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.adjustment.persistent.AdjustmentVO;
import com.sunrise.boss.business.cms.adjustment.persistent.AdjustmentListVO;
import com.sunrise.boss.business.cms.adjustment.persistent.VAdjustmentListVO;
import com.sunrise.boss.business.cms.adjustment.control.AdjustmentControlBean;
import com.sunrise.boss.business.cms.adjustment.control.AdjustmentControl;

import java.io.Serializable;

/**
 * <p>Title: AdjustmentDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class AdjustmentDelegate {

    private static AdjustmentControl control;

    public AdjustmentDelegate() throws Exception {
        control = (AdjustmentControl) ControlFactory.build(AdjustmentControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public AdjustmentVO doCreate(AdjustmentVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(AdjustmentVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public AdjustmentVO doUpdate(AdjustmentVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public AdjustmentVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (AdjustmentVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(AdjustmentListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    
    public DataPackage doQuery(VAdjustmentListVO params, User user)
			throws Exception {
		return control.doQuery(params, user);
	}
    
    public String doSaveUnchecked(VAdjustmentListVO params, User user) throws Exception{
    	return control.doSaveUnchecked(params, user);
    }
    
    public String doSaveAllUnchecked(VAdjustmentListVO params, User user) throws Exception{
    	return control.doSaveAllUnchecked(params, user);
    }
    
    public String doDeleteAllChecked(VAdjustmentListVO params, User user) throws Exception{
    	return control.doDeleteAllChecked(params, user);
    }
    
    public String doCreatereport(VAdjustmentListVO params, User user) throws Exception{
    	return control.doCreatereport(params, user);
    }

}
