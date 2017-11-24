package com.sunrise.boss.business.fee.common.eboxchg.control;

import java.io.Serializable;

import com.sunrise.boss.business.fee.common.eboxchg.persistent.EboxchgDAO;
import com.sunrise.boss.business.fee.common.eboxchg.persistent.EboxchgListVO;
import com.sunrise.boss.business.fee.common.eboxchg.persistent.EboxchgVO;
import com.sunrise.boss.business.fee.dgrealprod.rbeboxchglog.persistent.RbEboxChgLogDAO;
import com.sunrise.boss.business.fee.dgrealprod.rbeboxchglog.persistent.RbEboxChgLogListVO;
import com.sunrise.boss.business.fee.persistent.eboxchglog.EboxChgLogDAO;
import com.sunrise.boss.business.fee.persistent.eboxchglog.EboxChgLogListVO;
import com.sunrise.boss.business.fee.querybyno.dgeboxchglog.persistent.DgEboxChgLogDAO;
import com.sunrise.boss.business.fee.querybyno.dgeboxchglog.persistent.DgEboxChgLogListVO;
import com.sunrise.boss.business.fee.querybyno.eboxchgloghis.persistent.EboxChgLogHisDAO;
import com.sunrise.boss.business.fee.querybyno.eboxchgloghis.persistent.EboxChgLogHisListVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;

/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/fee/common/eboxchg/control/EboxchgControlBean"
*    name="EboxchgControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class EboxchgControlBean extends AbstractControlBean implements
		EboxchgControl {
	private static final long serialVersionUID = 2832619718070882972L;

	public EboxchgVO doCreate(EboxchgVO vo, User user) throws Exception {
		try {
			EboxchgDAO dao = (EboxchgDAO) DAOFactory.build(EboxchgDAO.class,
					user.getCityid());
			// 主键-sequence方式产生
			return (EboxchgVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(EboxchgVO vo, User user) throws Exception {
		try {
			EboxchgDAO dao = (EboxchgDAO) DAOFactory.build(EboxchgDAO.class,
					user.getCityid());
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public EboxchgVO doUpdate(EboxchgVO vo, User user) throws Exception {
		try {
			EboxchgDAO dao = (EboxchgDAO) DAOFactory.build(EboxchgDAO.class,
					user.getCityid());
			return (EboxchgVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public EboxchgVO doFindByPk(Serializable pk, User user) throws Exception {
		EboxchgDAO dao = (EboxchgDAO) DAOFactory.build(EboxchgDAO.class, user
				.getCityid());
		return (EboxchgVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(EboxchgListVO params, User user)
			throws Exception {
		EboxchgDAO dao = (EboxchgDAO) DAOFactory.build(EboxchgDAO.class, user
				.getCityid());
		return dao.query(params);
	}
	
	
	
	
	public DataPackage queryEboxchglog(EboxChgLogListVO listVO,User user) throws Exception{
		EboxChgLogDAO dao = (EboxChgLogDAO) DAOFactory.build(EboxChgLogDAO.class, user.getCityid());
		return dao.queryEboxchglog("queryEboxchglog", listVO);
	}
	
	public DataPackage queryEboxChgLogHis(EboxChgLogHisListVO listVO,User user) throws Exception{
		EboxChgLogHisDAO dao = (EboxChgLogHisDAO) DAOFactory.build(EboxChgLogHisDAO.class, user.getCityid());
		return dao.queryEboxChgLogHis("queryEboxChgLogHis", listVO);
	}
	
	public DataPackage queryRbEboxChgLog(RbEboxChgLogListVO listVO,User user) throws Exception{
		RbEboxChgLogDAO dao = (RbEboxChgLogDAO) DAOFactory.build(RbEboxChgLogDAO.class, user.getCityid());
		return dao.queryRbEboxChgLog("queryRbEboxChgLog", listVO);
	}
	
	public DataPackage queryDgEboxChgLog(DgEboxChgLogListVO listVO,User user) throws Exception{
		DgEboxChgLogDAO dao = (DgEboxChgLogDAO) DAOFactory.build(DgEboxChgLogDAO.class, user.getCityid());
		return dao.queryDgEboxChgLog("queryDgEboxChgLog", listVO);
	}
	
}
