/**
* auto-generated code
* Thu Apr 19 11:41:36 CST 2012
*/
package com.sunrise.boss.delegate.cms.rewardupload;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.rewardupload.persistent.RewarduploadVO;
import com.sunrise.boss.business.cms.rewardupload.persistent.RewarduploadListVO;
import com.sunrise.boss.business.cms.rewardupload.control.RewarduploadControlBean;
import com.sunrise.boss.business.cms.rewardupload.control.RewarduploadControl;

import java.io.Serializable;

/**
 * <p>Title: RewarduploadDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class RewarduploadDelegate {

    private static RewarduploadControl control;

    public RewarduploadDelegate() throws Exception {
        control = (RewarduploadControl) ControlFactory.build(RewarduploadControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public RewarduploadVO doCreate(RewarduploadVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(RewarduploadVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public RewarduploadVO doUpdate(RewarduploadVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public RewarduploadVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (RewarduploadVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(RewarduploadListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
