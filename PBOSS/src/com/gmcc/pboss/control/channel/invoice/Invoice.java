/**
 * auto-generated code
 * Fri Dec 30 09:40:47 CST 2011
 */
package com.gmcc.pboss.control.channel.invoice;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.invoice.InvoiceDBParam;
import com.gmcc.pboss.business.channel.invoice.InvoiceVO; 
import com.sunrise.jop.infrastructure.control.AbstractControl; 
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Invoice </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public interface Invoice extends AbstractControl {
    public InvoiceVO doCreate(InvoiceVO vo) throws Exception;

    public void doRemoveByVO(InvoiceVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public InvoiceVO doUpdate(InvoiceVO vo) throws Exception;

    public InvoiceVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(InvoiceDBParam params) throws Exception;
    
    public DataPackage doInvoiceList(InvoiceDBParam params,String countyid)throws Exception;
    

}
