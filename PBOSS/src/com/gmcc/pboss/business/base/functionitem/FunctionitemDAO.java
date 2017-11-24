/**
 * auto-generated code
 * Tue Jul 14 14:52:45 CST 2009
 */
package com.gmcc.pboss.business.base.functionitem;

import java.io.Serializable;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.infrastructure.db.hibernate3.Hibernate3BaseDAO;
import com.sunrise.jop.infrastructure.db.hibernate3.Hibernate3SessionManager;

/**
 * <p>Title: FunctionitemDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class FunctionitemDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public FunctionitemDAO(){
        super(FunctionitemVO.class);
    }
	@Override
	public void removeByPk(Serializable pk) throws Exception {
		// TODO Auto-generated method stub
		//由于删除的是树结构节点，所有删除节点时应该也删除节点的了孙节点
		String sql = "delete from sa_db_FunctionItem where funcid in( "+
		" select distinct funcid from sa_db_FunctionItem "+
	 " start with funcid = '"+pk+"' connect by nocycle prior funcid = parentid )";
		Hibernate3SessionManager sessionManager = (Hibernate3SessionManager)super.getSessionManager();
		Session session = (Session) sessionManager.getCurrentSession();
		
		try{
			session.connection().createStatement().executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		
	}
	
	@Override
	public Object update(Object vo) throws Exception {
		// TODO Auto-generated method stub
		super.update(vo);
		FunctionitemVO functionitemVO = (FunctionitemVO)vo;
		//如果是可见,则要迭代往上查找父节点有无不可见,如果有则update
		Hibernate3SessionManager sessionManager = (Hibernate3SessionManager)super.getSessionManager();
		Session session = (Session) sessionManager.getCurrentSession();
		if(functionitemVO.getStatus() == 1){
			String upperSql = "update sa_db_FunctionItem set status = '1' where funcid in "+
				  	"(select funcid from sa_db_FunctionItem start with funcid = '" + functionitemVO.getFuncid() +"' connect by nocycle prior parentid = funcid)";
			session.connection().createStatement().executeUpdate(upperSql);
		}
		String lowerSql = "update sa_db_FunctionItem set status = '"+functionitemVO.getStatus()+"' where funcid in " +  
					"(select funcid from sa_db_FunctionItem start with funcid = '" + functionitemVO.getFuncid() +"' connect by nocycle prior funcid = parentid)";
		session.connection().createStatement().executeUpdate(lowerSql);
		return functionitemVO;
	}
    
    
}
