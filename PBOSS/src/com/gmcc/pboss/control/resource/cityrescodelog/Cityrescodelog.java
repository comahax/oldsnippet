/**
 * auto-generated code
 * Tue Aug 09 16:10:47 CST 2011
 */
package com.gmcc.pboss.control.resource.cityrescodelog;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.cityrescodelog.CityrescodelogDBParam;
import com.gmcc.pboss.business.resource.cityrescodelog.CityrescodelogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Cityrescodelog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public interface Cityrescodelog extends AbstractControl {
    public CityrescodelogVO doCreate(CityrescodelogVO vo) throws Exception;

    public void doRemoveByVO(CityrescodelogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public CityrescodelogVO doUpdate(CityrescodelogVO vo) throws Exception;

    public CityrescodelogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(CityrescodelogDBParam params) throws Exception;

}
