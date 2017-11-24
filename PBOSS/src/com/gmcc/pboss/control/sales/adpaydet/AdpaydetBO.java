/**
 * auto-generated code
 * Wed Apr 28 13:14:56 CST 2010
 */
package com.gmcc.pboss.control.sales.adpaydet;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.adpaydet.AdpaydetDBParam;
import com.gmcc.pboss.business.sales.adpaydet.AdpaydetDAO;
import com.gmcc.pboss.business.sales.adpaydet.AdpaydetVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: AdpaydetBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author zsw
 * @version 1.0
 */
public class AdpaydetBO extends AbstractControlBean implements
		Adpaydet {

	public AdpaydetVO doCreate(AdpaydetVO vo) throws Exception {
		try {
			AdpaydetDAO dao = (AdpaydetDAO) DAOFactory.build(AdpaydetDAO.class, user);
			// TODO set the pk */
			return (AdpaydetVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(AdpaydetVO vo) throws Exception {
		try {
			AdpaydetDAO dao = (AdpaydetDAO) DAOFactory.build(AdpaydetDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			AdpaydetDAO dao = (AdpaydetDAO) DAOFactory.build(AdpaydetDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public AdpaydetVO doUpdate(AdpaydetVO vo) throws Exception {
		try {
			AdpaydetDAO dao = (AdpaydetDAO) DAOFactory.build(AdpaydetDAO.class,user);
			return (AdpaydetVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public AdpaydetVO doFindByPk(Serializable pk) throws Exception {
		AdpaydetDAO dao = (AdpaydetDAO) DAOFactory.build(AdpaydetDAO.class,user);
		return (AdpaydetVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(AdpaydetDBParam params)
			throws Exception {
		AdpaydetDAO dao = (AdpaydetDAO) DAOFactory.build(AdpaydetDAO.class,user);
		return dao.query(params);
	}
}
