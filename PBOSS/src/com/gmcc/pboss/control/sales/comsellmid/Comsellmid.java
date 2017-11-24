/**
 * auto-generated code
 * Mon Nov 23 16:57:18 CST 2009
 */
package com.gmcc.pboss.control.sales.comsellmid;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.comsellmid.ComsellmidDBParam;
import com.gmcc.pboss.business.sales.comsellmid.ComsellmidVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Comsellmid </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public interface Comsellmid extends AbstractControl {
    public ComsellmidVO doCreate(ComsellmidVO vo) throws Exception;

    public void doRemoveByVO(ComsellmidVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ComsellmidVO doUpdate(ComsellmidVO vo) throws Exception;

    public ComsellmidVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ComsellmidDBParam params) throws Exception;

}
