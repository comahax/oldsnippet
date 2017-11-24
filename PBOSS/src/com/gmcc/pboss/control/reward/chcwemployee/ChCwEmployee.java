/**
 * auto-generated code
 * Tue Sep 15 10:34:49 CST 2015
 */
package com.gmcc.pboss.control.reward.chcwemployee;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.chcwemployee.ChCwEmployeeDBParam;
import com.gmcc.pboss.business.reward.chcwemployee.ChCwEmployeeVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ChCwEmployee </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author ydr
 * @version 1.0
 */
public interface ChCwEmployee extends AbstractControl {
    public ChCwEmployeeVO doCreate(ChCwEmployeeVO vo) throws Exception;

    public void doRemoveByVO(ChCwEmployeeVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ChCwEmployeeVO doUpdate(ChCwEmployeeVO vo) throws Exception;

    public ChCwEmployeeVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ChCwEmployeeDBParam params) throws Exception;

}
