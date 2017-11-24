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
 * �Խ���Ӫ����������Ϣ����
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
	 * ����
	 */
	protected ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�Խ���Ӫ����������Ϣ");
		export.addOutputProperty("wayid", "��������");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("upperwayid", "�ϼ�����");

		export.addOutputProperty("svbrchcode", "���������");
		export.addOutputProperty("bchlevel", "����������");
		export.addOutputProperty("waytype", "�������");
		export.addOutputProperty("waysubtype", "������");
		export.addOutputProperty("cityid", "���й�˾");
		export.addOutputProperty("countyid", "�ֹ�˾");
		export.addOutputProperty("svccode", "������������");
		export.addOutputProperty("mareacode", "΢����");
		export.addOutputProperty("starlevel", "�Ǽ�");

		export.addOutputProperty("buztypecode", "��Ȧ����");
		export.addOutputProperty("adtypecode", "��������");
		export.addOutputProperty("buzphoneno", "��ϵ�绰");
		export.addOutputProperty("adacode", "��������");
		// "��ϸ��ַ","����γ��","������","��Ӫģʽ","�Ƿ�����","������ʽ","��ҵ��Դ����","�Ƿ���������","�����̱���"
		export.addOutputProperty("address", "��ϸ��ַ");
		export.addOutputProperty("latitude", "����γ��");
		export.addOutputProperty("longtitude", "������");
		export.addOutputProperty("runmode", "��Ӫģʽ");
		export.addOutputProperty("isconnected", "�Ƿ�����");
		export.addOutputProperty("connecttype", "������ʽ");
		export.addOutputProperty("prtsource", "��ҵ��Դ����");
		export.addOutputProperty("iscoreway", "�Ƿ���������");
		export.addOutputProperty("chainhead", "�����̱���");
		export.addOutputProperty("isshare", "�Ƿ���");
		// String endLine[] = { "(ע:��д���뽫����ת��Ϊtxt��ʽ,ȥ��������,���ϴ�����)",
		// "ʱ���ʽΪ:YYYY-MM-DD(��:2007-04-18)",
		// "���������:0:������������;1,����������;2,������ͨ������;3,����ͨ������;4,���������",
		// "MZ1,���еش�Ʒ�Ƶ�;MZ2,���еش�У԰��;PVIP,�׵ǻ������;CVIP,�׵ǳ������;",
		// "�Ƿ�����:0,����;1,������;�Ƿ���������:0,��;1,��","����������:1,A��;2,B��;3,C��;99,����;�����ͱ���:ET,ʵ������;"
		// };
		export.appendEndLine(new String[] { "��������:", user.getOpercode(),"����ʱ��",
				format.format(new Date())});
		export.appendEndBody("(ע:��д���뽫����ת��Ϊtxt��ʽ,ȥ��������,���ϴ�����)" + "<br>"
				+ "ʱ���ʽΪ:YYYY-MM-DD(��:2007-04-18)" + "<br>"
				+ "���������:0:������������;1,����������;2,������ͨ������;3,����ͨ������;4,���������" + "<br>"
				+ "����������:1,A��;2,B��;3,C��;99,����;����������:ET,ʵ������;" + "<br>"
				+ "�Ǽ�:0,δ���Ǽ�;1,һ�Ǽ�;2,���Ǽ�;3,���Ǽ�;4,���Ǽ�;5,���Ǽ�;6,���Ǽ�" + "<br>"
				+ "��Ȧ����:0,��ҵ��;1,������;2,��ͨ��Ŧ;3,סլ����;4,ѧУ����;5,����;6,����;7,����;99,����"
				+ "<br>" + "��������:0,����;1,����;2,һ������;3,��������;4,��������;99,����" + "<br>"
				+ "��Ӫģʽ:0,�Խ���Ӫ;1,�Խ���Ӫ;2,������Ӫ;" + "<br>"
				+ "������ʽ:0,����;1,2M����;2,GPRS;3,CSD;4,��������;5,��������" + "<br>"
				+ "��ҵ��Դ:0,����;1,������ҵ����;2,���й�˾����;3,�����ҵ��������;" + "<br>"
				+ "���������:GMPT,�ƶ���˾����/����;G100,��ͨ100������;D100,����100��Ϣ�������;"+"<br>"
				+ "MZ1,���еش�Ʒ�Ƶ�;MZ2,���еش�У԰��;PVIP,�׵ǻ������;CVIP,�׵ǳ������;" + "<br>"
				+ "�Ƿ�����:0,����;1,������;�Ƿ���������:0,��;1,��;�Ƿ���:0,��;1,��" + "<br>");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super
				.doExcel(actionMapping, actionForm, request, response, user);
	}

	/**
	 * �û��޸��ϼ�����
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
					"�ϼ�����״̬��������Ч��.");
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

	// ������ѡ��
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
	 * �Խ���Ӫ������Ϣ
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
			form.setMareacode(StringUtils.equals("��ѡ��", form.getMareacode()) ? "" : form.getMareacode());
			form.setSvccode(StringUtils.equals("��ѡ��", form.getSvccode()) ? ""
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
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�!");
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
					"������������Ϣ�Ѵ���");
			request.setAttribute("isExit", "1");
		}
		if (!AuditUtils.doCheckWayidStyle(form.getWayid())
				&& StringUtils.isNotEmpty(form.getWayid())) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"���������ʽ����ȷ,ֻ������ĸ+���ֻ���'-'");
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
						"�����������벻����");
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
