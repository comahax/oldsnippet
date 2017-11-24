/**
* auto-generated code
* Wed Sep 04 21:16:54 CST 2013
*/
package com.sunrise.boss.business.cms.provagent.vchpdrprewardrecord.persistent;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;

/**
 * <p>Title: ChPdRprewardrecordDAO</p>
 * <p>Description: Data Access Object for ChPdRprewardrecordVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class VChPdRprewardrecordDAO extends BaseDAO {

    /**
     * default constructor
     */
    public VChPdRprewardrecordDAO(){
        super(VChPdRprewardrecordVO.class);
    }
    
    public DataPackage query(Object params) throws Exception {    	
    	return queryByNamedSqlQuery("boss.business.cms.provagent.rprewardrecord", params);
    }
}
