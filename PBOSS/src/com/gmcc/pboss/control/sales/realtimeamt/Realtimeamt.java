/**
 * auto-generated code
 * Tue Oct 13 09:42:25 CST 2009
 */
package com.gmcc.pboss.control.sales.realtimeamt;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.realtimeamt.RealtimeamtDBParam;
import com.gmcc.pboss.business.sales.realtimeamt.RealtimeamtVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Realtimeamt </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Realtimeamt extends AbstractControl {
    public RealtimeamtVO doCreate(RealtimeamtVO vo) throws Exception;

    public void doRemoveByVO(RealtimeamtVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public RealtimeamtVO doUpdate(RealtimeamtVO vo) throws Exception;

    public RealtimeamtVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(RealtimeamtDBParam params) throws Exception;

}
