package com.gmcc.pboss.business.cms.examine.exmnstddetail.persistent;


import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.infrastructure.db.hibernate3.Hibernate3SessionManager;

/**
 * <p>Title: ExmnstddetailDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExmnstddetailDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public ExmnstddetailDAO(){
        super(ExmnstddetailVO.class);
    }
    /**
     * 按“渠道代码[WAYID]”、“考核标识[EXMNID]”、“考核周期[EXMNPERIOD]
     * 分组统计“指标得分明细[CH_KH_EXMNSTDDETAIL]”的“考核分数[EXMNMARK]”，得到“考核总分”及相关信息
     * @return
     * @throws Exception
     */
    public DataPackage doSumGroupExmnmarkInfo(String exmnperiod) throws Exception {
    	ExmnstddetailDBParam param = new ExmnstddetailDBParam();
    	param.setSelectFieldsString("wayid,exmnid,exmnperiod,exmnmark");
		param.getQueryConditions().put("exmnperiod", exmnperiod);
		param.setQueryAll(true);
		return queryByNamedSqlQuery("com.gmcc.pboss.business.examine.exmnstddetail.sumGroupExmnmarkInfo", param);
	}
    /**
     * 根据“渠道代码[WAYID]”、“考核标识[EXMNID]”、“考核周期”判断
     * “指标得分明细[CH_KH_EXMNSTDDETAIL]”表中是否存在“否决项[ISVOTED]”为“是[1]”的是指标
     * @param wayid
     * @param exmnid
     * @param exmnperiod
     * @return
     * @throws Exception
     */
    public boolean doHasIsvotedExmnstddetail(String wayid,Integer exmnid,String exmnperiod)throws Exception{
    	Hibernate3SessionManager sessionManager = (Hibernate3SessionManager)super.getSessionManager();
		Session session = (Session) sessionManager.getCurrentSession();
		Query query=session.createSQLQuery(session.getNamedQuery("com.gmcc.pboss.business.examine.exmnstddetail.hasIsvotedExmnstddetail").getQueryString())
						.addScalar("cou", Hibernate.INTEGER);
		query.setParameter("exmnperiod", exmnperiod);
		query.setParameter("exmnid", exmnid);
		query.setParameter("wayid", wayid);
		List list=query.list();
		if(list!=null && (Integer)list.get(0)>0){
			return true;
		}
		return false;
    }
}
