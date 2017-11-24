package com.gmcc.pboss.business.cms.examine.coefficient.control;

import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.coefficient.persistent.CoefficientListVO;
import com.gmcc.pboss.business.cms.examine.coefficient.persistent.CoefficientVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: CoefficientControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Coefficient extends AbstractControl {
    public CoefficientVO doCreate(CoefficientVO vo)
        throws Exception;

    public void doRemove(CoefficientVO vo)
        throws Exception;

    public CoefficientVO doUpdate(CoefficientVO vo)
        throws Exception;

    public CoefficientVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(CoefficientListVO params)
        throws Exception;
    
    public DataPackage doQueryByNameSql(String nameSql,CoefficientListVO params)
    throws Exception;

}
