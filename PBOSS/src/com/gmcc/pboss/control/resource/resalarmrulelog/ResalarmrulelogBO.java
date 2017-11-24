package com.gmcc.pboss.control.resource.resalarmrulelog;


import java.io.Serializable;

import com.gmcc.pboss.business.resource.resalarmrulelog.ResalarmrulelogDAO;
import com.gmcc.pboss.business.resource.resalarmrulelog.ResalarmrulelogDBParam;
import com.gmcc.pboss.business.resource.resalarmrulelog.ResalarmrulelogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: ResalarmrulelogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class ResalarmrulelogBO extends AbstractControlBean implements
		Resalarmrulelog {

	public ResalarmrulelogVO doCreate(ResalarmrulelogVO vo) throws Exception {
		try {
			ResalarmrulelogDAO dao = (ResalarmrulelogDAO) DAOFactory.build(ResalarmrulelogDAO.class, user);
			// TODO set the pk */
			return (ResalarmrulelogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ResalarmrulelogVO vo) throws Exception {
		try {
			ResalarmrulelogDAO dao = (ResalarmrulelogDAO) DAOFactory.build(ResalarmrulelogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ResalarmrulelogDAO dao = (ResalarmrulelogDAO) DAOFactory.build(ResalarmrulelogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ResalarmrulelogVO doUpdate(ResalarmrulelogVO vo) throws Exception {
		try {
			ResalarmrulelogDAO dao = (ResalarmrulelogDAO) DAOFactory.build(ResalarmrulelogDAO.class,user);
			return (ResalarmrulelogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ResalarmrulelogVO doFindByPk(Serializable pk) throws Exception {
		ResalarmrulelogDAO dao = (ResalarmrulelogDAO) DAOFactory.build(ResalarmrulelogDAO.class,user);
		return (ResalarmrulelogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ResalarmrulelogDBParam params)
			throws Exception {
		ResalarmrulelogDAO dao = (ResalarmrulelogDAO) DAOFactory.build(ResalarmrulelogDAO.class,user);
		return dao.query(params);
	}
}
