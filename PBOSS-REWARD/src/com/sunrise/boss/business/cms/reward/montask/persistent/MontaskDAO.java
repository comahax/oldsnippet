/**
* auto-generated code
* Thu Aug 20 16:16:59 CST 2009
*/
package com.sunrise.boss.business.cms.reward.montask.persistent;

import java.util.HashMap;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;

/**
 * <p>Title: MontaskDAO</p>
 * <p>Description: Data Access Object for MontaskVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class MontaskDAO extends BaseDAO {

    /**
     * default constructor
     */
    public MontaskDAO(){
        super(MontaskVO.class);
    }
    
    public DataPackage queryTaskid(MontaskListVO params)
	throws Exception {
    	return queryByNamedSqlQuery("queryMonTaskid", params);
    }
    
    public DataPackage queryTaskid2(MontaskListVO params, String value, String value0)
	throws Exception {
    	params = new MontaskListVO();
    	HashMap map = new HashMap();
    	map.put("validbillcyc", value);
    	map.put("validbillcyc00", value0);
    	params.setQueryConditions(map);
    	return queryByNamedSqlQuery("queryMonTaskid", params);
    }
}
