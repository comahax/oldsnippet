/**
* auto-generated code
* Tue Jan 05 15:32:41 CST 2010
*/
package com.sunrise.boss.business.cms.zjty.zjtydataquery.persistent;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;

/**
 * <p>Title: ZjtyDataqueryDAO</p>
 * <p>Description: Data Access Object for ZjtyDataqueryVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class ZjtyDataqueryDAO extends BaseDAO {

    /**
     * default constructor
     */
    public ZjtyDataqueryDAO(){
        super(ZjtyDataqueryVO.class);
    }
    
    public DataPackage queryBosssucc(ZjtyDataqueryListVO params) throws Exception{
    	params.set_pagesize("20");
    	return this.queryByNamedSqlQuery("zjtydataquery.bosssucc", params);
    }
    
    public DataPackage queryBossfail(ZjtyDataqueryListVO params) throws Exception{
    	params.set_pagesize("20");
    	return this.queryByNamedSqlQuery("zjtydataquery.bossfail", params);
    }
    
    public DataPackage queryBossjlsucc(ZjtyDataqueryListVO params) throws Exception{
    	params.set_pagesize("20");
    	return this.queryByNamedSqlQuery("zjtydataquery.bossjlsucc", params);
    }
    
    public DataPackage queryBossjlfail(ZjtyDataqueryListVO params) throws Exception{
    	params.set_pagesize("20");
    	return this.queryByNamedSqlQuery("zjtydataquery.bossjlfail", params);
    }
    
    public DataPackage querySalesucc(ZjtyDataqueryListVO params) throws Exception{
    	params.set_pagesize("20");
    	return this.queryByNamedSqlQuery("zjtydataquery.salesucc", params);
    }
    
    public DataPackage querySalefail(ZjtyDataqueryListVO params) throws Exception{
    	params.set_pagesize("20");
    	return this.queryByNamedSqlQuery("zjtydataquery.salefail", params);
    }
    
    public DataPackage queryTmnalsucc(ZjtyDataqueryListVO params) throws Exception{
    	params.set_pagesize("20");
    	return this.queryByNamedSqlQuery("zjtydataquery.tmnalsucc", params);
    }
    
    public DataPackage queryTmnalfail(ZjtyDataqueryListVO params) throws Exception{
    	params.set_pagesize("20");
    	return this.queryByNamedSqlQuery("zjtydataquery.tmnalfail", params);
    }
    
}
