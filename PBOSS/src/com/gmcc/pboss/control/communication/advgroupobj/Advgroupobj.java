/**
 * auto-generated code
 * Tue Sep 29 10:22:17 CST 2009
 */
package com.gmcc.pboss.control.communication.advgroupobj;

import java.io.Serializable;

import com.gmcc.pboss.business.communication.advgroupobj.AdvgroupobjDBParam;
import com.gmcc.pboss.business.communication.advgroupobj.AdvgroupobjVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Advgroupobj </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Advgroupobj extends AbstractControl {
    public AdvgroupobjVO doCreate(AdvgroupobjVO vo) throws Exception;

    public void doRemoveByVO(AdvgroupobjVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public AdvgroupobjVO doUpdate(AdvgroupobjVO vo) throws Exception;

    public AdvgroupobjVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(AdvgroupobjDBParam params) throws Exception;

}
