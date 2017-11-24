/**
 * auto-generated code
 * Fri Mar 04 17:20:29 CST 2011
 */
package com.gmcc.pboss.control.channel.emodconfirm;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.emodconfirm.EmodconfirmDBParam;
import com.gmcc.pboss.business.channel.emodconfirm.EmodconfirmDAO;
import com.gmcc.pboss.business.channel.emodconfirm.EmodconfirmVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: EmodconfirmBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class EmodconfirmBO extends AbstractControlBean implements
		Emodconfirm {

	public EmodconfirmVO doCreate(EmodconfirmVO vo) throws Exception {
		try {
			EmodconfirmDAO dao = (EmodconfirmDAO) DAOFactory.build(EmodconfirmDAO.class, user);
			// TODO set the pk */
			return (EmodconfirmVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(EmodconfirmVO vo) throws Exception {
		try {
			EmodconfirmDAO dao = (EmodconfirmDAO) DAOFactory.build(EmodconfirmDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			EmodconfirmDAO dao = (EmodconfirmDAO) DAOFactory.build(EmodconfirmDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public EmodconfirmVO doUpdate(EmodconfirmVO vo) throws Exception {
		try {
			EmodconfirmDAO dao = (EmodconfirmDAO) DAOFactory.build(EmodconfirmDAO.class,user);
			return (EmodconfirmVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public EmodconfirmVO doFindByPk(Serializable pk) throws Exception {
		EmodconfirmDAO dao = (EmodconfirmDAO) DAOFactory.build(EmodconfirmDAO.class,user);
		return (EmodconfirmVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(EmodconfirmDBParam params)
			throws Exception {
		EmodconfirmDAO dao = (EmodconfirmDAO) DAOFactory.build(EmodconfirmDAO.class,user);
		return dao.query(params);
	}
}
