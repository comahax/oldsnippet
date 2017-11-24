/**
* auto-generated code
* Fri Aug 25 11:23:52 CST 2006
*/
package com.sunrise.boss.delegate.cms.citycompany;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.citycompany.control.CitycompanyControl;
import com.sunrise.boss.business.cms.citycompany.control.CitycompanyControlBean;
import com.sunrise.boss.business.cms.citycompany.persistent.CitycompanyVO;
import com.sunrise.boss.business.cms.citycompany.persistent.CitycompanyListVO;

import java.io.Serializable;

/**
 * <p>Title: CitycompanyDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
public class CitycompanyDelegate {

    private static CitycompanyControl control;

    public CitycompanyDelegate() throws Exception {
        control = (CitycompanyControl) ControlFactory.build(CitycompanyControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public CitycompanyVO doCreate(CitycompanyVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(CitycompanyVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public CitycompanyVO doUpdate(CitycompanyVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public CitycompanyVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (CitycompanyVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(CitycompanyListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
    public DataPackage getCitycompanysOfCenter(String centerid, User user )
    throws Exception {
    	return control.getCitycompanysOfCenter(centerid, user);
    } 
    public DataPackage doQueryByOprcode(CitycompanyListVO params, User user )
    	throws Exception {
    return control.doQueryByOprcode(params, user);
    }
    public boolean doIfOrgcodenull(String adacode, User user) throws Exception{
    	return control.doIfOrgcodenull(adacode, user);
    }
    public void doUpdateOrgcode(String adacode, String orgcode, User user)throws Exception{
    	control.doUpdateOrgcode(adacode, orgcode, user);
    }
    public String doGetOrgcode(String adacode, User user) throws Exception {
    	return control.doGetOrgcode(adacode, user);
    }
}
