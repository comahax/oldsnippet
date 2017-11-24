package com.sunrise.boss.business.fee.querybyno.eboxchgloghis.persistent;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;

public class EboxChgLogHisDAO extends BaseDAO{
	public EboxChgLogHisDAO() {
		super(EboxChgLogHisVO.class);
	}
	
    public DataPackage queryEboxChgLogHis(String queryname,EboxChgLogHisListVO listVO) throws Exception {
    	return queryByNamedSqlQuery(queryname, listVO);
    }
	
	
}
