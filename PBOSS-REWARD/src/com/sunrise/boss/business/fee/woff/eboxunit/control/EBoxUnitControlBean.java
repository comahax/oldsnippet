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
 * <p>Description: �ʱ���Ŀҵ������ControlBean </p>
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
	 * ����ʱ���Ŀ,������ʵ���Ŀ���ʱ���Ŀ��Ӧ��ϵ,�Ǽ���־
	 * 
	 * @param EBoxUnitVO
	 *            �ʱ���Ŀ��Ϣ
	 * @param BillEboxVO
	 *            �ʵ���Ŀ���ʱ���Ŀ��Ӧ��ϵ
	 * @param User
	 *            �û���Ϣ
	 * @return EBoxUnitVO �ʱ���Ŀ��Ϣ
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
	 * ɾ���ʱ���Ŀ,��ɾ�����Ӧ���ʵ���Ŀ���ʱ���Ŀ��Ӧ���¼,�Ǽ���־
	 * 
	 * @param pk
	 *            �ʱ���Ŀ��ʶ
	 * @param user
	 *            �û���Ϣ
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

			// ��ȡ�ʱ���Ŀ��ʶ[delid]��Ӧ���ʵ���Ŀ���ʱ���Ŀ��Ӧ���¼,������ɾ��
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
	 * �����ʱ���Ŀ,���Ǽ���־
	 * 
	 * @param EBoxUnitVO
	 *            �ʱ���Ŀ��Ϣ
	 * @param User
	 *            �û���Ϣ
	 * @return EBoxUnitVO �ʱ���Ŀ��Ϣ
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

	//�ж��ʱ���Ŀ״̬�Ƿ���� ��ʱֻ����true
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
