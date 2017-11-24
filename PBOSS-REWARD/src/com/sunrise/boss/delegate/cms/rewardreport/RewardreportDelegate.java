/**
* auto-generated code
* Thu May 19 16:35:38 CST 2011
*/
package com.sunrise.boss.delegate.cms.rewardreport;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.rewardreport.persistent.RewardreportVO;
import com.sunrise.boss.business.cms.rewardreport.persistent.RewardreportListVO;
import com.sunrise.boss.business.cms.rewardreport.control.RewardreportControlBean;
import com.sunrise.boss.business.cms.rewardreport.control.RewardreportControl;

import java.io.Serializable;

/**
 * <p>Title: RewardreportDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class RewardreportDelegate {

    private static RewardreportControl control;

    public RewardreportDelegate() throws Exception {
        control = (RewardreportControl) ControlFactory.build(RewardreportControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public RewardreportVO doCreate(RewardreportVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(RewardreportVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public RewardreportVO doUpdate(RewardreportVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public RewardreportVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (RewardreportVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(RewardreportListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

    public DataPackage doQuery2(RewardreportListVO params, User user)
	    throws Exception {
	    return control.doQuery2(params, user);
	}
}
