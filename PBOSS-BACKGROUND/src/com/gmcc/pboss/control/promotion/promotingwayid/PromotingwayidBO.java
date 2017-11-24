/**
 * auto-generated code
 * Tue Sep 15 10:39:05 CST 2009
 */
package com.gmcc.pboss.control.promotion.promotingwayid;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import open.tool.rule.data.VO;

import com.gmcc.pboss.business.promotion.elmttmpl.DefaultVO;
import com.gmcc.pboss.business.promotion.promotingwayid.PromotingwayidDAO;
import com.gmcc.pboss.business.promotion.promotingwayid.PromotingwayidDBParam;
import com.gmcc.pboss.business.promotion.promotingwayid.PromotingwayidVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: PromotingwayidBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name=
 *           "com/sunrise/jop/business/promotions/promotingwayid/control/PromotingwayidBO"
 *           name="Promotingwayid" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class PromotingwayidBO extends AbstractControlBean implements
		Promotingwayid {

	public PromotingwayidVO doCreate(PromotingwayidVO vo)
			throws Exception {
		try {
			PromotingwayidDAO dao = (PromotingwayidDAO) DAOFactory.build(
					PromotingwayidDAO.class, user);
			// TODO set the pk */
			return (PromotingwayidVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(PromotingwayidVO vo)
			throws Exception {
		try {
			PromotingwayidDAO dao = (PromotingwayidDAO) DAOFactory.build(
					PromotingwayidDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			PromotingwayidDAO dao = (PromotingwayidDAO) DAOFactory.build(
					PromotingwayidDAO.class, user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PromotingwayidVO doUpdate(PromotingwayidVO vo)
			throws Exception {
		try {
			PromotingwayidDAO dao = (PromotingwayidDAO) DAOFactory.build(
					PromotingwayidDAO.class, user);
			return (PromotingwayidVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PromotingwayidVO doFindByPk(Serializable pk)
			throws Exception {
		PromotingwayidDAO dao = (PromotingwayidDAO) DAOFactory.build(
				PromotingwayidDAO.class, user);
		return (PromotingwayidVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(PromotingwayidDBParam params)
			throws Exception {
		PromotingwayidDAO dao = (PromotingwayidDAO) DAOFactory.build(
				PromotingwayidDAO.class, user);
		return dao.query(params);
	}

	public Map<VO, Object> filterDataByPfrtMode(Map<VO, Object> srcData,
			String pfrtMode, long pid, long ruleid)
			throws Exception {
		PromotingwayidDAO dao = (PromotingwayidDAO) DAOFactory.build(
				PromotingwayidDAO.class, user);
		PromotingwayidDBParam pwParam = new PromotingwayidDBParam();
		if ("0".equals(pfrtMode)) {
			// »¥³â
			pwParam.set_ne_pid(String.valueOf(pid));
		} else {
			// ¹²Ïí
			pwParam.set_ne_pid(String.valueOf(pid));
			pwParam.set_ne_ruleid(String.valueOf(ruleid));
		}

		List<PromotingwayidVO> proWays = new ArrayList<PromotingwayidVO>(
				dao.query(pwParam).getDatas());
		if (proWays != null && proWays.size() > 0) {
			Map<String,String> wayIdMap = new HashMap<String,String>();
			for (PromotingwayidVO pwVo : proWays) {
				wayIdMap.put(pwVo.getWayid(),"");
			}
			Set<VO> keys = srcData.keySet();
			Iterator<VO> keysIt = keys.iterator();
			while (keysIt.hasNext()) {
				DefaultVO vo = (DefaultVO) keysIt.next();
				HashMap<String, ?> voKeys = vo.getKeys();
				if (voKeys.containsKey("WAYID")) {
					String wayId = (String) voKeys.get("WAYID");
					if (wayIdMap.containsKey(wayId)) {
						keysIt.remove();
					}
				}
			}
		}
		return srcData;
	}

}
