/**
 * auto-generated code
 * Thu Sep 17 15:16:11 CST 2009
 */
package com.gmcc.pboss.control.promotion.ppzlncom;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.ppzlncom.PpzlncomDBParam;
import com.gmcc.pboss.business.promotion.ppzlncom.PpzlncomDAO;
import com.gmcc.pboss.business.promotion.ppzlncom.PpzlncomVO;
import com.gmcc.pboss.control.promotion.ppzlncom.PpzlncomBO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: PpzlncomBO
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
 * @author LiZhaoLiang
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/jop/business/promotion/ppzlncom/control/PpzlncomBO"
 *           name="Ppzlncom" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class PpzlncomBO extends AbstractControlBean implements Ppzlncom {

	public PpzlncomVO doCreate(PpzlncomVO vo) throws Exception {
		try {
			PpzlncomDAO dao = (PpzlncomDAO) DAOFactory.build(PpzlncomDAO.class,
					user);
			// TODO set the pk */
			return (PpzlncomVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(PpzlncomVO vo) throws Exception {
		try {
			PpzlncomDAO dao = (PpzlncomDAO) DAOFactory.build(PpzlncomDAO.class,
					user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			PpzlncomDAO dao = (PpzlncomDAO) DAOFactory.build(PpzlncomDAO.class,
					user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PpzlncomVO doUpdate(PpzlncomVO vo) throws Exception {
		try {
			PpzlncomDAO dao = (PpzlncomDAO) DAOFactory.build(PpzlncomDAO.class,
					user);
			return (PpzlncomVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}
	
	/**
	 * 获取促销与商品的vo
	 */
	public PpzlncomVO doFindByVO(PpzlncomVO vo) throws Exception {
		PpzlncomDBParam params = new PpzlncomDBParam();
		PpzlncomBO ppzlncomBO = (PpzlncomBO) BOFactory.build(PpzlncomBO.class,
				user);
		params.set_se_comcategory(vo.getComcategory());
		params.set_se_pid(vo.getPid().toString());

		DataPackage dp = ppzlncomBO.doQuery(params);
		if (dp != null && dp.getDatas().size() > 0) {
			vo = (PpzlncomVO) dp.getDatas().get(0);
		} else {
			vo = null;
		}
		return vo;
	}

	public PpzlncomVO doFindByPk(Serializable pk) throws Exception {
		PpzlncomDAO dao = (PpzlncomDAO) DAOFactory.build(PpzlncomDAO.class,
				user);
		return (PpzlncomVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(PpzlncomDBParam params) throws Exception {
		PpzlncomDAO dao = (PpzlncomDAO) DAOFactory.build(PpzlncomDAO.class,
				user);
		return dao.query(params);
	}
}
