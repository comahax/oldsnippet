/**
 * auto-generated code
 * Sun Jan 04 10:44:26 CST 2009
 */
package com.sunrise.boss.business.cms.reward.busiwayrel.control;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.cms.reward.busiwayrel.BusiwayrelBatchCheck;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.busiwayrel.persistent.BusiwayrelVO;
import com.sunrise.boss.business.cms.reward.busiwayrel.persistent.BusiwayrelDAO;
import com.sunrise.boss.business.cms.reward.busiwayrel.persistent.BusiwayrelListVO;

/**
 * <p>
 * Title: BusiwayrelControlBean
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
 * @author LiZhaoLiang
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/reward/busiwayrel/control/BusiwayrelControlBean"
 *           name="BusiwayrelControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class BusiwayrelControlBean extends AbstractControlBean implements BusiwayrelControl {
	private static final Log log = LogFactory.getLog(BusiwayrelBatchCheck.class);

	public BusiwayrelVO doCreate(BusiwayrelVO vo, User user) throws Exception {
		try {
			BusiwayrelDAO dao = (BusiwayrelDAO) DAOFactory.build(BusiwayrelDAO.class, user);
			// TODO set the pk */
			return (BusiwayrelVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(BusiwayrelVO vo, User user) throws Exception {
		try {
			BusiwayrelDAO dao = (BusiwayrelDAO) DAOFactory.build(BusiwayrelDAO.class, user);
			dao.remove(vo);

		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public BusiwayrelVO doUpdate(BusiwayrelVO vo, User user) throws Exception {
		try {
			BusiwayrelDAO dao = (BusiwayrelDAO) DAOFactory.build(BusiwayrelDAO.class, user);
			return (BusiwayrelVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public BusiwayrelVO doFindByPk(Serializable pk, User user) throws Exception {
		BusiwayrelDAO dao = (BusiwayrelDAO) DAOFactory.build(BusiwayrelDAO.class, user);
		return (BusiwayrelVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(BusiwayrelListVO params, User user) throws Exception {
		BusiwayrelDAO dao = (BusiwayrelDAO) DAOFactory.build(BusiwayrelDAO.class, user);
		return dao.query(params);
	}

	/**
	 * ����Ƿ�Ϊ���,���Ϊ�����������
	 * 
	 * @param vo
	 * @param user
	 * @throws Exception
	 */
	public String doBatchCreate(BusiwayrelVO vo, User user) throws Exception {
		StringBuffer resultstr = new StringBuffer("");
		try {
			if (checkIsLayer(vo.getOpnid(), user)) {
				String dp[] = queryLayer(vo.getOpnid(), user);
				if (dp != null && dp.length > 0) {
					resultstr.append("\n\t�ò��").append(vo.getOpnid()).append("��������������")
							.append("\n");
					for (int i = 0; i < dp.length; i++) {
						String opnid = dp[i];
						BusiwayrelVO newVO=new BusiwayrelVO();
						if (opnid != null) {
							newVO.setOpnid(opnid);
							newVO.setWayid(vo.getWayid());
						}
						if (canBeCreate(newVO, user)) {
							doCreate(newVO, user);
							resultstr.append("\t\t\t").append(opnid).append("|").append(
									newVO.getWayid()).append("\t�����ɹ�\n");
						} else {
							resultstr.append("\t\t\t").append(opnid).append("|").append(
									newVO.getWayid()).append("\tҪ�����������Ѿ�����");
						}

					}
				}
			} else {
				doCreate(vo, user);
			}
			// TODO set the pk */
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
		return resultstr.toString();
	}

	/**
	 * ����Ƿ�Ϊ���,���Ϊ�������ɾ��
	 * 
	 * @param vo
	 * @param user
	 * @throws Exception
	 */
	public String doBatchRemove(BusiwayrelVO vo, User user) throws Exception {
		StringBuffer resultstr = new StringBuffer("");
		try {

			BusiwayrelListVO listVO = new BusiwayrelListVO();
			listVO.set_se_opnid(vo.getOpnid());
			if (checkIsLayer(vo.getOpnid(), user)) {
				String dp[] = queryLayer(listVO.get_se_opnid(), user);
				if (dp != null && dp.length > 0) {
					resultstr.append("\n\t�ò��").append(vo.getOpnid()).append("����ɾ��������")
							.append("\n");
					for (int i = 0; i < dp.length; i++) {
						String opnid = dp[i];
						BusiwayrelVO delVO=new BusiwayrelVO();
						if (opnid != null) {
							delVO.setOpnid(opnid);
							delVO.setWayid(vo.getWayid());
						}
						if (canBeRemove(delVO, user)) {
							doRemove(delVO, user);
							resultstr.append("\t\t\t").append(opnid).append("|").append(
									vo.getWayid()).append("\tɾ���ɹ�\n");
						} else {
							resultstr.append("\t\t\t").append(opnid).append("|").append(
									delVO.getWayid()).append("\tҪɾ���ļ�¼�Ѿ�����");
						}
					}
				}
			} else {
				doRemove(vo, user);
			}
			// TODO set the pk */
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
		return resultstr.toString();
	}

	/**
	 * ������/ɾ��֮ǰ�Ƿ��Ѿ�����
	 * 
	 * @param isCreate
	 * @return
	 */
	private boolean canBeCreate(BusiwayrelVO vo, User user) throws Exception {
		BusiwayrelDAO dao = (BusiwayrelDAO) DAOFactory.build(BusiwayrelDAO.class, user);
		Object obj = dao.findByPk(vo);
		return obj == null;
	}

	/**
	 * ������/ɾ��֮ǰ�Ƿ��Ѿ�����
	 * 
	 * @param isCreate
	 * @return
	 */
	private boolean canBeRemove(BusiwayrelVO vo, User user) throws Exception {
		BusiwayrelDAO dao = (BusiwayrelDAO) DAOFactory.build(BusiwayrelDAO.class, user);
		Object obj = dao.findByPk(vo);
		return obj != null;
	}

	/**
	 * 
	 * @param listVO
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean checkIsLayer(String opnid, User user) throws Exception {
		boolean result = false;
		DataPackage dp = null;
		BusiwayrelDAO dao = (BusiwayrelDAO) DAOFactory.build(BusiwayrelDAO.class, user);
		BusiwayrelListVO listVO = new BusiwayrelListVO();
		listVO.getQueryConditions().put("opnid", opnid);
		dp = dao.queryCountByNamedSqlQuery("cms.busiwayrel.checkIsLayer", listVO);
		result = dp.getRowCount() == 1;
		if (log.isInfoEnabled() && result) {
			log.info("ok:queryed 1 record");
		}
		return result;
	}

	/***************************************************************************
	 * 
	 * @param listVO
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public String[] queryLayer(String opnid, User user) throws Exception {
		BusiwayrelDAO dao = (BusiwayrelDAO) DAOFactory.build(BusiwayrelDAO.class, user);
		// String sql="select opnid,'' wayid from (select opnid,isbusi from
		// common.ch_pw_operation b start with opnid=:oopnid connect by prior
		// opnid=parentid ) a where a.isbusi=1";
		String[] res = dao.getOpnid(opnid, "cms.busiwayrel.queryLayer");
		if (res == null && log.isErrorEnabled()) {
			log.error("oh,no opnid find,null datas ");
		}
		if (res != null && log.isInfoEnabled()) {
			log.info("query count:" + res.length);
		}
		return res;
	}

	public static void main(String[] args) {

	}
}
