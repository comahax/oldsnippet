/**
 * auto-generated code
 * Sun Feb 01 17:08:50 CST 2009
 */
package com.sunrise.boss.business.cms.stdrewardhz.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.stdreward.persistent.StdrewardDAO;
import com.sunrise.boss.business.cms.stdreward.persistent.StdrewardVO;
import com.sunrise.boss.business.cms.stdrewardhz.persistent.StdrewardhzVO;
import com.sunrise.boss.business.cms.stdrewardhz.persistent.StdrewardhzDAO;
import com.sunrise.boss.business.cms.stdrewardhz.persistent.StdrewardhzListVO;

/**
 * <p>
 * Title: StdrewardhzControlBean
 * </p>
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
 * @author Linli
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/stdrewardhz/control/StdrewardhzControlBean"
 *           name="StdrewardhzControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class StdrewardhzControlBean extends AbstractControlBean implements
		StdrewardhzControl {

	private static Log log = LogFactory.getLog(StdrewardhzControlBean.class);

	public StdrewardhzVO doCreate(StdrewardhzVO vo, User user) throws Exception {
		try {
			StdrewardhzDAO dao = (StdrewardhzDAO) DAOFactory.build(
					StdrewardhzDAO.class, user);
			// TODO set the pk */
			return (StdrewardhzVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(StdrewardhzVO vo, User user) throws Exception {
		try {
			StdrewardDAO dao = (StdrewardDAO) DAOFactory.build(
					StdrewardDAO.class, user);
			StdrewardVO stdrewardvo = (StdrewardVO) dao.findByPk(vo
					.getRewardid());
			if (null != stdrewardvo) {
				dao.remove(stdrewardvo);
			}
			StdrewardhzListVO listvo = new StdrewardhzListVO();
			listvo.set_ne_rewardid(vo.getRewardid().toString());
			Iterator it = doQuery(listvo, user).getDatas().iterator();
			Session session = SessionUtil.currentSession(dao.getDbFlag());
			while (it.hasNext()) {
				Object ob = it.next();
				session.clear();
				session.evict(ob);
				dao.remove(ob);
			}
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public StdrewardhzVO doUpdate(StdrewardhzVO vo, User user) throws Exception {
		try {
			StdrewardhzDAO dao = (StdrewardhzDAO) DAOFactory.build(
					StdrewardhzDAO.class, user);
			return (StdrewardhzVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public StdrewardhzVO doFindByPk(Serializable pk, User user)
			throws Exception {
		StdrewardhzDAO dao = (StdrewardhzDAO) DAOFactory.build(
				StdrewardhzDAO.class, user);
		return (StdrewardhzVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(StdrewardhzListVO params, User user)
			throws Exception {
		StdrewardhzDAO dao = (StdrewardhzDAO) DAOFactory.build(
				StdrewardhzDAO.class, user);
		return dao.query(params);
	}

	/**
	 * 单次事务的提交,包括存储STDREWARDHZ,临时列表
	 * @param stdrewardvo
	 * @param oldList
	 * @param newList
	 * @param isCity
	 * @returns
	 */
	public StdrewardVO doSave(StdrewardVO stdrewardvo, List oldList,
			List newList, boolean isCity, User user) throws Exception {

		List oldStarList = new ArrayList();
		List newStarList = new ArrayList();
		oldStarList.addAll(oldList);
		newStarList.addAll(newList);

		try {
			// 判断是省页面还是市页面,如果是市页面就不用再存储STDREWARDVO
			if (isCity == false) {
				StdrewardDAO dao = (StdrewardDAO) DAOFactory.build(
						StdrewardDAO.class, user);
				if (null == stdrewardvo.getRewardid()) {
					stdrewardvo = (StdrewardVO) dao.create(stdrewardvo);
				} else {
					stdrewardvo = (StdrewardVO) dao.update(stdrewardvo);
				}
			}

			StdrewardhzDAO hzdao = (StdrewardhzDAO) DAOFactory.build(
					StdrewardhzDAO.class, user);

			// 处理临时列表最原始列表
			Iterator newItt2 = newStarList.iterator();
			while (newItt2.hasNext()) {
				StdrewardhzVO compvo = (StdrewardhzVO) newItt2.next();
				if (compvo.getRewardid() == null) {
					continue;
				}
				if (oldStarList.contains(compvo)) {
					oldStarList.remove(compvo);
				}
			}
			Iterator oldItt = oldStarList.iterator();
			while (oldItt.hasNext()) {
				StdrewardhzVO vo = (StdrewardhzVO) oldItt.next();
				hzdao.remove(vo);
			}

			// 处理临时列表最新列表
			Iterator newItt = newStarList.iterator();
			while (newItt.hasNext()) {
				StdrewardhzVO vo = (StdrewardhzVO) newItt.next();
				if (vo.getRewardid() == null) {
					vo.setRewardid(stdrewardvo.getRewardid());
					hzdao.create(vo);
				} else {
					if (StringUtils.isNotEmpty(vo.getState())) {
						vo.setRewardid(stdrewardvo.getRewardid());
						hzdao.update(vo);
					}
				}
				vo.setState(null);
			}

			return stdrewardvo;

		} catch (Exception e) {
			sessionContext.setRollbackOnly();
			log.warn(e.getMessage());
		}
		return null;
	}

	public String doQueryHealth(User user) throws Exception {
		StdrewardhzDAO dao = (StdrewardhzDAO) DAOFactory.build(
				StdrewardhzDAO.class, user);
		return dao.doQueryHealth(user);
	}
}
