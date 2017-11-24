/**
 * auto-generated code
 * Wed Apr 28 13:14:56 CST 2010
 */
package com.gmcc.pboss.control.sales.adpaydet;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.adpaydet.AdpaydetDBParam;
import com.gmcc.pboss.business.sales.adpaydet.AdpaydetVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Adpaydet </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author zsw
 * @version 1.0
 */
public interface Adpaydet extends AbstractControl {
    public AdpaydetVO doCreate(AdpaydetVO vo) throws Exception;

    public void doRemoveByVO(AdpaydetVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public AdpaydetVO doUpdate(AdpaydetVO vo) throws Exception;

    public AdpaydetVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(AdpaydetDBParam params) throws Exception;

}
