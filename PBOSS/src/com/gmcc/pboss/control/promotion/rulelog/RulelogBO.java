/**
 * auto-generated code
 * Thu Sep 17 14:57:06 CST 2009
 */
package com.gmcc.pboss.control.promotion.rulelog;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.rulelog.RulelogDBParam;
import com.gmcc.pboss.business.promotion.rulelog.RulelogDAO;
import com.gmcc.pboss.business.promotion.rulelog.RulelogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: RulelogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/promotion/rulelog/control/RulelogBO"
*    name="Rulelog"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class RulelogBO extends AbstractControlBean implements
		Rulelog {

	public RulelogVO doCreate(RulelogVO vo) throws Exception {
		try {
			RulelogDAO dao = (RulelogDAO) DAOFactory.build(RulelogDAO.class, user);
			// TODO set the pk */
			return (RulelogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(RulelogVO vo) throws Exception {
		try {
			RulelogDAO dao = (RulelogDAO) DAOFactory.build(RulelogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			RulelogDAO dao = (RulelogDAO) DAOFactory.build(RulelogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RulelogVO doUpdate(RulelogVO vo) throws Exception {
		try {
			RulelogDAO dao = (RulelogDAO) DAOFactory.build(RulelogDAO.class,user);
			return (RulelogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RulelogVO doFindByPk(Serializable pk) throws Exception {
		RulelogDAO dao = (RulelogDAO) DAOFactory.build(RulelogDAO.class,user);
		return (RulelogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(RulelogDBParam params)
			throws Exception {
		RulelogDAO dao = (RulelogDAO) DAOFactory.build(RulelogDAO.class,user);
		return dao.query(params);
	}
}
