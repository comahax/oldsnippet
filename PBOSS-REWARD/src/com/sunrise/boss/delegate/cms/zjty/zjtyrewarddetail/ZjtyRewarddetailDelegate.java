/**
* auto-generated code
* Wed Dec 24 15:55:56 CST 2008
*/
package com.sunrise.boss.delegate.cms.zjty.zjtyrewarddetail;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtyrewarddetail.persistent.ZjtyRewarddetailVO;
import com.sunrise.boss.business.cms.zjty.zjtyrewarddetail.persistent.ZjtyRewarddetailListVO;
import com.sunrise.boss.business.cms.zjty.zjtyrewarddetail.control.ZjtyRewarddetailControlBean;
import com.sunrise.boss.business.cms.zjty.zjtyrewarddetail.control.ZjtyRewarddetailControl;

import java.io.Serializable;

/**
 * <p>Title: ChZjtyRewarddetailDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class ZjtyRewarddetailDelegate {

    private static ZjtyRewarddetailControl control;

    public ZjtyRewarddetailDelegate() throws Exception {
        control = (ZjtyRewarddetailControl) ControlFactory.build(ZjtyRewarddetailControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public ZjtyRewarddetailVO doCreate(ZjtyRewarddetailVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(ZjtyRewarddetailVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public ZjtyRewarddetailVO doUpdate(ZjtyRewarddetailVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public ZjtyRewarddetailVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ZjtyRewarddetailVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(ZjtyRewarddetailListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    public DataPackage doQuerybyType(ZjtyRewarddetailListVO params, User user)
    throws Exception {
	    return control.doQuerybyType(params, user);
	}
}
