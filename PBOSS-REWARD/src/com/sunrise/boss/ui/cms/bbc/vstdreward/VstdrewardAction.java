package com.sunrise.boss.ui.cms.bbc.vstdreward;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ajaxanywhere.AAUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.bbc.operation.persistent.BBCoperationVO;
import com.sunrise.boss.business.cms.bbc.stdrewardbj.persistent.BBCstdrewardbjVO;
import com.sunrise.boss.business.cms.bbc.vstdreward.persistent.VstdrewardListVO;
import com.sunrise.boss.business.cms.bbc.vstdreward.persistent.VstdrewardVO;
import com.sunrise.boss.business.cms.provincialright.persistent.ProvincialrightListVO;
import com.sunrise.boss.business.cms.provincialright.persistent.ProvincialrightVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.admin.acl.ACLDelegate;
import com.sunrise.boss.delegate.cms.bbc.operation.BBCoperationDelegate;
import com.sunrise.boss.delegate.cms.bbc.stdrewardbj.BBCstdrewardbjDelegate;
import com.sunrise.boss.delegate.cms.bbc.vstdreward.VstdrewardDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.cms.commons.TimeUtil;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>
 * Title: vstdrewardAction
 * </p>
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
public class VstdrewardAction extends BaseAction {
	// ʡ��Ȩ������
	private static final String PROVINCE_PURVIEW_A = "CH_B2M_REWARD_PROVINCIAL";

	// �м�Ȩ������
	private static final String PROVINCE_PURVIEW_B = "CH_B2M_REWARD_CIVIC";

	// ҵ�����
	public final static String BUSIBELONG = "BUSIBELONG";

	public final static String SELL_BUSIBELONG = "SELL"; // ����ҵ�����

	public final static String SELL_DATA_BUSIBELONG = "SELL_DATA";// ����ҵ��������

	public final static String SELL_SERVICE_BUSIBELONG = "SELL_SERVICE";// ����ҵ�������

	public final static String DATABUSI_BUSIBELONG = "DATABUSI"; // ����������

	public final static String CZ_BUSIBELONG = "CZ"; // ��ֵ������

	public final static String QUER_BUSIBELONG = "QUER"; // ��ѯ��

	public final static String ACTV_BUSIBELONG = "ACTV"; // ��Ծ��

	public final static String ACTV_NEW_BUSIBELONG = "ACTV_NEW";// ������վ��Ծ��

	public final static String ACTV_E100_BUSIBELONG = "ACTV_E100";// e100��Ծ��

	public final static String DEFAULT_ACCTYPE = "1"; // �Ƴ귽ʽ Ĭ�ϰ���������

	public final static String SCALE_ACCTYPE = "2"; // �Ƴ귽ʽ ����������

	public final static String PROVINCE_REGION = "999"; // ʡ����
	
	// �����ʶ 999-ʡ��˾ 000-�й�˾
	public static String REGION_PRO = "999";
	public static String REGION_CIV = "000";
	public static String RIGHT;
	public static String RIGHT_CITY;

	public VstdrewardAction() throws Exception {
		setVoClass(VstdrewardVO.class);
		// TODO: ������������������
		this.pkNameArray = new String[3];
		pkNameArray[0] = "rewardid";
		pkNameArray[1] = "region";
		pkNameArray[2] = "ossrc";
		delegate = new CommonDelegate(ProvincialrightVO.class);
	}

	private String purview = "";

	private CommonDelegate delegate;
	
	/**
	 * ����һ��tabҳ��
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	
	public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
//		String select = (String) request.getParameter("select");
		String pk = (String) request
				.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
//		request.setAttribute("select", select);
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_PK, pk);
		
//		getPurview(user);
//		if ("A".equals(this.purview)) {
////			request.setAttribute(RIGHT, "A");
//			request.setAttribute("RIGHT", "A");
//		} else if ("B".equals(this.purview)) {
////			request.setAttribute(RIGHT, "B");
//			request.setAttribute("RIGHT", "B");
//		}
		return actionMapping.findForward("frame");
	}

	/**
	 * ��ѯ
	 */
	public ActionForward doList(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		Page.setPageSize(request, (BaseActionForm) actionForm);
		VstdrewardListVO listVO = new VstdrewardListVO();
		BaseActionForm baseForm = (BaseActionForm) actionForm;
		// BeanUtils.copyProperties(listVO, actionForm);
		// ���ú�listVO����OrdinaryΪ��ѯ����
		VstdrewardForm form = (VstdrewardForm) actionForm;
		// if (form.get_ne_region() == null) {
		// form.set_ne_region("");
		// }
		BeanUtils.copyProperties(listVO, form);
		VstdrewardDelegate delegate = new VstdrewardDelegate();
		DataPackage dp =null;
		getPurview(user);
		if ("A".equals(this.purview)) {
			dp=delegate.doQueryDesc(listVO, user);
		} else{
			dp=delegate.doQuery(listVO, user);
		}
		
		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		return (actionMapping.findForward("list"));
	}

	/**
	 * �༭
	 */
	public ActionForward doEdit(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		/*
		 * ���ݿ�ȡ������ֵ���ŵ�actionform��ȥ��
		 */
		getContentVO(request, user, actionForm);
		VstdrewardForm form = (VstdrewardForm) actionForm;
		
		//region������й�˾����ʡ��˾,��ת����ͬ�ĳ������ҳ��
		String region = (String) request.getParameter("region");
		//������й�˾����������Ϊ�й�˾��id,ʡ��˾�Ͳ�������
		if("000".equals(region))
			form.setRegion(user.getCityid());
		
		BBCoperationVO bbcVO = getBBCoperationVO(form.getOpnid(), user);
		if ("QUER".equals(bbcVO.getBusibelong())) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "ҵ��������ڲ�ѯ�಻����༭");
			return (actionMapping.findForward("list"));
		}
		String command = getCommandString(request);
		((BaseActionForm) actionForm).setCmdState(command);
		
		//�������й�˾����ʡ��˾,���ò�ͬ������,����ǵ���й�˾�ĳ�����ñ�׼,���򲻱�,�����ʡ��˾,���򷴹���
		if("000".equals(region)){
			doGetvalue(actionMapping, actionForm, request, response, user);
		}else{
			doGetvalueDesc(actionMapping, actionForm, request, response, user);
		}
		
		
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
				WebConstant.COMMAND_STRING_EDIT);
//		//ʡ��˾,�й�˾������ͬ��ҳ��
//		if ("A".equals(this.purview)) {
////			form.setRegion("999");
//			return (actionMapping.findForward("content"));
//		} else if ("B".equals(this.purview)) {
//			form.setRegion(user.getCityid());
//			return (actionMapping.findForward("content1"));
//		} 
		
		return (actionMapping.findForward("content"));
//		return actionMapping.findForward(getForward(region));
		
	}
	
	/**
	 * ���������ʶ��λ��ת
	 * 
	 * @param region
	 * @return
	 */
	private String getForward(String region) {
		if (REGION_PRO.equals(region)) {
			return "contentpro";
		} else if (REGION_CIV.equals(region)) {
			return "contentciv";
		} else {
			return "contentpro";
		}
	}

	public void getContentVO(HttpServletRequest request, User user, ActionForm actionForm)
			throws Exception {

		String pk = request.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
		if (pk == null)
			throw new NullPointerException("pk is required.");
		Object contentVO = getContentVO(request, user);
		if (contentVO == null)
			throw new NullPointerException("VO not found, pk " + pk + " of "
					+ ClassUtils.getShortClassName(actionForm.getClass()));
		BeanUtils.copyProperties(actionForm, contentVO);

	}

	public Object getContentVO(HttpServletRequest request, User user) throws Exception {
		String pk = "";
		String parameter = request.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
		// list.jsp��ת���������
		if (parameter != null) {
			pk = parameter;
		}
		
		//region������й�˾����ʡ��˾,��ת����ͬ�ĳ������ҳ��
		String region = (String) request.getParameter("region");
//		VstdrewardVO contentVO=null;
//		if (REGION_PRO.equals(region)) {
//			contentVO = getSingVOPRO(user, pk);
//		} else if (REGION_CIV.equals(region)) {
//			contentVO = getSingVOCIV(user, pk);
//		} 
		VstdrewardVO contentVO = getSingVO(user, pk,region);
		return contentVO;
	}

	private VstdrewardVO getSingVO(User user, String pk) throws Exception {
		
		
		VstdrewardDelegate delegate = new VstdrewardDelegate();
		VstdrewardVO contentVO = null;
		VstdrewardListVO listVO = new VstdrewardListVO();
		String pks[] = StringUtils.splitPreserveAllTokens(pk, "|");
		listVO.set_ne_rewardid(pks[0]);
//		//ʡ���������
//		listVO.set_se_region("999");
		listVO.set_se_region(pks[1]);
		listVO.set_ne_ossrc(pks[2]);
		listVO.set_se_opnid(pks[3]);
		if (!pk.trim().equalsIgnoreCase("")) { // ��list.jsp ������
			DataPackage dp = delegate.doQuery(listVO, user);
			contentVO = getVstdrewardVO(dp);
		}
		return contentVO;
	}
	
	
	private VstdrewardVO getSingVO(User user, String pk,String region) throws Exception {
		
		
		VstdrewardDelegate delegate = new VstdrewardDelegate();
		VstdrewardVO contentVO = null;
		VstdrewardListVO listVO = new VstdrewardListVO();
		String pks[] = StringUtils.splitPreserveAllTokens(pk, "|");
		listVO.set_ne_rewardid(pks[0]);
		if (REGION_PRO.equals(region)) {
			listVO.set_se_region("999");
		} else if (REGION_CIV.equals(region)) {
			listVO.set_se_region(region);
		} 
//		listVO.set_se_region(pks[1]);
		listVO.set_ne_ossrc(pks[2]);
		listVO.set_se_opnid(pks[3]);
		if (!pk.trim().equalsIgnoreCase("")) { // ��list.jsp ������
			DataPackage dp = delegate.doQuery(listVO, user);
			contentVO = getVstdrewardVO(dp);
		}
		return contentVO;
	}

	/**
	 * ȡֵ
	 */
	public ActionForward doGetvalue(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		VstdrewardListVO listVO = new VstdrewardListVO();
		setListVO(listVO, actionForm); // ���ú�listVO����OrdinaryΪ��ѯ����
		VstdrewardForm form = (VstdrewardForm) actionForm;
		VstdrewardDelegate delegate = new VstdrewardDelegate();
		listVO.set_se_opnid(form.getOpnid());
		listVO.set_ne_ossrc(String.valueOf(form.getOssrc()));
		// ȡ��Ȩ��
		getPurview(user);
		DataPackage dp = null;
			// ʡ������
			dp = delegate.doQuery(listVO, user);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		if (dp.getRowCount() > 0) {
			request.setAttribute("SHOW", "TRUE");
		}
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, "EDIT");
		if (AAUtils.isAjaxRequest(request)) {
			AAUtils.addZonesToRefresh(request, "getvalue");
		}
		return actionMapping.findForward("content");
//		return actionMapping.findForward(getForward(form.getRegion()));
	}

	/**
	 * ȡֵ
	 */
	public ActionForward doGetvalueDesc(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		VstdrewardListVO listVO = new VstdrewardListVO();
		setListVO(listVO, actionForm); // ���ú�listVO����OrdinaryΪ��ѯ����
		VstdrewardForm form = (VstdrewardForm) actionForm;
		VstdrewardDelegate delegate = new VstdrewardDelegate();
		listVO.set_se_opnid(form.getOpnid());
		listVO.set_ne_ossrc(String.valueOf(form.getOssrc()));
		// ȡ��Ȩ��
		getPurview(user);
		DataPackage dp = null;
			// ʡ������
			dp = delegate.doQueryDesc(listVO, user);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		if (dp.getRowCount() > 0) {
			request.setAttribute("SHOW", "TRUE");
		}
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, "EDIT");
		if (AAUtils.isAjaxRequest(request)) {
			AAUtils.addZonesToRefresh(request, "getvalue");
		}
		return actionMapping.findForward("content");
//		return actionMapping.findForward(getForward(form.getRegion()));
	}
	
	/**
	 * ��ȡʡ��˾�������
	 * 
	 * @param vo
	 * @param user
	 * @return
	 * @throws Exception
	 */
	/**
	 * ȡֵ
	 */
	public ActionForward doGetprovincestd(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		try {
			getMaxRewardstd(actionForm, request, user);

			if (AAUtils.isAjaxRequest(request)) {
				AAUtils.addZonesToRefresh(request, "getprovincestd");
			}
			doGetvalue(actionMapping, actionForm, request, response, user);
		} catch (Exception ex) {
			request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, "EDIT");
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
			request.setAttribute("DISABLE", "TRUE");
		}
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, "EDIT");
		return actionMapping.findForward("content");
	}

	private Double getMaxRewardstd(ActionForm actionForm, HttpServletRequest request, User user)
			throws Exception {
		VstdrewardVO contentVO = null;
		VstdrewardListVO listVO = new VstdrewardListVO();
		VstdrewardForm form = (VstdrewardForm) actionForm;
		VstdrewardDelegate delegate = new VstdrewardDelegate();
		listVO.set_se_opnid(form.getOpnid());
		listVO.set_se_region(PROVINCE_REGION);
		if (form.getOssrc() != null) {
			listVO.set_ne_ossrc(String.valueOf(form.getOssrc()));
		}
		listVO.set_dnm_startdate(TimeUtil.formatDate(form.getStartdate()));
		listVO.set_dnl_stopdate(TimeUtil.formatDate(form.getStopdate()));
		if (form.getIntvmonth() != null) {
			listVO.set_ne_intvmonth(String.valueOf(form.getIntvmonth()));
		}
		DataPackage dp = delegate.doQuery2(listVO, user);
		contentVO = getVstdrewardVO(dp);
		if (contentVO == null) {
			throw new Exception("ʡ��˾��δ���ø�ʱ��εĳ���׼������ϵʡ��˾��");
		} else {
			form.setMax_pro_std(contentVO.getRewardstd());
			return contentVO.getRewardstd();
		}
	}

	/**
	 * �½�
	 */
	public ActionForward doNew(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		// �½�ʱ����form��Ĭ��ֵ
		setNewForm(actionForm);
		String command = getCommandString(request);
		((BaseActionForm) actionForm).setCmdState(command);
		VstdrewardForm form = (VstdrewardForm) actionForm;
		form.setRegion(user.getCityid());
		form.setRewardproj(new Short("1"));
		getPurview(user);
		if ("A".equals(this.purview)) {
			form.setRegion("999");
		} else if ("B".equals(this.purview)) {
			form.setRegion(user.getCityid());
		} else {
			throw new Exception("�ù���û������Ȩ��");
		}
		form.setAcctype(new Short(DEFAULT_ACCTYPE));
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
				WebConstant.COMMAND_STRING_EDIT);
		return (actionMapping.findForward("content"));
	}

	/**
	 * A-ʡ��Ȩ�ޣ�B-����Ȩ��
	 * 
	 * @param user
	 */
	private void getPurview(User user) throws Exception {
		ProvincialrightListVO listVO = new ProvincialrightListVO();
		listVO.set_se_proopr(user.getOpercode());
		listVO.set_se_rightid(PROVINCE_PURVIEW_A);
		listVO.set_pagesize("0");

		if (delegate.doQuery(listVO, user).getDatas().size() > 0) {
			purview = "A";
			return;
		}
		ACLDelegate delegate2 = new ACLDelegate();
		if (delegate2.checkPermission(user.getOpercode(), PROVINCE_PURVIEW_A)) {
			purview = "A";
			return;
		}
		listVO.set_se_rightid(PROVINCE_PURVIEW_B);
		if (delegate.doQuery(listVO, user).getDatas().size() > 0) {
			purview = "B";
			return;
		}
		if (delegate2.checkPermission(user.getOpercode(), PROVINCE_PURVIEW_B)) {
			purview = "B";
			return;
		}
		purview = "";
	}

	/**
	 * ����
	 */
	protected ActionForward doSave(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		try {
			VstdrewardDelegate delegate=new VstdrewardDelegate();
			VstdrewardVO contentVO = new VstdrewardVO();
			setSaveVO(contentVO, actionForm); // �ڴ˸�ʽ������� vo �Ա���
			VstdrewardForm fm = (VstdrewardForm) actionForm;
			// �ٴμ��ʡ����׼
			getPurview(user);
			//����Ȩ�޵����,��ʡ��˾�����Ƹ��ǹ�˾��Ȩ��,������й�˾��region,�ͼ��һ��
			if (("B".equals(this.purview))|| !("999".equals(fm.getRegion())) ) {
				Double max = getMaxRewardstd(actionForm, request, user);
				if (max != null && max.doubleValue() < contentVO.getRewardstd().doubleValue()) {
					if (fm.getAcctype().shortValue() == 2) {
						throw new Exception("���г���׼���ܴ���ʡ����׼" + fm.getMax_pro_std().doubleValue()
								* 100 + "%");
					} else {
						throw new Exception("���г���׼���ܴ���ʡ����׼" + fm.getMax_pro_std());
					}
				}
			}
				
			String cmdState = ((BaseActionForm) actionForm).getCmdState();
			if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {
				Object vo = null;
				BBCstdrewardbjVO pkVO = new BBCstdrewardbjVO();
				BeanUtils.copyProperties(pkVO, contentVO);
				BBCstdrewardbjDelegate bbcstdrewardbjdelegate= new BBCstdrewardbjDelegate();
				vo = bbcstdrewardbjdelegate.doFindByPk((Serializable) pkVO, user);
				if (vo == null) {
					bbcstdrewardbjdelegate.doCreate(pkVO, user);
				}else{
					// �����Ƿ�Ҫ�жϼ�¼�Ƿ��Ѿ�����?
					delegate.doUpdate(contentVO, user);
				}
				
				BeanUtils.copyProperties(actionForm, contentVO); // �Ѹ��º��ֵ����form������web��ʾ
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
			} else {// ����
				Object vo = null;
				BBCstdrewardbjVO pkVO = new BBCstdrewardbjVO();
				BeanUtils.copyProperties(pkVO, contentVO);
				vo = new BBCstdrewardbjDelegate().doFindByPk((Serializable) pkVO, user);
				if (vo == null) {
					// ȡ��rewardtype��ֵ
					getRewardtype(user, contentVO);
					//
					delegate.doCreate(contentVO, user);
					BeanUtils.copyProperties(actionForm, contentVO); // �Ѹ��º��ֵ����form������web��ʾ
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
				} else {
					request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
							WebConstant.COMMAND_STRING_EDIT);
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "�����ظ�");
					onDuplicatePk(actionMapping, actionForm, request, response, user);
				}
			}
		} catch (Exception ex) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
			request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
					WebConstant.COMMAND_STRING_EDIT);
			return (actionMapping.findForward("content"));
		}
		return (actionMapping.findForward("content"));
	}

	/**
	 * �жϳ������
	 * 
	 * @param user
	 * @param contentVO
	 * @throws Exception
	 */
	private void getRewardtype(User user, VstdrewardVO contentVO) throws Exception {
		BBCoperationVO bbcVO = getBBCoperationVO(contentVO, user);
		if (contentVO.getIntvmonth().intValue() > 0) {
			if ("CZ".equals(bbcVO.getBusibelong()) || "DATABUSI".equals(bbcVO.getBusibelong())
					|| "DATABUSI2".equals(bbcVO.getBusibelong())
					|| "SELL".equals(bbcVO.getBusibelong())) {
				contentVO.setRewardtype(new Short("10"));
			}
			if ("030100047".equals(contentVO.getOpnid())) {
				contentVO.setRewardtype(new Short("12"));
			}
			if ("030100048".equals(contentVO.getOpnid())) {
				contentVO.setRewardtype(new Short("14"));
			}
		} else if (contentVO.getIntvmonth().intValue() == 0) {
			if ("CZ".equals(bbcVO.getBusibelong()) || "DATABUSI".equals(bbcVO.getBusibelong())
					|| "DATABUSI2".equals(bbcVO.getBusibelong())
					|| "SELL".equals(bbcVO.getBusibelong())) {
				contentVO.setRewardtype(new Short("9"));
			}
			if ("030100047".equals(contentVO.getOpnid())) {
				contentVO.setRewardtype(new Short("11"));
			}
			if ("030100048".equals(contentVO.getOpnid())) {
				contentVO.setRewardtype(new Short("13"));
			}
		}
	}

	private BBCoperationVO getBBCoperationVO(VstdrewardVO contentVO, User user) throws Exception {
		BBCoperationVO bbcVO = getBBCoperationVO(contentVO.getOpnid(), user);
		return bbcVO;
	}

	private BBCoperationVO getBBCoperationVO(String opnid, User user) throws Exception {
		BBCoperationDelegate bbcDelegate = new BBCoperationDelegate();
		BBCoperationVO bbcVO = bbcDelegate.doFindByPk(opnid, user);
		return bbcVO;
	}

	/**
	 * ɾ��
	 */
	protected ActionForward doDelete(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		getPurview(user);
		String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
		VstdrewardDelegate delegate = new VstdrewardDelegate();
		for (int i = 0; i < selectArray.length; i++) {
			{
				VstdrewardVO delVO = (VstdrewardVO) getSingVO(user, selectArray[i]);
				if ("A".equals(this.purview) && "999".equals(delVO.getRegion())) {
					delegate.doRemove(delVO, user);
				} else if("A".equals(this.purview) && !"999".equals(delVO.getRegion())){
					throw new Exception("ʡ�����ƹ���ֻ��ɾ������Ϊ[�㶫]�ļ�¼");
				}
				if ("B".equals(this.purview) && user.getCityid().equals(delVO.getRegion())) {
					delegate.doRemove(delVO, user);
				} else if("B".equals(this.purview) && !user.getCityid().equals(delVO.getRegion())){
					throw new Exception("�������ƹ���ֻ��ɾ������Ϊ�����еļ�¼");
				}
				if ("".equals(this.purview)) {
					throw new Exception("�ù���û��ɾ��Ȩ��");
				}
			}
		}
		return doList(actionMapping, actionForm, request, response, user);
	}

	/**
	 * ���ز�ѯ���ĵ�һ��VO.
	 */
	private VstdrewardVO getVstdrewardVO(DataPackage dp) throws Exception {
		VstdrewardVO contentVO = null;
		if (dp.getRowCount() > 0) {
			Collection col = dp.getDatas();
			Iterator it = col.iterator();
			if (it.hasNext()) {
				contentVO = (VstdrewardVO) it.next();
			}
		}
		return contentVO;
	}

	/**
	 * ����ΪEXCEL��ʽ��
	 */
	public ActionForward doExcel(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("����׼����");
		export.appendHeadLine(new String[] { "��������:", user.getOpercode() });
		export.appendHeadLine(new String[] { "����ʱ��", format.format(new Date()) });
		export.addOutputProperty("rewardid", "����־");
		export.addOutputProperty("rewardname", "�������");
		export.addOutputProperty("opnid", "ҵ�����", CommonExportBean.CODE2NAME, "#BBC_OPERATION");
		export.addOutputProperty("region", "����", CommonExportBean.CODE2NAME, "$region");
		export.addOutputProperty("ossrc", "ҵ��ƽ̨��Դ", CommonExportBean.CODE2NAME, "$CH_OSSRC");
		export.addOutputProperty("rewardtype", "�������", CommonExportBean.CODE2NAME,
				"#CH_BBCREWARDTYPE");
		export.addOutputProperty("intvmonth", "����·�(��)");
		export.addOutputProperty("rewardstd", "����׼");
		export.addOutputProperty("startdate", "����ʱ��", CommonExportBean.DATE, "yyyy-MM-dd");
		export.addOutputProperty("stopdate", "ͣ��ʱ��", CommonExportBean.DATE, "yyyy-MM-dd");
		export.addOutputProperty("acctype", "�Ƴ귽ʽ", CommonExportBean.CODE2NAME, "$CH_ACCTYPE");
		export.addOutputProperty("ruleid", "У������־", CommonExportBean.CODE2NAME, "#CH_ADT_RULE");
		export.addOutputProperty("memo", "��ע");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel(actionMapping, actionForm, request, response, user);
	}
}
