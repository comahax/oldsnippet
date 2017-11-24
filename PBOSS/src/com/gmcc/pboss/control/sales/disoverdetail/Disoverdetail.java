/**
 * auto-generated code
 * Tue Nov 15 11:32:53 CST 2011
 */
package com.gmcc.pboss.control.sales.disoverdetail;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.disoverdetail.DisoverdetailDBParam;
import com.gmcc.pboss.business.sales.disoverdetail.DisoverdetailVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Disoverdetail </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Disoverdetail extends AbstractControl {
    public DisoverdetailVO doCreate(DisoverdetailVO vo) throws Exception;

    public void doRemoveByVO(DisoverdetailVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public DisoverdetailVO doUpdate(DisoverdetailVO vo) throws Exception;

    public DisoverdetailVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(DisoverdetailDBParam params) throws Exception;

}
