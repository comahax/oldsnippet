/**
 * auto-generated code
 * Wed Oct 14 17:29:02 CST 2009
 */
package com.gmcc.pboss.business.sales.disform;

import com.gmcc.pboss.business.sales.disformprint.DisformprintDBParam;
import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: DisformDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class DisformDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public DisformDAO(){
        super(DisformVO.class);
    }
    
    /*
     * 获取配送单详细信息
     */
    public DataPackage getDisform4Print(DisformprintDBParam params) throws Exception{
    	DataPackage dp = null;    	
    	dp = this.queryByNamedSqlQuery("com.gmcc.pboss.business.sales.disformprint.getDisform4Print", params);
    	return dp;
    }
}
