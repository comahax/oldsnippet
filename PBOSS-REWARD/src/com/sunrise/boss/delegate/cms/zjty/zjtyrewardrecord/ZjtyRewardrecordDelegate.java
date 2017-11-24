/**
* auto-generated code
* Tue Feb 28 17:21:47 CST 2012
*/
package com.sunrise.boss.delegate.cms.zjty.zjtyrewardrecord;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtyrewardrecord.persistent.ZjtyRewardrecordVO;
import com.sunrise.boss.business.cms.zjty.zjtyrewardrecord.persistent.ZjtyRewardrecordListVO;
import com.sunrise.boss.business.cms.zjty.zjtyrewardrecord.control.ZjtyRewardrecordControlBean;
import com.sunrise.boss.business.cms.zjty.zjtyrewardrecord.control.ZjtyRewardrecordControl;

import java.io.Serializable;

/**
 * <p>Title: ZjtyRewardrecordDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author qiuzhi
 * @version 1.0
 */
public class ZjtyRewardrecordDelegate {

    private static ZjtyRewardrecordControl control;

    public ZjtyRewardrecordDelegate() throws Exception {
        control = (ZjtyRewardrecordControl) ControlFactory.build(ZjtyRewardrecordControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ZjtyRewardrecordVO doCreate(ZjtyRewardrecordVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ZjtyRewardrecordVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ZjtyRewardrecordVO doUpdate(ZjtyRewardrecordVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ZjtyRewardrecordVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ZjtyRewardrecordVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ZjtyRewardrecordListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
