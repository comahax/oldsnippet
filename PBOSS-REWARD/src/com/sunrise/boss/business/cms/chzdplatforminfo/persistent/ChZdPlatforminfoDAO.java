/**
* auto-generated code
* Sat May 11 16:40:18 CST 2013
*/
package com.sunrise.boss.business.cms.chzdplatforminfo.persistent;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;

/**
 * <p>Title: ChZdPlatforminfoDAO</p>
 * <p>Description: Data Access Object for ChZdPlatforminfoVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class ChZdPlatforminfoDAO extends BaseDAO {

    /**
     * default constructor
     */
    public ChZdPlatforminfoDAO(){
        super(ChZdPlatforminfoVO.class);
    }
    
    public DataPackage queryforzdplatform(ChZdPlatforminfoListVO params) throws Exception {
    	Session session = SessionUtil.currentSession(this.getDbFlag());
		String sql="select zd_platform as zdplatform from ch_zd_platforminfo group by zd_platform order by zd_platform";
		SQLQuery query = session.createSQLQuery(sql);
		query.addScalar("zdplatform", Hibernate.STRING);
		List list = query.list();
    	DataPackage dp = new DataPackage();
    	dp.setDatas(list);
    	dp.setRowCount(list.size());
    	return dp;
	}
    
    public DataPackage queryforproducttype(ChZdPlatforminfoListVO params) throws Exception {
    	Session session = SessionUtil.currentSession(this.getDbFlag());
		String sql="select producttype from ch_zd_platforminfo group by producttype order by producttype";
		SQLQuery query = session.createSQLQuery(sql);
		query.addScalar("producttype", Hibernate.STRING);
		List list = query.list();
    	DataPackage dp = new DataPackage();
    	dp.setDatas(list);
    	dp.setRowCount(list.size());
    	return dp;
	}
    
//    public DataPackage queryforproducttype(ChZdPlatforminfoListVO params) throws Exception {
//		StringBuffer sql = new StringBuffer();
//		
//		sql.append(" Select '' SEQ,'' PRODUCTID,ProductTYPE PRODUCTTYPE,'' ZDPLATFORM,'' SALEPRICE,'' STARTTIME,'' ENDTIME,'' BATCHNO from CH_ZD_PLATFORMINFO group by ProductTYPE order by ProductTYPE ");
//		
//		return  queryBySql(sql.toString(), params);
//	}
}
