/**
* auto-generated code
* Sun Feb 01 10:31:20 CST 2009
*/
package com.sunrise.boss.business.cms.cityrewardad.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.cityrewardad.persistent.CityrewardadVO;
import com.sunrise.boss.business.cms.cityrewardad.persistent.CityrewardadListVO;

import java.io.Serializable;

/**
 * <p>Title: CityrewardadControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public interface CityrewardadControl extends AbstractControl {
    public CityrewardadVO doCreate(CityrewardadVO vo, User user)
        throws Exception;

    public void doRemove(CityrewardadVO vo, User user)
        throws Exception;

    public CityrewardadVO doUpdate(CityrewardadVO vo, User user)
        throws Exception;

    public CityrewardadVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(CityrewardadListVO params, User user)
        throws Exception;

}
