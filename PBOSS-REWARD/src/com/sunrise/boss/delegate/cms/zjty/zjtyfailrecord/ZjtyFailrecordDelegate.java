/**
* auto-generated code
* Wed Feb 29 11:21:28 CST 2012
*/
package com.sunrise.boss.delegate.cms.zjty.zjtyfailrecord;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtyfailrecord.persistent.ZjtyFailrecordVO;
import com.sunrise.boss.business.cms.zjty.zjtyfailrecord.persistent.ZjtyFailrecordListVO;
import com.sunrise.boss.business.cms.zjty.zjtyfailrecord.control.ZjtyFailrecordControlBean;
import com.sunrise.boss.business.cms.zjty.zjtyfailrecord.control.ZjtyFailrecordControl;

import java.io.Serializable;

/**
 * <p>Title: ZjtyFailrecordDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author qiuzhi
 * @version 1.0
 */
public class ZjtyFailrecordDelegate {

    private static ZjtyFailrecordControl control;

    public ZjtyFailrecordDelegate() throws Exception {
        control = (ZjtyFailrecordControl) ControlFactory.build(ZjtyFailrecordControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ZjtyFailrecordVO doCreate(ZjtyFailrecordVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ZjtyFailrecordVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ZjtyFailrecordVO doUpdate(ZjtyFailrecordVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ZjtyFailrecordVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ZjtyFailrecordVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ZjtyFailrecordListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
