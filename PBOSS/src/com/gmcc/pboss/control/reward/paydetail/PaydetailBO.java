package com.gmcc.pboss.control.reward.paydetail;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.paydetail.PaydetailDAO;
import com.gmcc.pboss.business.reward.paydetail.PaydetailDBParam;
import com.gmcc.pboss.business.reward.paydetail.PaydetailVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class PaydetailBO extends AbstractControlBean implements Paydetail {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9153377859593975157L;

	

	public PaydetailVO doCreate(PaydetailVO vo) throws Exception {

		try {
			
			PaydetailDAO dao = (PaydetailDAO) DAOFactory.build(
					PaydetailDAO.class, user);
			return (PaydetailVO)dao.create(vo);
			
		} catch (Exception e) {
			throw new JOPException(e);
		}
		
	}

	public void doRemoveByVO(PaydetailVO vo) throws Exception {
		
		try {
			
			PaydetailDAO dao = (PaydetailDAO) DAOFactory.build(PaydetailDAO.class, user);
			vo = doFindByPk(vo.getSeq());
			dao.remove(vo);
			
		} catch (Exception e) {
			throw new JOPException(e);
		}

	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		
		try {
			
			PaydetailDAO dao = (PaydetailDAO) DAOFactory.build(PaydetailDAO.class, user);
			dao.removeByPk(pk);
			
		} catch (Exception e) {
			throw new JOPException(e);
		}

	}

	public PaydetailVO doUpdate(PaydetailVO vo) throws Exception {
		
		try {
			
			PaydetailDAO dao = (PaydetailDAO) DAOFactory.build(PaydetailDAO.class, user);
			return (PaydetailVO)dao.update(vo);
			
		} catch (Exception e) {
			throw new JOPException(e);
		}
	}

	public PaydetailVO doFindByPk(Serializable pk) throws Exception {
		
		try {
			
			PaydetailDAO dao = (PaydetailDAO) DAOFactory.build(PaydetailDAO.class, user);
			return (PaydetailVO)dao.findByPk(pk);
			
		} catch (Exception e) {
			throw new JOPException(e);
		}
	}

	public DataPackage doQuery(PaydetailDBParam params) throws Exception {

		try {
			
			PaydetailDAO dao = (PaydetailDAO)DAOFactory.build(PaydetailDAO.class, user);
			return dao.query(params);
			
		} catch (Exception e) {
			throw new JOPException(e);
		}
		
	}

	public DataPackage doQueryBySql(PaydetailDBParam params) throws Exception {
		
		try {
			
			PaydetailDAO dao = (PaydetailDAO)DAOFactory.build(PaydetailDAO.class, user);
			String queryString = "SELECT SEQ, CALCMONTH, OPMONTH, TYPE, WAYID, MOBILE FROM CH_SC_PAYDETAIL";
			DataPackage dp = dao.queryBySql(queryString, params);
			return dp;
			
		} catch (Exception e) {
			throw new JOPException(e);
		}
	}

}
