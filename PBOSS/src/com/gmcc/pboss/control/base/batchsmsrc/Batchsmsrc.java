/**
 * auto-generated code
 * Fri May 20 16:28:47 CST 2011
 */
package com.gmcc.pboss.control.base.batchsmsrc;

import java.io.Serializable;

import com.gmcc.pboss.business.base.batchsmsrc.BatchsmsrcDBParam;
import com.gmcc.pboss.business.base.batchsmsrc.BatchsmsrcVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Batchsmsrc </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author YangDaRen
 * @version 1.0
 */
public interface Batchsmsrc extends AbstractControl {
    public BatchsmsrcVO doCreate(BatchsmsrcVO vo) throws Exception;

    public void doRemoveByVO(BatchsmsrcVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public BatchsmsrcVO doUpdate(BatchsmsrcVO vo) throws Exception;

    public BatchsmsrcVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(BatchsmsrcDBParam params) throws Exception;

}
