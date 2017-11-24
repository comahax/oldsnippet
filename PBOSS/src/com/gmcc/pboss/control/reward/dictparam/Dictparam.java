/**
 * auto-generated code
 * Thu Mar 10 11:54:46 CST 2011
 */
package com.gmcc.pboss.control.reward.dictparam;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.dictparam.DictparamDBParam;
import com.gmcc.pboss.business.reward.dictparam.DictparamVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Dictparam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public interface Dictparam extends AbstractControl {
    public DictparamVO doCreate(DictparamVO vo) throws Exception;

    public void doRemoveByVO(DictparamVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public DictparamVO doUpdate(DictparamVO vo) throws Exception;

    public DictparamVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(DictparamDBParam params) throws Exception;

}
