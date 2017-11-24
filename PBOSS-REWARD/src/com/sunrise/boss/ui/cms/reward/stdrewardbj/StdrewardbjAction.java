package com.sunrise.boss.ui.cms.reward.stdrewardbj;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.operation.persistent.OperationVO;
import com.sunrise.boss.business.cms.reward.stdrewardbj.persistent.StdrewardbjListVO;
import com.sunrise.boss.business.cms.reward.stdrewardbj.persistent.StdrewardbjVO;
import com.sunrise.boss.business.cms.reward.stdrewardbjnoncyc.persistent.StdrewardbjnoncycVO;
import com.sunrise.boss.business.cms.reward.stdrewardbjstar.persistent.StdrewardbjstarListVO;
import com.sunrise.boss.business.cms.reward.stdrewardbjstar.persistent.StdrewardbjstarVO;
import com.sunrise.boss.business.cms.reward.stdrewardbjway.persistent.StdrewardbjwayListVO;
import com.sunrise.boss.business.cms.reward.stdrewardbjway.persistent.StdrewardbjwayVO;
import com.sunrise.boss.business.cms.stdreward.persistent.StdrewardVO;
import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.cms.operation.OperationDelegate;
import com.sunrise.boss.delegate.cms.reward.stdrewardbj.StdrewardbjDelegate;
import com.sunrise.boss.delegate.cms.reward.stdrewardbjnoncyc.StdrewardbjnoncycDelegate;
import com.sunrise.boss.delegate.cms.reward.stdrewardbjstar.StdrewardbjstarDelegate;
import com.sunrise.boss.delegate.cms.reward.stdrewardbjway.StdrewardbjwayDelegate;
import com.sunrise.boss.delegate.cms.stdreward.StdrewardDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.cms.reward.constant.RewardType;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.pub.tools.PublicUtils;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.pub.tools.StringSplit;
import com.sunrise.boss.delegate.cms.reward.rewardslvlimit.RewardslvlimitDelegate;
import com.sunrise.boss.business.cms.reward.rewardslvlimit.persistent.RewardslvlimitVO;
import com.sunrise.boss.business.cms.reward.rewardslvlimit.persistent.RewardslvlimitListVO;

/**
 * <p>
 * Title: StdrewardbjAction
 * </p>
 * <p>
 * Description: 计件酬金上限设置
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company: SUNRISE Tech Ltd.
 * </p>
 * 
 * @author Zhang Fengchao
 * @version 1.0 2008-03-05
 */
public class StdrewardbjAction extends BaseDelegateAction {
	// 业务归属
	public final static String BUSIBELONG = "BUSIBELONG";
	public final static String CARD_BUSIBELONG = "CARD"; // 标准卡业务类
	public final static String DATA_BUSIBELONG = "DATA"; // 数据业务类
	public final static String SERV_BUSIBELONG = "SERV"; // 服务业务类

	// 分割符
	public final static String SEMICOLON = ";";
	public final static String VERTICAL = "|";

	public final static String DEFAULT_REGION = "999"; // 默认省公司区域代码
	public final static String DEFAULT_ACCTYPE = "1"; // 计酬方式 默认按笔数计算
	public final static String DEFAULT_REWARDPROJ = "1"; // 酬金项目 默认为计件酬金
	public final static String DATAFORMAT = "yyyy-MM-dd"; // 日期格式
	public final static String OLDLIST = "OLDLIST";
	public final static String NEWLIST = "NEWLIST";
	
	public final static String OLDSTARLIST = "OLDSTARLIST";
	public final static String NEWSTARLIST = "NEWSTARLIST";
	
	public final static String OLDWAYLIST = "OLDWAYLIST";
	public final static String NEWWAYLIST = "NEWWAYLIST";

	public final static Short  ISPT_NO = new Short("0");
	
	public StdrewardbjAction() {
		setVoClass(StdrewardbjVO.class);
		this.pkNameArray = new String[2];
		pkNameArray[0] = "region";
		pkNameArray[1] = "rewardid";
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

		OperationDelegate operDelegate = new OperationDelegate();
		OperationVO operationVO = operDelegate.doFindByPk(opnid, user);
		if (null == operationVO) {
			throw new Exception("根据业务代码[" + opnid + "]查询业务信息为空");
		}
		StdrewardbjForm form = (StdrewardbjForm) actionForm;
		setDefaultFormValue(form, operationVO);

		StdrewardbjDelegate stdrewardbjDelegate = new StdrewardbjDelegate();
		StdrewardDelegate stdrewardDelegate = new StdrewardDelegate();
		StdrewardbjListVO stdrewardbjListVO = new StdrewardbjListVO();
		stdrewardbjListVO.set_se_opnid(opnid);
		// 按照间隔月份排序从小到大排序
		stdrewardbjListVO.set_orderby("intvmonth,rewardid");
		stdrewardbjListVO.set_se_region(DEFAULT_REGION);

		DataPackage dp = stdrewardbjDelegate.doQuery(stdrewardbjListVO, user);
		if (null != dp && null != dp.getDatas()) {
			for (Iterator iter = dp.getDatas().iterator(); iter.hasNext();) {
				StdrewardbjVO item = (StdrewardbjVO) iter.next();
				StdrewardVO vo = stdrewardDelegate.doFindByPk(item
						.getRewardid(), user);
				setFormValue(form, vo, item, false, user);
			}
		}

		// 实现compartor接口
		ListCompare sortMethod = new ListCompare();
		Collections.sort(form.getOldencouragelist(), sortMethod);

		form.getNewencouragelist().addAll(form.getOldencouragelist());
		request.getSession().setAttribute(OLDLIST, form.getOldencouragelist());
		request.getSession().setAttribute(NEWLIST, form.getNewencouragelist());
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form
				.getNewencouragelist());
		if (!CARD_BUSIBELONG.equals(form.getBusibelong())
				&& !DATA_BUSIBELONG.equals(form.getBusibelong())
				&& !SERV_BUSIBELONG.equals(form.getBusibelong())) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"该业务无设置对应的【业务归属】或未启用暂不支持计酬，请联系省公司设置。");
			return actionMapping.findForward("error");
		} else {
			return actionMapping.findForward(getForward(form.getBusibelong(),
					false));
		}
		
		
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
		StdrewardbjForm form = (StdrewardbjForm) actionForm;
		String opnid = request.getParameter("opnid");
		if (null == opnid || opnid.trim().length() == 0) {
			throw new Exception("业务代码参数为空");
		}

		if (opnid.trim().substring(0, 4).equals("0403")) {
			request.setAttribute("prvopnid", "A");
		}

		OperationDelegate operDelegate = new OperationDelegate();
		OperationVO operationVO = operDelegate.doFindByPk(opnid, user);
		if (null == operationVO) {
			throw new Exception("根据业务代码[" + opnid + "]查询业务信息为空");
		}

		setDefaultFormValue(form, operationVO);

		StdrewardbjDelegate stdrewardbjDelegate = new StdrewardbjDelegate();
		StdrewardDelegate stdrewardDelegate = new StdrewardDelegate();
		StdrewardbjListVO stdrewardbjListVO = new StdrewardbjListVO();
		stdrewardbjListVO.set_se_opnid(opnid);
		stdrewardbjListVO.set_se_region(user.getCityid());
		DataPackage city = stdrewardbjDelegate.doQuery(stdrewardbjListVO, user);
		stdrewardbjListVO.set_se_region(DEFAULT_REGION);
		DataPackage province = stdrewardbjDelegate.doQuery(stdrewardbjListVO,
				user);
		List list = new ArrayList();
		for (Iterator iter = province.getDatas().iterator(); iter.hasNext();) {
			StdrewardbjVO item = (StdrewardbjVO) iter.next();

			boolean match = false;
			for (Iterator iter2 = city.getDatas().iterator(); iter2.hasNext();) {
				StdrewardbjVO item2 = (StdrewardbjVO) iter2.next();
				if (item.getRewardid().equals(item2.getRewardid())) {
					list.add(item2);
					match = true;
					break;
				}
			}
			if (!match) {
				item.setProvincial(true);
				list.add(item);
			}
		}

		// 实现compartor接口
		ListCompare sortMethod = new ListCompare();
		Collections.sort(list, sortMethod);

		for (Iterator iter = list.iterator(); iter.hasNext();) {
			StdrewardbjVO item = (StdrewardbjVO) iter.next();
			StdrewardVO vo = stdrewardDelegate.doFindByPk(item.getRewardid(),
					user);
			setFormValue(form, vo, item, true, user);
		}

		form.getNewencouragelist().addAll(form.getOldencouragelist());
		request.getSession().setAttribute(OLDLIST, form.getOldencouragelist());
		request.getSession().setAttribute(NEWLIST, form.getNewencouragelist());
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form
				.getNewencouragelist());

		// 如果是积分酬金的话 重新把form里面对Newencouragelist跟Oldencouragelist拿出来处理
		// 此时Newencouragelist跟Oldencouragelist变为市的跟省的数据
		if (CARD_BUSIBELONG.equals(form.getBusibelong())) {
			// 全为省的数据
			List provList = new ArrayList();
			List cityList = new ArrayList();

			for (Iterator ittOld = form.getOldencouragelist().iterator(); ittOld
					.hasNext();) {
				StdrewardbjVO item = (StdrewardbjVO) ittOld.next();
				StdrewardbjVO copy = new StdrewardbjVO();
				BeanUtils.copyProperties(copy, item);
				copy.setRegion(DEFAULT_REGION);
				provList.add(copy);
			}
			// 全为市的数据
			for (Iterator ittNew = form.getOldencouragelist().iterator(); ittNew
					.hasNext();) {
				StdrewardbjVO item = (StdrewardbjVO) ittNew.next();
				if (user.getCityid().equals(item.getRegion())) {
					cityList.add(item);
				}
			}

			// 重新排序
			Collections.sort(provList, sortMethod);
			Collections.sort(cityList, sortMethod);

			// 重置数据
			request.getSession().setAttribute(OLDLIST, provList);
			request.getSession().setAttribute(NEWLIST, cityList);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, cityList);
		}

		// 重置加载星级数据
		StdrewardbjstarDelegate starDelegate = new StdrewardbjstarDelegate();
		StdrewardbjstarListVO starlistvo = new StdrewardbjstarListVO();
		starlistvo.set_se_opnid(form.getOpnid());
		starlistvo.set_se_region(user.getCityid());
		starlistvo.set_pagesize("0");
		DataPackage starDp = starDelegate.doQuery(starlistvo, user);

		request.getSession().setAttribute(OLDSTARLIST,
				starDp.toList(StdrewardbjstarVO.class));
		request.getSession().setAttribute(NEWSTARLIST,
				starDp.toList(StdrewardbjstarVO.class));
		

		// 重置加载标准关联渠道数据
		StdrewardbjwayDelegate bjwayDelegate = new StdrewardbjwayDelegate();
		StdrewardbjwayListVO bjwayListVO = new StdrewardbjwayListVO();
		bjwayListVO.set_se_opnid(form.getOpnid());
		bjwayListVO.set_se_region(user.getCityid());
		bjwayListVO.set_pagesize("0");
		DataPackage bjwayDp = bjwayDelegate.doQuery(bjwayListVO, user);

		request.getSession().setAttribute(OLDWAYLIST,
				bjwayDp.toList(StdrewardbjwayVO.class));
		request.getSession().setAttribute(NEWWAYLIST,
				bjwayDp.toList(StdrewardbjwayVO.class));
		if (!CARD_BUSIBELONG.equals(form.getBusibelong())
				&& !DATA_BUSIBELONG.equals(form.getBusibelong())
				&& !SERV_BUSIBELONG.equals(form.getBusibelong())) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"该业务无设置对应的【业务归属】或未启用暂不支持计酬，请联系省公司设置。");
			return actionMapping.findForward("error");
		} else {
			return actionMapping.findForward(getForward(form.getBusibelong(),
					true));
		}
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
		StdrewardbjForm form = (StdrewardbjForm) actionForm;
		try{
			form.setOldencouragelist((List) request.getSession().getAttribute(OLDLIST));
			form.setNewencouragelist((List) request.getSession().getAttribute(NEWLIST));
			List list = new ArrayList();
	
			if (form.isFixedflag() || null != form.getRewardid_fixed()) {
				list.add(buildFixedVO(form, DEFAULT_REGION));
			}
			if (form.isAllowanceflag() || null != form.getRewardid_allowance()) {
				list.add(buildAllowanceVO(form, DEFAULT_REGION));
			}
			if (form.isEncourageflag()) {
				list.addAll(buildEncourageList(form.getOldencouragelist(), form.getNewencouragelist()));
			} else if (null != form.getOldencouragelist()) {
				list.addAll(buildEncourageList(form.getOldencouragelist(), new ArrayList(0)));
			}
			
			//检查RULEID的不同
			List checkRuleidList = new ArrayList();
			for(Iterator itt = list.iterator(); itt.hasNext();){
				StdrewardbjVO vo = (StdrewardbjVO)itt.next();
				if(!vo.isDeletefalg()){
					if(!checkRuleidList.contains(vo.getRuleid())){
						checkRuleidList.add(vo.getRuleid());
					}else{
						throw new Exception("同一业务下不能设置相同的校验规则["+vo.getRuleid()+"]!");
					}
				}
			}
	
			// 保存
			StdrewardbjDelegate stdrewardbjDelegate = new StdrewardbjDelegate();
			stdrewardbjDelegate.doSave(list, user);
	
			// 查询显示 只有标准卡的list才需要清,因为调用了setFormValue方法
			OperationDelegate operDelegate = new OperationDelegate();
			OperationVO operationVO = operDelegate
					.doFindByPk(form.getOpnid(), user);
			form.getOldencouragelist().clear();
			form.getNewencouragelist().clear();
			setDefaultFormValue(form, operationVO);
	
			StdrewardDelegate stdrewardDelegate = new StdrewardDelegate();
			StdrewardbjListVO stdrewardbjListVO = new StdrewardbjListVO();
			stdrewardbjListVO.set_se_opnid(form.getOpnid());
			stdrewardbjListVO.set_se_region(DEFAULT_REGION);
			DataPackage dp = stdrewardbjDelegate.doQuery(stdrewardbjListVO, user);
			if (null != dp && null != dp.getDatas()) {
				for (Iterator iter = dp.getDatas().iterator(); iter.hasNext();) {
					StdrewardbjVO item = (StdrewardbjVO) iter.next();
					StdrewardVO vo = stdrewardDelegate.doFindByPk(item
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
		}catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form.getNewencouragelist());
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
			return actionMapping.findForward(getForward(form.getBusibelong(), false));
			// TODO: handle exception
		}
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
		StdrewardbjForm form = (StdrewardbjForm) actionForm;
		try{
			form.setOldencouragelist((List) request.getSession().getAttribute(OLDLIST));
			form.setNewencouragelist((List) request.getSession().getAttribute(NEWLIST));
			List list = new ArrayList();
			if (form.isFixedflag() || null != form.getRewardid_fixed()) {
				list.add(buildFixedVO(form, user.getCityid()));
			}
			if (form.isAllowanceflag() || null != form.getRewardid_allowance()) {
				list.add(buildAllowanceVO(form, user.getCityid()));
			}
			if (form.isEncourageflag()) {
				Iterator ittOld = form.getOldencouragelist().iterator();
				Iterator ittNew = form.getNewencouragelist().iterator();
				
				while(ittOld.hasNext() && ittNew.hasNext()){
					StdrewardbjVO voOld = (StdrewardbjVO)ittOld.next();
					StdrewardbjVO voNew = (StdrewardbjVO)ittNew.next();
					if(voOld.getRewardid() == voNew.getRewardid()){
						voNew.setRegion(user.getCityid());
						list.add(voNew);
					}else{
						throw new Exception("与省积分酬金顺序达不到同步");
					}
				}
				
				while(ittOld.hasNext()){
					StdrewardbjVO item = (StdrewardbjVO)ittOld.next();
					StdrewardbjVO delVO = new StdrewardbjVO();
					BeanUtils.copyProperties(delVO, item);
					delVO.setRegion(user.getCityid());
					delVO.setDeletefalg(true);
					list.add(delVO);
				}
				
			}
			
			List starList = buildStarList((List)request.getSession().getAttribute(this.OLDSTARLIST),(List)request.getSession().getAttribute(this.NEWSTARLIST));
			List wayList = buildWayList((List)request.getSession().getAttribute(this.OLDWAYLIST),(List)request.getSession().getAttribute(this.NEWWAYLIST));
			
			// 保存
			StdrewardbjDelegate stdrewardbjDelegate = new StdrewardbjDelegate();
			stdrewardbjDelegate.doSavecity(list, user, starList, wayList);
	
			//form.getNewencouragelist().addAll(form.getOldencouragelist());
			request.getSession().setAttribute(OLDLIST, form.getOldencouragelist());
			request.getSession().setAttribute(NEWLIST, form.getNewencouragelist());
			
			request.getSession().setAttribute(OLDSTARLIST, request.getSession().getAttribute(NEWSTARLIST));
			request.getSession().setAttribute(NEWSTARLIST, request.getSession().getAttribute(NEWSTARLIST));
			
			request.getSession().setAttribute(OLDWAYLIST, request.getSession().getAttribute(NEWWAYLIST));
			request.getSession().setAttribute(NEWWAYLIST, request.getSession().getAttribute(NEWWAYLIST));
			
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form.getNewencouragelist());
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "设置保存成功");
			
			return actionMapping.findForward(getForward(form.getBusibelong(), true));
		}catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form.getNewencouragelist());
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
			return actionMapping.findForward(getForward(form.getBusibelong(), true));
		}
	}

	/**
	 * 构建固定酬金用VO
	 * 
	 * @param form
	 * @param region
	 * @return
	 * @throws Exception
	 */
	private StdrewardbjVO buildFixedVO(StdrewardbjForm form, String region)
			throws Exception {
		StdrewardbjVO vo = new StdrewardbjVO();
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
		if (!form.isFixedflag() && null != form.getRewardid_fixed()) {
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
	private StdrewardbjVO buildAllowanceVO(StdrewardbjForm form, String region)
			throws Exception {
		StdrewardbjVO vo = new StdrewardbjVO();
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
	private StdrewardbjVO buildBasicVO(StdrewardbjForm form, String region) throws Exception {
		StdrewardbjVO vo = new StdrewardbjVO();
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
			StdrewardbjVO item1 = (StdrewardbjVO) iter1.next();
			boolean match = false;
			for (Iterator iter2 = newlist.iterator(); iter2.hasNext();) {
				StdrewardbjVO item2 = (StdrewardbjVO) iter2.next();
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
		StdrewardbjForm form = (StdrewardbjForm) actionForm;
		try{
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
			
			//检查RULEID的不同
			List checkRuleidList = new ArrayList();
			for(Iterator itt = list.iterator(); itt.hasNext();){
				StdrewardbjVO vo = (StdrewardbjVO)itt.next();
				if(!vo.isDeletefalg()){
					if(!checkRuleidList.contains(vo.getRuleid())){
						checkRuleidList.add(vo.getRuleid());
					}else{
						throw new Exception("同一业务下不能设置相同的校验规则["+vo.getRuleid()+"]!");
					}
				}
			}
			
			
			// 保存
			StdrewardbjDelegate stdrewardbjDelegate = new StdrewardbjDelegate();
			stdrewardbjDelegate.doSave(list, user);
	
			// 查询显示
			OperationDelegate operDelegate = new OperationDelegate();
			OperationVO operationVO = operDelegate
					.doFindByPk(form.getOpnid(), user);
	//		form.getOldencouragelist().clear();
	//		form.getNewencouragelist().clear();
			setDefaultFormValue(form, operationVO);
	
			StdrewardDelegate stdrewardDelegate = new StdrewardDelegate();
			StdrewardbjListVO stdrewardbjListVO = new StdrewardbjListVO();
			stdrewardbjListVO.set_se_opnid(form.getOpnid());
			stdrewardbjListVO.set_se_region(DEFAULT_REGION);
			DataPackage dp = stdrewardbjDelegate.doQuery(stdrewardbjListVO, user);
			if (null != dp && null != dp.getDatas()) {
				for (Iterator iter = dp.getDatas().iterator(); iter.hasNext();) {
					StdrewardbjVO item = (StdrewardbjVO) iter.next();
					StdrewardVO vo = stdrewardDelegate.doFindByPk(item
							.getRewardid(), user);
					setFormValue(form, vo, item, false, user);
				}
			}
			
			//form.getNewencouragelist().addAll(form.getOldencouragelist());
			request.getSession().setAttribute(OLDLIST, form.getOldencouragelist());
			request.getSession().setAttribute(NEWLIST, form.getNewencouragelist());
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form.getNewencouragelist());
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "设置保存成功");
			return actionMapping.findForward(getForward(form.getBusibelong(), false));
		}catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form.getNewencouragelist());
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
			return actionMapping.findForward(getForward(form.getBusibelong(), false));
			// TODO: handle exception
		}
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
		StdrewardbjForm form = (StdrewardbjForm) actionForm;
		try{
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
			
			List starList = buildStarList((List)request.getSession().getAttribute(this.OLDSTARLIST),(List)request.getSession().getAttribute(this.NEWSTARLIST));
			List wayList = buildWayList((List)request.getSession().getAttribute(this.OLDWAYLIST),(List)request.getSession().getAttribute(this.NEWWAYLIST));
			
			// 保存
			StdrewardbjDelegate stdrewardbjDelegate = new StdrewardbjDelegate();
			stdrewardbjDelegate.doSavecity(list, user, starList, wayList);
	
			// 查询显示
			OperationDelegate operDelegate = new OperationDelegate();
			OperationVO operationVO = operDelegate.doFindByPk(form.getOpnid(), user);
			form.getOldencouragelist().clear();
			form.getNewencouragelist().clear();
			setDefaultFormValue(form, operationVO);
			
			StdrewardDelegate stdrewardDelegate = new StdrewardDelegate();
			StdrewardbjListVO stdrewardbjListVO = new StdrewardbjListVO();
			stdrewardbjListVO.set_se_opnid(form.getOpnid());
			stdrewardbjListVO.set_se_region(user.getCityid());
			DataPackage city = stdrewardbjDelegate.doQuery(stdrewardbjListVO, user);
			stdrewardbjListVO.set_se_region(DEFAULT_REGION);
			DataPackage province = stdrewardbjDelegate.doQuery(stdrewardbjListVO, user);
			
			List result = new ArrayList();
			for (Iterator iter = province.getDatas().iterator(); iter.hasNext();) {
				StdrewardbjVO item = (StdrewardbjVO) iter.next();
				
				boolean match = false;
				for (Iterator iter2 = city.getDatas().iterator(); iter2.hasNext();) {
					StdrewardbjVO item2 = (StdrewardbjVO) iter2.next();
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
				StdrewardbjVO item = (StdrewardbjVO) iter.next();
				StdrewardVO vo = stdrewardDelegate.doFindByPk(item.getRewardid(), user);
				setFormValue(form, vo, item, false, user);
			}
			
			form.getNewencouragelist().addAll(form.getOldencouragelist());
			request.getSession().setAttribute(OLDLIST, form.getOldencouragelist());
			request.getSession().setAttribute(NEWLIST, form.getNewencouragelist());
			
			request.getSession().setAttribute(OLDSTARLIST, request.getSession().getAttribute(NEWSTARLIST));
			request.getSession().setAttribute(NEWSTARLIST, request.getSession().getAttribute(NEWSTARLIST));
			
			request.getSession().setAttribute(OLDWAYLIST, request.getSession().getAttribute(NEWWAYLIST));
			request.getSession().setAttribute(NEWWAYLIST, request.getSession().getAttribute(NEWWAYLIST));
			
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form.getNewencouragelist());
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "设置保存成功");
			return actionMapping.findForward(getForward(form.getBusibelong(), true));
		}catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form.getNewencouragelist());
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
			return actionMapping.findForward(getForward(form.getBusibelong(), true));
		}
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
		StdrewardbjForm form = (StdrewardbjForm) actionForm;
		String pk = request.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
		form.setRowIndex(request.getParameter("ROWINDEX"));
		if (pk == null) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"pk is required.");
			return actionMapping.findForward(getForward(form.getBusibelong(), false));
		}

		form.setOldencouragelist((List) request.getSession().getAttribute(OLDLIST));
		form.setNewencouragelist((List) request.getSession().getAttribute(NEWLIST));
		List list = form.getNewencouragelist();
		StdrewardbjVO stdrewardbjVO = null;

		String[] arr = StringSplit.split(pk, VERTICAL);
		String rewardid = arr[0];
		String temprewardid = "";
		if (arr.length >= 2) {
			temprewardid = arr[1];
		}
		if (null != rewardid && rewardid.length() > 0) {
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				StdrewardbjVO item = (StdrewardbjVO) iter.next();
				if (null == item || null == item.getRewardid()) {
					continue;
				}
				if (item.getRewardid().toString().equals(rewardid)) {
					stdrewardbjVO = item;
					break;
				}
			}
		} else if (null != temprewardid && temprewardid.length() > 0) {
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				StdrewardbjVO item = (StdrewardbjVO) iter.next();
				if (null == item || null == item.getTemprewardid()) {
					continue;
				}
				if (item.getTemprewardid().toString().equals(temprewardid)) {
					stdrewardbjVO = item;
					break;
				}
			}
		}

		if (null == stdrewardbjVO) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"pk is error, nothing match.");
			return actionMapping.findForward(getForward(form.getBusibelong(), false));
		}

		if (null != stdrewardbjVO.getRewardid()) {
			form.setRewardid_encourage(stdrewardbjVO.getRewardid());
		} else {
			form.setRewardid_encourage(stdrewardbjVO.getTemprewardid());
		}
		form.setRewardname_encourage(stdrewardbjVO.getRewardname());
		form.setRewardtype_encourage(stdrewardbjVO.getRewardtype());
		form.setStartdate_encourage(PublicUtils.formatUtilDate(stdrewardbjVO
				.getStartdate(), DATAFORMAT));
		form.setStopdate_encourage(PublicUtils.formatUtilDate(stdrewardbjVO
				.getStopdate(), DATAFORMAT));
		form.setRewardstd_encourage(stdrewardbjVO.getRewardstd());
		form.setRuleid_encourage(stdrewardbjVO.getRuleid());
		form.setIntvmonth_encourage(stdrewardbjVO.getIntvmonth());

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
		StdrewardbjForm form = (StdrewardbjForm) actionForm;
		String pk = request.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
		form.setRowIndex(request.getParameter("ROWINDEX"));
		if (pk == null) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"pk is required.");
			return actionMapping.findForward(getForward(form.getBusibelong(), true));
		}

		form.setOldencouragelist((List) request.getSession().getAttribute(OLDLIST));
		form.setNewencouragelist((List) request.getSession().getAttribute(NEWLIST));
		List list = form.getNewencouragelist();
		StdrewardbjVO stdrewardbjVO = null;

		String[] arr = StringSplit.split(pk, VERTICAL);
		String rewardid = arr[0];
		String temprewardid = "";
		if (arr.length >= 2) {
			temprewardid = arr[1];
		}
		if (null != rewardid && rewardid.length() > 0) {
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				StdrewardbjVO item = (StdrewardbjVO) iter.next();
				if (null == item || null == item.getRewardid()) {
					continue;
				}
				if (item.getRewardid().toString().equals(rewardid)) {
					stdrewardbjVO = item;
					break;
				}
			}
		} else if (null != temprewardid && temprewardid.length() > 0) {
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				StdrewardbjVO item = (StdrewardbjVO) iter.next();
				if (null == item || null == item.getTemprewardid()) {
					continue;
				}
				if (item.getTemprewardid().toString().equals(temprewardid)) {
					stdrewardbjVO = item;
					break;
				}
			}
		}

		if (null == stdrewardbjVO) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"pk is error, nothing match.");
			return actionMapping.findForward(getForward(form.getBusibelong(), true));
		}

		if (null != stdrewardbjVO.getRewardid()) {
			form.setRewardid_encourage(stdrewardbjVO.getRewardid());
		} else {
			form.setRewardid_encourage(stdrewardbjVO.getTemprewardid());
		}
		form.setRewardname_encourage(stdrewardbjVO.getRewardname());
		form.setRewardtype_encourage(stdrewardbjVO.getRewardtype());
		form.setStartdate_encourage(PublicUtils.formatUtilDate(stdrewardbjVO
				.getStartdate(), DATAFORMAT));
		form.setStopdate_encourage(PublicUtils.formatUtilDate(stdrewardbjVO
				.getStopdate(), DATAFORMAT));
		form.setRuleid_encourage(stdrewardbjVO.getRuleid());
		
		if(!stdrewardbjVO.getRegion().equals(DEFAULT_REGION)){
			form.setIntvmonth_encourage(stdrewardbjVO.getIntvmonth());
			form.setRewardstd_encourage(stdrewardbjVO.getRewardstd());
		}
		
		StdrewardbjVO provinceVO = new StdrewardbjVO();
		provinceVO.setRewardid(form.getRewardid_encourage());
		provinceVO = this.getProvinceStd(provinceVO, user);
		
		//市公司酬金上限设置,将省公司酬金上限提取
		form.setRewardstd_encourage_limited(provinceVO.getRewardstd());
		form.setIntvmonth_encourage_limited(provinceVO.getIntvmonth());

		
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
		StdrewardbjForm form = (StdrewardbjForm) actionForm;
		form.setOldencouragelist((List) request.getSession().getAttribute(OLDLIST));
		form.setNewencouragelist((List) request.getSession().getAttribute(NEWLIST));
		if (hasSameName(form.getRewardname_encourage(), form.getNewencouragelist())) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, 
					"酬金名称 [" + form.getRewardname_encourage() + "] 已经存在，名称不允许重复，请修改");
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form.getNewencouragelist());
			return actionMapping.findForward(getForward(form.getBusibelong(), false));
		}
		
		StdrewardbjVO stdrewardbjVO = new StdrewardbjVO();
		stdrewardbjVO.setTemprewardid(new Long(Sequence.getSequence()));
		stdrewardbjVO.setRegion(DEFAULT_REGION);
		stdrewardbjVO.setAcctype(new Short(DEFAULT_ACCTYPE));
		stdrewardbjVO.setOpnid(form.getOpnid());
		stdrewardbjVO.setRewardstd(form.getRewardstd_encourage());
		stdrewardbjVO.setIntvmonth(form.getIntvmonth_encourage());
		stdrewardbjVO.setRuleid(form.getRuleid_encourage());
		stdrewardbjVO.setRewardname(form.getRewardname_encourage());
		stdrewardbjVO.setRewardtype(form.getRewardtype_encourage());
		stdrewardbjVO.setStartdate(PublicUtils.UtilStrToDate(form
				.getStartdate_encourage(), DATAFORMAT));
		stdrewardbjVO.setStopdate(PublicUtils.UtilStrToDate(form
				.getStopdate_encourage(), DATAFORMAT));
		stdrewardbjVO.setRewardproj(new Short(DEFAULT_REWARDPROJ));

		//reset encourage values
		form.getNewencouragelist().add(stdrewardbjVO);
		if(form.getRewardtype_encourage().intValue() == RewardType.CARD_INTEGRAL){
			form.setRewardname_encourage(form.getOpnname()
					+ getOpnname(form.getBusibelong()) + "积分酬金");
		}else{
			form.setRewardname_encourage(form.getOpnname()
					+ getOpnname(form.getBusibelong()) + "奖励酬金");
		}
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
		StdrewardbjForm form = (StdrewardbjForm) actionForm;
		form.setOldencouragelist((List) request.getSession().getAttribute(OLDLIST));
		form.setNewencouragelist((List) request.getSession().getAttribute(NEWLIST));
		if (null == form.getRewardid_encourage()) {
			if(form.getRewardtype_encourage().intValue() == RewardType.CARD_INTEGRAL){
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "积分酬金标识为空");
			}else{
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "奖励酬金标识为空");
			}
			return actionMapping.findForward(getForward(form.getBusibelong(), false));
		}
		
		String rewardid = form.getRewardid_encourage().toString();
		List list = form.getNewencouragelist();
		int matchIndex = -1;
		for (int i = 0; i < list.size(); i++) {
			StdrewardbjVO item = (StdrewardbjVO) list.get(i);
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
			if(form.getRewardtype_encourage().intValue() == RewardType.CARD_INTEGRAL){
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "积分酬金标识["
						+ rewardid + "]匹配结果为空");
			}else{
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "奖励酬金标识["
						+ rewardid + "]匹配结果为空");
			}
			return actionMapping.findForward(getForward(form.getBusibelong(), false));
		}
		
		//update encourage list value
		StdrewardbjVO item = (StdrewardbjVO) list.get(matchIndex);
		item.setRewardname(form.getRewardname_encourage());
		item.setStartdate(PublicUtils.UtilStrToDate(form
				.getStartdate_encourage(), DATAFORMAT));
		item.setStopdate(PublicUtils.UtilStrToDate(form
				.getStopdate_encourage(), DATAFORMAT));
		item.setRewardstd(form.getRewardstd_encourage());
		item.setIntvmonth(form.getIntvmonth_encourage());
		item.setRuleid(form.getRuleid_encourage());
		
		StdrewardbjVO stdrewardbjVO = new StdrewardbjVO();
		BeanUtils.copyProperties(stdrewardbjVO, item);
		list.remove(matchIndex);
		list.add(matchIndex, stdrewardbjVO);

		// reset encourage values
		if(form.getRewardtype_encourage().intValue() == RewardType.CARD_INTEGRAL){
			form.setRewardname_encourage(form.getOpnname()
					+ getOpnname(form.getBusibelong()) + "积分酬金");
		}else{
			form.setRewardname_encourage(form.getOpnname()
					+ getOpnname(form.getBusibelong()) + "奖励酬金");
		}
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
		StdrewardbjForm form = (StdrewardbjForm) actionForm;
		form.setOldencouragelist((List) request.getSession().getAttribute(OLDLIST));
		form.setNewencouragelist((List) request.getSession().getAttribute(NEWLIST));
		if (null == form.getRewardid_encourage()) {
			if(form.getRewardtype_encourage().intValue() == RewardType.CARD_INTEGRAL){
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "积分酬金标识为空");
			}else{
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "奖励酬金标识为空");
			}
			return actionMapping.findForward(getForward(form.getBusibelong(), true));
		}
		
		String rewardid = form.getRewardid_encourage().toString();
		List list = form.getNewencouragelist();
		int matchIndex = -1;
		for (int i = 0; i < list.size(); i++) {
			StdrewardbjVO item = (StdrewardbjVO) list.get(i);
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
			if(form.getRewardtype_encourage().intValue() == RewardType.CARD_INTEGRAL){
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "积分酬金标识["
						+ rewardid + "]匹配结果为空");
			}else{
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "奖励酬金标识["
						+ rewardid + "]匹配结果为空");
			}
			return actionMapping.findForward(getForward(form.getBusibelong(), true));
		}
		
		//检查酬金设置是否大于省公司上限
		StdrewardbjVO item = (StdrewardbjVO) list.get(matchIndex);
		
		//update encourage list value
		item.setRewardname(form.getRewardname_encourage());
		item.setStartdate(PublicUtils.UtilStrToDate(form
				.getStartdate_encourage(), DATAFORMAT));
		item.setStopdate(PublicUtils.UtilStrToDate(form
				.getStopdate_encourage(), DATAFORMAT));
		item.setRewardstd(form.getRewardstd_encourage());
		item.setIntvmonth(form.getIntvmonth_encourage());
		item.setRuleid(form.getRuleid_encourage());
		
		StdrewardbjVO stdrewardbjVO = new StdrewardbjVO();
		BeanUtils.copyProperties(stdrewardbjVO, item);
		list.remove(matchIndex);
		list.add(matchIndex, stdrewardbjVO);

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
		StdrewardbjForm form = (StdrewardbjForm) actionForm;
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
				StdrewardbjVO item = (StdrewardbjVO) list.get(j);
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
		}

		return "";
	}

	/**
	 * 设置form中酬金相关默认值
	 * 
	 * @param form
	 * @param operationVO
	 */
	private void setDefaultFormValue(StdrewardbjForm form,
			OperationVO operationVO) throws Exception {
		if (null == operationVO.getBusibelong()
				|| operationVO.getBusibelong().trim().length() == 0) {
			return;
		}

		String beginDate = getDefaultBeginDate();
		String endDate = getDefaultEndDate();
		form.setOpnid(operationVO.getOpnid());
		form.setOpnname(operationVO.getName());
		form.setOpnstate(operationVO.getState());
		form.setBusibelong(operationVO.getBusibelong());
		if (CARD_BUSIBELONG.equals(operationVO.getBusibelong())) {
			form.setRewardname_fixed(operationVO.getName() + "标准卡固定酬金");
			form.setRewardtype_fixed(new Short("" + RewardType.CARD_FIXED));
			form.setStartdate_fixed(beginDate);
			form.setStopdate_fixed(endDate);

			form.setRewardname_encourage(operationVO.getName() + "标准卡积分酬金");
			form.setRewardtype_encourage(new Short(""
							+ RewardType.CARD_INTEGRAL));
			form.setStartdate_encourage(beginDate);
			form.setStopdate_encourage(endDate);

			form.setRewardname_allowance(operationVO.getName() + "标准卡专门津贴");
			form.setRewardtype_allowance(new Short(""
					+ RewardType.CARD_ALLOWANCE));
			form.setStartdate_allowance(beginDate);
			form.setStopdate_allowance(endDate);
		} else if (DATA_BUSIBELONG.equals(operationVO.getBusibelong())) {
			form.setRewardname_basic(operationVO.getName() + "数据业务基本酬金");
			form.setRewardtype_basic(new Short("" + RewardType.DATA_BASIC));
			form.setStartdate_basic(beginDate);
			form.setStopdate_basic(endDate);

			form.setRewardname_encourage(operationVO.getName() + "数据业务奖励酬金");
			form.setRewardtype_encourage(new Short(""
					+ RewardType.DATA_ENCOURAGE));
			form.setStartdate_encourage(beginDate);
			form.setStopdate_encourage(endDate);
		} else if (SERV_BUSIBELONG.equals(operationVO.getBusibelong())) {
			form.setRewardname_basic(operationVO.getName() + "服务业务基本酬金");
			form.setRewardtype_basic(new Short("" + RewardType.SERV_BASIC));
			form.setStartdate_basic(beginDate);
			form.setStopdate_basic(endDate);
			form.setAcctype_basic(new Short(DEFAULT_ACCTYPE));

			form.setRewardname_encourage(operationVO.getName() + "服务业务奖励酬金");
			form.setRewardtype_encourage(new Short(""
					+ RewardType.SERV_ENCOURAGE));
			form.setStartdate_encourage(beginDate);
			form.setStopdate_encourage(endDate);
		}
	}

	/**
	 * 设置form中酬金相关值
	 * 
	 * @param form
	 * @param stdrewardbjVO
	 * @param stdrewardVO
	 * @param flag
	 */
	private void setFormValue(StdrewardbjForm form, StdrewardVO stdrewardVO,
			StdrewardbjVO stdrewardbjVO, boolean flag, User user) throws Exception {
		if (null == stdrewardVO || null == stdrewardVO.getRewardtype()) {
			return;
		}

		switch (stdrewardVO.getRewardtype().intValue()) {
		case RewardType.CARD_FIXED: // 标准卡固定酬金
			form.setFixedflag(true);
			form.setRewardid_fixed(stdrewardVO.getRewardid());
			form.setRewardname_fixed(stdrewardVO.getRewardname());
			form.setRewardtype_fixed(stdrewardVO.getRewardtype());
			form.setStartdate_fixed(PublicUtils.formatUtilDate(stdrewardVO
					.getStartdate(), DATAFORMAT));
			form.setStopdate_fixed(PublicUtils.formatUtilDate(stdrewardVO
					.getStopdate(), DATAFORMAT));
			form.setRewardstd_fixed(stdrewardbjVO.getRewardstd());
			form.setRuleid_fixed(stdrewardbjVO.getRuleid());
			form.setIntvmonth_fixed(stdrewardbjVO.getIntvmonth());
			
			//市公司酬金上限设置,将省公司酬金上限提取
			if(flag == true){
				StdrewardbjVO vo = this.getProvinceStd(stdrewardbjVO, user);
				form.setRewardstd_fixed_limited(vo.getRewardstd());
				form.setIntvmonth_fixed_limited(vo.getIntvmonth());
				
				if(stdrewardbjVO.isProvincial()){
					form.setRewardstd_fixed(null);
					form.setIntvmonth_fixed(null);
				}
			}
			
			break;
		case RewardType.CARD_ALLOWANCE: // 标准卡专门津贴
			form.setAllowanceflag(true);
			form.setRewardid_allowance(stdrewardVO.getRewardid());
			form.setRewardname_allowance(stdrewardVO.getRewardname());
			form.setRewardtype_allowance(stdrewardVO.getRewardtype());
			form.setStartdate_allowance(PublicUtils.formatUtilDate(stdrewardVO
					.getStartdate(), DATAFORMAT));
			form.setStopdate_allowance(PublicUtils.formatUtilDate(stdrewardVO
					.getStopdate(), DATAFORMAT));
			form.setRewardstd_allowance(stdrewardbjVO.getRewardstd());
			form.setRuleid_allowance(stdrewardbjVO.getRuleid());
			form.setIntvmonth_allowance(stdrewardbjVO.getIntvmonth());
			
			//市公司酬金上限设置,将省公司酬金上限提取
			if(flag == true){
				StdrewardbjVO vo = this.getProvinceStd(stdrewardbjVO, user);
				form.setRewardstd_allowance_limited(vo.getRewardstd());
				form.setIntvmonth_allowance_limited(vo.getIntvmonth());
				
				if(stdrewardbjVO.isProvincial()){
					form.setRewardstd_allowance(null);
					form.setIntvmonth_allowance(null);
				}
			}
			
			break;
		case RewardType.DATA_BASIC: // 数据业务基本酬金
		case RewardType.SERV_BASIC: // 服务业务基本酬金
			form.setBasicflag(true);
			form.setRewardid_basic(stdrewardVO.getRewardid());
			form.setRewardname_basic(stdrewardVO.getRewardname());
			form.setRewardtype_basic(stdrewardVO.getRewardtype());
			form.setStartdate_basic(PublicUtils.formatUtilDate(stdrewardVO
					.getStartdate(), DATAFORMAT));
			form.setStopdate_basic(PublicUtils.formatUtilDate(stdrewardVO
					.getStopdate(), DATAFORMAT));
			form.setRewardstd_basic(stdrewardbjVO.getRewardstd());
			form.setRuleid_basic(stdrewardbjVO.getRuleid());
			form.setAcctype_basic(stdrewardbjVO.getAcctype());
			form.setIntvmonth_basic(stdrewardbjVO.getIntvmonth());
			
			//市公司酬金上限设置,将省公司酬金上限提取
			if(flag == true){
				StdrewardbjVO vo = this.getProvinceStd(stdrewardbjVO, user);
				form.setRewardstd_basic_limited(vo.getRewardstd());
				form.setIntvmonth_basic_limited(vo.getIntvmonth());
				
				if(stdrewardbjVO.isProvincial()){
					form.setRewardstd_basic(null);
					form.setIntvmonth_basic(null);
				}
			}
			
			break;
		case RewardType.DATA_ENCOURAGE: // 数据业务奖励酬金
		case RewardType.SERV_ENCOURAGE: // 服务业务奖励酬金
		case RewardType.CARD_INTEGRAL: // 标准卡积分酬金 当作 奖励酬金处理
			form.setEncourageflag(true);
			stdrewardbjVO.setRewardname(stdrewardVO.getRewardname());
			stdrewardbjVO.setRewardtype(stdrewardVO.getRewardtype());
			stdrewardbjVO.setStartdate(stdrewardVO.getStartdate());
			stdrewardbjVO.setStopdate(stdrewardVO.getStopdate());
			stdrewardbjVO.setRewardproj(new Short(this.DEFAULT_REWARDPROJ));
			form.getOldencouragelist().add(stdrewardbjVO);
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
			StdrewardbjVO item = (StdrewardbjVO) iter.next();
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
	private StdrewardbjVO getProvinceStd(StdrewardbjVO vo, User user) throws Exception {
		StdrewardbjVO stdrewardbjVO = new StdrewardbjVO();
		stdrewardbjVO.setRewardid(vo.getRewardid());
		stdrewardbjVO.setRegion(DEFAULT_REGION);
		StdrewardbjDelegate delegate = new StdrewardbjDelegate();
		stdrewardbjVO = delegate.doFindByPk(stdrewardbjVO, user);
		return stdrewardbjVO;
	}
	
	/**
	 * 读取省数据,数据放在OldEncourageList里面,地市数据放在NewEncourageList里面
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doLoadcityencourage(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		StdrewardbjForm form = (StdrewardbjForm) actionForm;
		
		form.setOldencouragelist((List) request.getSession().getAttribute(OLDLIST));
		form.setNewencouragelist((List) request.getSession().getAttribute(NEWLIST));
		
		List listOld = form.getOldencouragelist();
		List listNew = form.getNewencouragelist();
		if(listOld.size() == listNew.size()){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, 
					"已经达到省积分酬金条数最大值:"+listOld.size()+"条");
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form.getNewencouragelist());
			return actionMapping.findForward(getForward(form.getBusibelong(), true));
		}
		
		Iterator ittOld = listOld.iterator();
		Iterator ittNew = listNew.iterator();
		
		while(ittOld.hasNext() && ittNew.hasNext()){
			StdrewardbjVO voOld = (StdrewardbjVO)ittOld.next();
			StdrewardbjVO voNew = (StdrewardbjVO)ittNew.next();
			if(!voOld.getRewardid().equals(voNew.getRewardid())){
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, 
						"与省积分酬金顺序达不到同步");
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form.getNewencouragelist());
				return actionMapping.findForward(getForward(form.getBusibelong(), true));
			}
		}
		
		StdrewardbjVO stdrewardbjVO = (StdrewardbjVO) ittOld.next();
		
		form.setRewardid_encourage(stdrewardbjVO.getRewardid());
		form.setRewardname_encourage(stdrewardbjVO.getRewardname());
		form.setRewardtype_encourage(stdrewardbjVO.getRewardtype());
		form.setStartdate_encourage(PublicUtils.formatUtilDate(stdrewardbjVO
				.getStartdate(), DATAFORMAT));
		form.setStopdate_encourage(PublicUtils.formatUtilDate(stdrewardbjVO
				.getStopdate(), DATAFORMAT));
		form.setRuleid_encourage(stdrewardbjVO.getRuleid());
		form.setIntvmonth_encourage(null);
		form.setRewardstd_encourage(null);
		
		StdrewardbjVO provinceVO = new StdrewardbjVO();
		provinceVO.setRewardid(form.getRewardid_encourage());
		provinceVO = this.getProvinceStd(provinceVO, user);
		
		//市公司酬金上限设置,将省公司酬金上限提取
		form.setRewardstd_encourage_limited(provinceVO.getRewardstd());
		form.setIntvmonth_encourage_limited(provinceVO.getIntvmonth());
		
		request.getSession().setAttribute(OLDLIST, form.getOldencouragelist());
		request.getSession().setAttribute(NEWLIST, form.getNewencouragelist());
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form.getNewencouragelist());
		request.setAttribute(WebConstant.COMMAND_STRING_EDIT, "LOAD");
		request.getSession().setAttribute(WebConstant.COMMAND_STRING_EDIT, "LOAD");
		return actionMapping.findForward(getForward(form.getBusibelong(), true));
		
	}
	
	
	/**
	 * 读取省数据,数据放在OldEncourageList里面,地市数据放在NewEncourageList里面
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doSavecityencourage2(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		StdrewardbjForm form = (StdrewardbjForm) actionForm;
		form.setOldencouragelist((List) request.getSession().getAttribute(OLDLIST));
		form.setNewencouragelist((List) request.getSession().getAttribute(NEWLIST));
		String str = (String) request.getSession().getAttribute(WebConstant.COMMAND_STRING_EDIT);
		if(!"LOAD".equals(str)){
			return this.doSavecityencourage(actionMapping, actionForm, request, response, user);
		}
		request.getSession().setAttribute(WebConstant.COMMAND_STRING_EDIT,null);
		
		StdrewardbjVO item = (StdrewardbjVO) form.getOldencouragelist().get(form.getNewencouragelist().size());
		item.setRewardname(form.getRewardname_encourage());
		item.setStartdate(PublicUtils.UtilStrToDate(form
				.getStartdate_encourage(), DATAFORMAT));
		item.setStopdate(PublicUtils.UtilStrToDate(form
				.getStopdate_encourage(), DATAFORMAT));
		item.setRewardstd(form.getRewardstd_encourage());
		item.setIntvmonth(form.getIntvmonth_encourage());
		item.setRuleid(form.getRuleid_encourage());
		
		StdrewardbjVO stdrewardbjVO = new StdrewardbjVO();
		BeanUtils.copyProperties(stdrewardbjVO, item);

		// reset encourage values
		form.setRewardname_encourage("");
		form.setStartdate_encourage("");
		form.setStopdate_encourage("");
		form.setRewardstd_encourage(null);
		form.setIntvmonth_encourage(null);
		form.setRuleid_encourage("");
		
		form.getNewencouragelist().add(stdrewardbjVO);
		
		request.getSession().setAttribute(OLDLIST, form.getOldencouragelist());
		request.getSession().setAttribute(NEWLIST, form.getNewencouragelist());
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form.getNewencouragelist());
		return actionMapping.findForward(getForward(form.getBusibelong(), true));
	}
	
	public ActionForward doDelencourage2(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		StdrewardbjForm form = (StdrewardbjForm) actionForm;
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
				StdrewardbjVO item = (StdrewardbjVO) list.get(j);
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
		return actionMapping.findForward(getForward(form.getBusibelong(), true));
	}
	
	/**
	 * 从session里面过滤条件弹出弹出框
	 * @param oldStarList
	 * @param form
	 * @param user
	 * @return
	 * @throws Exception
	 */
	private List findInStarList(List oldStarList, StdrewardbjForm form, User user) throws Exception{
		List list = new ArrayList();
		if(oldStarList == null || oldStarList.size() == 0){
			return list;
		}else{
			for(Iterator itt = oldStarList.iterator(); itt.hasNext(); ){
				StdrewardbjstarVO vo = (StdrewardbjstarVO)itt.next();
				if(vo.getRewardid().equals(form.getS_rewardid()) && vo.getRegion().equals(user.getCityid())){
					list.add(vo);
				}
			}
			return list;
		}
	}
	
	/**
	 * 从waysession里面过滤条件弹出弹出框
	 * @param oldWayList
	 * @param form
	 * @param user
	 * @return
	 * @throws Exception
	 */
	private List findInWayList(List oldWayList, StdrewardbjForm form, User user) throws Exception{
		List list = new ArrayList();
		if(oldWayList == null || oldWayList.size() == 0){
			return list;
		}else{
			for(Iterator itt = oldWayList.iterator(); itt.hasNext(); ){
				StdrewardbjwayVO vo = (StdrewardbjwayVO)itt.next();
				if(vo.isDeleteFlag()){ //预删除的不显示到list列表里面
					continue;
				}
				if(vo.getRewardid().equals(form.getS_rewardid()) && vo.getRegion().equals(user.getCityid())){
					if(StringUtils.isEmpty(form.getS_wayid())){
						list.add(vo);
					}else{
						if(vo.getWayid().indexOf(form.getS_wayid()) != -1){ //不符合查询条件的不显示到list列表里面
							list.add(vo);
						}
					}
				}
			}
			return list;
		}
	}
	
	/**
	 * 更新最新的starList
	 * @param oldStarList
	 * @param newStarList
	 * @return
	 * @throws Exception
	 */
	private List updateStarList(List oldStarList, List newStarList) throws Exception{
		if(oldStarList == null || oldStarList.size() == 0){
			return newStarList;
		}else{
			List oldList = new ArrayList();
			oldList.addAll(oldStarList);
			
			for(Iterator ittOld = oldStarList.iterator(); ittOld.hasNext(); ){
				StdrewardbjstarVO oldVO = (StdrewardbjstarVO)ittOld.next();
				for(Iterator ittNew = newStarList.iterator(); ittNew.hasNext(); ){
					StdrewardbjstarVO newVO = (StdrewardbjstarVO)ittNew.next();
					if(newVO.getRewardid().equals(oldVO.getRewardid()) && newVO.getRegion().equals(oldVO.getRegion()) && newVO.getStar().equals(oldVO.getStar())){
						oldList.remove(oldVO);
						break;
					}
				}
			}
			oldList.addAll(newStarList);
			return oldList;
		}
	}
	
	public ActionForward doShowcitystar(ActionMapping actionMapping,ActionForm actionForm, HttpServletRequest request,	HttpServletResponse response, User user) throws Exception {
		StdrewardbjForm form = (StdrewardbjForm) actionForm;
		
		//加载网点酬金总额封顶 
		RewardslvlimitDelegate limitDelegate = new RewardslvlimitDelegate();
		RewardslvlimitListVO limitlistvo = new RewardslvlimitListVO();
		limitlistvo.set_pagesize("0");
		limitlistvo.set_se_opnid(form.getS_opnid());
		limitlistvo.set_se_region(user.getCityid());
		limitlistvo.set_ne_rewardid(form.getS_rewardid().toString());
		DataPackage limitDp = limitDelegate.doQuery(limitlistvo, user);
		List<RewardslvlimitVO> limitlist = limitDp.toList(RewardslvlimitVO.class);
		for(Iterator<RewardslvlimitVO> iter=limitlist.iterator();iter.hasNext();){
			RewardslvlimitVO vo = iter.next();
			short slv = vo.getSlv();
			switch(slv){
				case 0:
					form.setUplimit_level_non(vo.getRewardlimit());
					break;
				case 1:
					form.setUplimit_level_1(vo.getRewardlimit());
					break;
				case 2:
					form.setUplimit_level_2(vo.getRewardlimit());
					break;
				case 3:
					form.setUplimit_level_3(vo.getRewardlimit());
					break;
				case 4:
					form.setUplimit_level_4(vo.getRewardlimit());
					break;
				case 5:
					form.setUplimit_level_5(vo.getRewardlimit());
					break;
				case 6:
					form.setUplimit_level_6(vo.getRewardlimit());
					break;
			}
		}
		
		List list = findInStarList((List)request.getSession().getAttribute(NEWSTARLIST),form,user);
		
		//如果list拿回来是0或者是有任何一条是要删除的,则直接跳到统一设置酬金模式
		if(list.size() == 0 || ((StdrewardbjstarVO)list.get(0)).isDeleteFlag()){
			form.setS_starflag("1");
			return actionMapping.findForward("citystarcontent");
		}else{
			form.setS_starflag("2");
		}
		
		for(Iterator itt = list.iterator();itt.hasNext();){
			StdrewardbjstarVO vo = (StdrewardbjstarVO) itt.next();
			switch (vo.getStar().shortValue()) {
				case 1:
					form.setRewardstd_onestar(vo.getRewardstd());
					break;
				case 2:
					form.setRewardstd_twostar(vo.getRewardstd());
					//设置 是否排它 单排它 双排它 modify by laixueguang 2010-3-10
					if(vo.getIspt() == null){
						vo.setIspt(new Short("0"));
						vo.setSinglept(new Double("0.0"));
						vo.setDiploidpt(new Double("0.0"));
					}
					if(vo.getRewardstd() == null){
						form.setRewardstd_twostar(new Double("0.0"));
					}
					form.setIspt(vo.getIspt());
					form.setSinglept(vo.getSinglept());
					form.setDiploidpt(vo.getDiploidpt());
					break;
				case 3:
					form.setRewardstd_threestar(vo.getRewardstd());
					break;
				case 4:
					form.setRewardstd_fourstar(vo.getRewardstd());
					break;
				case 5:
					form.setRewardstd_fivestar(vo.getRewardstd());
					break;
				case 6:
					form.setRewardstd_sixstar(vo.getRewardstd());
					break;
			}
		}
		return actionMapping.findForward("citystarcontent");
	}
	
	public ActionForward doShowcityway(ActionMapping actionMapping,ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		StdrewardbjForm form = (StdrewardbjForm) actionForm;
		List list = findInWayList((List)request.getSession().getAttribute(NEWWAYLIST),form,user);
		DataPackage dp = new DataPackage();
		dp.setPageSize(list.size());
		dp.setPageNo(1);
		dp.setPageSize(0);
		dp.setDatas(list);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		return actionMapping.findForward("citywaylist");
	}
	
	/**
	 * 跳入新增界面
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doEditcityway(ActionMapping actionMapping,ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		StdrewardbjForm form = (StdrewardbjForm) actionForm;
		String[] pks = StringSplit.split(request.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK), "|");
		form.setS_rewardid(new Long(pks[1]));
		form.setS_wayid(pks[2]);
		form.setS_opnid(pks[3]);
		form.setS_acctype(new Short(pks[4]));
		form.setS_ruleid(pks[5]);
		form.setS_cityrewardstd(new Double(pks[6]));
		return actionMapping.findForward("citywaycontent");
	}
	
	/**
	 * 跳入新增界面
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doNewcityway(ActionMapping actionMapping,ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		StdrewardbjForm form = (StdrewardbjForm) actionForm;
		form.setS_wayid(null);
		form.setS_cityrewardstd(null);
		((BaseActionForm) actionForm).setCmdState("NEWCITYWAY");
		return actionMapping.findForward("citywaycontent");
	}
	
	/**
	 * 预保存wayList
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doSavecityway(ActionMapping actionMapping,ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		StdrewardbjForm form = (StdrewardbjForm) actionForm;
		try{
			String cmdState = request.getParameter("NEWCMD");
			List list = new ArrayList();
			StdrewardbjwayVO bjwayVO = new StdrewardbjwayVO();
			bjwayVO.setAcctype(form.getS_acctype());
			bjwayVO.setOpnid(form.getS_opnid());
			bjwayVO.setRegion(user.getCityid());
			bjwayVO.setRewardid(form.getS_rewardid());
			bjwayVO.setRewardstd(form.getS_cityrewardstd());
			bjwayVO.setRuleid(form.getS_ruleid());
			bjwayVO.setWayid(form.getS_wayid());
			if("NEWCITYWAY".equals(cmdState)){
				CommonDelegate delegate = new CommonDelegate(WayVO.class);
				WayListVO listvo = new WayListVO();
				listvo.set_se_upperwayid(bjwayVO.getWayid());
				DataPackage dp = delegate.doQuery(listvo, user);
				if(dp.getDatas() != null && dp.getDatas().size() != 0){
					throw new Exception("只能选择最底层的渠道!");
				}
			}else{
				bjwayVO.setUpdateFlag(true);
			}
			list.add(bjwayVO);
			request.getSession().setAttribute(NEWWAYLIST, updateWayList(list, (List)request.getSession().getAttribute(NEWWAYLIST), cmdState));
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功!");
		}catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
			// TODO: handle exception
		}
		return actionMapping.findForward("citywaycontent");
	}
		
	
	/**
	 * 预删除wayList
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doDeletecityway(ActionMapping actionMapping,ActionForm actionForm, HttpServletRequest request,	HttpServletResponse response, User user) throws Exception {
		StdrewardbjForm form = (StdrewardbjForm) actionForm;
		List list = (List)request.getSession().getAttribute(NEWWAYLIST);
		List delList = new ArrayList();
		String[] citywayPkNameArray = new String[]{"region","rewardid","wayid","opnid","acctype","ruleid"};
		String[] selectArray = form.get_selectitem();
		for (int i = 0; i < selectArray.length; i++) {
			String[] pkValueArray = selectArray[i].split("\\|");
			StdrewardbjwayVO vo = new StdrewardbjwayVO();
			for (int j = 0; j < pkValueArray.length; j++) {
				BeanUtils.setProperty(vo, citywayPkNameArray[j], pkValueArray[j]);
			}
			delList.add(vo);
		}
		request.getSession().setAttribute(NEWWAYLIST, updateWayList(delList, list, "DELETECITYWAY"));
		return doShowcityway(actionMapping, actionForm, request, response, user);
	}
	
	/**
	 * 更新最新的wayList
	 * @param oldStarList
	 * @param newStarList
	 * @return
	 * @throws Exception
	 */
	private List updateWayList(List oldWayList, List newWayList, String type) throws Exception{
		List requestNewWayList = new ArrayList();
		for(Iterator itt = newWayList.iterator(); itt.hasNext(); ){
			StdrewardbjwayVO vo = (StdrewardbjwayVO)itt.next();
			StdrewardbjwayVO newvo = new StdrewardbjwayVO();
			BeanUtils.copyProperties(newvo, vo);
			requestNewWayList.add(newvo);
		}
		
		String[] citywayPkNameArray = new String[]{"region","rewardid","wayid","opnid","acctype","ruleid"};
		if("DELETECITYWAY".equals(type)){
			for(Iterator ittOld = oldWayList.iterator(); ittOld.hasNext();){
				StdrewardbjwayVO oldVO = (StdrewardbjwayVO)ittOld.next();
				for(Iterator ittNew = requestNewWayList.iterator(); ittNew.hasNext();){
					StdrewardbjwayVO newVO = (StdrewardbjwayVO)ittNew.next();
					if(oldVO.equals(newVO)){
						newVO.setDeleteFlag(true);
						break;
					}
				}
			}
			return requestNewWayList;
		}else if("NEWCITYWAY".equals(type)){
			boolean newFlag = true;
			for(Iterator ittOld = oldWayList.iterator(); ittOld.hasNext();){
				StdrewardbjwayVO oldVO = (StdrewardbjwayVO)ittOld.next();
				for(Iterator ittNew = requestNewWayList.iterator(); ittNew.hasNext();){
					StdrewardbjwayVO newVO = (StdrewardbjwayVO)ittNew.next();
					if(oldVO.equals(newVO)){
						newVO.setRewardstd(oldVO.getRewardstd());
						newVO.setDeleteFlag(false);
						newVO.setUpdateFlag(true);
						newFlag = false;
						break;
					}
				}
			}
			if(newFlag){
				requestNewWayList.addAll(oldWayList);
			}
		}else if("EDITCITYWAY".equals(type)){
			for(Iterator ittOld = oldWayList.iterator(); ittOld.hasNext();){
				StdrewardbjwayVO oldVO = (StdrewardbjwayVO)ittOld.next();
				for(Iterator ittNew = requestNewWayList.iterator(); ittNew.hasNext();){
					StdrewardbjwayVO newVO = (StdrewardbjwayVO)ittNew.next();
					if(oldVO.equals(newVO)){
						newVO.setRewardstd(oldVO.getRewardstd());
						newVO.setUpdateFlag(true);
						break;
					}
				}
			}
		}else{
			throw new Exception("内部程序异常,请联系管理员!");
		}
		return requestNewWayList;
	}
	
	private ActionForward doSaveStarlimit(ActionMapping actionMapping,ActionForm actionForm,HttpServletRequest request,HttpServletResponse response,User user) throws Exception{
		try{
			StdrewardbjForm form = (StdrewardbjForm) actionForm;		
			List list = new ArrayList();
			for(short i=0;i<7;i++){
				RewardslvlimitVO limitVO = new RewardslvlimitVO();
				limitVO.setOpnid(form.getS_opnid());
				limitVO.setRegion(user.getCityid());
				limitVO.setRewardid(form.getS_rewardid());
				limitVO.setSlv(i);
				switch(i){
					case 0:
						limitVO.setRewardlimit(form.getUplimit_level_non());
						break;
					case 1:
						limitVO.setRewardlimit(form.getUplimit_level_1());
						break;
					case 2:
						limitVO.setRewardlimit(form.getUplimit_level_2());
						break;
					case 3:
						limitVO.setRewardlimit(form.getUplimit_level_3());
						break;
					case 4:
						limitVO.setRewardlimit(form.getUplimit_level_4());
						break;
					case 5:
						limitVO.setRewardlimit(form.getUplimit_level_5());
						break;
					case 6:
						limitVO.setRewardlimit(form.getUplimit_level_6());
						break;
				}
				list.add(limitVO);
			}
			RewardslvlimitDelegate limitDelegate = new RewardslvlimitDelegate();
			limitDelegate.doModifyuplimit(list,user);	
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,"保存成功!");
		}catch(Exception ex){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,ex.getMessage());
		}		
		return actionMapping.findForward("citystarcontent");
	}
	
	private ActionForward doSaveInstallmentpay(ActionMapping actionMapping,ActionForm actionForm, 
			HttpServletRequest request,HttpServletResponse response, User user) throws Exception {
		response.setCharacterEncoding("UTF-8");
    	PrintWriter out = response.getWriter();
    	try{
    		StdrewardbjForm form = (StdrewardbjForm) actionForm;
    		int num = form.getInstallmentpay_num();
    		Double items[] = form.getInstallmentpay_items();
    		double total = 0.0;
    		for(double item:items){
    			total+=item;
    		}
    		StdrewardbjDelegate delegate = new StdrewardbjDelegate();
    		StdrewardbjListVO listvo = new StdrewardbjListVO();
    		listvo.set_ne_rewardid(form.getS_rewardid().toString());
    		listvo.set_se_region("999");
    		listvo.set_se_opnid(form.getS_opnid());
    		listvo.set_pagesize("0");
    		DataPackage dp = delegate.doQuery(listvo, user);
    		if(dp!=null && dp.getDatas()!=null && dp.getDatas().size()>0){
    			StdrewardbjVO vo = (StdrewardbjVO)dp.getDatas().iterator().next();
    			double rewardstd = vo.getRewardstd()!=null?vo.getRewardstd().doubleValue():0.0;
    			if(total>rewardstd){
//    				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,"酬金标准超出省公司上限，请重新设置!");
//    				return actionMapping.findForward("citystarcontent");
    				throw new BusinessException(null,"酬金标准超出省公司上限，请重新设置!");
    			}
    		}else{
//    			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,"酬金标准超出省公司上限数据不存在!");
//    			return actionMapping.findForward("citystarcontent");
    			throw new BusinessException(null,"酬金标准超出省公司上限数据不存在!");
    		}
    		
    		StdrewardbjnoncycDelegate ncdelegate = new StdrewardbjnoncycDelegate();
    		for(short i=1;i<=items.length;i++){
    			StdrewardbjnoncycVO ncvo = new StdrewardbjnoncycVO();
    			ncvo.setAcctype(form.getS_acctype());
    			ncvo.setOpnid(form.getS_opnid());
    			ncvo.setRegion(user.getCityid());
    			ncvo.setRewardid(form.getS_rewardid());
    			ncvo.setRuleid(form.getS_ruleid());
    			ncvo.setNoncyc(i);
    			ncvo.setRewardstd(items[i-1]);
    			ncdelegate.doCreate(ncvo, user);
    		}
    		out.write("保存成功!");
    	}catch(BusinessException ex){
    		out.write(ex.toString());
    	}catch(Exception ex){
    		ex.printStackTrace();
    		out.write(ex.getMessage());
    	}
    	return null;
//		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,"保存成功!");
//		return actionMapping.findForward("citystarcontent");
	}
	
	public ActionForward doSavecitystar(ActionMapping actionMapping,ActionForm actionForm, HttpServletRequest request,	HttpServletResponse response, User user) throws Exception {
		StdrewardbjForm form = (StdrewardbjForm) actionForm;
		if("3".equals(form.getS_starflag())){
			return this.doSaveStarlimit(actionMapping, actionForm, request, response, user);
		}
		if("4".equals(form.getS_starflag())){
			return this.doSaveInstallmentpay(actionMapping, actionForm, request, response, user);
		}
		List list = new ArrayList();
		for(short i=1;i<=6;i++){
			StdrewardbjstarVO starVO = new StdrewardbjstarVO();
			starVO.setAcctype(form.getS_acctype());
			starVO.setOpnid(form.getS_opnid());
			starVO.setRegion(user.getCityid());
			starVO.setRewardid(form.getS_rewardid());
			starVO.setRuleid(form.getS_ruleid());
			starVO.setStar(new Short(i));
			//如果从数据load出来或者客户设置了星级关联又重新设回统一标准,则删除deleteFlag为true
			if("1".equals(form.getS_starflag())){
				starVO.setDeleteFlag(true);
			}
			switch (i) {
				case 1:
					starVO.setRewardstd(form.getRewardstd_onestar());
					break;
				case 2:
					if(form.getRewardstd_twostar() == null){
						form.setRewardstd_twostar(new Double("0.0"));
					}
					starVO.setRewardstd(form.getRewardstd_twostar());
					//只有2星级才需要存储 是否排它、单排它值、双排它值 modify by laixueguang 2010-3-10
					if(form.getIspt() != null){
						if(form.getIspt().shortValue() == ISPT_NO.shortValue()){//如果非排它，排它值都设为0
							form.setSinglept(new Double("0.0"));
							form.setDiploidpt(new Double("0.0"));
						}
					} else {
						form.setIspt(new Short("0"));
						form.setSinglept(new Double("0.0"));
						form.setDiploidpt(new Double("0.0"));
					}
					if(form.getRewardstd() == null){
						form.setRewardstd(new Double("0.0"));
					}
					starVO.setIspt(form.getIspt());
					starVO.setSinglept(form.getSinglept());
					starVO.setDiploidpt(form.getDiploidpt());
					break;
				case 3:
					starVO.setRewardstd(form.getRewardstd_threestar());
					break;
				case 4:
					starVO.setRewardstd(form.getRewardstd_fourstar());
					break;
				case 5:
					starVO.setRewardstd(form.getRewardstd_fivestar());
					break;
				case 6:
					starVO.setRewardstd(form.getRewardstd_sixstar());
					break;
			}
			list.add(starVO);
		}
		request.getSession().setAttribute(NEWSTARLIST, updateStarList((List)request.getSession().getAttribute(NEWSTARLIST),list));
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,"保存成功!");
		return actionMapping.findForward("citystarcontent");
	}
	
	private List buildStarList(List oldStarList, List newStarList) throws Exception{
		if(oldStarList == null || oldStarList.size() == 0){
			return newStarList;
		}
		List list = new ArrayList();
		for(Iterator newItt = newStarList.iterator();newItt.hasNext();){
			StdrewardbjstarVO newVO = (StdrewardbjstarVO) newItt.next();
			boolean isNew = true;
			boolean updateflag = false;
			for(Iterator oldItt = oldStarList.iterator();oldItt.hasNext();){
				StdrewardbjstarVO oldVO = (StdrewardbjstarVO) oldItt.next();
				if(newVO.equals(oldVO)){
					isNew = false;
					
					if(newVO.getStar().intValue() == 2){//如果是2星级，且排它值有变化，更新
						if(oldVO.getRewardstd() == null){
							oldVO.setRewardstd(new Double("0.0"));
						}
						if(newVO.getRewardstd() == null){
							newVO.setRewardstd(new Double("0.0"));
						}
						//在session存储的oldVO中，关于“排它”酬金的三个字段仍有可能为null，初始化为0
						if(oldVO.getIspt() == null || oldVO.getSinglept() == null || oldVO.getDiploidpt() == null){
							oldVO.setIspt(new Short("0"));
							oldVO.setSinglept(new Double("0.0"));
							oldVO.setDiploidpt(new Double("0.0"));
						}
						//在页面只修改业务对应的多个酬金标准中的一个时，其中一个酬金标准关于“排它”酬金的三个字段有可能为null，初始化为0
						if(newVO.getIspt() == null || newVO.getSinglept() == null || newVO.getDiploidpt() == null){
							newVO.setIspt(new Short("0"));
							newVO.setSinglept(new Double("0.0"));
							newVO.setDiploidpt(new Double("0.0"));
							updateflag = true;
						}
						if(newVO.getIspt().shortValue() != oldVO.getIspt().shortValue()
							 ||newVO.getSinglept().doubleValue() != oldVO.getSinglept().doubleValue()
								||newVO.getDiploidpt().doubleValue() != oldVO.getDiploidpt().doubleValue()){
							updateflag = true;
						}
					}
					if(newVO.getRewardstd().doubleValue() != oldVO.getRewardstd().doubleValue()){
						updateflag = true;
						break;
					}
					break;
				}
			}
			if(isNew){
				newVO.setUpdateFlag(false);
				list.add(newVO);
				continue;
			}else{
				if(newVO.isDeleteFlag()){
					list.add(newVO);
					continue;
				}
				if(updateflag){
					newVO.setUpdateFlag(true);
					list.add(newVO);
					continue;
				}
			}
		}
		return list;
	}
	
	/**
	 * 重构入库的wayList
	 * @param oldWayList
	 * @param newWayList
	 * @return
	 * @throws Exception
	 */
	private List buildWayList(List oldWayList, List newWayList) throws Exception{
		if(oldWayList == null || oldWayList.size() == 0){
			return newWayList;
		}
		List list = new ArrayList();
		for(Iterator newItt = newWayList.iterator();newItt.hasNext();){
			StdrewardbjwayVO newVO = (StdrewardbjwayVO) newItt.next();
			boolean isNew = true;
			boolean updateflag = false;
			for(Iterator oldItt = oldWayList.iterator();oldItt.hasNext();){
				StdrewardbjwayVO oldVO = (StdrewardbjwayVO) oldItt.next();
				if(newVO.equals(oldVO)){
					isNew = false;
					if(newVO.getRewardstd().doubleValue() != oldVO.getRewardstd().doubleValue()){
						updateflag = true;
						break;
					}
					break;
				}
			}
			if(isNew){
				newVO.setUpdateFlag(false);
				list.add(newVO);
				continue;
			}else{
				if(newVO.isDeleteFlag()){
					list.add(newVO);
					continue;
				}
				if(updateflag){
					newVO.setUpdateFlag(true);
					list.add(newVO);
					continue;
				}
			}
		}
		return list;
	}
}

//使用外部类 按照间隔月份排序从小到大排序
class ListCompare implements Comparator{

	public int compare(Object arg1, Object arg2) {
		StdrewardbjVO s1 = (StdrewardbjVO) arg1;
		StdrewardbjVO s2 = (StdrewardbjVO) arg2;
		
		if(s1.getRuleid().compareTo(s2.getRuleid()) == 0){
			if (s1.getIntvmonth().intValue() > s2.getIntvmonth().intValue()) {
				return 1;
			} else {
			   if (s1.getIntvmonth().intValue() == s2.getIntvmonth().intValue()) {
			    	if(s1.getRewardid().intValue() > s2.getRewardid().intValue()){
			    		return 1;
			    	}else{
			    		if(s1.getRewardid().intValue() == s2.getRewardid().intValue()){
			    			return 0;
			    		}else{
			    			return -1;
			    		}
			    	}
			   } else {
			    return -1;
			   }
			}
		}else{
			return s1.getRuleid().compareTo(s2.getRuleid());
		}
	}
}