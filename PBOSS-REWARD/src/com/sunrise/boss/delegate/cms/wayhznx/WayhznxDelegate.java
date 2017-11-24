/**
* auto-generated code
* Thu Feb 12 09:35:58 CST 2009
*/
package com.sunrise.boss.delegate.cms.wayhznx;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.wayhznx.persistent.WayhznxVO;
import com.sunrise.boss.business.cms.wayhznx.persistent.WayhznxListVO;
import com.sunrise.boss.business.cms.wayhznx.control.WayhznxControlBean;
import com.sunrise.boss.business.cms.wayhznx.control.WayhznxControl;

import java.io.Serializable;

/**
 * <p>Title: WayhznxDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class WayhznxDelegate {

    private static WayhznxControl control;

    public WayhznxDelegate() throws Exception {
        control = (WayhznxControl) ControlFactory.build(WayhznxControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public WayhznxVO doCreate(WayhznxVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(WayhznxVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public WayhznxVO doUpdate(WayhznxVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public WayhznxVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (WayhznxVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(WayhznxListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    
    public DataPackage doQuery2(Object params[], Class[] vo, String joins[][], User user)
    	throws Exception {
    	return control.doQuery2(params, vo, joins, user);
    }
}
