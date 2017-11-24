/**
 * auto-generated code
 * Tue Jun 29 12:02:04 CST 2010
 */
package com.gmcc.pboss.control.channel.empmodel;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.empmodel.EmpmodelDBParam;
import com.gmcc.pboss.business.channel.empmodel.EmpmodelDAO;
import com.gmcc.pboss.business.channel.empmodel.EmpmodelVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: EmpmodelBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author zhangsiwei
 * @version 1.0
 */
public class EmpmodelBO extends AbstractControlBean implements
		Empmodel {

	public EmpmodelVO doCreate(EmpmodelVO vo) throws Exception {
		try {
			EmpmodelDAO dao = (EmpmodelDAO) DAOFactory.build(EmpmodelDAO.class, user);
			// TODO set the pk */
			return (EmpmodelVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}
	
	public EmpmodelVO doCreateNoSeq(EmpmodelVO vo) throws Exception {
		try {
			EmpmodelDAO dao = (EmpmodelDAO) DAOFactory.build(EmpmodelDAO.class, user);
			// 人员工作模式标识*/
			String seq = ""+dao.getSequence("CH_PW_EMPMODEL_SEQ");
			vo.setEmpmodelid(Long.valueOf(seq));
			return (EmpmodelVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(EmpmodelVO vo) throws Exception {
		try {
			EmpmodelDAO dao = (EmpmodelDAO) DAOFactory.build(EmpmodelDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			EmpmodelDAO dao = (EmpmodelDAO) DAOFactory.build(EmpmodelDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public EmpmodelVO doUpdate(EmpmodelVO vo) throws Exception {
		try {
			EmpmodelDAO dao = (EmpmodelDAO) DAOFactory.build(EmpmodelDAO.class,user);
			return (EmpmodelVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public EmpmodelVO doFindByPk(Serializable pk) throws Exception {
		EmpmodelDAO dao = (EmpmodelDAO) DAOFactory.build(EmpmodelDAO.class,user);
		return (EmpmodelVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(EmpmodelDBParam params)
			throws Exception {
		EmpmodelDAO dao = (EmpmodelDAO) DAOFactory.build(EmpmodelDAO.class,user);
		return dao.query(params);
	}
}
