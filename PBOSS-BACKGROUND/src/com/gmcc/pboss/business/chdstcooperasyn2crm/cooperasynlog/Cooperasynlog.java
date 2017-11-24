/**
 * auto-generated code
 * Sat Jun 11 09:41:33 CST 2011
 */
package com.gmcc.pboss.business.chdstcooperasyn2crm.cooperasynlog;

import java.io.Serializable;

import com.gmcc.pboss.business.chpwempsyn2crm.empsynlog.EmpsynlogDBParam;
import com.gmcc.pboss.business.chpwempsyn2crm.empsynlog.EmpsynlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Empsynlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Cooperasynlog extends AbstractControl {
    public CooperasynlogVO doCreate(CooperasynlogVO vo) throws Exception;

    public void doRemoveByVO(CooperasynlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public CooperasynlogVO doUpdate(CooperasynlogVO vo) throws Exception;

    public CooperasynlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(CooperasynlogDBParam params) throws Exception;

}
