package com.sunrise.boss.ui.cms.zjty.zjtywayinfo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ajaxanywhere.AAUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.adimarea.persistent.AdimareaVO;
import com.sunrise.boss.business.cms.common.AuditUtils;
import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.adimarea.AdimareaDelegate;
import com.sunrise.boss.delegate.cms.svwayinfo.SvwayinfoDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * 自建他营渠道基本信息管理
 * 
 * @author LiZhaoLiang
 * 
 */
public class ZjtywayinfoAction extends BaseAction {

	public static final String remotepath = "Upload/cms/way";

	AuditUtils utils = new AuditUtils();

	public ZjtywayinfoAction() {
		// TODO Auto-generated constructor stub
		super.pkNameArray = new String[] { "wayid" };
		super.voClass = WayVO.class;
	}

	/**
	 * 导出
	 */
	protected ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("自建他营渠道基本信息");
		export.addOutputProperty("wayid", "渠道编码");
		export.addOutputProperty("wayname", "渠道名称");
		export.addOutputProperty("upperwayid", "上级渠道");

		export.addOutputProperty("svbrchcode", "服务厅类别");
		export.addOutputProperty("bchlevel", "服务厅级别");
		export.addOutputProperty("waytype", "渠道类别");
		export.addOutputProperty("waysubtype", "子类型");
		export.addOutputProperty("cityid", "地市公司");
		export.addOutputProperty("countyid", "分公司");
		export.addOutputProperty("svccode", "服务销售中心");
		export.addOutputProperty("mareacode", "微区域");
		export.addOutputProperty("starlevel", "星级");

		export.addOutputProperty("buztypecode", "商圈类型");
		export.addOutputProperty("adtypecode", "区域类型");
		export.addOutputProperty("buzphoneno", "联系电话");
		export.addOutputProperty("adacode", "行政区划");
		// "详细地址","地理纬度","地理经度","经营模式","是否联网","联网方式","物业来源分类","是否中心渠道","合作商编码"
		export.addOutputProperty("address", "详细地址");
		export.addOutputProperty("latitude", "地理纬度");
		export.addOutputProperty("longtitude", "地理经度");
		export.addOutputProperty("runmode", "经营模式");
		export.addOutputProperty("isconnected", "是否联网");
		export.addOutputProperty("connecttype", "联网方式");
		export.addOutputProperty("prtsource", "物业来源分类");
		export.addOutputProperty("iscoreway", "是否中心渠道");
		export.addOutputProperty("chainhead", "合作商编码");
		export.addOutputProperty("isshare", "是否共享");
		// String endLine[] = { "(注:填写后请将数据转换为txt格式,去掉标题行,再上传导入)",
		// "时间格式为:YYYY-MM-DD(如:2007-04-18)",
		// "服务厅类别:0:城区主服务厅;1,县主服务厅;2,城区普通服务厅;3,县普通服务厅;4,乡镇服务厅",
		// "MZ1,动感地带品牌店;MZ2,动感地带校园店;PVIP,易登机贵宾厅;CVIP,易登车贵宾厅;",
		// "是否联网:0,联网;1,非联网;是否中心渠道:0,否;1,是","服务厅级别:1,A级;2,B级;3,C级;99,其它;主类型编码:ET,实体渠道;"
		// };
		export.appendEndLine(new String[] { "导出工号:", user.getOpercode(),"导出时间",
				format.format(new Date())});
		export.appendEndBody("(注:填写后请将数据转换为txt格式,去掉标题行,再上传导入)" + "<br>"
				+ "时间格式为:YYYY-MM-DD(如:2007-04-18)" + "<br>"
				+ "服务厅类别:0:城区主服务厅;1,县主服务厅;2,城区普通服务厅;3,县普通服务厅;4,乡镇服务厅" + "<br>"
				+ "服务厅级别:1,A级;2,B级;3,C级;99,其它;渠道类别编码:ET,实体渠道;" + "<br>"
				+ "星级:0,未定星级;1,一星级;2,二星级;3,三星级;4,四星级;5,五星级;6,六星级" + "<br>"
				+ "商圈类型:0,商业区;1,商务区;2,交通枢纽;3,住宅社区;4,学校区域;5,厂矿;6,郊县;7,乡镇;99,其他"
				+ "<br>" + "区域类型:0,城区;1,郊县;2,一类乡镇;3,二类乡镇;4,三类乡镇;99,其他" + "<br>"
				+ "经营模式:0,自建自营;1,自建他营;2,他建他营;" + "<br>"
				+ "联网方式:0,光缆;1,2M电缆;2,GPRS;3,CSD;4,拨号上网;5,无线网桥" + "<br>"
				+ "物业来源:0,租赁;1,存续企业购建;2,上市公司购建;3,社会物业（他建）;" + "<br>"
				+ "渠道子类别:GMPT,移动公司部门/科室;G100,沟通100服务厅;D100,动力100信息化体验店;"+"<br>"
				+ "MZ1,动感地带品牌店;MZ2,动感地带校园店;PVIP,易登机贵宾厅;CVIP,易登车贵宾厅;" + "<br>"
				+ "是否联网:0,联网;1,非联网;是否中心渠道:0,否;1,是;是否共享:0,否;1,是" + "<br>");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super
				.doExcel(actionMapping, actionForm, request, response, user);
	}

	/**
	 * 用户修改上级渠道
	 */ 
	public ActionForward doChangeupwayid(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ZjtywayinfoForm form = (ZjtywayinfoForm) actionForm;
		form.setCmdState(request.getParameter("cmdstates"));
		WayDelegate delegate = new WayDelegate();
		WayVO wayVO = delegate.doFindByPk(form.getUpperwayid(), user);
		form.setCityid(wayVO.getCityid());
		form.setCountyid(wayVO.getCountyid());
		if (StringUtils.isEmpty(wayVO.getCountyid())) {
			request.setAttribute("ischange", "1");
		}
		if (wayVO.getWaystate().intValue() == -1) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"上级渠道状态必须是有效的.");
			request.setAttribute("isExit", "1");
		}
		form.setSvccode(wayVO.getSvccode());
		form.setMareacode(wayVO.getMareacode());
		if (AAUtils.isAjaxRequest(request)) {
			AAUtils.addZonesToRefresh(request, "getcityid");
			AAUtils.addZonesToRefresh(request, "getcountyid");
			AAUtils.addZonesToRefresh(request, "getsvccode");
			AAUtils.addZonesToRefresh(request, "getmareacode");
			AAUtils.addZonesToRefresh(request, "showerror");
			AAUtils.addZonesToRefresh(request, "showbutton");
		}
		return actionMapping.findForward("content");
	}

	public ActionForward doSelectsv(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ZjtywayinfoForm form = (ZjtywayinfoForm) actionForm;

		request.setAttribute("FLAG", form.getRunmode());
		if (!new Long(1).equals(form.getRunmode())) {
			form.setChainhead(null);
		}

		if (AAUtils.isAjaxRequest(request)) {
			AAUtils.addZonesToRefresh(request, "sv");
		}
		return (actionMapping.findForward("content"));
	}

	// 下拉框选择
	public ActionForward doGetcountid(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ZjtywayinfoForm form = (ZjtywayinfoForm) actionForm;
		form.setCmdState(request.getParameter("cmdstates"));
		WayDelegate delegate = new WayDelegate();
		WayVO wayVO = new WayVO();
		if (StringUtils.isNotEmpty(form.getUpperwayid())) {
			wayVO = delegate.doFindByPk(form.getUpperwayid(), user);
		}
		if (StringUtils.isEmpty(wayVO.getCountyid())) {
			request.setAttribute("ischange", "1");
		}
		String cmdvalue = request.getParameter("cmdvalue");
		if ("cityid".equals(cmdvalue)) {
			form.setCountyid("");
			form.setSvccode("");
			form.setMareacode("");
		} else if ("citycompid".equals(cmdvalue)) {
			form.setSvccode("");
			form.setMareacode("");
		}
		if (AAUtils.isAjaxRequest(request)) {
			AAUtils.addZonesToRefresh(request, "getcountyid");
			AAUtils.addZonesToRefresh(request, "getsvccode");
			AAUtils.addZonesToRefresh(request, "getmareacode");

		}

		return actionMapping.findForward("content");
	}

	public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ZjtywayinfoForm form = (ZjtywayinfoForm) actionForm;
		// form.set_se_wayid(user.getWayid());
		return actionMapping.findForward("list");
	}
	
	/**
	 * 自建他营渠道信息
	 */
	protected ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		Page.setPageSize(request, (BaseActionForm) actionForm);
		ZjtywayinfoForm form = (ZjtywayinfoForm) actionForm;
		WayDelegate delegate = new WayDelegate();
		WayListVO listvo = new WayListVO();
		BeanUtils.copyProperties(listvo, form);
		listvo.set_se_waytype("AG");
		listvo.set_se_waysubtype("ZJTY");
		listvo.set_ne_runmode("1");
		listvo.set_se_cityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
		DataPackage zjtywaydp = delegate.doQuery(listvo, user);
		request.setAttribute("LIST", zjtywaydp);

		return actionMapping.findForward("list");
	}

	
	public ActionForward doEdit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user)throws Exception {
		ZjtywayinfoForm form = (ZjtywayinfoForm) actionForm;
		return super.doEdit(actionMapping, actionForm, request, response, user);
	}
	
	protected ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			ZjtywayinfoForm form = (ZjtywayinfoForm) actionForm;
			form.setMareacode(StringUtils.equals("请选择", form.getMareacode()) ? "" : form.getMareacode());
			form.setSvccode(StringUtils.equals("请选择", form.getSvccode()) ? ""
					: form.getSvccode());
			form.setWaytype("AG");
			WayDelegate delegate = new WayDelegate();
			WayVO wayVO = (WayVO) delegate.doFindByPk(form.getWayid(), user);
			if (StringUtils.equals("NEW", form.getCmdState()) && wayVO == null) {
				WayVO newvo = new WayVO();
				BeanUtils.copyProperties(newvo, form);
				newvo.setWaystate(new Short("1"));
				delegate.doCreate(newvo, user);
				request.setAttribute("wayid", newvo.getWayid());
			} else {
				BeanUtils.copyProperties(wayVO, form, true);
				if ("".equals(wayVO.getWaystate())
						|| wayVO.getWaystate() == null) {
					wayVO.setWaystate(new Short("1"));
				}
				request.setAttribute("wayid", wayVO.getWayid());
				delegate.doUpdate(wayVO, user);
			}
			request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
							"SAVE");
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功!");
			return actionMapping.findForward("content");
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			request
					.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
							"EDIT");
			return actionMapping.findForward("content");
		}
	}

	protected ActionForward doDelete(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ZjtywayinfoForm form = (ZjtywayinfoForm) actionForm;
		SvwayinfoDelegate delegate = new SvwayinfoDelegate();
		for (int i = 0; i < form.get_selectitem().length; i++) {
			WayVO vo = (WayVO) delegate.doFindByPk(form.get_selectitem()[i],
					user);
			delegate.doRemove(vo, user);
		}
		return this.doList(actionMapping, actionForm, request, response, user);
	}

	protected ActionForward doNew(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ZjtywayinfoForm form = (ZjtywayinfoForm) actionForm;
		if (StringUtils.isNotEmpty(form.getUpperwayid())) {
			form.set_se_upperwayid(form.getUpperwayid());
			this.doChangeupwayid(actionMapping, actionForm, request, response,
					user);
		}
		return super.doNew(actionMapping, actionForm, request, response, user);
	}


	public ActionForward doExistedwid(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ZjtywayinfoForm form = (ZjtywayinfoForm) actionForm;
		SvwayinfoDelegate delegate = new SvwayinfoDelegate();
		WayVO wayVO = (WayVO) delegate.doFindByPk(form.getWayid(), user);
		if (wayVO != null && wayVO.getWaystate().intValue() > -1) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"该渠道基本信息已存在");
			request.setAttribute("isExit", "1");
		}
		if (!AuditUtils.doCheckWayidStyle(form.getWayid())
				&& StringUtils.isNotEmpty(form.getWayid())) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"渠道编码格式不正确,只能是字母+数字或者'-'");
			request.setAttribute("isExit", "1");
		}
		if (AAUtils.isAjaxRequest(request)) {
			AAUtils.addZonesToRefresh(request, "showerror");
			AAUtils.addZonesToRefresh(request, "showbutton");
		}
		return (actionMapping.findForward("content"));
	}

	public ActionForward doCheckada(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ZjtywayinfoForm form = (ZjtywayinfoForm) actionForm;
		if (StringUtils.isNotEmpty(form.getAdacode())) {
			AdimareaDelegate delegate = new AdimareaDelegate();
			AdimareaVO vo = (AdimareaVO) delegate.doFindByPk(form.getAdacode(),
					user);
			if (vo == null) {
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
						"行政区划编码不存在");
				request.setAttribute("isExit", "1");
			}
		}
		if (AAUtils.isAjaxRequest(request)) {
			AAUtils.addZonesToRefresh(request, "showerror");
			AAUtils.addZonesToRefresh(request, "showbutton");
		}
		return (actionMapping.findForward("content"));
	}

}
