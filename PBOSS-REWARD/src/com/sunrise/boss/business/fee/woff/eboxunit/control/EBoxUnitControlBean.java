package com.sunrise.boss.business.fee.woff.eboxunit.control;

import java.io.Serializable;
import java.util.Iterator;

import com.sunrise.boss.business.common.managelog.persistent.ManageLogDAO;
import com.sunrise.boss.business.common.managelog.persistent.OperAction;
import com.sunrise.boss.business.common.managelog.persistent.OperState;
import com.sunrise.boss.business.fee.print.billebox.persistent.BillEboxDAO;
import com.sunrise.boss.business.fee.print.billebox.persistent.BillEboxListVO;
import com.sunrise.boss.business.fee.print.billebox.persistent.BillEboxVO;
import com.sunrise.boss.business.fee.woff.eboxunit.persistent.EBoxUnitDAO;
import com.sunrise.boss.business.fee.woff.eboxunit.persistent.EBoxUnitVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: EBoxUnitControlBean</p>
 * <p>Description: 帐本科目业务处理类ControlBean </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author xiefufeng
 * @version 1.0
 */

/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/fee/woff/eboxunit/control/EBoxUnitControlBean"
 *           name="EBoxUnitControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class EBoxUnitControlBean extends AbstractControlBean implements
		EBoxUnitControl {

	/**
	 * 添加帐本科目,并添加帐单项目与帐本科目对应关系,登记日志
	 * 
	 * @param EBoxUnitVO
	 *            帐本科目信息
	 * @param BillEboxVO
	 *            帐单项目与帐本科目对应关系
	 * @param User
	 *            用户信息
	 * @return EBoxUnitVO 帐本科目信息
	 * @throws BusinessException
	 */
	public EBoxUnitVO doCreateWithManageLog(EBoxUnitVO vo, BillEboxVO billvo,
			User user) throws BusinessException {
		ManageLogDAO mdao = (ManageLogDAO) DAOFactory.build(ManageLogDAO.class,
				user.getCityid());
		EBoxUnitDAO edao = (EBoxUnitDAO) DAOFactory.build(EBoxUnitDAO.class,
				user.getCityid());
		BillEboxDAO bdao = (BillEboxDAO) DAOFactory.build(BillEboxDAO.class,
				user.getCityid());
		try {
			vo = (EBoxUnitVO) edao.create(vo);
			mdao.manageLog(user, vo.getClass().getName(), OperAction.INSERT,
					null, vo, OperState.SUCCESS);

			if (billvo != null) {
				bdao.create(billvo);
				mdao.manageLog(user, billvo.getClass().getName(),
						OperAction.INSERT, null, billvo, OperState.SUCCESS);
			}
			return vo;
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw new BusinessException(ex.getMessage(), "create");
		}
	}

	/**
	 * 删除帐本科目,并删除其对应的帐单项目与帐本科目对应表记录,登记日志
	 * 
	 * @param pk
	 *            帐本科目标识
	 * @param user
	 *            用户信息
	 * @throws BusinessException
	 */
	public void doRemoveByPkWithManageLog(Serializable pk, User user)
			throws BusinessException {
		ManageLogDAO mdao = (ManageLogDAO) DAOFactory.build(ManageLogDAO.class,
				user.getCityid());
		EBoxUnitDAO edao = (EBoxUnitDAO) DAOFactory.build(EBoxUnitDAO.class,
				user.getCityid());
		BillEboxDAO bdao = (BillEboxDAO) DAOFactory.build(BillEboxDAO.class,
				user.getCityid());
		try {
			EBoxUnitVO vo = (EBoxUnitVO) edao.findByPk(pk);
			mdao.manageLog(user, vo.getClass().getName(), OperAction.DELETE,
					vo, null, OperState.SUCCESS);
			edao.removeByPk(pk);

			// 获取帐本科目标识[delid]对应的帐单项目与帐本科目对应表记录,并将其删除
			BillEboxVO billvo = null;
			BillEboxListVO lsvo = new BillEboxListVO();
			lsvo.set_pagesize("0");
			lsvo.set_ne_eboxunitid(pk.toString());
			Iterator it = bdao.query(lsvo, false).getDatas().iterator();
			while (it != null && it.hasNext()) {
				billvo = (BillEboxVO) it.next();
				mdao.manageLog(user, billvo.getClass().getName(),
						OperAction.DELETE, billvo, null, OperState.SUCCESS);
				bdao.remove(billvo);
			}

		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw new BusinessException(ex.getMessage(), "remove");
		}
	}

	/**
	 * 更新帐本科目,并登记日志
	 * 
	 * @param EBoxUnitVO
	 *            帐本科目信息
	 * @param User
	 *            用户信息
	 * @return EBoxUnitVO 帐本科目信息
	 * @throws BusinessException
	 */
	public EBoxUnitVO doUpdateWithManageLog(EBoxUnitVO vo, User user)
			throws BusinessException {
		ManageLogDAO mdao = (ManageLogDAO) DAOFactory.build(ManageLogDAO.class,
				user.getCityid());
		// BaseDAO ordinaryDAO = new BaseDAO(EBoxUnitVO.class,user.getCityid());
		// change by liwenjing
		BaseDAO ordinaryDAO = DAOFactory.build(EBoxUnitDAO.class, user);

		try {
			mdao.manageLog(user, vo.getClass().getName(), OperAction.UPDATE,
					null, vo, OperState.SUCCESS);
			vo = (EBoxUnitVO) ordinaryDAO.update(vo);
			return vo;
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw new BusinessException(ex.getMessage(), "update");
		}
	}

	public Object doFindByPk(Serializable pk, Class voClass, User user)
			throws Exception {
		// BaseDAO ordinaryDAO = new BaseDAO(voClass,user.getCityid());
		// change by liwenjing
		EBoxUnitDAO edao = (EBoxUnitDAO) DAOFactory.build(EBoxUnitDAO.class,
				user);
		return edao.findByPk(pk);
	}

	//判断帐本科目状态是否可用 暂时只返回true
	public boolean doCheck(Long pk, User user) throws Exception {

		EBoxUnitDAO edao = (EBoxUnitDAO) DAOFactory.build(EBoxUnitDAO.class,
				user);
		EBoxUnitVO vo = (EBoxUnitVO) edao.findByPk(pk);
		if (vo.getEboxunitstate().shortValue() == 1) {
			return true;
		} else {
			return false;
		}

//		return true;
	}
}
