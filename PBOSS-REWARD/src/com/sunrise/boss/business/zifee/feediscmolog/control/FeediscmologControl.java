/**
* auto-generated code
* Thu Nov 15 12:26:36 CST 2007
*/
package com.sunrise.boss.business.zifee.feediscmolog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.feediscmolog.persistent.FeediscmologVO;
import com.sunrise.boss.business.zifee.feediscmolog.persistent.FeediscmologListVO;

import java.io.Serializable;

/**
 * <p>Title: FeediscmologControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author zeng jianxin
 * @version 1.0
 */
public interface FeediscmologControl extends AbstractControl {
    public FeediscmologVO doCreate(FeediscmologVO vo, User user)
        throws Exception;

    public void doRemove(FeediscmologVO vo, User user)
        throws Exception;

    public FeediscmologVO doUpdate(FeediscmologVO vo, User user)
        throws Exception;

    public FeediscmologVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(FeediscmologListVO params, User user)
        throws Exception;

}
