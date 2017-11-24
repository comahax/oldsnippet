/**
* auto-generated code
* Wed Nov 11 16:19:50 CST 2009
*/
package com.sunrise.boss.business.cms.reward.batchno.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.batchno.persistent.BatchnoVO;
import com.sunrise.boss.business.cms.reward.batchno.persistent.BatchnoListVO;

import java.io.Serializable;

/**
 * <p>Title: BatchnoControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public interface BatchnoControl extends AbstractControl {
    public BatchnoVO doCreate(BatchnoVO vo, User user)
        throws Exception;

    public void doRemove(BatchnoVO vo, User user)
        throws Exception;

    public BatchnoVO doUpdate(BatchnoVO vo, User user)
        throws Exception;

    public BatchnoVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(BatchnoListVO params, User user)
        throws Exception;
    
    public DataPackage doQueryBySelectBatchno(BatchnoListVO param ,User user) throws Exception;
}
