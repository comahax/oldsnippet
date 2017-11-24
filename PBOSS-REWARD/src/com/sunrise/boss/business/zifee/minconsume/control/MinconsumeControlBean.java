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
						"ϵͳ�Ѵ���һ��'�������������'Ϊ-1���Żݼ�¼�������޸�'�������������'Ϊ���ڵ���1��ɾ���ü�¼��Ȼ���ٽ���������");
			}
			if (vo.getEffectiveinterval() != null) {
				int interval = calcResult("" + vo.getYxplanid(), user);
				if (interval > vo.getEffectiveinterval().intValue()) {
					throw new Exception("�޸�[��Чʱ����]������ڵ���ϵͳĬ�ϼ��������ֵ!");
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
						"����ʧ�ܣ��޸ĺ��������ĵ���Чʱ����Ӧ��С�ڵ��ں����¼�����ݿ��е���Чʱ����!");
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
				throw new Exception("δ��ȡ��ֵ!");
			}
		}
		return result;
	}

	/**
	 * ���������¼���滹�м�¼,�򷵻�true,������ɾ��
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
				throw new Exception("������û��ȡ������ֵ");
			}
		} else {
			return -1;
		}
	}

	/**
	 * ��ѯ>��ǰPK��ֵ��
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
