package com.sunrise.boss.business.fee.billing.rhfixfeecresult.control;

import java.io.Serializable;

import com.sunrise.boss.business.fee.billing.rhfixfeecresult.persistent.RhFixfeeCresultDAO;
import com.sunrise.boss.business.fee.billing.rhfixfeecresult.persistent.RhFixfeeCresultDBParam;
import com.sunrise.boss.business.fee.billing.rhfixfeecresult.persistent.RhFixfeeCresultVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;


public class RhFixfeeCresultBO extends AbstractControlBean implements 
RhFixfeeCresult {

	public RhFixfeeCresultVO doCreate(RhFixfeeCresultVO vo)
			throws Exception {
		try {
			RhFixfeeCresultDAO dao = (RhFixfeeCresultDAO) DAOFactory.build(RhFixfeeCresultDAO.class, this.user);

			return (RhFixfeeCresultVO) dao.create(vo);
		} catch (Exception ex) {
			throw ex;
		}
	}

	public void doRemove(RhFixfeeCresultVO vo) throws Exception {
		try {
			RhFixfeeCresultDAO dao = (RhFixfeeCresultDAO) DAOFactory.build(RhFixfeeCresultDAO.class, this.user);

			dao.remove(vo);
		} catch (Exception ex) {
			throw ex;
		}
	}

	public RhFixfeeCresultVO doUpdate(RhFixfeeCresultVO vo)
			throws Exception {
		try {
			RhFixfeeCresultDAO dao = (RhFixfeeCresultDAO) DAOFactory.build(RhFixfeeCresultDAO.class, this.user);

			return (RhFixfeeCresultVO) dao.update(vo);
		} catch (Exception ex) {
			throw ex;
		}
	}

	public RhFixfeeCresultVO doFindByPk(Serializable pk)
			throws Exception {
		RhFixfeeCresultDAO dao = (RhFixfeeCresultDAO) DAOFactory.build(
				RhFixfeeCresultDAO.class, this.user);
		return (RhFixfeeCresultVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(RhFixfeeCresultDBParam params) throws Exception {
		RhFixfeeCresultDAO dao = (RhFixfeeCresultDAO) DAOFactory.build(
				RhFixfeeCresultDAO.class, this.user);
		return dao.query(params);
	}

}
