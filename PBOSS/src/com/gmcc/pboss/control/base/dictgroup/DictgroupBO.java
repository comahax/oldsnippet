package com.gmcc.pboss.control.base.dictgroup;

import java.io.Serializable;

import com.gmcc.pboss.business.base.dictgroup.DictgroupDAO;
import com.gmcc.pboss.business.base.dictgroup.DictgroupDBParam;
import com.gmcc.pboss.business.base.dictgroup.DictgroupVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
/**
 * @ejb.bean local-jndi-name="com/gmcc/pboss/control/base/dictitem/DictgroupBO"
 *           name="Dictgroup" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class DictgroupBO extends AbstractControlBean implements Dictgroup{

	public DictgroupVO doCreate(DictgroupVO vo) throws Exception {
		try {
			DictgroupDAO dao = (DictgroupDAO) DAOFactory.build(DictgroupDAO.class, user);
			return (DictgroupVO) dao.create(vo);
		} catch (Exception e) {
			throw new JOPException(e);
		}
	}

	public DictgroupVO doFindByPk(Serializable pk) throws Exception {
		DictgroupDAO dao = (DictgroupDAO) DAOFactory.build(DictgroupDAO.class,
				user);
		return (DictgroupVO) dao.findByPk(pk);
		
	}

	public DataPackage doQuery(DictgroupDBParam params) throws Exception {
		DictgroupDAO dao = (DictgroupDAO) DAOFactory.build(DictgroupDAO.class,
				user);
		return dao.query(params);
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			DictgroupDAO dao = (DictgroupDAO) DAOFactory.build(DictgroupDAO.class, user);
			dao.removeByPk(pk);
		} catch (Exception e) {
			throw new JOPException(e);
		}
		
	}

	public void doRemoveByVO(DictgroupVO vo) throws Exception {
		try {
			DictgroupDAO dao = (DictgroupDAO) DAOFactory.build(DictgroupDAO.class, user);
			dao.remove(vo);
		} catch (Exception e) {
			throw new JOPException(e);
		}
		
	}

	public DictgroupVO doUpdate(DictgroupVO vo) throws Exception {
		try {
			DictgroupDAO dao = (DictgroupDAO) DAOFactory.build(DictgroupDAO.class, user);
			return (DictgroupVO) dao.update(vo);
		} catch (Exception e) {
			throw new JOPException(e);
		}
	}

}
