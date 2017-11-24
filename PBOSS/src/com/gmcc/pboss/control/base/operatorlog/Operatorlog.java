/**
 * auto-generated code
 * Tue Sep 08 09:43:07 CST 2009
 */
package com.gmcc.pboss.control.base.operatorlog;

import java.io.Serializable;

import com.gmcc.pboss.business.base.operatorlog.OperatorlogDBParam;
import com.gmcc.pboss.business.base.operatorlog.OperatorlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Operatorlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public interface Operatorlog extends AbstractControl {
    public OperatorlogVO doCreate(OperatorlogVO vo) throws Exception;

    public void doRemoveByVO(OperatorlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public OperatorlogVO doUpdate(OperatorlogVO vo) throws Exception;

    public OperatorlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(OperatorlogDBParam params) throws Exception;

}
