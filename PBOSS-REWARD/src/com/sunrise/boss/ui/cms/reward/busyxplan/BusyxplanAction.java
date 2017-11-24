/**
 * auto-generated code
 * Sat Feb 02 15:13:27 CST 2008
 */
package com.sunrise.boss.ui.cms.reward.busyxplan;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.operation.persistent.OperationListVO;
import com.sunrise.boss.business.cms.operation.persistent.OperationVO;
import com.sunrise.boss.business.cms.reward.assessinfo.persistent.AssessinfoListVO;
import com.sunrise.boss.business.cms.reward.assessinfo.persistent.AssessinfoVO;
import com.sunrise.boss.business.cms.reward.busyxplan.persistent.BusyxplanListVO;
import com.sunrise.boss.business.cms.reward.busyxplan.persistent.BusyxplanVO;
import com.sunrise.boss.business.cms.reward.vbusyxplan.persistent.VbusyxplanListVO;
import com.sunrise.boss.business.cms.reward.vbusyxplan.persistent.VbusyxplanVO;
import com.sunrise.boss.business.cms.reward.wayxplan.persistent.WayxplanVO;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanListVO;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.operation.OperationDelegate;
import com.sunrise.boss.delegate.cms.reward.assessinfo.AssessinfoDelegate;
import com.sunrise.boss.delegate.cms.reward.busyxplan.BusyxplanDelegate;
import com.sunrise.boss.delegate.cms.reward.vbusyxplan.VbusyxplanDelegate;
import com.sunrise.boss.delegate.cms.reward.wayxplan.WayxplanDelegate;
import com.sunrise.boss.delegate.zifee.yxplan.YxPlanDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>
 * Title: BusyxplanAction
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
public class BusyxplanAction extends BaseDelegateAction {
	public BusyxplanAction() {
		// 以下几个方法是必须的
		// 指定VO类
		setVoClass(BusyxplanVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[1];
		pkNameArray[0] = "seq";
		//pkNameArray[1] = "yxplanid";
	}

	public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		BusyxplanForm form = (BusyxplanForm) actionForm;
		form.set_se_cityid(user.getCityid());
		return actionMapping.findForward("list");
	}

	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			
			BusyxplanForm form = (BusyxplanForm) actionForm; 
			YxPlanDelegate delegate = new YxPlanDelegate();
			//营销方案业务类型
			YxPlanVO vo = new YxPlanVO();
			if (null != form.getYxplanid() && !"".equals(form.getYxplanid())){
			 vo = delegate.doFindByPk(form.getYxplanid(), user);
			}
			if ("WLAN".equals(form.getPlanbusitype())) {
				request.setAttribute("planbusitype", "WLAN");
			} else {
				request.setAttribute("planbusitype", "OTH");
			} 
			//营销方案标识/产品标识不能同时为空
			if("".equals(form.getProdid()) && "".equals(form.getYxplanid())){
				 throw new Exception("营销方案标识/产品标识不能同时为空，请检查");
			}
			if("NEW".equals(form.getCmdState())){
			BusyxplanListVO busyvo = new BusyxplanListVO();
			busyvo.set_se_opnid(form.getOpnid());
			List yxPlantemp = new ArrayList();
			List prodidtemp = new ArrayList();
			BusyxplanDelegate busyDelegate = new BusyxplanDelegate();
			if (!"".equals(form.getYxplanid()) && null!=form.getYxplanid()){
				busyvo.set_se_opnid(form.getOpnid());
			    busyvo.set_ne_yxplanid(form.getYxplanid().toString()); 
			    yxPlantemp = (List) busyDelegate.doQuery(busyvo, user).getDatas();
			}
			if(!"".equals(form.getProdid()) && null!=form.getProdid()){
				busyvo.set_se_opnid(form.getOpnid());
				busyvo.set_se_prodid(form.getProdid());
				prodidtemp = (List) busyDelegate.doQuery(busyvo, user).getDatas();
			} 
			 if (!yxPlantemp.isEmpty() || !prodidtemp.isEmpty()){
				 throw new Exception("该业务对应的营销方案标识/产品标识已存在，请检查");
			 } 
			}
			
			request.setAttribute("SAVE", "TRUE");
			if(!"".equals(form.getProdid()) && null !=form.getProdid()){
				  form.setCityid(user.getCityid());
				}

			if (vo != null && vo.getAreacode() != null) {
				form.setCityid(vo.getAreacode().equals("100") ? "999" : vo
						.getAreacode());
			} else if (vo == null) {
				throw new Exception("营销方案在系统中不存在!");
			}

			super.doSave(actionMapping, actionForm, request, response, user);
		} catch (Exception ex) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
			request.setAttribute("SAVE", "FALSE");
		}
		return (actionMapping.findForward("content"));
	}

	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		BusyxplanForm form = (BusyxplanForm) actionForm;
		Page.setPageSize(request, (BaseActionForm) form);
		String isRight = request.getParameter("RIGHT");
		ArrayList yxplanlist = null;
		ArrayList opnlist = null;

		if (form.get_se_yxplanname() != null
				&& !"".equals(form.get_se_yxplanname())) {
			YxPlanListVO yxplanListVO = new YxPlanListVO();

			yxplanListVO.set_pagesize("50");
			yxplanListVO.set_sk_yxplanname(form.get_se_yxplanname());
			YxPlanDelegate yxPlanDelegate = new YxPlanDelegate();
			List yxPlantemp = (List) yxPlanDelegate.doQuery(yxplanListVO, user)
					.getDatas();
			yxplanlist = new ArrayList();
			if (!yxPlantemp.isEmpty()) {
				for (Iterator i = yxPlantemp.iterator(); i.hasNext();) {
					YxPlanVO yxPlanVO = (YxPlanVO) i.next();
					yxplanlist.add(yxPlanVO.getYxplanid());
				}
			}
		}
		if (form.get_ne_yxplanid() != null
				&& !"".equals(form.get_ne_yxplanid())) {
			if (yxplanlist == null) {
				yxplanlist = new ArrayList();
			}
			yxplanlist.add(form.get_ne_yxplanid());
		}

		if (form.get_se_opnname() != null && !"".equals(form.get_se_opnname())) {
			OperationListVO operationListVO = new OperationListVO();

			operationListVO.set_pagesize("50");
			operationListVO.set_sk_name(form.get_se_opnname());
			OperationDelegate operationDelegate = new OperationDelegate();
			List operationtemp = (List) operationDelegate.doQuery(
					operationListVO, user).getDatas();
			opnlist = new ArrayList();
			if (!operationtemp.isEmpty()) {
				for (Iterator i = operationtemp.iterator(); i.hasNext();) {
					OperationVO operationVO = (OperationVO) i.next();
					opnlist.add(operationVO.getOpnid());
				}
			}
		}

		if (form.get_se_opnid() != null && !"".equals(form.get_se_opnid())) {
			if (opnlist == null) {
				opnlist = new ArrayList();
			}
			opnlist.add(form.get_se_opnid());
		}

		VbusyxplanListVO vbusyxplanListVO = new VbusyxplanListVO();
		vbusyxplanListVO.set_nin_yxplanid(yxplanlist);
		vbusyxplanListVO.set_sin_opnid(opnlist);
		setListVO(vbusyxplanListVO, actionForm);

		if ("0".equals(isRight)) {
			if (form.get_se_cityid().equals(user.getCityid())) {
				vbusyxplanListVO.set_se_cityid(null);
				vbusyxplanListVO
						.set_sql_cityid(" (cityid is null or  cityid in ('999','100','865','','"
								+ user.getCityid() + "'))  ");
				form.set_se_cityid(user.getCityid());
			}
		}

		VbusyxplanDelegate busyxplanDelegate = new VbusyxplanDelegate();
		DataPackage pack = busyxplanDelegate.doQuery(vbusyxplanListVO, user);

		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
		return (actionMapping.findForward("list"));

	}

	public ActionForward doShowyxplanid(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		BusyxplanForm form = (BusyxplanForm) actionForm;
		form.set_se_areacode(user.getCityid());
		return (actionMapping.findForward("select"));
	}

	public ActionForward doEdit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		String comp1 = request.getParameter("GRADE");// 需要的令牌
		String comp2 = request.getParameter("GRADE2");// 验证后的令牌排位
		String pk = request.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK); 
		BusyxplanDelegate delegate = new BusyxplanDelegate();
		BusyxplanVO vo = new BusyxplanVO(); 
		BusyxplanForm form = (BusyxplanForm) actionForm;
		vo.setSeq(Long.parseLong(pk));
		vo = delegate.doFindByPk(Long.parseLong(pk), user);
		if ("WLAN".equals(vo.getPlanbusitype())) {
			request.setAttribute("planbusitype", "WLAN");
		} else {
			request.setAttribute("planbusitype", "OTH");
		}  
		if (Integer.parseInt(comp2) >= Integer.parseInt(comp1)) {
			request.setAttribute("SAVE", "TRUE");
		} else {
			request.setAttribute("SAVE", "FALSE");
		}
		//营销方案标识/产品标识不能同时为空
		if("".equals(form.getProdid()) && "".equals(form.getYxplanid())){
			 throw new Exception("营销方案标识/产品标识不能同时为空，请检查");
		}
		
		
		return super.doEdit(actionMapping, actionForm, request, response, user);
	}

	public ActionForward doNew(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		request.setAttribute("SAVE", "TRUE");
		return super.doNew(actionMapping, actionForm, request, response, user);
	}


	public ActionForward doSelect(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		BusyxplanForm form = (BusyxplanForm) actionForm;
		String isRight = request.getParameter("RIGHT");
		try {
			Page.setPageSize(request, form);
			YxPlanListVO listVO = new YxPlanListVO();
			setListVO(listVO, actionForm); // 设置好listVO，作为查询条件
			listVO.set_ne_groupflag("0"); // 1 是, 0
			// 否（如果“是”营销方案组，则在[营销方案管理]中不可见，在[营销方案分组管理]中对营销方案组管理）

			// 限制查询本工号所属市公司以及全省性营销方案，全国性营销方案 modify by luozhoujie 2006-11-29
			// 集团统一营销案,全省,市公司,区域标识为空也在查询范围内

			if (isRight.equals("YES")) {// 有权限
				if (form.get_se_areacode() == null
						|| "".equals(form.get_se_areacode())) {// 有权限无选择
					listVO.set_sql_areacode(null);
					listVO.set_se_areacode(null);
				} else {// 有权限有选择
					listVO.set_sql_areacode(null);
				}
			} else {// 无权限
				String _sql_areacode = " (areacode is null or  areacode in ('','"
						+ user.getCityid() + "')) ";
				listVO.set_sql_areacode(_sql_areacode);
				listVO.set_se_areacode(null);
			}
			YxPlanDelegate delegate = new YxPlanDelegate();
			DataPackage dp = delegate.doQuery(listVO, user);
			// form.setPage(dp.getPageNo());
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
			form.set_se_areacode(form.get_se_areacode());
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return (actionMapping.findForward("select"));
	}

	protected Object getContentVO(HttpServletRequest request, User user)
			throws Exception {
		String pk = "";
		String parameter = request
				.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
		// list.jsp跳转过来的情况
		if (parameter != null)
			pk = parameter;
		BusyxplanDelegate delegate = new BusyxplanDelegate();
		BusyxplanVO busyxplan;
		if (!pk.trim().equalsIgnoreCase("")) { // 由list.jsp 传过来
			// 复合主键
			busyxplan = delegate.doFindByPk(Long.parseLong(pk), user);
			if (busyxplan.getYxplanid() != null) {
				Long yxplanid = busyxplan.getYxplanid();
				WayxplanDelegate del = new WayxplanDelegate();
				WayxplanVO wayxplan = (WayxplanVO) del.doFindByPk(yxplanid,
						user);
				if (wayxplan != null && wayxplan.getWayid() != null) {
					busyxplan.setWayid(wayxplan.getWayid());
				}
			}
			return busyxplan;
		}
		return null;
	}

	
	public ActionForward doImport(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		AssessinfoDelegate assessinfoDelegate=new AssessinfoDelegate();
		AssessinfoListVO assessinfoListVO=new AssessinfoListVO();
		assessinfoListVO.set_se_cityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
		assessinfoListVO.set_ne_type("3");
    	DataPackage dp=assessinfoDelegate.doQuery(assessinfoListVO, user);
    	String assessinfostr="";
    	if(dp!=null && dp.getDatas().size()>0){
    		Iterator it = dp.getDatas().iterator();
			if(it.hasNext()) {
				AssessinfoVO VO=(AssessinfoVO)it.next();
				assessinfostr=VO.getAsseremark();
			}
    	}
    	request.getSession().setAttribute("assessinfostr", assessinfostr);
		return actionMapping.findForward("batch");
	}
	
	public ActionForward doTxt(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user); 
		export.setFileName("营销方案（产品标识）与全省统一业务关联设置");  
		export.addOutputProperty("seq");
		export.addOutputProperty("opnid"); 
		export.addOutputProperty("opnid",CommonExportBean.CODE2NAME,"#OPERATION"); 
		export.addOutputProperty("yxplanid");
		export.addOutputProperty("yxplanid",CommonExportBean.CODE2NAME,"#ZIFEE-YXPLAN");
		export.addOutputProperty("prodid");
		export.addOutputProperty("cityid",CommonExportBean.CODE2NAME,"#CITYCOMPANY");
		export.addOutputProperty("noncyc");
		export.addOutputProperty("wayid");  
		export.voClassArray = new Class[] {VbusyxplanVO.class }; 
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(
				fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain");
		export.writeTxtTitle(response.getOutputStream(), new String[] {
				"序列","全省业务编码", "全省业务名称", "营销方案标识","营销方案名称", "产品标识","地市标记","客户维系酬金发放期数","渠道名称"});
		super.ExportQuery(actionMapping, actionForm, request, response, user,
				export);
		return actionMapping.findForward(null);
	}
	
}
