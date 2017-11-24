/**
 * auto-generated code
 * Thu Apr 05 09:18:42 CST 2012
 */
package com.gmcc.pboss.control.sales.simrealtimeamt;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.simrealtimeamt.SimrealtimeamtDBParam;
import com.gmcc.pboss.business.sales.simrealtimeamt.SimrealtimeamtVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Simrealtimeamt </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public interface Simrealtimeamt extends AbstractControl {
    public SimrealtimeamtVO doCreate(SimrealtimeamtVO vo) throws Exception;

    public void doRemoveByVO(SimrealtimeamtVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public SimrealtimeamtVO doUpdate(SimrealtimeamtVO vo) throws Exception;

    public SimrealtimeamtVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(SimrealtimeamtDBParam params) throws Exception;

}
