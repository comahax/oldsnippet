/**
* auto-generated code
* Fri Oct 20 10:57:25 CST 2006
*/
package com.sunrise.boss.business.zifee.feedisclog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.feedisclog.persistent.FeedisclogVO;
import com.sunrise.boss.business.zifee.feedisclog.persistent.FeedisclogListVO;

import java.io.Serializable;

/**
 * <p>Title: FeedisclogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author eboxdisc
 * @version 1.0
 */
public interface FeedisclogControl extends AbstractControl {
    public FeedisclogVO doCreate(FeedisclogVO vo, User user)
        throws Exception;

    public void doRemove(FeedisclogVO vo, User user)
        throws Exception;

    public FeedisclogVO doUpdate(FeedisclogVO vo, User user)
        throws Exception;

    public FeedisclogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(FeedisclogListVO params, User user)
        throws Exception;

}
