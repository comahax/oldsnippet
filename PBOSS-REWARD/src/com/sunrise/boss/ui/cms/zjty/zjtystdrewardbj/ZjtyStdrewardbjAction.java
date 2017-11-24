package com.sunrise.boss.ui.cms.zjty.zjtystdrewardbj;


/**
 * auto-generated code
 * Tue May 01 13:34:19 CST 2007
 */


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.cms.zjty.zjtyoperation.persistent.ZjtyOperationVO;
import com.sunrise.boss.business.cms.zjty.zjtystdreward.persistent.ZjtyStdrewardVO;
import com.sunrise.boss.business.cms.zjty.zjtystdrewardbj.persistent.ZjtyStdrewardbjListVO;
import com.sunrise.boss.business.cms.zjty.zjtystdrewardbj.persistent.ZjtyStdrewardbjVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.cms.zjty.zjtyoperation.ZjtyOperationDelegate;
import com.sunrise.boss.delegate.cms.zjty.zjtystdreward.ZjtyStdrewardDelegate;
import com.sunrise.boss.delegate.cms.zjty.zjtystdrewardbj.ZjtyStdrewardbjDelegate;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.cms.zjty.constant.ZjtyRewardType;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.pub.tools.PublicUtils;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.pub.tools.StringSplit;

/**
 * <p>
 * Title: ZjtyOperationAction
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
public class ZjtyStdrewardbjAction extends BaseDelegateAction {

	// 业务归属
	public final static String BUSIBELONG = "BUSIBELONG";
	
	public final static String CARD_BUSIBELONG = "CARD"; // 标准卡业务类
	public final static String DATA_BUSIBELONG = "DATA"; // 数据业务类
	public final static String SERV_BUSIBELONG = "SERV"; // 服务业务类
	public final static String CLIENT_BUSIBELONG = "CLIENT"; // 定制终端类

	// 分割符
	public final static String SEMICOLON = ";";
	public final static String VERTICAL = "|";

	public final static String DEFAULT_REGION = "999"; // 默认省公司区域代码
	public final static String DEFAULT_ACCTYPE = "1"; // 计酬方式 默认按笔数计算
	public final static String DEFAULT_REWARDPROJ = "1"; // 酬金项目 默认为计件酬金
	public final static String DATAFORMAT = "yyyy-MM-dd"; // 日期格式
	public final static String OLDLIST = "OLDLIST";
	public final static String NEWLIST = "NEWLIST";
	
	public ZjtyStdrewardbjAction() {
		// 以下几个方法是必须的
		// 指定VO类
		setVoClass(ZjtyStdrewardbjVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[3];
		pkNameArray[0] = "region";
		pkNameArray[1] = "rewardid";
		pkNameArray[2] = "wayid";
	}
	

	/**
	 * 根据业务代码跳转至相应内容页面 计件酬金上限设置
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
		String opnid = request.getParameter("opnid");
		if (null == opnid || opnid.trim().length() == 0) {
			throw new Exception("业务代码参数为空");
		}

		ZjtyOperationDelegate zjtyoperDelegate = new ZjtyOperationDelegate();
		ZjtyOperationVO zjtyoperationVO = zjtyoperDelegate.doFindByPk(opnid, user);
		if (null == zjtyoperationVO) {
			throw new Exception("根据业务代码[" + opnid + "]查询业务信息为空");
		}
		ZjtyStdrewardbjForm form = (ZjtyStdrewardbjForm) actionForm;
		form.reset(actionMapping, request);
		setDefaultFormValue(form, zjtyoperationVO);
		
		if(StringUtils.isEmpty(form.getWayid())){
			return actionMapping.findForward(getForward(form.getBusibelong(), false));
		}
		
//		WayDelegate waydelegate = new WayDelegate();
//		WayListVO wayListvo = new WayListVO();
//		wayListvo.set_se_wayid(form.getWayid());
//		wayListvo.set_se_waytype("ET");
//		wayListvo.set_se_waysubtype("G100");
//		wayListvo.set_ne_runmode(new Short("1"));
//		DataPackage waydp = waydelegate.doQuery(wayListvo, user);
//		if(waydp.getDatas().size() == 0){
//			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "所选择的渠道并非自建他营渠道");
//			return actionMapping.findForward(getForward(form.getBusibelong(), false));
//		}

		ZjtyStdrewardbjDelegate zjtystdrewardbjDelegate = new ZjtyStdrewardbjDelegate();
		ZjtyStdrewardDelegate zjtystdrewardDelegate = new ZjtyStdrewardDelegate();
		ZjtyStdrewardbjListVO zjtystdrewardbjListVO = new ZjtyStdrewardbjListVO();
		
		zjtystdrewardbjListVO.set_se_opnid(opnid);
		zjtystdrewardbjListVO.set_se_region(DEFAULT_REGION);
		zjtystdrewardbjListVO.set_se_wayid(form.getWayid());
		
		DataPackage dp = zjtystdrewardbjDelegate.doQuery(zjtystdrewardbjListVO, user);
		if (null != dp && null != dp.getDatas()) {
			for (Iterator iter = dp.getDatas().iterator(); iter.hasNext();) {
				ZjtyStdrewardbjVO item = (ZjtyStdrewardbjVO) iter.next();
				ZjtyStdrewardVO vo = zjtystdrewardDelegate.doFindByPk(item
						.getRewardid(), user);
				setFormValue(form, vo, item, false, user);
			}
		}
		
		form.getNewencouragelist().addAll(form.getOldencouragelist());
		request.getSession().setAttribute(OLDLIST, form.getOldencouragelist());
		request.getSession().setAttribute(NEWLIST, form.getNewencouragelist());
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form.getNewencouragelist());
		return actionMapping.findForward(getForward(form.getBusibelong(), false));
	}
	
	/**
	 * 根据业务代码跳转至相应内容页面 市公司计件酬金上限设置
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doShowcity(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		String opnid = request.getParameter("opnid");
		if (null == opnid || opnid.trim().length() == 0) {
			throw new Exception("业务代码参数为空");
		}

		ZjtyOperationDelegate zjtyoperDelegate = new ZjtyOperationDelegate();
		ZjtyOperationVO zjtyoperationVO = zjtyoperDelegate.doFindByPk(opnid, user);
		if (null == zjtyoperationVO) {
			throw new Exception("根据业务代码[" + opnid + "]查询业务信息为空");
		}
		ZjtyStdrewardbjForm form = (ZjtyStdrewardbjForm) actionForm;
		form.reset(actionMapping, request);
		setDefaultFormValue(form, zjtyoperationVO);
		
		if(StringUtils.isEmpty(form.getWayid())){
			return actionMapping.findForward(getForward(form.getBusibelong(), true));
		}

		ZjtyStdrewardbjDelegate zjtystdrewardbjDelegate = new ZjtyStdrewardbjDelegate();
		ZjtyStdrewardDelegate zjtystdrewardDelegate = new ZjtyStdrewardDelegate();
		ZjtyStdrewardbjListVO zjtystdrewardbjListVO = new ZjtyStdrewardbjListVO();
		
		zjtystdrewardbjListVO.set_se_opnid(opnid);
		zjtystdrewardbjListVO.set_se_region(user.getCityid());
		zjtystdrewardbjListVO.set_se_wayid(form.getWayid());
		
		DataPackage city = zjtystdrewardbjDelegate.doQuery(zjtystdrewardbjListVO, user);
		zjtystdrewardbjListVO.set_se_region(DEFAULT_REGION);
		DataPackage province = zjtystdrewardbjDelegate.doQuery(zjtystdrewardbjListVO, user);
		
		List list = new ArrayList();
		for (Iterator iter = province.getDatas().iterator(); iter.hasNext();) {
			ZjtyStdrewardbjVO item = (ZjtyStdrewardbjVO) iter.next();
			
			boolean match = false;
			for (Iterator iter2 = city.getDatas().iterator(); iter2.hasNext();) {
				ZjtyStdrewardbjVO item2 = (ZjtyStdrewardbjVO) iter2.next();
				if (item.getRewardid().equals(item2.getRewardid())) {
					list.add(item2);
					match = true;
					break;
				}
			}
			if (!match) {
				list.add(item);
			}
		}
		
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			ZjtyStdrewardbjVO item = (ZjtyStdrewardbjVO) iter.next();
			ZjtyStdrewardVO vo = zjtystdrewardDelegate.doFindByPk(item.getRewardid(), user);
			setFormValue(form, vo, item, true, user);
		}
		
		form.getNewencouragelist().addAll(form.getOldencouragelist());
		request.getSession().setAttribute(OLDLIST, form.getOldencouragelist());
		request.getSession().setAttribute(NEWLIST, form.getNewencouragelist());
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form.getNewencouragelist());
		return actionMapping.findForward(getForward(form.getBusibelong(), true));
	}

	/**
	 * 标准卡业务酬金上限设置 保存
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doSavecard(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ZjtyStdrewardbjForm form = (ZjtyStdrewardbjForm) actionForm;
		List list = new ArrayList();

		if (form.isFixedflag() || null != form.getRewardid_fixed()) {
			list.add(buildFixedVO(form, DEFAULT_REGION));
		}
		if (form.isIntegralflag() || null != form.getRewardid_integral()) {
			list.add(buildIntegralVO(form, DEFAULT_REGION));
		}
		if (form.isAllowanceflag() || null != form.getRewardid_allowance()) {
			list.add(buildAllowanceVO(form, DEFAULT_REGION));
		}

		// 保存
		ZjtyStdrewardbjDelegate zjtystdrewardbjDelegate = new ZjtyStdrewardbjDelegate();
		zjtystdrewardbjDelegate.doSave(list, user);

		// 查询显示
		ZjtyOperationDelegate zjtyoperDelegate = new ZjtyOperationDelegate();
		ZjtyOperationVO zjtyoperationVO = zjtyoperDelegate
				.doFindByPk(form.getOpnid(), user);
		setDefaultFormValue(form, zjtyoperationVO);

		ZjtyStdrewardDelegate zjtystdrewardDelegate = new ZjtyStdrewardDelegate();
		ZjtyStdrewardbjListVO zjtystdrewardbjListVO = new ZjtyStdrewardbjListVO();
		
		zjtystdrewardbjListVO.set_se_opnid(form.getOpnid());
		zjtystdrewardbjListVO.set_se_region(DEFAULT_REGION);
		zjtystdrewardbjListVO.set_se_wayid(form.getWayid());
		
		DataPackage dp = zjtystdrewardbjDelegate.doQuery(zjtystdrewardbjListVO, user);
		if (null != dp && null != dp.getDatas()) {
			for (Iterator iter = dp.getDatas().iterator(); iter.hasNext();) {
				ZjtyStdrewardbjVO item = (ZjtyStdrewardbjVO) iter.next();
				ZjtyStdrewardVO vo = zjtystdrewardDelegate.doFindByPk(item
						.getRewardid(), user);
				setFormValue(form, vo, item, false, user);
			}
		}
		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "设置保存成功");
		return actionMapping.findForward(getForward(form.getBusibelong(), false));
	}
	
	/**
	 * 市公司标准卡业务酬金上限设置 保存
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doSavecitycard(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ZjtyStdrewardbjForm form = (ZjtyStdrewardbjForm) actionForm;
		List list = new ArrayList();
		if (form.isFixedflag() || null != form.getRewardid_fixed()) {
			list.add(buildFixedVO(form, user.getCityid()));
		}
		if (form.isIntegralflag() || null != form.getRewardid_integral()) {
			list.add(buildIntegralVO(form, user.getCityid()));
		}
		if (form.isAllowanceflag() || null != form.getRewardid_allowance()) {
			list.add(buildAllowanceVO(form, user.getCityid()));
		}
		
		//检查酬金设置是否大于省公司上限
//		for (Iterator iter = list.iterator(); iter.hasNext();) {
//			ZjtyStdrewardbjVO item = (ZjtyStdrewardbjVO) iter.next();
//			Double provinceStd = getProvinceStd(item, user);
//			if (item.getRewardstd().compareTo(provinceStd) > 0) {
//				String msg = "酬金 [" + item.getRewardname() + "] 不能大于省公司上限标准 ["
//						+ provinceStd + "] ，请重新设置";
//				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, msg);
//				return actionMapping.findForward(getForward(form
//						.getBusibelong(), true));
//			}
//		}

		// 保存
		ZjtyStdrewardbjDelegate zjtystdrewardbjDelegate = new ZjtyStdrewardbjDelegate();
		zjtystdrewardbjDelegate.doSavecity(list, user);

		// 查询显示
		ZjtyOperationDelegate zjtyoperDelegate = new ZjtyOperationDelegate();
		ZjtyOperationVO zjtyoperationVO = zjtyoperDelegate.doFindByPk(form.getOpnid(), user);
		setDefaultFormValue(form, zjtyoperationVO);
		
		ZjtyStdrewardDelegate zjtystdrewardDelegate = new ZjtyStdrewardDelegate();
		ZjtyStdrewardbjListVO zjtystdrewardbjListVO = new ZjtyStdrewardbjListVO();
		
		zjtystdrewardbjListVO.set_se_opnid(form.getOpnid());
		zjtystdrewardbjListVO.set_se_region(user.getCityid());
		zjtystdrewardbjListVO.set_se_wayid(form.getWayid());
		
		DataPackage city = zjtystdrewardbjDelegate.doQuery(zjtystdrewardbjListVO, user);
		zjtystdrewardbjListVO.set_se_region(DEFAULT_REGION);
		DataPackage province = zjtystdrewardbjDelegate.doQuery(zjtystdrewardbjListVO, user);
		
		List result = new ArrayList();
		for (Iterator iter = province.getDatas().iterator(); iter.hasNext();) {
			ZjtyStdrewardbjVO item = (ZjtyStdrewardbjVO) iter.next();
			
			boolean match = false;
			for (Iterator iter2 = city.getDatas().iterator(); iter2.hasNext();) {
				ZjtyStdrewardbjVO item2 = (ZjtyStdrewardbjVO) iter2.next();
				if (item.getRewardid().equals(item2.getRewardid())) {
					result.add(item2);
					match = true;
					break;
				}
			}
			if (!match) {
				result.add(item);
			}
		}
		
		for (Iterator iter = result.iterator(); iter.hasNext();) {
			ZjtyStdrewardbjVO item = (ZjtyStdrewardbjVO) iter.next();
			ZjtyStdrewardVO vo = zjtystdrewardDelegate.doFindByPk(item.getRewardid(), user);
			setFormValue(form, vo, item, true, user);
		}
		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "设置保存成功");
		return actionMapping.findForward(getForward(form.getBusibelong(), true));
	}

	/**
	 * 构建固定酬金用VO
	 * 
	 * @param form
	 * @param region
	 * @return
	 * @throws Exception
	 */
	private ZjtyStdrewardbjVO buildFixedVO(ZjtyStdrewardbjForm form, String region)
			throws Exception {
		ZjtyStdrewardbjVO vo = new ZjtyStdrewardbjVO();
		vo.setRegion(region);
		vo.setRewardid(form.getRewardid_fixed());
		vo.setOpnid(form.getOpnid());
		vo.setAcctype(new Short(DEFAULT_ACCTYPE));
		vo.setRewardstd(form.getRewardstd_fixed());
		vo.setRuleid(form.getRuleid_fixed());
		vo.setRewardname(form.getRewardname_fixed());
		vo.setRewardtype(form.getRewardtype_fixed());
		vo.setIntvmonth(form.getIntvmonth_fixed());
		vo.setStartdate(PublicUtils.UtilStrToDate(form.getStartdate_fixed(),
				DATAFORMAT));
		vo.setStopdate(PublicUtils.UtilStrToDate(form.getStopdate_fixed(),
				DATAFORMAT));
		vo.setRewardproj(new Short(DEFAULT_REWARDPROJ));
		//自建他营酬金与其他酬金不同的地方
		vo.setWayid(form.getWayid());
		
		if (!form.isFixedflag() && null != form.getRewardid_fixed()) {
			vo.setDeletefalg(true);
		}

		return vo;
	}

	/**
	 * 构建积分酬金用VO
	 * 
	 * @param form
	 * @param region
	 * @return
	 * @throws Exception
	 */
	private ZjtyStdrewardbjVO buildIntegralVO(ZjtyStdrewardbjForm form, String region)
			throws Exception {
		ZjtyStdrewardbjVO vo = new ZjtyStdrewardbjVO();
		vo.setRegion(region);
		vo.setRewardid(form.getRewardid_integral());
		vo.setOpnid(form.getOpnid());
		vo.setAcctype(new Short(DEFAULT_ACCTYPE));
		vo.setRewardstd(form.getRewardstd_integral());
		vo.setRuleid(form.getRuleid_integral());
		vo.setRewardname(form.getRewardname_integral());
		vo.setRewardtype(form.getRewardtype_integral());
		vo.setIntvmonth(form.getIntvmonth_integral());
		vo.setStartdate(PublicUtils.UtilStrToDate(form.getStartdate_integral(),
				DATAFORMAT));
		vo.setStopdate(PublicUtils.UtilStrToDate(form.getStopdate_integral(),
				DATAFORMAT));
		vo.setRewardproj(new Short(DEFAULT_REWARDPROJ));
//		自建他营酬金与其他酬金不同的地方
		vo.setWayid(form.getWayid());

		if (!form.isIntegralflag() && null != form.getRewardid_integral()) {
			vo.setDeletefalg(true);
		}
		return vo;
	}

	/**
	 * 构建专门津贴用VO
	 * 
	 * @param form
	 * @param region
	 * @return
	 * @throws Exception
	 */
	private ZjtyStdrewardbjVO buildAllowanceVO(ZjtyStdrewardbjForm form, String region)
			throws Exception {
		ZjtyStdrewardbjVO vo = new ZjtyStdrewardbjVO();
		vo.setRegion(region);
		vo.setRewardid(form.getRewardid_allowance());
		vo.setOpnid(form.getOpnid());
		vo.setAcctype(new Short(DEFAULT_ACCTYPE));
		vo.setRewardstd(form.getRewardstd_allowance());
		vo.setRuleid(form.getRuleid_allowance());
		vo.setRewardname(form.getRewardname_allowance());
		vo.setRewardtype(form.getRewardtype_allowance());
		vo.setIntvmonth(form.getIntvmonth_allowance());
		vo.setStartdate(PublicUtils.UtilStrToDate(
				form.getStartdate_allowance(), DATAFORMAT));
		vo.setStopdate(PublicUtils.UtilStrToDate(form.getStopdate_allowance(),
				DATAFORMAT));
		vo.setRewardproj(new Short(DEFAULT_REWARDPROJ));
//		自建他营酬金与其他酬金不同的地方
		vo.setWayid(form.getWayid());

		if (!form.isAllowanceflag() && null != form.getRewardid_allowance()) {
			vo.setDeletefalg(true);
		}
		return vo;
	}
	
	/**
	 * 构建基本酬金用VO
	 * 
	 * @param form
	 * @return
	 */
	private ZjtyStdrewardbjVO buildBasicVO(ZjtyStdrewardbjForm form, String region) throws Exception {
		ZjtyStdrewardbjVO vo = new ZjtyStdrewardbjVO();
		vo.setRegion(region);
		vo.setRewardid(form.getRewardid_basic());
		vo.setOpnid(form.getOpnid());
		vo.setAcctype(new Short(DEFAULT_ACCTYPE));
		if (null != form.getAcctype_basic()) {
			vo.setAcctype(form.getAcctype_basic());
		}
		vo.setRewardstd(form.getRewardstd_basic());
		vo.setRuleid(form.getRuleid_basic());
		vo.setRewardname(form.getRewardname_basic());
		vo.setRewardtype(form.getRewardtype_basic());
		vo.setIntvmonth(form.getIntvmonth_basic());
		vo.setStartdate(PublicUtils.UtilStrToDate(
				form.getStartdate_basic(), DATAFORMAT));
		vo.setStopdate(PublicUtils.UtilStrToDate(form.getStopdate_basic(),
				DATAFORMAT));
		vo.setRewardproj(new Short(DEFAULT_REWARDPROJ));
//		自建他营酬金与其他酬金不同的地方
		vo.setWayid(form.getWayid());
		
		if (!form.isBasicflag() && null != form.getRewardid_basic()) {
			vo.setDeletefalg(true);
		}
		return vo;
	}
	
	/**
	 * 构建奖励酬金用List
	 * 
	 * @param oldlist
	 * @param newlist
	 * @return
	 */
	private List buildEncourageList(List oldlist, List newlist) {
		if (null == oldlist) {
			oldlist = new ArrayList(0);
		}
		if (null == newlist) {
			newlist = new ArrayList(0);
		}

		// the delete values = old - new
		List list = new ArrayList();
		for (Iterator iter1 = oldlist.iterator(); iter1.hasNext();) {
			ZjtyStdrewardbjVO item1 = (ZjtyStdrewardbjVO) iter1.next();
			boolean match = false;
			for (Iterator iter2 = newlist.iterator(); iter2.hasNext();) {
				ZjtyStdrewardbjVO item2 = (ZjtyStdrewardbjVO) iter2.next();
				if (null == item2.getRewardid()) {
					continue;
				}
				if (item1.getRewardid().equals(item2.getRewardid())) {
					match = true;
					break;
				}
			}

			if (!match) {
				item1.setDeletefalg(true);
				list.add(item1);
			}
		}

		// the add or update values = all new values
		if (newlist.size() > 0) {
			list.addAll(newlist);
		}

		return list;
	}

	/**
	 * 计件酬金上限设置保存，适用于 [数据业务] 和 [服务业务]
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doSavedata(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ZjtyStdrewardbjForm form = (ZjtyStdrewardbjForm) actionForm;
		form.setOldencouragelist((List) request.getSession().getAttribute(OLDLIST));
		form.setNewencouragelist((List) request.getSession().getAttribute(NEWLIST));
		List list = new ArrayList();

		if (form.isBasicflag() || null != form.getRewardid_basic()) {
			list.add(buildBasicVO(form, DEFAULT_REGION));
		}
		
		if (form.isEncourageflag()) {
			list.addAll(buildEncourageList(form.getOldencouragelist(), form.getNewencouragelist()));
		} else if (null != form.getOldencouragelist()) {
			list.addAll(buildEncourageList(form.getOldencouragelist(), new ArrayList(0)));
		}

		// 保存
		ZjtyStdrewardbjDelegate zjtystdrewardbjDelegate = new ZjtyStdrewardbjDelegate();
		zjtystdrewardbjDelegate.doSave(list, user);

		// 查询显示
		ZjtyOperationDelegate zjtyoperDelegate = new ZjtyOperationDelegate();
		ZjtyOperationVO zjtyoperationVO = zjtyoperDelegate
				.doFindByPk(form.getOpnid(), user);
		form.getOldencouragelist().clear();
		form.getNewencouragelist().clear();
		setDefaultFormValue(form, zjtyoperationVO);

		ZjtyStdrewardDelegate zjtystdrewardDelegate = new ZjtyStdrewardDelegate();
		ZjtyStdrewardbjListVO zjtystdrewardbjListVO = new ZjtyStdrewardbjListVO();
		
		zjtystdrewardbjListVO.set_se_opnid(form.getOpnid());
		zjtystdrewardbjListVO.set_se_region(DEFAULT_REGION);
		zjtystdrewardbjListVO.set_se_wayid(form.getWayid());
		
		DataPackage dp = zjtystdrewardbjDelegate.doQuery(zjtystdrewardbjListVO, user);
		if (null != dp && null != dp.getDatas()) {
			for (Iterator iter = dp.getDatas().iterator(); iter.hasNext();) {
				ZjtyStdrewardbjVO item = (ZjtyStdrewardbjVO) iter.next();
				ZjtyStdrewardVO vo = zjtystdrewardDelegate.doFindByPk(item
						.getRewardid(), user);
				setFormValue(form, vo, item, false, user);
			}
		}
		
		form.getNewencouragelist().addAll(form.getOldencouragelist());
		request.getSession().setAttribute(OLDLIST, form.getOldencouragelist());
		request.getSession().setAttribute(NEWLIST, form.getNewencouragelist());
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form.getNewencouragelist());
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "设置保存成功");
		return actionMapping.findForward(getForward(form.getBusibelong(), false));
	}
	
	/**
	 * 市公司计件酬金上限设置保存，适用于 [数据业务] 和 [服务业务]
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doSavecitydata(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ZjtyStdrewardbjForm form = (ZjtyStdrewardbjForm) actionForm;
		form.setOldencouragelist((List) request.getSession().getAttribute(OLDLIST));
		form.setNewencouragelist((List) request.getSession().getAttribute(NEWLIST));
		List list = new ArrayList();

		if (form.isBasicflag() || null != form.getRewardid_basic()) {
			list.add(buildBasicVO(form, user.getCityid()));
		}
		
		if (form.isEncourageflag()) {
			list.addAll(buildEncourageList(form.getOldencouragelist(), form.getNewencouragelist()));
		} else if (null != form.getOldencouragelist()) {
			list.addAll(buildEncourageList(form.getOldencouragelist(), new ArrayList(0)));
		}
		
		//检查酬金设置是否大于省公司上限
//		for (Iterator iter = list.iterator(); iter.hasNext();) {
//			ZjtyStdrewardbjVO item = (ZjtyStdrewardbjVO) iter.next();
//			Double provinceStd = getProvinceStd(item, user);
//			if (item.getRewardstd().compareTo(provinceStd) > 0) {
//				String msg = "酬金 [" + item.getRewardname() + "] 不能大于省公司上限标准 ["
//						+ provinceStd + "] ，请重新设置";
//				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, msg);
//				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form.getNewencouragelist());
//				return actionMapping.findForward(getForward(form
//						.getBusibelong(), true));
//			}
//		}

		// 保存
		ZjtyStdrewardbjDelegate zjtystdrewardbjDelegate = new ZjtyStdrewardbjDelegate();
		zjtystdrewardbjDelegate.doSavecity(list, user);

		// 查询显示
		ZjtyOperationDelegate operDelegate = new ZjtyOperationDelegate();
		ZjtyOperationVO zjtyoperationVO = operDelegate.doFindByPk(form.getOpnid(), user);
		form.getOldencouragelist().clear();
		form.getNewencouragelist().clear();
		setDefaultFormValue(form, zjtyoperationVO);
		
		ZjtyStdrewardDelegate zjtystdrewardDelegate = new ZjtyStdrewardDelegate();
		ZjtyStdrewardbjListVO zjtystdrewardbjListVO = new ZjtyStdrewardbjListVO();
		
		zjtystdrewardbjListVO.set_se_opnid(form.getOpnid());
		zjtystdrewardbjListVO.set_se_region(user.getCityid());
		zjtystdrewardbjListVO.set_se_wayid(form.getWayid());
		
		DataPackage city = zjtystdrewardbjDelegate.doQuery(zjtystdrewardbjListVO, user);
		zjtystdrewardbjListVO.set_se_region(DEFAULT_REGION);
		DataPackage province = zjtystdrewardbjDelegate.doQuery(zjtystdrewardbjListVO, user);
		
		List result = new ArrayList();
		for (Iterator iter = province.getDatas().iterator(); iter.hasNext();) {
			ZjtyStdrewardbjVO item = (ZjtyStdrewardbjVO) iter.next();
			
			boolean match = false;
			for (Iterator iter2 = city.getDatas().iterator(); iter2.hasNext();) {
				ZjtyStdrewardbjVO item2 = (ZjtyStdrewardbjVO) iter2.next();
				if (item.getRewardid().equals(item2.getRewardid())) {
					result.add(item2);
					match = true;
					break;
				}
			}
			if (!match) {
				result.add(item);
			}
		}
		
		for (Iterator iter = result.iterator(); iter.hasNext();) {
			ZjtyStdrewardbjVO item = (ZjtyStdrewardbjVO) iter.next();
			ZjtyStdrewardVO vo = zjtystdrewardDelegate.doFindByPk(item.getRewardid(), user);
			setFormValue(form, vo, item, true, user);
		}
		
		form.getNewencouragelist().addAll(form.getOldencouragelist());
		request.getSession().setAttribute(OLDLIST, form.getOldencouragelist());
		request.getSession().setAttribute(NEWLIST, form.getNewencouragelist());
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form.getNewencouragelist());
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "设置保存成功");
		return actionMapping.findForward(getForward(form.getBusibelong(), true));
	}

	/**
	 * 编辑奖励酬金
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doEditencourage(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ZjtyStdrewardbjForm form = (ZjtyStdrewardbjForm) actionForm;
		String pk = request.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
		if (pk == null) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"pk is required.");
			return actionMapping.findForward(getForward(form.getBusibelong(), false));
		}

		form.setOldencouragelist((List) request.getSession().getAttribute(OLDLIST));
		form.setNewencouragelist((List) request.getSession().getAttribute(NEWLIST));
		List list = form.getNewencouragelist();
		ZjtyStdrewardbjVO zjtystdrewardbjVO = null;

		String[] arr = StringSplit.split(pk, VERTICAL);
		String rewardid = arr[0];
		String temprewardid = "";
		if (arr.length >= 2) {
			temprewardid = arr[1];
		}
		if (null != rewardid && rewardid.length() > 0) {
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				ZjtyStdrewardbjVO item = (ZjtyStdrewardbjVO) iter.next();
				if (null == item || null == item.getRewardid()) {
					continue;
				}
				if (item.getRewardid().toString().equals(rewardid)) {
					zjtystdrewardbjVO = item;
					break;
				}
			}
		} else if (null != temprewardid && temprewardid.length() > 0) {
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				ZjtyStdrewardbjVO item = (ZjtyStdrewardbjVO) iter.next();
				if (null == item || null == item.getTemprewardid()) {
					continue;
				}
				if (item.getTemprewardid().toString().equals(temprewardid)) {
					zjtystdrewardbjVO = item;
					break;
				}
			}
		}

		if (null == zjtystdrewardbjVO) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"pk is error, nothing match.");
			return actionMapping.findForward(getForward(form.getBusibelong(), false));
		}

		if (null != zjtystdrewardbjVO.getRewardid()) {
			form.setRewardid_encourage(zjtystdrewardbjVO.getRewardid());
		} else {
			form.setRewardid_encourage(zjtystdrewardbjVO.getTemprewardid());
		}
		form.setRewardname_encourage(zjtystdrewardbjVO.getRewardname());
		form.setRewardtype_encourage(zjtystdrewardbjVO.getRewardtype());
		form.setStartdate_encourage(PublicUtils.formatUtilDate(zjtystdrewardbjVO
				.getStartdate(), DATAFORMAT));
		form.setStopdate_encourage(PublicUtils.formatUtilDate(zjtystdrewardbjVO
				.getStopdate(), DATAFORMAT));
		form.setRewardstd_encourage(zjtystdrewardbjVO.getRewardstd());
		form.setRuleid_encourage(zjtystdrewardbjVO.getRuleid());
		form.setIntvmonth_encourage(zjtystdrewardbjVO.getIntvmonth());
		form.setRewardname_encourage_temp(zjtystdrewardbjVO.getRewardname());

		request.getSession().setAttribute(OLDLIST, form.getOldencouragelist());
		request.getSession().setAttribute(NEWLIST, form.getNewencouragelist());
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form.getNewencouragelist());
		request.setAttribute(WebConstant.COMMAND_STRING_EDIT, "TRUE");
		return actionMapping.findForward(getForward(form.getBusibelong(), false));
	}
	
	/**
	 * 编辑奖励酬金 市公司
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doEditcityencourage(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ZjtyStdrewardbjForm form = (ZjtyStdrewardbjForm) actionForm;
		String pk = request.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
		if (pk == null) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"pk is required.");
			return actionMapping.findForward(getForward(form.getBusibelong(), true));
		}

		form.setOldencouragelist((List) request.getSession().getAttribute(OLDLIST));
		form.setNewencouragelist((List) request.getSession().getAttribute(NEWLIST));
		List list = form.getNewencouragelist();
		ZjtyStdrewardbjVO zjtystdrewardbjVO = null;

		String[] arr = StringSplit.split(pk, VERTICAL);
		String rewardid = arr[0];
		String temprewardid = "";
		if (arr.length >= 2) {
			temprewardid = arr[1];
		}
		if (null != rewardid && rewardid.length() > 0) {
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				ZjtyStdrewardbjVO item = (ZjtyStdrewardbjVO) iter.next();
				if (null == item || null == item.getRewardid()) {
					continue;
				}
				if (item.getRewardid().toString().equals(rewardid)) {
					zjtystdrewardbjVO = item;
					break;
				}
			}
		} else if (null != temprewardid && temprewardid.length() > 0) {
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				ZjtyStdrewardbjVO item = (ZjtyStdrewardbjVO) iter.next();
				if (null == item || null == item.getTemprewardid()) {
					continue;
				}
				if (item.getTemprewardid().toString().equals(temprewardid)) {
					zjtystdrewardbjVO = item;
					break;
				}
			}
		}

		if (null == zjtystdrewardbjVO) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"pk is error, nothing match.");
			return actionMapping.findForward(getForward(form.getBusibelong(), true));
		}

		if (null != zjtystdrewardbjVO.getRewardid()) {
			form.setRewardid_encourage(zjtystdrewardbjVO.getRewardid());
		} else {
			form.setRewardid_encourage(zjtystdrewardbjVO.getTemprewardid());
		}
		
		ZjtyStdrewardbjVO provinceVO = this.getProvinceStd(zjtystdrewardbjVO, user);
		//市公司酬金上限设置,将省公司酬金上限提取
		form.setRewardstd_encourage_limited(provinceVO.getRewardstd());
		form.setIntvmonth_encourage_limited(provinceVO.getIntvmonth());
		
		
		form.setRewardname_encourage(zjtystdrewardbjVO.getRewardname());
		form.setRewardtype_encourage(zjtystdrewardbjVO.getRewardtype());
		form.setStartdate_encourage(PublicUtils.formatUtilDate(zjtystdrewardbjVO
				.getStartdate(), DATAFORMAT));
		form.setStopdate_encourage(PublicUtils.formatUtilDate(zjtystdrewardbjVO
				.getStopdate(), DATAFORMAT));
		form.setRewardstd_encourage(zjtystdrewardbjVO.getRewardstd());
		form.setRuleid_encourage(zjtystdrewardbjVO.getRuleid());
		form.setIntvmonth_encourage(zjtystdrewardbjVO.getIntvmonth());

		request.getSession().setAttribute(OLDLIST, form.getOldencouragelist());
		request.getSession().setAttribute(NEWLIST, form.getNewencouragelist());
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form.getNewencouragelist());
		request.setAttribute(WebConstant.COMMAND_STRING_EDIT, "TRUE");
		return actionMapping.findForward(getForward(form.getBusibelong(), true));
	}
	
	/**
	 * 新增奖励酬金
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doNewencourage(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ZjtyStdrewardbjForm form = (ZjtyStdrewardbjForm) actionForm;
		form.setOldencouragelist((List) request.getSession().getAttribute(OLDLIST));
		form.setNewencouragelist((List) request.getSession().getAttribute(NEWLIST));
		if (hasSameName(form.getRewardname_encourage(), form.getNewencouragelist())) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, 
					"酬金名称 [" + form.getRewardname_encourage() + "] 已经存在，名称不允许重复，请修改");
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form.getNewencouragelist());
			return actionMapping.findForward(getForward(form.getBusibelong(), false));
		}
		
		ZjtyStdrewardbjVO zjtystdrewardbjVO = new ZjtyStdrewardbjVO();
		zjtystdrewardbjVO.setTemprewardid(new Long(Sequence.getSequence()));
		zjtystdrewardbjVO.setRegion(DEFAULT_REGION);
		zjtystdrewardbjVO.setAcctype(new Short(DEFAULT_ACCTYPE));
		zjtystdrewardbjVO.setOpnid(form.getOpnid());
		zjtystdrewardbjVO.setRewardstd(form.getRewardstd_encourage());
		zjtystdrewardbjVO.setIntvmonth(form.getIntvmonth_encourage());
		zjtystdrewardbjVO.setRuleid(form.getRuleid_encourage());
		zjtystdrewardbjVO.setRewardname(form.getRewardname_encourage());
		zjtystdrewardbjVO.setRewardtype(form.getRewardtype_encourage());
		zjtystdrewardbjVO.setStartdate(PublicUtils.UtilStrToDate(form
				.getStartdate_encourage(), DATAFORMAT));
		zjtystdrewardbjVO.setStopdate(PublicUtils.UtilStrToDate(form
				.getStopdate_encourage(), DATAFORMAT));
		zjtystdrewardbjVO.setRewardproj(new Short(DEFAULT_REWARDPROJ));
		//自建他营渠道代码
		zjtystdrewardbjVO.setWayid(form.getWayid());
		
		//reset encourage values
		form.getNewencouragelist().add(zjtystdrewardbjVO);
		form.setRewardname_encourage(form.getOpnname()
				+ getOpnname(form.getBusibelong()) + "奖励酬金");
		form.setStartdate_encourage(getDefaultBeginDate());
		form.setStopdate_encourage(getDefaultEndDate());
		form.setRewardstd_encourage(null);
		form.setIntvmonth_encourage(null);
		form.setRuleid_encourage("");
		
		request.getSession().setAttribute(OLDLIST, form.getOldencouragelist());
		request.getSession().setAttribute(NEWLIST, form.getNewencouragelist());
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form.getNewencouragelist());
		return actionMapping.findForward(getForward(form.getBusibelong(), false));
	}

	/**
	 * 保存奖励酬金
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doSaveencourage(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ZjtyStdrewardbjForm form = (ZjtyStdrewardbjForm) actionForm;
		form.setOldencouragelist((List) request.getSession().getAttribute(OLDLIST));
		form.setNewencouragelist((List) request.getSession().getAttribute(NEWLIST));
		if (null == form.getRewardid_encourage()) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "奖励酬金标识为空");
			return actionMapping.findForward(getForward(form.getBusibelong(), false));
		}
		
		if (hasSameNameWhenEdit(form.getRewardname_encourage(),form.getRewardname_encourage_temp(),form.getNewencouragelist())) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, 
					"酬金名称 [" + form.getRewardname_encourage() + "] 已经存在，名称不允许重复，请修改");
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form.getNewencouragelist());
			return actionMapping.findForward(getForward(form.getBusibelong(), false));
		}
		
		String rewardid = form.getRewardid_encourage().toString();
		List list = form.getNewencouragelist();
		int matchIndex = -1;
		for (int i = 0; i < list.size(); i++) {
			ZjtyStdrewardbjVO item = (ZjtyStdrewardbjVO) list.get(i);
			if (null == item.getRewardid() && null == item.getTemprewardid()) {
				continue;
			}
			if (null != item.getRewardid()) {
				if (rewardid.equals(item.getRewardid().toString())) {
					matchIndex = i;
					break;
				}
			} else if (null != item.getTemprewardid()) {
				if (rewardid.equals(item.getTemprewardid().toString())) {
					matchIndex = i;
					break;
				}
			}
		}
		
		if (matchIndex < 0) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "奖励酬金标识["
					+ rewardid + "]匹配结果为空");
			return actionMapping.findForward(getForward(form.getBusibelong(), false));
		}
		
		//update encourage list value
		ZjtyStdrewardbjVO item = (ZjtyStdrewardbjVO) list.get(matchIndex);
		item.setRewardname(form.getRewardname_encourage());
		item.setStartdate(PublicUtils.UtilStrToDate(form
				.getStartdate_encourage(), DATAFORMAT));
		item.setStopdate(PublicUtils.UtilStrToDate(form
				.getStopdate_encourage(), DATAFORMAT));
		item.setRewardstd(form.getRewardstd_encourage());
		item.setIntvmonth(form.getIntvmonth_encourage());
		item.setRuleid(form.getRuleid_encourage());
		//自建他营渠道代码
		item.setWayid(form.getWayid());
		
		ZjtyStdrewardbjVO zjtystdrewardbjVO = new ZjtyStdrewardbjVO();
		BeanUtils.copyProperties(zjtystdrewardbjVO, item);
		list.remove(matchIndex);
		list.add(matchIndex, zjtystdrewardbjVO);

		// reset encourage values
		form.setRewardname_encourage(form.getOpnname()
				+ getOpnname(form.getBusibelong()) + "奖励酬金");
		form.setStartdate_encourage(getDefaultBeginDate());
		form.setStopdate_encourage(getDefaultEndDate());
		form.setRewardstd_encourage(null);
		form.setIntvmonth_encourage(null);
		form.setRuleid_encourage("");
		
		request.getSession().setAttribute(OLDLIST, form.getOldencouragelist());
		request.getSession().setAttribute(NEWLIST, form.getNewencouragelist());
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form.getNewencouragelist());
		return actionMapping.findForward(getForward(form.getBusibelong(), false));
	}
	
	/**
	 * 保存奖励酬金 市公司
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doSavecityencourage(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ZjtyStdrewardbjForm form = (ZjtyStdrewardbjForm) actionForm;
		form.setOldencouragelist((List) request.getSession().getAttribute(OLDLIST));
		form.setNewencouragelist((List) request.getSession().getAttribute(NEWLIST));
		if (null == form.getRewardid_encourage()) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "奖励酬金标识为空");
			return actionMapping.findForward(getForward(form.getBusibelong(), true));
		}
		
		String rewardid = form.getRewardid_encourage().toString();
		List list = form.getNewencouragelist();
		int matchIndex = -1;
		for (int i = 0; i < list.size(); i++) {
			ZjtyStdrewardbjVO item = (ZjtyStdrewardbjVO) list.get(i);
			if (null == item.getRewardid() && null == item.getTemprewardid()) {
				continue;
			}
			if (null != item.getRewardid()) {
				if (rewardid.equals(item.getRewardid().toString())) {
					matchIndex = i;
					break;
				}
			} else if (null != item.getTemprewardid()) {
				if (rewardid.equals(item.getTemprewardid().toString())) {
					matchIndex = i;
					break;
				}
			}
		}
		
		if (matchIndex < 0) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "奖励酬金标识["
					+ rewardid + "]匹配结果为空");
			return actionMapping.findForward(getForward(form.getBusibelong(), true));
		}
		
		//检查酬金设置是否大于省公司上限
		ZjtyStdrewardbjVO item = (ZjtyStdrewardbjVO) list.get(matchIndex);
//		Double provinceStd = getProvinceStd(item, user);
//		if (form.getRewardstd_encourage().compareTo(provinceStd) > 0) {
//			String msg = "酬金 [" + item.getRewardname() + "] 不能大于省公司上限标准 ["
//					+ provinceStd + "] ，请重新设置";
//			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, msg);
//			request.setAttribute(WebConstant.COMMAND_STRING_EDIT, "TRUE");
//			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form.getNewencouragelist());
//			return actionMapping.findForward(getForward(form
//					.getBusibelong(), true));
//		}
		
		//update encourage list value
		item.setRewardname(form.getRewardname_encourage());
		item.setStartdate(PublicUtils.UtilStrToDate(form
				.getStartdate_encourage(), DATAFORMAT));
		item.setStopdate(PublicUtils.UtilStrToDate(form
				.getStopdate_encourage(), DATAFORMAT));
		item.setRewardstd(form.getRewardstd_encourage());
		item.setIntvmonth(form.getIntvmonth_encourage());
		item.setRuleid(form.getRuleid_encourage());
		
		ZjtyStdrewardbjVO zjtystdrewardbjVO = new ZjtyStdrewardbjVO();
		BeanUtils.copyProperties(zjtystdrewardbjVO, item);
		list.remove(matchIndex);
		list.add(matchIndex, zjtystdrewardbjVO);

		// reset encourage values
		form.setRewardname_encourage("");
		form.setStartdate_encourage("");
		form.setStopdate_encourage("");
		form.setRewardstd_encourage(null);
		form.setIntvmonth_encourage(null);
		form.setRuleid_encourage("");
		
		request.getSession().setAttribute(OLDLIST, form.getOldencouragelist());
		request.getSession().setAttribute(NEWLIST, form.getNewencouragelist());
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form.getNewencouragelist());
		return actionMapping.findForward(getForward(form.getBusibelong(), true));
	}
	
	/**
	 * 删除奖励酬金
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doDelencourage(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ZjtyStdrewardbjForm form = (ZjtyStdrewardbjForm) actionForm;
		form.setOldencouragelist((List) request.getSession().getAttribute(OLDLIST));
		form.setNewencouragelist((List) request.getSession().getAttribute(NEWLIST));
		
		List list = form.getNewencouragelist();
		String[] arr = form.get_selectitem();
		for (int i=0; i<arr.length; i++) {
			if (null == arr[i]) {
				continue;
			}
			
			String[] key = StringSplit.split(arr[i], VERTICAL);
			String rewardid = key[0];
			String temprewardid = "";
			if (key.length >= 2) {
				temprewardid = key[1];
			}
			int matchIndex = -1;
			for (int j=0; j<list.size();j++) {
				ZjtyStdrewardbjVO item = (ZjtyStdrewardbjVO) list.get(j);
				if (null != item.getRewardid()) {
					if (item.getRewardid().toString().equals(rewardid)) {
						matchIndex = j;
						break;
					}
				} else if (null != item.getTemprewardid()) {
					if (item.getTemprewardid().toString().equals(temprewardid)) {
						matchIndex = j;
						break;
					}
				}
			}
			
			if (matchIndex >= 0) {
				list.remove(matchIndex);
			}
		}
		
		request.getSession().setAttribute(OLDLIST, form.getOldencouragelist());
		request.getSession().setAttribute(NEWLIST, form.getNewencouragelist());
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form.getNewencouragelist());
		return actionMapping.findForward(getForward(form.getBusibelong(), false));
	}

	/**
	 * 根据业务归属定位目标页面
	 * 
	 * @param busibelong
	 *            业务归属
	 * @param cityflag
	 *            是否市公司
	 * @return
	 * @throws Exception
	 */
	private String getForward(String busibelong, boolean cityflag)
			throws Exception {
		if (cityflag) {
			if (CARD_BUSIBELONG.equals(busibelong)) {
				return "citycardcontent";
			} else if (DATA_BUSIBELONG.equals(busibelong)) {
				return "citydatacontent";
			} else if (SERV_BUSIBELONG.equals(busibelong)) {
				return "cityservcontent";
			} else if (CLIENT_BUSIBELONG.equals(busibelong)){
				return "cityclientcontent";
			} else {
				throw new Exception("根据业务归属" + busibelong + "无法定位目标界面");
			}
		} else {
			if (CARD_BUSIBELONG.equals(busibelong)) {
				return "cardcontent";
			} else if (DATA_BUSIBELONG.equals(busibelong)) {
				return "datacontent";
			} else if (SERV_BUSIBELONG.equals(busibelong)) {
				return "servcontent";
			}else if (CLIENT_BUSIBELONG.equals(busibelong)){
				return "clientcontent";
			} else {
				throw new Exception("根据业务归属" + busibelong + "无法定位目标界面");
			}
		}
	}
	
	/**
	 * 根据业务归属获取名称
	 * @param busibelong
	 * @return
	 */
	private String getOpnname(String busibelong) {
		if (null == busibelong || busibelong.trim().length() == 0) {
			return "";
		}
		
		if (CARD_BUSIBELONG.equals(busibelong)) {
			return "标准卡业务";
		} else if (DATA_BUSIBELONG.equals(busibelong)) {
			return "数据业务";
		} else if (SERV_BUSIBELONG.equals(busibelong)) {
			return "服务业务";
		} else if (CLIENT_BUSIBELONG.equals(busibelong)){
			return "定制终端业务";
		}

		return "";
	}

	/**
	 * 设置form中酬金相关默认值
	 * 
	 * @param form
	 * @param operationVO
	 */
	private void setDefaultFormValue(ZjtyStdrewardbjForm form,
			ZjtyOperationVO zjtyoperationVO) throws Exception {
		if (null == zjtyoperationVO.getBusibelong()
				|| zjtyoperationVO.getBusibelong().trim().length() == 0) {
			return;
		}

		String beginDate = getDefaultBeginDate();
		String endDate = getDefaultEndDate();
		form.setOpnid(zjtyoperationVO.getOpnid());
		form.setOpnname(zjtyoperationVO.getName());
		form.setOpnstate(zjtyoperationVO.getState());
		form.setBusibelong(zjtyoperationVO.getBusibelong());
		
		if (CARD_BUSIBELONG.equals(zjtyoperationVO.getBusibelong())) {
			form.setRewardname_fixed(zjtyoperationVO.getName() + "标准卡销售酬金");
			form.setRewardtype_fixed(new Short("" + ZjtyRewardType.CARD_FIXED));
			form.setStartdate_fixed(beginDate);
			form.setStopdate_fixed(endDate);

			form.setRewardname_integral(zjtyoperationVO.getName() + "标准卡激活酬金");
			form.setRewardtype_integral(new Short(""
							+ ZjtyRewardType.CARD_INTEGRAL));
			form.setStartdate_integral(beginDate);
			form.setStopdate_integral(endDate);

			form.setRewardname_allowance(zjtyoperationVO.getName() + "标准卡客户质量奖");
			form.setRewardtype_allowance(new Short(""
					+ ZjtyRewardType.CARD_ALLOWANCE));
			form.setStartdate_allowance(beginDate);
			form.setStopdate_allowance(endDate);
		} else if (DATA_BUSIBELONG.equals(zjtyoperationVO.getBusibelong())) {
			form.setRewardname_basic(zjtyoperationVO.getName() + "数据业务基本酬金");
			form.setRewardtype_basic(new Short("" + ZjtyRewardType.DATA_BASIC));
			form.setStartdate_basic(beginDate);
			form.setStopdate_basic(endDate);

			form.setRewardname_encourage(zjtyoperationVO.getName() + "数据业务奖励酬金");
			form.setRewardtype_encourage(new Short(""
					+ ZjtyRewardType.DATA_ENCOURAGE));
			form.setStartdate_encourage(beginDate);
			form.setStopdate_encourage(endDate);
		} else if (SERV_BUSIBELONG.equals(zjtyoperationVO.getBusibelong())) {
			form.setRewardname_basic(zjtyoperationVO.getName() + "服务业务基本酬金");
			form.setRewardtype_basic(new Short("" + ZjtyRewardType.SERV_BASIC));
			form.setStartdate_basic(beginDate);
			form.setStopdate_basic(endDate);
			form.setAcctype_basic(new Short(DEFAULT_ACCTYPE));
			
			form.setRewardname_encourage(zjtyoperationVO.getName() + "服务业务奖励酬金");
			form.setRewardtype_encourage(new Short(""
					+ ZjtyRewardType.SERV_ENCOURAGE));
			form.setStartdate_encourage(beginDate);
			form.setStopdate_encourage(endDate);
		} else if (CLIENT_BUSIBELONG.equals(zjtyoperationVO.getBusibelong())){
			form.setRewardname_basic(zjtyoperationVO.getName() + "终端销售基本酬金");
			form.setRewardtype_basic(new Short("" + ZjtyRewardType.CLIENT_BASIC));
			form.setStartdate_basic(beginDate);
			form.setStopdate_basic(endDate);
			form.setAcctype_basic(new Short(DEFAULT_ACCTYPE));

//			form.setRewardname_encourage(zjtyoperationVO.getName() + "终端销售奖励酬金");
//			form.setRewardtype_encourage(new Short(""
//					+ ZjtyRewardType.CLIENT_ENCOURAGE));
//			form.setStartdate_encourage(beginDate);
//			form.setStopdate_encourage(endDate);
		}
	}

	/**
	 * 设置form中酬金相关值
	 * 
	 * @param form
	 * @param stdrewardbjVO
	 * @param stdrewardVO
	 */
	private void setFormValue(ZjtyStdrewardbjForm form, ZjtyStdrewardVO zjtystdrewardVO,
			ZjtyStdrewardbjVO zjtystdrewardbjVO, boolean flag, User user) throws Exception {
		if (null == zjtystdrewardVO || null == zjtystdrewardVO.getRewardtype()) {
			return;
		}
		//自建他营渠道代码
		form.setWayid(zjtystdrewardbjVO.getWayid());
		
		switch (zjtystdrewardVO.getRewardtype().intValue()) {
		case ZjtyRewardType.CARD_FIXED: // 标准卡固定酬金
			form.setFixedflag(true);
//			form.setRewardid_fixed(zjtystdrewardVO.getRewardid());
//			form.setRewardname_fixed(zjtystdrewardVO.getRewardname());
			form.setRewardid_fixed(zjtystdrewardbjVO.getRewardid());
			form.setRewardname_fixed(zjtystdrewardbjVO.getRewardname());
			form.setRewardtype_fixed(zjtystdrewardVO.getRewardtype());
			form.setStartdate_fixed(PublicUtils.formatUtilDate(zjtystdrewardVO
					.getStartdate(), DATAFORMAT));
			form.setStopdate_fixed(PublicUtils.formatUtilDate(zjtystdrewardVO
					.getEnddate(), DATAFORMAT));
			form.setRewardstd_fixed(zjtystdrewardbjVO.getRewardstd());
			form.setRuleid_fixed(zjtystdrewardbjVO.getRuleid());
			form.setIntvmonth_fixed(zjtystdrewardbjVO.getIntvmonth());
			
			//市公司酬金上限设置,将省公司酬金上限提取
			if(flag == true){
				ZjtyStdrewardbjVO vo = this.getProvinceStd(zjtystdrewardbjVO, user);
				form.setRewardstd_fixed_limited(vo.getRewardstd());
				form.setIntvmonth_fixed_limited(vo.getIntvmonth());
			}
			
			break;
		case ZjtyRewardType.CARD_INTEGRAL: // 标准卡积分酬金
			form.setIntegralflag(true);
//			form.setRewardid_integral(zjtystdrewardVO.getRewardid());
//			form.setRewardname_integral(zjtystdrewardVO.getRewardname());
			form.setRewardid_integral(zjtystdrewardbjVO.getRewardid());
			form.setRewardname_integral(zjtystdrewardbjVO.getRewardname());
			form.setRewardtype_integral(zjtystdrewardVO.getRewardtype());
			form.setStartdate_integral(PublicUtils.formatUtilDate(zjtystdrewardVO
					.getStartdate(), DATAFORMAT));
			form.setStopdate_integral(PublicUtils.formatUtilDate(zjtystdrewardVO
					.getEnddate(), DATAFORMAT));
			form.setRewardstd_integral(zjtystdrewardbjVO.getRewardstd());
			form.setRuleid_integral(zjtystdrewardbjVO.getRuleid());
			form.setIntvmonth_integral(zjtystdrewardbjVO.getIntvmonth());
			
			//市公司酬金上限设置,将省公司酬金上限提取
			if(flag == true){
				ZjtyStdrewardbjVO vo = this.getProvinceStd(zjtystdrewardbjVO, user);
				form.setRewardstd_integral_limited(vo.getRewardstd());
				form.setIntvmonth_integral_limited(vo.getIntvmonth());
			}
			
			break;
		case ZjtyRewardType.CARD_ALLOWANCE: // 标准卡专门津贴
			form.setAllowanceflag(true);
//			form.setRewardid_allowance(zjtystdrewardVO.getRewardid());
//			form.setRewardname_allowance(zjtystdrewardVO.getRewardname());
			form.setRewardid_allowance(zjtystdrewardbjVO.getRewardid());
			form.setRewardname_allowance(zjtystdrewardbjVO.getRewardname());
			form.setRewardtype_allowance(zjtystdrewardVO.getRewardtype());
			form.setStartdate_allowance(PublicUtils.formatUtilDate(zjtystdrewardVO
					.getStartdate(), DATAFORMAT));
			form.setStopdate_allowance(PublicUtils.formatUtilDate(zjtystdrewardVO
					.getEnddate(), DATAFORMAT));
			form.setRewardstd_allowance(zjtystdrewardbjVO.getRewardstd());
			form.setRuleid_allowance(zjtystdrewardbjVO.getRuleid());
			form.setIntvmonth_allowance(zjtystdrewardbjVO.getIntvmonth());
			
			//市公司酬金上限设置,将省公司酬金上限提取
			if(flag == true){
				ZjtyStdrewardbjVO vo = this.getProvinceStd(zjtystdrewardbjVO, user);
				form.setRewardstd_allowance_limited(vo.getRewardstd());
				form.setIntvmonth_allowance_limited(vo.getIntvmonth());
			}
			
			break;
		case ZjtyRewardType.DATA_BASIC: // 数据业务基本酬金
		case ZjtyRewardType.SERV_BASIC: // 服务业务基本酬金
		case ZjtyRewardType.CLIENT_BASIC: //定制终端基本酬金
			form.setBasicflag(true);
//			form.setRewardid_basic(zjtystdrewardVO.getRewardid());
//			form.setRewardname_basic(zjtystdrewardVO.getRewardname());
			form.setRewardid_basic(zjtystdrewardbjVO.getRewardid());
			form.setRewardname_basic(zjtystdrewardbjVO.getRewardname());
			form.setRewardtype_basic(zjtystdrewardVO.getRewardtype());
			form.setStartdate_basic(PublicUtils.formatUtilDate(zjtystdrewardVO
					.getStartdate(), DATAFORMAT));
			form.setStopdate_basic(PublicUtils.formatUtilDate(zjtystdrewardVO
					.getEnddate(), DATAFORMAT));
			form.setRewardstd_basic(zjtystdrewardbjVO.getRewardstd());
			form.setRuleid_basic(zjtystdrewardbjVO.getRuleid());
			form.setAcctype_basic(zjtystdrewardbjVO.getAcctype());
			form.setIntvmonth_basic(zjtystdrewardbjVO.getIntvmonth());
			
			//市公司酬金上限设置,将省公司酬金上限提取
			if(flag == true){
				ZjtyStdrewardbjVO vo = this.getProvinceStd(zjtystdrewardbjVO, user);
				form.setRewardstd_basic_limited(vo.getRewardstd());
				form.setIntvmonth_basic_limited(vo.getIntvmonth());
			}
			
			break;
		case ZjtyRewardType.DATA_ENCOURAGE: // 数据业务奖励酬金
		case ZjtyRewardType.SERV_ENCOURAGE: // 服务业务奖励酬金
			form.setEncourageflag(true);
//			zjtystdrewardbjVO.setRewardname(zjtystdrewardVO.getRewardname());
			zjtystdrewardbjVO.setRewardname(zjtystdrewardbjVO.getRewardname());
			zjtystdrewardbjVO.setRewardtype(zjtystdrewardVO.getRewardtype());
			zjtystdrewardbjVO.setStartdate(zjtystdrewardVO.getStartdate());
			zjtystdrewardbjVO.setStopdate(zjtystdrewardVO.getEnddate());
			zjtystdrewardbjVO.setRewardproj(new Short(DEFAULT_REWARDPROJ));
			form.getOldencouragelist().add(zjtystdrewardbjVO);
			break;
		}
	}
	
	
	/**
	 * 是否含有相同酬金名称，有则返回true，否则返回false
	 * 
	 * @param rewardname
	 * @param list
	 * @return
	 */
	private boolean hasSameName(String rewardname, List list) {
		if (null == list || list.size() == 0) {
			return false;
		}
		
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			ZjtyStdrewardbjVO item = (ZjtyStdrewardbjVO) iter.next();
			if (null == item || null == item.getRewardname()) {
				continue;
			}
			if (item.getRewardname().equals(rewardname)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 当编辑奖励酬金要存入会话中时，判断奖励内是否有相同的酬金名称
	 * 
	 * @param rewardname
	 * @param list
	 * @return
	 */
	private boolean hasSameNameWhenEdit(String rewardname,String rewardname_temp,List list) throws Exception {
		if (null == list || list.size() == 0) {
			return false;
		}
		if (StringUtils.isEmpty(rewardname_temp)){
			throw new Exception("未经过编辑操作不能使用该保存按钮");
		}
		//新的名字等于旧的名字,就说明没改动过名称
		if(rewardname.equals(rewardname_temp)){
			return false;
		}
		//新的名字不等于旧的名字,不用理会那条旧记录 
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			ZjtyStdrewardbjVO item = (ZjtyStdrewardbjVO) iter.next();
			if (null == item || null == item.getRewardname()) {
				continue;
			}
			if (item.getRewardname().equals(rewardname)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 获取默认开始日期 当天
	 * 
	 * @return
	 */
	private static String getDefaultBeginDate() {
		return PublicUtils.formatUtilDate(new Date(), DATAFORMAT);
	}

	/**
	 * 获取默认终止日期 2099-01-01
	 * 
	 * @return
	 */
	private static String getDefaultEndDate() throws Exception {
		return "2099-01-01";
	}
	
	/**
	 * 获取省公司酬金上限
	 * 
	 * @param vo
	 * @param user
	 * @return
	 * @throws Exception
	 */
	private ZjtyStdrewardbjVO getProvinceStd(ZjtyStdrewardbjVO vo, User user) throws Exception {
		ZjtyStdrewardbjVO zjtystdrewardbjVO = new ZjtyStdrewardbjVO();
		zjtystdrewardbjVO.setRewardid(vo.getRewardid());
		zjtystdrewardbjVO.setRegion(DEFAULT_REGION);
		zjtystdrewardbjVO.setWayid(vo.getWayid());
		ZjtyStdrewardbjDelegate delegate = new ZjtyStdrewardbjDelegate();
		zjtystdrewardbjVO = delegate.doFindByPk(zjtystdrewardbjVO, user);
		return zjtystdrewardbjVO;
	}
	
}



