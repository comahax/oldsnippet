/**
* auto-generated code
* Thu Mar 15 15:06:14 CST 2012
*/
package com.sunrise.boss.delegate.cms.reward.adtrewardupload;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.adtrewardupload.persistent.AdtRewarduploadVO;
import com.sunrise.boss.business.cms.reward.adtrewardupload.persistent.AdtRewarduploadListVO;
import com.sunrise.boss.business.cms.reward.adtrewardupload.control.AdtRewarduploadControlBean;
import com.sunrise.boss.business.cms.reward.adtrewardupload.control.AdtRewarduploadControl;

import java.io.Serializable;

/**
 * <p>Title: AdtRewarduploadDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class AdtRewarduploadDelegate {

    private static AdtRewarduploadControl control;

    public AdtRewarduploadDelegate() throws Exception {
        control = (AdtRewarduploadControl) ControlFactory.build(AdtRewarduploadControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public AdtRewarduploadVO doCreate(AdtRewarduploadVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(AdtRewarduploadVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public AdtRewarduploadVO doUpdate(AdtRewarduploadVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public AdtRewarduploadVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (AdtRewarduploadVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(AdtRewarduploadListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
