/**
 * auto-generated code
 * Tue Nov 08 09:56:31 CST 2011
 */
package com.gmcc.pboss.control.base.limitsms;

import java.io.Serializable;

import com.gmcc.pboss.business.base.limitsms.LimitsmsDBParam;
import com.gmcc.pboss.business.base.limitsms.LimitsmsVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Limitsms </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public interface Limitsms extends AbstractControl {
    public LimitsmsVO doCreate(LimitsmsVO vo) throws Exception;

    public void doRemoveByVO(LimitsmsVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public LimitsmsVO doUpdate(LimitsmsVO vo) throws Exception;

    public LimitsmsVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(LimitsmsDBParam params) throws Exception;

}
