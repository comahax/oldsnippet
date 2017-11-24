/**
 * auto-generated code
 * Sat Jan 13 14:53:14 CST 2007
 */
package com.sunrise.boss.business.zifee.yxplangpinf.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.yxplangpinf.persistent.YxplangpinfVO;
import com.sunrise.boss.business.zifee.yxplangpinf.persistent.YxplangpinfDAO;
import com.sunrise.boss.business.zifee.yxplangpinf.persistent.YxplangpinfListVO;
import com.sunrise.boss.business.zifee.yxplangroup.persistent.YxPlanGroupListVO;
import com.sunrise.boss.business.zifee.yxplangroup.control.YxPlanGroupControl;
import com.sunrise.boss.business.zifee.yxplangroup.control.YxPlanGroupControlBean;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.exception.delegate.DelegateException;

/**
 * <p>
 * Title: YxplangpinfControlBean
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
 * @author Danny(luozhoujie)
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/zifee/yxplangpinf/control/YxplangpinfControlBean"
 *           name="YxplangpinfControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class YxplangpinfControlBean extends AbstractControlBean implements
		YxplangpinfControl {

	public YxplangpinfVO doCreate(YxplangpinfVO vo, User user) throws Exception {
		try {
			YxplangpinfDAO dao = (YxplangpinfDAO) DAOFactory.build(
					YxplangpinfDAO.class, user);
			if (null == vo.getAreacode()
					|| !vo.getAreacode().trim().equalsIgnoreCase(
							user.getCityid().trim())) {
				throw new BusinessException("",
						"新增失败,当前营销方案分组的区域标识为空或与当前工号所在区域标识不一致");
			}
			// TODO set the pk */
			return (YxplangpinfVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(YxplangpinfVO vo, User user) throws Exception {
		try {
			YxplangpinfDAO dao = (YxplangpinfDAO) DAOFactory.build(
					YxplangpinfDAO.class, user);
			if (null == vo.getGroupid())
				throw new BusinessException("", "删除营销方案分组时出错，营销方案分组标识为空");
			Long pk = vo.getGroupid();
			if (null == vo.getAreacode()
					|| !vo.getAreacode().trim().equalsIgnoreCase(
							user.getCityid().trim())) {
				throw new BusinessException("",
						"删除营销方案分组标识失败,当前营销方案分组区域标识为空或与当前工号所在区域标识不一致,不允许删除");
			}
			YxPlanGroupListVO groupMemListVO = new YxPlanGroupListVO();
			groupMemListVO.set_ne_groupyxplan(pk.toString());
			YxPlanGroupControl yxPlanGroupControl = (YxPlanGroupControl) ControlFactory
					.build(YxPlanGroupControlBean.class);
			if (null == yxPlanGroupControl) {
				throw new DelegateException(this.getClass()
						+ " initialize failed");
			}
			DataPackage groupMemVO = yxPlanGroupControl.doQuery(groupMemListVO,
					user);
			if (null != groupMemVO && groupMemVO.getRowCount() > 0) {
				String msginf = "不允许删除，营销方案分组标识[" + pk
						+ "]下存在成员营销方案，请先删除成员营销方案再删除营销方案分组";
				throw new BusinessException("", msginf);
			}
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public YxplangpinfVO doUpdate(YxplangpinfVO vo, User user) throws Exception {
		try {
			YxplangpinfDAO dao = (YxplangpinfDAO) DAOFactory.build(
					YxplangpinfDAO.class, user);
			if (null == vo.getAreacode()
					|| !vo.getAreacode().trim().equalsIgnoreCase(
							user.getCityid().trim())) {
				throw new BusinessException("",
						"修改失败,当前营销方案分组的区域标识为空或与当前工号所在区域标识不一致，不允许修改");
			}
			return (YxplangpinfVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public YxplangpinfVO doFindByPk(Serializable pk, User user)
			throws Exception {
		YxplangpinfDAO dao = (YxplangpinfDAO) DAOFactory.build(
				YxplangpinfDAO.class, user);
		return (YxplangpinfVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(YxplangpinfListVO params, User user)
			throws Exception {
		YxplangpinfDAO dao = (YxplangpinfDAO) DAOFactory.build(
				YxplangpinfDAO.class, user);
		return dao.query(params);
	}
}
