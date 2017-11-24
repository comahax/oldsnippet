/**
 * auto-generated code
 * Fri Jul 09 09:11:20 CST 2010
 */
package com.gmcc.pboss.control.resource.resalarminfo;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.resalarminfo.ResalarminfoDBParam;
import com.gmcc.pboss.business.resource.resalarminfo.ResalarminfoVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Resalarminfo </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public interface Resalarminfo extends AbstractControl {
    public ResalarminfoVO doCreate(ResalarminfoVO vo) throws Exception;

    public void doRemoveByVO(ResalarminfoVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ResalarminfoVO doUpdate(ResalarminfoVO vo) throws Exception;

    public ResalarminfoVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ResalarminfoDBParam params) throws Exception;

}
