/**
* auto-generated code
* Fri Aug 25 11:23:52 CST 2006
*/
package com.sunrise.boss.business.fee.citycompany.control;

import java.io.Serializable;

import com.sunrise.boss.business.fee.citycompany.persistent.CitycompanyDBParam;
import com.sunrise.boss.business.fee.citycompany.persistent.CitycompanyVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;


/**
 * <p>Title: CitycompanyControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
public interface Citycompany extends AbstractControl {
    public CitycompanyVO doCreate(CitycompanyVO vo)
        throws Exception;

    public void doRemove(CitycompanyVO vo)
        throws Exception;

    public CitycompanyVO doUpdate(CitycompanyVO vo)
        throws Exception;

    public CitycompanyVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(CitycompanyDBParam params)
        throws Exception;
	
}
