/**
* auto-generated code
* Wed Oct 18 16:15:34 CST 2006
*/
package com.sunrise.boss.delegate.cms.postinfolog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.postinfolog.control.PostinfologControl;
import com.sunrise.boss.business.cms.postinfolog.control.PostinfologControlBean;
import com.sunrise.boss.business.cms.postinfolog.persistent.PostinfologVO;
import com.sunrise.boss.business.cms.postinfolog.persistent.PostinfologListVO;

import java.io.Serializable;

/**
 * <p>Title: PostinfologDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class PostinfologDelegate {

    private static PostinfologControl control;

    public PostinfologDelegate() throws Exception {
        control = (PostinfologControl) ControlFactory.build(PostinfologControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public PostinfologVO doCreate(PostinfologVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(PostinfologVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public PostinfologVO doUpdate(PostinfologVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public PostinfologVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (PostinfologVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(PostinfologListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
