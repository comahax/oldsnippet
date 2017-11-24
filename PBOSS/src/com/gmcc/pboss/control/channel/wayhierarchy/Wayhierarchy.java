/**
 * auto-generated code
 * Sat Nov 21 17:07:29 CST 2009
 */
package com.gmcc.pboss.control.channel.wayhierarchy;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.wayhierarchy.WayhierarchyDBParam;
import com.gmcc.pboss.business.channel.wayhierarchy.WayhierarchyVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Wayhierarchy </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public interface Wayhierarchy extends AbstractControl {
    public WayhierarchyVO doCreate(WayhierarchyVO vo) throws Exception;

    public void doRemoveByVO(WayhierarchyVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public WayhierarchyVO doUpdate(WayhierarchyVO vo) throws Exception;

    public WayhierarchyVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(WayhierarchyDBParam params) throws Exception;

}
