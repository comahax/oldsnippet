/**
 * auto-generated code
 * Tue Oct 13 09:23:33 CST 2009
 */
package com.gmcc.pboss.control.sales.baseorderamt;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.baseorderamt.BaseorderamtDBParam;
import com.gmcc.pboss.business.sales.baseorderamt.BaseorderamtVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Baseorderamt </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Baseorderamt extends AbstractControl {
    public BaseorderamtVO doCreate(BaseorderamtVO vo) throws Exception;

    public void doRemoveByVO(BaseorderamtVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public BaseorderamtVO doUpdate(BaseorderamtVO vo) throws Exception;

    public BaseorderamtVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(BaseorderamtDBParam params) throws Exception;

}
