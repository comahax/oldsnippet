/**
* auto-generated code
* Wed Aug 15 12:26:00 CST 2012
*/
package com.sunrise.boss.delegate.cms.dcord;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.dcord.persistent.DcordVO;
import com.sunrise.boss.business.cms.dcord.persistent.DcordListVO;
import com.sunrise.boss.business.cms.dcord.control.DcordControlBean;
import com.sunrise.boss.business.cms.dcord.control.DcordControl;
import com.sunrise.boss.business.cms.dcord.persistent.VDcordListVO;

import java.io.Serializable;

/**
 * <p>Title: DcordDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class DcordDelegate {

    private static DcordControl control;

    public DcordDelegate() throws Exception {
        control = (DcordControl) ControlFactory.build(DcordControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public DcordVO doCreate(DcordVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(DcordVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public DcordVO doUpdate(DcordVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public DcordVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (DcordVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(DcordListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    
    public DataPackage doQuery(VDcordListVO params, User user)
    	throws Exception {
    	return control.doQuery(params, user);
    }

}
