/**
 * auto-generated code
 * Mon Nov 14 15:52:02 CST 2011
 */
package com.gmcc.pboss.control.sales.disoverstat;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.disoverstat.DisoverstatDBParam;
import com.gmcc.pboss.business.sales.disoverstat.DisoverstatVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Disoverstat </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Disoverstat extends AbstractControl {
    public DisoverstatVO doCreate(DisoverstatVO vo) throws Exception;

    public void doRemoveByVO(DisoverstatVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public DisoverstatVO doUpdate(DisoverstatVO vo) throws Exception;

    public DisoverstatVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(DisoverstatDBParam params) throws Exception;

}
