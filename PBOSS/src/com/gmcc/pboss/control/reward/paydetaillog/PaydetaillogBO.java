package com.gmcc.pboss.control.reward.paydetaillog;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.paydetail.PaydetailDBParam;
import com.gmcc.pboss.business.reward.paydetaillog.PaydetaillogDAO;
import com.gmcc.pboss.business.reward.paydetaillog.PaydetaillogDBParam;
import com.gmcc.pboss.business.reward.paydetaillog.PaydetaillogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class PaydetaillogBO extends AbstractControlBean implements Paydetaillog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2341390422404301543L;

	public PaydetaillogVO doCreate(PaydetaillogVO vo) throws Exception {

		try {
			
			PaydetaillogDAO dao = (PaydetaillogDAO) DAOFactory.build(
					PaydetaillogDAO.class, user);
			return (PaydetaillogVO)dao.create(vo);
			
		} catch (Exception e) {
			throw new JOPException(e);
		}
		
	}

	public void doRemoveByVO(PaydetaillogVO vo) throws Exception {
		
		try {
			
			PaydetaillogDAO dao = (PaydetaillogDAO) DAOFactory.build(PaydetaillogDAO.class, user);
			vo = doFindByPk(vo.getLogid());
			dao.remove(vo);
			
		} catch (Exception e) {
			throw new JOPException(e);
		}

	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		
		try {
			
			PaydetaillogDAO dao = (PaydetaillogDAO) DAOFactory.build(PaydetaillogDAO.class, user);
			dao.removeByPk(pk);
			
		} catch (Exception e) {
			throw new JOPException(e);
		}

	}

	public PaydetaillogVO doUpdate(PaydetaillogVO vo) throws Exception {
		
		try {
			
			PaydetaillogDAO dao = (PaydetaillogDAO) DAOFactory.build(PaydetaillogDAO.class, user);
			return (PaydetaillogVO)dao.update(vo);
			
		} catch (Exception e) {
			throw new JOPException(e);
		}
	}

	public PaydetaillogVO doFindByPk(Serializable pk) throws Exception {
		
		try {
			
			PaydetaillogDAO dao = (PaydetaillogDAO) DAOFactory.build(PaydetaillogDAO.class, user);
			return (PaydetaillogVO)dao.findByPk(pk);
			
		} catch (Exception e) {
			throw new JOPException(e);
		}
	}

	public DataPackage doQuery(PaydetaillogDBParam params) throws Exception {

		try {
			
			PaydetaillogDAO dao = (PaydetaillogDAO)DAOFactory.build(PaydetaillogDAO.class, user);
			return dao.query(params);
			
		} catch (Exception e) {
			throw new JOPException(e);
		}
		
	}

	public DataPackage doQueryBySql(PaydetaillogDBParam params) throws Exception {
		
		try {
			
			PaydetaillogDAO dao = (PaydetaillogDAO)DAOFactory.build(PaydetaillogDAO.class, user);
			String queryString = "SELECT LOGIN, SEQ, CALCMONTH, OPMONTH, TYPE, WAYID, MOBILE, OPRCODE, OPRTYPE, OPTIME FROM CH_SC_PAYDETAIL";
			DataPackage dp = dao.queryBySql(queryString, params);
			return dp;
			
		} catch (Exception e) {
			throw new JOPException(e);
		}
	}

	

	
}
