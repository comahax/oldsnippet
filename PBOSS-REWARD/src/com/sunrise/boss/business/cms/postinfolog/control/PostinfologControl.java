/**
* auto-generated code
* Wed Oct 18 16:15:34 CST 2006
*/
package com.sunrise.boss.business.cms.postinfolog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.postinfolog.persistent.PostinfologVO;
import com.sunrise.boss.business.cms.postinfolog.persistent.PostinfologListVO;

import java.io.Serializable;

/**
 * <p>Title: PostinfologControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public interface PostinfologControl extends AbstractControl {
    public PostinfologVO doCreate(PostinfologVO vo, User user)
        throws Exception;

    public void doRemove(PostinfologVO vo, User user)
        throws Exception;

    public PostinfologVO doUpdate(PostinfologVO vo, User user)
        throws Exception;

    public PostinfologVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(PostinfologListVO params, User user)
        throws Exception;

}
