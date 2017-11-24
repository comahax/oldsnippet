/**
 * auto-generated code
 * Thu Jun 16 17:11:00 CST 2011
 */
package com.gmcc.pboss.control.sales.extraexent;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.extraexent.ExtraexentDBParam;
import com.gmcc.pboss.business.sales.extraexent.ExtraexentDAO;
import com.gmcc.pboss.business.sales.extraexent.ExtraexentVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: ExtraexentBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public class ExtraexentBO extends AbstractControlBean implements
		Extraexent {

	public ExtraexentVO doCreate(ExtraexentVO vo) throws Exception {
		try {
			ExtraexentDAO dao = (ExtraexentDAO) DAOFactory.build(ExtraexentDAO.class, user);
			// TODO set the pk */
			return (ExtraexentVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ExtraexentVO vo) throws Exception {
		try {
			ExtraexentDAO dao = (ExtraexentDAO) DAOFactory.build(ExtraexentDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ExtraexentDAO dao = (ExtraexentDAO) DAOFactory.build(ExtraexentDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ExtraexentVO doUpdate(ExtraexentVO vo) throws Exception {
		try {
			ExtraexentDAO dao = (ExtraexentDAO) DAOFactory.build(ExtraexentDAO.class,user);
			return (ExtraexentVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ExtraexentVO doFindByPk(Serializable pk) throws Exception {
		ExtraexentDAO dao = (ExtraexentDAO) DAOFactory.build(ExtraexentDAO.class,user);
		return (ExtraexentVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ExtraexentDBParam params)
			throws Exception {
		ExtraexentDAO dao = (ExtraexentDAO) DAOFactory.build(ExtraexentDAO.class,user);
		return dao.query(params);
	}
}
