/**
 * auto-generated code
 * Wed Sep 08 17:44:18 CST 2010
 */
package com.gmcc.pboss.control.sales.vrealtimeamt;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.vrealtimeamt.VrealtimeamtDBParam;
import com.gmcc.pboss.business.sales.vrealtimeamt.VrealtimeamtVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Vrealtimeamt </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jemy
 * @version 1.0
 */
public interface Vrealtimeamt extends AbstractControl {
    public VrealtimeamtVO doCreate(VrealtimeamtVO vo) throws Exception;

    public void doRemoveByVO(VrealtimeamtVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public VrealtimeamtVO doUpdate(VrealtimeamtVO vo) throws Exception;

    public VrealtimeamtVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(VrealtimeamtDBParam params) throws Exception;

}
