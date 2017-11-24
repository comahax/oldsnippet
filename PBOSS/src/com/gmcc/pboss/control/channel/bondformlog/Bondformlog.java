/**
 * auto-generated code
 * Wed Jan 04 10:07:20 CST 2012
 */
package com.gmcc.pboss.control.channel.bondformlog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.bondformlog.BondformlogDBParam;
import com.gmcc.pboss.business.channel.bondformlog.BondformlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Bondformlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public interface Bondformlog extends AbstractControl {
    public BondformlogVO doCreate(BondformlogVO vo) throws Exception;

    public void doRemoveByVO(BondformlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public BondformlogVO doUpdate(BondformlogVO vo) throws Exception;

    public BondformlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(BondformlogDBParam params) throws Exception;
    
    public DataPackage doBondformlogList(BondformlogDBParam params)throws Exception;
    
    public DataPackage doBondformlogListForExcel(BondformlogDBParam params)throws Exception;

}
