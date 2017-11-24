/**
* auto-generated code
* Fri May 03 16:45:00 CST 2013
*/
package com.sunrise.boss.business.cms.dktersalereward.persistent;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;

/**
 * <p>Title: DktersalerewardDAO</p>
 * <p>Description: Data Access Object for DktersalerewardVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class DktersalerewardDAO extends BaseDAO {

    /**
     * default constructor
     */
    public DktersalerewardDAO(){
        super(DktersalerewardVO.class);
    }
    
	public DataPackage doQueryRewardTotal(DktersalerewardListVO params)
	    throws Exception {
    	DataPackage dp = new DataPackage();
		StringBuffer queryString = new StringBuffer();
		queryString.append("select cityid, sum(nvl(salesuc, 0)) salesuc, " +
			"sum(nvl(examinesuc, 0)) examinesuc, sum(nvl(foundreward, 0)) foundreward, " +
			"sum(nvl(examinereward, 0)) examinereward from ch_pw_dktersalereward where 1 = 1 ");
		if (params.get_se_month() != null && !"".equals(params.get_se_month())) {
			queryString.append(" and month = '").append(params.get_se_month()).append("' ");
		}
		queryString.append(" group by cityid");
		
		Session session = SessionUtil.currentSession(getDbFlag());
		SQLQuery query = session.createSQLQuery(queryString.toString())
				.addScalar("cityid", Hibernate.STRING)
				.addScalar("salesuc", Hibernate.LONG)
				.addScalar("examinesuc", Hibernate.LONG)
				.addScalar("foundreward", Hibernate.DOUBLE)
				.addScalar("examinereward", Hibernate.DOUBLE);
		List list = query.list();
		
		List voList = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			Object[] obj = (Object[]) list.get(i);
			DktersalerewardVO vo = new DktersalerewardVO();
			vo.setRecid((long)(i+1));
			vo.setCityid(Short.parseShort(obj[0].toString()));
			vo.setSalesuc(Long.parseLong(obj[1].toString()));
			vo.setExaminesuc(Long.parseLong(obj[2].toString()));
			vo.setFoundreward(Double.parseDouble(obj[3].toString()));
			vo.setExaminereward(Double.parseDouble(obj[4].toString()));
			voList.add(vo);
		}
		dp.setDatas(voList);
		dp.setPageSize(1);
		dp.setPageNo(1);
		dp.setRowCount(1);
		return dp;
	}
}
