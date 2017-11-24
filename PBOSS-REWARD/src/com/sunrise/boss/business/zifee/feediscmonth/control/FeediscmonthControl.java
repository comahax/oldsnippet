/**
* auto-generated code
* Wed Nov 14 16:51:17 CST 2007
*/
package com.sunrise.boss.business.zifee.feediscmonth.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.feediscmonth.persistent.FeediscmonthVO;
import com.sunrise.boss.business.zifee.feediscmonth.persistent.FeediscmonthListVO;

import java.io.Serializable;

/**
 * <p>Title: FeediscmonthControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author zeng jianxin
 * @version 1.0
 */
public interface FeediscmonthControl extends AbstractControl {
    public FeediscmonthVO doCreate(FeediscmonthVO vo, User user)
        throws Exception;

    public void doRemove(FeediscmonthVO vo, User user)
        throws Exception;

    public FeediscmonthVO doUpdate(FeediscmonthVO vo, User user)
        throws Exception;

    public FeediscmonthVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(FeediscmonthListVO params, User user)
        throws Exception;

}
