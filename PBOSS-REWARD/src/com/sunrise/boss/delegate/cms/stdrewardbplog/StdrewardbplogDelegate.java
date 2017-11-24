/**
* auto-generated code
* Fri Feb 01 18:25:30 CST 2008
*/
package com.sunrise.boss.delegate.cms.stdrewardbplog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.stdrewardbplog.control.StdrewardbplogControl;
import com.sunrise.boss.business.cms.stdrewardbplog.control.StdrewardbplogControlBean;
import com.sunrise.boss.business.cms.stdrewardbplog.persistent.StdrewardbplogVO;
import com.sunrise.boss.business.cms.stdrewardbplog.persistent.StdrewardbplogListVO;

import java.io.Serializable;

/**
 * <p>Title: StdrewardbplogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class StdrewardbplogDelegate {

    private static StdrewardbplogControl control;

    public StdrewardbplogDelegate() throws Exception {
        control = (StdrewardbplogControl) ControlFactory.build(StdrewardbplogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public StdrewardbplogVO doCreate(StdrewardbplogVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(StdrewardbplogVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public StdrewardbplogVO doUpdate(StdrewardbplogVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public StdrewardbplogVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (StdrewardbplogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(StdrewardbplogListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
