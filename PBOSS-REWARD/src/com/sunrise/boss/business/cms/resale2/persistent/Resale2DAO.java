/**
 * auto-generated code
 * Sun Feb 03 10:15:39 CST 2008
 */
package com.sunrise.boss.business.cms.resale2.persistent;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.boss.business.cms.resale2.persistent.Resale2ListVO;
import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;

/**
 * <p>
 * Title: RuleDAO
 * </p>
 * <p>
 * Description: Data Access Object for RuleVO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
public class Resale2DAO extends BaseDAO {

	/**
	 * default constructor
	 */
	public Resale2DAO() {
		super(Resale2VO.class);
	}

	// OPNID≤È—Ø
	public String queryOpnid(String mobile) throws Exception {
		Session session = SessionUtil.currentSession(getDbFlag());
		Query query = session.getNamedQuery("queryOpnid2");
		query.setParameter("comresid", mobile);
		List list = query.list();
		if(list.size()<=0){
			return null;
		}else{
			return ((Resale2VO)(list.get(0))).getOpntype();
		}
	}
}
