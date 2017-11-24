/**
* auto-generated code
* Mon Mar 05 15:38:35 CST 2012
*/
package com.sunrise.boss.delegate.cms.zjty.zjtyimportrec;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtyimportrec.persistent.ZjtyImportrecVO;
import com.sunrise.boss.business.cms.zjty.zjtyimportrec.persistent.ZjtyImportrecListVO;
import com.sunrise.boss.business.cms.zjty.zjtyimportrec.control.ZjtyImportrecControlBean;
import com.sunrise.boss.business.cms.zjty.zjtyimportrec.control.ZjtyImportrecControl;

import java.io.Serializable;

/**
 * <p>Title: ZjtyImportrecDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author qiuzhi
 * @version 1.0
 */
public class ZjtyImportrecDelegate {

    private static ZjtyImportrecControl control;

    public ZjtyImportrecDelegate() throws Exception {
        control = (ZjtyImportrecControl) ControlFactory.build(ZjtyImportrecControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ZjtyImportrecVO doCreate(ZjtyImportrecVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ZjtyImportrecVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ZjtyImportrecVO doUpdate(ZjtyImportrecVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ZjtyImportrecVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ZjtyImportrecVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ZjtyImportrecListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
