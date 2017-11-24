/**
 * auto-generated code
 * Thu Jul 09 10:43:47 CST 2009
 */
package com.gmcc.pboss.business.base.operator;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

/**
 * <p>Title: OperatorDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class OperatorDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public OperatorDAO(){
        super(OperatorVO.class);
    }
    /**
     * 根据角色标识查找操作员用户列表
     * @param roleids
     * @return
     * @throws Exception
     */
    public DataPackage queryOperatorList(String roleids,OperatorDBParam param) throws Exception {
    	param.setSelectFieldsString("operid,opername");
    	Session session = SessionUtils.currentSession("DB_COMMON");
		SQLQuery query = (SQLQuery)session.getNamedQuery("com.gmcc.pboss.business.base.operator.queryOperatorList");	
		String queryString = query.getQueryString();
		queryString+=" and r.roleid in('"+roleids+"') ";
		return super.queryBySql(queryString, param);
	}
    /**
     * 根据角色令牌查找操作员用户列表
     * @param roleids
     * @return
     * @throws Exception
     */
    public DataPackage queryWayOperatorList(String lastStepid,
			DBAccessUser user, OperatorDBParam param) throws Exception {
		param.setSelectFieldsString("operid,opername");
		Session session = SessionUtils.currentSession("DB_COMMON");
		SQLQuery query = (SQLQuery) session.getNamedQuery("auditOperator");
		String queryString = query.getQueryString();
		User realUser = (User) user;
		queryString = queryString + " and OP.REGION=" + realUser.getHwcityid()+ " ";
		if ("1".equals(lastStepid)) {
			queryString += " and opro.roleid ='N-PBOSS-04' ";
		} else if ("2".equals(lastStepid)) {
			queryString += " and opro.roleid='N-PBOSS-06' ";
		} else if ("djugeAudit".equals(lastStepid)) {
			queryString = queryString
					+ " and opro.roleid in ('N-PBOSS-04','N-PBOSS-06')  and opro.operid='"
					+ user.getOprcode() + "'";
		}

		return super.queryBySql(queryString, param);
	}
    
    /**
     * 根据角色标识查找操作员用户列表
     * @param roleids
     * @return
     * @throws Exception
     */
    public DataPackage showLowerOperator(OperatorDBParam param) throws Exception {
    	String orgid = param.get_se_orgid();
		param.getQueryConditions().put("wayid", orgid);
		param.set_se_orgid(null);
		param.setQueryAll(true);
		DataPackage dp =  queryByNamedSqlQuery("showOperator", param);
		param.set_se_orgid(orgid);
		return dp;
	}
}
