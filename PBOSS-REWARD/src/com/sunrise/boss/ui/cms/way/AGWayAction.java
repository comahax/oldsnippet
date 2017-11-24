package com.sunrise.boss.ui.cms.way;

import java.io.Serializable;
import java.lang.reflect.Method;

import javax.servlet.http.*;

import org.ajaxanywhere.AAUtils;
import org.apache.struts.action.*;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.bchcontact.persistent.BchcontactVO;
import com.sunrise.boss.business.cms.common.AuditUtils;
import com.sunrise.boss.business.cms.distribute.cooperator.persistent.CooperatorVO;
import com.sunrise.boss.business.cms.way.persistent.*;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountVO;
import com.sunrise.boss.business.cms.waycompact.persistent.WaycompactVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
//import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.*;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.bchcontact.BchcontactDelegate;
import com.sunrise.boss.delegate.cms.distribute.cooperator.CooperatorDelegate;
import com.sunrise.boss.delegate.cms.way.*;
import com.sunrise.boss.delegate.cms.wayaccount.WayaccountDelegate;
import com.sunrise.boss.delegate.cms.waycompact.WaycompactDelegate;
import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.ui.cms.commons.CMSConstant;
import com.sunrise.boss.ui.cms.commons.UploadFile;
import com.sunrise.boss.ui.cms.distribute.cooperator.CooperatorForm;
import com.sunrise.boss.ui.cms.waycompact.WaycompactForm;
import com.sunrise.boss.ui.commons.*;
import com.sunrise.boss.ui.commons.ftp.FtpAccess;
import com.sunrise.boss.ui.commons.ftp.FtpBusUtils;
import com.sunrise.boss.ui.commons.ftp.FtpInfo;

/**
 * AGWayAction <br>
 * Description: �������ר��Action
 * 
 * <br>
 * Company: Sunrise,Guangzhou</br>
 * 
 * @author yijianrong
 * @since 1.0
 * @version 1.0 2007-4-5
 */
public class AGWayAction extends BaseDelegateAction {

	public AGWayAction() {
		setVoClass(WayVO.class);
		this.pkNameArray = new String[1];
		pkNameArray[0] = "wayid";
	}

	/**
	 * �б�
	 */
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		try {
			String waysubtype = request.getParameter("WAYSUBTYPE");
			WayForm wayForm = (WayForm) actionForm;
			Page.setPageSize(request, wayForm);

			String wayid = user.getWayid();
			WayDelegate delegate = new WayDelegate();
			WayVO wayVO = delegate.doFindByPk(wayid, user);
			if (wayVO == null) {
				throw new BusinessException("", "��¼������������, ��������:" + wayid);
			}
			/* �Ե�ǰ�����Ƿ���ʡ��˾һ���������жϣ���Ϊҳ����Ի���ʾ��׼�� */

			// String userWayid = user.getWayid();
			// boolean isGDWay = delegate.isGMCCDirectWay(wayid, user);
			// if (isGDWay) { // ��ǰ����ԱΪʡ��˾����Ա
			// request.setAttribute("GDWAY", "GD");
			// }
			// else {
			// wayForm.set_se_cityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
			// request.setAttribute("GDWAY", "NOTGD");
			// request.setAttribute("CITYID",
			// SessionFactoryRouter.conversionCityid(user.getCityid()));
			// }
			WayListVO listVO = new WayListVO();
			BeanUtils.copyProperties(listVO, wayForm);

			// ����DIS��TRST��LOGIS
			if (listVO.get_se_waysubtype() == null
					|| listVO.get_se_waysubtype().trim().equals("")) {
				listVO.set_se_waysubtype(waysubtype);
			}

			DataPackage dp = delegate.doQueryByOprcode(listVO, user);
			String centerid = wayVO.getCenterid();
			request.setAttribute("centerid", centerid);

			// if (AAUtils.isAjaxRequest(request)) {
			// AAUtils.addZonesToRefresh(request, "zoneCountycompany");
			// AAUtils.addZonesToRefresh(request, "svccode");
			// AAUtils.addZonesToRefresh(request, "mareacode");
			// }

			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		} catch (Exception e) {
			throw e;
		}
		return (actionMapping.findForward("list"));
	}

	/**
	 * ������&������ɾ��
	 */
	public ActionForward doAgdelete(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
		try {
			AGWayDelegate delegate = new AGWayDelegate();
			// CooperatorDelegate cooperatordelegate = new CooperatorDelegate();
			// CooperatorVO cooperatorvo = null;
			WayVO vo = null;
			for (int i = 0; i < selectArray.length; i++) {

				// cooperatorvo =
				// cooperatordelegate.doFindByPk(getAgdeletePK(selectArray[i],CooperatorVO.class),
				// user);
				vo = delegate.doFindByPk(getDeletePK(selectArray[i]), user);

				// if(cooperatorvo != null){
				// cooperatorvo.setState(new Short("0"));//�޸�״̬Ϊͣ��
				// cooperatordelegate.doUpdate(cooperatorvo, user);
				// }
				// vo.setWaystate(new Short("-1"));
				delegate.doDelete(vo, user);
			}
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.toString());
		} catch (Exception e) {
			throw e;
		}

		return doAglist(actionMapping, actionForm, request, response, user);
	}

	/**
	 * ������&�������б�
	 */
	public ActionForward doAglist(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		try {
			String waysubtype = request.getParameter("WAYSUBTYPE");
			AGWayForm wayForm = (AGWayForm) actionForm;
			Page.setPageSize(request, wayForm);

			String wayid = user.getWayid();
			WayDelegate delegate = new WayDelegate();
			WayVO wayVO = delegate.doFindByPk(wayid, user);
			if (wayVO == null) {
				throw new BusinessException("", "��¼������������, ��������:" + wayid);
			}

			/* �Ե�ǰ�����Ƿ���ʡ��˾һ���������жϣ���Ϊҳ����Ի���ʾ��׼�� */

			// String userWayid = user.getWayid();
			// boolean isGDWay = delegate.isGMCCDirectWay(wayid, user);
			// if (isGDWay) { // ��ǰ����ԱΪʡ��˾����Ա
			// request.setAttribute("GDWAY", "GD");
			// }
			// else {
			// wayForm.set_se_cityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
			// request.setAttribute("GDWAY", "NOTGD");
			// request.setAttribute("CITYID",
			// SessionFactoryRouter.conversionCityid(user.getCityid()));
			// }
			WayListVO listVO = new WayListVO();
			BeanUtils.copyProperties(listVO, wayForm);
			listVO.set_nne_waystate(new Short("-1"));// ����ʾ״̬Ϊ-1�ļ�¼

			// ����DIS��TRST��LOGIS
			if (listVO.get_se_waysubtype() == null
					|| listVO.get_se_waysubtype().trim().equals("")) {
				listVO.set_se_waysubtype(waysubtype);
			}

			DataPackage dp = delegate.doQueryByOprcode(listVO, user);
			String centerid = wayVO.getCenterid();
			request.setAttribute("centerid", centerid);

			// if (AAUtils.isAjaxRequest(request)) {
			// AAUtils.addZonesToRefresh(request, "zoneCountycompany");
			// AAUtils.addZonesToRefresh(request, "svccode");
			// AAUtils.addZonesToRefresh(request, "mareacode");
			// }

			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		} catch (Exception e) {
			throw e;
		}
		return (actionMapping.findForward("list"));
	}

	/**
	 * �õ���Ӧ��ĵ�����
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
			throw new Exception("�������������");
		}
	}

	/**
	 * �õ���Ӧ���˫����
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

	/**
	 * ������&�����༭
	 */
	public ActionForward doAgedit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		String pk = request.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);

		WayDelegate delegate = new WayDelegate();
		BchcontactDelegate bchcontactDelegate = new BchcontactDelegate();
		WayaccountDelegate wayaccountDelegate = new WayaccountDelegate();
		WaycompactDelegate waycompactDelegate = new WaycompactDelegate();
		CooperatorDelegate cooperatorDelegate = new CooperatorDelegate();

		WayVO wayvo = delegate.doFindByPk(getDeletePK(pk), user);
		BchcontactVO bchcontactvo = bchcontactDelegate.doFindByPk(
				getAgdeletePK(pk, BchcontactVO.class), user);
		WayaccountVO wayaccountvo = wayaccountDelegate.doFindByPk(
				getAgdeletePkVO(1 + "|" + pk, WayaccountVO.class), user);
		CooperatorVO cooperatorvo = cooperatorDelegate.doFindByPk(pk, user);
		WaycompactVO waycompactvo = waycompactDelegate.doFindByPk(
				getAgdeletePK(pk, WaycompactVO.class), user);

		AuditUtils utils = new AuditUtils();
		String[] waypk = { "wayid" };
		String[] cooperaupk = { "cooperauid" };
		String[] wayaccountpk = { "accid", "wayid" };

		wayvo = (WayVO) utils.doGetAuditvalue(wayvo, "CH_PW_WAY",
				"CH_PW_STRBWAY", waypk, user);
		if (cooperatorvo != null) {
			cooperatorvo = (CooperatorVO) utils.doGetAuditvalue(cooperatorvo,
					"CH_DST_COOPERATOR", "CH_PW_STRBWAY", cooperaupk, user);
			BeanUtils.copyProperties(((AGWayForm) actionForm), cooperatorvo);
		}
		if (wayaccountvo != null) {
			wayaccountvo = (WayaccountVO) utils.doGetAuditvalue(wayaccountvo,
					"CH_PW_WAYACCOUNT", "CH_PW_STRBWAY", wayaccountpk, user);
			BeanUtils.copyProperties(((AGWayForm) actionForm), wayaccountvo);
		}

		BeanUtils.copyProperties(((AGWayForm) actionForm), wayvo);
		if (bchcontactvo != null) {
			BeanUtils.copyProperties(((AGWayForm) actionForm), bchcontactvo);
		}
		if (waycompactvo != null) {
			BeanUtils.copyProperties(((AGWayForm) actionForm), waycompactvo);
			((AGWayForm) actionForm).setCmpendtime(waycompactvo.getEndtime());
		}

		// getContentVO(request, user, actionForm);

		String command = getCommandString(request);
		((AGWayForm) actionForm).setCmdState(command);
		((AGWayForm) actionForm).set_se_upperwayid(((AGWayForm) actionForm)
				.getUpperwayid());
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, "AGEDIT");
		return (actionMapping.findForward("content"));
	}

	/**
	 * ������&�������½�
	 */
	public ActionForward doAgnew(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		AGWayForm wayForm = (AGWayForm) actionForm;
		try {

			String upperwayid = wayForm.get_se_upperwayid() == null ? ""
					: wayForm.get_se_upperwayid();
			WayDelegate delegate = new WayDelegate();
			WayVO wayVO = delegate.doFindByPk(upperwayid, user);
			if (wayVO == null) {
				throw new BusinessException("", "�û������[�ϼ�����]������");
			} else {
				wayForm.setCityid(wayVO.getCityid());
				wayForm.setCountyid(wayVO.getCountyid());
				wayForm.setSvccode(wayVO.getSvccode());
				wayForm.setMareacode(wayVO.getMareacode());
			}
			//Ĭ������Ϊ"��Ч" by wh
			wayForm.setWaystate(new Short("1"));
			String centerid = wayVO.getCenterid();
			request.setAttribute("centerid", centerid);

		} catch (Exception ex) {
			ex.printStackTrace();
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex
					.getMessage());
			return actionMapping.findForward("list");
		}
		return super.doNew(actionMapping, wayForm, request, response, user);
	}

	/**
	 * ������&�����̱���
	 */
	public ActionForward doAgsave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		AGWayForm form = (AGWayForm) actionForm;
		boolean upperwayfalg = false;// �����жϱ������Ƿ�����ϼ�����

		WayVO newVO = new WayVO();
		// ����vo
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
		cooperatorvo.setDistrictid(SessionFactoryRouter
				.conversionCityid2Num(form.getCityid()));

		wayaccountvo.setAccttype(new Short("0"));
		wayaccountvo.setChargetype(new Short("0"));

		BeanUtils.copyProperties(newVO, form);

		AGWayDelegate delegate = new AGWayDelegate();
		// ����Delegate
		BchcontactDelegate bchcontactDelegate = new BchcontactDelegate();
		WayaccountDelegate wayaccountDelegate = new WayaccountDelegate();
		WaycompactDelegate waycompactDelegate = new WaycompactDelegate();
		CooperatorDelegate cooperatorDelegate = new CooperatorDelegate();

		try {
			newVO.setWaytype("AG");
			// newVO.setWaystate(new Short("1"));
			if (newVO.getWaysubtype() == null
					|| newVO.getWaysubtype().trim().equals("")) {
				throw new BusinessException("", "���������û��ֵ��");
			}

			WayaccountVO wayaccountpkvo = new WayaccountVO();
			wayaccountpkvo.setAccid(new Integer(1));
			wayaccountpkvo.setWayid(form.getWayid());

			WayVO oldVO = delegate.doFindByPk(form.getWayid(), user);
			// BchcontactVO oldbchcontactvo
			// =bchcontactDelegate.doFindByPk(form.getWayid(), user);
			// WayaccountVO oldwayaccountvo
			// =wayaccountDelegate.doFindByPk(wayaccountpkvo, user);
			// CooperatorVO oldcooperatorvo
			// =cooperatorDelegate.doFindByPk(form.getWayid(), user);
			// WaycompactVO oldwaycompactvo
			// =waycompactDelegate.doFindByPk(form.getWayid(), user);
			//			
			if (waycompactvo != null) {

				// �ϴ�
				FormFile compactfile = form.getCompactfile();
				try {
					if (compactfile != null
							&& compactfile.getFileName() != null
							&& compactfile.getFileSize() > 0) {
						String uploadpath = servlet.getServletContext()
								.getRealPath("/")
								+ CMSConstant.COMPACT_UPLOADPATH;
						if (UploadFile.doUpLoadFile(uploadpath, compactfile,
								request)) {
							form.setCompactpath(uploadpath
									+ compactfile.getFileName());
						}
					}
				} catch (Exception ex) {
					// ��������
				}

				FormFile licencefile = form.getLicencefile();
				try {
					if (licencefile != null
							&& licencefile.getFileName() != null
							&& licencefile.getFileSize() > 0) {
						String uploadpath = servlet.getServletContext()
								.getRealPath("/")
								+ CMSConstant.COMPACT_UPLOADPATH;
						if (UploadFile.doUpLoadFile(uploadpath, licencefile,
								request)) {
							form.setLicencepath(uploadpath
									+ licencefile.getFileName());
						}
					}
				} catch (Exception ex) {
					// ��������
				}
			}
			AuditUtils auditutils = new AuditUtils();
			if (oldVO != null) {
				if (!oldVO.getUpperwayid().equalsIgnoreCase(
						newVO.getUpperwayid())) {
					upperwayfalg = true;
					// delegate.doEdit(oldVO, newVO, user);
				} // else {
				// delegate.doUpdate(newVO, user);
				// }
				// if(oldbchcontactvo!=null && oldwayaccountvo!=null &&
				// oldwaycompactvo!=null && oldcooperatorvo!=null){
				// �޸�

				delegate.doAgupdate(oldVO, newVO, cooperatorvo, waycompactvo,
						wayaccountvo, bchcontactvo, upperwayfalg, user);
				// }
				if (auditutils.doCheckPre("CH_PW_SOTYWAY_AUDIT", user)) {
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							"����ɹ���");
				} else {
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							"����ɹ�����ϸ��ַ,�ͻ���ַ,������,�ʺ�,��Ҫ��˳ɹ��������Ч��");
				}
			} else {
				if (oldVO == null) {
					// ����
					delegate.doAgcreate(newVO, cooperatorvo, waycompactvo,
							wayaccountvo, bchcontactvo, user);
					// delegate.doCreate(newVO, user);
					if (auditutils.doCheckPre("CH_PW_SOTYWAY_AUDIT", user)) {
						request.setAttribute(
								WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ���");
					} else {
						request.setAttribute(
								WebConstant.PAGE_ATTRIBUTE_MESSAGE,
								"����ɹ�����ϸ��ַ,�ͻ���ַ,������,�ʺ�,��Ҫ��˳ɹ��������Ч��");
					}
				} else {
					throw new BusinessException("", "�Ѿ�������ͬ��������ļ�¼,�������������");
				}

			}

		} catch (BusinessException be) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "�������"
					+ be.getMessage());
			request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
					WebConstant.COMMAND_STRING_EDIT);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "�������"
					+ e.getMessage());
			request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
					WebConstant.COMMAND_STRING_EDIT);
			e.printStackTrace();
		}
		return actionMapping.findForward("content");
	}

	public ActionForward doNew(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		WayForm wayForm = (WayForm) actionForm;

		String wayid = user.getWayid();
		WayDelegate delegate = new WayDelegate();
		WayVO wayVO = delegate.doFindByPk(wayid, user);
		String centerid = wayVO.getCenterid();
		request.setAttribute("centerid", centerid);

		// if (AAUtils.isAjaxRequest(request)) {
		// AAUtils.addZonesToRefresh(request, "zoneCountycompany");
		// AAUtils.addZonesToRefresh(request, "svccode");
		// AAUtils.addZonesToRefresh(request, "mareacode");
		// }
		return super.doNew(actionMapping, wayForm, request, response, user);
	}

	/**
	 * ����
	 */
	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		WayForm form = (WayForm) actionForm;
		WayVO newVO = new WayVO();
		BeanUtils.copyProperties(newVO, form);
		WayDelegate delegate = new WayDelegate();

		try {
			newVO.setWaytype("AG");
			// newVO.setWaystate(new Short("1"));
			if (newVO.getWaysubtype() == null
					|| newVO.getWaysubtype().trim().equals("")) {
				throw new BusinessException("", "���������û��ֵ��");
			}

			WayVO oldVO = delegate.doFindByPk(form.getWayid(), user);
			if (WebConstant.COMMAND_STRING_EDIT.equalsIgnoreCase(form
					.getCmdState())) {
				if (!oldVO.getUpperwayid().equalsIgnoreCase(
						newVO.getUpperwayid())) {
					delegate.doEdit(oldVO, newVO, user);
				} else {
					delegate.doUpdate(newVO, user);
				}
			} else {
				if (oldVO == null) {
					delegate.doCreate(newVO, user);
				} else {
					throw new BusinessException("", "�Ѿ�������ͬ��������ļ�¼,�������������");
				}
			}
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
		} catch (BusinessException be) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "�������"
					+ be.getMessage());
		} catch (Exception e) {
			throw e;
		}
		return actionMapping.findForward("content");
	}

	public ActionForward doExport(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		CommonExportBean commonExportBean = new CommonExportBean(user);
		commonExportBean.setFileName("��������б�");
		commonExportBean.addOutputProperty("wayid", "��������");
		commonExportBean.addOutputProperty("wayname", "��������");
		commonExportBean.addOutputProperty("upperwayid", "�ϼ�����",
				CommonExportBean.CODE2NAME, "#WAY");
		commonExportBean.addOutputProperty("cooperator", "������",
				CommonExportBean.CODE2NAME, "$CH_COOPERATOR");
		commonExportBean.addOutputProperty("cityid", "�й�˾",
				CommonExportBean.CODE2NAME, "#CITYCOMPANY");
		commonExportBean.addOutputProperty("countyid", "�ֹ�˾",
				CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		commonExportBean.addOutputProperty("svccode", "������������",
				CommonExportBean.CODE2NAME, "#CH_SERVCENT");
		commonExportBean.addOutputProperty("mareacode", "΢����",
				CommonExportBean.CODE2NAME, "#CH_MICROAREA");
		commonExportBean.addOutputProperty("adtypecode", "��������",
				CommonExportBean.CODE2NAME, "$CH_ADTYPE");
		commonExportBean.addOutputProperty("adacode", "��������",
				CommonExportBean.CODE2NAME, "#CH_ADIMAREA");
		commonExportBean.appendEndLine(new String[] { "��������:",
				user.getOpercode() });
		commonExportBean
				.appendEndLine(new String[] { "��������:", user.getWayid() });

		commonExportBean.voClassArray = new Class[] { voClass };
		commonExportBean.buildExcelPage(actionMapping, actionForm, request,
				response, user, this);

		return actionMapping.findForward(null);
	}

	/**
	 * ������&�����̵���
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doAgexport(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		CommonExportBean commonExportBean = new CommonExportBean(user);
		commonExportBean.setFileName("������Ӫ�����̹���");
		commonExportBean.addOutputProperty("wayid", "��������");
		commonExportBean.addOutputProperty("wayname", "��������");
		commonExportBean.addOutputProperty("upperwayid", "�ϼ�����",
				CommonExportBean.CODE2NAME, "#WAY");
		commonExportBean.addOutputProperty("waystate", "����״̬",
				CommonExportBean.CODE2NAME, "$CH_VALIDFLAG");
		commonExportBean.addOutputProperty("cooperator", "������",
				CommonExportBean.CODE2NAME, "$CH_COOPERATOR");
		commonExportBean.addOutputProperty("cityid", "�й�˾",
				CommonExportBean.CODE2NAME, "#CITYCOMPANY");
		commonExportBean.addOutputProperty("countyid", "�ֹ�˾",
				CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		commonExportBean.addOutputProperty("svccode", "������������",
				CommonExportBean.CODE2NAME, "#CH_SERVCENT");
		commonExportBean.addOutputProperty("mareacode", "΢����",
				CommonExportBean.CODE2NAME, "#CH_MICROAREA");
		commonExportBean.addOutputProperty("taxtype", "��˰��ʽ",
				CommonExportBean.CODE2NAME, "$CH_STTAXTYPE");
		commonExportBean.addOutputProperty("mainlayer", "�����㼶",
				CommonExportBean.CODE2NAME, "$CH_COPLAYER");
		commonExportBean.addOutputProperty("adtypecode", "��������",
				CommonExportBean.CODE2NAME, "$CH_ADTYPE");
		commonExportBean.addOutputProperty("adacode", "������������",
				CommonExportBean.CODE2NAME, "#CH_ADIMAREA");
		commonExportBean.appendEndLine(new String[] { "��������:",
				user.getOpercode() });
		commonExportBean
				.appendEndLine(new String[] { "��������:", user.getWayid() });

		commonExportBean.voClassArray = new Class[] { voClass };

		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT,
				commonExportBean);

		commonExportBean.queryMethodName = "doAglist";
		if (commonExportBean.headtitle == null) {
			commonExportBean.headtitle = commonExportBean.getFileName();
		}
		commonExportBean.buildExcelPage(actionMapping, actionForm, request,
				response, user, this);
		return actionMapping.findForward(null);

	}

	/**
	 * �����������ֶβ�ѯ��ʾ��������Ϊ������������������
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doListsendway(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			WayForm wayForm = (WayForm) actionForm;
			String wayid = request.getParameter("wayid");
			WayDelegate delegate = new WayDelegate();

			if (wayid != null && !wayid.trim().equals("")) {
				WayListVO listVO = new WayListVO();
				BeanUtils.copyProperties(listVO, wayForm);
				listVO.set_se_logiscode(wayid);
				DataPackage dp = delegate.doQuery(listVO, user);
				request.setAttribute("pk", wayid);
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
			}

		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		} catch (Exception e) {
			throw e;
		}
		return (actionMapping.findForward("sendlist"));
	}

	/**
	 * ���ݺ�����/�������б���ʾ����������������б�
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doListsaleway(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			WayForm wayForm = (WayForm) actionForm;
			String wayid = request.getParameter("wayid");
			WayDelegate delegate = new WayDelegate();

			if (wayid != null && !wayid.trim().equals("")) {
				WayListVO listVO = new WayListVO();
				BeanUtils.copyProperties(listVO, wayForm);
				listVO.set_se_upperwayid(wayid);
				DataPackage dp = delegate.doQuerysaleway(listVO, user);
				request.setAttribute("pk", wayid);
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
			}
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		} catch (Exception e) {
			throw e;
		}
		return (actionMapping.findForward("salelist"));
	}

	public ActionForward doDownload(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			String url = request.getParameter("file");
			FtpAccess ftpAccess = new FtpAccess(FtpInfo.getInstance());
			String localPath = FtpBusUtils.getDownloadRealPath(servlet);
			String file = ftpAccess.downloadFile(localPath, url);
			if (file == null) {
				throw new Exception("����ʧ�ܣ�");
			}
			request.setAttribute("filename", FtpBusUtils.getDownloadFilename(
					servlet, url));
		} catch (Exception ex) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex
					.getCause());
		}
		return actionMapping.findForward("download");
	}

	/**
	 * ���غ����̾�&�����ϼ�������Ӧ����֯�ṹ��Ϣ
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doAgupway(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		AGWayForm form = (AGWayForm) actionForm;
		WayDelegate delegate = new WayDelegate();
		WayVO wayVO = delegate.doFindByPk(form.getUpperwayid(), user);
		form.setCityid(wayVO.getCityid());
		form.setCountyid(wayVO.getCountyid());
		form.setSvccode(wayVO.getSvccode());
		form.setMareacode(wayVO.getMareacode());
		if (AAUtils.isAjaxRequest(request)) {
			AAUtils.addZonesToRefresh(request, "zoneCitycompany");
			AAUtils.addZonesToRefresh(request, "zoneCountycompany");
			AAUtils.addZonesToRefresh(request, "svccode");
			AAUtils.addZonesToRefresh(request, "mareacode");
		}
		return (actionMapping.findForward("content"));
	}

	/**
	 * �����ϼ�������Ӧ����֯�ṹ��Ϣ
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doGetsthwithway(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		WayForm form = (WayForm) actionForm;
		WayDelegate delegate = new WayDelegate();
		WayVO wayVO = delegate.doFindByPk(form.getUpperwayid(), user);
		form.setCityid(wayVO.getCityid());
		form.setCountyid(wayVO.getCountyid());
		form.setSvccode(wayVO.getSvccode());
		form.setMareacode(wayVO.getMareacode());
		if (AAUtils.isAjaxRequest(request)) {
			AAUtils.addZonesToRefresh(request, "zoneCitycompany");
			AAUtils.addZonesToRefresh(request, "zoneCountycompany");
			AAUtils.addZonesToRefresh(request, "svccode");
			AAUtils.addZonesToRefresh(request, "mareacode");
		}
		return (actionMapping.findForward("content"));
	}

	// ������ѡ��
	/**
	 * 
	 */
	public ActionForward doGetcountid(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		AGWayForm form = (AGWayForm) actionForm;
		form.setCmdState(request.getParameter("cmdstates"));
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

}
