/**
 * auto-generated code
 * Wed Oct 14 09:04:57 CST 2009
 */
package com.gmcc.pboss.control.sales.process;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.process.ProcessDBParam;
import com.gmcc.pboss.business.sales.process.ProcessVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Process </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public interface Process extends AbstractControl {
    public ProcessVO doCreate(ProcessVO vo) throws Exception;

    public void doRemoveByVO(ProcessVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ProcessVO doUpdate(ProcessVO vo) throws Exception;

    public ProcessVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ProcessDBParam params) throws Exception;

}
