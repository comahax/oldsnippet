/**
 * auto-generated code
 * Thu Sep 17 15:14:35 CST 2009
 */
package com.gmcc.pboss.control.promotion.ppzlnptnr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.promotion.ppzlnptnr.PpzlnptnrDBParam;
import com.gmcc.pboss.business.promotion.ppzlnptnr.PpzlnptnrDAO;
import com.gmcc.pboss.business.promotion.ppzlnptnr.PpzlnptnrVO;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: PpzlnptnrBO
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
 * @ejb.bean local-jndi-name="com/sunrise/jop/business/promotion/ppzlnptnr/control/PpzlnptnrBO"
 *           name="Ppzlnptnr" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class PpzlnptnrBO extends AbstractControlBean implements Ppzlnptnr {

	public PpzlnptnrVO doCreate(PpzlnptnrVO vo) throws Exception {
		try {
			PpzlnptnrDAO dao = (PpzlnptnrDAO) DAOFactory.build(
					PpzlnptnrDAO.class, user);
			// TODO set the pk */
			return (PpzlnptnrVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	/**
	 * 获取并返回促销与参与对象的渠道编码结果集
	 */
	public List<String> doQueryWayVo(String countyid, String starlevel)
			throws Exception {
		
		WayBO waybo = (WayBO) BOFactory.build(WayBO.class, user);
		List<String> list = new ArrayList<String>();
		WayDBParam wayparam = new WayDBParam();
		WayVO wayvo = new WayVO();
		wayparam.set_ne_starlevel(starlevel);
		wayparam.set_se_countyid(countyid);
		wayparam.set_se_waytype("AG");
		DataPackage waydp = waybo.doQuery(wayparam);
		if (waydp != null && waydp.getDatas().size() > 0) {
			int i = 0;
			for (i = 0; i < waydp.getDatas().size(); i++) {
				wayvo = (WayVO) waydp.getDatas().get(i);
				list.add(wayvo.getWayid());
			}
		}

		return list;
	}

	public void doRemoveByVO(PpzlnptnrVO vo) throws Exception {
		try {
			PpzlnptnrDAO dao = (PpzlnptnrDAO) DAOFactory.build(
					PpzlnptnrDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			PpzlnptnrDAO dao = (PpzlnptnrDAO) DAOFactory.build(
					PpzlnptnrDAO.class, user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PpzlnptnrVO doUpdate(PpzlnptnrVO vo) throws Exception {
		try {
			PpzlnptnrDAO dao = (PpzlnptnrDAO) DAOFactory.build(
					PpzlnptnrDAO.class, user);
			return (PpzlnptnrVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PpzlnptnrVO doFindByPk(Serializable pk) throws Exception {
		PpzlnptnrDAO dao = (PpzlnptnrDAO) DAOFactory.build(PpzlnptnrDAO.class,
				user);
		return (PpzlnptnrVO) dao.findByPk(pk);
	}

	/**
	 * 获取促销与参与对象的vo
	 */
	public PpzlnptnrVO doFindByVO(PpzlnptnrVO vo) throws Exception {
		PpzlnptnrDBParam params = new PpzlnptnrDBParam();
		PpzlnptnrBO ppzlnptnrBO = (PpzlnptnrBO) BOFactory.build(
				PpzlnptnrBO.class, user);
		params.set_se_wayid(vo.getWayid());
		params.set_ne_pid(vo.getPid().toString());

		DataPackage dp = ppzlnptnrBO.doQuery(params);
		if (dp != null && dp.getDatas().size() > 0) {
			vo = (PpzlnptnrVO) dp.getDatas().get(0);
		} else {
			vo = null;
		}
		return vo;
	}

	public DataPackage doQuery(PpzlnptnrDBParam params) throws Exception {
		PpzlnptnrDAO dao = (PpzlnptnrDAO) DAOFactory.build(PpzlnptnrDAO.class,
				user);
		return dao.query(params);
	}
}
