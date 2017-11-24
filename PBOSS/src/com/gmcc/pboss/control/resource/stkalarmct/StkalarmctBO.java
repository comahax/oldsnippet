/**
 * auto-generated code
 * Tue Aug 10 16:43:27 CST 2010
 */
package com.gmcc.pboss.control.resource.stkalarmct;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.stkalarmct.StkalarmctDBParam;
import com.gmcc.pboss.business.resource.stkalarmct.StkalarmctDAO;
import com.gmcc.pboss.business.resource.stkalarmct.StkalarmctVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: StkalarmctBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author zhangsiwei
 * @version 1.0
 */
public class StkalarmctBO extends AbstractControlBean implements
		Stkalarmct {

	public StkalarmctVO doCreate(StkalarmctVO vo) throws Exception {
		try {
			StkalarmctDAO dao = (StkalarmctDAO) DAOFactory.build(StkalarmctDAO.class, user);
			// TODO set the pk */
			return (StkalarmctVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(StkalarmctVO vo) throws Exception {
		try {
			StkalarmctDAO dao = (StkalarmctDAO) DAOFactory.build(StkalarmctDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			StkalarmctDAO dao = (StkalarmctDAO) DAOFactory.build(StkalarmctDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public StkalarmctVO doUpdate(StkalarmctVO vo) throws Exception {
		try {
			StkalarmctDAO dao = (StkalarmctDAO) DAOFactory.build(StkalarmctDAO.class,user);
			return (StkalarmctVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public StkalarmctVO doFindByPk(Serializable pk) throws Exception {
		StkalarmctDAO dao = (StkalarmctDAO) DAOFactory.build(StkalarmctDAO.class,user);
		return (StkalarmctVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(StkalarmctDBParam params)
			throws Exception {
		StkalarmctDAO dao = (StkalarmctDAO) DAOFactory.build(StkalarmctDAO.class,user);
		return dao.query(params);
	}
}
