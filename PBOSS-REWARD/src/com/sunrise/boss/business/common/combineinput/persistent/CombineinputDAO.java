package com.sunrise.boss.business.common.combineinput.persistent;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

public class CombineinputDAO extends BaseDAO {
	public static String SQL_DICTITEM = "boss.common.combineinput.queryDictitemCase";
	public static String SQL_QUERYJOIN = "boss.common.combineinput.queryAcctJoinCase";
	
	public CombineinputDAO() {
		super(CombineinputVO.class);
	}
    
    public DataPackage queryDictitem(CombineinputListVO listVO, User user) throws Exception {
    	return queryByNamedSqlQuery(SQL_DICTITEM, listVO, QUERY_TYPE_DATA);
    }
	
    public DataPackage queryAcctJoin(CombineinputListVO listVO, User user) throws Exception {
    	return queryByNamedSqlQuery(SQL_QUERYJOIN, listVO, QUERY_TYPE_DATA);
    }
    public DataPackage queryByNamedSqlQuery(CombineinputListVO listVO,String sqlName,User user) throws Exception {
    	return queryByNamedSqlQuery(sqlName, listVO, QUERY_TYPE_DATA);
    }
}
