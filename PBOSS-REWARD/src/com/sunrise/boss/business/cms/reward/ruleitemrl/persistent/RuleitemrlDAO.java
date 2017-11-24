/**
* auto-generated code
* Thu Sep 11 19:35:20 CST 2008
*/
package com.sunrise.boss.business.cms.reward.ruleitemrl.persistent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.BaseListVO;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: RuleitemrlDAO</p>
 * <p>Description: Data Access Object for RuleitemrlVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RuleitemrlDAO extends BaseDAO {

    /**
     * default constructor
     */
    public RuleitemrlDAO(){
        super(RuleitemrlVO.class);
    }
    public DataPackage doQueryRuleItemRl(String ruleid,String ruleitemid,String rltype)
		throws Exception{
    	BaseListVO baseListVO = new BaseListVO();
		baseListVO.getQueryConditions().put("ruleid", ruleid);
		baseListVO.getQueryConditions().put("ruleitemid", ruleitemid);
		baseListVO.getQueryConditions().put("rltype", rltype);
		baseListVO.set_pagesize("0");
		return queryByNamedSqlQuery(
					"cms.reward.ruleitemrl.queryRuleItemRl", baseListVO);
    }
 
	public DataPackage doQueryRuleItemRlTypeChain(String ruleid,String ruleitemid,short rltype)
		throws Exception {
		BaseListVO baseListVO = new BaseListVO();
		baseListVO.getQueryConditions().put("ruleid", ruleid);
		baseListVO.getQueryConditions().put("ruleitemid", ruleitemid);
		baseListVO.getQueryConditions().put("rltype",String.valueOf(rltype));
		baseListVO.set_pagesize("0");
		return queryByNamedSqlQuery(
				"cms.reward.ruleitemrl.queryRuleItemRlTypeChain", baseListVO);
	}
	public DataPackage doQueryRuleItemRlIsleaderChain(String ruleid,String ruleitemid,short rltype,short isleader)
		throws Exception {
		BaseListVO baseListVO = new BaseListVO();
		baseListVO.getQueryConditions().put("ruleid", ruleid);
		baseListVO.getQueryConditions().put("ruleitemid", ruleitemid);
		baseListVO.getQueryConditions().put("rltype",String.valueOf(rltype));
		baseListVO.getQueryConditions().put("isleader",String.valueOf(isleader));
		baseListVO.set_pagesize("0");
		return queryByNamedSqlQuery(
				"cms.reward.ruleitemrl.queryRuleItemRlIsleaderChain", baseListVO);
//		RuleitemrlDAO dao = (RuleitemrlDAO) DAOFactory.build(RuleitemrlDAO.class, user);
//		Session session=SessionUtil.currentSession(dao.getDbFlag());
//		List resultlist=new ArrayList();
//		Query query;
//		query=session.getNamedQuery("cms.reward.ruleitemrl.queryRuleItemRlChain");
//		query.setString("ruleid", ruleid);
//		query.setShort("isleader",isleader);
//		query.setString("ruleitemid",ruleitemid);
//		List list=query.list();
//		DataPackage datapackage=new DataPackage();
//		datapackage.setDatas(list);
//		datapackage.setPageSize(list.size());
//		return datapackage;
	}
	
	public DataPackage doQueryRuleItemRlMutex(String ruleid,String ruleitemid,short rltype)
		throws Exception {
		BaseListVO baseListVO = new BaseListVO();
		baseListVO.getQueryConditions().put("ruleid", ruleid);
		baseListVO.getQueryConditions().put("ruleitemid", ruleitemid);
		baseListVO.getQueryConditions().put("rltype",String.valueOf(rltype));
		baseListVO.set_pagesize("0");
		return queryByNamedSqlQuery(
				"cms.reward.ruleitemrl.queryRuleItemRlMutex", baseListVO);
	}
}
