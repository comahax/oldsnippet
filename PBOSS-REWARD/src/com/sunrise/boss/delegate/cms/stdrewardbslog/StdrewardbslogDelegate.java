/**
* auto-generated code
* Fri Feb 01 18:27:26 CST 2008
*/
package com.sunrise.boss.delegate.cms.stdrewardbslog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.stdrewardbslog.control.StdrewardbslogControl;
import com.sunrise.boss.business.cms.stdrewardbslog.control.StdrewardbslogControlBean;
import com.sunrise.boss.business.cms.stdrewardbslog.persistent.StdrewardbslogVO;
import com.sunrise.boss.business.cms.stdrewardbslog.persistent.StdrewardbslogListVO;

import java.io.Serializable;

/**
 * <p>Title: StdrewardbslogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class StdrewardbslogDelegate {

    private static StdrewardbslogControl control;

    public StdrewardbslogDelegate() throws Exception {
        control = (StdrewardbslogControl) ControlFactory.build(StdrewardbslogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public StdrewardbslogVO doCreate(StdrewardbslogVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(StdrewardbslogVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public StdrewardbslogVO doUpdate(StdrewardbslogVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public StdrewardbslogVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (StdrewardbslogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(StdrewardbslogListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
