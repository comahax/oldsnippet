/**
 * auto-generated code
 * Fri Dec 07 14:13:24 CST 2012
 */
package com.gmcc.pboss.control.resource.simnoactinfofile;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.simnoactinfofile.SimnoactinfofileDBParam;
import com.gmcc.pboss.business.resource.simnoactinfofile.SimnoactinfofileVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Simnoactinfofile </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public interface Simnoactinfofile extends AbstractControl {
    public SimnoactinfofileVO doCreate(SimnoactinfofileVO vo) throws Exception;

    public void doRemoveByVO(SimnoactinfofileVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public SimnoactinfofileVO doUpdate(SimnoactinfofileVO vo) throws Exception;

    public SimnoactinfofileVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(SimnoactinfofileDBParam params) throws Exception;

}
