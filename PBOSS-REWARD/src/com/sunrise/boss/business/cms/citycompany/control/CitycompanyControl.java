/**
* auto-generated code
* Fri Aug 25 11:23:52 CST 2006
*/
package com.sunrise.boss.business.cms.citycompany.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.citycompany.persistent.CitycompanyVO;
import com.sunrise.boss.business.cms.citycompany.persistent.CitycompanyListVO;

import java.io.Serializable;


/**
 * <p>Title: CitycompanyControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
public interface CitycompanyControl extends AbstractControl {
    public CitycompanyVO doCreate(CitycompanyVO vo, User user)
        throws Exception;

    public void doRemove(CitycompanyVO vo, User user)
        throws Exception;

    public CitycompanyVO doUpdate(CitycompanyVO vo, User user)
        throws Exception;

    public CitycompanyVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(CitycompanyListVO params, User user)
        throws Exception;

	public DataPackage getCitycompanysOfCenter(String centerid, User user)  throws Exception;
	
	public DataPackage doQueryByOprcode(CitycompanyListVO params, User user)
		throws Exception;
	
    public boolean doIfOrgcodenull(String adacode, User user) throws Exception;
    
    public void doUpdateOrgcode(String adacode, String orgcode, User user)
		throws Exception;
    
    public String doGetOrgcode(String adacode, User user) throws Exception ;

}
