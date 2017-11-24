/**
* auto-generated code
* Sun Aug 27 12:00:09 CST 2006
*/
package com.sunrise.boss.business.cms.postinfo.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.postinfo.persistent.PostinfoVO;
import com.sunrise.boss.business.cms.postinfo.persistent.PostinfoListVO;

import java.io.Serializable;

/**
 * <p>Title: PostinfoControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
public interface PostinfoControl extends AbstractControl {
    public PostinfoVO doCreate(PostinfoVO vo, User user)
        throws Exception;

    public void doRemove(PostinfoVO vo, User user)
        throws Exception;

    public PostinfoVO doUpdate(PostinfoVO vo, User user)
        throws Exception;

    public PostinfoVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(PostinfoListVO params, User user)
        throws Exception;

}
