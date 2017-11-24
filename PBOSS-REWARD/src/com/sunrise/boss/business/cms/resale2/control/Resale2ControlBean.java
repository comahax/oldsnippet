/**
 * auto-generated code
 * Sun Feb 03 10:15:39 CST 2008
 */
package com.sunrise.boss.business.cms.resale2.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.resale2.persistent.Resale2DAO;
import com.sunrise.boss.business.cms.resale2.persistent.Resale2ListVO;
import com.sunrise.boss.business.cms.reward.rule.persistent.RuleVO;
import com.sunrise.boss.business.cms.reward.rule.persistent.RuleDAO;
import com.sunrise.boss.business.cms.reward.rule.persistent.RuleListVO;

/**
 * <p>
 * Title: Resale2ControlBean
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
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/resale2/control/Resale2ControlBean"
 *           name="Resale2Control" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class Resale2ControlBean extends AbstractControlBean implements
		Resale2Control {

	public String doQuery(String mobile, User user) throws Exception {
		Resale2DAO dao = (Resale2DAO) DAOFactory.build(Resale2DAO.class, user);
		return dao.queryOpnid(mobile);
	}
}
