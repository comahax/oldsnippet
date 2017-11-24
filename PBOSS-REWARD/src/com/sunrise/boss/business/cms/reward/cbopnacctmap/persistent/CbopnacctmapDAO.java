/**
* auto-generated code
* Mon Sep 22 09:01:03 CST 2008
*/
package com.sunrise.boss.business.cms.reward.cbopnacctmap.persistent;

import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.DataPackage;

/**
 * <p>Title: CbopnacctmapDAO</p>
 * <p>Description: Data Access Object for CbopnacctmapVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class CbopnacctmapDAO extends BaseLogDAO {

    /**
     * default constructor
     */
    public CbopnacctmapDAO(){
        super(CbopnacctmapVO.class);
    }
    
    public DataPackage doQuery(CbopnacctmapListVO params) throws Exception{
    	return  queryByNamedSqlQuery("cms.reward.mapQuery2", params);
    	//return this.queryByNamedSqlQuery("cms.reward.mapQuery", params);
    }
}
