/**
 * auto-generated code
 * Tue Sep 13 15:08:16 CST 2011
 */
package com.gmcc.pboss.business.imprrlparamsyn2crm.rlparamsynlog;

import java.io.Serializable;


import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Rlparamsynlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Rlparamsynlog extends AbstractControl {
    public RlparamsynlogVO doCreate(RlparamsynlogVO vo) throws Exception;

    public void doRemoveByVO(RlparamsynlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public RlparamsynlogVO doUpdate(RlparamsynlogVO vo) throws Exception;

    public RlparamsynlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(RlparamsynlogDBParam params) throws Exception;

}
