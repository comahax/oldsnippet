/**
* auto-generated code
* Wed Nov 11 16:19:50 CST 2009
*/
package com.sunrise.boss.delegate.cms.reward.batchno;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.batchno.persistent.BatchnoVO;
import com.sunrise.boss.business.cms.reward.batchno.persistent.BatchnoListVO;
import com.sunrise.boss.business.cms.reward.batchno.control.BatchnoControlBean;
import com.sunrise.boss.business.cms.reward.batchno.control.BatchnoControl;

import java.io.Serializable;

/**
 * <p>Title: BatchnoDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class BatchnoDelegate {

    private static BatchnoControl control;

    public BatchnoDelegate() throws Exception {
        control = (BatchnoControl) ControlFactory.build(BatchnoControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public BatchnoVO doCreate(BatchnoVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(BatchnoVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public BatchnoVO doUpdate(BatchnoVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public BatchnoVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (BatchnoVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(BatchnoListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    
    public DataPackage doQueryBySelectBatchno(BatchnoListVO param, User user) throws Exception{
    	return control.doQueryBySelectBatchno(param, user);
    }
}
