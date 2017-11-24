package com.gmcc.pboss.control.base.operinfo;

import java.io.Serializable;

import com.gmcc.pboss.business.base.operator.OperatorDAO;
import com.gmcc.pboss.business.base.operinfo.OperinfoDAO;
import com.gmcc.pboss.business.base.operinfo.OperinfoDBParam;
import com.gmcc.pboss.business.base.operinfo.OperinfoVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
/**
 * @ejb.bean local-jndi-name="com/gmcc/pboss/control/base/operinfo/OperinfoBO"
 *           name="Operinfo" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class OperinfoBO extends AbstractControlBean implements Operinfo{

	public OperinfoVO doCreate(OperinfoVO vo) throws Exception {
		try {
			OperinfoDAO dao = (OperinfoDAO) DAOFactory.build(OperinfoDAO.class, user);
			return (OperinfoVO) dao.create(vo);
		} catch (Exception e) {
			throw new JOPException(e);
		}
	}

	public OperinfoVO doFindByPk(Serializable pk) throws Exception {
		OperinfoDAO dao = (OperinfoDAO) DAOFactory.build(OperinfoDAO.class,
				user);
		return (OperinfoVO) dao.findByPk(pk);
		
	}

	

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			OperinfoDAO dao = (OperinfoDAO) DAOFactory.build(OperinfoDAO.class, user);
			dao.removeByPk(pk);
		} catch (Exception e) {
			throw new JOPException(e);
		}
		
	}

	public void doRemoveByVO(OperinfoVO vo) throws Exception {
		try {
			OperinfoDAO dao = (OperinfoDAO) DAOFactory.build(OperinfoDAO.class, user);
			dao.remove(vo);
		} catch (Exception e) {
			throw new JOPException(e);
		}
		
	}

	public OperinfoVO doUpdate(OperinfoVO vo) throws Exception {
		try {
			OperinfoDAO dao = (OperinfoDAO) DAOFactory.build(OperinfoDAO.class, user);
			return (OperinfoVO) dao.update(vo);
		} catch (Exception e) {
			throw new JOPException(e);
		}
	}

	public DataPackage doQuery(OperinfoDBParam params) throws Exception {
		OperinfoDAO dao = (OperinfoDAO) DAOFactory.build(OperinfoDAO.class,
				user);
		return dao.query(params);
	}

}
