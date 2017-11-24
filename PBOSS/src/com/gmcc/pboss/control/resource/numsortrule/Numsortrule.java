/**
 * auto-generated code
 * Sat Sep 05 17:12:40 CST 2009
 */
package com.gmcc.pboss.control.resource.numsortrule;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.numsortrule.NumsortruleDBParam;
import com.gmcc.pboss.business.resource.numsortrule.NumsortruleVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Numsortrule </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public interface Numsortrule extends AbstractControl {
    public NumsortruleVO doCreate(NumsortruleVO vo) throws Exception;

    public void doRemoveByVO(NumsortruleVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public NumsortruleVO doUpdate(NumsortruleVO vo) throws Exception;

    public NumsortruleVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(NumsortruleDBParam params) throws Exception;

}
