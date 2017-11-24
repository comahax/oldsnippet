/**
 * auto-generated code
 * Thu Jul 01 16:27:16 CST 2010
 */
package com.gmcc.pboss.control.sales.comdisscalelog;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.comdisscalelog.ComdisscalelogDBParam;
import com.gmcc.pboss.business.sales.comdisscalelog.ComdisscalelogDAO;
import com.gmcc.pboss.business.sales.comdisscalelog.ComdisscalelogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: ComdisscalelogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ComdisscalelogBO extends AbstractControlBean implements
		Comdisscalelog {

	public ComdisscalelogVO doCreate(ComdisscalelogVO vo) throws Exception {
		try {
			ComdisscalelogDAO dao = (ComdisscalelogDAO) DAOFactory.build(ComdisscalelogDAO.class, user);
			// TODO set the pk */
			return (ComdisscalelogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ComdisscalelogVO vo) throws Exception {
		try {
			ComdisscalelogDAO dao = (ComdisscalelogDAO) DAOFactory.build(ComdisscalelogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ComdisscalelogDAO dao = (ComdisscalelogDAO) DAOFactory.build(ComdisscalelogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ComdisscalelogVO doUpdate(ComdisscalelogVO vo) throws Exception {
		try {
			ComdisscalelogDAO dao = (ComdisscalelogDAO) DAOFactory.build(ComdisscalelogDAO.class,user);
			return (ComdisscalelogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ComdisscalelogVO doFindByPk(Serializable pk) throws Exception {
		ComdisscalelogDAO dao = (ComdisscalelogDAO) DAOFactory.build(ComdisscalelogDAO.class,user);
		return (ComdisscalelogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ComdisscalelogDBParam params)
			throws Exception {
		ComdisscalelogDAO dao = (ComdisscalelogDAO) DAOFactory.build(ComdisscalelogDAO.class,user);
		return dao.query(params);
	}
}
