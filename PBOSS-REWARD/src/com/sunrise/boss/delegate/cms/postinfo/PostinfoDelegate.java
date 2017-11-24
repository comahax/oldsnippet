/**
* auto-generated code
* Sun Aug 27 12:00:09 CST 2006
*/
package com.sunrise.boss.delegate.cms.postinfo;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.postinfo.control.PostinfoControl;
import com.sunrise.boss.business.cms.postinfo.control.PostinfoControlBean;
import com.sunrise.boss.business.cms.postinfo.persistent.PostinfoVO;
import com.sunrise.boss.business.cms.postinfo.persistent.PostinfoListVO;

import java.io.Serializable;

/**
 * <p>Title: PostinfoDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
public class PostinfoDelegate {

    private static PostinfoControl control;

    public PostinfoDelegate() throws Exception {
        control = (PostinfoControl) ControlFactory.build(PostinfoControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public PostinfoVO doCreate(PostinfoVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(PostinfoVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public PostinfoVO doUpdate(PostinfoVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public PostinfoVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (PostinfoVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(PostinfoListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
