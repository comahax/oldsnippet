/**
 * auto-generated code
 * Fri May 20 16:28:47 CST 2011
 */
package com.gmcc.pboss.control.base.batchsmsrc;

import java.io.Serializable;

import com.gmcc.pboss.business.base.batchsmsrc.BatchsmsrcDBParam;
import com.gmcc.pboss.business.base.batchsmsrc.BatchsmsrcDAO;
import com.gmcc.pboss.business.base.batchsmsrc.BatchsmsrcVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: BatchsmsrcBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author YangDaRen
 * @version 1.0
 */
public class BatchsmsrcBO extends AbstractControlBean implements
		Batchsmsrc {

	public BatchsmsrcVO doCreate(BatchsmsrcVO vo) throws Exception {
		try {
			BatchsmsrcDAO dao = (BatchsmsrcDAO) DAOFactory.build(BatchsmsrcDAO.class, user);
			// TODO set the pk */
			return (BatchsmsrcVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(BatchsmsrcVO vo) throws Exception {
		try {
			BatchsmsrcDAO dao = (BatchsmsrcDAO) DAOFactory.build(BatchsmsrcDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			BatchsmsrcDAO dao = (BatchsmsrcDAO) DAOFactory.build(BatchsmsrcDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public BatchsmsrcVO doUpdate(BatchsmsrcVO vo) throws Exception {
		try {
			BatchsmsrcDAO dao = (BatchsmsrcDAO) DAOFactory.build(BatchsmsrcDAO.class,user);
			return (BatchsmsrcVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public BatchsmsrcVO doFindByPk(Serializable pk) throws Exception {
		BatchsmsrcDAO dao = (BatchsmsrcDAO) DAOFactory.build(BatchsmsrcDAO.class,user);
		return (BatchsmsrcVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(BatchsmsrcDBParam params)
			throws Exception {
		BatchsmsrcDAO dao = (BatchsmsrcDAO) DAOFactory.build(BatchsmsrcDAO.class,user);
		return dao.query(params);
	}
}
