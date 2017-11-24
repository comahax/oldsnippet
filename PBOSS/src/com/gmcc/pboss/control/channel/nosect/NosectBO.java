/**
 * auto-generated code
 * Fri Aug 27 11:25:02 CST 2010
 */
package com.gmcc.pboss.control.channel.nosect;

import java.io.Serializable;
import java.util.Iterator;

import com.gmcc.pboss.business.channel.nosect.NosectDAO;
import com.gmcc.pboss.business.channel.nosect.NosectDBParam;
import com.gmcc.pboss.business.channel.nosect.NosectVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: NosectBO
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
 * @author Jemy
 * @version 1.0
 */
public class NosectBO extends AbstractControlBean implements Nosect {

	public NosectVO doCreate(NosectVO vo) throws Exception {
		try {
			NosectDAO dao = (NosectDAO) DAOFactory.build(NosectDAO.class, user);
			// TODO set the pk */
			return (NosectVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(NosectVO vo) throws Exception {
		try {
			NosectDAO dao = (NosectDAO) DAOFactory.build(NosectDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			NosectDAO dao = (NosectDAO) DAOFactory.build(NosectDAO.class, user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw new JOPException(ex);
		}
	}

	public NosectVO doUpdate(NosectVO vo) throws Exception {
		try {
			NosectDAO dao = (NosectDAO) DAOFactory.build(NosectDAO.class, user);
			return (NosectVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw new JOPException(ex);
		}
	}

	public NosectVO doFindByPk(Serializable pk) throws Exception {
		NosectDAO dao = (NosectDAO) DAOFactory.build(NosectDAO.class, user);
		return (NosectVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(NosectDBParam params) throws Exception {
		NosectDAO dao = (NosectDAO) DAOFactory.build(NosectDAO.class, user);
		return dao.query(params);
	}

	public String doQueryCityID(String mobileno) throws Exception {
		String bossarea = null;
		NosectDAO dao = (NosectDAO) DAOFactory.build(NosectDAO.class, user);
		NosectDBParam listVO = new NosectDBParam();
		listVO.set_snm_beginno(mobileno);
		listVO.set_snl_endno(mobileno);
		DataPackage dp = dao.query(listVO);
		if (dp.getRowCount() <= 0) {
			throw new Exception("手机号码不存在于号段表");
		} else {
			Iterator it = dp.getDatas().iterator();
			if (it.hasNext()) {
				NosectVO itVO = (NosectVO) it.next();
				if (itVO!=null && itVO.getBossarea() != null){
					bossarea = itVO.getBossarea();
				}
			}
		}

		return bossarea;
	}
}
