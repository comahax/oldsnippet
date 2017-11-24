/**
 * auto-generated code
 * Fri Aug 08 14:58:15 CST 2008
 */
package com.sunrise.boss.business.zifee.minconsume.control;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.minconsume.persistent.MinconsumeVO;
import com.sunrise.boss.business.zifee.minconsume.persistent.MinconsumeDAO;
import com.sunrise.boss.business.zifee.minconsume.persistent.MinconsumeListVO;

/**
 * <p>
 * Title: MinconsumeControlBean
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
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/zifee/minconsume/control/MinconsumeControlBean"
 *           name="MinconsumeControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class MinconsumeControlBean extends AbstractControlBean implements
		MinconsumeControl {

	public MinconsumeVO doCreate(MinconsumeVO vo, User user) throws Exception {
		try {
			// TODO set the pk */
			MinconsumeDAO dao = (MinconsumeDAO) DAOFactory.build(
					MinconsumeDAO.class, user);
			if (dao.hasCyclecount(String.valueOf(vo.getYxplanid()))) {
				throw new Exception(
						"系统已存在一条'最低消费周期数'为-1的优惠记录，请先修改'最低消费周期数'为大于等于1或删除该记录，然后再进行新增。");
			}
			if (vo.getEffectiveinterval() != null) {
				int interval = calcResult("" + vo.getYxplanid(), user);
				if (interval > vo.getEffectiveinterval().intValue()) {
					throw new Exception("修改[生效时间间隔]必须大于等于系统默认计算出来的值!");
				}
			}
			return (MinconsumeVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(MinconsumeVO vo, User user) throws Exception {
		try {
			MinconsumeDAO dao = (MinconsumeDAO) DAOFactory.build(
					MinconsumeDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public MinconsumeVO doUpdate(MinconsumeVO vo, User user) throws Exception {
		try {
			MinconsumeDAO dao = (MinconsumeDAO) DAOFactory.build(
					MinconsumeDAO.class, user);
			//
			int calcVAL = vo.getEffectiveinterval().intValue()
					+ (int) vo.getConsumecycle().longValue()
					* vo.getCyclecount().intValue();
			int dataVAL = getNextIntevalValue("" + vo.getYxplanid(), ""
					+ vo.getEffectiveinterval(), user);
			if (calcVAL > dataVAL && dataVAL!=-1) {
				throw new Exception(
						"保存失败，修改后计算出来的的生效时间间隔应该小于等于后面记录在数据库中的生效时间间隔!");
			}
			return (MinconsumeVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public MinconsumeVO doFindByPk(Serializable pk, User user) throws Exception {
		MinconsumeDAO dao = (MinconsumeDAO) DAOFactory.build(
				MinconsumeDAO.class, user);
		return (MinconsumeVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(MinconsumeListVO params, User user)
			throws Exception {
		MinconsumeDAO dao = (MinconsumeDAO) DAOFactory.build(
				MinconsumeDAO.class, user);
		return dao.query(params);
	}

	public boolean hasCyclecount(String yxplanid, User user) throws Exception {
		MinconsumeDAO dao = (MinconsumeDAO) DAOFactory.build(
				MinconsumeDAO.class, user);
		return dao.hasCyclecount(yxplanid);
	}

	public int calcResult(String yxplanid, User user) throws Exception {
		int result = 0;
		MinconsumeListVO listVO = new MinconsumeListVO();
		MinconsumeDAO dao = (MinconsumeDAO) DAOFactory.build(
				MinconsumeDAO.class, user);
		listVO.set_ne_yxplanid(yxplanid);
		listVO.set_desc("1");
		listVO.set_orderby("effectiveinterval");
		DataPackage dp = dao.query(listVO);
		if (dp.getRowCount() >= 1) {
			Collection col = dp.getDatas();
			Iterator it = col.iterator();
			if (it.hasNext()) {
				MinconsumeVO lastVO = (MinconsumeVO) it.next();
				result = lastVO.getEffectiveinterval().intValue()
						+ (int) lastVO.getConsumecycle().longValue()
						* lastVO.getCyclecount().intValue();
			} else {
				throw new Exception("未能取到值!");
			}
		}
		return result;
	}

	/**
	 * 如果这条记录后面还有记录,则返回true,不允许删除
	 */
	public boolean canRemove(String yxplanid, String effectiveinterval,
			User user) throws Exception {
		return queryAfterThisPK(yxplanid, effectiveinterval, user)
				.getRowCount() > 0;
	}

	/**
	 * 
	 * @param pkvalue
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int getNextIntevalValue(String yxplanid, String effectiveinterval,
			User user) throws Exception {
		DataPackage dp = queryAfterThisPK(yxplanid, effectiveinterval, user);
		if (dp.getRowCount() > 0) {
			Iterator it = dp.getDatas().iterator();
			if (it.hasNext()) {
				return ((MinconsumeVO) it.next()).getEffectiveinterval()
						.intValue();
			} else {
				throw new Exception("包里面没有取到数据值");
			}
		} else {
			return -1;
		}
	}

	/**
	 * 查询>当前PK的值集
	 * 
	 * @param pkvalue
	 * @param user
	 * @return
	 * @throws Exception
	 */
	private DataPackage queryAfterThisPK(String yxplanid,
			String effectiveinterval, User user) throws Exception {
		MinconsumeDAO dao = (MinconsumeDAO) DAOFactory.build(
				MinconsumeDAO.class, user);
		MinconsumeListVO listVO = new MinconsumeListVO();
		listVO.set_ne_yxplanid(yxplanid);
		listVO.set_nm_effectiveinterval(effectiveinterval);
		listVO.set_orderby("effectiveinterval");
		listVO.set_desc("0");
		return dao.query(listVO);
	}
}
