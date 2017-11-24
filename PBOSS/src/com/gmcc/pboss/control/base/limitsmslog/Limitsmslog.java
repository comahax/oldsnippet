/**
 * auto-generated code
 * Tue Nov 08 10:06:39 CST 2011
 */
package com.gmcc.pboss.control.base.limitsmslog;

import java.io.Serializable;

import com.gmcc.pboss.business.base.limitsmslog.LimitsmslogDBParam;
import com.gmcc.pboss.business.base.limitsmslog.LimitsmslogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Limitsmslog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public interface Limitsmslog extends AbstractControl {
    public LimitsmslogVO doCreate(LimitsmslogVO vo) throws Exception;

    public void doRemoveByVO(LimitsmslogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public LimitsmslogVO doUpdate(LimitsmslogVO vo) throws Exception;

    public LimitsmslogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(LimitsmslogDBParam params) throws Exception;

}
