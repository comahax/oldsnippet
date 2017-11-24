/**
 * auto-generated code
 * Fri Oct 02 10:44:18 CST 2009
 */
package com.gmcc.pboss.control.resource.discomres;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.discomres.DiscomresDBParam;
import com.gmcc.pboss.business.resource.discomres.DiscomresVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Discomres </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public interface Discomres extends AbstractControl {
    public DiscomresVO doCreate(DiscomresVO vo) throws Exception;

    public void doRemoveByVO(DiscomresVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public DiscomresVO doUpdate(DiscomresVO vo) throws Exception;

    public DiscomresVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(DiscomresDBParam params) throws Exception;
    public DataPackage doQueryDiscomresInfo(DiscomresDBParam params) throws Exception;

}
