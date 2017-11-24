/**
* auto-generated code
* Wed Nov 18 16:17:06 CST 2009
*/
package com.sunrise.boss.business.cms.examine.examine.persistent;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;


/**
 * <p>Title: ExamineDAO</p>
 * <p>Description: Data Access Object for ExamineVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExamineDAO extends BaseLogDAO {

    /**
     * default constructor
     */
    public ExamineDAO(){
        super(ExamineVO.class);
    }
	public DataPackage queryExamineList(ExamineListVO params,String cityid)throws Exception  {
		Session session = SessionUtil.currentSession(getDbFlag());

		SQLQuery query = (SQLQuery)session.getNamedQuery("queryExamineList");
		String queryString = query.getQueryString();
		//params.getQueryConditions().put("adtype", "%" + params.get_sk_adtype() + "%");
		//params.getQueryConditions().put("starlevel", "%" + params.get_sk_starlevel() + "%");
		params.getQueryConditions().put("skcityid", "%" +  cityid+ "%");
		params.getQueryConditions().put("cityid", cityid);
		return queryBySql(queryString, params);

	}
}
