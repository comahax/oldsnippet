package com.gmcc.pboss.control.reward.stypelog;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.stypelog.StypelogDBParam;
import com.gmcc.pboss.business.reward.stypelog.StypelogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Stypelog </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public interface Stypelog extends AbstractControl {
    public StypelogVO doCreate(StypelogVO vo) throws Exception;

    public void doRemoveByVO(StypelogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public StypelogVO doUpdate(StypelogVO vo) throws Exception;

    public StypelogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(StypelogDBParam params) throws Exception;

}
