package com.sunrise.boss.business.fee.querybyno.dgeboxchglog.persistent;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;

public class DgEboxChgLogDAO extends BaseDAO{
	public DgEboxChgLogDAO() {
		super(DgEboxChgLogVO.class);
	}
	
    public DataPackage queryDgEboxChgLog(String queryname,DgEboxChgLogListVO listVO) throws Exception {
    	return queryByNamedSqlQuery(queryname, listVO);
    }
	
}
