/**
* auto-generated code
* Tue Sep 19 21:22:32 CST 2006
*/
package com.sunrise.boss.delegate.cms.recompense;

import com.sunrise.boss.business.cms.recompense.control.RecompenseControl;
import com.sunrise.boss.business.cms.recompense.control.RecompenseControlBean;
import com.sunrise.boss.business.cms.recompense.persistent.RecompenseListVO;
import com.sunrise.boss.business.cms.recompense.persistent.RecompenseVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import java.io.Serializable;

/**
 * <p>Title: RecompenseDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RecompenseDelegate {

    private static RecompenseControl control;

    public RecompenseDelegate() throws Exception {
        control = (RecompenseControl) ControlFactory.build(RecompenseControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public RecompenseVO doCreate(RecompenseVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(RecompenseVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public RecompenseVO doUpdate(RecompenseVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public RecompenseVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (RecompenseVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(RecompenseListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
