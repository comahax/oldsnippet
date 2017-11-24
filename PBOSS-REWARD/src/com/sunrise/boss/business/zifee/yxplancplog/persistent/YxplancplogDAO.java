/**
* auto-generated code
* Sat Jan 13 18:51:43 CST 2007
*/
package com.sunrise.boss.business.zifee.yxplancplog.persistent;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: YxplancplogDAO</p>
 * <p>Description: Data Access Object for YxplancplogVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Cai Jianhui
 * @version 1.0
 */
public class YxplancplogDAO extends BaseDAO {

    /**
     * default constructor
     */
    public YxplancplogDAO(){
        super(YxplancplogVO.class);
    }
    public DataPackage query(YxplancplogListVO listvo,User user) throws Exception {
		
			
    	listvo.getQueryConditions().put("AREACODE",user.getCityid());// ÉèÖÃµØÊÐ
		
			DataPackage dp2 = queryByNamedSqlQuery("cms.getyxplancplog",listvo, QUERY_TYPE_ALL);
			if (dp2.getDatas().size() > 0)
				return dp2;
			return null;
    }
		
	
}
