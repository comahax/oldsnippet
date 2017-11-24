/**
 * auto-generated code
 * Tue Jul 27 12:08:11 CST 2010
 */
package com.gmcc.pboss.control.resource.stkalarmstat;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.stkalarmstat.StkalarmstatDBParam;
import com.gmcc.pboss.business.resource.stkalarmstat.StkalarmstatVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Stkalarmstat </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Stkalarmstat extends AbstractControl {
    public StkalarmstatVO doCreate(StkalarmstatVO vo) throws Exception;

    public void doRemoveByVO(StkalarmstatVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public StkalarmstatVO doUpdate(StkalarmstatVO vo) throws Exception;

    public StkalarmstatVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(StkalarmstatDBParam params) throws Exception;
    
    public DataPackage doQueryDetails1(StkalarmstatDBParam params) throws Exception ;
    
    public DataPackage doQueryDetails2(StkalarmstatDBParam params) throws Exception;
    
    public DataPackage doQueryStat(StkalarmstatDBParam params) throws Exception;

}
