/**
 * auto-generated code
 * Wed Sep 08 16:30:03 CST 2010
 */
package com.gmcc.pboss.business.sales.waystocksnpt;

import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: WaystocksnptDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class RWaystocksnptDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public RWaystocksnptDAO(){
        super(RWaystocksnptVO.class);
    }
    
    public DataPackage queryStockSmpRecord(WaystocksnptDBParam params) throws Exception{
    	return queryByNamedSqlQuery("queryWaystockSmprecord", params);
    }
    
    public DataPackage queryStockCardRecord(WaystocksnptDBParam params) throws Exception{
    	return queryByNamedSqlQuery("queryWaystockCardrecord", params);
    }
    
    public DataPackage querySaleSmpRecord(WaystocksnptDBParam params) throws Exception{
    	return queryByNamedSqlQuery("querySalessmprecord", params);
    }
    
    public DataPackage querySaleCardRecord(WaystocksnptDBParam params) throws Exception{
    	return queryByNamedSqlQuery("querySalescardrecord", params);
    }
    
    public DataPackage queryActiveSmpRecord(WaystocksnptDBParam params) throws Exception{
    	return queryByNamedSqlQuery("queryActivesmprecord", params);
    }
    
    /**
     * 网点空白SIM卡销售量明细
     * @param params
     * @return
     * @throws Exception
     */
    public DataPackage querySaleRecord(WaystocksnptDBParam params) throws Exception{
    	return queryByNamedSqlQuery("querySaleRecord", params);
    }
    
    /**
     * 网点空白SIM卡使用量明细
     * @param params
     * @return
     * @throws Exception
     */
    public DataPackage queryUsedRecord(WaystocksnptDBParam params) throws Exception{
    	return queryByNamedSqlQuery("queryUsedRecord", params);
    }
}
