/**
 * auto-generated code
 * Wed Nov 14 16:51:17 CST 2007
 */
package com.sunrise.boss.business.zifee.feediscmonth.control;

import java.io.Serializable;

import com.sunrise.boss.business.zifee.feediscmonth.persistent.FeediscmonthDAO;
import com.sunrise.boss.business.zifee.feediscmonth.persistent.FeediscmonthListVO;
import com.sunrise.boss.business.zifee.feediscmonth.persistent.FeediscmonthVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: FeediscmonthControlBean
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
 * @author zeng jianxin
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/zifee/feediscmonth/control/FeediscmonthControlBean"
 *           name="FeediscmonthControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class FeediscmonthControlBean extends AbstractControlBean implements
		FeediscmonthControl {

	public FeediscmonthVO doCreate(FeediscmonthVO vo, User user)
			throws Exception {
		try {
			// TODO set the pk */
			FeediscmonthDAO dao = (FeediscmonthDAO) DAOFactory.build(
					FeediscmonthDAO.class, user);
			// �Ż�����Ϊ���ۿۡ�ʱ�Ż�ֵֻ������0-100֮�䣬�����ʾҪ���Ż�ֵת��Ϊ��
			if (vo.getDisctype().intValue() == 30) {
				if (vo.getDiscvalue().intValue() < 0
						|| vo.getDiscvalue().intValue() > 100) {
					throw new BusinessException("",
							"����ʧ�ܣ��Ż�����Ϊ'�ۿ�'ʱ���Ż�ֵ������0��100֮��!");
				}
			} else {
				vo.setDiscvalue(new Double(
						vo.getDiscvalue().doubleValue() * 100));
			}
			// ���ڡ���ͨ���ס�����ǿ�Ʊ��ס��͡��ⶥ��3���Ż����ͣ�ǰ̨����ֻ������ͬһ��Ӫ������������һ��
			if (vo.getDisctype().intValue() == 10
					|| vo.getDisctype().intValue() == 11
					|| vo.getDisctype().intValue() == 20) {
				FeediscmonthListVO listvo = new FeediscmonthListVO();
				listvo.set_ne_yxplanid(vo.getYxplanid().toString());
				listvo.set_ne_disctype(vo.getDisctype().toString());

				if (dao.query(listvo).getDatas().size() != 0) {
					throw new BusinessException("",
							"����ʧ��:�Ѿ����ڸ����͵��Żݼ�¼�����Ż�����ֻ��������һ��!");
				}
			}

			return (FeediscmonthVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(FeediscmonthVO vo, User user) throws Exception {
		try {
			FeediscmonthDAO dao = (FeediscmonthDAO) DAOFactory.build(
					FeediscmonthDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public FeediscmonthVO doUpdate(FeediscmonthVO vo, User user)
			throws Exception {
		try {
			FeediscmonthDAO dao = (FeediscmonthDAO) DAOFactory.build(
					FeediscmonthDAO.class, user);
			if (vo.getDisctype().intValue() == 30) {
				if (vo.getDiscvalue().intValue() < 0
						|| vo.getDiscvalue().intValue() > 100) {
					throw new BusinessException("",
							"����ʧ�ܣ��Ż�����Ϊ'�ۿ�'ʱ���Ż�ֵ������0��100֮��!");
				}
			} else {
				vo.setDiscvalue(new Double(
						vo.getDiscvalue().doubleValue() * 100));
			}
			// ���ڡ���ͨ���ס�����ǿ�Ʊ��ס��͡��ⶥ��3���Ż����ͣ�ǰ̨����ֻ������ͬһ��Ӫ������������һ��
			if (vo.getDisctype().intValue() == 10
					|| vo.getDisctype().intValue() == 11
					|| vo.getDisctype().intValue() == 20) {
				FeediscmonthListVO listvo = new FeediscmonthListVO();
				listvo.set_ne_yxplanid(vo.getYxplanid().toString());
				listvo.set_ne_disctype(vo.getDisctype().toString());

				if (dao.query(listvo).getDatas().size() != 0) {
					throw new BusinessException("",
							"����ʧ��:�Ѿ����ڸ����͵��Żݼ�¼�����Ż�����ֻ��������һ��!");
				}
			}

			return (FeediscmonthVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public FeediscmonthVO doFindByPk(Serializable pk, User user)
			throws Exception {
		FeediscmonthDAO dao = (FeediscmonthDAO) DAOFactory.build(
				FeediscmonthDAO.class, user);
		return (FeediscmonthVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(FeediscmonthListVO params, User user)
			throws Exception {
		FeediscmonthDAO dao = (FeediscmonthDAO) DAOFactory.build(
				FeediscmonthDAO.class, user);
		if (!"".equals(params.get_sk_discbill())
				&& params.get_sk_discbill() != null) {
			params.set_sk_discbill(params.get_sk_discbill()
					.replaceAll(" ", "%"));
		}
		if (!"".equals(params.get_sk_excludebill())
				&& params.get_sk_excludebill() != null) {
			params.set_sk_excludebill(params.get_sk_excludebill().replaceAll(
					" ", "%"));
		}
		return dao.query(params);
	}

}
