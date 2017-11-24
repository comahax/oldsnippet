/**
 * auto-generated code
 * Wed Aug 04 10:45:31 CST 2010
 */
package com.gmcc.pboss.control.sales.ordcomlog;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.ordcomlog.OrdcomlogDBParam;
import com.gmcc.pboss.business.sales.ordcomlog.OrdcomlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Ordcomlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Ordcomlog extends AbstractControl {
    public OrdcomlogVO doCreate(OrdcomlogVO vo) throws Exception;

    public void doRemoveByVO(OrdcomlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public OrdcomlogVO doUpdate(OrdcomlogVO vo) throws Exception;

    public OrdcomlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(OrdcomlogDBParam params) throws Exception;

}
