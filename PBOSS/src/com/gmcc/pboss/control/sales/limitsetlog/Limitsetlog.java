/**
 * auto-generated code
 * Thu Jul 08 10:32:29 CST 2010
 */
package com.gmcc.pboss.control.sales.limitsetlog;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.limitsetlog.LimitsetlogDBParam;
import com.gmcc.pboss.business.sales.limitsetlog.LimitsetlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Limitsetlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Limitsetlog extends AbstractControl {
    public LimitsetlogVO doCreate(LimitsetlogVO vo) throws Exception;

    public void doRemoveByVO(LimitsetlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public LimitsetlogVO doUpdate(LimitsetlogVO vo) throws Exception;

    public LimitsetlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(LimitsetlogDBParam params) throws Exception;

}
