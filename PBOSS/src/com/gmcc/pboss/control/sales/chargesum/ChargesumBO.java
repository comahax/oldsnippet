/**
 * auto-generated code
 * Tue Oct 13 09:30:24 CST 2009
 */
package com.gmcc.pboss.control.sales.chargesum;

import java.io.Serializable;
import java.util.Map;

import com.gmcc.pboss.business.sales.chargesum.ChargesumDAO;
import com.gmcc.pboss.business.sales.chargesum.ChargesumDBParam;
import com.gmcc.pboss.business.sales.chargesum.ChargesumVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ChargesumBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ChargesumBO extends AbstractControlBean implements
		Chargesum {

	public ChargesumVO doCreate(ChargesumVO vo) throws Exception {
		try {
			ChargesumDAO dao = (ChargesumDAO) DAOFactory.build(ChargesumDAO.class, user);
			// TODO set the pk */
			return (ChargesumVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ChargesumVO vo) throws Exception {
		try {
			ChargesumDAO dao = (ChargesumDAO) DAOFactory.build(ChargesumDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ChargesumDAO dao = (ChargesumDAO) DAOFactory.build(ChargesumDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ChargesumVO doUpdate(ChargesumVO vo) throws Exception {
		try {
			ChargesumDAO dao = (ChargesumDAO) DAOFactory.build(ChargesumDAO.class,user);
			return (ChargesumVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ChargesumVO doFindByPk(Serializable pk) throws Exception {
		ChargesumDAO dao = (ChargesumDAO) DAOFactory.build(ChargesumDAO.class,user);
		return (ChargesumVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ChargesumDBParam params) throws Exception {
		ChargesumDAO dao = (ChargesumDAO) DAOFactory.build(ChargesumDAO.class,user);
		return dao.query(params);
	}

	public DataPackage doQueryChargesum(Map<String,String> conditionMap, ChargesumDBParam param) throws Exception {
		ChargesumDAO dao = (ChargesumDAO) DAOFactory.build(ChargesumDAO.class,user);
		return dao.doQueryChargesum(conditionMap,param);
	}
	
}
