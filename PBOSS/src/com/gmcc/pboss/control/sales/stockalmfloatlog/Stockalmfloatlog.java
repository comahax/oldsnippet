/**
 * auto-generated code
 * Sun May 22 15:20:29 GMT 2011
 */
package com.gmcc.pboss.control.sales.stockalmfloatlog;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.stockalmfloatlog.StockalmfloatlogDBParam;
import com.gmcc.pboss.business.sales.stockalmfloatlog.StockalmfloatlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Stockalmfloatlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public interface Stockalmfloatlog extends AbstractControl {
    public StockalmfloatlogVO doCreate(StockalmfloatlogVO vo) throws Exception;

    public void doRemoveByVO(StockalmfloatlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public StockalmfloatlogVO doUpdate(StockalmfloatlogVO vo) throws Exception;

    public StockalmfloatlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(StockalmfloatlogDBParam params) throws Exception;

}
