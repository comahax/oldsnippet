/**
 * auto-generated code
 * Sun May 22 15:19:11 GMT 2011
 */
package com.gmcc.pboss.control.sales.stockalmfloat;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.stockalmfloat.StockalmfloatDBParam;
import com.gmcc.pboss.business.sales.stockalmfloat.StockalmfloatVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Stockalmfloat </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public interface Stockalmfloat extends AbstractControl {
    public StockalmfloatVO doCreate(StockalmfloatVO vo) throws Exception;

    public void doRemoveByVO(StockalmfloatVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public StockalmfloatVO doUpdate(StockalmfloatVO vo) throws Exception;

    public StockalmfloatVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(StockalmfloatDBParam params) throws Exception;

}
