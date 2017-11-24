/**
 * auto-generated code
 * Wed Apr 28 12:20:30 CST 2010
 */
package com.gmcc.pboss.control.sales.adpaysum;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.adpaysum.AdpaysumDBParam;
import com.gmcc.pboss.business.sales.adpaysum.AdpaysumVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Adpaysum </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author zsw
 * @version 1.0
 */
public interface Adpaysum extends AbstractControl {
    public AdpaysumVO doCreate(AdpaysumVO vo) throws Exception;

    public void doRemoveByVO(AdpaysumVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public AdpaysumVO doUpdate(AdpaysumVO vo) throws Exception;

    public AdpaysumVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(AdpaysumDBParam params) throws Exception;
    
    public void doConfirm(String sumid) throws Exception;
    
    public void doPay(String sumid) throws Exception;
    
}
