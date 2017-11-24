/**
 * auto-generated code
 * Thu Sep 17 14:53:18 CST 2009
 */
package com.gmcc.pboss.control.promotion.spproposallog;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.spproposallog.SpproposallogDBParam;
import com.gmcc.pboss.business.promotion.spproposallog.SpproposallogDAO;
import com.gmcc.pboss.business.promotion.spproposallog.SpproposallogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: SpproposallogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/promotion/spproposallog/control/SpproposallogBO"
*    name="Spproposallog"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class SpproposallogBO extends AbstractControlBean implements
		Spproposallog {

	public SpproposallogVO doCreate(SpproposallogVO vo) throws Exception {
		try {
			SpproposallogDAO dao = (SpproposallogDAO) DAOFactory.build(SpproposallogDAO.class, user);
			// TODO set the pk */
			return (SpproposallogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(SpproposallogVO vo) throws Exception {
		try {
			SpproposallogDAO dao = (SpproposallogDAO) DAOFactory.build(SpproposallogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			SpproposallogDAO dao = (SpproposallogDAO) DAOFactory.build(SpproposallogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SpproposallogVO doUpdate(SpproposallogVO vo) throws Exception {
		try {
			SpproposallogDAO dao = (SpproposallogDAO) DAOFactory.build(SpproposallogDAO.class,user);
			return (SpproposallogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SpproposallogVO doFindByPk(Serializable pk) throws Exception {
		SpproposallogDAO dao = (SpproposallogDAO) DAOFactory.build(SpproposallogDAO.class,user);
		return (SpproposallogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(SpproposallogDBParam params)
			throws Exception {
		SpproposallogDAO dao = (SpproposallogDAO) DAOFactory.build(SpproposallogDAO.class,user);
		return dao.query(params);
	}
}
