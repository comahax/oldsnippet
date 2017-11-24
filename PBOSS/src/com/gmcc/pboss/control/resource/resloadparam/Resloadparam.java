/**
 * auto-generated code
 * Sat Sep 05 16:17:17 CST 2009
 */
package com.gmcc.pboss.control.resource.resloadparam;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.resloadparam.ResloadparamDBParam;
import com.gmcc.pboss.business.resource.resloadparam.ResloadparamVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Resloadparam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public interface Resloadparam extends AbstractControl {
    public ResloadparamVO doCreate(ResloadparamVO vo) throws Exception;

    public void doRemoveByVO(ResloadparamVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ResloadparamVO doUpdate(ResloadparamVO vo) throws Exception;

    public ResloadparamVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ResloadparamDBParam params) throws Exception;

}
