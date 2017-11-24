/**
* auto-generated code
* Thu Oct 19 11:53:38 CST 2006
*/
package com.sunrise.boss.business.zifee.eboxdisclog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.eboxdisclog.persistent.EboxdisclogVO;
import com.sunrise.boss.business.zifee.eboxdisclog.persistent.EboxdisclogListVO;

import java.io.Serializable;

/**
 * <p>Title: EboxdisclogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author eboxdisc
 * @version 1.0
 */
public interface EboxdisclogControl extends AbstractControl {
    public EboxdisclogVO doCreate(EboxdisclogVO vo, User user)
        throws Exception;

    public void doRemove(EboxdisclogVO vo, User user)
        throws Exception;

    public EboxdisclogVO doUpdate(EboxdisclogVO vo, User user)
        throws Exception;

    public EboxdisclogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(EboxdisclogListVO params, User user)
        throws Exception;

}
