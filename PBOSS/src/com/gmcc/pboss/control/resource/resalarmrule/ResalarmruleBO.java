package com.gmcc.pboss.control.resource.resalarmrule;


import java.io.Serializable;

import com.gmcc.pboss.business.resource.resalarmrule.ResalarmruleDAO;
import com.gmcc.pboss.business.resource.resalarmrule.ResalarmruleDBParam;
import com.gmcc.pboss.business.resource.resalarmrule.ResalarmruleVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: ResalarmruleBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class ResalarmruleBO extends AbstractControlBean implements
		Resalarmrule {

	public ResalarmruleVO doCreate(ResalarmruleVO vo) throws Exception {
		try {
			ResalarmruleDAO dao = (ResalarmruleDAO) DAOFactory.build(ResalarmruleDAO.class, user);
			// TODO set the pk */
			return (ResalarmruleVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ResalarmruleVO vo) throws Exception {
		try {
			ResalarmruleDAO dao = (ResalarmruleDAO) DAOFactory.build(ResalarmruleDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ResalarmruleDAO dao = (ResalarmruleDAO) DAOFactory.build(ResalarmruleDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ResalarmruleVO doUpdate(ResalarmruleVO vo) throws Exception {
		try {
			ResalarmruleDAO dao = (ResalarmruleDAO) DAOFactory.build(ResalarmruleDAO.class,user);
			return (ResalarmruleVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ResalarmruleVO doFindByPk(Serializable pk) throws Exception {
		ResalarmruleDAO dao = (ResalarmruleDAO) DAOFactory.build(ResalarmruleDAO.class,user);
		return (ResalarmruleVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ResalarmruleDBParam params)
			throws Exception {
		ResalarmruleDAO dao = (ResalarmruleDAO) DAOFactory.build(ResalarmruleDAO.class,user);
		return dao.query(params);
	}
}
