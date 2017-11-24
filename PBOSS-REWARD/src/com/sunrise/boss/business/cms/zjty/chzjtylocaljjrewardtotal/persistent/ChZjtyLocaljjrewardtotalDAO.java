/**
* auto-generated code
* Sat Mar 09 12:07:52 CST 2013
*/
package com.sunrise.boss.business.cms.zjty.chzjtylocaljjrewardtotal.persistent;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;

/**
 * <p>Title: ChZjtyLocaljjrewardtotalDAO</p>
 * <p>Description: Data Access Object for ChZjtyLocaljjrewardtotalVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ChZjtyLocaljjrewardtotalDAO extends BaseDAO {

    /**
     * default constructor
     */
    public ChZjtyLocaljjrewardtotalDAO(){
        super(ChZjtyLocaljjrewardtotalVO.class);
    }
    
    public DataPackage doQueryTotal(ChZjtyLocaljjrewardtotalListVO params)
        throws Exception {
    	DataPackage dp = new DataPackage();
		StringBuffer queryString = new StringBuffer();
		queryString.append("select cityid, nvl(sum(qqtxzfhcj), 0) qqtxzfhcj, nvl(sum(yffzqqtcj), 0) yffzqqtcj, " +
				"nvl(sum(dgddtkxscj), 0) dgddtkxscj, nvl(sum(szxtkxscj), 0) szxtkxscj, nvl(sum(czywcj), 0) czywcj, " +
				"nvl(sum(dzzdcj), 0) dzzdcj, nvl(sum(zhywcj), 0) zhywcj, nvl(sum(zzywcj), 0) zzywcj, " +
				"nvl(sum(dgddwlk), 0) dgddwlk, nvl(sum(jtkdkhcj), 0) jtkdkhcj, nvl(sum(sjywcj), 0) sjywcj, " +
				"nvl(sum(jtywcj), 0) jtywcj, nvl(sum(dsgsyxzd), 0) dsgsyxzd, nvl(sum(qqtffcjkj), 0) qqtffcjkj, " +
				"nvl(sum(total), 0) total from ch_zjty_localjjrewardtotal where 1 = 1 ");
		if (params.get_se_rewardreporttime() != null && !"".equals(params.get_se_rewardreporttime())) {
			queryString.append(" and rewardreporttime = '").append(params.get_se_rewardreporttime()).append("' ");
		}
		queryString.append(" group by cityid");
		
		Session session = SessionUtil.currentSession(getDbFlag());
		SQLQuery query = session.createSQLQuery(queryString.toString())
				.addScalar("cityid", Hibernate.STRING)
				.addScalar("qqtxzfhcj", Hibernate.DOUBLE)
				.addScalar("yffzqqtcj", Hibernate.DOUBLE)
				.addScalar("dgddtkxscj", Hibernate.DOUBLE)
				.addScalar("szxtkxscj", Hibernate.DOUBLE)
				.addScalar("czywcj", Hibernate.DOUBLE)
				.addScalar("dzzdcj", Hibernate.DOUBLE)
				.addScalar("zhywcj", Hibernate.DOUBLE)
				.addScalar("zzywcj", Hibernate.DOUBLE)
				.addScalar("dgddwlk", Hibernate.DOUBLE)
				.addScalar("jtkdkhcj", Hibernate.DOUBLE)
				.addScalar("sjywcj", Hibernate.DOUBLE)
				.addScalar("jtywcj", Hibernate.DOUBLE)
				.addScalar("dsgsyxzd", Hibernate.DOUBLE)
				.addScalar("qqtffcjkj", Hibernate.DOUBLE)
				.addScalar("total", Hibernate.DOUBLE);
		List list = query.list();
		List voList = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			Object[] obj = (Object[]) list.get(i);
			ChZjtyLocaljjrewardtotalVO vo = new ChZjtyLocaljjrewardtotalVO();
			vo.setRecid((long)(i+1));
			vo.setCityid(obj[0]==null?"":obj[0].toString());
			vo.setQqtxzfhcj(Double.parseDouble(obj[1].toString()));
			vo.setYffzqqtcj(Double.parseDouble(obj[2].toString()));
			vo.setDgddtkxscj(Double.parseDouble(obj[3].toString()));
			vo.setSzxtkxscj(Double.parseDouble(obj[4].toString()));
			vo.setCzywcj(Double.parseDouble(obj[5].toString()));
			vo.setDzzdcj(Double.parseDouble(obj[6].toString()));
			vo.setZhywcj(Double.parseDouble(obj[7].toString()));
			vo.setZzywcj(Double.parseDouble(obj[8].toString()));
			vo.setDgddwlk(Double.parseDouble(obj[9].toString()));
			vo.setJtkdkhcj(Double.parseDouble(obj[10].toString()));
			vo.setSjywcj(Double.parseDouble(obj[11].toString()));
			vo.setJtywcj(Double.parseDouble(obj[12].toString()));
			vo.setDsgsyxzd(Double.parseDouble(obj[13].toString()));
			vo.setQqtffcjkj(Double.parseDouble(obj[14].toString()));
			vo.setTotal(Double.parseDouble(obj[15].toString()));
			voList.add(vo);
		}
		dp.setDatas(voList);
		dp.setPageSize(1);
		dp.setPageNo(1);
		dp.setRowCount(1);
		return dp;
    }
}
