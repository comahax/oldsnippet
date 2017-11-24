package com.gmcc.pboss.control.reward.paymentsc;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.paymentsc.PaymentscDAO;
import com.gmcc.pboss.business.reward.paymentsc.PaymentscDBParam;
import com.gmcc.pboss.business.reward.paymentsc.PaymentscVO;
import com.gmcc.pboss.business.reward.paymentsc.VPaymentscDAO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: PaymentscBO
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2010
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author caiwr
 * @version 1.0
 */
public class PaymentscBO extends AbstractControlBean implements Paymentsc {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5084049836844505783L;
	// 如果pagesize为0，表示不分页，只有1页
	private final String NG_PAGESIZE = "0";

	public PaymentscVO doCreate(PaymentscVO vo) throws Exception {
		try {
			PaymentscDAO dao = (PaymentscDAO) DAOFactory.build(
					PaymentscDAO.class, user);
			return (PaymentscVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(PaymentscVO vo) throws Exception {
		try {
			PaymentscDAO dao = (PaymentscDAO) DAOFactory.build(
					PaymentscDAO.class, user);
			vo = doFindByPk(vo);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			PaymentscDAO dao = (PaymentscDAO) DAOFactory.build(
					PaymentscDAO.class, user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PaymentscVO doUpdate(PaymentscVO vo) throws Exception {
		try {
			PaymentscDAO dao = (PaymentscDAO) DAOFactory.build(
					PaymentscDAO.class, user);
			return (PaymentscVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PaymentscVO doFindByPk(Serializable pk) throws Exception {
		try {
			PaymentscDAO dao = (PaymentscDAO) DAOFactory.build(
					PaymentscDAO.class, user);
			return (PaymentscVO) dao.findByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DataPackage doQuery(PaymentscDBParam params) throws Exception {
		try {
			PaymentscDAO dao = (PaymentscDAO) DAOFactory.build(
					PaymentscDAO.class, user);
			return dao.query(params);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	/**
	 * 查询和导出时根据审核开关赋不同的查询语句
	 * 
	 * @param switchflag
	 * @return
	 */
	private String setQrySql(boolean switchflag) {
		String qrySql;
		if (switchflag) {
			qrySql = "com.gmcc.pboss.business.reward.paymentsc.doShowQueryByOprcodeSql";
		} else {
			qrySql = "com.gmcc.pboss.business.reward.paymentsc.doShowQueryBySql";
		}

		return qrySql;
	}

	/**
	 * 统计总金额时根据审核开关赋不同的查询语句
	 * 
	 * @param switchflag
	 * @return
	 */
	private String setQrySumSql(boolean switchflag) {
		String qrySql;
		if (switchflag) {
			qrySql = "com.gmcc.pboss.business.reward.paymentsc.doShowQuerySumByOprcodeSql";
		} else {
			qrySql = "com.gmcc.pboss.business.reward.paymentsc.doShowQuerySumBySql";
		}

		return qrySql;
	}

	private String setDelSql(boolean switchflag) {
		String qrySql;
		if (switchflag) {
			qrySql = "com.gmcc.pboss.business.reward.paymentsc.doDeleteQueryByOprcodeSql";
		} else {
			qrySql = "com.gmcc.pboss.business.reward.paymentsc.doDeleteQuerySql";
		}

		return qrySql;
	}

	public DataPackage doQueryBySql(PaymentscDBParam params, boolean switchflag)
			throws Exception {
		try {
			String qrySql = setQrySql(switchflag);

			VPaymentscDAO dao = (VPaymentscDAO) DAOFactory.build(
					VPaymentscDAO.class, user);
			DataPackage dp = dao.queryByNamedSqlQuery(qrySql, params);
			return dp;
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}
	
	public DataPackage doQueryDelByNamedSql(PaymentscDBParam params, boolean switchflag)
			throws Exception {
		String qrySql = setDelSql(switchflag);
		VPaymentscDAO dao = (VPaymentscDAO) DAOFactory.build(VPaymentscDAO.class,
				user);
		
		return dao.queryByNamedSqlQuery(qrySql, params);
	}

	public String doDelCountByNamedSql(PaymentscDBParam params,
			boolean switchflag) throws Exception {
		String counts = "0";

		String qrySql = setDelSql(switchflag);
		VPaymentscDAO dao = (VPaymentscDAO) DAOFactory.build(
				VPaymentscDAO.class, user);
		DataPackage dp = dao.queryByNamedSqlQuery(qrySql, params);
		counts = String.valueOf(dp.getRowCount());
		return counts;
	}

	public String doQuerySumByNamedSql(PaymentscDBParam params,
			boolean switchflag) throws Exception {
		String amounts = "-1.0";

		try {
			String sumSql = setQrySumSql(switchflag);

			VPaymentscDAO dao = (VPaymentscDAO) DAOFactory.build(
					VPaymentscDAO.class, user);
			amounts = dao.querySumByNamedSql(sumSql, params);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}

		return amounts;
	}
}
