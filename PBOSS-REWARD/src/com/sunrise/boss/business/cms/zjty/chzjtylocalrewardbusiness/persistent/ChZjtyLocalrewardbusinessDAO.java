/**
* auto-generated code
* Sat Mar 09 12:10:59 CST 2013
*/
package com.sunrise.boss.business.cms.zjty.chzjtylocalrewardbusiness.persistent;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;

/**
 * <p>Title: ChZjtyLocalrewardbusinessDAO</p>
 * <p>Description: Data Access Object for ChZjtyLocalrewardbusinessVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ChZjtyLocalrewardbusinessDAO extends BaseDAO {

    /**
     * default constructor
     */
    public ChZjtyLocalrewardbusinessDAO(){
        super(ChZjtyLocalrewardbusinessVO.class);
    }
    
    public DataPackage doQueryTotal(ChZjtyLocalrewardbusinessListVO params)
        throws Exception {
    	DataPackage dp = new DataPackage();
		StringBuffer queryString = new StringBuffer();
		queryString.append("select cityid, nvl(sum(qqtxzfh), 0) qqtxzfh, nvl(sum(yffzqqt), 0) yffzqqt, " +
				"nvl(sum(dgddtkxs), 0) dgddtkxs, nvl(sum(szxtkxs), 0) szxtkxs, nvl(sum(czyw), 0) czyw, " +
				"nvl(sum(dzzd), 0) dzzd, nvl(sum(zhyw), 0) zhyw, nvl(sum(zzyw), 0) zzyw, " +
				"nvl(sum(dgddwlk), 0) dgddwlk, nvl(sum(jtkdkh), 0) jtkdkh, nvl(sum(sjyw), 0) sjyw, " +
				"nvl(sum(jtyw), 0) jtyw, nvl(sum(dsgsyxzdlyw), 0) dsgsyxzdlyw, nvl(sum(total), 0) total " +
				"from ch_zjty_localrewardbusiness where 1 = 1 ");
		if (params.get_se_rewardreporttime() != null && !"".equals(params.get_se_rewardreporttime())) {
			queryString.append(" and rewardreporttime = '").append(params.get_se_rewardreporttime()).append("' ");
		}
		queryString.append(" group by cityid");
		
		Session session = SessionUtil.currentSession(getDbFlag());
		SQLQuery query = session.createSQLQuery(queryString.toString())
				.addScalar("cityid", Hibernate.STRING)
				.addScalar("qqtxzfh", Hibernate.DOUBLE)
				.addScalar("yffzqqt", Hibernate.DOUBLE)
				.addScalar("dgddtkxs", Hibernate.DOUBLE)
				.addScalar("szxtkxs", Hibernate.DOUBLE)
				.addScalar("czyw", Hibernate.DOUBLE)
				.addScalar("dzzd", Hibernate.DOUBLE)
				.addScalar("zhyw", Hibernate.DOUBLE)
				.addScalar("zzyw", Hibernate.DOUBLE)
				.addScalar("dgddwlk", Hibernate.DOUBLE)
				.addScalar("jtkdkh", Hibernate.DOUBLE)
				.addScalar("sjyw", Hibernate.DOUBLE)
				.addScalar("jtyw", Hibernate.DOUBLE)
				.addScalar("dsgsyxzdlyw", Hibernate.DOUBLE)
				.addScalar("total", Hibernate.DOUBLE);
		List list = query.list();
		List voList = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			Object[] obj = (Object[]) list.get(i);
			ChZjtyLocalrewardbusinessVO vo = new ChZjtyLocalrewardbusinessVO();
			vo.setRecid((long)(i+1));
			vo.setCityid(obj[0]==null?"":obj[0].toString());
			vo.setQqtxzfh(Double.parseDouble(obj[1].toString()));
			vo.setYffzqqt(Double.parseDouble(obj[2].toString()));
			vo.setDgddtkxs(Double.parseDouble(obj[3].toString()));
			vo.setSzxtkxs(Double.parseDouble(obj[4].toString()));
			vo.setCzyw(Double.parseDouble(obj[5].toString()));
			vo.setDzzd(Double.parseDouble(obj[6].toString()));
			vo.setZhyw(Double.parseDouble(obj[7].toString()));
			vo.setZzyw(Double.parseDouble(obj[8].toString()));
			vo.setDgddwlk(Double.parseDouble(obj[9].toString()));
			vo.setJtkdkh(Double.parseDouble(obj[10].toString()));
			vo.setSjyw(Double.parseDouble(obj[11].toString()));
			vo.setJtyw(Double.parseDouble(obj[12].toString()));
			vo.setDsgsyxzdlyw(Double.parseDouble(obj[13].toString()));
			vo.setTotal(Double.parseDouble(obj[14].toString()));
			voList.add(vo);
		}
		dp.setDatas(voList);
		dp.setPageSize(1);
		dp.setPageNo(1);
		dp.setRowCount(1);
		return dp;
    }
}
