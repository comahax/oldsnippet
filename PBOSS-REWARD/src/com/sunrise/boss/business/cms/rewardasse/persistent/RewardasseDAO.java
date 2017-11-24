/**
* auto-generated code
* Thu Jan 31 15:08:13 CST 2008
*/
package com.sunrise.boss.business.cms.rewardasse.persistent;

import com.sunrise.boss.business.cms.reward.rulerel.persistent.RulerelListVO;
import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.DataPackage;

/**
 * <p>Title: RewardasseDAO</p>
 * <p>Description: Data Access Object for RewardasseVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author xiangyin
 * @version 1.0
 */
public class RewardasseDAO extends BaseLogDAO {

    /**
     * default constructor
     */
    public RewardasseDAO(){
        super(RewardasseVO.class);
    }
    
    public DataPackage getSynAssegrade(RewardasseListVO params1) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("select  a.assemonth,b.calcmonth,a.rewardtype,a.wayid ,b.assegrade,a.memo ")
		.append(" from CH_PW_REWARDASSE a,CH_ADT_CREDITTOTAL b ")
		.append(" Where a.wayid=b.wayid and b.calcmonth="+params1.get_se_assemonth());
		
		params1.set_se_assemonth(null);
		params1.set_ne_rewardtype(null);
		
		return  queryBySql(sql.toString(), params1);
	}
}
