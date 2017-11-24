/**
* auto-generated code
* Wed Dec 24 15:55:56 CST 2008
*/
package com.sunrise.boss.business.cms.zjty.zjtyrewarddetail.persistent;

import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.DataPackage;

/**
 * <p>Title: ChZjtyRewarddetailDAO</p>
 * <p>Description: Data Access Object for ChZjtyRewarddetailVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class ZjtyRewarddetailDAO extends BaseLogDAO {

    /**
     * default constructor
     */
    public ZjtyRewarddetailDAO(){
        super(ZjtyRewarddetailVO.class);
    }
    
    public DataPackage querybyType(ZjtyRewarddetailListVO params) throws Exception{
    	return this.queryByNamedSqlQuery("zjtyrewarddetailQuery", params);
    }
}
