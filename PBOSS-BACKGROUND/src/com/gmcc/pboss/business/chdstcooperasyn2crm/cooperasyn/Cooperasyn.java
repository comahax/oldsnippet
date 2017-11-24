/**
 * auto-generated code
 * Sat Jun 11 09:38:29 CST 2011
 */
package com.gmcc.pboss.business.chdstcooperasyn2crm.cooperasyn;

import java.io.Serializable;

import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Empsyn </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Cooperasyn extends AbstractControl {
    public CooperasynVO doCreate(CooperasynVO vo) throws Exception;

    public void doRemoveByVO(CooperasynVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public CooperasynVO doUpdate(CooperasynVO vo) throws Exception;

    public CooperasynVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(CooperasynDBParam params) throws Exception;
    
    public void doProcess(String  cityid, int batch_size) throws Exception;

}
