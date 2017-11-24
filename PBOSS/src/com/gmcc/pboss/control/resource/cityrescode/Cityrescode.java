/**
 * auto-generated code
 * Tue Aug 09 20:23:41 CST 2011
 */
package com.gmcc.pboss.control.resource.cityrescode;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.cityrescode.CityrescodeDBParam;
import com.gmcc.pboss.business.resource.cityrescode.CityrescodeVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Cityrescode </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public interface Cityrescode extends AbstractControl {
    public CityrescodeVO doCreate(CityrescodeVO vo) throws Exception;

    public void doRemoveByVO(CityrescodeVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public CityrescodeVO doUpdate(CityrescodeVO vo) throws Exception;

    public CityrescodeVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(CityrescodeDBParam params) throws Exception;

}
