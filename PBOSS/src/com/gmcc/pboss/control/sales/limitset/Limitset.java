/**
 * auto-generated code
 * Thu Jul 08 10:27:54 CST 2010
 */
package com.gmcc.pboss.control.sales.limitset;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.limitset.LimitsetDBParam;
import com.gmcc.pboss.business.sales.limitset.LimitsetVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Limitset </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Limitset extends AbstractControl {
    public LimitsetVO doCreate(LimitsetVO vo) throws Exception;

    public void doRemoveByVO(LimitsetVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public LimitsetVO doUpdate(LimitsetVO vo) throws Exception;

    public LimitsetVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(LimitsetDBParam params) throws Exception;

}
