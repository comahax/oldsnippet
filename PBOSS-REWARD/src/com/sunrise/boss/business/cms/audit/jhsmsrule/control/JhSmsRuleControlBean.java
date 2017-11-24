package com.sunrise.boss.business.cms.audit.jhsmsrule.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.audit.jhsmsrule.persistent.JhSmsRuleDAO;
import com.sunrise.boss.business.cms.audit.jhsmsrule.persistent.JhSmsRuleListVO;
import com.sunrise.boss.business.cms.audit.jhsmsrule.persistent.JhSmsRuleVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: CompanyDelegate
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Hanny Yeung
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/cms/audit/jhsmsrule/control/JhSmsRuleControlBean"
*    name="JhSmsRuleControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class JhSmsRuleControlBean extends AbstractControlBean implements
		JhSmsRuleControl {

	public JhSmsRuleVO doCreate(JhSmsRuleVO vo, User user) throws Exception {
		try {
			JhSmsRuleDAO dao = (JhSmsRuleDAO) DAOFactory.build(
					JhSmsRuleDAO.class, user );
			return (JhSmsRuleVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(JhSmsRuleVO vo, User user) throws Exception {
		try {
			JhSmsRuleDAO dao = (JhSmsRuleDAO) DAOFactory.build(
					JhSmsRuleDAO.class, user );
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public JhSmsRuleVO doUpdate(JhSmsRuleVO vo, User user) throws Exception {
		try {
			JhSmsRuleDAO dao = (JhSmsRuleDAO) DAOFactory.build(
					JhSmsRuleDAO.class, user );
			return (JhSmsRuleVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public JhSmsRuleVO doFindByPk(Serializable pk, User user) throws Exception {
		JhSmsRuleDAO dao = (JhSmsRuleDAO) DAOFactory.build(JhSmsRuleDAO.class,
				user );
		return (JhSmsRuleVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(JhSmsRuleListVO params, User user)
			throws Exception {
		JhSmsRuleDAO dao = (JhSmsRuleDAO) DAOFactory.build(JhSmsRuleDAO.class,
				user );
		return dao.query(params);
	}
}
