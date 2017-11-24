/**
 * auto-generated code
 * Tue Sep 29 10:24:36 CST 2009
 */
package com.gmcc.pboss.control.communication.advapproval;

import java.io.Serializable;

import com.gmcc.pboss.business.communication.advapproval.AdvapprovalDBParam;
import com.gmcc.pboss.business.communication.advapproval.AdvapprovalVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Advapproval </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Advapproval extends AbstractControl {
    public AdvapprovalVO doCreate(AdvapprovalVO vo) throws Exception;

    public void doRemoveByVO(AdvapprovalVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public AdvapprovalVO doUpdate(AdvapprovalVO vo) throws Exception;

    public AdvapprovalVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(AdvapprovalDBParam params) throws Exception;

}
