/**
* auto-generated code
* Wed Dec 24 15:55:56 CST 2008
*/
package com.sunrise.boss.business.cms.zjty.zjtyrewarddetail.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtyrewarddetail.persistent.ZjtyRewarddetailVO;
import com.sunrise.boss.business.cms.zjty.zjtyrewarddetail.persistent.ZjtyRewarddetailListVO;

import java.io.Serializable;

/**
 * <p>Title: ZjtyRewarddetailControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public interface ZjtyRewarddetailControl extends AbstractControl {
    public ZjtyRewarddetailVO doCreate(ZjtyRewarddetailVO vo, User user)
        throws Exception;

    public void doRemove(ZjtyRewarddetailVO vo, User user)
        throws Exception;

    public ZjtyRewarddetailVO doUpdate(ZjtyRewarddetailVO vo, User user)
        throws Exception;

    public ZjtyRewarddetailVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ZjtyRewarddetailListVO params, User user)
        throws Exception;
    
    public DataPackage doQuerybyType(ZjtyRewarddetailListVO params, User user)
    throws Exception;
}
