/**
 * auto-generated code
 * Tue Sep 18 15:52:13 CST 2007
 */
package com.sunrise.boss.business.zifee.yxplanpresnt.control;

import java.io.Serializable;

import com.sunrise.boss.business.fee.woff.acct.persistent.AcctDAO;
import com.sunrise.boss.business.fee.woff.acct.persistent.AcctVO;
import com.sunrise.boss.business.fee.woff.eboxunit.persistent.EBoxUnitDAO;
import com.sunrise.boss.business.fee.woff.eboxunit.persistent.EBoxUnitVO;
import com.sunrise.boss.business.zifee.yxplanpresnt.persistent.YxplanpresntDAO;
import com.sunrise.boss.business.zifee.yxplanpresnt.persistent.YxplanpresntListVO;
import com.sunrise.boss.business.zifee.yxplanpresnt.persistent.YxplanpresntVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: YxplanpresntControlBean
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
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/zifee/yxplanpresnt/control/YxplanpresntControlBean"
 *           name="YxplanpresntControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class YxplanpresntControlBean extends AbstractControlBean implements
		YxplanpresntControl {

	public YxplanpresntVO doCreate(YxplanpresntVO vo, User user)
			throws Exception {
		try {
			// TODO set the pk */
			doCheckAcctid(vo, user);
			doCheckEboxunit(vo, user);

			doCheckCreate(vo, user);

			YxplanpresntDAO dao = (YxplanpresntDAO) DAOFactory.build(
					YxplanpresntDAO.class, user);
			return (YxplanpresntVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(YxplanpresntVO vo, User user) throws Exception {
		try {
			YxplanpresntDAO dao = (YxplanpresntDAO) DAOFactory.build(
					YxplanpresntDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public YxplanpresntVO doUpdate(YxplanpresntVO vo, User user)
			throws Exception {
		try {

			doCheckEboxunit(vo, user);

			YxplanpresntControl yxplanpresntcontrol = (YxplanpresntControl) ControlFactory
					.build(YxplanpresntControlBean.class);

			YxplanpresntVO pkvo = new YxplanpresntVO();
			pkvo.setYxplanid(vo.getYxplanid());
			pkvo.setPresentinterval(vo.getPresentinterval());
			pkvo.setAcctid(vo.getAcctid());
			YxplanpresntVO vo2 = (YxplanpresntVO) yxplanpresntcontrol
					.doFindByPk(pkvo, user);

			// 修改帐本科目
			EBoxUnitDAO eboxUnitDAO = (EBoxUnitDAO) DAOFactory.build(
					EBoxUnitDAO.class, user);
			EBoxUnitVO eboxUnitVO = new EBoxUnitVO();

			if (vo.getEboxunitid() != null) {
				eboxUnitVO = (EBoxUnitVO) eboxUnitDAO.findByPk(vo
						.getEboxunitid());
			}
			if (vo != null && vo2 != null) {
				if (!vo.getEboxunitid().equals(vo2.getEboxunitid())) {
					if (eboxUnitVO != null) {
						if (eboxUnitVO.getEboxunitstate() != null) {
							int flag = 1;
							if (flag != eboxUnitVO.getEboxunitstate()
									.intValue()) {
								throw new BusinessException("", "保存失败：账本科目已禁用");
							}
						} else {
							throw new BusinessException("",
									"修改记录出错：查不到相关的[帐本科目]状态]");
						}
					} else {
						throw new BusinessException("", "修改记录出错：[帐本科目标识]不存在");
					}
				}

			}

			YxplanpresntDAO dao = (YxplanpresntDAO) DAOFactory.build(
					YxplanpresntDAO.class, user);
			BeanUtils.copyProperties(vo2, vo);
			YxplanpresntVO yxplanpresntVO = (YxplanpresntVO) dao.update(vo2);
			return yxplanpresntVO;
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public YxplanpresntVO doFindByPk(Serializable pk, User user)
			throws Exception {
		YxplanpresntDAO dao = (YxplanpresntDAO) DAOFactory.build(
				YxplanpresntDAO.class, user);
		return (YxplanpresntVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(YxplanpresntListVO params, User user)
			throws Exception {
		YxplanpresntDAO dao = (YxplanpresntDAO) DAOFactory.build(
				YxplanpresntDAO.class, user);
		return dao.query(params);
	}

	/**
	 * 逻辑检查
	 * 
	 * @param vo
	 * @param user
	 */
	private void doCheckAcctid(YxplanpresntVO vo, User user) throws Exception {
		if (vo.getAcctid() == null || "".equals(vo.getAcctid()))
			throw new BusinessException("", "错误:要进行逻辑检查的值为空:"
					+ "vo.getAcctid()");
		AcctDAO dao = (AcctDAO) DAOFactory.build(AcctDAO.class, user);
		AcctVO acctVO = (AcctVO) dao.findByPk(vo.getAcctid());
		if (acctVO == null) {
			throw new BusinessException("", "[目标帐单科目标识]应是帐单科目表中存在的值!");
		}
	}

	private void doCheckEboxunit(YxplanpresntVO vo, User user) throws Exception {
		if (vo.getEboxunitid() == null || "".equals(vo.getEboxunitid()))
			throw new BusinessException("", "错误:要进行逻辑检查的值为空:"
					+ "vo.getEboxunitid()");
		EBoxUnitDAO dao = (EBoxUnitDAO) DAOFactory.build(EBoxUnitDAO.class,
				user);
		EBoxUnitVO acctVO = (EBoxUnitVO) dao.findByPk(vo.getEboxunitid());
		if (acctVO == null) {
			throw new Exception("[到达账本科目标识]应是库表中存在的值!");
		}

	}

	/**
	 * 新增帐本科目&帐单科目逻辑检查
	 * 
	 * @param vo
	 * @param user
	 */
	private void doCheckCreate(YxplanpresntVO vo, User user) throws Exception {// 检查
		// [帐单科目状态]是否为可用[1]
		AcctDAO acctDAO = (AcctDAO) DAOFactory.build(AcctDAO.class, user);
		AcctVO acctVO = new AcctVO();
		if (vo.getAcctid() != null) {
			acctVO = (AcctVO) acctDAO.findByPk(vo.getAcctid());
		}

		if (acctVO != null)

			if (acctVO.getAcctstate() != null) {
				int flag = 1;
				if (flag != acctVO.getAcctstate().intValue()) {
					throw new BusinessException("", "保存失败：账单科目已禁用");
				}
			}
		// 检查 [帐本科目状态]是否为可用[1]
		EBoxUnitDAO eboxUnitDAO = (EBoxUnitDAO) DAOFactory.build(
				EBoxUnitDAO.class, user);
		EBoxUnitVO eboxUnitVO = new EBoxUnitVO();
		if (vo.getAcctid() != null) {
			eboxUnitVO = (EBoxUnitVO) eboxUnitDAO.findByPk(vo.getEboxunitid());
		}

		if (eboxUnitVO != null)

			if (eboxUnitVO.getEboxunitstate() != null) {
				int flag = 1;
				if (flag != eboxUnitVO.getEboxunitstate().intValue()) {
					throw new BusinessException("", "保存失败：账本科目已禁用");
				}
			}
	}
}
