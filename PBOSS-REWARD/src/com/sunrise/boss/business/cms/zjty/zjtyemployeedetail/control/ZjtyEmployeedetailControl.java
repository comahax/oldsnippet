/**
* auto-generated code
* Fri Feb 13 09:03:29 CST 2009
*/
package com.sunrise.boss.business.cms.zjty.zjtyemployeedetail.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtyemployeedetail.persistent.ZjtyEmployeedetailVO;
import com.sunrise.boss.business.cms.zjty.zjtyemployeedetail.persistent.ZjtyEmployeedetailListVO;

import java.io.Serializable;

/**
 * <p>Title: ZjtyEmployeedetailControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public interface ZjtyEmployeedetailControl extends AbstractControl {
    public ZjtyEmployeedetailVO doCreate(ZjtyEmployeedetailVO vo, User user)
        throws Exception;

    public void doRemove(ZjtyEmployeedetailVO vo, User user)
        throws Exception;

    public ZjtyEmployeedetailVO doUpdate(ZjtyEmployeedetailVO vo, User user)
        throws Exception;

    public ZjtyEmployeedetailVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ZjtyEmployeedetailListVO params, User user)
        throws Exception;

}
