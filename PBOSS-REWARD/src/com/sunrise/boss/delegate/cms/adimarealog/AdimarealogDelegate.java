/**
* auto-generated code
* Mon Apr 16 17:13:59 CST 2007
*/
package com.sunrise.boss.delegate.cms.adimarealog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.adimarealog.control.AdimarealogControl;
import com.sunrise.boss.business.cms.adimarealog.control.AdimarealogControlBean;
import com.sunrise.boss.business.cms.adimarealog.persistent.AdimarealogVO;
import com.sunrise.boss.business.cms.adimarealog.persistent.AdimarealogListVO;

import java.io.Serializable;

/**
 * <p>Title: AdimarealogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Ye Daoe
 * @version 1.0
 */
public class AdimarealogDelegate {

    private static AdimarealogControl control;

    public AdimarealogDelegate() throws Exception {
        control = (AdimarealogControl) ControlFactory.build(AdimarealogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public AdimarealogVO doCreate(AdimarealogVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(AdimarealogVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public AdimarealogVO doUpdate(AdimarealogVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public AdimarealogVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (AdimarealogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(AdimarealogListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
