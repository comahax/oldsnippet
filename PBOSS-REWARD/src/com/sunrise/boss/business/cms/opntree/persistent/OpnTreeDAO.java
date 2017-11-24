/**
* auto-generated code
* Wed Dec 31 13:51:34 CST 2008
*/
package com.sunrise.boss.business.cms.opntree.persistent;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.ui.cms.opntree.OpnTreeType;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: OpnTreeDAO</p>
 * <p>Description: Data Access Object for OpnTreeVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class OpnTreeDAO extends BaseDAO {

    /**
     * default constructor
     */
    public OpnTreeDAO(){
        super(OpnTreeVO.class);
    }
    
    public int queryUpCount(OpnTreeListVO params, User user) throws Exception{
    	Session session = SessionUtil.currentSession(this.getDbFlag());
		Query query = session.getNamedQuery(params.getTreetype()+".operation.queryup");
		query.setString("id", params.get_se_opnid());
		query.setString("name", "%" + params.get_sk_name() + "%");
		List list = query.list();
		return list.size();
    }
    
    public DataPackage queryUpData(OpnTreeListVO params, User user) throws Exception{
		Session session = SessionUtil.currentSession(this.getDbFlag());
		Query query = session.getNamedQuery(params.getTreetype()+".operation.queryup");
		query.setString("id", params.get_se_opnid());
		query.setString("name", "%" + params.get_sk_name() + "%");
		List list = query.list();
		DataPackage dp = new DataPackage();
		dp.setDatas(list);
		dp.setDatas(dp.toList(OpnTreeVO.class));
		return dp;
    }
    
    public int queryDownCount(OpnTreeListVO params, User user) throws Exception{
    	params.getQueryConditions().put("parentid", params.get_se_parentid());
    	DataPackage dp = super.queryByNamedSqlQuery(params.getTreetype()+".operation.querydown", params, super.QUERY_TYPE_COUNT);
		if (dp != null) {
			return dp.getRowCount();
		} else {
			return -1;
		}
    }
    
    public DataPackage queryDownData(OpnTreeListVO params, User user) throws Exception{
    	params.getQueryConditions().put("parentid", params.get_se_parentid());
    	DataPackage dp = super.queryByNamedSqlQuery(params.getTreetype()+".operation.querydown", params, super.QUERY_TYPE_DATA);
    	dp.setDatas(dp.toList(OpnTreeVO.class));
    	return dp;
    }
    
}
