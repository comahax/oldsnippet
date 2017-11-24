package com.sunrise.boss.business.cms.stdrewardbs.persistent;

import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.DataPackage;

public class V_StdrewardbsDAO extends BaseLogDAO {

    public V_StdrewardbsDAO() {
		super( V_StdrewardbsVO.class);
	}

    
    public DataPackage unionQuery(StdrewardbsListVO params){
		try {
			return this.queryByNamedSqlQuery("boss.cms.stdrewardbs.unionQuery", params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    	
    }
}