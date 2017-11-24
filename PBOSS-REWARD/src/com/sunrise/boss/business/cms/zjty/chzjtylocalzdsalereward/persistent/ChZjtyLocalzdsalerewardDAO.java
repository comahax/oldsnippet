/**
* auto-generated code
* Sat Mar 09 12:12:34 CST 2013
*/
package com.sunrise.boss.business.cms.zjty.chzjtylocalzdsalereward.persistent;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;

/**
 * <p>Title: ChZjtyLocalzdsalerewardDAO</p>
 * <p>Description: Data Access Object for ChZjtyLocalzdsalerewardVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ChZjtyLocalzdsalerewardDAO extends BaseDAO {

    /**
     * default constructor
     */
    public ChZjtyLocalzdsalerewardDAO(){
        super(ChZjtyLocalzdsalerewardVO.class);
    }
    
    public DataPackage doQueryTotal(ChZjtyLocalzdsalerewardListVO params)
        throws Exception {
    	DataPackage dp = new DataPackage();
		StringBuffer queryString = new StringBuffer();
		queryString.append("select cityid, nvl(sum(dzzdxlhyj), 0) dzzdxlhyj, nvl(sum(dzzdxllhy), 0) dzzdxllhy, " +
				"nvl(sum(dzzdxllj), 0) dzzdxllj, nvl(sum(dzzdxlhj), 0) dzzdxlhj, nvl(sum(ysrgdzzdxlhyj), 0) ysrgdzzdxlhyj, " +
				"nvl(sum(ysrgdzzdxllhy), 0) ysrgdzzdxllhy, nvl(sum(ysrgdzzdxllj), 0) ysrgdzzdxllj, " +
				"nvl(sum(ysrgdzzdxlhj), 0) ysrgdzzdxlhj, nvl(sum(dzzdcjhyj), 0) dzzdcjhyj, nvl(sum(dzzdcjlhy), 0) dzzdcjlhy, " +
				"nvl(sum(dzzdcjlj), 0) dzzdcjlj, nvl(sum(dzzdcjhj), 0) dzzdcjhj, nvl(sum(ysrgdzzdcjhyj), 0) ysrgdzzdcjhyj, " +
				"nvl(sum(ysrgdzzdcjlhy), 0) ysrgdzzdcjlhy, nvl(sum(ysrgdzzdcjlj), 0) ysrgdzzdcjlj, " +
				"nvl(sum(ysrgdzzdcjhj), 0) ysrgdzzdcjhj from ch_zjty_localzdsalereward where 1 = 1 ");
		if (params.get_se_rewardreporttime() != null && !"".equals(params.get_se_rewardreporttime())) {
			queryString.append(" and rewardreporttime = '").append(params.get_se_rewardreporttime()).append("' ");
		}
		queryString.append(" group by cityid");
		
		Session session = SessionUtil.currentSession(getDbFlag());
		SQLQuery query = session.createSQLQuery(queryString.toString())
				.addScalar("cityid", Hibernate.STRING)
				.addScalar("dzzdxlhyj", Hibernate.LONG)
				.addScalar("dzzdxllhy", Hibernate.LONG)
				.addScalar("dzzdxllj", Hibernate.LONG)
				.addScalar("dzzdxlhj", Hibernate.LONG)
				.addScalar("ysrgdzzdxlhyj", Hibernate.LONG)
				.addScalar("ysrgdzzdxllhy", Hibernate.LONG)
				.addScalar("ysrgdzzdxllj", Hibernate.LONG)
				.addScalar("ysrgdzzdxlhj", Hibernate.LONG)
				.addScalar("dzzdcjhyj", Hibernate.DOUBLE)
				.addScalar("dzzdcjlhy", Hibernate.DOUBLE)
				.addScalar("dzzdcjlj", Hibernate.DOUBLE)
				.addScalar("dzzdcjhj", Hibernate.DOUBLE)
				.addScalar("ysrgdzzdcjhyj", Hibernate.DOUBLE)
				.addScalar("ysrgdzzdcjlhy", Hibernate.DOUBLE)
				.addScalar("ysrgdzzdcjlj", Hibernate.DOUBLE)
				.addScalar("ysrgdzzdcjhj", Hibernate.DOUBLE);
		List list = query.list();
		List voList = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			Object[] obj = (Object[]) list.get(i);
			ChZjtyLocalzdsalerewardVO vo = new ChZjtyLocalzdsalerewardVO();
			vo.setRecid((long)(i+1));
			vo.setCityid(obj[0]==null?"":obj[0].toString());
			vo.setDzzdxlhyj(Long.parseLong(obj[1].toString()));
			vo.setDzzdxllhy(Long.parseLong(obj[2].toString()));
			vo.setDzzdxllj(Long.parseLong(obj[3].toString()));
			vo.setDzzdxlhj(Long.parseLong(obj[4].toString()));
			vo.setYsrgdzzdxlhyj(Long.parseLong(obj[5].toString()));
			vo.setYsrgdzzdxllhy(Long.parseLong(obj[6].toString()));
			vo.setYsrgdzzdxllj(Long.parseLong(obj[7].toString()));
			vo.setYsrgdzzdxlhj(Long.parseLong(obj[8].toString()));
			vo.setDzzdcjhyj(Double.parseDouble(obj[9].toString()));
			vo.setDzzdcjlhy(Double.parseDouble(obj[10].toString()));
			vo.setDzzdcjlj(Double.parseDouble(obj[11].toString()));
			vo.setDzzdcjhj(Double.parseDouble(obj[12].toString()));
			vo.setYsrgdzzdcjhyj(Double.parseDouble(obj[13].toString()));
			vo.setYsrgdzzdcjlhy(Double.parseDouble(obj[14].toString()));
			vo.setYsrgdzzdcjlj(Double.parseDouble(obj[15].toString()));
			vo.setYsrgdzzdcjhj(Double.parseDouble(obj[16].toString()));
			voList.add(vo);
		}
		dp.setDatas(voList);
		dp.setPageSize(1);
		dp.setPageNo(1);
		dp.setRowCount(1);
		return dp;
    }
}
