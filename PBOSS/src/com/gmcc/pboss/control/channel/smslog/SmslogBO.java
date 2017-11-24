/**
 * auto-generated code
 * Thu Feb 24 16:49:38 CST 2011
 */
package com.gmcc.pboss.control.channel.smslog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.smslog.SmslogDBParam;
import com.gmcc.pboss.business.channel.smslog.SmslogDAO;
import com.gmcc.pboss.business.channel.smslog.SmslogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: SmslogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class SmslogBO extends AbstractControlBean implements
		Smslog {

	public SmslogVO doCreate(SmslogVO vo) throws Exception {
		try {
			SmslogDAO dao = (SmslogDAO) DAOFactory.build(SmslogDAO.class, user);
			// TODO set the pk */
			return (SmslogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(SmslogVO vo) throws Exception {
		try {
			SmslogDAO dao = (SmslogDAO) DAOFactory.build(SmslogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			SmslogDAO dao = (SmslogDAO) DAOFactory.build(SmslogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SmslogVO doUpdate(SmslogVO vo) throws Exception {
		try {
			SmslogDAO dao = (SmslogDAO) DAOFactory.build(SmslogDAO.class,user);
			return (SmslogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SmslogVO doFindByPk(Serializable pk) throws Exception {
		SmslogDAO dao = (SmslogDAO) DAOFactory.build(SmslogDAO.class,user);
		return (SmslogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(SmslogDBParam params)
			throws Exception {
		SmslogDAO dao = (SmslogDAO) DAOFactory.build(SmslogDAO.class,user);
		return dao.query(params);
	}
}
