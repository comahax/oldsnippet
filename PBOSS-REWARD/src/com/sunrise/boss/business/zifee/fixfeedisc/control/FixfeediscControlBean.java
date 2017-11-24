/**
 * auto-generated code
 * Thu Aug 17 16:39:40 CST 2006
 */
package com.sunrise.boss.business.zifee.fixfeedisc.control;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sunrise.boss.business.fee.woff.acct.control.AcctControl;
import com.sunrise.boss.business.fee.woff.acct.control.AcctControlBean;
import com.sunrise.boss.business.fee.woff.acct.persistent.AcctDAO;
import com.sunrise.boss.business.fee.woff.acct.persistent.AcctVO;
import com.sunrise.boss.business.zifee.fixfeedisc.persistent.PcPsFixfeediscDAO;
import com.sunrise.boss.business.zifee.fixfeedisc.persistent.PcPsFixfeediscListVO;
import com.sunrise.boss.business.zifee.fixfeedisc.persistent.PcPsFixfeediscVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: FixfeediscControlBean
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Sunrise Tech Ltd.
 * </p>
 * 
 * @author Danny(luozhoujie)
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/zifee/fixfeedisc/control/FixfeediscControlBean"
 *           name="FixfeediscControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class FixfeediscControlBean extends AbstractControlBean implements
		FixfeediscControl {
	private static Log log = LogFactory.getLog(FixfeediscControlBean.class);

	public PcPsFixfeediscVO doCreate(PcPsFixfeediscVO vo, User user)
			throws Exception {
		try {
			// 检查 [帐单科目状态]是否为可用[1]
			AcctDAO acctDAO = (AcctDAO) DAOFactory.build(AcctDAO.class, user);
			AcctVO acctVO = new AcctVO();
			if (vo.getAcctid() != null) {
				acctVO = (AcctVO) acctDAO.findByPk(vo.getAcctid());
			}

			if (acctVO != null)

				if (acctVO.getAcctstate() != null) {
					int flag = 1;
					if (flag != acctVO.getAcctstate().intValue()) {
						throw new BusinessException("", "录入记录出错：帐单科目已禁用");
					}
				}
			// TODO set the pk */
			PcPsFixfeediscDAO dao = (PcPsFixfeediscDAO) DAOFactory.build(
					PcPsFixfeediscDAO.class, user);
			// Long seq =
			// (Long)dao.getSequence("PC_PS_FIXFEEDISC_SEQ");//直接到oracle里面取seq的值
			// vo.setFixfeediscid(seq);
			return (PcPsFixfeediscVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(PcPsFixfeediscVO vo, User user) throws Exception {
		try {
			PcPsFixfeediscDAO dao = (PcPsFixfeediscDAO) DAOFactory.build(
					PcPsFixfeediscDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public PcPsFixfeediscVO doUpdate(PcPsFixfeediscVO vo, User user)
			throws Exception {
		try {
			// 检查 [帐单科目状态]是否为可用[1]
			// AcctDAO acctDAO=(AcctDAO)DAOFactory.build(AcctDAO.class, user);

			AcctControl acctcontrol = (AcctControl) ControlFactory
					.build(AcctControlBean.class);
			AcctVO acctVO = (AcctVO) acctcontrol.doFindByPk(vo.getAcctid(),
					user);

			FixfeediscControl control = (FixfeediscControl) ControlFactory
					.build(FixfeediscControlBean.class);
			PcPsFixfeediscVO vo2 = (PcPsFixfeediscVO) control.doFindByPk(vo
					.getFixfeediscid(), user);

			if (vo != null && vo2 != null) {
				if (!vo.getAcctid().equals(vo2.getAcctid())) {
					if (acctVO != null) {
						if (acctVO.getAcctstate() != null) {
							int flag = 1;
							if (flag != acctVO.getAcctstate().intValue()) {
								throw new BusinessException("",
										"修改记录出错：帐单科目已禁用");
							}
						} else {
							throw new BusinessException("",
									"修改记录出错：查不到相关的[帐单科目状态]");
						}
					} else {
						throw new BusinessException("", "修改记录出错：[帐单科目标识]不存在");
					}
				}

			}
			PcPsFixfeediscDAO dao = (PcPsFixfeediscDAO) DAOFactory.build(
					PcPsFixfeediscDAO.class, user);
			BeanUtils.copyProperties(vo2, vo);
			PcPsFixfeediscVO fixfeediscvo = (PcPsFixfeediscVO) dao.update(vo2);
			return fixfeediscvo;
		} catch (Exception e) {
			log.error(e);
			sessionContext.setRollbackOnly();
			throw e;
		}
	}

	public PcPsFixfeediscVO doFindByPk(Serializable pk, User user)
			throws Exception {
		PcPsFixfeediscDAO dao = (PcPsFixfeediscDAO) DAOFactory.build(
				PcPsFixfeediscDAO.class, user);
		return (PcPsFixfeediscVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(PcPsFixfeediscListVO params, User user)
			throws Exception {
		PcPsFixfeediscDAO dao = (PcPsFixfeediscDAO) DAOFactory.build(
				PcPsFixfeediscDAO.class, user);
		return dao.query(params);
	}
}
