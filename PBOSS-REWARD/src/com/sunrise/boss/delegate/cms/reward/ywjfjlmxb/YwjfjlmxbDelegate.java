/**
* auto-generated code
* Tue Nov 22 15:32:38 CST 2011
*/
package com.sunrise.boss.delegate.cms.reward.ywjfjlmxb;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.ywjfjlmxb.persistent.YwjfjlmxbVO;
import com.sunrise.boss.business.cms.reward.ywjfjlmxb.persistent.YwjfjlmxbListVO;
import com.sunrise.boss.business.cms.reward.ywjfjlmxb.control.YwjfjlmxbControlBean;
import com.sunrise.boss.business.cms.reward.ywjfjlmxb.control.YwjfjlmxbControl;

import java.io.Serializable;

/**
 * <p>Title: YwjfjlmxbDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class YwjfjlmxbDelegate {

    private static YwjfjlmxbControl control;

    public YwjfjlmxbDelegate() throws Exception {
        control = (YwjfjlmxbControl) ControlFactory.build(YwjfjlmxbControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public YwjfjlmxbVO doCreate(YwjfjlmxbVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(YwjfjlmxbVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public YwjfjlmxbVO doUpdate(YwjfjlmxbVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public YwjfjlmxbVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (YwjfjlmxbVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(YwjfjlmxbListVO params, User user,String[] ids)
        throws Exception {
    	
        return control.doQuery(params, user,ids);
    }

}
