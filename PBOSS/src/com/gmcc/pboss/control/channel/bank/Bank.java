/**
 * auto-generated code
 * Thu Sep 09 16:14:40 CST 2010
 */
package com.gmcc.pboss.control.channel.bank;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.bank.BankDBParam;
import com.gmcc.pboss.business.channel.bank.BankVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Bank </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public interface Bank extends AbstractControl {
    public BankVO doCreate(BankVO vo) throws Exception;

    public void doRemoveByVO(BankVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public BankVO doUpdate(BankVO vo) throws Exception;

    public BankVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(BankDBParam params) throws Exception;

}
