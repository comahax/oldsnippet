/**
* auto-generated code
* Thu Aug 20 16:16:59 CST 2009
*/
package com.sunrise.boss.business.cms.reward.montask.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.montask.persistent.MontaskVO;
import com.sunrise.boss.business.cms.reward.montask.persistent.MontaskListVO;

import java.io.Serializable;

/**
 * <p>Title: MontaskControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public interface MontaskControl extends AbstractControl {
    public MontaskVO doCreate(MontaskVO vo, User user)
        throws Exception;

    public void doRemove(MontaskVO vo, User user)
        throws Exception;

    public MontaskVO doUpdate(MontaskVO vo, User user)
        throws Exception;

    public MontaskVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(MontaskListVO params, User user)
        throws Exception;
    
    public DataPackage doQuery2(MontaskListVO params, String value, String value0, User user)
    throws Exception;

}
