/**
* auto-generated code
* Tue May 05 11:03:52 CST 2009
*/
package com.sunrise.boss.delegate.cms.bbc.yxplan;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.yxplan.control.YxplanControl;
import com.sunrise.boss.business.cms.bbc.yxplan.control.YxplanControlBean;
import com.sunrise.boss.business.cms.bbc.yxplan.persistent.YxplanVO;
import com.sunrise.boss.business.cms.bbc.yxplan.persistent.YxplanListVO;

import java.io.Serializable;

/**
 * <p>Title: YxplanDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class YxplanDelegate {

    private static YxplanControl control;

    public YxplanDelegate() throws Exception {
        control = (YxplanControl) ControlFactory.build(YxplanControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public YxplanVO doCreate(YxplanVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(YxplanVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public YxplanVO doUpdate(YxplanVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public YxplanVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (YxplanVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(YxplanListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
