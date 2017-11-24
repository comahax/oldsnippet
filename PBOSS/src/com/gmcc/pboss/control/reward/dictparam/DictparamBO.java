/**
 * auto-generated code
 * Thu Mar 10 11:54:46 CST 2011
 */
package com.gmcc.pboss.control.reward.dictparam;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.dictparam.DictparamDBParam;
import com.gmcc.pboss.business.reward.dictparam.DictparamDAO;
import com.gmcc.pboss.business.reward.dictparam.DictparamVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: DictparamBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class DictparamBO extends AbstractControlBean implements
		Dictparam {

	public DictparamVO doCreate(DictparamVO vo) throws Exception {
		try {
			DictparamDAO dao = (DictparamDAO) DAOFactory.build(DictparamDAO.class, user);
			// TODO set the pk */
			return (DictparamVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(DictparamVO vo) throws Exception {
		try {
			DictparamDAO dao = (DictparamDAO) DAOFactory.build(DictparamDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			DictparamDAO dao = (DictparamDAO) DAOFactory.build(DictparamDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DictparamVO doUpdate(DictparamVO vo) throws Exception {
		try {
			DictparamDAO dao = (DictparamDAO) DAOFactory.build(DictparamDAO.class,user);
			return (DictparamVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DictparamVO doFindByPk(Serializable pk) throws Exception {
		DictparamDAO dao = (DictparamDAO) DAOFactory.build(DictparamDAO.class,user);
		return (DictparamVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(DictparamDBParam params)
			throws Exception {
		DictparamDAO dao = (DictparamDAO) DAOFactory.build(DictparamDAO.class,user);
		return dao.query(params);
	}
}
