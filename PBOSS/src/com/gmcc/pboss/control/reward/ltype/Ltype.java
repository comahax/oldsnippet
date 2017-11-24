package com.gmcc.pboss.control.reward.ltype;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.ltype.LtypeDBParam;
import com.gmcc.pboss.business.reward.ltype.LtypeVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Ltype </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public interface Ltype extends AbstractControl {
    public LtypeVO doCreate(LtypeVO vo) throws Exception;

    public void doRemoveByVO(LtypeVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public LtypeVO doUpdate(LtypeVO vo) throws Exception;

    public LtypeVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(LtypeDBParam params) throws Exception;

    public DataPackage doQueryBySql(LtypeDBParam params) throws Exception;
}
