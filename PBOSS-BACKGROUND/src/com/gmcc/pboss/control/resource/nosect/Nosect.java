/**
 * auto-generated code
 * Tue Mar 02 10:13:35 CST 2010
 */
package com.gmcc.pboss.control.resource.nosect;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.nosect.NosectDBParam;
import com.gmcc.pboss.business.resource.nosect.NosectVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Nosect </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Canigar
 * @version 1.0
 */
public interface Nosect extends AbstractControl {
    public NosectVO doCreate(NosectVO vo) throws Exception;

    public void doRemoveByVO(NosectVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public NosectVO doUpdate(NosectVO vo) throws Exception;

    public NosectVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(NosectDBParam params) throws Exception;
    
    public String doQueryCityID(String mobileno) throws Exception;

}
