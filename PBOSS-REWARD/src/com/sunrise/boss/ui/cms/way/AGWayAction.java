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
 * Description: 社会渠道专用Action
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
	 * 列表
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
				throw new BusinessException("", "登录的渠道不存在, 渠道编码:" + wayid);
			}
			/* 对当前操作是否是省公司一级操作作判断，以为页面个性化显示作准备 */

			// String userWayid = user.getWayid();
			// boolean isGDWay = delegate.isGMCCDirectWay(wayid, user);
			// if (isGDWay) { // 当前操作员为省公司操作员
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

			// 区分DIS、TRST、LOGIS
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
	 * 合作商&经销商删除
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
				// cooperatorvo.setState(new Short("0"));//修改状态为停用
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
	 * 合作商&经销商列表
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
				throw new BusinessException("", "登录的渠道不存在, 渠道编码:" + wayid);
			}

			/* 对当前操作是否是省公司一级操作作判断，以为页面个性化显示作准备 */

			// String userWayid = user.getWayid();
			// boolean isGDWay = delegate.isGMCCDirectWay(wayid, user);
			// if (isGDWay) { // 当前操作员为省公司操作员
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
			listVO.set_nne_waystate(new Short("-1"));// 不显示状态为-1的记录

			// 区分DIS、TRST、LOGIS
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

	/**
	 * 合作商&经销编辑
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
	 * 合作商&经销商新建
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
				throw new BusinessException("", "用户输入的[上级渠道]不存在");
			} else {
				wayForm.setCityid(wayVO.getCityid());
				wayForm.setCountyid(wayVO.getCountyid());
				wayForm.setSvccode(wayVO.getSvccode());
				wayForm.setMareacode(wayVO.getMareacode());
			}
			//默认新增为"有效" by wh
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
	 * 合作商&经销商保存
	 */
	public ActionForward doAgsave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		AGWayForm form = (AGWayForm) actionForm;
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
		cooperatorvo.setDistrictid(SessionFactoryRouter
				.conversionCityid2Num(form.getCityid()));

		wayaccountvo.setAccttype(new Short("0"));
		wayaccountvo.setChargetype(new Short("0"));

		BeanUtils.copyProperties(newVO, form);

		AGWayDelegate delegate = new AGWayDelegate();
		// 增加Delegate
		BchcontactDelegate bchcontactDelegate = new BchcontactDelegate();
		WayaccountDelegate wayaccountDelegate = new WayaccountDelegate();
		WaycompactDelegate waycompactDelegate = new WaycompactDelegate();
		CooperatorDelegate cooperatorDelegate = new CooperatorDelegate();

		try {
			newVO.setWaytype("AG");
			// newVO.setWaystate(new Short("1"));
			if (newVO.getWaysubtype() == null
					|| newVO.getWaysubtype().trim().equals("")) {
				throw new BusinessException("", "渠道子类别没有值！");
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

				// 上传
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
					// 不做处理
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
					// 不做处理
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
				// 修改

				delegate.doAgupdate(oldVO, newVO, cooperatorvo, waycompactvo,
						wayaccountvo, bchcontactvo, upperwayfalg, user);
				// }
				if (auditutils.doCheckPre("CH_PW_SOTYWAY_AUDIT", user)) {
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							"保存成功！");
				} else {
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							"保存成功：详细地址,送货地址,开户行,帐号,需要审核成功后才能生效！");
				}
			} else {
				if (oldVO == null) {
					// 新增
					delegate.doAgcreate(newVO, cooperatorvo, waycompactvo,
							wayaccountvo, bchcontactvo, user);
					// delegate.doCreate(newVO, user);
					if (auditutils.doCheckPre("CH_PW_SOTYWAY_AUDIT", user)) {
						request.setAttribute(
								WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功！");
					} else {
						request.setAttribute(
								WebConstant.PAGE_ATTRIBUTE_MESSAGE,
								"保存成功：详细地址,送货地址,开户行,帐号,需要审核成功后才能生效！");
					}
				} else {
					throw new BusinessException("", "已经存在相同渠道编码的记录,请更换渠道编码");
				}

			}

		} catch (BusinessException be) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存出错："
					+ be.getMessage());
			request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
					WebConstant.COMMAND_STRING_EDIT);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存出错："
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
	 * 新增
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
				throw new BusinessException("", "渠道子类别没有值！");
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
					throw new BusinessException("", "已经存在相同渠道编码的记录,请更换渠道编码");
				}
			}
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
		} catch (BusinessException be) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存出错："
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
		commonExportBean.setFileName("社会渠道列表");
		commonExportBean.addOutputProperty("wayid", "渠道编码");
		commonExportBean.addOutputProperty("wayname", "渠道名称");
		commonExportBean.addOutputProperty("upperwayid", "上级渠道",
				CommonExportBean.CODE2NAME, "#WAY");
		commonExportBean.addOutputProperty("cooperator", "合作方",
				CommonExportBean.CODE2NAME, "$CH_COOPERATOR");
		commonExportBean.addOutputProperty("cityid", "市公司",
				CommonExportBean.CODE2NAME, "#CITYCOMPANY");
		commonExportBean.addOutputProperty("countyid", "分公司",
				CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		commonExportBean.addOutputProperty("svccode", "服务销售中心",
				CommonExportBean.CODE2NAME, "#CH_SERVCENT");
		commonExportBean.addOutputProperty("mareacode", "微区域",
				CommonExportBean.CODE2NAME, "#CH_MICROAREA");
		commonExportBean.addOutputProperty("adtypecode", "区域类型",
				CommonExportBean.CODE2NAME, "$CH_ADTYPE");
		commonExportBean.addOutputProperty("adacode", "行政区划",
				CommonExportBean.CODE2NAME, "#CH_ADIMAREA");
		commonExportBean.appendEndLine(new String[] { "导出工号:",
				user.getOpercode() });
		commonExportBean
				.appendEndLine(new String[] { "导出渠道:", user.getWayid() });

		commonExportBean.voClassArray = new Class[] { voClass };
		commonExportBean.buildExcelPage(actionMapping, actionForm, request,
				response, user, this);

		return actionMapping.findForward(null);
	}

	/**
	 * 合作商&经销商导出
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
		commonExportBean.setFileName("连锁经营合作商管理");
		commonExportBean.addOutputProperty("wayid", "渠道编码");
		commonExportBean.addOutputProperty("wayname", "渠道名称");
		commonExportBean.addOutputProperty("upperwayid", "上级渠道",
				CommonExportBean.CODE2NAME, "#WAY");
		commonExportBean.addOutputProperty("waystate", "渠道状态",
				CommonExportBean.CODE2NAME, "$CH_VALIDFLAG");
		commonExportBean.addOutputProperty("cooperator", "合作方",
				CommonExportBean.CODE2NAME, "$CH_COOPERATOR");
		commonExportBean.addOutputProperty("cityid", "市公司",
				CommonExportBean.CODE2NAME, "#CITYCOMPANY");
		commonExportBean.addOutputProperty("countyid", "分公司",
				CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		commonExportBean.addOutputProperty("svccode", "服务销售中心",
				CommonExportBean.CODE2NAME, "#CH_SERVCENT");
		commonExportBean.addOutputProperty("mareacode", "微区域",
				CommonExportBean.CODE2NAME, "#CH_MICROAREA");
		commonExportBean.addOutputProperty("taxtype", "扣税方式",
				CommonExportBean.CODE2NAME, "$CH_STTAXTYPE");
		commonExportBean.addOutputProperty("mainlayer", "合作层级",
				CommonExportBean.CODE2NAME, "$CH_COPLAYER");
		commonExportBean.addOutputProperty("adtypecode", "区域类型",
				CommonExportBean.CODE2NAME, "$CH_ADTYPE");
		commonExportBean.addOutputProperty("adacode", "行政区划编码",
				CommonExportBean.CODE2NAME, "#CH_ADIMAREA");
		commonExportBean.appendEndLine(new String[] { "导出工号:",
				user.getOpercode() });
		commonExportBean
				.appendEndLine(new String[] { "导出渠道:", user.getWayid() });

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
	 * 根据物流商字段查询显示该物流商为其服务的所有渠道网点
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
	 * 根据合作商/经销商列表显示其下面的零售网点列表
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
				throw new Exception("下载失败！");
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
	 * 返回合作商经&销商上级渠道对应的组织结构信息
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
	 * 返回上级渠道对应的组织结构信息
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

	// 下拉框选择
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
