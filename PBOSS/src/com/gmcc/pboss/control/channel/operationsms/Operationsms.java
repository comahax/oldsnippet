/**
 * auto-generated code
 * Thu Mar 10 18:50:30 CST 2011
 */
package com.gmcc.pboss.control.channel.operationsms;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.operationsms.OperationsmsDBParam;
import com.gmcc.pboss.business.channel.operationsms.OperationsmsVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Operationsms </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public interface Operationsms extends AbstractControl {
    public OperationsmsVO doCreate(OperationsmsVO vo) throws Exception;

    public void doRemoveByVO(OperationsmsVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public OperationsmsVO doUpdate(OperationsmsVO vo) throws Exception;

    public OperationsmsVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(OperationsmsDBParam params) throws Exception;

}
