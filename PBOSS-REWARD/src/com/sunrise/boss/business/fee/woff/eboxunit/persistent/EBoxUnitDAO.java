package com.sunrise.boss.business.fee.woff.eboxunit.persistent;

//import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.SessionUtil;

/**
 * <p>Title: EBoxUnitDAO</p>
 * <p>Description: EBox Unit DAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author xiefufeng
 * @version 1.0
 */

public class EBoxUnitDAO extends BaseDAO{

    /**
     * default constructor
     */
    public EBoxUnitDAO(){
        super(EBoxUnitVO.class);
    }
    
    /**
     * 返回帐本科目 IB_CB_EboxUnit表的所有帐本科目标识
     * @return
     * @throws Exception
     * @author gy
     */
    public List getAllEboxunitid() throws Exception {
    	Session session = SessionUtil.currentSession(getDbFlag());
    	StringBuffer buff = new StringBuffer(" select p.eboxunitid from EBoxUnitVO as p ");
    	
    	try {
            Query query = session.createQuery(buff.toString());

            List list = query.list();
            if (list != null && list.size() > 0) {
            	/*
            	List result = new ArrayList();
            	for (Iterator it = list.iterator(); it.hasNext();) {
            		Long id = (Long) it.next();
            		result.add(id);
            	}
            	return result;
            	*/
            	return list;
            }
          }
          catch (HibernateException ex) {
            if (ex.getCause() != null) {
              throw new Exception(ex.getCause());
            }
            else {
              throw ex;
            }
          }
          return null;
    }

}
