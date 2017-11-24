/**
 * auto-generated code
 * Tue Sep 13 15:06:31 CST 2011
 */
package com.gmcc.pboss.business.imprrlparamsyn2crm.rlparamsyn;

import java.io.Serializable;

import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Rlparamsyn </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Rlparamsyn extends AbstractControl {
    public RlparamsynVO doCreate(RlparamsynVO vo) throws Exception;

    public void doRemoveByVO(RlparamsynVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public RlparamsynVO doUpdate(RlparamsynVO vo) throws Exception;

    public RlparamsynVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(RlparamsynDBParam params) throws Exception;

    public void doProcess(String cityid, int batch_size) throws Exception;
    
}
