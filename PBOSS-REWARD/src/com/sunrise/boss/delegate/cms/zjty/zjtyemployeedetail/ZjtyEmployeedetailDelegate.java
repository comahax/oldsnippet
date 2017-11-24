/**
* auto-generated code
* Fri Feb 13 09:03:29 CST 2009
*/
package com.sunrise.boss.delegate.cms.zjty.zjtyemployeedetail;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtyemployeedetail.persistent.ZjtyEmployeedetailVO;
import com.sunrise.boss.business.cms.zjty.zjtyemployeedetail.persistent.ZjtyEmployeedetailListVO;
import com.sunrise.boss.business.cms.zjty.zjtyemployeedetail.control.ZjtyEmployeedetailControlBean;
import com.sunrise.boss.business.cms.zjty.zjtyemployeedetail.control.ZjtyEmployeedetailControl;

import java.io.Serializable;

/**
 * <p>Title: ZjtyEmployeedetailDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class ZjtyEmployeedetailDelegate {

    private static ZjtyEmployeedetailControl control;

    public ZjtyEmployeedetailDelegate() throws Exception {
        control = (ZjtyEmployeedetailControl) ControlFactory.build(ZjtyEmployeedetailControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public ZjtyEmployeedetailVO doCreate(ZjtyEmployeedetailVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(ZjtyEmployeedetailVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public ZjtyEmployeedetailVO doUpdate(ZjtyEmployeedetailVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public ZjtyEmployeedetailVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ZjtyEmployeedetailVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(ZjtyEmployeedetailListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
