package com.gmcc.pboss.business.sales.bgbusiness.SellMidClear;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.gmcc.pboss.business.sales.comsellmid.ComsellmidVO;
import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.infrastructure.db.AbstractDAO;

public class SellMidClearDAO extends AbstractDAO {

	public SellMidClearDAO() {
		super(ComsellmidVO.class);
	}
	
	public int deleteOverdueData(Date overdueDate) throws Exception {
		int deleteRow = 0;
		String deleteSQL = "delete from FX_SW_COMSELLMID where CREATETIME < :overdueDate";
		Session session = SessionUtils.currentSession();
		try {
			deleteRow = session.createSQLQuery(deleteSQL)
								.setDate("overdueDate", overdueDate)
								.executeUpdate();
		}catch (HibernateException ex) {
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}
    	return deleteRow;
	}
}
