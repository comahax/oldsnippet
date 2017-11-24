/**
* auto-generated code
* Fri Aug 25 11:26:23 CST 2006
*/
package com.sunrise.boss.business.cms.custbchtype.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.custbchtype.persistent.CustbchtypeVO;
import com.sunrise.boss.business.cms.custbchtype.persistent.CustbchtypeListVO;

import java.io.Serializable;

/**
 * <p>Title: CustbchtypeControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
public interface CustbchtypeControl extends AbstractControl {
    public CustbchtypeVO doCreate(CustbchtypeVO vo, User user)
        throws Exception;

    public void doRemove(CustbchtypeVO vo, User user)
        throws Exception;

    public CustbchtypeVO doUpdate(CustbchtypeVO vo, User user)
        throws Exception;

    public CustbchtypeVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(CustbchtypeListVO params, User user)
        throws Exception;
    public DataPackage doFindByCitycompany(String cityid, User user)
       throws Exception ;

}
