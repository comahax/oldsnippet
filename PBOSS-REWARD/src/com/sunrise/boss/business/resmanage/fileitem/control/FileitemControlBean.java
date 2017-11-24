package com.sunrise.boss.business.resmanage.fileitem.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.resmanage.fileitem.persistent.FileitemVO;
import com.sunrise.boss.business.resmanage.fileitem.persistent.FileitemDAO;
import com.sunrise.boss.business.resmanage.fileitem.persistent.FileitemListVO;

/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/resmanage/fileitem/control/FileitemControlBean"
 *           name="FileitemControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class FileitemControlBean extends AbstractControlBean implements
		FileitemControl {

	public FileitemVO doCreate(FileitemVO vo, User user) throws Exception {
		try {
			FileitemDAO dao = (FileitemDAO) DAOFactory.build(FileitemDAO.class,
					user.getCityid());
			// TODO set the pk */
			return (FileitemVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(FileitemVO vo, User user) throws Exception {
		try {
			FileitemDAO dao = (FileitemDAO) DAOFactory.build(FileitemDAO.class,
					user.getCityid());
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public FileitemVO doUpdate(FileitemVO vo, User user) throws Exception {
		try {
			FileitemDAO dao = (FileitemDAO) DAOFactory.build(FileitemDAO.class,
					user.getCityid());
			return (FileitemVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public FileitemVO doFindByPk(Serializable pk, User user) throws Exception {
		FileitemDAO dao = (FileitemDAO) DAOFactory.build(FileitemDAO.class,
				user.getCityid());
		return (FileitemVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(FileitemListVO params, User user)
			throws Exception {
		FileitemDAO dao = (FileitemDAO) DAOFactory.build(FileitemDAO.class,
				user.getCityid());
		return dao.query(params);
	}

	public DataPackage doQuery(FileitemListVO params, User user,
			boolean getRcdCount) throws Exception {
		FileitemDAO dao = (FileitemDAO) DAOFactory.build(FileitemDAO.class,
				user.getCityid());
		return dao.query(params, getRcdCount);
	}
}
