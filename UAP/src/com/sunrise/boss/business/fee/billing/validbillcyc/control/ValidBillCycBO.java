/**
 * 
 */
package com.sunrise.boss.business.fee.billing.validbillcyc.control;

import java.io.Serializable;

import com.sunrise.boss.business.fee.billing.validbillcyc.persistent.ValidBillCycDAO;
import com.sunrise.boss.business.fee.billing.validbillcyc.persistent.ValidBillCycDBParam;
import com.sunrise.boss.business.fee.billing.validbillcyc.persistent.ValidBillCycVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;


public class ValidBillCycBO extends AbstractControlBean implements
		ValidBillCyc {

	public ValidBillCycVO doCreate(ValidBillCycVO vo)
			throws Exception {
		try {
			ValidBillCycDAO dao = (ValidBillCycDAO) DAOFactory.build(ValidBillCycDAO.class, this.user);

			return (ValidBillCycVO) dao.create(vo);
		} catch (Exception ex) {
			throw ex;
		}
	}

	public void doRemove(ValidBillCycVO vo) throws Exception {
		try {
			ValidBillCycDAO dao = (ValidBillCycDAO) DAOFactory.build(ValidBillCycDAO.class, this.user);

			dao.remove(vo);
		} catch (Exception ex) {
			throw ex;
		}
	}

	public ValidBillCycVO doUpdate(ValidBillCycVO vo)
			throws Exception {
		try {
			ValidBillCycDAO dao = (ValidBillCycDAO) DAOFactory.build(ValidBillCycDAO.class, this.user);

			return (ValidBillCycVO) dao.update(vo);
		} catch (Exception ex) {
			throw ex;
		}
	}

	public ValidBillCycVO doFindByPk(Serializable pk)
			throws Exception {
		ValidBillCycDAO dao = (ValidBillCycDAO) DAOFactory.build(
				ValidBillCycDAO.class, this.user);
		return (ValidBillCycVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ValidBillCycDBParam params)
			throws Exception {
		ValidBillCycDAO dao = (ValidBillCycDAO) DAOFactory.build(
				ValidBillCycDAO.class, this.user);
		return dao.query(params);
	}

}
