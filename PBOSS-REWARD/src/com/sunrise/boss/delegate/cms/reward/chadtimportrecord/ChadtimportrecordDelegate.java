/**
* auto-generated code
* Fri Jun 24 11:00:35 CST 2011
*/
package com.sunrise.boss.delegate.cms.reward.chadtimportrecord;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.chadtimportrecord.persistent.ChadtimportrecordListVO;
import com.sunrise.boss.business.cms.reward.chadtimportrecord.persistent.ChadtimportrecordVO;
import com.sunrise.boss.business.cms.reward.chadtimportrecord.control.ChadtimportrecordControlBean;
import com.sunrise.boss.business.cms.reward.chadtimportrecord.control.ChadtimportrecordControl;

import java.io.Serializable;

/**
 * <p>Title: ChAdtImportrecordDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class ChadtimportrecordDelegate {

    private static ChadtimportrecordControl control;

    public ChadtimportrecordDelegate() throws Exception {
        control = (ChadtimportrecordControl) ControlFactory.build(ChadtimportrecordControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChadtimportrecordVO doCreate(ChadtimportrecordVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChadtimportrecordVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChadtimportrecordVO doUpdate(ChadtimportrecordVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChadtimportrecordVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChadtimportrecordVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChadtimportrecordListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
