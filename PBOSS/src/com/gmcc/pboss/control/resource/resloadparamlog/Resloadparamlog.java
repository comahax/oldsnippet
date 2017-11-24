/**
 * auto-generated code
 * Thu Sep 03 10:29:08 CST 2009
 */
package com.gmcc.pboss.control.resource.resloadparamlog;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.resloadparamlog.ResloadparamlogDBParam;
import com.gmcc.pboss.business.resource.resloadparamlog.ResloadparamlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Resloadparamlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Resloadparamlog extends AbstractControl {
    public ResloadparamlogVO doCreate(ResloadparamlogVO vo) throws Exception;

    public void doRemoveByVO(ResloadparamlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ResloadparamlogVO doUpdate(ResloadparamlogVO vo) throws Exception;

    public ResloadparamlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ResloadparamlogDBParam params) throws Exception;

}
