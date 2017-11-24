/**
* auto-generated code
* Tue Apr 17 11:01:07 CST 2007
*/
package com.sunrise.boss.delegate.cms.microarealog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.microarealog.control.MicroarealogControl;
import com.sunrise.boss.business.cms.microarealog.control.MicroarealogControlBean;
import com.sunrise.boss.business.cms.microarealog.persistent.MicroarealogVO;
import com.sunrise.boss.business.cms.microarealog.persistent.MicroarealogListVO;

import java.io.Serializable;

/**
 * <p>Title: MicroarealogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Ye Daoe
 * @version 1.0
 */
public class MicroarealogDelegate {

    private static MicroarealogControl control;

    public MicroarealogDelegate() throws Exception {
        control = (MicroarealogControl) ControlFactory.build(MicroarealogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public MicroarealogVO doCreate(MicroarealogVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(MicroarealogVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public MicroarealogVO doUpdate(MicroarealogVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public MicroarealogVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (MicroarealogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(MicroarealogListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
