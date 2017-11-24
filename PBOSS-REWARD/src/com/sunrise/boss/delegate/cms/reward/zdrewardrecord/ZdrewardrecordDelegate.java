/**
* auto-generated code
* Thu Jun 06 20:14:18 CST 2013
*/
package com.sunrise.boss.delegate.cms.reward.zdrewardrecord;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.zdrewardrecord.persistent.ZdrewardrecordVO;
import com.sunrise.boss.business.cms.reward.zdrewardrecord.persistent.ZdrewardrecordListVO;
import com.sunrise.boss.business.cms.reward.zdrewardrecord.control.ZdrewardrecordControlBean;
import com.sunrise.boss.business.cms.reward.zdrewardrecord.control.ZdrewardrecordControl;

import java.io.Serializable;

/**
 * <p>Title: ZdrewardrecordDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ZdrewardrecordDelegate {

    private static ZdrewardrecordControl control;

    public ZdrewardrecordDelegate() throws Exception {
        control = (ZdrewardrecordControl) ControlFactory.build(ZdrewardrecordControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ZdrewardrecordVO doCreate(ZdrewardrecordVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ZdrewardrecordVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ZdrewardrecordVO doUpdate(ZdrewardrecordVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ZdrewardrecordVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ZdrewardrecordVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ZdrewardrecordListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
