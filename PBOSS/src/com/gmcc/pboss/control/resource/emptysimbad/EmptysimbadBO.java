/**
 * auto-generated code
 * Wed Jul 16 15:07:03 CST 2014
 */
package com.gmcc.pboss.control.resource.emptysimbad;

import java.io.Serializable;
import com.gmcc.pboss.business.resource.emptysimbad.EmptysimbadDBParam;
import com.gmcc.pboss.business.resource.emptysimbad.EmptysimbadDAO;
import com.gmcc.pboss.business.resource.emptysimbad.EmptysimbadVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: EmptysimbadBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class EmptysimbadBO extends AbstractControlBean implements
		Emptysimbad {

	public EmptysimbadVO doCreate(EmptysimbadVO vo) throws Exception {
		try {
			EmptysimbadDAO dao = (EmptysimbadDAO) DAOFactory.build(EmptysimbadDAO.class, user);
			// TODO set the pk */
			return (EmptysimbadVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(EmptysimbadVO vo) throws Exception {
		try {
			EmptysimbadDAO dao = (EmptysimbadDAO) DAOFactory.build(EmptysimbadDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			EmptysimbadDAO dao = (EmptysimbadDAO) DAOFactory.build(EmptysimbadDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public EmptysimbadVO doUpdate(EmptysimbadVO vo) throws Exception {
		try {
			EmptysimbadDAO dao = (EmptysimbadDAO) DAOFactory.build(EmptysimbadDAO.class,user);
			return (EmptysimbadVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public EmptysimbadVO doFindByPk(Serializable pk) throws Exception {
		EmptysimbadDAO dao = (EmptysimbadDAO) DAOFactory.build(EmptysimbadDAO.class,user);
		return (EmptysimbadVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(EmptysimbadDBParam params)
			throws Exception {
		EmptysimbadDAO dao = (EmptysimbadDAO) DAOFactory.build(EmptysimbadDAO.class,user);
		return dao.query(params);
	}

	public DataPackage doQueryComcategory(EmptysimbadDBParam params)
			throws Exception {
		EmptysimbadDAO dao = (EmptysimbadDAO) DAOFactory.build(EmptysimbadDAO.class,user);
		params.getQueryConditions().put("emptyno", params.get_se_emptyno());
		params.setSelectFieldsString("comcategory");
		params.setDataOnly(true);
		params.set_se_emptyno(null);
		return dao.queryByNamedSqlQuery("com.gmcc.pboss.business.resource.emptysimbad.getcomcategory", params);
	}

	public DataPackage doEmptySimBadCount(String wayid) throws Exception {
		EmptysimbadDAO dao = (EmptysimbadDAO) DAOFactory.build(EmptysimbadDAO.class, user);
		EmptysimbadDBParam params = new EmptysimbadDBParam();
		params.setSelectFieldsString("comcategory,count");
		params.getQueryConditions().put("wayid", wayid);
		DataPackage dp = dao.queryByNamedSqlQuery("com.gmcc.pboss.business.sales.partnerres.doEmptySimBadCount", params);
		return dp;
	}
}
