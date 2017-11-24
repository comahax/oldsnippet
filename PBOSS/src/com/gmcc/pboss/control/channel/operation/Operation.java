/**
 * auto-generated code
 * Sun Sep 13 11:38:11 CST 2009
 */
package com.gmcc.pboss.control.channel.operation;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.operation.OperationDBParam;
import com.gmcc.pboss.business.channel.operation.OperationVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Operation </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Canigar
 * @version 1.0
 */
public interface Operation extends AbstractControl {
    public OperationVO doCreate(OperationVO vo) throws Exception;

    public void doRemoveByVO(OperationVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public OperationVO doUpdate(OperationVO vo) throws Exception;

    public OperationVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(OperationDBParam params) throws Exception;

}
