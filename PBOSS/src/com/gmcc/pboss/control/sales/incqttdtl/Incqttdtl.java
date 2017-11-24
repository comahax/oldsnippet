/**
 * auto-generated code
 * Thu Oct 29 15:57:12 CST 2009
 */
package com.gmcc.pboss.control.sales.incqttdtl;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.incqttdtl.IncqttdtlDBParam;
import com.gmcc.pboss.business.sales.incqttdtl.IncqttdtlVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Incqttdtl </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Canigar
 * @version 1.0
 */
public interface Incqttdtl extends AbstractControl {
    public IncqttdtlVO doCreate(IncqttdtlVO vo) throws Exception;

    public void doRemoveByVO(IncqttdtlVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public IncqttdtlVO doUpdate(IncqttdtlVO vo) throws Exception;

    public IncqttdtlVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(IncqttdtlDBParam params) throws Exception;

}
