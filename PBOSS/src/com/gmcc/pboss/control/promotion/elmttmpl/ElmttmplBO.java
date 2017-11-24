/**
 * auto-generated code
 * Mon Sep 14 14:22:16 CST 2009
 */
package com.gmcc.pboss.control.promotion.elmttmpl;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.elmttmpl.ElmttmplDAO;
import com.gmcc.pboss.business.promotion.elmttmpl.ElmttmplDBParam;
import com.gmcc.pboss.business.promotion.elmttmpl.ElmttmplVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: ElmttmplBO
 * </p>;
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
 * @author linli
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/jop/business/promotion/elmttmpl/control/ElmttmplBO"
 *           name="Elmttmpl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class ElmttmplBO extends AbstractControlBean implements Elmttmpl {

	public ElmttmplVO doCreate(ElmttmplVO vo) throws Exception {
		try {
			ElmttmplDAO dao = (ElmttmplDAO) DAOFactory.build(ElmttmplDAO.class,
					user);
			// TODO set the pk */
			return (ElmttmplVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ElmttmplVO vo) throws Exception {
		try {
			ElmttmplDAO dao = (ElmttmplDAO) DAOFactory.build(ElmttmplDAO.class,
					user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ElmttmplDAO dao = (ElmttmplDAO) DAOFactory.build(ElmttmplDAO.class,
					user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ElmttmplVO doUpdate(ElmttmplVO vo) throws Exception {
		try {
			ElmttmplDAO dao = (ElmttmplDAO) DAOFactory.build(ElmttmplDAO.class,
					user);
			return (ElmttmplVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ElmttmplVO doFindByPk(Serializable pk) throws Exception {
		ElmttmplDAO dao = (ElmttmplDAO) DAOFactory.build(ElmttmplDAO.class,
				user);
		return (ElmttmplVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ElmttmplDBParam params) throws Exception {
		ElmttmplDAO dao = (ElmttmplDAO) DAOFactory.build(ElmttmplDAO.class,
				user);
		return dao.query(params);
	}
}
