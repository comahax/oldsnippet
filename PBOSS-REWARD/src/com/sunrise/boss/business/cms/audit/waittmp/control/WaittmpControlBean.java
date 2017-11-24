package com.sunrise.boss.business.cms.audit.waittmp.control;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import com.sunrise.boss.business.admin.operator.persistent.OperatorDAO;
import com.sunrise.boss.business.admin.operator.persistent.OperatorVO;
import com.sunrise.boss.business.cms.audit.waittmp.persistent.WaittmpDAO;
import com.sunrise.boss.business.cms.audit.waittmp.persistent.WaittmpListVO;
import com.sunrise.boss.business.cms.audit.waittmp.persistent.WaittmpVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * @author liminghao
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/cms/audit/waittmp/control/WaittmpControlBean"
*    name="WaittmpControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class WaittmpControlBean extends AbstractControlBean implements
		WaittmpControl {

	public WaittmpVO doCreate(WaittmpVO vo, User user) throws Exception {

		try {
			WaittmpDAO dao = (WaittmpDAO) DAOFactory.build(WaittmpDAO.class,
					user);
			vo = (WaittmpVO) dao.create(vo);
			return vo;
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(WaittmpVO vo, User user) throws Exception {

		try {
			WaittmpDAO dao = (WaittmpDAO) DAOFactory.build(WaittmpDAO.class,
					user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public WaittmpVO doUpdate(WaittmpVO vo, User user) throws Exception {
		try {
			WaittmpDAO dao = (WaittmpDAO) DAOFactory.build(WaittmpDAO.class,
					user);
			vo = (WaittmpVO) dao.update(vo);
			return vo;
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public WaittmpVO doFindByPk(Serializable pk, User user) throws Exception {
		WaittmpDAO dao = (WaittmpDAO) DAOFactory.build(WaittmpDAO.class, user);
		return (WaittmpVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(WaittmpListVO params, User user)
			throws Exception {
		WaittmpDAO dao = (WaittmpDAO) DAOFactory.build(WaittmpDAO.class, user);
		return dao.query(params);
	}

	public boolean sendDx(int type, String orgCode, String desCode, User user)
			throws Exception {
		WaittmpDAO dao = (WaittmpDAO) DAOFactory.build(WaittmpDAO.class, user);
		return dao.sendDx(type, orgCode, desCode, user);
	}
	

}
