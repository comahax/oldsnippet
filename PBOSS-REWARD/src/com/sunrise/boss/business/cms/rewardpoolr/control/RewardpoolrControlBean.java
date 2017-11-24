/**
 * auto-generated code
 * Fri Feb 01 18:16:01 CST 2008
 */
package com.sunrise.boss.business.cms.rewardpoolr.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sunrise.boss.business.cms.rewardpoolr.persistent.RewardpoolrDAO;
import com.sunrise.boss.business.cms.rewardpoolr.persistent.RewardpoolrListVO;
import com.sunrise.boss.business.cms.rewardpoolr.persistent.RewardpoolrVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: RewardpoolrControlBean
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/rewardpoolr/control/RewardpoolrControlBean"
 *           name="RewardpoolrControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class RewardpoolrControlBean extends AbstractControlBean implements
		RewardpoolrControl {

	public RewardpoolrVO doCreate(RewardpoolrVO vo, User user) throws Exception {
		try {
			// TODO set the pk */
			RewardpoolrDAO dao = (RewardpoolrDAO) DAOFactory.build(
					RewardpoolrDAO.class, user);
			return (RewardpoolrVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(RewardpoolrVO vo, User user) throws Exception {
		try {
			RewardpoolrDAO dao = (RewardpoolrDAO) DAOFactory.build(
					RewardpoolrDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public RewardpoolrVO doUpdate(RewardpoolrVO vo, User user) throws Exception {
		try {
			RewardpoolrDAO dao = (RewardpoolrDAO) DAOFactory.build(
					RewardpoolrDAO.class, user);
			return (RewardpoolrVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public RewardpoolrVO doFindByPk(Serializable pk, User user)
			throws Exception {
		RewardpoolrDAO dao = (RewardpoolrDAO) DAOFactory.build(
				RewardpoolrDAO.class, user);
		return (RewardpoolrVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(RewardpoolrListVO params, User user)
			throws Exception {
		RewardpoolrDAO dao = (RewardpoolrDAO) DAOFactory.build(
				RewardpoolrDAO.class, user);
		String strtmp;
		DataPackage pack = (DataPackage) dao.query(params);
		List list1 = new ArrayList();
		List list2 = new ArrayList();
		List list = pack.toList(RewardpoolrVO.class);
		Iterator c = list.iterator();
		while (c.hasNext()) {
			String str = null;
			StringBuffer str1 = new StringBuffer();
			str = ((RewardpoolrVO) c.next()).getSlv();
			for (int i = 0; i < str.length(); i++) {
				if ("1".equals(str.substring(i, i + 1))) {
					str1.append(i + 1 + "ÐÇ¼¶" + ",");
				}
			}
			str = str1.toString();
			if(str.indexOf(",") != -1) {
				str = str.substring(0, str.lastIndexOf(","));
			}
			list1.add(str);
		}
		int i = 0;
		Iterator t = list.iterator();
		while (t.hasNext()) {
			((RewardpoolrVO) t.next()).setSlv((String) list1.get(i));
			i++;
		}
		Iterator tt = list.iterator();
		while (tt.hasNext()) {
			list2.add((RewardpoolrVO) tt.next());
		}
		pack.setDatas(list2);
		return pack;
	}
}
