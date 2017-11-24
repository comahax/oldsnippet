/**
* auto-generated code
* Wed Nov 18 10:52:23 CST 2009
*/
package com.sunrise.boss.delegate.cms.examine.oprnwayidlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.oprnwayidlog.persistent.OprnwayidlogVO;
import com.sunrise.boss.business.cms.examine.oprnwayidlog.persistent.OprnwayidlogListVO;
import com.sunrise.boss.business.cms.examine.oprnwayidlog.control.OprnwayidlogControlBean;
import com.sunrise.boss.business.cms.examine.oprnwayidlog.control.OprnwayidlogControl;

import java.io.Serializable;

/**
 * <p>Title: OprnwayidlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class OprnwayidlogDelegate {

    private static OprnwayidlogControl control;

    public OprnwayidlogDelegate() throws Exception {
        control = (OprnwayidlogControl) ControlFactory.build(OprnwayidlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public OprnwayidlogVO doCreate(OprnwayidlogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(OprnwayidlogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public OprnwayidlogVO doUpdate(OprnwayidlogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public OprnwayidlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (OprnwayidlogVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(OprnwayidlogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
