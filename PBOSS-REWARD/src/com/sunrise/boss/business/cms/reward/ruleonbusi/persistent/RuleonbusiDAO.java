/**
* auto-generated code
* Fri Apr 18 17:02:15 CST 2008
*/
package com.sunrise.boss.business.cms.reward.ruleonbusi.persistent;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;

/**
 * <p>Title: RuleonbusiDAO</p>
 * <p>Description: Data Access Object for RuleonbusiVO</p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: SUNRISE Tech Ltd.</p>
 * @author Zhang Fengchao
 * @version 1.0
 */
public class RuleonbusiDAO extends BaseDAO {

    /**
     * default constructor
     */
    public RuleonbusiDAO(){
        super(RuleonbusiVO.class);
    }
    
    
    public DataPackage ruleonbusiQuery(RuleonbusiListVO listvo) throws Exception {
		String querystepid = listvo.get_sk_name();
		listvo.set_sk_name(null);

			listvo.getQueryConditions().put("name", "%"+querystepid+"%");

		return queryByNamedSqlQuery("ruleonbusi.query", listvo);
	}
}
