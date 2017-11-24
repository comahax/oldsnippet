package com.sunrise.boss.ui.cms.zjty.zjtyrewarddetail;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.cms.zjty.zjtyrewarddetail.persistent.ZjtyRewarddetailListVO;
import com.sunrise.boss.business.cms.zjty.zjtyrewarddetail.persistent.ZjtyRewarddetailVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.cms.zjty.zjtyrewarddetail.ZjtyRewarddetailDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

public class ZjtyRewarddetailAction extends BaseDelegateAction {

	public ZjtyRewarddetailAction() {
		// 以下几个方法是必须的
		// 指定VO类
		setVoClass(ZjtyRewarddetailVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[1];
		pkNameArray[0] = "rewardlistid";
	}
	
	/**
	 * 自建他营地市公司酬金列表
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doChlist(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			ZjtyRewarddetailForm form = (ZjtyRewarddetailForm) actionForm;
			ZjtyRewarddetailListVO listvo = new ZjtyRewarddetailListVO();
			setListVO(listvo, actionForm); // 设置好listVO，作Ordinary为查询条件
			ZjtyRewarddetailDelegate delegate = new ZjtyRewarddetailDelegate();
			DataPackage dp = delegate.doQuerybyType(listvo, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
			return (actionMapping.findForward("chlist"));
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			return (actionMapping.findForward("chlist"));
		}
	}
	
	public ActionForward doZzedit(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		// TODO Auto-generated method stub
		super.doEdit(actionMapping, actionForm, request, response, user);
		return (actionMapping.findForward("zzcontent"));
	}
	
	public ActionForward doZznew(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		// TODO Auto-generated method stub
		super.doNew(actionMapping, actionForm, request, response, user);
		return (actionMapping.findForward("zzcontent"));
	}
	
	/**
	 * 自助终端业务酬金(89)查询&列表
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doZzlist(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			Page.setPageSize(request, (BaseActionForm) actionForm);
			ZjtyRewarddetailForm zzform = (ZjtyRewarddetailForm) actionForm;
			ZjtyRewarddetailListVO listvo = new ZjtyRewarddetailListVO();
			ZjtyRewarddetailDelegate zzdelegate = new ZjtyRewarddetailDelegate();
			setListVO(listvo, zzform);
			listvo.set_se_rewardtype(new Short("89"));
			DataPackage dp = zzdelegate.doQuery(listvo, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return (actionMapping.findForward("zzlist"));
	}
	
	/**
	 * 自助终端业务酬金-保存
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doZzsave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ZjtyRewarddetailForm form = (ZjtyRewarddetailForm) actionForm;
		ZjtyRewarddetailVO zzVO = new ZjtyRewarddetailVO();
		ZjtyRewarddetailDelegate zzdelegate = new ZjtyRewarddetailDelegate();
		this.setSaveVO(zzVO, actionForm);
		WayListVO waylistvo = new WayListVO();
		WayDelegate wayDelegate = new WayDelegate();
		DataPackage zzDp = new DataPackage();
		if (null != zzVO.getWayid() && !"".equals(zzVO.getWayid())) {
			if (!wayDelegate.isWayExist(zzVO.getWayid(), user)) {
				request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
						"Zzedit");
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
						"保存失败,渠道代码不存在。");
				return (actionMapping.findForward("zzcontent"));
			}
		}
		
		waylistvo.set_se_wayid(form.getWayid());
		waylistvo.set_se_waytype("AG");
		waylistvo.set_se_waysubtype("ZJTY");
		waylistvo.set_ne_runmode("1");
		waylistvo.set_se_cityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
		zzDp = wayDelegate.doQuery(waylistvo, user);
		if (zzDp.getDatas().size() == 0) {
			request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
					"Zzedit");
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"保存失败,该渠道["+form.getWayid()+"]不是本地市的自建他营渠道!");
			return (actionMapping.findForward("zzcontent"));
		}
		
		zzVO.setOperseq(new Long("-1"));
		zzVO.setWayopercode("-1");
		zzVO.setRewardid(new Long("-1"));
		zzVO.setRewardstd(new Double("-1"));
		zzVO.setCoef1(new Double("-1"));
		zzVO.setCoef2(new Double("-1"));
		zzVO.setCoef3(new Double("-1"));
		zzVO.setCoef4(new Double("-1"));
		zzVO.setTotalsum(new Double("-1"));
		zzVO.setBatchnum("-1");
		
		if(zzVO.getRewardlistid()==null){
			zzdelegate.doCreate(zzVO, user);
		}else{
			zzdelegate.doUpdate(zzVO, user);
		}
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功!");
		return (actionMapping.findForward("zzcontent"));
	}
	
	/**
	 * 自建他营酬金明细保存
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ZjtyRewarddetailForm form = (ZjtyRewarddetailForm) actionForm;
		ZjtyRewarddetailVO contentVO = new ZjtyRewarddetailVO();
		setSaveVO(contentVO, actionForm); // 在此格式化处理好 vo 以保存
		WayListVO waylistvo = new WayListVO();
		WayDelegate wayDelegate = new WayDelegate();
		DataPackage dp;
		if (null != contentVO.getWayid() && !"".equals(contentVO.getWayid())) {
			if (!wayDelegate.isWayExist(contentVO.getWayid(), user)) {
				request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
						WebConstant.COMMAND_STRING_EDIT);
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
						"保存失败,渠道代码不存在");
				return (actionMapping.findForward("content"));
			}
		}

		waylistvo.set_se_wayid(form.getWayid());
		waylistvo.set_se_waytype("AG");
		waylistvo.set_se_waysubtype("ZJTY");
		waylistvo.set_ne_runmode("1");
		waylistvo.set_se_cityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
		dp = wayDelegate.doQuery(waylistvo, user);
		if (dp.getDatas().size() == 0) {
			request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
					WebConstant.COMMAND_STRING_EDIT);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"保存失败,该渠道不是本地市的自建他营的渠道!");
			return (actionMapping.findForward("content"));
		}

		try {
			form.setRewardlistid(form.getRewardlistid());
			form.setAcctype(new Short("-1"));
			form.setOperseq(new Long("-1"));
			form.setOpnid("-1");
			form.setWayopercode("-1");
			form.setRewardid(new Long("-1"));
			form.setRewardstd(new Double("-1"));
			form.setCoef1(new Double("-1"));
			form.setCoef2(new Double("-1"));
			form.setCoef3(new Double("-1"));
			form.setCoef4(new Double("-1"));
			form.setTotalsum(new Double("-1"));
			Calendar cld = Calendar.getInstance();
			SimpleDateFormat df = new SimpleDateFormat("yyMMddhhmmss");
			String day = df.format(cld.getTime());
			form.setBatchnum(SessionFactoryRouter.conversionCityid(user
					.getCityid())
					+ day);
			return super.doSave(actionMapping, actionForm, request, response,
					user);

		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			return (actionMapping.findForward("content"));
		}

	}
	
	/**
	 * 自助终端业务酬金-删除
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doZzdelete(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			super.doDelete(actionMapping, actionForm, request, response, user);
			return doZzlist(actionMapping, actionForm, request, response, user);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			return (actionMapping.findForward("zzlist"));
		}
	}
	

	public ActionForward doChdelete(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			super.doDelete(actionMapping, actionForm, request, response, user);
			return doChlist(actionMapping, actionForm, request, response, user);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			return (actionMapping.findForward("chlist"));
		}

	}
}