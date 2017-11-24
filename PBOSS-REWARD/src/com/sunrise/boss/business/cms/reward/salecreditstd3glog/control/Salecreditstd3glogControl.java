/**
* auto-generated code
* Tue Dec 11 12:11:57 CST 2012
*/
package com.sunrise.boss.business.cms.reward.salecreditstd3glog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.salecreditstd3glog.persistent.Salecreditstd3glogVO;
import com.sunrise.boss.business.cms.reward.salecreditstd3glog.persistent.Salecreditstd3glogListVO;

import java.io.Serializable;

/**
 * <p>Title: Salecreditstd3glogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public interface Salecreditstd3glogControl extends AbstractControl {
    public Salecreditstd3glogVO doCreate(Salecreditstd3glogVO vo, User user)
        throws Exception;

    public void doRemove(Salecreditstd3glogVO vo, User user)
        throws Exception;

    public Salecreditstd3glogVO doUpdate(Salecreditstd3glogVO vo, User user)
        throws Exception;

    public Salecreditstd3glogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(Salecreditstd3glogListVO params, User user)
        throws Exception;

}
