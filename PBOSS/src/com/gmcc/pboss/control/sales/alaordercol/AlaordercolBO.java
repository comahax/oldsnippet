/**
 * auto-generated code
 * Fri Jun 25 10:45:52 CST 2010
 */
package com.gmcc.pboss.control.sales.alaordercol;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.alaordercol.AlaordercolDAO;
import com.gmcc.pboss.business.sales.alaordercol.AlaordercolDBParam;
import com.gmcc.pboss.business.sales.alaordercol.AlaordercolVO;
import com.gmcc.pboss.business.sales.disform.DisformDBParam;
import com.gmcc.pboss.business.sales.disform.VDisformDAO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: AlaordercolBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class AlaordercolBO extends AbstractControlBean implements
		Alaordercol {

	public AlaordercolVO doCreate(AlaordercolVO vo) throws Exception {
		try {
			AlaordercolDAO dao = (AlaordercolDAO) DAOFactory.build(AlaordercolDAO.class, user);
			// TODO set the pk */
			return (AlaordercolVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(AlaordercolVO vo) throws Exception {
		try {
			AlaordercolDAO dao = (AlaordercolDAO) DAOFactory.build(AlaordercolDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			AlaordercolDAO dao = (AlaordercolDAO) DAOFactory.build(AlaordercolDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public AlaordercolVO doUpdate(AlaordercolVO vo) throws Exception {
		try {
			AlaordercolDAO dao = (AlaordercolDAO) DAOFactory.build(AlaordercolDAO.class,user);
			return (AlaordercolVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public AlaordercolVO doFindByPk(Serializable pk) throws Exception {
		AlaordercolDAO dao = (AlaordercolDAO) DAOFactory.build(AlaordercolDAO.class,user);
		return (AlaordercolVO) dao.findByPk(pk);
	}
	
	public DataPackage doQuery(AlaordercolDBParam params) throws Exception {
		AlaordercolDAO dao = (AlaordercolDAO) DAOFactory.build(AlaordercolDAO.class,
				user);
		return dao.query(params);
	}
	public DataPackage doGroupQuery(AlaordercolDBParam params) throws Exception {
		AlaordercolDAO dao = (AlaordercolDAO) DAOFactory.build(AlaordercolDAO.class,
				user);
		return dao.groupQuery(params);
	}
}
