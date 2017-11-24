/**
* auto-generated code
* Tue Oct 17 17:37:23 CST 2006
*/
package com.sunrise.boss.business.cms.citycomlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.citycomlog.persistent.CitycomlogVO;
import com.sunrise.boss.business.cms.citycomlog.persistent.CitycomlogListVO;

import java.io.Serializable;

/**
 * <p>Title: CitycomlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public interface CitycomlogControl extends AbstractControl {
    public CitycomlogVO doCreate(CitycomlogVO vo, User user)
        throws Exception;

    public void doRemove(CitycomlogVO vo, User user)
        throws Exception;

    public CitycomlogVO doUpdate(CitycomlogVO vo, User user)
        throws Exception;

    public CitycomlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(CitycomlogListVO params, User user)
        throws Exception;

}
