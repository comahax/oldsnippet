/**
 * auto-generated code
 * Fri Aug 05 08:51:02 CST 2011
 */
package com.gmcc.pboss.business.channel.wayprovince;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.infrastructure.db.AbstractDAO;

/**
 * <p>Title: WayprovinceDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class WayprovinceDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public WayprovinceDAO(){
        super(WayprovinceVO.class);
    }
    
    public List doQueryWpByWayid(String wayid) throws Exception{
		Session session = SessionUtils.currentSession(WayprovinceVO.class,getDbFlag());
		Query query=session.getNamedQuery("getWpByWayid");
		query.setString("wayid", wayid);
		return query.list();
    	/*WayprovinceDBParam wpDBParam= new WayprovinceDBParam();
    	wpDBParam.set_pagesize("0"); // 当pagesize设为0时查所有数据，不分页
    	wpDBParam.getQueryConditions().put("wayid", wayid);		
		return queryByNamedSqlQuery("getWpByWayid", wpDBParam).getDatas();*/
	}
    
    public List doQueryWpByUniquewayid(String uniquewayid) throws Exception{
		Session session = SessionUtils.currentSession(WayprovinceVO.class,getDbFlag());
		Query query=session.getNamedQuery("getWpByUniquewayid");
		query.setString("uniquewayid", uniquewayid);
		return query.list();
		
		/*WayprovinceDBParam wpDBParam= new WayprovinceDBParam();
    	wpDBParam.set_pagesize("0"); // 当pagesize设为0时查所有数据，不分页
    	wpDBParam.getQueryConditions().put("uniquewayid", uniquewayid);		
		return queryByNamedSqlQuery("getWpByUniquewayid", wpDBParam).getDatas();*/
	}
}
