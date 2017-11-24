/**
 * auto-generated code
 * Fri Oct 23 15:23:36 CST 2009
 */
package com.gmcc.pboss.control.sales.noactinfo;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.noactinfo.NoactinfoDBParam;
import com.gmcc.pboss.business.sales.noactinfo.NoactinfoVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Noactinfo </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public interface Noactinfo extends AbstractControl {
    public NoactinfoVO doCreate(NoactinfoVO vo) throws Exception;

    public void doRemoveByVO(NoactinfoVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public NoactinfoVO doUpdate(NoactinfoVO vo) throws Exception;

    public NoactinfoVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(NoactinfoDBParam params) throws Exception;

}
