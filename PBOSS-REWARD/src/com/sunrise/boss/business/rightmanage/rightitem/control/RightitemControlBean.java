/**
 * auto-generated code
 * Tue Oct 31 14:19:29 CST 2006
 */
package com.sunrise.boss.business.rightmanage.rightitem.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.rightmanage.rightitem.persistent.RightitemVO;
import com.sunrise.boss.business.rightmanage.rightitem.persistent.RightitemDAO;
import com.sunrise.boss.business.rightmanage.rightitem.persistent.RightitemListVO;
/**
 * <p>
 * Title: RightitemControlBean
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/rightmanage/rightitem/control/RightitemControlBean"
 *           name="RightitemControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class RightitemControlBean extends AbstractControlBean implements
		RightitemControl {

	public RightitemVO doCreate(RightitemVO vo, User user) throws Exception {
		try {
			RightitemDAO dao = (RightitemDAO) DAOFactory.build(
					RightitemDAO.class, user.getCityid());
			// TODO set the pk */
			return (RightitemVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(RightitemVO vo, User user) throws Exception {
		try {
			RightitemDAO dao = (RightitemDAO) DAOFactory.build(
					RightitemDAO.class, user.getCityid());
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public RightitemVO doUpdate(RightitemVO vo, User user) throws Exception {
		try {
			RightitemDAO dao = (RightitemDAO) DAOFactory.build(
					RightitemDAO.class, user.getCityid());
			return (RightitemVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public RightitemVO doFindByPk(Serializable pk, User user) throws Exception {
		RightitemDAO dao = (RightitemDAO) DAOFactory.build(RightitemDAO.class,
				user.getCityid());
		return (RightitemVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(RightitemListVO params, User user)
			throws Exception {
		RightitemDAO dao = (RightitemDAO) DAOFactory.build(RightitemDAO.class,
				user.getCityid());
		return dao.query(params);
	}

	public void doBatchin(RightitemVO vo, User user) throws Exception {
		RightitemDAO dao = (RightitemDAO) DAOFactory.build(RightitemDAO.class, user.getCityid());
		RightitemVO getvo = (RightitemVO)dao.findByPk(vo.getRightid());
    	if (getvo != null){
    		throw new Exception("记录已存在!");
    	}
    	try {
			dao.create(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception(e.getMessage()+"||"+e.getCause()+"||入库失败");
		}
	}
}
