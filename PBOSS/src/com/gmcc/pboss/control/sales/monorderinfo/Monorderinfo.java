/**
 * auto-generated code
 * Tue Oct 13 09:40:57 CST 2009
 */
package com.gmcc.pboss.control.sales.monorderinfo;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.monorderinfo.MonorderinfoDBParam;
import com.gmcc.pboss.business.sales.monorderinfo.MonorderinfoVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Monorderinfo </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Monorderinfo extends AbstractControl {
    public MonorderinfoVO doCreate(MonorderinfoVO vo) throws Exception;

    public void doRemoveByVO(MonorderinfoVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public MonorderinfoVO doUpdate(MonorderinfoVO vo) throws Exception;

    public MonorderinfoVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(MonorderinfoDBParam params) throws Exception;

}
