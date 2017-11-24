/**
* auto-generated code
* Thu Dec 29 14:47:31 CST 2011
*/
package com.sunrise.boss.delegate.cms.zjty.zjtyassess;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtyassess.persistent.ZjtyAssessVO;
import com.sunrise.boss.business.cms.zjty.zjtyassess.persistent.ZjtyAssessListVO;
import com.sunrise.boss.business.cms.zjty.zjtyassess.control.ZjtyAssessControlBean;
import com.sunrise.boss.business.cms.zjty.zjtyassess.control.ZjtyAssessControl;

import java.io.Serializable;

/**
 * <p>Title: ZjtyAssessDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author qiuzhi
 * @version 1.0
 */
public class ZjtyAssessDelegate {

    private static ZjtyAssessControl control;

    public ZjtyAssessDelegate() throws Exception {
        control = (ZjtyAssessControl) ControlFactory.build(ZjtyAssessControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ZjtyAssessVO doCreate(ZjtyAssessVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ZjtyAssessVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ZjtyAssessVO doUpdate(ZjtyAssessVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ZjtyAssessVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ZjtyAssessVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ZjtyAssessListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
