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
     * ������������[WAYID]���������˱�ʶ[EXMNID]��������������[EXMNPERIOD]
     * ����ͳ�ơ�ָ��÷���ϸ[CH_KH_EXMNSTDDETAIL]���ġ����˷���[EXMNMARK]�����õ��������ܷ֡��������Ϣ
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
     * ���ݡ���������[WAYID]���������˱�ʶ[EXMNID]�������������ڡ��ж�
     * ��ָ��÷���ϸ[CH_KH_EXMNSTDDETAIL]�������Ƿ���ڡ������[ISVOTED]��Ϊ����[1]������ָ��
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
