/**
* auto-generated code
* Wed Nov 18 09:26:48 CST 2009
*/
package com.sunrise.boss.delegate.cms.examine.examinestdlog;

import java.io.Serializable;

import com.sunrise.boss.business.cms.examine.examinestdlog.control.ExaminestdlogControl;
import com.sunrise.boss.business.cms.examine.examinestdlog.control.ExaminestdlogControlBean;
import com.sunrise.boss.business.cms.examine.examinestdlog.persistent.ExaminestdlogListVO;
import com.sunrise.boss.business.cms.examine.examinestdlog.persistent.ExaminestdlogVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: ExaminestdlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExaminestdlogDelegate {

    private static ExaminestdlogControl control;

    public ExaminestdlogDelegate() throws Exception {
        control = (ExaminestdlogControl) ControlFactory.build(ExaminestdlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ExaminestdlogVO doCreate(ExaminestdlogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ExaminestdlogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ExaminestdlogVO doUpdate(ExaminestdlogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ExaminestdlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ExaminestdlogVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ExaminestdlogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
