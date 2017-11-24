/**
 * auto-generated code
 * Fri May 25 11:37:59 CST 2012
 */
package com.gmcc.pboss.control.resource.resoperator;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.resoperator.ResoperatorDBParam;
import com.gmcc.pboss.business.resource.resoperator.ResoperatorVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Resoperator </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Resoperator extends AbstractControl {
    public ResoperatorVO doCreate(ResoperatorVO vo) throws Exception;

    public void doRemoveByVO(ResoperatorVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ResoperatorVO doUpdate(ResoperatorVO vo) throws Exception;

    public ResoperatorVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ResoperatorDBParam params) throws Exception;
    
    public DataPackage doWayinfo(ResoperatorDBParam params) throws Exception;

}
