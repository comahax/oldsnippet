/**
* auto-generated code
* Tue Jul 09 12:03:37 CST 2013
*/
package com.sunrise.boss.delegate.cms.zjty.chzjtynogotonedetail;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtynogotonedetail.persistent.ChZjtyNogotonedetailVO;
import com.sunrise.boss.business.cms.zjty.chzjtynogotonedetail.persistent.ChZjtyNogotonedetailListVO;
import com.sunrise.boss.business.cms.zjty.chzjtynogotonedetail.control.ChZjtyNogotonedetailControlBean;
import com.sunrise.boss.business.cms.zjty.chzjtynogotonedetail.control.ChZjtyNogotonedetailControl;
import java.io.Serializable;

/**
 * <p>Title: ChZjtyNogotonedetailDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ChZjtyNogotonedetailDelegate {

    private static ChZjtyNogotonedetailControl control;

    public ChZjtyNogotonedetailDelegate() throws Exception {
        control = (ChZjtyNogotonedetailControl) ControlFactory.build(ChZjtyNogotonedetailControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChZjtyNogotonedetailVO doCreate(ChZjtyNogotonedetailVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChZjtyNogotonedetailVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChZjtyNogotonedetailVO doUpdate(ChZjtyNogotonedetailVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChZjtyNogotonedetailVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChZjtyNogotonedetailVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChZjtyNogotonedetailListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

    public DataPackage doQueryByView(ChZjtyNogotonedetailListVO params, User user)
        throws Exception {
    	return control.doQueryByView(params, user);
    }

    public void doDelete(ChZjtyNogotonedetailListVO vo, User user)
        throws Exception {
        control.doDelete(vo, user);
    }

    public long doFindMaxMark(User user) throws Exception {
    	return control.doFindMaxMark(user);
    }
}
