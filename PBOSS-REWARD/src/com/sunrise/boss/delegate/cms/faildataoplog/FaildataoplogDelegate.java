/**
* auto-generated code
* Fri Oct 09 16:20:49 CST 2009
*/
package com.sunrise.boss.delegate.cms.faildataoplog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.faildataoplog.persistent.FaildataoplogVO;
import com.sunrise.boss.business.cms.faildataoplog.persistent.FaildataoplogListVO;
import com.sunrise.boss.business.cms.faildataoplog.control.FaildataoplogControlBean;
import com.sunrise.boss.business.cms.faildataoplog.control.FaildataoplogControl;

import java.io.Serializable;

/**
 * <p>Title: FaildataoplogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class FaildataoplogDelegate {

    private static FaildataoplogControl control;

    public FaildataoplogDelegate() throws Exception {
        control = (FaildataoplogControl) ControlFactory.build(FaildataoplogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public FaildataoplogVO doCreate(FaildataoplogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(FaildataoplogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public FaildataoplogVO doUpdate(FaildataoplogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public FaildataoplogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (FaildataoplogVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(FaildataoplogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
