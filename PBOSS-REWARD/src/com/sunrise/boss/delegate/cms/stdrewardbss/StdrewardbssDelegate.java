/**
* auto-generated code
* Sat Apr 23 11:54:03 CST 2011
*/
package com.sunrise.boss.delegate.cms.stdrewardbss;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.stdrewardbss.persistent.StdrewardbssVO;
import com.sunrise.boss.business.cms.stdrewardbss.persistent.StdrewardbssListVO;
import com.sunrise.boss.business.cms.stdrewardbss.control.StdrewardbssControlBean;
import com.sunrise.boss.business.cms.stdrewardbss.control.StdrewardbssControl;

import java.io.Serializable;

/**
 * <p>Title: StdrewardbssDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class StdrewardbssDelegate {

    private static StdrewardbssControl control;

    public StdrewardbssDelegate() throws Exception {
        control = (StdrewardbssControl) ControlFactory.build(StdrewardbssControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public StdrewardbssVO doCreate(StdrewardbssVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(StdrewardbssVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public StdrewardbssVO doUpdate(StdrewardbssVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public StdrewardbssVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (StdrewardbssVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(StdrewardbssListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
