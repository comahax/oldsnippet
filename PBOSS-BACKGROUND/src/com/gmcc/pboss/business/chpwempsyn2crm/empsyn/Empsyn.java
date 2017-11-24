/**
 * auto-generated code
 * Sat Jun 11 09:38:29 CST 2011
 */
package com.gmcc.pboss.business.chpwempsyn2crm.empsyn;

import java.io.Serializable;

import com.gmcc.pboss.business.chpwempsyn2crm.empsyn.EmpsynDBParam;
import com.gmcc.pboss.business.chpwempsyn2crm.empsyn.EmpsynVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Empsyn </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Empsyn extends AbstractControl {
    public EmpsynVO doCreate(EmpsynVO vo) throws Exception;

    public void doRemoveByVO(EmpsynVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public EmpsynVO doUpdate(EmpsynVO vo) throws Exception;

    public EmpsynVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(EmpsynDBParam params) throws Exception;
    
    public void doProcess(String  cityid, int batch_size) throws Exception;

}
