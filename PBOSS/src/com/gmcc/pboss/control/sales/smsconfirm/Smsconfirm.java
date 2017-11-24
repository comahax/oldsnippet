/**
 * auto-generated code
 * Mon May 24 14:01:26 CST 2010
 */
package com.gmcc.pboss.control.sales.smsconfirm;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.smsconfirm.SmsconfirmDBParam;
import com.gmcc.pboss.business.sales.smsconfirm.SmsconfirmVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Smsconfirm </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author zsw
 * @version 1.0
 */
public interface Smsconfirm extends AbstractControl {
    public SmsconfirmVO doCreate(SmsconfirmVO vo) throws Exception;

    public void doRemoveByVO(SmsconfirmVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public SmsconfirmVO doUpdate(SmsconfirmVO vo) throws Exception;

    public SmsconfirmVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(SmsconfirmDBParam params) throws Exception;
    /**
     * 二次确认
     * @param pkItem
     * @throws Exception
     */
	public void doSecondConfirm(String[] pkItem) throws Exception;

}
