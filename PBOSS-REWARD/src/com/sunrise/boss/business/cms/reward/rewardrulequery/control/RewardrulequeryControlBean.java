/**
 * auto-generated code
 * Wed Mar 05 16:41:04 CST 2008
 */
package com.sunrise.boss.business.cms.reward.rewardrulequery.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.reward.rewardrulequery.persistent.RewardrulequeryDAO;
import com.sunrise.boss.business.cms.reward.rewardrulequery.persistent.RewardrulequeryListVO;
import com.sunrise.boss.business.cms.reward.rewardrulequery.persistent.RewardrulequeryVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: StdrewardbjControlBean
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company: SUNRISE Tech Ltd.
 * </p>
 * 
 * @author linli
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/reward/rewardrulequery/control/RewardrulequeryControlBean"
 *           name="RewardrulequeryControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class RewardrulequeryControlBean extends AbstractControlBean implements
		RewardrulequeryControl {
	

	public RewardrulequeryVO doCreate(RewardrulequeryVO vo, User user) throws Exception {
		RewardrulequeryDAO dao=(RewardrulequeryDAO)DAOFactory.build(RewardrulequeryDAO.class, user);
		return (RewardrulequeryVO)dao.create(vo);
		 
	}

	public RewardrulequeryVO doFindByPk(Serializable pk, User user) throws Exception {
		RewardrulequeryDAO dao=(RewardrulequeryDAO)DAOFactory.build(RewardrulequeryDAO.class, user);
		return (RewardrulequeryVO)dao.findByPk(pk);
	}

	public void doRemove(RewardrulequeryVO vo, User user) throws Exception {
		RewardrulequeryDAO dao=(RewardrulequeryDAO)DAOFactory.build(RewardrulequeryDAO.class, user);
		dao.remove(vo);
	}

	public RewardrulequeryVO doUpdate(RewardrulequeryVO vo, User user) throws Exception {
		RewardrulequeryDAO dao=(RewardrulequeryDAO)DAOFactory.build(RewardrulequeryDAO.class, user);
		return (RewardrulequeryVO)dao.update(vo);
	}

	public DataPackage doQuery(RewardrulequeryListVO params, User user) throws Exception {
		RewardrulequeryDAO dao=(RewardrulequeryDAO)DAOFactory.build(RewardrulequeryDAO.class, user);
		return dao.doQuery(params);
	}

}
