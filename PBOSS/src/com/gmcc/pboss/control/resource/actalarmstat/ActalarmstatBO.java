/**
 * auto-generated code
 * Tue Jul 27 15:41:54 CST 2010
 */
package com.gmcc.pboss.control.resource.actalarmstat;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.actalarmstat.ActalarmstatDAO;
import com.gmcc.pboss.business.resource.actalarmstat.ActalarmstatDBParam;
import com.gmcc.pboss.business.resource.actalarmstat.ActalarmstatVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ActalarmstatBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ActalarmstatBO extends AbstractControlBean implements
		Actalarmstat {

	public ActalarmstatVO doCreate(ActalarmstatVO vo) throws Exception {
		try {
			ActalarmstatDAO dao = (ActalarmstatDAO) DAOFactory.build(ActalarmstatDAO.class, user);
			// TODO set the pk */
			return (ActalarmstatVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ActalarmstatVO vo) throws Exception {
		try {
			ActalarmstatDAO dao = (ActalarmstatDAO) DAOFactory.build(ActalarmstatDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ActalarmstatDAO dao = (ActalarmstatDAO) DAOFactory.build(ActalarmstatDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ActalarmstatVO doUpdate(ActalarmstatVO vo) throws Exception {
		try {
			ActalarmstatDAO dao = (ActalarmstatDAO) DAOFactory.build(ActalarmstatDAO.class,user);
			return (ActalarmstatVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ActalarmstatVO doFindByPk(Serializable pk) throws Exception {
		ActalarmstatDAO dao = (ActalarmstatDAO) DAOFactory.build(ActalarmstatDAO.class,user);
		return (ActalarmstatVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ActalarmstatDBParam params)
			throws Exception {
		ActalarmstatDAO dao = (ActalarmstatDAO) DAOFactory.build(ActalarmstatDAO.class,user);
		return dao.query(params);
	}
	
	public DataPackage doUnionQuery(Object[] params,Class[] classvo,String[][] joins)throws Exception {
		ActalarmstatDAO dao = (ActalarmstatDAO) DAOFactory.build(ActalarmstatDAO.class,user);
		return dao.unionQuery(params, classvo, joins);
	}
}
