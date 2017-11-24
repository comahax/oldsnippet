/**
* auto-generated code
* Thu Mar 15 09:32:40 CST 2012
*/
package com.sunrise.boss.delegate.cms.reward.xjjlywjfmx;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.xjjlywjfmx.persistent.XjjlywjfmxVO;
import com.sunrise.boss.business.cms.reward.xjjlywjfmx.persistent.XjjlywjfmxListVO;
import com.sunrise.boss.business.cms.reward.xjjlywjfmx.control.XjjlywjfmxControlBean;
import com.sunrise.boss.business.cms.reward.xjjlywjfmx.control.XjjlywjfmxControl;

import java.io.Serializable;

/**
 * <p>Title: XjjlywjfmxDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class XjjlywjfmxDelegate {

    private static XjjlywjfmxControl control;

    public XjjlywjfmxDelegate() throws Exception {
        control = (XjjlywjfmxControl) ControlFactory.build(XjjlywjfmxControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public XjjlywjfmxVO doCreate(XjjlywjfmxVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(XjjlywjfmxVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public XjjlywjfmxVO doUpdate(XjjlywjfmxVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public XjjlywjfmxVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (XjjlywjfmxVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(XjjlywjfmxListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
