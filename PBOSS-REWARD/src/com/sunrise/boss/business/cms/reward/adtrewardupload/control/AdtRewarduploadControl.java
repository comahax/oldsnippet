/**
* auto-generated code
* Thu Mar 15 15:06:14 CST 2012
*/
package com.sunrise.boss.business.cms.reward.adtrewardupload.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.adtrewardupload.persistent.AdtRewarduploadVO;
import com.sunrise.boss.business.cms.reward.adtrewardupload.persistent.AdtRewarduploadListVO;

import java.io.Serializable;

/**
 * <p>Title: AdtRewarduploadControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public interface AdtRewarduploadControl extends AbstractControl {
    public AdtRewarduploadVO doCreate(AdtRewarduploadVO vo, User user)
        throws Exception;

    public void doRemove(AdtRewarduploadVO vo, User user)
        throws Exception;

    public AdtRewarduploadVO doUpdate(AdtRewarduploadVO vo, User user)
        throws Exception;

    public AdtRewarduploadVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(AdtRewarduploadListVO params, User user)
        throws Exception;

}
