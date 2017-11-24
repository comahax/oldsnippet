/**
* auto-generated code
* Tue Jul 09 08:59:10 CST 2013
*/
package com.sunrise.boss.delegate.cms.zjty.chzjtygotonedetail;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtygotonedetail.persistent.ChZjtyGotonedetailVO;
import com.sunrise.boss.business.cms.zjty.chzjtygotonedetail.persistent.ChZjtyGotonedetailListVO;
import com.sunrise.boss.business.cms.zjty.chzjtygotonedetail.control.ChZjtyGotonedetailControlBean;
import com.sunrise.boss.business.cms.zjty.chzjtygotonedetail.control.ChZjtyGotonedetailControl;

import java.io.Serializable;

/**
 * <p>Title: ChZjtyGotonedetailDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ChZjtyGotonedetailDelegate {

    private static ChZjtyGotonedetailControl control;

    public ChZjtyGotonedetailDelegate() throws Exception {
        control = (ChZjtyGotonedetailControl) ControlFactory.build(ChZjtyGotonedetailControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChZjtyGotonedetailVO doCreate(ChZjtyGotonedetailVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChZjtyGotonedetailVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChZjtyGotonedetailVO doUpdate(ChZjtyGotonedetailVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChZjtyGotonedetailVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChZjtyGotonedetailVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChZjtyGotonedetailListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
   
    public DataPackage doQueryByView(ChZjtyGotonedetailListVO params, User user)
        throws Exception {
    	return control.doQueryByView(params, user);
    }
    
    public void doDelete(ChZjtyGotonedetailListVO params, User user)
        throws Exception {
    	control.doDelete(params, user);
    }

    public long doFindMaxMark(User user) throws Exception {
    	return control.doFindMaxMark(user);
    }
}
