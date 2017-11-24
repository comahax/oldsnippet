/**
 * auto-generated code
 * Thu Aug 24 15:28:14 CST 2006
 */
package com.sunrise.boss.ui.cms.way;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ajaxanywhere.AAUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.adimarea.persistent.AdimareaVO;
import com.sunrise.boss.business.cms.areacenter.persistent.AreacenterListVO;
import com.sunrise.boss.business.cms.areacenter.persistent.AreacenterVO;
import com.sunrise.boss.business.cms.citycompany.persistent.CitycompanyVO;
import com.sunrise.boss.business.cms.cntycompany.persistent.CntycompanyVO;
import com.sunrise.boss.business.cms.microarea.persistent.MicroareaVO;
import com.sunrise.boss.business.cms.servcent.persistent.ServcentVO;
import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.admin.acl.ACLDelegate;
import com.sunrise.boss.delegate.cms.areacenter.AreacenterDelegate;
import com.sunrise.boss.delegate.cms.citycompany.CitycompanyDelegate;
import com.sunrise.boss.delegate.cms.cntycompany.CntycompanyDelegate;
import com.sunrise.boss.delegate.cms.microarea.MicroareaDelegate;
import com.sunrise.boss.delegate.cms.servcent.ServcentDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.cms.commons.CMSUtils;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.dtree.TreeNode;
import com.sunrise.boss.ui.commons.taglib.code2name.Code2NameConfiger;

/**
 * <p>
 * Title: WayAction
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
 * @author He Kun
 * @version 1.0
 */
public class WayAction extends BaseDelegateAction {

	private static final Log log = LogFactory.getLog(WayAction.class);

	public WayAction() {
		// 以下几个方法是必须的
		// 指定VO类
		setVoClass(WayVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[1];
		pkNameArray[0] = "wayid";
	}

	protected ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		WayForm wayForm = (WayForm) actionForm;

		String wayid = user.getWayid();
		WayDelegate delegate = new WayDelegate();
		WayVO wayVO = delegate.doFindByPk(wayid, user);
		if (wayVO == null) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"登录的渠道不存在, 渠道编码:" + wayid);
			return actionMapping.findForward("list");
		}

		String centerid = wayVO.getCenterid();
		String cityid = wayVO.getCityid();
		String countyid = wayVO.getCountyid();

		request.setAttribute("centerid", centerid); // 登录的渠道没有区域标识, 判断为省直属渠道,
		// 可以看到 区域中心条件输入框
		request.setAttribute("cityid", cityid);
		request.setAttribute("countyid", countyid);

//		if (StringUtils.isEmpty(wayForm.get_se_upperwayid())) {
//			wayForm.set_se_upperwayid(user.getWayid());
//		}

		if (!StringUtils.isEmpty(wayForm.get_se_centerid()))
			wayForm.setCenterid(wayForm.get_se_centerid());
		if (!StringUtils.isEmpty(wayForm.get_se_cityid()))
			wayForm.setCityid(wayForm.get_se_cityid());
		if (!StringUtils.isEmpty(wayForm.get_se_countyid()))
			wayForm.setCountyid(wayForm.get_se_countyid());
		if (!StringUtils.isEmpty(wayForm.get_se_upperwayid()))
			wayForm.setUpperwayid(wayForm.get_se_upperwayid());

		if (AAUtils.isAjaxRequest(request)) {
			AAUtils.addZonesToRefresh(request, "zoneCitycompany");
			AAUtils.addZonesToRefresh(request, "zoneCountycompany");
			AAUtils.addZonesToRefresh(request, "zoneWaysubtype");
		}
		WayListVO params=new WayListVO();
		Page.setPageSize(request, wayForm);
		BeanUtils.copyProperties(params, wayForm);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, delegate.doQueryAllSubWays(params, user));
//		ActionForward forward = super.doList(actionMapping, actionForm,
//				request, response, user);
		// 将查询条件作为新增的缺省值,主要是上级渠道id,区域中心id,市公司id,县公司id.
		return actionMapping.findForward("list");

	}

	public ActionForward doSearch(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		if (AAUtils.isAjaxRequest(request)) {
			AAUtils.addZonesToRefresh(request, "zoneCitycompany");
			AAUtils.addZonesToRefresh(request, "zoneCountycompany");
		}

		super.doList(actionMapping, actionForm, request, response, user);
		return actionMapping.findForward("query");

	}

	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		WayForm form = (WayForm) actionForm;
		form.setUpdatedate(new Date());
		try {
		if("AG".equals(form.getWaytype()))
		{
			if(!"TEMI".equals(form.getWaysubtype()) && !"ITF".equals(form.getWaysubtype())&& !"ECF".equals(form.getWaysubtype()))
			{
				throw new BusinessException("","[社会网点，合作商]类别的渠道,请去专门的渠道菜单进行录入!");
			}
		}
		WayVO newVO = new WayVO();
		BeanUtils.copyProperties(newVO, form);
		WayDelegate delegate = new WayDelegate();
	
			if (WebConstant.COMMAND_STRING_EDIT.equalsIgnoreCase(form
					.getCmdState())) {
				// WayVO oldVO = delegate.doFindByPk(form.getWayid(), user);
				// if (!oldVO.getUpperwayid().equalsIgnoreCase(
				// newVO.getUpperwayid())) {
				// delegate.doEdit(oldVO, newVO, user);
				// } else {
				delegate.doUpdate(newVO, user);
				// }
			} else {
				newVO.setWaystate(new Short("1"));// 新增时将渠道状态设置为生效.xy
				delegate.doCreate(newVO, user);
			}
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
		} catch (BusinessException be) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, be
					.getMessage());
		} catch (Exception e) {
			throw e;
		}
		return actionMapping.findForward("content");
	}

	public void doOrgTreePage(HttpServletRequest request) throws Exception {
		User user = (User) request.getSession().getAttribute(
				WebConstant.SESSION_ATTRIBUTE_USER);
		String contextPath = request.getContextPath();
		String showtext = "";
		String[] orgtype = CMSUtils.doGetOrgtypeNumber(request
				.getParameter("orgtype"));
		String rewayid = user.getWayid();
		String topChildrenURI = "selectOrgXml.jsp";
		String parentType = "org";
		String orgproxy = "";
		String rootName = null;
		String topAction = "";
		String topChildrenURL = null;
		String rootAdaId = null;
		AdimareaVO adimareaVO = null;
		StringBuffer topChildrenURLBuffer = new StringBuffer(100);
		WayDelegate delegate = new WayDelegate();
		WayVO wayvo = delegate.doFindByPk(rewayid, user);
		if (StringUtils.isNotEmpty(wayvo.getMareacode())) {
			MicroareaDelegate dele = new MicroareaDelegate();
			MicroareaVO vo = dele.doFindByPk(wayvo.getMareacode(), user);
			rootName = vo.getManame();
			rootAdaId = vo.getMacode();
			orgproxy = "5";
		} else if (StringUtils.isNotEmpty(wayvo.getSvccode())) {
			ServcentDelegate dele = new ServcentDelegate();
			ServcentVO vo = dele.doFindByPk(wayvo.getSvccode(), user);
			rootName = vo.getSvcname();
			rootAdaId = vo.getSvccode();
			orgproxy = "4";

		} else if (StringUtils.isNotEmpty(wayvo.getCountyid())) {
			CntycompanyDelegate dele = new CntycompanyDelegate();
			CntycompanyVO vo = dele.doFindByPk(wayvo.getCountyid(), user);
			rootName = vo.getCountycompname();
			rootAdaId = vo.getCountycompid();
			orgproxy = "3";
		} else if (StringUtils.isNotEmpty(wayvo.getCityid())) {
			CitycompanyDelegate delegate2 = new CitycompanyDelegate();
			CitycompanyVO vo = delegate2.doFindByPk(wayvo.getCityid(), user);
			rootName = vo.getCitycompname();
			rootAdaId = vo.getCitycompid();
			orgproxy = "2";
		} else {
			rootName = "广东省";
			rootAdaId = "";
			orgproxy = "1";
		}

		topChildrenURLBuffer.append(contextPath).append("/cms/way/").append(
				topChildrenURI).append("?parentid=").append(rootAdaId).append(
				"&parenttype=").append(parentType).append(
				"&function=selectOrg&childrenURL=").append(contextPath).append(
				"/cms/way/").append(topChildrenURI).append("&orgproxy=")
				.append(orgproxy).append("&orgtype=").append(orgtype[0])
				.append("&times=").append((new Date()).getTime());
		if (StringUtils.isEmpty(orgtype[0])
				|| StringUtils.equals(orgtype[0], orgproxy)) {
			topAction = rootAdaId == null ? "" : "\"javascript:selectOrg('"
					+ rootAdaId + "','" + rootName + "' , 'org','"
					+ CMSUtils.doGetOrgtypebynumber(orgproxy) + "') \"";
		} else {
			topAction = rootAdaId == null ? "" : "\"javascript:void(0) \"";
			showtext = "不存在组织结构信息";
		}
		topChildrenURL = rootAdaId != null ? topChildrenURLBuffer.toString()
				: "";
		request.setAttribute("text", showtext);
		request.setAttribute("rootAdaId", rootAdaId);
		request.setAttribute("orgproxy", orgproxy);
		request.setAttribute("rootName", rootName);
		request.setAttribute("parentType", parentType);
		request.setAttribute("topChildrenURL", topChildrenURL);
		request.setAttribute("topAction", topAction);

	}

	public void doTreepage(HttpServletRequest request) throws Exception {
		User user = (User) request.getSession().getAttribute(
				WebConstant.SESSION_ATTRIBUTE_USER);
		try {
			String contextPath = request.getContextPath();

			String topChildrenURI = "selectWayXml.jsp";

			String waytype = request.getParameter("waytype");// 渠道类型
			String waysubtype = request.getParameter("waysubtype");// 渠道子类型
			String runmode="";
			WayDelegate delegate = new WayDelegate();
			String menuTokenId = (String) request.getParameter("menuTokenId");
			boolean isable = StringUtils.isEmpty(request
					.getParameter("showDisabled")) ? false : true;
			boolean showOfCitycom = false;
			boolean showParent = false;
			boolean showSubWays = false;
			boolean showSibling = false; // 预留
			boolean showSelfOnly = false; // 预留
			// 根据权限和令牌控制渠道树数据: 分4个层次: 市公司渠道, 本渠道及下级, 本渠道,本工号

			String tokenA = "JHQUERYRGT_A";
			String tokenB = "JHQUERYRGT_B";
			String tokenC = "JHQUERYRGT_C";
			String tokenD = "JHQUERYRGT_D";

			if (StringUtils.isNotBlank(menuTokenId)) {
				tokenA = menuTokenId + "_" + tokenA;
				tokenB = menuTokenId + "_" + tokenB;
				tokenC = menuTokenId + "_" + tokenC;
				tokenD = menuTokenId + "_" + tokenD;
			}

			ACLDelegate aclDelegate = new ACLDelegate();
			showOfCitycom = aclDelegate.checkPermission(user.getOpercode(),
					tokenA); // 查询本市公司所有渠道

			if (!showOfCitycom) {

				showParent = aclDelegate.checkPermission(user.getOpercode(),
						tokenB);

				if (!showParent) {
					showSubWays = aclDelegate.checkPermission(user
							.getOpercode(), tokenC); // 查询本渠道及下属渠道

					if (!showSubWays) {
						showSelfOnly = aclDelegate.checkPermission(user
								.getOpercode(), tokenD); // 查询本渠道
					}
				}
			}

			// 以下代码通过特殊参数忽略令牌
			if (StringUtils.isBlank(menuTokenId)) {
				showSubWays = true;
				// showOfCitycom = true;
			}
			String rootWayId = null;

			if (user != null)
				rootWayId = user.getWayid();

			String wayName = "非法渠道";

			String parentType = "Way";
			String rootName = null;
			String topAction = null;
			String topChildrenURL = null;
			StringBuffer topChildrenURLBuffer = new StringBuffer(100);

			if (rootWayId != null) {
				WayVO wayvo = null;
				if (showParent) {
					wayvo = delegate.getUpperWay(rootWayId, user);
					if (wayvo == null)
						wayvo = delegate.doFindByPk(rootWayId, user);

					if (wayvo != null) {
						rootWayId = wayvo.getWayid();
						wayName = wayvo.getWayname();
					}
				} else if (showOfCitycom) {

					wayvo = delegate.getCitycomDirectWayByWay(rootWayId, user);
					if (wayvo != null) {
						rootWayId = wayvo.getWayid();
						wayName = wayvo.getWayname();
					}

				} else if (showSubWays) {
					wayvo = delegate.doFindByPk(rootWayId, user);
					if (wayvo != null) {
						rootWayId = wayvo.getWayid();
						wayName = wayvo.getWayname();
					}
				} else { // show current way only

					wayvo = delegate.doFindByPk(rootWayId, user);
					rootWayId = wayvo.getWayid();
					wayName = wayvo == null ? "非法渠道" : "(" + wayvo.getWayid()
							+ ")" + wayvo.getWayname();
					// rootWayId = "#"; //通过一个不存在的渠道, 实现不加载下级渠道
					topAction = ";";
					topChildrenURLBuffer = new StringBuffer("&");
				}
				if (!"&".equals(topChildrenURLBuffer.toString()))
					topChildrenURLBuffer.append(contextPath)
							.append("/cms/way/").append(topChildrenURI).append(
									"?parentid=").append(rootWayId).append(
									"&parenttype=").append(parentType).append(
									"&function=selectWay&childrenURL=").append(
									contextPath).append("/cms/way/").append(
									"selectWayXml.jsp")
							.append("&showDisabled=").append(isable).append(
									"&time=").append(new Date().getTime())
									.append("&layer=0");
				if (StringUtils.isNotEmpty(waytype)) {
					topChildrenURLBuffer.append("&waytype=").append(waytype);
				}
				if (StringUtils.isNotEmpty(waysubtype)) {
					topChildrenURLBuffer.append("&waysubtype=").append(
							waysubtype);
				}
				if (CMSUtils.doGetwaytype(wayvo, waytype, waysubtype,runmode)) {
					topAction = rootWayId != null ? "\"javascript:selectWay('"
							+ rootWayId + "','" + wayName + "' , 'Way') \""
							: "";
				} else {
					topAction = "\"\"";
				}
				rootName = rootWayId != null ? "(" + rootWayId + ")" + wayName
						: "无渠道信息";
				topChildrenURL = rootWayId != null ? topChildrenURLBuffer
						.toString() : "";

			}

			request.setAttribute("rootWayId", rootWayId);

			request.setAttribute("rootName", rootName);
			request.setAttribute("parentType", parentType);
			request.setAttribute("topChildrenURL", topChildrenURL);
			request.setAttribute("topAction", topAction);
			request.setAttribute("showDisabled", Boolean.valueOf(isable));
		} catch (BusinessException e) {
			e.printStackTrace();
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			request.setAttribute("rootName", "非法数据");
		}
	}

	/**
	 * 生成渠道树结构Model
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doTree(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// getContetnVO(request, user, actionForm);
		// request.setAttribute(WebConstant.PAGE_ATTRIBUTE_ISEDIT,
		// WebConstant.STRING_TRUE); //可编辑标记
		// String cmd = "TREE";
		// List treeListData = new ArrayList();///buildTreeData(user);
		//
		// request.setAttribute("TREELIST", treeListData);
		// String command = getCommandString(request);
		// ((BaseActionForm) actionForm).setCmdState(command);
		String type = request.getParameter("type");
		doSelectwaytree(actionMapping, actionForm, request, response, user);
		if ("page".equals(type)) {
			return (actionMapping.findForward("treepage"));
		} else
			return (actionMapping.findForward("tree"));
	}

	protected ActionForward doNew(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		WayForm wayForm = (WayForm) actionForm;

		if (AAUtils.isAjaxRequest(request)) {
			if (!StringUtils.isEmpty(wayForm.get_se_upperwayid())
					|| !StringUtils.isEmpty(wayForm.getUpperwayid())) {
				WayDelegate wayDelegate = new WayDelegate();
				WayVO wayVO = wayDelegate.doFindByPk(wayForm.getUpperwayid(),
						user);
				String centerid = wayVO.getCenterid();
				String cityid = wayVO.getCityid();
				String countyid = wayVO.getCountyid();
				String level = wayVO.getWaylevel().toString();
				// String waylevel=wayVO.getWaylevel().intValue()+1+"";
				level = level == null ? "" : level;
				if (centerid != null)
					wayForm.setCenterid(centerid);
				if (cityid != null)
					wayForm.setCityid(cityid);
				if (countyid != null)
					wayForm.setCountyid(countyid);
				if (wayVO.getWaylevel() != null)
					wayForm.setWaylevel(new Short(wayVO.getWaylevel()
							.intValue()
							+ 1 + ""));

				wayForm.setUpperwayid(wayForm.get_se_upperwayid());
				if ("0".equals(level)) {
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							"上级渠道不能是省公司/区域中心");
					request.setAttribute("canSave", "no");
				} else {
					request.setAttribute("canSave", "yes");
				}
			}
			AAUtils.addZonesToRefresh(request, "zoneWaysubtype");
			AAUtils.addZonesToRefresh(request, "zoneCenter");
			AAUtils.addZonesToRefresh(request, "zoneCity");
			AAUtils.addZonesToRefresh(request, "zoneCounty");
			AAUtils.addZonesToRefresh(request, "zoneWaylevel");
			return (actionMapping.findForward("content"));
		}

		if (StringUtils.isEmpty(wayForm.get_se_centerid())
				&& StringUtils.isEmpty(wayForm.get_se_cityid())
				&& StringUtils.isEmpty(wayForm.get_se_countyid())
				&& StringUtils.isEmpty(wayForm.get_se_upperwayid())) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"CMS-11002:必须指定上级或上级渠道.");
			return actionMapping.findForward("list");
		}

		wayForm.setWaylevel(new Short((short) 0));
		if (!StringUtils.isEmpty(wayForm.get_se_countyid())) {

			CntycompanyDelegate cntycompanyDelegate = new CntycompanyDelegate();
			CntycompanyVO cntycompanyVO = cntycompanyDelegate.doFindByPk(
					wayForm.get_se_countyid(), user);

			String cityid = cntycompanyVO.getCitycompid();

			CitycompanyDelegate citycompanyDelegate = new CitycompanyDelegate();
			CitycompanyVO citycompanyVO = citycompanyDelegate.doFindByPk(
					cityid, user);

			String centerid = citycompanyVO.getCenterid();

			wayForm.setCityid(cityid);
			wayForm.setCenterid(centerid);
		} else if (!StringUtils.isEmpty(wayForm.get_se_cityid())) {
			CitycompanyDelegate citycompanyDelegate = new CitycompanyDelegate();
			CitycompanyVO citycompanyVO = citycompanyDelegate.doFindByPk(
					wayForm.get_se_cityid(), user);

			String centerid = citycompanyVO.getCenterid();
			wayForm.setCenterid(centerid);

		} else if (!StringUtils.isEmpty(wayForm.get_se_upperwayid())) {
			WayDelegate wayDelegate = new WayDelegate();
			WayVO wayVO = wayDelegate.doFindByPk(wayForm.get_se_upperwayid(),
					user);
			String centerid = wayVO.getCenterid();
			String cityid = wayVO.getCityid();
			String countyid = wayVO.getCountyid();

			if (centerid != null)
				wayForm.setCenterid(centerid);
			if (cityid != null)
				wayForm.setCityid(cityid);
			if (countyid != null)
				wayForm.setCountyid(countyid);

			wayForm.setUpperwayid(wayForm.get_se_upperwayid());

			String upperwayid = wayForm.get_se_upperwayid();
			WayDelegate delegate = new WayDelegate();

			if (delegate.isGMCCDirectWay(upperwayid, user))
				wayForm.setWaylevel(new Short((short) 0));
			else {
				WayVO upperWayVO = delegate.doFindByPk(upperwayid, user);
				if (upperWayVO == null) {
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							"父渠道不存在！ 编码:" + upperwayid);
				} else {
					Short upperwaylevel = upperWayVO.getWaylevel();
					wayForm.setWaylevel(new Short((short) (upperwaylevel
							.shortValue() + 1)));
				}
			}
		}
		return super.doNew(actionMapping, wayForm, request, response, user);
	}

	/**
	 * 维护渠道资料
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doMaginfo(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		doEdit(actionMapping, actionForm, request, response, user);

		WayForm wayForm = (WayForm) actionForm;
		String wayType = wayForm.getWaytype();
		String waySubType = wayForm.getWaysubtype();

		request.setAttribute("wayType", wayType);
		request.setAttribute("waySubType", waySubType);

		return (actionMapping.findForward("maginfo"));
	}

	private List buildTreeData(User user) throws Exception {

		List treeListData = new ArrayList();
		TreeNode gmcc = new TreeNode("GMCC", "-1", "GMCC", "GMCC");
		treeListData.add(gmcc);

		addCenters("GMCC", treeListData, user);
		return treeListData;
	}

	private void addCenters(String root, List treeListData, User user)
			throws Exception {
		AreacenterDelegate delegate = new AreacenterDelegate();
		AreacenterListVO listVO = new AreacenterListVO();
		List areaCenters = (List) delegate.doQuery(listVO, user).getDatas();

		for (int i = 0; i < areaCenters.size(); i++) {
			AreacenterVO areacenterVO = (AreacenterVO) areaCenters.get(i);
			TreeNode centerNode = new TreeNode("CENTER_"
					+ areacenterVO.getCenterid(), root, areacenterVO
					.getCentername(), "Areacenter");
			treeListData.add(centerNode);

			// 查询市公司及下属渠道
			addCitycompanys(areacenterVO, treeListData, user);
		}

	}

	private void addCitycompanys(AreacenterVO areacenterVO, List treeListData,
			User user) throws Exception {

		if (log.isInfoEnabled())
			log.info("区域中心:" + areacenterVO.getCentername());
		String centerid = areacenterVO.getCenterid();
		CitycompanyDelegate delegate = new CitycompanyDelegate();
		List citycoms = (List) delegate.getCitycompanysOfCenter(centerid, user)
				.getDatas();
		for (int i = 0; i < citycoms.size(); i++) {
			CitycompanyVO citycompanyVO = (CitycompanyVO) citycoms.get(i);

			TreeNode citycomNode = new TreeNode("CITY_"
					+ citycompanyVO.getCitycompid(), "CENTER_" + centerid,
					citycompanyVO.getCitycompname(), "Citycompany");
			treeListData.add(citycomNode);

			// 查询县公司及下属渠道
			addCntycompanys(citycompanyVO, treeListData, user);
		}

	}

	private void addCntycompanys(CitycompanyVO citycompanyVO,
			List treeListData, User user) throws Exception {

		if (log.isInfoEnabled())
			log.info("市公司:" + citycompanyVO.getCitycompname());
		String cityid = citycompanyVO.getCitycompid();
		CntycompanyDelegate delegate = new CntycompanyDelegate();
		List countycoms = (List) delegate.getCntycompanysOfCity(cityid, user)
				.getDatas();
		for (int i = 0; i < countycoms.size(); i++) {
			CntycompanyVO cntycompanyVO = (CntycompanyVO) countycoms.get(i);
			if (log.isInfoEnabled())
				log.info("县公司:" + cntycompanyVO.getCountycompname());
			TreeNode countycomNode = new TreeNode("COUNTY_"
					+ cntycompanyVO.getCountycompid(), "CITY_" + cityid,
					cntycompanyVO.getCountycompname(), "Cntycompany");
			treeListData.add(countycomNode);
		}
	}

	/**
	 * 生成组织结构树
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doSelectorgtree(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			String contextPath = request.getContextPath();
			String showtext = "";
			String[] orgtype = CMSUtils.doGetOrgtypeNumber(request
					.getParameter("orgtype"));
			String rewayid = (StringUtils.equals("undefined", request
					.getParameter("rewayid")) || StringUtils.isEmpty(request
					.getParameter("rewayid"))) ? user.getWayid() : request
					.getParameter("rewayid");
			String topChildrenURI = "selectOrgXml.jsp";
			String parentType = "org";
			String orgproxy = "";
			String rootName = null;
			String topAction = "";
			String topChildrenURL = null;
			String rootAdaId = null;
			AdimareaVO adimareaVO = null;
			StringBuffer topChildrenURLBuffer = new StringBuffer(100);
			WayForm form = (WayForm) actionForm;
			WayDelegate delegate = new WayDelegate();
			WayVO wayvo = delegate.doFindByPk(rewayid, user);
			if (StringUtils.isNotEmpty(wayvo.getMareacode())) {
				MicroareaDelegate dele = new MicroareaDelegate();
				MicroareaVO vo = dele.doFindByPk(wayvo.getMareacode(), user);
				rootName = vo.getManame();
				rootAdaId = vo.getMacode();
				orgproxy = "5";
			} else if (StringUtils.isNotEmpty(wayvo.getSvccode())) {
				ServcentDelegate dele = new ServcentDelegate();
				ServcentVO vo = dele.doFindByPk(wayvo.getSvccode(), user);
				rootName = vo.getSvcname();
				rootAdaId = vo.getSvccode();
				orgproxy = "4";

			} else if (StringUtils.isNotEmpty(wayvo.getCountyid())) {
				CntycompanyDelegate dele = new CntycompanyDelegate();
				CntycompanyVO vo = dele.doFindByPk(wayvo.getCountyid(), user);
				rootName = vo.getCountycompname();
				rootAdaId = vo.getCountycompid();
				orgproxy = "3";
			} else if (StringUtils.isNotEmpty(wayvo.getCityid())) {
				CitycompanyDelegate delegate2 = new CitycompanyDelegate();
				CitycompanyVO vo = delegate2
						.doFindByPk(wayvo.getCityid(), user);
				rootName = vo.getCitycompname();
				rootAdaId = vo.getCitycompid();
				orgproxy = "2";
			} else {
				rootName = "广东省";
				rootAdaId = "";
				orgproxy = "1";
			}

			topChildrenURLBuffer.append(contextPath).append("/cms/way/")
					.append(topChildrenURI).append("?parentid=").append(
							rootAdaId).append("&parenttype=")
					.append(parentType).append(
							"&function=selectOrg&childrenURL=").append(
							contextPath).append("/cms/way/").append(
							topChildrenURI).append("&orgproxy=").append(
							orgproxy).append("&orgtype=").append(orgtype[0])
					.append("&times=").append((new Date()).getTime());
			if (StringUtils.isEmpty(orgtype[0])
					|| StringUtils.equals(orgtype[0], orgproxy)) {
				topAction = rootAdaId == null ? "" : "\"javascript:selectOrg('"
						+ rootAdaId + "','" + rootName + "' , 'org','"
						+ CMSUtils.doGetOrgtypebynumber(orgproxy) + "') \"";
			} else {
				topAction = rootAdaId == null ? "" : "\"javascript:void(0) \"";
				showtext = "不存在组织结构信息";
			}
			// 如果要求输入的级别大于用户所在的级别，则提示下面的信息

			if (StringUtils.isNotEmpty(orgtype[0])
					&& (Integer.valueOf(orgproxy).intValue()) > (Integer
							.valueOf(orgtype[0]).intValue())) {
				// topAction="\"javascript:void(0)\"";
				// rootAdaId=null;
				// showtext="您当前的渠道组织不属于"+orgtype[1]+"一级!";
				// String tmpadaid="";
				if (StringUtils.equals("4", orgtype[0])) {
					rootAdaId = wayvo.getSvccode();
					showtext = (String) Code2NameConfiger.getName("SERVCENT",
							wayvo.getSvccode(), user.getCityid());
				} else if (StringUtils.equals("3", orgtype[0])) {
					rootAdaId = wayvo.getCountyid();
					showtext = (String) Code2NameConfiger.getName(
							"CNTYCOMPANY", wayvo.getCountyid(), user
									.getCityid());
				} else if (StringUtils.equals("2", orgtype[0])) {
					rootAdaId = wayvo.getCityid();
					showtext = (String) Code2NameConfiger.getName(
							"CITYCOMPANY", wayvo.getCityid(), user.getCityid());
				}
				rootName = showtext;
				topAction = "\"javascript:selectOrg('" + rootAdaId + "','"
						+ showtext + "' , 'org','"
						+ CMSUtils.doGetOrgtypebynumber(orgtype[0]) + "') \"";
			}

			topChildrenURL = rootAdaId != null ? topChildrenURLBuffer
					.toString() : "";
			request.setAttribute("text", showtext);
			request.setAttribute("rootAdaId", rootAdaId);
			request.setAttribute("orgproxy", orgproxy);
			request.setAttribute("rootName", rootName);
			request.setAttribute("parentType", parentType);
			request.setAttribute("topChildrenURL", topChildrenURL);
			request.setAttribute("topAction", topAction);
		} catch (Exception e) {
			log.error(e);
			request.setAttribute("rootAdaId", null);
		}
		return actionMapping.findForward("selectorgTree");
	}

	public ActionForward doSelectwaytree(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			String contextPath = request.getContextPath();

			String topChildrenURI = "selectWayXml.jsp";
			String cityid=request.getParameter("cityid");//新增的地市标识 by xy
			String waytype = request.getParameter("waytype");// 渠道类型
			String waysubtype = request.getParameter("waysubtype");// 渠道子类型
			String runmode=request.getParameter("runmode");
			WayDelegate delegate = new WayDelegate();

			String showOfCitycomStr = (String) request
					.getParameter("showOfCitycom"); // 显示父渠道
			String showParentStr = (String) request.getParameter("showParent"); // 显示父渠道
			String showSiblingStr = (String) request
					.getParameter("showSibling"); // 显示兄弟渠道(同级渠道)
			String menuTokenId = (String) request.getParameter("menuTokenId");

			String queryText = ((WayForm) actionForm).get_sk_wayname();
			if (StringUtils.isBlank(queryText))
				queryText = "";

			boolean showDisabled = ((WayForm) actionForm).isShowDisabled();

			boolean showOfCitycom = false;
			boolean showParent = false;
			boolean showSubWays = false;
			boolean showSibling = false; // 预留
			boolean showSelfOnly = false; // 预留
			// 根据权限和令牌控制渠道树数据: 分4个层次: 市公司渠道, 本渠道及下级, 本渠道,本工号

			String tokenA = "JHQUERYRGT_A";
			String tokenB = "JHQUERYRGT_B";
			String tokenC = "JHQUERYRGT_C";
			String tokenD = "JHQUERYRGT_D";

			if (StringUtils.isNotBlank(menuTokenId)) {
				tokenA = menuTokenId + "_" + tokenA;
				tokenB = menuTokenId + "_" + tokenB;
				tokenC = menuTokenId + "_" + tokenC;
				tokenD = menuTokenId + "_" + tokenD;
			}

			ACLDelegate aclDelegate = new ACLDelegate();
			showOfCitycom = aclDelegate.checkPermission(user.getOpercode(),
					tokenA); // 查询本市公司所有渠道

			if (!showOfCitycom) {

				showParent = aclDelegate.checkPermission(user.getOpercode(),
						tokenB);

				if (!showParent) {
					showSubWays = aclDelegate.checkPermission(user
							.getOpercode(), tokenC); // 查询本渠道及下属渠道

					if (!showSubWays) {
						showSelfOnly = aclDelegate.checkPermission(user
								.getOpercode(), tokenD); // 查询本渠道
					}
				}
			}

			// 以下代码通过特殊参数忽略令牌
			if (StringUtils.isBlank(menuTokenId)) {
				showSubWays = true;
				// showOfCitycom = true;
			}

			if (!showOfCitycom)
				showOfCitycom = showOfCitycomStr != null
						&& "true".equalsIgnoreCase(showOfCitycomStr);
			if (!showParent)
				showParent = showParentStr != null
						&& "true".equalsIgnoreCase(showParentStr);
			if (!showSibling)
				showSibling = showSiblingStr != null
						&& "true".equalsIgnoreCase(showSiblingStr);

			String rootWayId = null;

			if (user != null && StringUtils.isEmpty(cityid)){
				rootWayId = user.getWayid();
			}
			else{
				rootWayId=delegate.doQueryWaybyCityid(SessionFactoryRouter.conversionCityid(cityid), user);
			}
			
			String wayName = "非法渠道";

			String parentType = "Way";
			String rootName = null;
			String topAction = null;
			String topChildrenURL = null;
			StringBuffer topChildrenURLBuffer = new StringBuffer(100);

			if (rootWayId != null) {
				WayVO wayvo = null;
				if (showParent) {
					wayvo = delegate.getUpperWay(rootWayId, user);
					if (wayvo == null)
						wayvo = delegate.doFindByPk(rootWayId, user);

					if (wayvo != null) {
						rootWayId = wayvo.getWayid();
						wayName = wayvo.getWayname();
					}
				} else if (showOfCitycom) {

					wayvo = delegate.getCitycomDirectWayByWay(rootWayId, user);
					if (wayvo != null) {
						rootWayId = wayvo.getWayid();
						wayName = wayvo.getWayname();
					}

				} else if (showSubWays) {
					wayvo = delegate.doFindByPk(rootWayId, user);
					if (wayvo != null) {
						rootWayId = wayvo.getWayid();
						wayName = wayvo.getWayname();
					}
				} else { // show current way only

					wayvo = delegate.doFindByPk(rootWayId, user);
					rootWayId = wayvo.getWayid();
					wayName = wayvo == null ? "非法渠道" : "(" + wayvo.getWayid()
							+ ")" + wayvo.getWayname();
					// rootWayId = "#"; //通过一个不存在的渠道, 实现不加载下级渠道
					topAction = ";";
					topChildrenURLBuffer = new StringBuffer("&");
				}

				// topChildrenURL = contextPath + "/cms/way/" + topChildrenURI
				// +"?parentid=" + rootWayId +
				// "&parenttype=" + parentType +
				// "&function=selectWay&childrenURL=" + contextPath +
				// "/cms/way/" + "selectWayXml.jsp" ;
				//				
				if (!"&".equals(topChildrenURLBuffer.toString()))
					topChildrenURLBuffer.append(contextPath)
							.append("/cms/way/").append(topChildrenURI).append(
									"?parentid=").append(rootWayId).append(
									"&parenttype=").append(parentType).append(
									"&function=selectWay&childrenURL=").append(
									contextPath).append("/cms/way/").append(
									"selectWayXml.jsp")
							.append("&showDisabled=").append(showDisabled)
							.append("&time=").append(new Date().getTime())
							.append("&layer=0");
				if (StringUtils.isNotEmpty(waytype)) {
					topChildrenURLBuffer.append("&waytype=").append(waytype);
				}
				if (StringUtils.isNotEmpty(waysubtype)) {
					topChildrenURLBuffer.append("&waysubtype=").append(
							waysubtype);
				}
				if(StringUtils.isNotEmpty(runmode)){
					topChildrenURLBuffer.append("&runmode=").append(
							runmode);
				}
				if(StringUtils.isNotEmpty(cityid)){
					topChildrenURLBuffer.append("&cityid=").append(
							cityid);
				}

				// if(StringUtils.isNotBlank(queryText))
				// topChildrenURLBuffer.append("&queryText=").append(queryText);
				if (CMSUtils.doGetwaytype(wayvo, waytype, waysubtype,runmode)) {
					topAction = rootWayId != null ? "\"javascript:selectWay('"
							+ rootWayId + "','" + wayName + "' , 'Way') \""
							: "";
				} else {
					topAction = "\"\"";
				}
				rootName = rootWayId != null ? wayName : "无渠道信息";
				topChildrenURL = rootWayId != null ? topChildrenURLBuffer
						.toString() : "";

			}

			request.setAttribute("rootWayId", rootWayId);

			request.setAttribute("rootName", rootName);
			request.setAttribute("parentType", parentType);
			request.setAttribute("topChildrenURL", topChildrenURL);
			request.setAttribute("queryText", queryText);
			request.setAttribute("topAction", topAction);

//			request.getSession().setAttribute("selectwaytree_queryText",
//					queryText);
		} catch (BusinessException e) {
			e.printStackTrace();
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			request.setAttribute("rootName", "非法数据");
		}
		return actionMapping.findForward("selectWayTree");
	}

	public ActionForward doWayinfo(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		WayDelegate wayDelegate = new WayDelegate();
		WayForm wayForm = (WayForm) actionForm;
		WayVO wayVO = wayDelegate.doFindByPk(wayForm.get_se_upperwayid(), user);
		request.getSession().setAttribute("wayinfo", wayVO);
		return null;
	}

	public ActionForward doBatch(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		return actionMapping.findForward("batch");
	}

	/**
	 * 渠道编码|渠道名称|上级渠道|营业点标识|是否共享|渠道类别|渠道子类别| 分公司自定义渠道类别管理|城市级别|渠道等级|
	 * 渠道MIS编码|物业来源分类|是否联网|联网方式|经营模式|是否中心渠道|星级|排他性|
	 * 连锁总店编码|签约状态|营业人员数量|管理人员数量|终端数量|纬度|经度|渠道状态| 渠道中间代码|自营标志
	 */
	/**
	 * 导出为EXCEL格式。
	 */
	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("渠道管理");
		export.appendHeadLine(new String[] { "导出工号:", user.getOpercode() });
		export
				.appendHeadLine(new String[] { "导出时间",
						format.format(new Date()) });
		export.addOutputProperty("wayid", "渠道编码");
		export.addOutputProperty("wayname", "渠道名称");
		export.addOutputProperty("upperwayid", "上级渠道");
		export.addOutputProperty("busicode", "营业点标识");
		export.addOutputProperty("isshare", "是否共享");
		export.addOutputProperty("waytype", "渠道类别");
		export.addOutputProperty("waysubtype", "渠道子类别");
		export.addOutputProperty("custtype", "分公司自定义渠道类别管理");
		export.addOutputProperty("citylevel", "城市级别");
		export.addOutputProperty("bchlevel", "渠道等级");
		export.addOutputProperty("miscode", "渠道MIS编码");
		export.addOutputProperty("prtsource", "物业来源分类");
		export.addOutputProperty("isconnected", "是否联网");
		export.addOutputProperty("connecttype", "联网方式");
		export.addOutputProperty("runmode", "经营模式");
		export.addOutputProperty("iscoreway", "是否中心渠道");
		export.addOutputProperty("starlevel", "星级");
		export.addOutputProperty("pt", "排他性");
		export.addOutputProperty("chainhead", "连锁总店编码");
		export.addOutputProperty("signstatus", "签约状态");
		export.addOutputProperty("empnumber", "营业人员数量");
		export.addOutputProperty("magnumber", "管理人员数量");
		export.addOutputProperty("terminumber", "终端数量");
		export.addOutputProperty("latitude", "纬度");
		export.addOutputProperty("longtitude", "经度");
		export.addOutputProperty("waystate", "渠道状态");
		export.addOutputProperty("depotdet", "渠道中间代码");
		export.addOutputProperty("runbyself", "自营标志");
		export.appendEndBody("是否共享:0,否1,是; 渠道类别:AV,增值合作渠道;RIVL,竞争对手渠道;SA,直销渠道;"
				+ "<br>" + "渠道子类别:AVAG 增值代理商;VTAG 虚拟运营商" + "<br>"
				+ "RVOW 竞争对手自营渠道;RVST 竞争对手社会渠道" + "<br>"
				+ "SMAG 销售经理;CMAG 客户经理" + "<br>" + "分公司自定义渠道类别管理:0,其他;11,热线前台"
				+ "<br>" + "城市级别:1,直辖市;2,副省级;3,地级市;4,县级市;99,其他;-1,退回;" + "<br>"
				+ "渠道等级:1,A级;2,B级;3,C级;99,其他 " + "<br>"
				+ "物业来源分类:0,租赁;1,存续企业购建;2,上市公司购建;3,社会物业（他建） " + "<br>"
				+ "是否联网:0,联网;非联网,1 联网方式:0,光缆;1,2M电缆;2,GPRS;3,CSD;4,拨号上网;5,无线网桥"
				+ "<br>" + "经营模式:0,自建自营;1,自建他营;2,他建他营 是否中心渠道:0,否;1,是 " + "<br>"
				+ "星级:0,未定星级;1,一星级;2,二星级;3,三星级;4,四星级;5,五星级;6,六星级; " + "<br>"
				+ "排他性:-1,双排他;1,非排他;0,单排他; 签约状态:0,正常;1,预解约;2,注销; " + "<br>"
				+ "渠道状态:1,生效,0,无效; 自营标志:FZY,非自营;ZY,自营");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super
				.doExcel(actionMapping, actionForm, request, response, user);
	}
	/**
	 * 渠道查询导出为EXCEL格式。
	 */
	public ActionForward doExcel2(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("渠道查询");
		export.appendHeadLine(new String[] { "导出工号:", user.getOpercode() });
		export
				.appendHeadLine(new String[] { "导出时间",
						format.format(new Date()) });
		export.addOutputProperty("wayid", "渠道编码");
		export.addOutputProperty("wayname", "渠道名称");
		export.addOutputProperty("upperwayid", "上级渠道渠道");
		export.addOutputProperty("upperwayid", "上级渠道名称",
				CommonExportBean.CODE2NAME, "#WAY");
		export.addOutputProperty("busicode", "营业点标识");
		export.addOutputProperty("waytype", "渠道类别", CommonExportBean.CODE2NAME,
				"#WAYTYPE");
		export.addOutputProperty("waysubtype", "渠道子类别",
				CommonExportBean.CODE2NAME, "#WAYTYPE");
		export.addOutputProperty("custtype", "分公司自定义渠道类别管理",
				CommonExportBean.CODE2NAME, "#CUSTWAYTYPE");
		export.addOutputProperty("centerid", "区域中心",
				CommonExportBean.CODE2NAME, "#AREACENTER");
		export.addOutputProperty("cityid", "市公司", CommonExportBean.CODE2NAME,
				"#CITYCOMPANY");
		export.addOutputProperty("countyid", "县公司", CommonExportBean.CODE2NAME,
				"#CNTYCOMPANY");
		export.addOutputProperty("citylevel", "城市级别",
				CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("waylevel", "渠道级别");
		export.addOutputProperty("bchlevel", "渠道等级",
				CommonExportBean.CODE2NAME, "$CH_BCHLEVEL");
		export.addOutputProperty("miscode", "渠道MIS编码");
		export.addOutputProperty("waystate", "渠道状态",
				CommonExportBean.CODE2NAME, "$CH_VALIDFLAG");
		export.addOutputProperty("function", "职能描述");
		export.addOutputProperty("createtime", "创建时间", CommonExportBean.DATE,
				"yyyy-MM-dd");
		export.addOutputProperty("isshare", "是否共享",CommonExportBean.CODE2NAME,"$CH_DSTISKEYSTEP");
		export.voClassArray=new Class[]{voClass};
		export.queryMethodName="doSearch";
		if(export.headtitle==null){
			export.headtitle=export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm,request,response,user,this);
        return actionMapping.findForward(null);
	}
	
	/**
	 * 省级渠道选择框
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doSelectunvmsgbox(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try{
			Page.setPageSize(request, (BaseActionForm)actionForm);
			
			WayForm form = (WayForm)actionForm;
			WayListVO listvo = new WayListVO();
			setListVO(listvo, form);
			
			List waySubtypeList = new ArrayList();
			waySubtypeList.add("UNPB");
			waySubtypeList.add("DIS");
			
			List upperwayidList = new ArrayList();
			upperwayidList.add("UNPB-----");
			upperwayidList.add("DIS-----");
			
			listvo.getQueryConditions().put("_se_waytype", "AG");
			listvo.getQueryConditions().put("_sin_waysubtype", waySubtypeList);
			listvo.getQueryConditions().put("_sin_upperwayid", upperwayidList);
			
			CommonDelegate delegate = new CommonDelegate(WayVO.class);
			DataPackage dp = delegate.doQuery(listvo, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		}catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
			// TODO: handle exception
		}
		return actionMapping.findForward("unvselectmsgbox");
	}
	
}
