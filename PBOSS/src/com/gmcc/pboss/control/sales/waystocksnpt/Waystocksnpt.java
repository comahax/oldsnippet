/**
 * auto-generated code
 * Wed Sep 08 16:30:03 CST 2010
 */
package com.gmcc.pboss.control.sales.waystocksnpt;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.waystocksnpt.WaystocksnptDBParam;
import com.gmcc.pboss.business.sales.waystocksnpt.WaystocksnptVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Waystocksnpt </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public interface Waystocksnpt extends AbstractControl {
    public WaystocksnptVO doCreate(WaystocksnptVO vo) throws Exception;

    public void doRemoveByVO(WaystocksnptVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public WaystocksnptVO doUpdate(WaystocksnptVO vo) throws Exception;

    public WaystocksnptVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(WaystocksnptDBParam params) throws Exception;
    
    public DataPackage doQuerySalesSmplist(WaystocksnptDBParam params) throws Exception;
    
    // 网点套卡销售量统计批量导出
    public DataPackage doQuerySalesSmplistBatchExp(WaystocksnptDBParam params) throws Exception;
    
    public DataPackage doQuerySalesCardlist(WaystocksnptDBParam params) throws Exception;
    
    // 网点充值卡销售量统计批量导出
    public DataPackage doQuerySalesCardlistBatchExp(WaystocksnptDBParam params) throws Exception;
    
    public DataPackage doQueryStockSmpRecord(WaystocksnptDBParam params) throws Exception;
    
    public DataPackage doQueryStockCardRecord(WaystocksnptDBParam params) throws Exception;
    
    public DataPackage doQuerySalesSmpRecord(WaystocksnptDBParam params) throws Exception;
    
    public DataPackage doQuerySalesCardRecord(WaystocksnptDBParam params) throws Exception;
    
    public DataPackage doQueryActiveSmpList(WaystocksnptDBParam params) throws Exception;
    
    // 网点套卡激活统计批量导出
    public DataPackage doQueryActiveSmpListBatchExp(WaystocksnptDBParam params) throws Exception;
    
    public DataPackage doQueryActiveSmpList2(WaystocksnptDBParam params) throws Exception;
    
    public DataPackage doQueryActiveSmpRecord(WaystocksnptDBParam params) throws Exception;
    
    public DataPackage doQuerySaleStatistic(WaystocksnptDBParam params) throws Exception;
    
    public DataPackage doQuerySaleRecord(WaystocksnptDBParam params) throws Exception;
    
    public DataPackage doQueryUsedStatistic(WaystocksnptDBParam params) throws Exception;
    
    public DataPackage doQueryUsedRecord(WaystocksnptDBParam params) throws Exception;
}
