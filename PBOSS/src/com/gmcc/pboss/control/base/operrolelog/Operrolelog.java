/**
 * auto-generated code
 * Mon Sep 07 11:18:53 CST 2009
 */
package com.gmcc.pboss.control.base.operrolelog;

import java.io.Serializable;

import com.gmcc.pboss.business.base.operrolelog.OperrolelogDBParam;
import com.gmcc.pboss.business.base.operrolelog.OperrolelogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Operrolelog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public interface Operrolelog extends AbstractControl {
    public OperrolelogVO doCreate(OperrolelogVO vo) throws Exception;

    public void doRemoveByVO(OperrolelogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public OperrolelogVO doUpdate(OperrolelogVO vo) throws Exception;

    public OperrolelogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(OperrolelogDBParam params) throws Exception;

}
