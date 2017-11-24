package com.gmcc.pboss.business.sales.bgbusiness.BookResRelease;


import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.gmcc.pboss.business.resource.compack.CompackVO;
import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.infrastructure.db.AbstractDAO;

public class BookResReleaseDAO extends AbstractDAO {


	public BookResReleaseDAO() {
		super(CompackVO.class);
	}
	
	public int updateComPack(String batchno,String boxno) throws Exception{
		String updateSql = "update CompackVO set PACKSTATE=1 " +
			"where BATCHNO = :batchno and BOXNUM = :boxno and PACKSTATE=5";
		int updatedRow = 0; 
		Session session = SessionUtils.currentSession();
		try {
			updatedRow = session.createQuery(updateSql)
								.setString("batchno", batchno)
								.setString("boxno", boxno)
								.executeUpdate();
		}catch (HibernateException ex) {
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}
		return updatedRow;
    }
}
