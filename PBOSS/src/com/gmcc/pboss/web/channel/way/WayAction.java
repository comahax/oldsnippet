/**
 * auto-generated code
 * Wed Jul 08 11:37:50 CST 2009
 */
package com.gmcc.pboss.web.channel.way;

import java.io.File;
import java.io.PrintWriter;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.channel.bchcontact.BchcontactVO;
import com.gmcc.pboss.business.channel.cooperator.CooperatorVO;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.channel.flowname.FlownameVO;
import com.gmcc.pboss.business.channel.way.AGWayVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountVO;
import com.gmcc.pboss.business.channel.wayapply.WayapplyVO;
import com.gmcc.pboss.business.channel.waycompact.WaycompactVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.common.ftp.FtpAccess;
import com.gmcc.pboss.common.ftp.FtpInfo;
import com.gmcc.pboss.control.base.acl.ACL;
import com.gmcc.pboss.control.base.acl.ACLBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.bchcontact.Bchcontact;
import com.gmcc.pboss.control.channel.bchcontact.BchcontactBO;
import com.gmcc.pboss.control.channel.cooperator.Cooperator;
import com.gmcc.pboss.control.channel.cooperator.CooperatorBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.flowname.Flowname;
import com.gmcc.pboss.control.channel.flowname.FlownameBO;
import com.gmcc.pboss.control.channel.way.AGWay;
import com.gmcc.pboss.control.channel.way.AGWayBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.channel.wayaccount.Wayaccount;
import com.gmcc.pboss.control.channel.wayaccount.WayaccountBO;
import com.gmcc.pboss.control.channel.wayapply.Wayapply;
import com.gmcc.pboss.control.channel.wayapply.WayapplyBO;
import com.gmcc.pboss.control.channel.waycompact.Waycompact;
import com.gmcc.pboss.control.channel.waycompact.WaycompactBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.exception.BusinessException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.AAUtilsForStruts2;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>
 * Title: WayAction
 * </p>
 * ;
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
 * @author Jerimy
 * @version 1.0
 */
public class WayAction extends BaseAction {

	private String processType;//处理类型 
	private String remotepath = "saleway";
	private File compactDoc; // 文本
	private String compactDocFileName;
	private String compactDocType;
	private String flag;// 用于判断是否需要申请审批

	private File licenceDoc; // 合同
	private String licenceDocFileName;
	private String licenceDocType;
	public File getCompactDoc() {
		return compactDoc;
	}
	public void setCompactDoc(File compactDoc) {
		this.compactDoc = compactDoc;
	}
	public String getCompactDocFileName() {
		return compactDocFileName;
	}
	public void setCompactDocFileName(String compactDocFileName) {
		this.compactDocFileName = compactDocFileName;
	}
	public String getCompactDocType() {
		return compactDocType;
	}
	public void setCompactDocType(String compactDocType) {
		this.compactDocType = compactDocType;
	}
	public File getLicenceDoc() {
		return licenceDoc;
	}
	public void setLicenceDoc(File licenceDoc) {
		this.licenceDoc = licenceDoc;
	}
	public String getLicenceDocFileName() {
		return licenceDocFileName;
	}
	public void setLicenceDocFileName(String licenceDocFileName) {
		this.licenceDocFileName = licenceDocFileName;
	}
	public String getLicenceDocType() {
		return licenceDocType;
	}
	public void setLicenceDocType(String licenceDocType) {
		this.licenceDocType = licenceDocType;
	}
	public String getProcessType() {
		return processType;
	}

	public void setProcessType(String processType) {
		this.processType = processType;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}

	public WayAction() {
		super();

		this.setForm(new AGWayForm());
		this.setParam(new WayWebParam());

		setClsVO(WayVO.class);
		this.pkNameArray = new String[] { "wayid" };
		this.setClsControl(Way.class);
		this.setClsQueryParam(WayDBParam.class);

	}

	/**
	 * 为考核登记提供渠道选择列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doListForItemfraded() throws Exception {
		WayDBParam param=(WayDBParam)getParam();
		param.set_pagesize("10");
		DataPackage dp = (DataPackage) executeDlgMethod(METHOD_TYPE_QUERY,param);
		setDp(dp);
		return "itemgraded";
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
	public String doShowOperatorTreeTree() throws Exception {
		doSelectwaytree();
		return "showOperatorTree";
	}
	
	public String doShowWayTree() throws Exception {
		doSelectwaytree();
		return "showwaytree";
	}

	public String doSelectwaytree() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			String contextPath = request.getContextPath();

			String topChildrenURI = "selectWayXml.jsp";
			String cityid = request.getParameter("cityid");// 新增的地市标识 by xy
			String waytype = request.getParameter("waytype");// 渠道类型
			String waysubtype = request.getParameter("waysubtype");// 渠道子类型
			String runmode = request.getParameter("runmode");
			String function = request.getParameter("function");
			
			Map<String,String> waytypeMap = new HashMap<String,String>(); // 存放渠道类型
			Map<String,String> waysubtypeMap = new HashMap<String,String>(); // 存放子渠道类型
			
			if (StringUtils.isEmpty(function)) {
				function = "selectWay";
			}

			User user = (User) getDBAccessUser();
			Way way = (Way) BOFactory.build(WayBO.class, user);

			String showOfCitycomStr = (String) request
					.getParameter("showOfCitycom"); // 显示父渠道
			String showParentStr = (String) request.getParameter("showParent"); // 显示父渠道
			String showSiblingStr = (String) request
					.getParameter("showSibling"); // 显示兄弟渠道(同级渠道)
			String menuTokenId = (String) request.getParameter("menuTokenId");

			String queryText = ((WayDBParam) getParam()).getQueryText();
			if (StringUtils.isBlank(queryText))
				queryText = "";

			boolean showDisabled = ((WayDBParam) getParam()).isShowDisabled();

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

			ACL acl = (ACL) BOFactory.build(ACLBO.class, user);
			showOfCitycom = acl.doCheckPermission(user.getOprcode(), tokenA); // 查询本市公司所有渠道
			if (!showOfCitycom) {
				showParent = acl.doCheckPermission(user.getOprcode(), tokenB);
				if (!showParent) {
					showSubWays = acl.doCheckPermission(user.getOprcode(),
							tokenC); // 查询本渠道及下属渠道
					if (!showSubWays) {
						showSelfOnly = acl.doCheckPermission(user.getOprcode(),
								tokenD); // 查询本渠道
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

			if (user != null && StringUtils.isEmpty(cityid)) {
				rootWayId = user.getWayid();
			} else {
				rootWayId = way.doQueryWaybyCityid(CityMappingUtil
						.getCityid(cityid));
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
					wayvo = way.doGetUpperWay(rootWayId);
					if (wayvo == null)
						wayvo = way.doFindByPk(rootWayId);

					if (wayvo != null) {
						rootWayId = wayvo.getWayid();
						wayName = wayvo.getWayname();
					}
				} else if (showOfCitycom) {

					wayvo = way.doGetCitycomDirectWayByWay(rootWayId);
					if (wayvo != null) {
						rootWayId = wayvo.getWayid();
						wayName = wayvo.getWayname();
					}

				} else if (showSubWays) {
					wayvo = way.doFindByPk(rootWayId);
					if (wayvo != null) {
						rootWayId = wayvo.getWayid();
						wayName = wayvo.getWayname();
					}
				} else { // show current way only

					wayvo = way.doFindByPk(rootWayId);
					rootWayId = wayvo.getWayid();
					wayName = wayvo == null ? "非法渠道" : "(" + wayvo.getWayid()
							+ ")" + wayvo.getWayname();
					// rootWayId = "#"; //通过一个不存在的渠道, 实现不加载下级渠道
					topAction = ";";
					topChildrenURLBuffer = new StringBuffer("&");
				}

				if (!"&".equals(topChildrenURLBuffer.toString()))
					topChildrenURLBuffer.append(contextPath).append(
							"/channel/way/").append(topChildrenURI).append(
							"?parentid=").append(rootWayId).append(
							"&parenttype=").append(parentType).append(
							"&function=").append(function).append(
							"&childrenURL=").append(contextPath).append(
							"/channel/way/").append("selectWayXml.jsp").append(
							"&showDisabled=").append(showDisabled).append(
							"&time=").append(new Date().getTime()).append(
							"&layer=0");
				
				if (StringUtils.isNotEmpty(waytype)) {
					topChildrenURLBuffer.append("&waytype=").append(waytype);
					String[] waytypes = StringUtils.split(waytype, "\\|");
					for(String wt : waytypes) {
						waytypeMap.put(wt, wt);
					}
				}
				if (StringUtils.isNotEmpty(waysubtype)) {
					topChildrenURLBuffer.append("&waysubtype=").append(
							waysubtype);
					String[] waysubtypes = StringUtils.split(waysubtype,"\\|");
					for(String wst : waysubtypes) {
						waysubtypeMap.put(wst, wst);
					}
				}
				if (StringUtils.isNotEmpty(runmode)) {
					topChildrenURLBuffer.append("&runmode=").append(runmode);
				}
				if (StringUtils.isNotEmpty(cityid)) {
					topChildrenURLBuffer.append("&cityid=").append(cityid);
				}

				
				if (way.doGetwaytype(wayvo, waytypeMap, waysubtypeMap, runmode)) {
					topAction = rootWayId != null ? "\"javascript:" + function
							+ "('" + rootWayId + "','" + wayName
							+ "' , 'Way') \"" : "";
				} else {
					topAction = "\"\"";
				}
				rootName = rootWayId != null ? wayName : "无渠道信息";
				topChildrenURL = rootWayId != null ? topChildrenURLBuffer
						.toString() : "";

			}

			System.out.println(topChildrenURL);

			request.setAttribute("rootWayId", rootWayId);

			request.setAttribute("rootName", rootName);
			request.setAttribute("parentType", parentType);
			request.setAttribute("topChildrenURL", topChildrenURL);
			request.setAttribute("queryText", queryText);
			request.setAttribute("topAction", topAction);

		} catch (BusinessException e) {
			e.printStackTrace();
			setActionMessage(e.getMessage());
			request.setAttribute("rootName", "非法数据");
		}
		return "selectWayTree";
	}

	/**
	 * 查询配送商
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doLogslist() throws Exception {
		HttpServletRequest request = getRequest();
		User user = (User) request.getSession().getAttribute(
				WebConstant.SESSION_ATTRIBUTE_USER);
		String waysubtype = request.getParameter("WAYSUBTYPE");
		String wayid = user.getWayid();
		Way way = (Way) BOFactory.build(WayBO.class, user);
		WayVO wayvo = way.doFindByPk(wayid);
		if (wayvo == null) {
			throw new Exception("登录的渠道不存在, 渠道编码:" + wayid);
		}
		WayWebParam param = (WayWebParam)getParam();
		if (param.get_se_waysubtype() == null
				|| param.get_se_waysubtype().trim().equals("")) {
			param.set_se_waysubtype("LOGS");
		}

		DataPackage dp = way.doQueryLogsway(param, user);
		setDp(dp);
		String centerid = wayvo.getCenterid();
		request.setAttribute("centerid", centerid);
		return "logsway";
	}
	
	
	//连锁商和配送商点击列表中链接时执行的查询	
	public String doListByLink() throws Exception{
		try {
			WayDBParam param = (WayDBParam)getParam();
			Way way = (Way) BOFactory.build(WayBO.class, getDBAccessUser());
			DataPackage dp = way.doQuery(param);
			setDp(dp);
		}catch (Exception e) {
			e.printStackTrace();
			setActionMessage(e.getMessage());
		}
		return "salelist";
	} 
	
	/**
	 * 配送商管理编辑
	 * @return "logswaycontent" 配送商管理新增/编辑页面
	 * @throws Exception
	 */
	public String doLogsedit() throws Exception {
		// TODO Auto-generated method stub
		super.doEdit();
		AGWayForm agform = (AGWayForm)getForm();
		Employee employee = (Employee)BOFactory.build(EmployeeBO.class, getDBAccessUser());
		EmployeeDBParam listVO = new EmployeeDBParam();
		listVO.set_se_wayid(agform.getWayid());
		listVO.set_ne_isnet("3");
		listVO.set_ne_empstatus("0");
		DataPackage dp = employee.doQuery(listVO);
		if( null != dp && dp.getRowCount()>0){
			EmployeeVO empvo = (EmployeeVO)dp.getDatas().iterator().next();
			agform.setOfficetel(empvo.getOfficetel());
			agform.setEmployeename(empvo.getEmployeename());
		}
		return "logswaycontent";
	}

	/**
	 * 合作商&经销商列表
	 */
	public String doAglist() throws Exception {
		HttpServletRequest request = getRequest();
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		User user = (User) request.getSession().getAttribute(
				WebConstant.SESSION_ATTRIBUTE_USER);
		try {
			// 检查权限令牌
			Sysparam sysparam = (Sysparam)BOFactory.build(SysparamBO.class, user);
			String paramvalue = sysparam.doFindByID(new Long("77"), "channel");
			// 如果paramvalue查到记录并且值为1，则需要用新的固定参数显示步骤ID下拉框
			if ("1".equals(paramvalue)) {
				this.setFlag("yes");
			}
			//AGWayForm wayForm = (AGWayForm) getForm();
			String wayid = user.getWayid();
			//String waysubtype = request.getParameter("WAYSUBTYPE");
			Way way = (Way) BOFactory.build(WayBO.class, user);
			WayVO wayVO = way.doFindByPk(wayid);
			if (wayVO == null) {
				throw new Exception("登录的渠道不存在, 渠道编码:" + wayid);
			}
			WayDBParam listVO = (WayDBParam) getParam();
			//listVO.set_se_cityid(cityid);
			listVO.set_nne_waystate(new Short("-1"));// 不显示状态为-1的记录

			// 区分DIS、TRST、LOGIS
			if (listVO.get_se_waysubtype() == null
					|| listVO.get_se_waysubtype().trim().equals("")) {
				listVO.set_se_waysubtype("DIS");
			}

			DataPackage dp = way.doQueryByOprcode(listVO, user);
			//String centerid = wayVO.getCenterid();
			//request.setAttribute("centerid", centerid);
			setDp(dp);
		} catch (Exception e) {
			setActionMessage(e.getMessage());
		}
		return "disway";
	}
	
//	public String doListByLinkDis() throws Exception{
//		try {
//			WayDBParam param = (WayDBParam)getParam();
//			Way way = (Way) BOFactory.build(WayBO.class, getDBAccessUser());
//			DataPackage dp = way.doQuery(param);
//			setDp(dp);
//		}catch (Exception e) {
//			e.printStackTrace();
//			setActionMessage(e.getMessage());
//		}
//		return "salelist";
//	} 
	
	/**
	 * 合作商&经销商新建
	 */
	public String doAgnew() throws Exception {
		HttpServletRequest request = getRequest();
		AGWayForm agwayForm = (AGWayForm) getForm();
		WayDBParam param = (WayDBParam)getParam();
		try {

			// 检查权限令牌
			Sysparam sysparam = (Sysparam)BOFactory.build(SysparamBO.class, getDBAccessUser());
			String paramvalue = sysparam.doFindByID(new Long("77"), "channel");
			// 如果paramvalue查到记录并且值为1，则需要用新的固定参数显示步骤ID下拉框
			if ("1".equals(paramvalue)) {
				this.setFlag("yes");
			}
			String upperwayid = param.get_se_upperwayid() == null ? ""
					: param.get_se_upperwayid();
			Way way = (Way) BOFactory.build(WayBO.class, getDBAccessUser());
			WayVO wayVO = way.doFindByPk(upperwayid);
			if (wayVO == null) {
				throw new Exception("用户输入的[上级渠道]不存在");
			} else {
				agwayForm.setUpperwayid(wayVO.getWayid());
				agwayForm.setUpperwayname(wayVO.getWayname());
				agwayForm.setCityid(wayVO.getCityid());
				agwayForm.setCountyid(wayVO.getCountyid());
				agwayForm.setSvccode(wayVO.getSvccode());
				agwayForm.setMareacode(wayVO.getMareacode());
			}
			//默认新增为"有效" by wh
			agwayForm.setWaystate(new Short("1"));
			//默认管理模式为星级模式.
			agwayForm.setCalcumode(new Short("0"));
			String centerid = wayVO.getCenterid();
			request.setAttribute("centerid", centerid);

		} catch (Exception ex) {
			ex.printStackTrace();
			addActionMessage(ex.getMessage());
			return "disway";
		}
		this.setCMD(WEB_CMD_NEW);
		return "diswaycontent";
	}
	
	/**
	 * 配送商新建
	 */
	public String doLogsnew() throws Exception {
		HttpServletRequest request = getRequest();
		User user = (User) request.getSession().getAttribute(
				WebConstant.SESSION_ATTRIBUTE_USER);
		String wayid = user.getWayid();
		Way delegate = (Way)BOFactory.build(WayBO.class, getDBAccessUser());
		WayVO wayVO = delegate.doFindByPk(wayid);
		String centerid = wayVO.getCenterid();
		request.setAttribute("centerid", centerid);
		AGWayForm form = (AGWayForm)getForm();
		form.setWaystate(new Short("1"));
		super.doNew();
		return "logswaycontent";
	}
	
	/**
	 * 保存配送商
	 */
	public String doLogssave() throws Exception {
		AGWayForm form = (AGWayForm) getForm();
		AGWayVO agvo = new AGWayVO();
		Way way = (Way)BOFactory.build(WayBO.class, getDBAccessUser());
		WayVO wayVO = way.doFindByPk(form.getWayid());
		if(null != wayVO){
			BeanUtils.copyProperties(agvo, wayVO);
		}
		BeanUtils.copyProperties(agvo, form,true);
		AGWay agway = (AGWay)BOFactory.build(AGWayBO.class, getDBAccessUser());
		try {
			agvo.setWaytype("AG");
			//agvo.setWaystate(new Short("1"));
			if (agvo.getWaysubtype() == null
					|| agvo.getWaysubtype().trim().equals("")) {
				throw new Exception("渠道子类别没有值！");
			}

			if ("EDIT".equalsIgnoreCase(super
					.getCMD())) {
					agway.doLogsUpdate(agvo,getDBAccessUser());
			} else {
				if (wayVO == null) {
					agway.doLogsCreate(agvo,getDBAccessUser());
				} else {
					throw new Exception("已经存在相同渠道编码的记录,请更换渠道编码!");
				}
			}
			super.addActionMessage("保存成功!");
			this.setCMD(WEB_CMD_SAVE);
		} catch (Exception be) {
			super.addActionError("保存出错："
					+ be.getMessage());
		}
		if("editLogsway".equals(this.processType))
			return "logswaycontent";
		return super.WEB_RESULT_CONTENT;
	}
	
	
	/**
	 * 配送商管理导出
	 */
	public String doLogstxt() throws Exception {
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("配送商管理导出");
		export.addOutputProperty("wayid", "合作商编码");
		export.addOutputProperty("wayname", "合作商名称");
		export.addOutputProperty("upperwayid", "上级渠道");
		export.addOutputProperty("cooperator", "合作方");
		export.addOutputProperty("cityid", "市公司");
		export.addOutputProperty("countyid", "分公司");
		export.addOutputProperty("svccode", "服务销售中心编码 ");
		export.addOutputProperty("mareacode", "微区域编码 ");
		export.addOutputProperty("adacode", "行政区划编码 ");
		export.addOutputProperty("officetel", "手机号 ");
		export.voClassArray = new Class[] { AGWayVO.class };

		prepareResponse(export.getFileName());
		param.set_pagesize("0");
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"合作商编码", "合作商名称", "上级渠道", "合作方" ,"市公司","分公司","服务销售中心编码","微区域编码","行政区划编码","手机号"});
		export.queryMethodName = "doLogslist";
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}

	
	/**
	 * 连锁经营合作商管理
	 */
	public String doDiswayExportTxt(){
		try{
			super.getParam().setQueryAll(true);
			super.getParam().setSelectFieldsUseVOType(true);
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				export.setFileName("连锁经营合作商管理导出");
			export.addOutputProperty("wayid", "合作商编码");
			export.addOutputProperty("wayname", "合作商名称");
			export.addOutputProperty("upperwayid", "上级渠道");
			export.addOutputProperty("cooperator", "合作方");
			export.addOutputProperty("cityid", "市公司");
			export.addOutputProperty("countyid", "分公司");
			export.addOutputProperty("svccode", "服务销售中心编码 ");
			export.addOutputProperty("mareacode", "微区域编码 ");
			export.addOutputProperty("adacode", "行政区划编码 ");
			export.addOutputProperty("taxtype", "扣税方式");
			export.addOutputProperty("mainlayer", "合作层级");
			export.addOutputProperty("waystate", "渠道状态 ");
			export.voClassArray = new Class[] { WayVO.class };

			prepareResponse(export.getFileName());
			
			export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
					"合作商编码", "合作商名称", "上级渠道", "合作方" ,"市公司","分公司","服务销售中心编码","微区域编码","行政区划编码","扣税方式","合作层级","渠道状态 "});
			export.queryMethodName = "doAglist";
			super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return null;
	}
	
	//连锁经营合作商删除
	public String doAgdelete() throws Exception{
		try{
			String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
			if(selectArray == null) {
				addActionError("无法获取选中项目！");
				return "disway";
			}
			Way way = (Way)BOFactory.build(WayBO.class, getDBAccessUser());
			WayVO vo = null;
			for (int i = 0; i < selectArray.length; i++) {
				vo = way.doFindByPk(getSelectedPK(selectArray[i]));
				way.doDelete(vo, getDBAccessUser());
			}
			super.addActionMessage("操作成功！");
		}catch(Exception e){
			super.addActionError(e.getMessage());
		}
		return this.doAglist();
	}
	
	//连锁经营合作商申请退出
	public String doAgdeleteapply() throws Exception{
		try{
			String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
			if(selectArray == null) {
				addActionError("无法获取选中项目！");
				return "disway";
			}
			Flowname flowname = (Flowname)BOFactory.build(FlownameBO.class, getDBAccessUser());
			FlownameVO flvo = flowname.doFindByPk("WAY_REMOVE_AUDIT1");
			if (flvo == null || (flvo.getOprcode() == null || "".equals(flvo.getOprcode().trim()))) {
				super.addActionError("下一步处理人没有定义！");
				return "disway";
			}
			String oprcode = flvo.getOprcode();
			
			Way way = (Way)BOFactory.build(WayBO.class, getDBAccessUser());
			Wayapply apply = (Wayapply)BOFactory.build(WayapplyBO.class,getDBAccessUser());
			WayapplyVO vo = null;
			for (int i = 0; i < selectArray.length; i++) {
				vo = way.doGetageidt(selectArray[i],getDBAccessUser());
				apply.doWayapply(oprcode, vo, getDBAccessUser(), "remove");
			}
			super.addActionMessage("连锁合作商退出申请成功！");
		}catch(Exception e){
			super.addActionError(e.getMessage());
		}
		return this.doAglist();
	}
	
	//配送商删除
	public String doLogsdelete() throws Exception{
		try{
			String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
			if(selectArray == null) {
				addActionError("无法获取选中项目！");
				return "logsway";
			}
			Way way = (Way)BOFactory.build(WayBO.class, getDBAccessUser());
			WayVO vo = null;
			for (int i = 0; i < selectArray.length; i++) {
				vo = way.doFindByPk(getSelectedPK(selectArray[i]));
				way.doDelete(vo, getDBAccessUser());
			}	
			super.addActionMessage("操作成功！");
		}catch(Exception e){
			super.addActionError(e.getMessage());
		}
		return this.doLogslist();
	}
	
	public void doGetwayinfo(){
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		PrintWriter out  = null;
		try {
			String wayid=request.getParameter("wayid");
			String selectType=request.getParameter("selectType");
			Way bo = (Way)BOFactory.build(WayBO.class, getDBAccessUser());
			out = response.getWriter();
			if(!StringUtils.isEmpty(wayid)){
				WayVO vo=bo.doFindByPk(wayid);
				if(!"logsway".equals(selectType) && (vo.getAdtypecode()==null || vo.getStarlevel()==null)){
					out.write("noAdtyOrStarlevel");
					
				}else{
					out.write(vo.getAdtypecode()+","+vo.getStarlevel()+","+vo.getCityid()+","+vo.getCountyid()+","+vo.getSvccode()+","+vo.getMareacode()+
							","+vo.getCenterid()+","+vo.getWaylevel());
				}
			}
			
		} catch (Exception e) {
			out.write("NO");
			e.printStackTrace();
		}
	}
	
	/**
	 * 合作商&经销商保存
	 */
	public String doAgsave() throws Exception {
		HttpServletRequest request = getRequest();
		AGWayForm form = (AGWayForm) getForm();
		boolean upperwayfalg = false;// 用于判断本渠道是否等于上级渠道

		WayVO newVO = new WayVO();
		// 增加vo
		CooperatorVO cooperatorvo = new CooperatorVO();
		WaycompactVO waycompactvo = new WaycompactVO();
		WayaccountVO wayaccountvo = new WayaccountVO();
		BchcontactVO bchcontactvo = new BchcontactVO();

		BeanUtils.copyProperties(cooperatorvo, form);
		BeanUtils.copyProperties(waycompactvo, form);
		BeanUtils.copyProperties(wayaccountvo, form);
		BeanUtils.copyProperties(bchcontactvo, form);
		waycompactvo.setEndtime(form.getCmpendtime());
		
		
		wayaccountvo.setAccid(new Integer(1));

		cooperatorvo.setCooperauid(form.getWayid());
		cooperatorvo.setCooperaname(form.getWayname());

		cooperatorvo.setCpabbrname(form.getWayname());
		cooperatorvo.setCocheckname(form.getShortname());
		// cooperatorvo.setState(new Short("1"));
		cooperatorvo.setState(form.getWaystate());

		cooperatorvo.setMemo(form.getFunction());
		cooperatorvo.setOldcoopera(form.getBusicode());

		cooperatorvo.setSmsmobileno(form.getBuzphoneno());

		cooperatorvo.setServman(form.getPrincipal());
		cooperatorvo.setCooperadel(form.getPrincipal());
		cooperatorvo.setConntel(form.getPrincipaltel());
		cooperatorvo.setUsremail(form.getPrincipalemail());
		cooperatorvo.setConnpers(form.getLinkman());
		cooperatorvo.setBusconntel(form.getLinkmantel());
		cooperatorvo.setConnfaxno(form.getFax());
		cooperatorvo.setStarttime(form.getBegintime());
		cooperatorvo.setLicenceid(form.getLicenceno());
		cooperatorvo.setCustmanager(form.getWaymagcode());
		cooperatorvo.setDistrictid(form.getCityid());

		wayaccountvo.setAccttype(new Short("0"));
		wayaccountvo.setChargetype(new Short("0"));

		BeanUtils.copyProperties(newVO, form);
		//如果是星级模式,把统一模式的时间设置为空
		if(newVO.getCalcumode()==0){
			newVO.setUniformtime("");
		}

		AGWay delegate = (AGWay)BOFactory.build(AGWayBO.class, getDBAccessUser());
		// 增加Delegate
//		Bchcontact bchcontactDelegate = (Bchcontact)BOFactory.build(BchcontactBO.class, getDBAccessUser());
//		Wayaccount wayaccountDelegate = (Wayaccount)BOFactory.build(WayaccountBO.class, getDBAccessUser());
//		Waycompact waycompactDelegate = (Waycompact)BOFactory.build(WaycompactBO.class, getDBAccessUser());
//		Cooperator cooperatorDelegate = (Cooperator)BOFactory.build(CooperatorBO.class, getDBAccessUser());

		try {
			newVO.setWaytype("AG");
			if (newVO.getWaysubtype() == null
					|| newVO.getWaysubtype().trim().equals("")) {
				throw new Exception("渠道子类别没有值！");
			}

			WayaccountVO wayaccountpkvo = new WayaccountVO();
			wayaccountpkvo.setAccid(new Integer(1));
			wayaccountpkvo.setWayid(form.getWayid());

			WayVO oldVO = delegate.doFindByPk(form.getWayid(), getDBAccessUser());
			
			if (waycompactvo != null) {
				try {
					if ((getCompactDocFileName()!=null && !"".equals(this.getCompactDocFileName()))
							|| (getLicenceDocFileName()!=null &&!"".equals(this.getLicenceDocFileName()))) {
						FtpInfo ftpInfo = FtpInfo.getInstance();
						FtpAccess ftp = new FtpAccess(ftpInfo);
						if (getCompactDocFileName()!=null && !"".equals(this.getCompactDocFileName())) {
							String compact = ftp.uploadFile(this.compactDoc,
									remotepath, true);
							form.setCompactpath(compact);
						}
						if (getLicenceDocFileName()!=null && !"".equals(this.getLicenceDocFileName())) {
							String licence = ftp.uploadFile(this.licenceDoc,
									remotepath, true);
							form.setLicencepath(licence);
						}
					}
				} catch (Exception e) {
					super.addActionError(e.getMessage());
					return ("content");
				}
				
			}
			
			if (oldVO != null) {
				if (!oldVO.getUpperwayid().equalsIgnoreCase(newVO.getUpperwayid())) {
					upperwayfalg = true;
				}
				delegate.doAgupdate(oldVO, newVO, cooperatorvo, waycompactvo,
						wayaccountvo, bchcontactvo, upperwayfalg, getDBAccessUser());
				super.addActionMessage("保存成功！");
				this.setCMD(WEB_CMD_SAVE);
			} else {
				if (oldVO == null) {
					// 新增
					delegate.doAgcreate(newVO, cooperatorvo, waycompactvo,
							wayaccountvo, bchcontactvo, getDBAccessUser());
					super.addActionMessage("保存成功！");
					this.setCMD(WEB_CMD_SAVE);
				} else {
					throw new Exception("已经存在相同渠道编码的记录,请更换渠道编码");
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			super.addActionError("保存出错："+ e.getMessage());
		}
		return "diswaycontent";
	}
	
	/**
	 * 合作商&经销商提交申请
	 */
	/**
	 * @return
	 * @throws Exception
	 */
	public String doAgapply() throws Exception {
		
		WayapplyVO applyvo = new WayapplyVO();
		AGWayForm form = (AGWayForm) getForm();

		AGWay delegate = (AGWay)BOFactory.build(AGWayBO.class, getDBAccessUser());
		WayVO oldVO = delegate.doFindByPk(form.getWayid(), getDBAccessUser());
		
		// 查询下一步处理人是否存在
		Flowname flowname = (Flowname)BOFactory.build(FlownameBO.class, getDBAccessUser());
		String pk = null;
		if (oldVO == null) {
			pk = "WAY_ADD_AUDIT1";
		} else {
			pk = "WAY_UPDATE_AUDIT1";
		}
		FlownameVO flvo = flowname.doFindByPk(pk);
		if (flvo == null || (flvo.getOprcode() == null || "".equals(flvo.getOprcode().trim()))) {
			super.addActionError("下一步处理人没有定义！");
			this.setFlag("yes");
			return "diswaycontent";
		}
		String oprcode = flvo.getOprcode();
		
		WaycompactVO waycompactvo = new WaycompactVO();
		BeanUtils.copyProperties(waycompactvo, form);
		waycompactvo.setEndtime(form.getCmpendtime());

		Wayapply apply = (Wayapply)BOFactory.build(WayapplyBO.class,getDBAccessUser());
		
		// 上传ftp文件
		try {			
			if (waycompactvo != null) {
				
				try {
					if ((getCompactDocFileName()!=null && !"".equals(this.getCompactDocFileName()))
							|| (getLicenceDocFileName()!=null &&!"".equals(this.getLicenceDocFileName()))) {
						FtpInfo ftpInfo = FtpInfo.getInstance();
						FtpAccess ftp = new FtpAccess(ftpInfo);
						if (getCompactDocFileName()!=null && !"".equals(this.getCompactDocFileName())) {
							String compact = ftp.uploadFile(this.compactDoc,
									remotepath, true);
							form.setCompactpath(compact);
						}
						if (getLicenceDocFileName()!=null && !"".equals(this.getLicenceDocFileName())) {
							String licence = ftp.uploadFile(this.licenceDoc,
									remotepath, true);
							form.setLicencepath(licence);
						}
					}
				} catch (Exception e) {
					super.addActionError(e.getMessage());
					this.setFlag("yes");
					return ("diswaycontent");
				}
				
			}
			
			// 数据复制到审批表
			BeanUtils.copyProperties(applyvo, form);
			applyvo.setEndtime(form.getCmpendtime());
			if (oldVO == null) {
				apply.doWayapply(oprcode, applyvo, getDBAccessUser(), "add");	
			} else {
				apply.doWayapply(oprcode, applyvo, getDBAccessUser(), "update");	
			}
			this.setFlag("yes");
			super.addActionMessage("提交申请成功！");
			this.setCMD(WEB_CMD_SAVE);
			
		}catch (Exception e) {
			e.printStackTrace();
			this.setFlag("yes");
			super.addActionError("保存出错："+ e.getMessage());
		}
		return "diswaycontent";
	}
	
	/**
	 * 合作商&经销编辑
	 */
	public String doAgedit() throws Exception {
		HttpServletRequest request = getRequest();
		String pk = request.getParameter("param._pk");
		AGWayForm agform =  (AGWayForm)getForm();

		// 检查权限令牌
		Sysparam sysparam = (Sysparam)BOFactory.build(SysparamBO.class, getDBAccessUser());
		String paramvalue = sysparam.doFindByID(new Long("77"), "channel");
		// 如果paramvalue查到记录并且值为1，则需要用新的固定参数显示步骤ID下拉框
		if ("1".equals(paramvalue)) {
			this.setFlag("yes");
		}
		Way delegate = (Way)BOFactory.build(WayBO.class, getDBAccessUser());
		Bchcontact bchcontactDelegate = (Bchcontact)BOFactory.build(BchcontactBO.class, getDBAccessUser());
		Wayaccount wayaccountDelegate = (Wayaccount)BOFactory.build(WayaccountBO.class, getDBAccessUser());
		Waycompact waycompactDelegate = (Waycompact)BOFactory.build(WaycompactBO.class, getDBAccessUser());
		Cooperator cooperatorDelegate = (Cooperator)BOFactory.build(CooperatorBO.class, getDBAccessUser());

		WayVO wayvo = delegate.doFindByPk(getSelectedPK(pk));
		BchcontactVO bchcontactvo = bchcontactDelegate.doFindByPk(
				getAgdeletePK(pk, BchcontactVO.class));
		WayaccountVO wayaccountvo = wayaccountDelegate.doFindByPk(
				getAgdeletePkVO(1 + "|" + pk, WayaccountVO.class));
		CooperatorVO cooperatorvo = cooperatorDelegate.doFindByPk(pk);
		WaycompactVO waycompactvo = waycompactDelegate.doFindByPk(
				getAgdeletePK(pk, WaycompactVO.class));

		//AuditUtils utils = new AuditUtils();
		String[] waypk = { "wayid" };
		String[] cooperaupk = { "cooperauid" };
		String[] wayaccountpk = { "accid", "wayid" };

//		wayvo = (WayVO) utils.doGetAuditvalue(wayvo, "CH_PW_WAY",
//				"CH_PW_STRBWAY", waypk, user);
		if (cooperatorvo != null) {
//			cooperatorvo = (CooperatorVO) utils.doGetAuditvalue(cooperatorvo,
//					"CH_DST_COOPERATOR", "CH_PW_STRBWAY", cooperaupk, user);
			BeanUtils.copyProperties(agform, cooperatorvo);
		}
		if (wayaccountvo != null) {
//			wayaccountvo = (WayaccountVO) utils.doGetAuditvalue(wayaccountvo,
//					"CH_PW_WAYACCOUNT", "CH_PW_STRBWAY", wayaccountpk, user);
			BeanUtils.copyProperties(agform, wayaccountvo);
		}

		BeanUtils.copyProperties(agform, wayvo);
		//如果是星级模式,把统一模式的时间设置为空
		if(agform.getCalcumode()==null || agform.getCalcumode()==0){
			agform.setUniformtime("");
		}
		if (bchcontactvo != null) {
			BeanUtils.copyProperties(agform, bchcontactvo);
		}
		if (waycompactvo != null) {
			BeanUtils.copyProperties(agform, waycompactvo);
			agform.setCmpendtime(waycompactvo.getEndtime());

		}

		// getContentVO(request, user, actionForm);

		String command = super.getCMD();
		//((AGWayForm) actionForm).setCmdState(command);
//		((AGWayForm) actionForm).set_se_upperwayid(((AGWayForm) actionForm)
//				.getUpperwayid());
		this.setCMD("AGEDIT");
		return "diswaycontent";
	}
	
	/**
	 * 得到相应表的单主键
	 */
	protected Serializable getAgdeletePK(String pkValue, Class voClass)
			throws Exception {
		Method[] methodArray = voClass.getMethods();
		Class pkType = null;
		for (int i = 0; i < methodArray.length; i++) {
			if (methodArray[i].getName().equalsIgnoreCase(
					"get" + pkNameArray[0])) {
				pkType = methodArray[i].getReturnType();
			}
		}
		if (Integer.class == pkType) {
			return new Integer(pkValue);
		} else if (Long.class == pkType) {
			return new Long(pkValue);
		} else if (String.class == pkType) {
			return pkValue;
		} else {
			throw new Exception("错误的主键类型");
		}
	}

	/**
	 * 得到相应表的双主键
	 */
	protected Serializable getAgdeletePkVO(String pkValue, Class voClass)
			throws Exception {
		String[] pkValueArray = pkValue.split("\\|");
		Serializable vo = (Serializable) voClass.newInstance();
		String[] pk = { "accid", "wayid" };

		for (int j = 0; j < pkValueArray.length; j++) {
			BeanUtils.setProperty(vo, pk[j], pkValueArray[j]);
		}
		return vo;
	}
	
	// 分公司下拉框数值根据市公司来变化
	public String doGetCountyid() throws Exception {
		if (AAUtilsForStruts2.isAjaxRequest()) {
			WayDBParam listVO = (WayDBParam) getParam();
			String cityid = listVO.get_se_cityid();
			getRequest().setAttribute("cityid", cityid);
			AAUtilsForStruts2.addZonesToRefresh("refreshcountyid");
		}
		return "disway";
	}

}