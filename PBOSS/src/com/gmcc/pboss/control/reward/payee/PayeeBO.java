package com.gmcc.pboss.control.reward.payee;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.payee.PayeeDAO;
import com.gmcc.pboss.business.reward.payee.PayeeDBParam;
import com.gmcc.pboss.business.reward.payee.PayeeVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: PayeeBO </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public class PayeeBO extends AbstractControlBean implements Payee {

	public PayeeVO doCreate(PayeeVO vo) throws Exception {
		try {
			PayeeDAO dao = (PayeeDAO) DAOFactory.build(PayeeDAO.class, user);
			// TODO set the pk */
			return (PayeeVO) dao.saveOrUpdate(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(PayeeVO vo) throws Exception {
		try {
			PayeeDAO dao = (PayeeDAO) DAOFactory.build(PayeeDAO.class,user);
			vo = doFindByPk(vo);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			PayeeDAO dao = (PayeeDAO) DAOFactory.build(PayeeDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PayeeVO doUpdate(PayeeVO vo) throws Exception {
		try {
			PayeeDAO dao = (PayeeDAO) DAOFactory.build(PayeeDAO.class,user);
			return (PayeeVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PayeeVO doFindByPk(Serializable pk) throws Exception {
		try {
			PayeeDAO dao = (PayeeDAO) DAOFactory.build(PayeeDAO.class,user);
			return (PayeeVO) dao.findByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DataPackage doQuery(PayeeDBParam params) throws Exception {
		try {
			PayeeDAO dao = (PayeeDAO) DAOFactory.build(PayeeDAO.class,user);
			return dao.query(params);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}		
	}
	
	public DataPackage doQueryPayeeBySql(PayeeDBParam params, int type) throws Exception {
		try {
			PayeeDAO dao = (PayeeDAO) DAOFactory.build(PayeeDAO.class,user);
			String queryString = "SELECT PAYEE, CITYID FROM CH_CW_PAYEE";
			DataPackage dp = dao.queryBySql(queryString, params,type);
			return dp;
		} catch (Exception ex) {
			throw new JOPException(ex);
		}		
	}
}
