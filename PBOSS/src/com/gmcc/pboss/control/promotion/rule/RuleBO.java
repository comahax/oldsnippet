/**
 * auto-generated code
 * Thu Sep 17 14:50:45 CST 2009
 */
package com.gmcc.pboss.control.promotion.rule;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.rule.RuleDBParam;
import com.gmcc.pboss.business.promotion.rule.RuleDAO;
import com.gmcc.pboss.business.promotion.rule.RuleVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: RuleBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/promotion/rule/control/RuleBO"
*    name="Rule"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class RuleBO extends AbstractControlBean implements
		Rule {

	public RuleVO doCreate(RuleVO vo) throws Exception {
		try {
			RuleDAO dao = (RuleDAO) DAOFactory.build(RuleDAO.class, user);
			String ruleid = dao.getSequence("CH_CX_RULE_SEQ").toString();
			vo.setRuleid(new Long(ruleid));
			// TODO set the pk */
			return (RuleVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(RuleVO vo) throws Exception {
		try {
			RuleDAO dao = (RuleDAO) DAOFactory.build(RuleDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			RuleDAO dao = (RuleDAO) DAOFactory.build(RuleDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RuleVO doUpdate(RuleVO vo) throws Exception {
		try {
			RuleDAO dao = (RuleDAO) DAOFactory.build(RuleDAO.class,user);
			return (RuleVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RuleVO doFindByPk(Serializable pk) throws Exception {
		RuleDAO dao = (RuleDAO) DAOFactory.build(RuleDAO.class,user);
		return (RuleVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(RuleDBParam params)
			throws Exception {
		RuleDAO dao = (RuleDAO) DAOFactory.build(RuleDAO.class,user);
		return dao.query(params);
	}
}
