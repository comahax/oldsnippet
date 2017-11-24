/**
 * auto-generated code
 * Tue Mar 01 19:20:26 CST 2011
 */
package com.gmcc.pboss.control.channel.empconfirm;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.empconfirm.EmpconfirmDBParam;
import com.gmcc.pboss.business.channel.empconfirm.EmpconfirmVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Empconfirm </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public interface Empconfirm extends AbstractControl {
    public EmpconfirmVO doCreate(EmpconfirmVO vo) throws Exception;

    public void doRemoveByVO(EmpconfirmVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public EmpconfirmVO doUpdate(EmpconfirmVO vo) throws Exception;

    public EmpconfirmVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(EmpconfirmDBParam params) throws Exception;

}
