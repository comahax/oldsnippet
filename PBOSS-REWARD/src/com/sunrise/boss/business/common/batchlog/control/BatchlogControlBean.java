package com.sunrise.boss.business.common.batchlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.business.common.batchlog.persistent.BatchlogVO;
import com.sunrise.boss.business.common.batchlog.persistent.BatchlogDAO;
import com.sunrise.boss.business.common.batchlog.persistent.BatchlogListVO;
import com.sunrise.boss.ui.commons.User;

/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/common/batchlog/control/BatchlogControlBean"
*    name="BatchlogControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class BatchlogControlBean extends AbstractControlBean implements
		BatchlogControl {

	public BatchlogVO doCreate(BatchlogVO vo, User user) throws Exception {

		try {
			BatchlogDAO dao = (BatchlogDAO) DAOFactory.build(BatchlogDAO.class,
					user);
			vo = (BatchlogVO) dao.create(vo);
			return vo;
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(BatchlogVO vo, User user) throws Exception {

		try {
			BatchlogDAO dao = (BatchlogDAO) DAOFactory.build(BatchlogDAO.class,
					user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public BatchlogVO doUpdate(BatchlogVO vo, User user) throws Exception {
		try {
			BatchlogDAO dao = (BatchlogDAO) DAOFactory.build(BatchlogDAO.class,
					user);
			vo = (BatchlogVO) dao.update(vo);
			return vo;
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public BatchlogVO doFindByPk(Serializable pk, User user) throws Exception {
		BatchlogDAO dao = (BatchlogDAO) DAOFactory.build(BatchlogDAO.class,
				user);
		return (BatchlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(BatchlogListVO params, User user)
			throws Exception {
		BatchlogDAO dao = (BatchlogDAO) DAOFactory.build(BatchlogDAO.class,
				user);
		return dao.query(params);
	}
}
