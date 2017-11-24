/**
* auto-generated code
* Fri Dec 08 11:45:12 CST 2006
*/
package com.sunrise.boss.delegate.cms.fee.yxfeaprv;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.fee.yxfeaprv.persistent.YxfeaprvVO;
import com.sunrise.boss.business.cms.fee.yxfeaprv.persistent.YxfeaprvListVO;
import com.sunrise.boss.business.cms.fee.yxfeaprv.control.YxfeaprvControlBean;
import com.sunrise.boss.business.cms.fee.yxfeaprv.control.YxfeaprvControl;

import java.io.Serializable;

/**
 * <p>Title: YxfeaprvDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public class YxfeaprvDelegate {

    private static YxfeaprvControl control;

    public YxfeaprvDelegate() throws Exception {
        control = (YxfeaprvControl) ControlFactory.build(YxfeaprvControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public YxfeaprvVO doCreate(YxfeaprvVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(YxfeaprvVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public YxfeaprvVO doUpdate(YxfeaprvVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public YxfeaprvVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (YxfeaprvVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(YxfeaprvListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
