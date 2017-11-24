/**
 * auto-generated code
 * Mon Sep 07 10:54:49 CST 2009
 */
package com.gmcc.pboss.control.base.batchlog;

import java.io.Serializable;

import com.gmcc.pboss.business.base.batchlog.BatchlogDBParam;
import com.gmcc.pboss.business.base.batchlog.BatchlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Batchlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public interface Batchlog extends AbstractControl {
    public BatchlogVO doCreate(BatchlogVO vo) throws Exception;

    public void doRemoveByVO(BatchlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public BatchlogVO doUpdate(BatchlogVO vo) throws Exception;

    public BatchlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(BatchlogDBParam params) throws Exception;

}
