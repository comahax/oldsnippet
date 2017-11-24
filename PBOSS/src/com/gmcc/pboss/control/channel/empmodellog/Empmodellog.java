/**
 * auto-generated code
 * Fri Mar 04 17:08:10 CST 2011
 */
package com.gmcc.pboss.control.channel.empmodellog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.empmodellog.EmpmodellogDBParam;
import com.gmcc.pboss.business.channel.empmodellog.EmpmodellogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Empmodellog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public interface Empmodellog extends AbstractControl {
    public EmpmodellogVO doCreate(EmpmodellogVO vo) throws Exception;

    public void doRemoveByVO(EmpmodellogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public EmpmodellogVO doUpdate(EmpmodellogVO vo) throws Exception;

    public EmpmodellogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(EmpmodellogDBParam params) throws Exception;

}
