/**
 * auto-generated code
 * Wed Jul 08 10:49:25 CST 2009
 */
package com.gmcc.pboss.control.channel.citycompany;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.citycompany.CitycompanyDBParam;
import com.gmcc.pboss.business.channel.citycompany.CitycompanyVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Citycompany </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public interface Citycompany extends AbstractControl {
    public CitycompanyVO doCreate(CitycompanyVO vo) throws Exception;

    public void doRemoveByVO(CitycompanyVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public CitycompanyVO doUpdate(CitycompanyVO vo) throws Exception;

    public CitycompanyVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(CitycompanyDBParam params) throws Exception;
    
    public DataPackage doGetCitycompanysOfCenter(String centerid) throws Exception;

}
