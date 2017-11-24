/**
 * auto-generated code
 * Mon Feb 04 12:04:50 CST 2008
 */
package com.sunrise.boss.business.cms.reward.rule3.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.rule3.persistent.Rule3VO;
import com.sunrise.boss.business.cms.reward.rule3.persistent.Rule3DAO;
import com.sunrise.boss.business.cms.reward.rule3.persistent.Rule3ListVO;

/**
 * <p>
 * Title: Rule3ControlBean
 * </p>
 * <p>
 * Description:
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
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/reward/rule3/control/Rule3ControlBean"
 *           name="Rule3Control" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class Rule3ControlBean extends AbstractControlBean implements
		Rule3Control {

	public Rule3VO doFindByPk(Serializable pk, User user) throws Exception {
		Rule3DAO dao = (Rule3DAO) DAOFactory.build(Rule3DAO.class, user);
		return (Rule3VO) dao.findByPk(pk);
	}

	public DataPackage doQuery(Rule3ListVO params, User user) throws Exception {
		Rule3DAO dao = (Rule3DAO) DAOFactory.build(Rule3DAO.class, user);
		return dao.queryRuleIn3Tables(params);
	}
}
