/**
* auto-generated code
* Tue Mar 13 17:29:11 CST 2012
*/
package com.sunrise.boss.business.cms.cityrecordtotal.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.cityrecordtotal.persistent.CityrecordtotalVO;
import com.sunrise.boss.business.cms.cityrecordtotal.persistent.CityrecordtotalListVO;

import java.io.Serializable;

/**
 * <p>Title: CityrecordtotalControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public interface CityrecordtotalControl extends AbstractControl {
    public CityrecordtotalVO doCreate(CityrecordtotalVO vo, User user)
        throws Exception;

    public void doRemove(CityrecordtotalVO vo, User user)
        throws Exception;

    public CityrecordtotalVO doUpdate(CityrecordtotalVO vo, User user)
        throws Exception;

    public CityrecordtotalVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(CityrecordtotalListVO params, User user)
        throws Exception;
    public DataPackage doQuerycnt(CityrecordtotalListVO params, User user)
    throws Exception ;
}
