/**
* auto-generated code
* Sat Dec 08 10:23:53 CST 2012
*/
package com.sunrise.boss.business.cms.reward.creditstd3glog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.creditstd3glog.persistent.Creditstd3glogVO;
import com.sunrise.boss.business.cms.reward.creditstd3glog.persistent.Creditstd3glogListVO;

import java.io.Serializable;

/**
 * <p>Title: Creditstd3gControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public interface Creditstd3glogControl extends AbstractControl {
    public Creditstd3glogVO doCreate(Creditstd3glogVO vo, User user)
        throws Exception;

    public void doRemove(Creditstd3glogVO vo, User user)
        throws Exception;

    public Creditstd3glogVO doUpdate(Creditstd3glogVO vo, User user)
        throws Exception;

    public Creditstd3glogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(Creditstd3glogListVO params, User user)
        throws Exception;

}
