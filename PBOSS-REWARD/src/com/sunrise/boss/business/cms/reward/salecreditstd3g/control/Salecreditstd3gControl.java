/**
* auto-generated code
* Tue Dec 11 09:30:18 CST 2012
*/
package com.sunrise.boss.business.cms.reward.salecreditstd3g.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.salecreditstd3g.persistent.Salecreditstd3gVO;
import com.sunrise.boss.business.cms.reward.salecreditstd3g.persistent.Salecreditstd3gListVO;

import java.io.Serializable;

/**
 * <p>Title: Salecreditstd3gControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public interface Salecreditstd3gControl extends AbstractControl {
    public Salecreditstd3gVO doCreate(Salecreditstd3gVO vo, User user)
        throws Exception;

    public void doRemove(Salecreditstd3gVO vo, User user)
        throws Exception;

    public Salecreditstd3gVO doUpdate(Salecreditstd3gVO vo, User user)
        throws Exception;

    public Salecreditstd3gVO doFindByPk(Serializable pk, User user)
        throws Exception;
    
    public void doRemoveByPk(Serializable pk, User user)throws Exception;

    public DataPackage doQuery(Salecreditstd3gListVO params, User user)
        throws Exception;

}
