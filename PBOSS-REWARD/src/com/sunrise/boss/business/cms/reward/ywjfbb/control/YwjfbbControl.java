/**
* auto-generated code
* Thu Nov 17 11:10:29 CST 2011
*/
package com.sunrise.boss.business.cms.reward.ywjfbb.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.ywjfbb.persistent.YwjfbbVO;
import com.sunrise.boss.business.cms.reward.ywjfbb.persistent.YwjfbbListVO;

import java.io.Serializable;

/**
 * <p>Title: YwjfbbControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public interface YwjfbbControl extends AbstractControl {
    public YwjfbbVO doCreate(YwjfbbVO vo, User user)
        throws Exception;

    public void doRemove(YwjfbbVO vo, User user)
        throws Exception;

    public YwjfbbVO doUpdate(YwjfbbVO vo, User user)
        throws Exception;

    public YwjfbbVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(YwjfbbListVO params, User user)
        throws Exception;

}
