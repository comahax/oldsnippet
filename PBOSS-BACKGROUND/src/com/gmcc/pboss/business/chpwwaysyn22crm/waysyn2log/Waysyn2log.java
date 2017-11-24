/**
 * auto-generated code
 * Thu Jun 09 15:03:21 CST 2011
 */
package com.gmcc.pboss.business.chpwwaysyn22crm.waysyn2log;

import java.io.Serializable;

import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Waysyn2log </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Waysyn2log extends AbstractControl {
    public Waysyn2logVO doCreate(Waysyn2logVO vo) throws Exception;

    public void doRemoveByVO(Waysyn2logVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public Waysyn2logVO doUpdate(Waysyn2logVO vo) throws Exception;

    public Waysyn2logVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(Waysyn2logDBParam params) throws Exception;

}
