package com.gmcc.pboss.control.reward.ltype;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.ltype.LtypeDAO;
import com.gmcc.pboss.business.reward.ltype.LtypeDBParam;
import com.gmcc.pboss.business.reward.ltype.LtypeVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: LtypeBO </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public class LtypeBO extends AbstractControlBean implements Ltype {

	public LtypeVO doCreate(LtypeVO vo) throws Exception {
		try {
			LtypeDAO dao = (LtypeDAO) DAOFactory.build(LtypeDAO.class, user);
			// TODO set the pk */
			return (LtypeVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(LtypeVO vo) throws Exception {
		try {
			LtypeDAO dao = (LtypeDAO) DAOFactory.build(LtypeDAO.class,user);
			vo = doFindByPk(vo);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			LtypeDAO dao = (LtypeDAO) DAOFactory.build(LtypeDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public LtypeVO doUpdate(LtypeVO vo) throws Exception {
		try {
			LtypeDAO dao = (LtypeDAO) DAOFactory.build(LtypeDAO.class,user);
			return (LtypeVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public LtypeVO doFindByPk(Serializable pk) throws Exception {
		try {
			LtypeDAO dao = (LtypeDAO) DAOFactory.build(LtypeDAO.class,user);
			return (LtypeVO) dao.findByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DataPackage doQuery(LtypeDBParam params) throws Exception {
		try {
			LtypeDAO dao = (LtypeDAO) DAOFactory.build(LtypeDAO.class,user);
			return dao.query(params);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}		
	}
	
	public DataPackage doQueryBySql(LtypeDBParam params) throws Exception {
		try {
			LtypeDAO dao = (LtypeDAO) DAOFactory.build(LtypeDAO.class,user);
			params.setSelectFieldsString("optype,ltype,stype");
			//params.setDataOnly(true);
			DataPackage dp = dao.queryByNamedSqlQuery("com.gmcc.pboss.business.reward.ltype.doQueryBySql", params);
			return dp;
		} catch (Exception ex) {
			throw new JOPException(ex);
		}		
	}
}
