/**
 * auto-generated code
 * Tue Oct 13 09:27:46 CST 2009
 */
package com.gmcc.pboss.control.sales.comorderstate;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.comorderstate.ComorderstateDBParam;
import com.gmcc.pboss.business.sales.comorderstate.ComorderstateVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Comorderstate </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Comorderstate extends AbstractControl {
    public ComorderstateVO doCreate(ComorderstateVO vo) throws Exception;

    public void doRemoveByVO(ComorderstateVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ComorderstateVO doUpdate(ComorderstateVO vo) throws Exception;

    public ComorderstateVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ComorderstateDBParam params) throws Exception;

}
