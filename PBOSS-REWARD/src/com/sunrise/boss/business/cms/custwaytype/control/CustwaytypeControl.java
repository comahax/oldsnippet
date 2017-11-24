/**
* auto-generated code
* Fri Aug 25 11:25:35 CST 2006
*/
package com.sunrise.boss.business.cms.custwaytype.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.custwaytype.persistent.CustwaytypeVO;
import com.sunrise.boss.business.cms.custwaytype.persistent.CustwaytypeListVO;

import java.io.Serializable;

/**
 * <p>Title: CustwaytypeControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
public interface CustwaytypeControl extends AbstractControl {
    public CustwaytypeVO doCreate(CustwaytypeVO vo, User user)
        throws Exception;

    public void doRemove(CustwaytypeVO vo, User user)
        throws Exception;

    public CustwaytypeVO doUpdate(CustwaytypeVO vo, User user)
        throws Exception;

    public CustwaytypeVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(CustwaytypeListVO params, User user)
        throws Exception;
    
    public DataPackage doFindByCitycompany(String cityid, User user)
    throws Exception ;

}
