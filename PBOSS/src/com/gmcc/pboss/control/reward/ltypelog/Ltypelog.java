package com.gmcc.pboss.control.reward.ltypelog;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.ltypelog.LtypelogDBParam;
import com.gmcc.pboss.business.reward.ltypelog.LtypelogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Ltypelog </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public interface Ltypelog extends AbstractControl {
    public LtypelogVO doCreate(LtypelogVO vo) throws Exception;

    public void doRemoveByVO(LtypelogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public LtypelogVO doUpdate(LtypelogVO vo) throws Exception;

    public LtypelogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(LtypelogDBParam params) throws Exception;

}
