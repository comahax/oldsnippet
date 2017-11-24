/**
 * auto-generated code
 * Thu Sep 17 15:17:36 CST 2009
 */
package com.gmcc.pboss.control.promotion.ppzlnres;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.ppzlnres.PpzlnresDAO;
import com.gmcc.pboss.business.promotion.ppzlnres.PpzlnresDBParam;
import com.gmcc.pboss.business.promotion.ppzlnres.PpzlnresVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: PpzlnresBO
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
 * @ejb.bean local-jndi-name="com/sunrise/jop/business/promotion/ppzlnres/control/PpzlnresBO"
 *           name="Ppzlnres" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class PpzlnresBO extends AbstractControlBean implements Ppzlnres {

	public PpzlnresVO doCreate(PpzlnresVO vo) throws Exception {
		try {
			PpzlnresDAO dao = (PpzlnresDAO) DAOFactory.build(PpzlnresDAO.class,
					user);
			// TODO set the pk */
			return (PpzlnresVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(PpzlnresVO vo) throws Exception {
		try {
			PpzlnresDAO dao = (PpzlnresDAO) DAOFactory.build(PpzlnresDAO.class,
					user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			PpzlnresDAO dao = (PpzlnresDAO) DAOFactory.build(PpzlnresDAO.class,
					user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PpzlnresVO doUpdate(PpzlnresVO vo) throws Exception {
		try {
			PpzlnresDAO dao = (PpzlnresDAO) DAOFactory.build(PpzlnresDAO.class,
					user);
			return (PpzlnresVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PpzlnresVO doFindByPk(Serializable pk) throws Exception {
		PpzlnresDAO dao = (PpzlnresDAO) DAOFactory.build(PpzlnresDAO.class,
				user);
		return (PpzlnresVO) dao.findByPk(pk);
	}
	
	/**
	 * 获取促销与资源的vo
	 */
	public PpzlnresVO doFindByVO(PpzlnresVO vo) throws Exception {
		PpzlnresDBParam params = new PpzlnresDBParam();
		PpzlnresBO ppzlnresBO = (PpzlnresBO) BOFactory.build(
				PpzlnresBO.class, user);
		params.set_se_resid(vo.getResid());
		params.set_ne_pid(vo.getPid().toString());

		DataPackage dp = ppzlnresBO.doQuery(params);
		if (dp != null && dp.getDatas().size() > 0) {
			vo = (PpzlnresVO) dp.getDatas().get(0);
		} else {
			vo = null;
		}
		return vo;
	}

	public DataPackage doQuery(PpzlnresDBParam params) throws Exception {
		PpzlnresDAO dao = (PpzlnresDAO) DAOFactory.build(PpzlnresDAO.class,
				user);
		return dao.query(params);
	}

	public DataPackage doQueryComcategory(PpzlnresDBParam param)
			throws Exception {
		PpzlnresDAO dao = (PpzlnresDAO) DAOFactory.build(PpzlnresDAO.class,
				user);
		return dao.doQueryComcategory(param);
	}
}
