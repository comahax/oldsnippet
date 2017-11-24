/**
* auto-generated code
* Sat Mar 09 12:02:30 CST 2013
*/
package com.sunrise.boss.business.cms.zjty.chzjtylocalgdrewardtotal.persistent;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;

/**
 * <p>Title: ChZjtyLocalgdrewardtotalDAO</p>
 * <p>Description: Data Access Object for ChZjtyLocalgdrewardtotalVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ChZjtyLocalgdrewardtotalDAO extends BaseDAO {

    /**
     * default constructor
     */
    public ChZjtyLocalgdrewardtotalDAO(){
        super(ChZjtyLocalgdrewardtotalVO.class);
    }
    
    public DataPackage doQueryTotal(ChZjtyLocalgdrewardtotalListVO params)
        throws Exception {
    	DataPackage dp = new DataPackage();
		StringBuffer queryString = new StringBuffer();
		queryString.append("select cityid, nvl(sum(petotal), 0) petotal, " +
				"nvl(sum(gdreward), 0) gdreward, nvl(sum(mgmenoykc), 0) mgmenoykc, " +
				"nvl(sum(total), 0) total from ch_zjty_localgdrewardtotal where 1 = 1 ");
		if (params.get_se_rewardreporttime() != null && !"".equals(params.get_se_rewardreporttime())) {
			queryString.append(" and rewardreporttime = '").append(params.get_se_rewardreporttime()).append("' ");
		}
		queryString.append(" group by cityid");
		
		Session session = SessionUtil.currentSession(getDbFlag());
		SQLQuery query = session.createSQLQuery(queryString.toString())
				.addScalar("cityid", Hibernate.STRING)
				.addScalar("petotal", Hibernate.LONG)
				.addScalar("gdreward", Hibernate.DOUBLE)
				.addScalar("mgmenoykc", Hibernate.DOUBLE)
				.addScalar("total", Hibernate.DOUBLE);
		List list = query.list();
		List voList = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			Object[] obj = (Object[]) list.get(i);
			ChZjtyLocalgdrewardtotalVO vo = new ChZjtyLocalgdrewardtotalVO();
			vo.setRecid((long)(i+1));
			vo.setCityid(obj[0]==null?"":obj[0].toString());
			vo.setPetotal(Long.parseLong(obj[1].toString()));
			vo.setGdreward(Double.parseDouble(obj[2].toString()));
			vo.setMgmenoykc(Double.parseDouble(obj[3].toString()));
			vo.setTotal(Double.parseDouble(obj[4].toString()));
			voList.add(vo);
		}
		dp.setDatas(voList);
		dp.setPageSize(1);
		dp.setPageNo(1);
		dp.setRowCount(1);
		return dp;
    }
}
