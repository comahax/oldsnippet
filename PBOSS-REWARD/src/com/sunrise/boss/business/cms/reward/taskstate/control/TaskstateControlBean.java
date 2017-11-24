/**
 * auto-generated code
 * Thu Aug 20 16:16:16 CST 2009
 */
package com.sunrise.boss.business.cms.reward.taskstate.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.cms.reward.taskstate.RegionData;
import com.sunrise.boss.ui.cms.reward.taskstate.StatusBean;
import com.sunrise.boss.business.cms.reward.taskstate.persistent.TaskstateVO;
import com.sunrise.boss.business.cms.reward.taskstate.persistent.TaskstateDAO;
import com.sunrise.boss.business.cms.reward.taskstate.persistent.TaskstateListVO;
import com.sunrise.boss.business.fee.acccounting.control.AccountingUtils;

/**
 * <p>
 * Title: TaskstateControlBean
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
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/reward/taskstate/control/TaskstateControlBean"
 *           name="TaskstateControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class TaskstateControlBean extends AbstractControlBean implements
		TaskstateControl {

	public TaskstateVO doCreate(TaskstateVO vo, User user) throws Exception {
		try {
			TaskstateDAO dao = (TaskstateDAO) DAOFactory.build(
					TaskstateDAO.class, user);
			// TODO set the pk */
			return (TaskstateVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public String[] doShow(TaskstateListVO params) throws Exception {

		String[] states = new String[15];
		String city = SessionFactoryRouter.conversionCityid2Num(params
				.get_se_cityid());
		String[] taskid = { "900002", "900001", "50", "910001", "910002",
				"910003", "260", "250", "240", "270", "601", "602", "604",
				"606", "9600" };
		String[] ownertaskid = { "900000", "900000", "900001", "900001",
				"900002", "900002", "900002", "900002", "900002", "900002",
				"900002", "900002", "900002", "900002", "900002" };

		for (int i = 0; i < taskid.length; i++) {
			List list = new ArrayList();

			try {
				queryStat(params, list, ownertaskid[i], taskid[i], city);
			} catch (Exception e) {
				e.printStackTrace();
			}
			states[i] = chkState(list);
		}
		return states;
	}

	private void queryStat(TaskstateListVO params, List list,
			String ownertaskid, String taskid, String city) throws Exception {
		TaskstateVO vo = queryVO(ownertaskid, taskid, params
				.get_se_rewardmonth(), city);
		if (vo == null) {
			list.add(new Short("0"));
		} else {
			if (vo.getState().intValue() < -1 || vo.getState().intValue() > 3) {
				list.add(new Short("0"));
			} else {
				list.add(vo.getState());
			}
		}
	}

	public TaskstateVO queryVO(String ownertaskid, String taskid,
			String rewardmonth, String cityid) throws Exception {

		TaskstateDAO dao = (TaskstateDAO) DAOFactory.build(TaskstateDAO.class,
				AccountingUtils.getCityid(cityid));
		TaskstateListVO listVO = new TaskstateListVO();
		listVO.set_se_rewardmonth(rewardmonth);
		listVO.set_se_ownertaskid(ownertaskid);
		listVO.set_se_taskid(taskid);

		listVO.set_se_cityid(cityid);
		DataPackage dp = dao.query(listVO, false);
		if (dp == null || dp.getDatas() == null || dp.getDatas().size() == 0) {
			return null;
		} else {
			TaskstateVO vo = (TaskstateVO) dp.toList(TaskstateVO.class).get(0);
			return vo;
		}
	}

	public String chkState(List list) {
		String state = "0";
		StringBuffer _strBState = new StringBuffer();
		if (null != list) {

			for (int i = 0; i < list.size(); i++) {
				Object ob = (Object) list.get(i);
				String _state = ob.toString();
				_strBState.append(_state);
				return _state;
			}
		}
		return state;
	}

	/**
	 * 查询子任务
	 */
	public List showProc(TaskstateListVO params) throws Exception {
		String city = SessionFactoryRouter.conversionCityid2Num(params
				.get_se_cityid());
		String[] taskid = params.get_se_taskid().split(",");
		String rewardmonth = params.get_se_rewardmonth();
		List list = new ArrayList();
		RegionData databean = new RegionData();
		List statuslist = new ArrayList();
		StatusBean bean = new StatusBean();
		bean.setStepname(taskid[0] + taskid[1]);
		bean.setSubphase(new Long(taskid[1]));
		TaskstateVO vo = queryVO(taskid[0], taskid[1], rewardmonth, city);
		if (vo == null) {
			bean.setStatus(new Short("0"));
		} else if (vo.getState().intValue() > 3
				|| vo.getState().intValue() < -1) {
			bean.setStatus(new Short("0"));
		} else {
			bean.setStatus(vo.getState());
			bean.setMainState(vo.getState());
		}
		
		statuslist.add(bean);

		for (int j = 2; j < taskid.length; j++) {
			try {
				StatusBean sbean = new StatusBean();
				sbean.setStepname(taskid[1] + taskid[j]);
				sbean.setSubphase(new Long(taskid[j]));
				vo = queryVO(taskid[1], taskid[j], rewardmonth, city);
				if (vo == null) {
					sbean.setStatus(new Short("0"));
				} else if (vo.getState().intValue() > 3
						|| vo.getState().intValue() < 0) {
					sbean.setStatus(new Short("0"));
				} else {
					sbean.setStatus(vo.getState());
				}
				statuslist.add(sbean);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		databean.setRegion(city);
		databean.setStatusdata(statuslist);
		list.add(databean);

		return list;
	}

	public void doRemove(TaskstateVO vo, User user) throws Exception {
		try {
			TaskstateDAO dao = (TaskstateDAO) DAOFactory.build(
					TaskstateDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public TaskstateVO doUpdate(TaskstateVO vo, User user) throws Exception {
		try {
			TaskstateDAO dao = (TaskstateDAO) DAOFactory.build(
					TaskstateDAO.class, user);
			return (TaskstateVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public TaskstateVO doFindByPk(Serializable pk, User user) throws Exception {
		TaskstateDAO dao = (TaskstateDAO) DAOFactory.build(TaskstateDAO.class,
				user);
		return (TaskstateVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(TaskstateListVO params, User user)
			throws Exception {
		TaskstateDAO dao = (TaskstateDAO) DAOFactory.build(TaskstateDAO.class,
				user);
		return dao.query(params);
	}
}
