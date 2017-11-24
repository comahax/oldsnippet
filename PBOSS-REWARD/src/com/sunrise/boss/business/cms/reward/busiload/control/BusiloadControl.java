/**
* auto-generated code
* Fri Feb 15 15:21:19 CST 2008
*/
package com.sunrise.boss.business.cms.reward.busiload.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.busiload.persistent.BusiloadVO;
import com.sunrise.boss.business.cms.reward.busiload.persistent.BusiloadListVO;

import java.io.Serializable;

/**
 * <p>Title: BusiloadControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author zeng jianxin
 * @version 1.0
 */
public interface BusiloadControl extends AbstractControl {
    public BusiloadVO doCreate(BusiloadVO vo, User user)
        throws Exception;

    public void doRemove(BusiloadVO vo, User user)
        throws Exception;

    public BusiloadVO doUpdate(BusiloadVO vo, User user)
        throws Exception;

    public BusiloadVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(BusiloadListVO params, User user)
        throws Exception;

}
