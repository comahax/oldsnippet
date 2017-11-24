/**
* auto-generated code
* Sun Aug 15 11:34:09 CST 2010
*/
package com.sunrise.boss.business.cms.bbc.bbcreopnrange.persistent;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;

/**
 * <p>Title: BbcReopnrangeDAO</p>
 * <p>Description: Data Access Object for BbcReopnrangeVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class BbcReopnrangeDAO extends BaseDAO {

    /**
     * default constructor
     */
    public BbcReopnrangeDAO(){
        super(BbcReopnrangeVO.class);
    }
    
    public DataPackage getRangeByOpnid(BbcReopnrangeListVO params, String opnid, String resertype) throws Exception {
		params.getQueryConditions().put("opnid", opnid);
		params.getQueryConditions().put("resertype", resertype);
		return queryByNamedSqlQuery("mmopnrangeValidate", params);
	}
    
    public DataPackage getRangeByResertype(BbcReopnrangeListVO params, String resertype) throws Exception{
    	params.getQueryConditions().put("resertype", resertype);
    	return queryByNamedSqlQuery("mmopnrangeQuery", params);
    }
}
