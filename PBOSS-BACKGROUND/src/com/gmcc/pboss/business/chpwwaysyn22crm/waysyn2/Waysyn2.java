/**
 * auto-generated code
 * Wed Jun 08 16:23:24 CST 2011
 */
package com.gmcc.pboss.business.chpwwaysyn22crm.waysyn2;

import java.io.Serializable;

import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Waysyn2 </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Waysyn2 extends AbstractControl {
    public Waysyn2VO doCreate(Waysyn2VO vo) throws Exception;

    public void doRemoveByVO(Waysyn2VO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public Waysyn2VO doUpdate(Waysyn2VO vo) throws Exception;

    public Waysyn2VO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(Waysyn2DBParam params) throws Exception;
    
    public void doProcess(String cityid, int batch_size) throws Exception;

}
