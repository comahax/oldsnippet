/**
 * auto-generated code
 * Thu Sep 17 14:55:03 CST 2009
 */
package com.gmcc.pboss.control.promotion.ruleitemlog;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.ruleitemlog.RuleitemlogDBParam;
import com.gmcc.pboss.business.promotion.ruleitemlog.RuleitemlogDAO;
import com.gmcc.pboss.business.promotion.ruleitemlog.RuleitemlogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: RuleitemlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/promotion/ruleitemlog/control/RuleitemlogBO"
*    name="Ruleitemlog"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class RuleitemlogBO extends AbstractControlBean implements
		Ruleitemlog {

	public RuleitemlogVO doCreate(RuleitemlogVO vo) throws Exception {
		try {
			RuleitemlogDAO dao = (RuleitemlogDAO) DAOFactory.build(RuleitemlogDAO.class, user);
			// TODO set the pk */
			return (RuleitemlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(RuleitemlogVO vo) throws Exception {
		try {
			RuleitemlogDAO dao = (RuleitemlogDAO) DAOFactory.build(RuleitemlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			RuleitemlogDAO dao = (RuleitemlogDAO) DAOFactory.build(RuleitemlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RuleitemlogVO doUpdate(RuleitemlogVO vo) throws Exception {
		try {
			RuleitemlogDAO dao = (RuleitemlogDAO) DAOFactory.build(RuleitemlogDAO.class,user);
			return (RuleitemlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RuleitemlogVO doFindByPk(Serializable pk) throws Exception {
		RuleitemlogDAO dao = (RuleitemlogDAO) DAOFactory.build(RuleitemlogDAO.class,user);
		return (RuleitemlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(RuleitemlogDBParam params)
			throws Exception {
		RuleitemlogDAO dao = (RuleitemlogDAO) DAOFactory.build(RuleitemlogDAO.class,user);
		return dao.query(params);
	}
}
