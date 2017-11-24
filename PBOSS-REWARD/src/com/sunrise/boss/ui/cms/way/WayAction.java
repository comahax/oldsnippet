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
		// ���¼��������Ǳ����
		// ָ��VO��
		setVoClass(WayVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
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
					"��¼������������, ��������:" + wayid);
			return actionMapping.findForward("list");
		}

		String centerid = wayVO.getCenterid();
		String cityid = wayVO.getCityid();
		String countyid = wayVO.getCountyid();

		request.setAttribute("centerid", centerid); // ��¼������û�������ʶ, �ж�Ϊʡֱ������,
		// ���Կ��� �����������������
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
		// ����ѯ������Ϊ������ȱʡֵ,��Ҫ���ϼ�����id,��������id,�й�˾id,�ع�˾id.
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
				throw new BusinessException("","[������㣬������]��������,��ȥר�ŵ������˵�����¼��!");
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
				newVO.setWaystate(new Short("1"));// ����ʱ������״̬����Ϊ��Ч.xy
				delegate.doCreate(newVO, user);
			}
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
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
			rootName = "�㶫ʡ";
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
			showtext = "��������֯�ṹ��Ϣ";
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

			String waytype = request.getParameter("waytype");// ��������
			String waysubtype = request.getParameter("waysubtype");// ����������
			String runmode="";
			WayDelegate delegate = new WayDelegate();
			String menuTokenId = (String) request.getParameter("menuTokenId");
			boolean isable = StringUtils.isEmpty(request
					.getParameter("showDisabled")) ? false : true;
			boolean showOfCitycom = false;
			boolean showParent = false;
			boolean showSubWays = false;
			boolean showSibling = false; // Ԥ��
			boolean showSelfOnly = false; // Ԥ��
			// ����Ȩ�޺����ƿ�������������: ��4�����: �й�˾����, ���������¼�, ������,������

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
					tokenA); // ��ѯ���й�˾��������

			if (!showOfCitycom) {

				showParent = aclDelegate.checkPermission(user.getOpercode(),
						tokenB);

				if (!showParent) {
					showSubWays = aclDelegate.checkPermission(user
							.getOpercode(), tokenC); // ��ѯ����������������

					if (!showSubWays) {
						showSelfOnly = aclDelegate.checkPermission(user
								.getOpercode(), tokenD); // ��ѯ������
					}
				}
			}

			// ���´���ͨ�����������������
			if (StringUtils.isBlank(menuTokenId)) {
				showSubWays = true;
				// showOfCitycom = true;
			}
			String rootWayId = null;

			if (user != null)
				rootWayId = user.getWayid();

			String wayName = "�Ƿ�����";

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
					wayName = wayvo == null ? "�Ƿ�����" : "(" + wayvo.getWayid()
							+ ")" + wayvo.getWayname();
					// rootWayId = "#"; //ͨ��һ�������ڵ�����, ʵ�ֲ������¼�����
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
						: "��������Ϣ";
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
			request.setAttribute("rootName", "�Ƿ�����");
		}
	}

	/**
	 * �����������ṹModel
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
		// WebConstant.STRING_TRUE); //�ɱ༭���
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
							"�ϼ�����������ʡ��˾/��������");
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
					"CMS-11002:����ָ���ϼ����ϼ�����.");
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
							"�����������ڣ� ����:" + upperwayid);
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
	 * ά����������
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

			// ��ѯ�й�˾����������
			addCitycompanys(areacenterVO, treeListData, user);
		}

	}

	private void addCitycompanys(AreacenterVO areacenterVO, List treeListData,
			User user) throws Exception {

		if (log.isInfoEnabled())
			log.info("��������:" + areacenterVO.getCentername());
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

			// ��ѯ�ع�˾����������
			addCntycompanys(citycompanyVO, treeListData, user);
		}

	}

	private void addCntycompanys(CitycompanyVO citycompanyVO,
			List treeListData, User user) throws Exception {

		if (log.isInfoEnabled())
			log.info("�й�˾:" + citycompanyVO.getCitycompname());
		String cityid = citycompanyVO.getCitycompid();
		CntycompanyDelegate delegate = new CntycompanyDelegate();
		List countycoms = (List) delegate.getCntycompanysOfCity(cityid, user)
				.getDatas();
		for (int i = 0; i < countycoms.size(); i++) {
			CntycompanyVO cntycompanyVO = (CntycompanyVO) countycoms.get(i);
			if (log.isInfoEnabled())
				log.info("�ع�˾:" + cntycompanyVO.getCountycompname());
			TreeNode countycomNode = new TreeNode("COUNTY_"
					+ cntycompanyVO.getCountycompid(), "CITY_" + cityid,
					cntycompanyVO.getCountycompname(), "Cntycompany");
			treeListData.add(countycomNode);
		}
	}

	/**
	 * ������֯�ṹ��
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
				rootName = "�㶫ʡ";
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
				showtext = "��������֯�ṹ��Ϣ";
			}
			// ���Ҫ������ļ�������û����ڵļ�������ʾ�������Ϣ

			if (StringUtils.isNotEmpty(orgtype[0])
					&& (Integer.valueOf(orgproxy).intValue()) > (Integer
							.valueOf(orgtype[0]).intValue())) {
				// topAction="\"javascript:void(0)\"";
				// rootAdaId=null;
				// showtext="����ǰ��������֯������"+orgtype[1]+"һ��!";
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
			String cityid=request.getParameter("cityid");//�����ĵ��б�ʶ by xy
			String waytype = request.getParameter("waytype");// ��������
			String waysubtype = request.getParameter("waysubtype");// ����������
			String runmode=request.getParameter("runmode");
			WayDelegate delegate = new WayDelegate();

			String showOfCitycomStr = (String) request
					.getParameter("showOfCitycom"); // ��ʾ������
			String showParentStr = (String) request.getParameter("showParent"); // ��ʾ������
			String showSiblingStr = (String) request
					.getParameter("showSibling"); // ��ʾ�ֵ�����(ͬ������)
			String menuTokenId = (String) request.getParameter("menuTokenId");

			String queryText = ((WayForm) actionForm).get_sk_wayname();
			if (StringUtils.isBlank(queryText))
				queryText = "";

			boolean showDisabled = ((WayForm) actionForm).isShowDisabled();

			boolean showOfCitycom = false;
			boolean showParent = false;
			boolean showSubWays = false;
			boolean showSibling = false; // Ԥ��
			boolean showSelfOnly = false; // Ԥ��
			// ����Ȩ�޺����ƿ�������������: ��4�����: �й�˾����, ���������¼�, ������,������

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
					tokenA); // ��ѯ���й�˾��������

			if (!showOfCitycom) {

				showParent = aclDelegate.checkPermission(user.getOpercode(),
						tokenB);

				if (!showParent) {
					showSubWays = aclDelegate.checkPermission(user
							.getOpercode(), tokenC); // ��ѯ����������������

					if (!showSubWays) {
						showSelfOnly = aclDelegate.checkPermission(user
								.getOpercode(), tokenD); // ��ѯ������
					}
				}
			}

			// ���´���ͨ�����������������
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
			
			String wayName = "�Ƿ�����";

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
					wayName = wayvo == null ? "�Ƿ�����" : "(" + wayvo.getWayid()
							+ ")" + wayvo.getWayname();
					// rootWayId = "#"; //ͨ��һ�������ڵ�����, ʵ�ֲ������¼�����
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
				rootName = rootWayId != null ? wayName : "��������Ϣ";
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
			request.setAttribute("rootName", "�Ƿ�����");
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
	 * ��������|��������|�ϼ�����|Ӫҵ���ʶ|�Ƿ���|�������|���������| �ֹ�˾�Զ�������������|���м���|�����ȼ�|
	 * ����MIS����|��ҵ��Դ����|�Ƿ�����|������ʽ|��Ӫģʽ|�Ƿ���������|�Ǽ�|������|
	 * �����ܵ����|ǩԼ״̬|Ӫҵ��Ա����|������Ա����|�ն�����|γ��|����|����״̬| �����м����|��Ӫ��־
	 */
	/**
	 * ����ΪEXCEL��ʽ��
	 */
	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("��������");
		export.appendHeadLine(new String[] { "��������:", user.getOpercode() });
		export
				.appendHeadLine(new String[] { "����ʱ��",
						format.format(new Date()) });
		export.addOutputProperty("wayid", "��������");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("upperwayid", "�ϼ�����");
		export.addOutputProperty("busicode", "Ӫҵ���ʶ");
		export.addOutputProperty("isshare", "�Ƿ���");
		export.addOutputProperty("waytype", "�������");
		export.addOutputProperty("waysubtype", "���������");
		export.addOutputProperty("custtype", "�ֹ�˾�Զ�������������");
		export.addOutputProperty("citylevel", "���м���");
		export.addOutputProperty("bchlevel", "�����ȼ�");
		export.addOutputProperty("miscode", "����MIS����");
		export.addOutputProperty("prtsource", "��ҵ��Դ����");
		export.addOutputProperty("isconnected", "�Ƿ�����");
		export.addOutputProperty("connecttype", "������ʽ");
		export.addOutputProperty("runmode", "��Ӫģʽ");
		export.addOutputProperty("iscoreway", "�Ƿ���������");
		export.addOutputProperty("starlevel", "�Ǽ�");
		export.addOutputProperty("pt", "������");
		export.addOutputProperty("chainhead", "�����ܵ����");
		export.addOutputProperty("signstatus", "ǩԼ״̬");
		export.addOutputProperty("empnumber", "Ӫҵ��Ա����");
		export.addOutputProperty("magnumber", "������Ա����");
		export.addOutputProperty("terminumber", "�ն�����");
		export.addOutputProperty("latitude", "γ��");
		export.addOutputProperty("longtitude", "����");
		export.addOutputProperty("waystate", "����״̬");
		export.addOutputProperty("depotdet", "�����м����");
		export.addOutputProperty("runbyself", "��Ӫ��־");
		export.appendEndBody("�Ƿ���:0,��1,��; �������:AV,��ֵ��������;RIVL,������������;SA,ֱ������;"
				+ "<br>" + "���������:AVAG ��ֵ������;VTAG ������Ӫ��" + "<br>"
				+ "RVOW ����������Ӫ����;RVST ���������������" + "<br>"
				+ "SMAG ���۾���;CMAG �ͻ�����" + "<br>" + "�ֹ�˾�Զ�������������:0,����;11,����ǰ̨"
				+ "<br>" + "���м���:1,ֱϽ��;2,��ʡ��;3,�ؼ���;4,�ؼ���;99,����;-1,�˻�;" + "<br>"
				+ "�����ȼ�:1,A��;2,B��;3,C��;99,���� " + "<br>"
				+ "��ҵ��Դ����:0,����;1,������ҵ����;2,���й�˾����;3,�����ҵ�������� " + "<br>"
				+ "�Ƿ�����:0,����;������,1 ������ʽ:0,����;1,2M����;2,GPRS;3,CSD;4,��������;5,��������"
				+ "<br>" + "��Ӫģʽ:0,�Խ���Ӫ;1,�Խ���Ӫ;2,������Ӫ �Ƿ���������:0,��;1,�� " + "<br>"
				+ "�Ǽ�:0,δ���Ǽ�;1,һ�Ǽ�;2,���Ǽ�;3,���Ǽ�;4,���Ǽ�;5,���Ǽ�;6,���Ǽ�; " + "<br>"
				+ "������:-1,˫����;1,������;0,������; ǩԼ״̬:0,����;1,Ԥ��Լ;2,ע��; " + "<br>"
				+ "����״̬:1,��Ч,0,��Ч; ��Ӫ��־:FZY,����Ӫ;ZY,��Ӫ");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super
				.doExcel(actionMapping, actionForm, request, response, user);
	}
	/**
	 * ������ѯ����ΪEXCEL��ʽ��
	 */
	public ActionForward doExcel2(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("������ѯ");
		export.appendHeadLine(new String[] { "��������:", user.getOpercode() });
		export
				.appendHeadLine(new String[] { "����ʱ��",
						format.format(new Date()) });
		export.addOutputProperty("wayid", "��������");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("upperwayid", "�ϼ���������");
		export.addOutputProperty("upperwayid", "�ϼ���������",
				CommonExportBean.CODE2NAME, "#WAY");
		export.addOutputProperty("busicode", "Ӫҵ���ʶ");
		export.addOutputProperty("waytype", "�������", CommonExportBean.CODE2NAME,
				"#WAYTYPE");
		export.addOutputProperty("waysubtype", "���������",
				CommonExportBean.CODE2NAME, "#WAYTYPE");
		export.addOutputProperty("custtype", "�ֹ�˾�Զ�������������",
				CommonExportBean.CODE2NAME, "#CUSTWAYTYPE");
		export.addOutputProperty("centerid", "��������",
				CommonExportBean.CODE2NAME, "#AREACENTER");
		export.addOutputProperty("cityid", "�й�˾", CommonExportBean.CODE2NAME,
				"#CITYCOMPANY");
		export.addOutputProperty("countyid", "�ع�˾", CommonExportBean.CODE2NAME,
				"#CNTYCOMPANY");
		export.addOutputProperty("citylevel", "���м���",
				CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("waylevel", "��������");
		export.addOutputProperty("bchlevel", "�����ȼ�",
				CommonExportBean.CODE2NAME, "$CH_BCHLEVEL");
		export.addOutputProperty("miscode", "����MIS����");
		export.addOutputProperty("waystate", "����״̬",
				CommonExportBean.CODE2NAME, "$CH_VALIDFLAG");
		export.addOutputProperty("function", "ְ������");
		export.addOutputProperty("createtime", "����ʱ��", CommonExportBean.DATE,
				"yyyy-MM-dd");
		export.addOutputProperty("isshare", "�Ƿ���",CommonExportBean.CODE2NAME,"$CH_DSTISKEYSTEP");
		export.voClassArray=new Class[]{voClass};
		export.queryMethodName="doSearch";
		if(export.headtitle==null){
			export.headtitle=export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm,request,response,user,this);
        return actionMapping.findForward(null);
	}
	
	/**
	 * ʡ������ѡ���
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
