/**
 * auto-generated code
 * Thu Aug 20 16:16:16 CST 2009
 */
package com.sunrise.boss.ui.cms.reward.taskstate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.reward.montask.persistent.MontaskListVO;
import com.sunrise.boss.business.cms.reward.taskstate.persistent.TaskstateListVO;
import com.sunrise.boss.business.cms.reward.taskstate.persistent.TaskstateVO;
import com.sunrise.boss.business.rightmanage.operright.persistent.OperrightListVO;
import com.sunrise.boss.business.rightmanage.operright.persistent.OperrightVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.common.utils.export.ExcelCodeToName;
import com.sunrise.boss.delegate.cms.provincialright.ProvincialrightDelegate;
import com.sunrise.boss.delegate.cms.reward.montask.MontaskDelegate;
import com.sunrise.boss.delegate.cms.reward.taskstate.TaskstateDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.pub.tools.LoggerUtils;

/**
 * <p>Title: TaskstateAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class TaskstateAction extends BaseAction {

	private Logger log = Logger.getLogger(TaskstateAction.class);

	public TaskstateAction() {
		setVoClass(TaskstateVO.class);
		// TODO: 给出主键的名字数组
		this.pkNameArray = new String[4];
		pkNameArray[0] = "cityid";
		pkNameArray[1] = "ownertaskid";
		pkNameArray[2] = "rewardmonth";
		pkNameArray[3] = "taskid";
	}

	/**
	 * 设置社会渠道酬金过程监控查询条件
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doSet(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		TaskstateForm form = (TaskstateForm) actionForm;
		try {

			if (StringUtils.isEmpty(form.getYear())
					|| StringUtils.isEmpty(form.getMonth())) {
				Calendar c = Calendar.getInstance();
				c.add(Calendar.MONTH, -1);
				Date d = c.getTime();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
				String date = sdf.format(d);
				form.setYear(date.substring(0, 4));
				form.setMonth(date.substring(4, 6));
			}

			ProvincialrightDelegate pdelegate = new ProvincialrightDelegate();
			CommonDelegate odelegate = new CommonDelegate(OperrightVO.class);
			OperrightListVO olistvo = new OperrightListVO();
			olistvo.set_se_operid(user.getOpercode());
			olistvo.set_se_rightid("CH_PW_REWARD_MON");
			DataPackage dp = odelegate.doQuery(olistvo, user);
			
			
			if ((!pdelegate.checkPurview(user, "CH_PW_REWARD_MON")||(dp==null && dp.getDatas().size()==0))) {
				form.set_se_cityid(SessionFactoryRouter.conversionCityid(user
						.getCityid()));
			}
			request.setAttribute("_se_cityid", form.get_se_cityid());
			request.setAttribute("_se_rewardmonth", form.get_se_rewardmonth());
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			LoggerUtils.error(e, log);
			return (actionMapping.findForward("set"));

		}
		return (actionMapping.findForward("set"));
	}

	/**
	 * 显示查询结果状态
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			TaskstateForm form = (TaskstateForm) actionForm;
			SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
			if (!StringUtils.isEmpty(form.get_se_rewardmonth())
					&& !StringUtils.isEmpty(form.get_se_cityid())
					&& form.get_se_cityid().trim().length() > 0) {

				String rewardmont = format.format(TaskstateAction
						.getDefaultDate(-1));
				String currMonth = format.format(TaskstateAction
						.getDefaultDate(0));
				if (Integer.parseInt(form.get_se_rewardmonth()) > Integer
						.parseInt(rewardmont)) {
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							"只允许查询当前结算月[" + currMonth + "]之前的出酬过程!");
					form.set_se_rewardmonth("");
					return (actionMapping.findForward("show"));
				} else {
					TaskstateListVO listVO = new TaskstateListVO();
					BeanUtils.copyProperties(listVO, form);
					TaskstateDelegate delegate = new TaskstateDelegate();
					String[] result = delegate.doShow(listVO);
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST,
							result);
				}
			}
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			LoggerUtils.error(e, log);
		}

		return (actionMapping.findForward("show"));
	}

	/**
	 * 显示子任务状态
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doShowproc(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		TaskstateForm form = (TaskstateForm) actionForm;
		TaskstateListVO listVO = new TaskstateListVO();
		BeanUtils.copyProperties(listVO, form);
		String taskid = request.getParameter("_TASKID");
		String rewardmonth = request.getParameter("_REWARDMONTH");
		String cityid = request.getParameter("_CITYID");
		String ownertaskid = request.getParameter("_OWNERTASKID");
		try {
			if (null != taskid && !"".equals(taskid)) {
				form.setTaskid(taskid);
				listVO.set_se_taskid(taskid);//这里的taskid要在controlbean中做拆分
			} else {
				listVO.set_se_taskid(form.getTaskid());
			}
			if (null != rewardmonth && !"".equals(rewardmonth)) {
				form.setRewardmonth(rewardmonth);
				listVO.set_se_rewardmonth(rewardmonth);
			} else {
				listVO.set_se_rewardmonth(form.getRewardmonth());
			}
			if (null != cityid && !"".equals(cityid)) {
				form.setCityid(SessionFactoryRouter
						.conversionCityid2Num(cityid));
				listVO.set_se_cityid(SessionFactoryRouter
						.conversionCityid2Num(cityid));
			} else {
				listVO.set_se_cityid(SessionFactoryRouter
						.conversionCityid2Num(form.get_se_cityid()));
			}
			if (null != ownertaskid && !"".equals(ownertaskid)) {
				form.setOwnertaskid(ownertaskid);
				listVO.set_se_ownertaskid(ownertaskid);
			} else {
				listVO.set_se_ownertaskid(form.getOwnertaskid());
			}

			TaskstateDelegate delegate = new TaskstateDelegate();
			List list = delegate.showProc(listVO);

			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return actionMapping.findForward("proc");
	}

	public ActionForward doShowlog(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			String steps = request.getParameter("_TASKID");
			String ownertaskid = steps.substring(0, 6);
			String taskid = steps.substring(6, steps.length());
			String region = request.getParameter("_REGION");
			String rewardmonth = request.getParameter("_REWARDMONTH");
			String rewardmonth0 = rewardmonth + "00";

			CommonDelegate delegate = new CommonDelegate(TaskstateVO.class);
			TaskstateListVO listVO = new TaskstateListVO();
			listVO.set_se_ownertaskid(ownertaskid);
			listVO.set_se_taskid(taskid);
			listVO.set_se_rewardmonth(rewardmonth);
			listVO.set_se_cityid(region);
			User newuser = new User();
			newuser.setCityid(region);
			
		    //当任务为业务数据采集清洗校验时, 执行以下逻辑
			if (ownertaskid.toString().equals("900002")
					&& (taskid.toString().equals("910003"))) {
				MontaskListVO listvo = new MontaskListVO();
				MontaskDelegate mondelegate = new MontaskDelegate();
				DataPackage pack = mondelegate.doQuery2(listvo, rewardmonth,
						rewardmonth0, user);
				request.setAttribute("_STEPNAME", steps);
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
				return actionMapping.findForward("log1");

			} else {
				DataPackage dp = delegate.doQuery(listVO, newuser, false);
				request.setAttribute("_STEPNAME", steps);
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
				return actionMapping.findForward("log");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return null;
	}

	public ActionForward doOperlist(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		return null;
	}

	/**
	 * 启动后台程序
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doBatchstartup(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		TaskstateForm form = (TaskstateForm) actionForm;
		try {
			TaskstateListVO listVO = new TaskstateListVO();
			String[] tasksid = form.getTaskid().split(",");
			BeanUtils.copyProperties(listVO, form);
			listVO.set_se_ownertaskid(tasksid[0]);
			listVO.set_se_rewardmonth(form.get_se_rewardmonth());
			listVO.set_se_taskid(tasksid[1]);
			listVO.set_se_cityid(form.getCityid());

			ExcelCodeToName et = new ExcelCodeToName();
			String step = tasksid[0] + tasksid[1];
			String stepname = et.codeToName("#SUBTASKNAME", step, user);

			TaskstateDelegate delegate = new TaskstateDelegate();
			DataPackage dp = delegate.doQuery(listVO, user);
			if (dp.getDatas().size() > 0) {
				TaskstateVO vo = new TaskstateVO();
				vo.setState(new Short("3"));
				vo.setOwnertaskid(tasksid[0]);
				vo.setRewardmonth(form.get_se_rewardmonth());
				vo.setTaskid(tasksid[1]);
				vo.setCityid(form.getCityid());
				vo.setStarttime(new Date(System.currentTimeMillis()));
				delegate.doUpdate(vo, user);
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
						stepname + "前台启动成功!");
			} else {
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
						"未找到对应任务号");
				return actionMapping.findForward("proc");
			}

		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			e.printStackTrace();
		}
		return doShowproc(actionMapping, actionForm, request, response, user);
	}

	private static Date getDefaultDate(int i) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, i);
		return c.getTime();
	}
}
