/**
 * auto-generated code
 * Thu Apr 05 10:00:59 CST 2007
 */
package com.sunrise.boss.ui.cms.adimarea;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.adimarea.persistent.AdimareaListVO;
import com.sunrise.boss.business.cms.adimarea.persistent.AdimareaVO;
import com.sunrise.boss.business.cms.citycompany.persistent.CitycompanyListVO;
import com.sunrise.boss.business.cms.cntycompany.persistent.CntycompanyListVO;
import com.sunrise.boss.business.cms.microarea.persistent.MicroareaListVO;
import com.sunrise.boss.business.cms.servcent.persistent.ServcentListVO;
import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.adimarea.AdimareaDelegate;
import com.sunrise.boss.delegate.cms.citycompany.CitycompanyDelegate;
import com.sunrise.boss.delegate.cms.cntycompany.CntycompanyDelegate;
import com.sunrise.boss.delegate.cms.microarea.MicroareaDelegate;
import com.sunrise.boss.delegate.cms.servcent.ServcentDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.cms.way.CountyComXmlBuilder;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>
 * Title: AdimareaAction
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
 * @author Ye Daoe
 * @version 1.0
 */
public class AdimareaAction extends BaseDelegateAction {
	private static Log log = LogFactory.getLog(AdimareaAction.class);

	public AdimareaAction() {
		// ���¼��������Ǳ����
		// ָ��VO��
		setVoClass(AdimareaVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[1];
		pkNameArray[0] = "adacode";
	}

	public void doAdaTreePage(HttpServletRequest request) throws Exception {
		User user = (User) request.getSession().getAttribute(
				WebConstant.SESSION_ATTRIBUTE_USER);
		String contextPath = request.getContextPath();
		String topChildrenURI = "selectAdaXml.jsp";
		String parentType = "adimarea";
		String rootName = null;
		String topAction = null;
		String topChildrenURL = null;
		String rootAdaId = null;
		AdimareaVO adimareaVO = null;
		StringBuffer topChildrenURLBuffer = new StringBuffer(100);
		WayDelegate delegate = new WayDelegate();
		WayVO wayvo = delegate.doFindByPk(user.getWayid(), user);
		rootAdaId = wayvo.getAdacode();
		if (StringUtils.isNotEmpty(rootAdaId)) {
			AdimareaDelegate delegate2 = new AdimareaDelegate();
			adimareaVO = delegate2.doFindByPk(rootAdaId, user);
		}

		rootName = adimareaVO == null ? "������������Ϣ" : "("
				+ adimareaVO.getAdacode() + ")" + adimareaVO.getAdaname();
		topChildrenURLBuffer.append(contextPath).append("/cms/adimarea/")
				.append(topChildrenURI).append("?parentid=").append(rootAdaId)
				.append("&parenttype=").append(parentType).append(
						"&function=selectAda&childrenURL=").append(contextPath)
				.append("/cms/adimarea/").append(topChildrenURI).append(
						"&times=").append(String.valueOf(new Date().getTime()));
		topAction = rootAdaId == null ? "" : "\"javascript:selectAda('"
				+ rootAdaId + "','" + rootName + "' , 'adimarea') \"";
		topChildrenURL = rootAdaId != null ? topChildrenURLBuffer.toString()
				: "";
		request.setAttribute("rootAdaId", rootAdaId);

		request.setAttribute("rootName", rootName);
		request.setAttribute("parentType", parentType);
		request.setAttribute("topChildrenURL", topChildrenURL);
		request.setAttribute("topAction", topAction);
	}

	/**
	 * ��������������
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doSelectadatree(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		String contextPath = request.getContextPath();
		String topChildrenURI = "selectAdaXml.jsp";
		String parentType = "adimarea";
		String rootName = null;
		String topAction = null;
		String topChildrenURL = null;
		String rootAdaId = null;
		AdimareaVO adimareaVO = null;
		StringBuffer topChildrenURLBuffer = new StringBuffer(100);
		AdimareaForm form = (AdimareaForm) actionForm;
		WayDelegate delegate = new WayDelegate();
		WayVO wayvo = delegate.doFindByPk(user.getWayid(), user);
		rootAdaId = wayvo.getAdacode();
		if(StringUtils.isEmpty(rootAdaId) && StringUtils.isNotEmpty(wayvo.getUpperwayid())){
			wayvo=delegate.doFindByPk(wayvo.getUpperwayid(), user);
			rootAdaId=wayvo==null?"":wayvo.getAdacode();
		}
		if (StringUtils.isNotEmpty(rootAdaId)) {
			AdimareaDelegate delegate2 = new AdimareaDelegate();
			adimareaVO = delegate2.doFindByPk(rootAdaId, user);
		}

		rootName = adimareaVO == null ? "������������Ϣ" : "("
				+ adimareaVO.getAdacode() + ")" + adimareaVO.getAdaname();
		topChildrenURLBuffer.append(contextPath).append("/cms/adimarea/")
				.append(topChildrenURI).append("?parentid=").append(rootAdaId)
				.append("&parenttype=").append(parentType).append(
						"&function=selectAda&childrenURL=").append(contextPath)
				.append("/cms/adimarea/").append(topChildrenURI).append(
						"&times=").append(String.valueOf(new Date().getTime()));
		topAction = rootAdaId == null ? "" : "\"javascript:selectAda('"
				+ rootAdaId + "','" + rootName + "' , 'adimarea') \"";
		topChildrenURL = rootAdaId != null ? topChildrenURLBuffer.toString()
				: "";
		request.setAttribute("rootAdaId", rootAdaId);

		request.setAttribute("rootName", rootName);
		request.setAttribute("parentType", parentType);
		request.setAttribute("topChildrenURL", topChildrenURL);
		request.setAttribute("topAction", topAction);
		return actionMapping.findForward("selectAdaTree");
	}

	/**
	 * ��ѯ
	 */
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			Page.setPageSize(request, (BaseActionForm) actionForm);
			AdimareaListVO listvo = new AdimareaListVO();
			setListVO(listvo, actionForm); // ���ú�listVO����Ϊ��ѯ����
			listvo.set_se_uppercode(request.getParameter("_se_uppercode"));
			AdimareaDelegate delegate = new AdimareaDelegate();
			DataPackage pack = delegate.doQueryByOprcode(listvo, user);
			pack.setPageSize(20);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		} catch (Exception e) {
			throw e;
		}
		return (actionMapping.findForward("list"));
	}

	/**
	 * ������ѡ��¼�����ݸ���״̬
	 */
	public ActionForward doChangestatus(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
		AdimareaVO vo = new AdimareaVO();
		AdimareaDelegate adimareadelegate = new AdimareaDelegate();
		for (int i = 0; i < selectArray.length; i++) {
			CommonDelegate delegate = new CommonDelegate(voClass);
			vo = (AdimareaVO) delegate.doFindByPk(getDeletePK(selectArray[i]),
					user);
			adimareadelegate.doChangeStatus(vo, user);
		}
		return doList(actionMapping, actionForm, request, response, user);
	}

	/**
	 * �Զ�����
	 */
	public ActionForward doAddup(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		AdimareaVO adimareavo = new AdimareaVO();
		BeanUtils.copyProperties(adimareavo, actionForm);
		AdimareaDelegate delegate = new AdimareaDelegate();
		String adacode = adimareavo.getAdacode();
		AdimareaListVO listvo = new AdimareaListVO();
		listvo.set_se_uppercode(adacode);
		adimareavo.setTotalppn(delegate.doAddupTotalppn(listvo, user));
		adimareavo.setResippn(delegate.doAddupResippn(listvo, user));
		adimareavo.setNonresippn(delegate.doAddupNonresippn(listvo, user));
		adimareavo.setAdarea(delegate.doAddupAdarea(listvo, user));
		adimareavo.setGmccusers(delegate.doAddupGmccusers(listvo, user));
		adimareavo.setCucusers(delegate.doAddupCucusers(listvo, user));
		adimareavo.setCtcusers(delegate.doAddupCtcusers(listvo, user));
		adimareavo.setHandphones(delegate.doAddupHandphones(listvo, user));
		BeanUtils.copyProperties(actionForm, adimareavo);

		// String command = getCommandString(request);
		((BaseActionForm) actionForm).setCmdState("EDIT");
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
				WebConstant.COMMAND_STRING_EDIT);
		return (actionMapping.findForward("content"));
	}

	/**
	 * ����,���û�����һ����¼ʱ,��Ҫ�ж�������¼�Ƿ������¼��������������ݷ�Χ��
	 */
	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		AdimareaVO adimareavo = new AdimareaVO();
		setSaveVO(adimareavo, actionForm); // �ڴ˸�ʽ������� vo �Ա���
		AdimareaDelegate delegate = new AdimareaDelegate();
		String cmdState = ((BaseActionForm) actionForm).getCmdState();
		AdimareaListVO params = new AdimareaListVO();
		String contentuppercode = adimareavo.getUppercode();
		String adacode = adimareavo.getAdacode();
		String orgcode = adimareavo.getOrgcode();
		try {
			if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {
				delegate.doUpdate(adimareavo, user);
				delegate.doChgAdacodeofOrg(orgcode, adacode, user);
			} else {
				if (delegate.judgeIfReasonable(params, contentuppercode, user)) {
					delegate.doCreate(adimareavo, user);
					delegate.doChgAdacodeofOrg(orgcode, adacode, user);
				} else {
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							"�ϼ������������벻�ܸ������ĵ�¼�������ڵ���������!");
					return (actionMapping.findForward("content"));
				}
			}
			BeanUtils.copyProperties(actionForm, adimareavo); // �Ѹ��º��ֵ����form������web��ʾ
			((BaseActionForm) actionForm)
					.setCmdState(WebConstant.COMMAND_STRING_EDIT);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.toString());
		} catch (Exception e) {
			throw e;
		}
		return (actionMapping.findForward("content"));
	}

	/**
	 * ɾ��,���û�ɾ��һ����¼ʱ,��Ҫ�ж�������¼�Ƿ������¼��������������ݷ�Χ��
	 */
	public ActionForward doDelete(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
		try {
			AdimareaDelegate delegate = new AdimareaDelegate();

			String findByPK = "doFindByPk";
			String methodName = "doRemove";

			for (int i = 0; i < selectArray.length; i++) {
				Object vo = null;
				vo = invokeDelegateMethod(delegate, findByPK, new Object[] {
						getDeletePK(selectArray[i]), user });
				AdimareaListVO params = new AdimareaListVO();
				String contentuppercode = ((AdimareaVO) vo).getUppercode();
				if (delegate.judgeIfReasonable(params, contentuppercode, user)) {
					Object ret = invokeDelegateMethod(delegate, methodName,
							new Object[] { vo, user });
				} else {
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							"��û��Ȩ��ɾ��������¼!");
					return (actionMapping.findForward("list"));
				}
			}
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.toString());
		} catch (Exception e) {
			throw e;
		}

		return doList(actionMapping, actionForm, request, response, user);
	}

	/**
	 * �½�
	 */
	public ActionForward doNew(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// �½�ʱ����form��Ĭ��ֵ
		setNewForm(actionForm, user);
		String command = getCommandString(request);
		((BaseActionForm) actionForm).setCmdState(command);
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
				WebConstant.COMMAND_STRING_EDIT);
		return (actionMapping.findForward("content"));
	}

	public void setNewForm(ActionForm actionForm, User user) throws Exception {
		AdimareaForm form = (AdimareaForm) actionForm;
		WayDelegate delegate = new WayDelegate();
		WayListVO listvo = new WayListVO();
		listvo.set_se_wayid(user.getWayid());
		DataPackage dp = delegate.doQuery(listvo, user);
		List list = (List) dp.getDatas();
		WayVO vo = (WayVO) list.get(0);
		form.setUppercode(vo.getAdacode());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		form.setDatayear(sdf.format(new Date()).substring(0, 4));// ȡʱ���ʽΪyyyy
	}

	protected ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean commonExportBean = new CommonExportBean(user);
		commonExportBean.setFileName("����������Ϣ����");
		commonExportBean.addOutputProperty("adacode", "�������");
		commonExportBean.addOutputProperty("adaname", "������������");
		commonExportBean.addOutputProperty("adatype", "������������",
				CommonExportBean.CODE2NAME, "$CH_ADATYPE");
		commonExportBean.addOutputProperty("adalevel", "������������",
				CommonExportBean.CODE2NAME, "$CH_ADALEVEL");
		commonExportBean.addOutputProperty("uppercode", "�ϼ�������������");
		commonExportBean.addOutputProperty("datayear", "����ͳ�����");
		commonExportBean.addOutputProperty("orgcode", "��֯����");
		commonExportBean.addOutputProperty("orgtype", "��֯����",
				CommonExportBean.CODE2NAME, "$CH_ORGTYPE");
		commonExportBean.addOutputProperty("status", "���ݸ���״̬",
				CommonExportBean.CODE2NAME, "$CH_DATASTATUS");
		commonExportBean.appendEndLine(new String[] { "��������:",
				user.getOpercode() });
		commonExportBean
				.appendEndLine(new String[] { "��������:", user.getWayid() });

		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT,
				commonExportBean);
		return super
				.doExcel(actionMapping, actionForm, request, response, user);
	}

	public ActionForward doChangeorgtype(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		AdimareaForm form = (AdimareaForm) actionForm;
		String orgcode = form.getOrgcode();
		CitycompanyListVO citylistvo = new CitycompanyListVO();
		citylistvo.set_se_citycompid(orgcode);
		CntycompanyListVO cntylistvo = new CntycompanyListVO();
		cntylistvo.set_se_countycompid(orgcode);
		ServcentListVO servlistvo = new ServcentListVO();
		servlistvo.set_se_svccode(orgcode);
		MicroareaListVO microlistvo = new MicroareaListVO();
		microlistvo.set_se_macode(orgcode);
		CitycompanyDelegate dele1 = new CitycompanyDelegate();
		CntycompanyDelegate dele2 = new CntycompanyDelegate();
		ServcentDelegate dele3 = new ServcentDelegate();
		MicroareaDelegate dele4 = new MicroareaDelegate();
		if (dele1.doQuery(citylistvo, user).getRowCount() > 0) {
			form.setOrgtype(new Short("0"));
		} else if (dele2.doQuery(cntylistvo, user).getRowCount() > 0) {
			form.setOrgtype(new Short("1"));
		}else if (dele3.doQuery(servlistvo, user).getRowCount()>0)
		{
			form.setOrgtype(new Short("2"));
		}else if (dele4.doQuery(microlistvo, user).getRowCount()>0)
		{
			form.setOrgtype(new Short("3"));
		}else 
			throw new BusinessException("Adimarea-111", "��֯���벻����!");

		return actionMapping.findForward("content");
	}
}
