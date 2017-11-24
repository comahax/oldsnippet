/**
 * auto-generated code
 * Fri Sep 18 10:50:26 CST 2009
 */
package com.gmcc.pboss.control.promotion.presentingdtl;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.presentingdtl.PresentingdtlDAO;
import com.gmcc.pboss.business.promotion.presentingdtl.PresentingdtlDBParam;
import com.gmcc.pboss.business.promotion.presentingdtl.PresentingdtlVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: PresentingdtlBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/promotions/presentingdtl/control/PresentingdtlBO"
*    name="Presentingdtl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class PresentingdtlBO extends AbstractControlBean implements
		Presentingdtl {

	public PresentingdtlVO doCreate(PresentingdtlVO vo) throws Exception {
		try {
			PresentingdtlDAO dao = (PresentingdtlDAO) DAOFactory.build(PresentingdtlDAO.class, user);
			// TODO set the pk */
			return (PresentingdtlVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(PresentingdtlVO vo) throws Exception {
		try {
			PresentingdtlDAO dao = (PresentingdtlDAO) DAOFactory.build(PresentingdtlDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			PresentingdtlDAO dao = (PresentingdtlDAO) DAOFactory.build(PresentingdtlDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PresentingdtlVO doUpdate(PresentingdtlVO vo) throws Exception {
		try {
			PresentingdtlDAO dao = (PresentingdtlDAO) DAOFactory.build(PresentingdtlDAO.class,user);
			return (PresentingdtlVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PresentingdtlVO doFindByPk(Serializable pk) throws Exception {
		PresentingdtlDAO dao = (PresentingdtlDAO) DAOFactory.build(PresentingdtlDAO.class,user);
		return (PresentingdtlVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(PresentingdtlDBParam params)
			throws Exception {
		PresentingdtlDAO dao = (PresentingdtlDAO) DAOFactory.build(PresentingdtlDAO.class,user);
		return dao.query(params);
	}
}
