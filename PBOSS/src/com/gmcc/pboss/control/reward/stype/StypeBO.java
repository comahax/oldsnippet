package com.gmcc.pboss.control.reward.stype;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.ltype.LtypeDAO;
import com.gmcc.pboss.business.reward.ltype.LtypeDBParam;
import com.gmcc.pboss.business.reward.stype.StypeDAO;
import com.gmcc.pboss.business.reward.stype.StypeDBParam;
import com.gmcc.pboss.business.reward.stype.StypeVO;
import com.gmcc.pboss.business.reward.stype.VstypeDAO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: StypeBO </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public class StypeBO extends AbstractControlBean implements Stype {

	public StypeVO doCreate(StypeVO vo) throws Exception {
		try {
			StypeDAO dao = (StypeDAO) DAOFactory.build(StypeDAO.class, user);
			// TODO set the pk */
			return (StypeVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(StypeVO vo) throws Exception {
		try {
			StypeDAO dao = (StypeDAO) DAOFactory.build(StypeDAO.class,user);
			vo = doFindByPk(vo);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			StypeDAO dao = (StypeDAO) DAOFactory.build(StypeDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public StypeVO doUpdate(StypeVO vo) throws Exception {
		try {
			StypeDAO dao = (StypeDAO) DAOFactory.build(StypeDAO.class,user);
			return (StypeVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public StypeVO doFindByPk(Serializable pk) throws Exception {
		try {
			StypeDAO dao = (StypeDAO) DAOFactory.build(StypeDAO.class,user);
			return (StypeVO) dao.findByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DataPackage doQuery(StypeDBParam params) throws Exception {
		try {
			StypeDAO dao = (StypeDAO) DAOFactory.build(StypeDAO.class,user);
			return dao.query(params);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}		
	}
	
	public DataPackage doQueryBySql(StypeDBParam params) throws Exception {
		try {
			VstypeDAO dao = (VstypeDAO) DAOFactory.build(VstypeDAO.class,user);
			//params.setSelectFieldsString("optype,ltype,stype");
			//params.setDataOnly(true);
			DataPackage dp = dao.queryByNamedSqlQuery("com.gmcc.pboss.business.reward.stype.doQueryBySql", params);
			return dp;
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}
	
	public DataPackage doQueryStypeBySql(StypeDBParam params, int type) throws Exception {
		try {
			StypeDAO dao = (StypeDAO) DAOFactory.build(StypeDAO.class,user);
			String queryString = "SELECT STYPE, CITYID FROM CH_CW_STYPE";
			DataPackage dp = dao.queryBySql(queryString, params,type);
			return dp;
		} catch (Exception ex) {
			throw new JOPException(ex);
		}		
	}
}
