/**
 * auto-generated code
 * Sun Feb 03 10:40:37 CST 2008
 */
package com.sunrise.boss.business.cms.reward.citydata.control;

import java.io.Serializable;

import com.sunrise.boss.business.admin.operator.control.OperatorControl;
import com.sunrise.boss.business.admin.operator.control.OperatorControlBean;
import com.sunrise.boss.business.cms.employee.control.EmployeeControl;
import com.sunrise.boss.business.cms.employee.control.EmployeeControlBean;
import com.sunrise.boss.business.cms.employee.persistent.EmployeeListVO;
import com.sunrise.boss.business.cms.operation.control.OperationControl;
import com.sunrise.boss.business.cms.operation.control.OperationControlBean;
import com.sunrise.boss.business.cms.operation.persistent.OperationListVO;
import com.sunrise.boss.business.cms.reward.citydata.persistent.CitydataDAO;
import com.sunrise.boss.business.cms.reward.citydata.persistent.CitydataListVO;
import com.sunrise.boss.business.cms.reward.citydata.persistent.CitydataVO;
import com.sunrise.boss.business.cms.way.control.WayControl;
import com.sunrise.boss.business.cms.way.control.WayControlBean;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: CitydataControlBean
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
 * @author Cai Jianhui
 * @version 1.0
 * 
 * modify by Zhang Fengchao 2008-03-17: Add the method clearAll()
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/reward/citydata/control/CitydataControlBean"
 *           name="CitydataControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class CitydataControlBean extends AbstractControlBean implements
		CitydataControl {

	public CitydataVO doCreate(CitydataVO vo, User user) throws Exception {
		try {
			// TODO set the pk */
			CitydataDAO dao = (CitydataDAO) DAOFactory.build(CitydataDAO.class,
					user);
			OperationControl operationControl = (OperationControl) ControlFactory
					.build(OperationControlBean.class);
			WayControl wayControl = (WayControl) ControlFactory
					.build(WayControlBean.class);
			OperatorControl operatorControl = (OperatorControl) ControlFactory
					.build(OperatorControlBean.class);
			EmployeeControl employeeControl = (EmployeeControl) ControlFactory
					.build(EmployeeControlBean.class);

			OperationListVO listVO = new OperationListVO();
			listVO.set_se_opnid(vo.getOpnid());
			listVO.getQueryConditions().put("_ne_isbusi", "1");
			if (operationControl.doQuery(listVO, user).getRowCount() == 0) {
				throw new Exception("发生业务编码：" + vo.getOpnid() + "不存在");
			}

			if (vo.getWayid() != null
					&& wayControl.doFindByPk(vo.getWayid(), user) == null) {
				throw new Exception("业务发生渠道编码：" + vo.getWayid() + "不存在");
			}

			if (vo.getOprcode() != null && vo.getOprcode().trim().length() > 0) {
				if (operatorControl.doFindByPk(vo.getOprcode(), user) == null) {
					throw new Exception("业务发生工号(BOSS工号)：" + vo.getOprcode()
							+ "不存在");
				} else {
					EmployeeListVO employeeListVO = new EmployeeListVO();
					employeeListVO.getQueryConditions().put("_se_oprcode2",
							vo.getOprcode());
					employeeListVO.getQueryConditions().put("_se_wayid",
							vo.getWayid());
					if (employeeControl.doQuery(employeeListVO, user)
							.getRowCount() == 0) {
						throw new Exception("业务发生工号(BOSS工号)：" + vo.getOpnid()
								+ "在系统中登记的对应渠道是ch_pw_employee的wayid，不是“业务发生渠道”");
					}
				}
			}

			if (!SessionFactoryRouter.conversionCityid(user.getCityid())
					.equals(vo.getCityid())) {
				throw new Exception("地市标识与当前登录工号所在地市不符");
			}
			return (CitydataVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(CitydataVO vo, User user) throws Exception {
		try {
			CitydataDAO dao = (CitydataDAO) DAOFactory.build(CitydataDAO.class,
					user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public CitydataVO doUpdate(CitydataVO vo, User user) throws Exception {
		try {
			CitydataDAO dao = (CitydataDAO) DAOFactory.build(CitydataDAO.class,
					user);
			return (CitydataVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public CitydataVO doFindByPk(Serializable pk, User user) throws Exception {
		CitydataDAO dao = (CitydataDAO) DAOFactory.build(CitydataDAO.class,
				user);
		return (CitydataVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(CitydataListVO params, User user)
			throws Exception {
		CitydataDAO dao = (CitydataDAO) DAOFactory.build(CitydataDAO.class,
				user);
		return dao.query(params);
	}

	/**
	 * 清理库表数据
	 */
	public void clearAll(User user) throws Exception {
		try {
			CitydataDAO dao = (CitydataDAO) DAOFactory.build(CitydataDAO.class,
					user);
			dao.clearAll(user);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}
}
