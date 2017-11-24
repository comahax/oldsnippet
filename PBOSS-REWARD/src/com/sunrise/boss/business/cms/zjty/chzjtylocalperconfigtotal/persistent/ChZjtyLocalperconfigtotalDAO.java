/**
* auto-generated code
* Sat Mar 09 12:10:11 CST 2013
*/
package com.sunrise.boss.business.cms.zjty.chzjtylocalperconfigtotal.persistent;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;

/**
 * <p>Title: ChZjtyLocalperconfigtotalDAO</p>
 * <p>Description: Data Access Object for ChZjtyLocalperconfigtotalVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ChZjtyLocalperconfigtotalDAO extends BaseDAO {

    /**
     * default constructor
     */
    public ChZjtyLocalperconfigtotalDAO(){
        super(ChZjtyLocalperconfigtotalVO.class);
    }
    
    public DataPackage doQueryTotal(ChZjtyLocalperconfigtotalListVO params)
        throws Exception {
    	DataPackage dp = new DataPackage();
		StringBuffer queryString = new StringBuffer();
		queryString.append("select cityid, nvl(sum(total), 0) total from ch_zjty_localperconfigtotal where 1 = 1 ");
		if (params.get_se_rewardreporttime() != null && !"".equals(params.get_se_rewardreporttime())) {
			queryString.append(" and rewardreporttime = '").append(params.get_se_rewardreporttime()).append("' ");
		}
		queryString.append(" group by cityid");
		
		Session session = SessionUtil.currentSession(getDbFlag());
		SQLQuery query = session.createSQLQuery(queryString.toString())
				.addScalar("cityid", Hibernate.STRING)
				.addScalar("total", Hibernate.LONG);
		List list = query.list();
		List voList = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			Object[] obj = (Object[]) list.get(i);
			ChZjtyLocalperconfigtotalVO vo = new ChZjtyLocalperconfigtotalVO();
			vo.setRecid((long)(i+1));
			vo.setCityid(obj[0]==null?"":obj[0].toString());
			vo.setTotal(Long.parseLong(obj[1].toString()));
			voList.add(vo);
		}
		dp.setDatas(voList);
		dp.setPageSize(1);
		dp.setPageNo(1);
		dp.setRowCount(1);
		return dp;
    }
}
