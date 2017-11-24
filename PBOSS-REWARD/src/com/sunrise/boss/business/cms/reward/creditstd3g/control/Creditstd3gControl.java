/**
* auto-generated code
* Sat Dec 08 10:23:53 CST 2012
*/
package com.sunrise.boss.business.cms.reward.creditstd3g.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.creditstd3g.persistent.Creditstd3gVO;
import com.sunrise.boss.business.cms.reward.creditstd3g.persistent.Creditstd3gListVO;

import java.io.Serializable;

/**
 * <p>Title: Creditstd3glogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public interface Creditstd3gControl extends AbstractControl {
    public Creditstd3gVO doCreate(Creditstd3gVO vo, User user)
        throws Exception;

    public void doRemove(Creditstd3gVO vo, User user)
        throws Exception;

    public Creditstd3gVO doUpdate(Creditstd3gVO vo, User user)
        throws Exception;

    public Creditstd3gVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(Creditstd3gListVO params, User user)
        throws Exception;
    
    public DataPackage doQuerystdset(Creditstd3gListVO params, User user)
    throws Exception ;

}
