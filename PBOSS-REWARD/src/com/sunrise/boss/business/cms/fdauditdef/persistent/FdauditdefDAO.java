/**
* auto-generated code
* Thu Jul 26 17:37:14 CST 2007
*/
package com.sunrise.boss.business.cms.fdauditdef.persistent;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: FdauditdefDAO</p>
 * <p>Description: Data Access Object for FdauditdefVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class FdauditdefDAO extends BaseDAO {

    /**
     * default constructor
     */
    public FdauditdefDAO(){
        super(FdauditdefVO.class);
    }
    
    public DataPackage queryAllTypes() throws Exception {
    	Session session = SessionUtil.currentSession(getDbFlag());
    	SQLQuery countQuery = session.createSQLQuery("select typechname,typename from CH_PW_FDAUDITDEF group by typechname,typename");
    	
    	countQuery.addScalar("typechname", Hibernate.STRING);
    	countQuery.addScalar("typename", Hibernate.STRING);
    	
    	List list = countQuery.list();
    	DataPackage data = new DataPackage();
    	data.setDatas(list);
    	data.setRowCount(list.size());
    	return data;
    }
}
