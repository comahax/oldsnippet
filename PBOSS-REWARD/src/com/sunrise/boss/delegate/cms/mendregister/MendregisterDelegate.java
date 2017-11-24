/**
* auto-generated code
* Mon Jun 20 09:11:28 GMT 2011
*/
package com.sunrise.boss.delegate.cms.mendregister;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.mendregister.persistent.MendregisterVO;
import com.sunrise.boss.business.cms.mendregister.persistent.MendregisterListVO;
import com.sunrise.boss.business.cms.mendregister.control.MendregisterControlBean;
import com.sunrise.boss.business.cms.mendregister.control.MendregisterControl;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title: MendregisterDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class MendregisterDelegate {

    private static MendregisterControl control;

    public MendregisterDelegate() throws Exception {
        control = (MendregisterControl) ControlFactory.build(MendregisterControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public MendregisterVO doCreate(MendregisterVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(MendregisterVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public MendregisterVO doUpdate(MendregisterVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public MendregisterVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (MendregisterVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(MendregisterListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    
    public boolean checkIfExistIn31Days(String mobile, Date selltime, User user)
		throws Exception {
    	return control.checkIfExistIn31Days(mobile, selltime, user);
    }
    
//    public MendregisterVO doCreateWithCheck(MendregisterVO vo, User user)
//		throws Exception {
//    	return control.doCreateWithCheck(vo, user);
//    }

}
