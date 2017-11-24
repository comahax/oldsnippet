/**
* auto-generated code
* Thu Apr 19 11:41:36 CST 2012
*/
package com.sunrise.boss.business.cms.rewardupload.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.rewardupload.persistent.RewarduploadVO;
import com.sunrise.boss.business.cms.rewardupload.persistent.RewarduploadListVO;

import java.io.Serializable;

/**
 * <p>Title: RewarduploadControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public interface RewarduploadControl extends AbstractControl {
    public RewarduploadVO doCreate(RewarduploadVO vo, User user)
        throws Exception;

    public void doRemove(RewarduploadVO vo, User user)
        throws Exception;

    public RewarduploadVO doUpdate(RewarduploadVO vo, User user)
        throws Exception;

    public RewarduploadVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RewarduploadListVO params, User user)
        throws Exception;
    
    public Long doGetSequence(User user) throws Exception;

}
