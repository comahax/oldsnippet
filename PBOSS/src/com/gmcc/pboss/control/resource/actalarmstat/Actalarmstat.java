/**
 * auto-generated code
 * Tue Jul 27 15:41:54 CST 2010
 */
package com.gmcc.pboss.control.resource.actalarmstat;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.actalarmstat.ActalarmstatDBParam;
import com.gmcc.pboss.business.resource.actalarmstat.ActalarmstatVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Actalarmstat </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Actalarmstat extends AbstractControl {
    public ActalarmstatVO doCreate(ActalarmstatVO vo) throws Exception;

    public void doRemoveByVO(ActalarmstatVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ActalarmstatVO doUpdate(ActalarmstatVO vo) throws Exception;

    public ActalarmstatVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ActalarmstatDBParam params) throws Exception;

    public DataPackage doUnionQuery(Object[] params,Class[] classvo,String[][] joins)throws Exception;
}
