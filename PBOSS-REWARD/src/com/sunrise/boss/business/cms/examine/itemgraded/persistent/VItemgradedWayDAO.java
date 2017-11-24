/**
* auto-generated code
* Sat Nov 28 17:57:55 CST 2009
*/
package com.sunrise.boss.business.cms.examine.itemgraded.persistent;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: ExmnauditDAO</p>
 * <p>Description: Data Access Object for ExmnauditVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class VItemgradedWayDAO extends BaseDAO {

    /**
     * default constructor
     */
    public VItemgradedWayDAO(){
        super(VItemgradedWayVO.class);
    }
    /**
	 * 查找评分渠道信息
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public DataPackage getItemgradedWayInfo(User user)
			throws Exception {
		Session session = SessionUtil.currentSession(getDbFlag());
		ItemgradedListVO listVO=new ItemgradedListVO();
		Query query = (SQLQuery) session
				.getNamedQuery("getItemgradedWayInfo");
		query.setParameter("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
		query.setParameter("likecityid", "%"+SessionFactoryRouter.conversionCityid(user.getCityid())+"%");
		query.setParameter("operid", user.getOpercode());
		DataPackage dp=new DataPackage();
		List list=query.list();
		dp.setDatas(list);
		return dp;
		/*String queryString = query.getQueryString();
		listVO.getQueryConditions().put("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
		listVO.getQueryConditions().put("likecityid", "%"+SessionFactoryRouter.conversionCityid(user.getCityid())+"%");
		listVO.getQueryConditions().put("operid", user.getOpercode());
		listVO.set_pagesize("0");
		List selectFields=new ArrayList();
		selectFields.add("wayid");
		selectFields.add("wayname");
		selectFields.add("adtypecode");
		selectFields.add("starlevel");
		selectFields.add("exmnid");
		selectFields.add("exmnname"); 
		selectFields.add("exmnstdid");
		selectFields.add("exmnstdname");
		selectFields.add("isvoted");
		selectFields.add("exmnscore");
		listVO.setSelectFields(selectFields);
		DataPackage date=super.queryByNamedSqlQuery("getItemgradedWayInfo", listVO);
		return super.queryByNamedSqlQuery("getItemgradedWayInfo", listVO);//queryBySql(queryString,listVO,super.QUERY_TYPE_ALL);
*/	}
   
}
