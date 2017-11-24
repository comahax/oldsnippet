package com.gmcc.pboss.control.reward.stype;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.ltype.LtypeDBParam;
import com.gmcc.pboss.business.reward.stype.StypeDBParam;
import com.gmcc.pboss.business.reward.stype.StypeVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Stype </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public interface Stype extends AbstractControl {
    public StypeVO doCreate(StypeVO vo) throws Exception;

    public void doRemoveByVO(StypeVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public StypeVO doUpdate(StypeVO vo) throws Exception;

    public StypeVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(StypeDBParam params) throws Exception;

    public DataPackage doQueryBySql(StypeDBParam params) throws Exception;
    
    public DataPackage doQueryStypeBySql(StypeDBParam params, int type) throws Exception;
}
