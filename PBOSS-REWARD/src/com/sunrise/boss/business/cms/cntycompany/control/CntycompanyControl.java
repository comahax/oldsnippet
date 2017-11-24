/**
* auto-generated code
* Fri Aug 25 11:16:40 CST 2006
*/
package com.sunrise.boss.business.cms.cntycompany.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.cntycompany.persistent.CntycompanyVO;
import com.sunrise.boss.business.cms.cntycompany.persistent.CntycompanyListVO;

import java.io.Serializable;


/**
 * <p>Title: CntycompanyControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
public interface CntycompanyControl extends AbstractControl {
    public CntycompanyVO doCreate(CntycompanyVO vo, User user)
        throws Exception;

    public void doRemove(CntycompanyVO vo, User user)
        throws Exception;

    public CntycompanyVO doUpdate(CntycompanyVO vo, User user)
        throws Exception;

    public CntycompanyVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(CntycompanyListVO params, User user)
        throws Exception;

	public DataPackage getCntycompanysOfCity(String cityid, User user) throws Exception;
	
	public DataPackage doQueryByOprcode(CntycompanyListVO params, User user)
		throws Exception;

    public boolean doIfOrgcodenull(String adacode, User user) throws Exception;
    
    public void doUpdateOrgcode(String adacode, String orgcode, User user)
		throws Exception;
    
    public String doGetOrgcode(String adacode, User user) throws Exception ;
}
