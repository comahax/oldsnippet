package com.sunrise.boss.business.fee.billing.checkplanresult.control;

import java.io.Serializable;

import com.sunrise.boss.business.fee.billing.checkplanresult.persistent.CheckPlanResultDAO;
import com.sunrise.boss.business.fee.billing.checkplanresult.persistent.CheckPlanResultDBParam;
import com.sunrise.boss.business.fee.billing.checkplanresult.persistent.CheckPlanResultVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;


public class CheckPlanResultBO extends AbstractControlBean implements
CheckPlanResult {

	public CheckPlanResultVO doCreate(CheckPlanResultVO vo)
			throws Exception {
		try {
			CheckPlanResultDAO dao = (CheckPlanResultDAO) DAOFactory.build(CheckPlanResultDAO.class, this.user);

			return (CheckPlanResultVO) dao.create(vo);
		} catch (Exception ex) {
			throw ex;
		}
	}

	public void doRemove(CheckPlanResultVO vo) throws Exception {
		try {
			CheckPlanResultDAO dao = (CheckPlanResultDAO) DAOFactory.build(CheckPlanResultDAO.class, this.user);

			dao.remove(vo);
		} catch (Exception ex) {
			throw ex;
		}
	}

	public CheckPlanResultVO doUpdate(CheckPlanResultVO vo)
			throws Exception {
		try {
			CheckPlanResultDAO dao = (CheckPlanResultDAO) DAOFactory.build(CheckPlanResultDAO.class, this.user);

			return (CheckPlanResultVO) dao.update(vo);
		} catch (Exception ex) {
			throw ex;
		}
	}

	public CheckPlanResultVO doFindByPk(Serializable pk)
			throws Exception {
		CheckPlanResultDAO dao = (CheckPlanResultDAO) DAOFactory.build(
				CheckPlanResultDAO.class, this.user);
		return (CheckPlanResultVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(CheckPlanResultDBParam params)
			throws Exception {
		CheckPlanResultDAO dao = (CheckPlanResultDAO) DAOFactory.build(
				CheckPlanResultDAO.class, this.user);
		return dao.query(params);
	}

}
