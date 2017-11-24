/**
 * auto-generated code
 * Tue Sep 15 10:37:06 CST 2015
 */
package com.gmcc.pboss.control.reward.chcwpaymentsend;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.chcwpaymentsend.ChCwPaymentsendDBParam;
import com.gmcc.pboss.business.reward.chcwpaymentsend.ChCwPaymentsendDAO;
import com.gmcc.pboss.business.reward.chcwpaymentsend.ChCwPaymentsendVO;
import com.gmcc.pboss.business.reward.chcwpaymentsend.VChCwPaymentsendDAO;
import com.gmcc.pboss.business.reward.chcwpaymentsend.VChCwPaymentsendDBParam;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>
 * Title: ChCwPaymentsendBO
 * </p>
 * ;
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
 * @author ydr
 * @version 1.0
 */
public class ChCwPaymentsendBO extends AbstractControlBean implements
		ChCwPaymentsend {

	public ChCwPaymentsendVO doCreate(ChCwPaymentsendVO vo) throws Exception {
		try {
			ChCwPaymentsendDAO dao = (ChCwPaymentsendDAO) DAOFactory.build(
					ChCwPaymentsendDAO.class, user);
			// TODO set the pk */
			return (ChCwPaymentsendVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ChCwPaymentsendVO vo) throws Exception {
		try {
			ChCwPaymentsendDAO dao = (ChCwPaymentsendDAO) DAOFactory.build(
					ChCwPaymentsendDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ChCwPaymentsendDAO dao = (ChCwPaymentsendDAO) DAOFactory.build(
					ChCwPaymentsendDAO.class, user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ChCwPaymentsendVO doUpdate(ChCwPaymentsendVO vo) throws Exception {
		try {
			ChCwPaymentsendDAO dao = (ChCwPaymentsendDAO) DAOFactory.build(
					ChCwPaymentsendDAO.class, user);
			return (ChCwPaymentsendVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ChCwPaymentsendVO doFindByPk(Serializable pk) throws Exception {
		ChCwPaymentsendDAO dao = (ChCwPaymentsendDAO) DAOFactory.build(
				ChCwPaymentsendDAO.class, user);
		return (ChCwPaymentsendVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ChCwPaymentsendDBParam params) throws Exception {
		ChCwPaymentsendDAO dao = (ChCwPaymentsendDAO) DAOFactory.build(
				ChCwPaymentsendDAO.class, user);
		return dao.query(params);
	}

	public DataPackage doQueryByNamedSql(String sql,
			VChCwPaymentsendDBParam params, int type) throws Exception {
		try {
			VChCwPaymentsendDAO dao = (VChCwPaymentsendDAO) DAOFactory.build(
					VChCwPaymentsendDAO.class, user);
			DataPackage dp = dao.queryByNamedSqlQuery(sql, params, type);
			return dp;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}

	public DataPackage doQuerySbatchBySql(ChCwPaymentsendDBParam params,
			int type) throws Exception {
		try {
			ChCwPaymentsendDAO dao = (ChCwPaymentsendDAO) DAOFactory.build(
					ChCwPaymentsendDAO.class, user);
			String queryString = "SELECT DISTINCT SBATCH FROM CH_CW_PAYMENTSEND WHERE SBATCH IS NOT NULL";
			DataPackage dp = dao.queryBySql(queryString, params, type);
			return dp;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}

}
