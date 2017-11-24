/**
 * auto-generated code
 * Thu Feb 24 16:50:49 CST 2011
 */
package com.gmcc.pboss.control.channel.smsloghis;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.smsloghis.SmsloghisDBParam;
import com.gmcc.pboss.business.channel.smsloghis.SmsloghisDAO;
import com.gmcc.pboss.business.channel.smsloghis.SmsloghisVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: SmsloghisBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class SmsloghisBO extends AbstractControlBean implements
		Smsloghis {

	public SmsloghisVO doCreate(SmsloghisVO vo) throws Exception {
		try {
			SmsloghisDAO dao = (SmsloghisDAO) DAOFactory.build(SmsloghisDAO.class, user);
			// TODO set the pk */
			return (SmsloghisVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(SmsloghisVO vo) throws Exception {
		try {
			SmsloghisDAO dao = (SmsloghisDAO) DAOFactory.build(SmsloghisDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			SmsloghisDAO dao = (SmsloghisDAO) DAOFactory.build(SmsloghisDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SmsloghisVO doUpdate(SmsloghisVO vo) throws Exception {
		try {
			SmsloghisDAO dao = (SmsloghisDAO) DAOFactory.build(SmsloghisDAO.class,user);
			return (SmsloghisVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SmsloghisVO doFindByPk(Serializable pk) throws Exception {
		SmsloghisDAO dao = (SmsloghisDAO) DAOFactory.build(SmsloghisDAO.class,user);
		return (SmsloghisVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(SmsloghisDBParam params)
			throws Exception {
		SmsloghisDAO dao = (SmsloghisDAO) DAOFactory.build(SmsloghisDAO.class,user);
		return dao.query(params);
	}
}
