package com.sunrise.boss.business.fee.persistent.eboxchglog;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;

public class EboxChgLogDAO extends BaseDAO{
	public EboxChgLogDAO() {
		super(EboxChgLogVO.class);
	}
	
    public DataPackage queryEboxchglog(String queryname,EboxChgLogListVO listVO) throws Exception {
    	return queryByNamedSqlQuery(queryname, listVO);
    }
	
	
	
}
