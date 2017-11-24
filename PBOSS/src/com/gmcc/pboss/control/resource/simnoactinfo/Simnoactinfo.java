/**
 * auto-generated code
 * Fri Dec 07 14:12:22 CST 2012
 */
package com.gmcc.pboss.control.resource.simnoactinfo;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.simnoactinfo.SimnoactinfoDBParam;
import com.gmcc.pboss.business.resource.simnoactinfo.SimnoactinfoVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Simnoactinfo </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public interface Simnoactinfo extends AbstractControl {
    public SimnoactinfoVO doCreate(SimnoactinfoVO vo) throws Exception;

    public void doRemoveByVO(SimnoactinfoVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public SimnoactinfoVO doUpdate(SimnoactinfoVO vo) throws Exception;

    public SimnoactinfoVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(SimnoactinfoDBParam params) throws Exception;

}
