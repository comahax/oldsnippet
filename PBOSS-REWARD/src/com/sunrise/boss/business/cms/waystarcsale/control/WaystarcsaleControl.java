/**
* auto-generated code
* Wed Feb 24 11:50:56 CST 2010
*/
package com.sunrise.boss.business.cms.waystarcsale.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.waystarcsale.persistent.WaystarcsaleVO;
import com.sunrise.boss.business.cms.waystarcsale.persistent.WaystarcsaleListVO;

import java.io.Serializable;

/**
 * <p>Title: WaystarcsaleControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Canigar
 * @version 1.0
 */
public interface WaystarcsaleControl extends AbstractControl {
    public WaystarcsaleVO doCreate(WaystarcsaleVO vo, User user)
        throws Exception;

    public void doRemove(WaystarcsaleVO vo, User user)
        throws Exception;

    public WaystarcsaleVO doUpdate(WaystarcsaleVO vo, User user)
        throws Exception;

    public WaystarcsaleVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(WaystarcsaleListVO params, User user)
        throws Exception;

}
