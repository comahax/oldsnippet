/**
* auto-generated code
* Mon Feb 04 12:03:22 CST 2008
*/
package com.sunrise.boss.business.cms.reward.rule2.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.rule2.persistent.Rule2VO;
import com.sunrise.boss.business.cms.reward.rule2.persistent.Rule2DAO;
import com.sunrise.boss.business.cms.reward.rule2.persistent.Rule2ListVO;

/**
 * <p>Title: Rule2ControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/rule2/control/Rule2ControlBean"
 name="Rule2Control"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class Rule2ControlBean extends AbstractControlBean
    implements Rule2Control {

    
    public Rule2VO doFindByPk(Serializable pk, User user)
        throws Exception {
         Rule2DAO dao = (Rule2DAO) DAOFactory.build(Rule2DAO.class, user);
        return (Rule2VO) dao.findByPk(pk);
    }
    public DataPackage doQuery(Rule2ListVO params, User user)
        throws Exception {
         Rule2DAO dao = (Rule2DAO) DAOFactory.build(Rule2DAO.class, user);
        return dao.queryRuleIn2Tables(params);
    }
    
	public DataPackage getDistinctRule(Rule2ListVO listVO, User user)
			throws Exception {
		Rule2DAO dao = (Rule2DAO) DAOFactory.build(Rule2DAO.class, user);
		return dao.getDistinctRule(listVO);
	}
	
	public DataPackage getDistinctBBCRule(Rule2ListVO listVO, User user)
			throws Exception {
		Rule2DAO dao = (Rule2DAO) DAOFactory.build(Rule2DAO.class, user);
		return dao.getDistinctBBCRule(listVO);
	}	
	
	public DataPackage getDistinctZjtyRule(Rule2ListVO listVO, User user)
			throws Exception {
		Rule2DAO dao = (Rule2DAO) DAOFactory.build(Rule2DAO.class, user);
		return dao.getDistinctZjtyRule(listVO);
	}	
	
}
