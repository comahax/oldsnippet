/**
* auto-generated code
* Thu Nov 17 11:10:29 CST 2011
*/
package com.sunrise.boss.delegate.cms.reward.ywjfbb;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.ywjfbb.persistent.YwjfbbVO;
import com.sunrise.boss.business.cms.reward.ywjfbb.persistent.YwjfbbListVO;
import com.sunrise.boss.business.cms.reward.ywjfbb.control.YwjfbbControlBean;
import com.sunrise.boss.business.cms.reward.ywjfbb.control.YwjfbbControl;

import java.io.Serializable;

/**
 * <p>Title: YwjfbbDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class YwjfbbDelegate {

    private static YwjfbbControl control;

    public YwjfbbDelegate() throws Exception {
        control = (YwjfbbControl) ControlFactory.build(YwjfbbControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public YwjfbbVO doCreate(YwjfbbVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(YwjfbbVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public YwjfbbVO doUpdate(YwjfbbVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public YwjfbbVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (YwjfbbVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(YwjfbbListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
