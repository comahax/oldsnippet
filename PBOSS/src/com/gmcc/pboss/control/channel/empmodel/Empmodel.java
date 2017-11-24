/**
 * auto-generated code
 * Tue Jun 29 12:02:04 CST 2010
 */
package com.gmcc.pboss.control.channel.empmodel;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.empmodel.EmpmodelDBParam;
import com.gmcc.pboss.business.channel.empmodel.EmpmodelVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Empmodel </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author zhangsiwei
 * @version 1.0
 */
public interface Empmodel extends AbstractControl {
    public EmpmodelVO doCreate(EmpmodelVO vo) throws Exception;

    public EmpmodelVO doCreateNoSeq(EmpmodelVO vo) throws Exception;
    
    public void doRemoveByVO(EmpmodelVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public EmpmodelVO doUpdate(EmpmodelVO vo) throws Exception;

    public EmpmodelVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(EmpmodelDBParam params) throws Exception;

}
