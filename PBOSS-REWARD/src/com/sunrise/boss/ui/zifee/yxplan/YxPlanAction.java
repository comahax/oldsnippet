package com.sunrise.boss.ui.zifee.yxplan;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ajaxanywhere.AAUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanListVO;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.admin.dictitem.DictitemDelegate;
import com.sunrise.boss.delegate.zifee.yxplan.YxPlanDelegate;
import com.sunrise.boss.delegate.zifee.yxplangroup.YxPlanGroupDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.boss.ui.commons.integration.IntegrationBean;
import com.sunrise.boss.ui.zifee.commons.BatchProcess;
import com.sunrise.boss.ui.zifee.commons.ResultBean;

public class YxPlanAction extends BaseDelegateAction {
	private String[] specialflagValue;

	private String[] specialflagName;

	private DictitemDelegate dictDelegate;

	public YxPlanAction() {
		this.voClass = YxPlanVO.class;
		this.pkNameArray = new String[1];
		pkNameArray[0] = "yxplanid";

	}

	protected void onDuplicatePk(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) {

		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
				"��ͬӪ��������ʶ�Ѿ�����, ��������������");

	}

	/**
	 * ��ѯ
	 */
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		YxPlanActionForm form = (YxPlanActionForm) actionForm;

		try {
			Page.setPageSize(request, form);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			YxPlanListVO listVO = new YxPlanListVO();
			setListVO(listVO, actionForm); // ���ú�listVO����Ϊ��ѯ����
			listVO.set_ne_groupflag("0"); // 1 ��, 0
			// ��������ǡ�Ӫ�������飬����[Ӫ����������]�в��ɼ�����[Ӫ�������������]�ж�Ӫ�����������

			// ���Ʋ�ѯ�����������й�˾�Լ�ȫʡ��Ӫ��������ȫ����Ӫ������ modify by luozhoujie 2006-11-29
			if (form.get_se_areacode() == null
					|| "".equals(form.get_se_areacode())) {
				// ����ͳһӪ����,ȫʡ,�й�˾,�����ʶΪ��Ҳ�ڲ�ѯ��Χ��
				String _sql_areacode = " (areacode is null or  areacode in ('865','100','999','','"
						+ user.getCityid() + "')) ";
				listVO.set_sql_areacode(_sql_areacode);
			}

			YxPlanDelegate delegate = new YxPlanDelegate();
			DataPackage dp = delegate.doQuery(listVO, user);
			// ����Ӫ��������־
			// DataPackage dp2 = dealDate(dp, user);
			// form.setPage(dp.getPageNo());
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		} catch (Exception e) {
			throw e;
		}
		return (actionMapping.findForward("list"));
	}

	public ActionForward doSelectyxplanid(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		YxPlanActionForm form = (YxPlanActionForm) actionForm;
		try {
			Page.setPageSize(request, form);
			YxPlanListVO listVO = new YxPlanListVO();
			YxPlanDelegate delegate = new YxPlanDelegate();
			setListVO(listVO, form);
			DataPackage dp = delegate.doQuery(listVO, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return actionMapping.findForward("selectyxplanid");
	}

	public Long getYxplanSeq(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		YxPlanDelegate delegate = new YxPlanDelegate();
		Long dbSeq = delegate.getYxplanSeq(user);
		return dbSeq;
	}

	public String formatYxplanID(String yxplanid) {

		return yxplanid;
	}

	public ActionForward doSelect(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		YxPlanActionForm form = (YxPlanActionForm) actionForm;
		try {
			Page.setPageSize(request, form);
			YxPlanListVO listVO = new YxPlanListVO();
			setListVO(listVO, actionForm); // ���ú�listVO����Ϊ��ѯ����
			listVO.set_ne_groupflag("0"); // 1 ��, 0
			// ��������ǡ�Ӫ�������飬����[Ӫ����������]�в��ɼ�����[Ӫ�������������]�ж�Ӫ�����������

			// ���Ʋ�ѯ�����������й�˾�Լ�ȫʡ��Ӫ��������ȫ����Ӫ������ modify by luozhoujie 2006-11-29
			if (form.get_se_areacode() == null
					|| "".equals(form.get_se_areacode())) {
				// ����ͳһӪ����,ȫʡ,�й�˾,�����ʶΪ��Ҳ�ڲ�ѯ��Χ��
				String _sql_areacode = " (areacode is null or  areacode in ('865','100','999','','"
						+ user.getCityid() + "')) ";
				listVO.set_sql_areacode(_sql_areacode);
			}
			YxPlanDelegate delegate = new YxPlanDelegate();
			DataPackage dp = delegate.doQuery(listVO, user);

			// form.setPage(dp.getPageNo());
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return (actionMapping.findForward("select"));
	}

	protected ActionForward doNew(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// TODO Auto-generated method stub
		String str;
		java.util.Date date = new java.util.Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		// str = "GD10000" + dateFormat.format(date) + "001" + "-" + "000000"+
		// "-" + "00";
		str = "GD10000" + dateFormat.format(date) + "001" + "000000" + "00";// �޸�Ϊ��ȥ��"-"
		YxPlanActionForm form = (YxPlanActionForm) actionForm;
		form.setYxplancode(str);
		form.setOperatorcode(user.getOpercode());
		form.setCheckercode(user.getOpercode());
		//Ĭ��ֵ �Ƿ�Ԥ�� ��
		form.setBookflag(new Byte("0"));
		// �������ⷽ����־��ֵ
		getValues(user);
		form.setSpecialflagName(this.specialflagName);
		request.setAttribute("VALUE", this.specialflagValue);
		
		//��ȡyxplanid
		Long seq = getYxplanSeq(actionMapping, actionForm, request, response,
				user);
		String seqString = String.valueOf(seq);
		String areacode=user.getCityid();
		if("999".equals(areacode))
			areacode="100";
		String yxplanid = areacode
				+ StringUtils.repeat("0", 11 - seqString.length()) + seq;
		form.setYxplanid(Long.valueOf(yxplanid));
		form.setAreacode(areacode);
		return super.doNew(actionMapping, actionForm, request, response, user);
	}

	public ActionForward doNewyxplanid(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// TODO Auto-generated method stub

		String areacode = request.getParameter("hWnd");
		Long seq = getYxplanSeq(actionMapping, actionForm, request, response,
				user);
		String seqString = String.valueOf(seq);
		String yxplanid = areacode
				+ StringUtils.repeat("0", 11 - seqString.length()) + seq;
		YxPlanActionForm form = (YxPlanActionForm) actionForm;
		form.setYxplanid(Long.valueOf(yxplanid));
		form.setAreacode(areacode);
		getValues(user);
		form.setSpecialflagName(this.specialflagName);
		request.setAttribute("VALUE", this.specialflagValue);
		return (actionMapping.findForward("content"));
	}

	/**
	 * ����Ӫ�����������ʶ����Ӫ������ID���ڸ���ҳ��ʹ��
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doGenyxplanid(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// TODO Auto-generated method stub
		try {
			String areacode = request.getParameter("hWnd");
			Long seq = getYxplanSeq(actionMapping, actionForm, request,
					response, user);
			String seqString = String.valueOf(seq);
			String yxplanid = areacode
					+ StringUtils.repeat("0", 11 - seqString.length()) + seq;
			YxPlanActionForm form = (YxPlanActionForm) actionForm;
			form.setYxplanid(Long.valueOf(yxplanid));
			form.setAreacode(areacode);
		} catch (Exception e) {
			request
					.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							"����Ӫ����ʶ����");
		} finally {
			if (request.getAttribute("detail") == null) {
				DataPackage dp = getCopyDetail(user);
				request.setAttribute("detail", dp);
			}
		}
		// �������ⷽ����־��ֵ

		return (actionMapping.findForward("single"));
	}

	public ActionForward doEdit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		getContentVO(request, user, actionForm);
		String command = getCommandString(request);
		((BaseActionForm) actionForm).setCmdState(command);
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
				WebConstant.COMMAND_STRING_EDIT);
		// �������ⷽ����־��ֵ
		getValues(user);
		((YxPlanActionForm) actionForm)
				.setSpecialflagName(this.specialflagName);
		request.setAttribute("VALUE", this.specialflagValue);
		// ���ÿɰ����û�״̬
		if (!(((YxPlanActionForm) actionForm).getUserstausflag() == null || ""
				.equals(((YxPlanActionForm) actionForm).getUserstausflag()))) {
			((YxPlanActionForm) actionForm)
					.setSelectuserstausflag(((YxPlanActionForm) actionForm)
							.getUserstausflag().split(","));
		}
		return (actionMapping.findForward("content"));
	}

	/**
	 * Ӫ���������б���ʾ
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @author added by yijianrong
	 */
	public ActionForward doGrouplist(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		YxPlanActionForm form = (YxPlanActionForm) actionForm;
		doQueryGroup(form, request, false, user);
		return (actionMapping.findForward("grouplist"));
	}

	/**
	 * Ӫ������������Ŀ¼��ʾ
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @author added by yijianrong
	 */
	public ActionForward doTree(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		YxPlanActionForm form = (YxPlanActionForm) actionForm;
		doQueryGroup(form, request, true, user);
		return (actionMapping.findForward("tree"));
	}

	/**
	 * ɾ��Ӫ��������
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @author added by yijianrong
	 */
	public ActionForward doDeletegroup(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		YxPlanActionForm form = (YxPlanActionForm) actionForm;
		YxPlanDelegate delegate = new YxPlanDelegate();
		YxPlanGroupDelegate groupdelegate = new YxPlanGroupDelegate();
		String[] selectArray = form.get_selectitem();

		try {
			for (int i = 0; i < selectArray.length; i++) {
				YxPlanVO vo = delegate.doFindByPk(new Long(selectArray[i]),
						user);
				groupdelegate.deleteByGroupid(vo.getYxplanid(), user);
				delegate.doRemove(vo, user);
			}
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.toString());
		} catch (Exception e) {
			throw e;
		}

		return doGrouplist(actionMapping, actionForm, request, response, user);
	}

	/**
	 * ����Ӫ��������
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @author added by yijianrong
	 */
	public ActionForward doNewgroup(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		YxPlanActionForm form = (YxPlanActionForm) actionForm;
		String command = getCommandString(request);
		form.setCmdState(command);
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, command);

		return (actionMapping.findForward("groupcontent"));
	}

	/**
	 * �༭Ӫ��������
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @author added by yijianrong
	 */
	public ActionForward doEditgroup(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		YxPlanActionForm form = (YxPlanActionForm) actionForm;
		getContentVO(request, user, form);
		String command = getCommandString(request);
		form.setCmdState(command);
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, command);

		return (actionMapping.findForward("groupcontent"));
	}

	/**
	 * ����Ӫ��������
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @author added by yijianrong
	 */
	public ActionForward doSavegroup(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		YxPlanActionForm form = (YxPlanActionForm) actionForm;
		YxPlanVO contentVO = new YxPlanVO();
		YxPlanDelegate delegate = new YxPlanDelegate();
		setSaveVO(contentVO, form);
		// ��VO��һЩ�������Ϣ

		contentVO.setStartdate(new Date(System.currentTimeMillis()));
		contentVO.setStopdate(new Date(System.currentTimeMillis()));
		contentVO.setGroupflag(new Byte("1"));

		YxPlanVO existVO = delegate.doFindByPk(contentVO.getYxplanid(), user);
		;

		if (existVO != null) {
			BeanUtils.copyProperties(existVO, contentVO);
			contentVO = existVO;
		}

		String cmdState = form.getCmdState();
//		if(contentVO.getAreacode()==null)
//		{
//			contentVO.setAreacode(user.getCityid());
//		}
		if (existVO != null) {
			
			delegate.doUpdate(contentVO, user);
			request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
					"EDITGROUP");
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "�޸ĳɹ�");
			return (actionMapping.findForward("groupcontent"));
		} else {
			delegate.doCreate(contentVO, user);
		}

		BeanUtils.copyProperties(form, contentVO);
		form.setCmdState("EDITGROUP");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
		return (actionMapping.findForward("groupcontent"));
	}

	/**
	 * ��ѯӪ�������飬����Ϊgroupflag=1
	 * 
	 * @param form
	 * @param request
	 * @param queryall
	 * @param user
	 * @return
	 * @throws Exception
	 * @author added by yijianrong
	 */
	private void doQueryGroup(YxPlanActionForm form,
			HttpServletRequest request, boolean queryall, User user)
			throws Exception {

		try {
			Page.setPageSize(request, form);
			YxPlanListVO listVO = new YxPlanListVO();

			if (queryall) {
				listVO.set_pagesize(null); // ȫ��һ���Բ�ѯ������_pagesize�Ȳ�������ΪInteger.MAX_VALUE��NULL
			} else {
				setListVO(listVO, form);
			}
			listVO.set_ne_groupflag("1"); // 1ΪӪ��������

			YxPlanDelegate delegate = new YxPlanDelegate();
			DataPackage dp = delegate.doQuery(listVO, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * ��������Ӫ������
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @author added by yijianrong
	 */
	public ActionForward doBatch(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		return (actionMapping.findForward("batch"));
	}

	/**
	 * �ϴ�����������Ӫ�������ļ�
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @author added by yijianrong
	 */
	public ActionForward doUpload(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		YxPlanActionForm form = (YxPlanActionForm) actionForm;
		FormFile inputFile = form.getInputFile();
		if (inputFile == null) {
			request
					.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							"�ϴ��ļ�����Ϊ��");
			return (actionMapping.findForward("batch"));
		}

		int sum = 0;
		int success = 0;
		int failure = 0;
		String elements = null;
		String restr = null;
		Iterator iterator = BatchProcess.getData(inputFile);
		StringBuffer result = new StringBuffer("");
		StringBuffer tmp = new StringBuffer("");
		YxPlanDelegate delegate = new YxPlanDelegate();

		while (iterator.hasNext()) {
			elements = (String) iterator.next();

			// ����ִ��Ϸ���
			String[] fields = BatchProcess.getInResult(elements);
			ResultBean resultBean = delegate.doCheck(fields, user);

			// ������Ϊ0��ʾ���ͨ��
			if (resultBean.getCode() == 0) {
				try {
					YxPlanVO vo = delegate.buildVO(fields, user);
					if (vo != null) {
						delegate.doCreate(vo, user);
					} else {
						restr = "��" + String.valueOf(sum + 1) + "�й���Ӫ����������ʧ��";
					}
				} catch (Exception ex) {
					restr = "��" + String.valueOf(sum + 1) + "�в������ݿ�ʧ��! ";
				}

				if (restr == null) {
					success++;
				} else {
					tmp.append("��").append(sum + 1).append("�м�¼���ʱ���ִ���\r\n");
					tmp.append("ԭ��").append(restr).append("\r\n\r\n");
					failure++;
				}
			} else {
				tmp.append("��").append(sum + 1).append("�м�¼���ʱ���ִ���\r\n");
				tmp.append("ԭ��").append(resultBean.getInfo()).append(
						"\r\n\r\n");
				failure++;
			}
			sum++;
		}

		result.append("�ܹ�").append(sum).append("����¼���ɹ�").append(success)
				.append("��,ʧ��").append(failure).append("��.\r\n\r\n");
		result.append(tmp.toString());
		form.setReInfo(result.toString());
		return (actionMapping.findForward("batch"));
	}

	/**
	 * Ӫ��������������Excel
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @author added by luozhoujie
	 */
	public ActionForward doExcelout(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		BaseActionForm form = (BaseActionForm) actionForm;
		// ������ѯBEAN
		ExcelOutYxPlan export = new ExcelOutYxPlan(user);

		export.setFileName("Ӫ������������Ϣ");
		request.setAttribute("creator", export);

		request.setAttribute("queryVO", actionForm);
		return actionMapping.findForward("excelout");
	}

	/**
	 * Ӫ������������Ϣ����
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @author added by luozhoujie
	 */
	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		YxPlanActionForm form = (YxPlanActionForm) actionForm;
		// ���Ӫ�����������ʶ���ǵ�ǰ������������,�������޸�
		if (!user.isProvinceUser()) {
			if (null == form.getAreacode()
					|| !form.getAreacode().trim().equalsIgnoreCase(
							user.getCityid().trim())) {
				request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
						WebConstant.COMMAND_STRING_EDIT);
				String msginfo = "����ʧ��,��ǰӪ�����������ʶΪ�ջ��뵱ǰ�������������ʶ��һ��,��������";
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
						msginfo);
				return (actionMapping.findForward("content"));
			}
		}
		String[] temp = form.getSelectSpecialflag();
		String result = "";
		for (int i = 0; i < temp.length; i++) {
			if (i != temp.length - 1) {
				result = result + temp[i] + ",";
			} else {
				result = result + temp[i];
			}
		}

		String[] selectuserstausflag = form.getSelectuserstausflag();
		String userstausflag = "";
		int lenght = selectuserstausflag == null ? 0
				: selectuserstausflag.length;
		for (int i = 0; i < lenght; i++) {
			if (i != lenght - 1) {
				userstausflag = userstausflag + selectuserstausflag[i] + ",";
			} else {
				userstausflag = userstausflag + selectuserstausflag[i];
			}
		}
		getValues(user);
		form.setSpecialflagName(this.specialflagName);
		request.setAttribute("VALUE", this.specialflagValue);
		form.setSpecialflag(result);
		form.setUserstausflag(userstausflag);
		return super.doSave(actionMapping, actionForm, request, response, user);
	}

	/**
	 * �ϴ�����������Ӫ�������ļ�(����)
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @author added by yijianrong
	 */
	public ActionForward doBatchadd(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		YxPlanActionForm form = (YxPlanActionForm) actionForm;
		FormFile inputFile = form.getInputFile();
		BaseCheckFormat iCheckFormat = new YxplanCheck();
		// ����ļ����ʹ�С,���������͵�
		if (inputFile == null || inputFile.getFileSize() == 0) {

			form.setReInfo("�ϴ��ļ�����Ϊ��");
			return (actionMapping.findForward("batch"));
		}
		iCheckFormat.checkFile(inputFile, null);
		// ����ļ�ÿ�и�ʽ
		String result = batchDisposal(inputFile, iCheckFormat, true, false,
				user);
		form.setReInfo(result);
		return (actionMapping.findForward("batch"));
	}

	/**
	 * �ϴ�����������Ӫ�������ļ�
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @author added by yijianrong
	 */
	// public ActionForward doUpload(ActionMapping actionMapping,
	// ActionForm actionForm, HttpServletRequest request,
	// HttpServletResponse response, User user) throws Exception {
	// }
	/**
	 * ͨ��ԭʼӪ��������ʶ���Ӫ��������Ϣ�������µ�Ӫ��������ʶ������Ĭ��ʱ���
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @author Cai Jianhui
	 */
	public ActionForward doGetyxplandt(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.AM_PM, 0);
			calendar.set(Calendar.HOUR, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			Date startdate = calendar.getTime();
			calendar.add(Calendar.YEAR, 1);
			calendar.set(Calendar.HOUR, 23);
			calendar.set(Calendar.MINUTE, 59);
			calendar.set(Calendar.SECOND, 59);
			Date stopdate = calendar.getTime();

			YxPlanActionForm form = (YxPlanActionForm) actionForm;
			YxPlanDelegate delegate = new YxPlanDelegate();
			YxPlanVO planVO = delegate.doFindByPk(form.getOrgyxplanid(), user);
			String areacode = user.getCityid();
			if (areacode == null || areacode.trim().length() == 0) {
				throw new BusinessException("", "Ӫ�����������ʶΪ��");
			}
			Long seq = getYxplanSeq(actionMapping, actionForm, request,
					response, user);
			String seqString = String.valueOf(seq);
			if("999".equals(areacode))
				areacode="100";
			String yxplanid = areacode
					+ StringUtils.repeat("0", 11 - seqString.length()) + seq;

			BeanUtils.copyProperties(form, planVO);
			form.setAreacode(areacode);
			form.setYxplanid(new Long(yxplanid));
			form.setYxplanname("");
			form.setStartdate(startdate);
			form.setStopdate(stopdate);
			// ��ԭ���ⷽ����־��ֵ
			getValues(user);
			form.setSpecialflagName(this.specialflagName);
			request.setAttribute("VALUE", this.specialflagValue);
			String[] strResult = revertValues(form.getSpecialflag());
			form.setSelectSpecialflag(strResult);
			
			if (!(((YxPlanActionForm) actionForm).getUserstausflag() == null || ""
					.equals(((YxPlanActionForm) actionForm).getUserstausflag()))) {
				((YxPlanActionForm) actionForm)
						.setSelectuserstausflag(((YxPlanActionForm) actionForm)
								.getUserstausflag().split(","));
			}
			
			if (!(form.getSpecialflag() == null || ""
					.equals(form.getSpecialflag()))) {
				if(form.getSpecialflag().indexOf(",")>0){
					form
					.setSelectSpecialflag(((YxPlanActionForm) actionForm)
							.getSpecialflag().split(","));
				}else{
					form
					.setSelectSpecialflag(new String[]{form.getSpecialflag()});
				}
				
			}
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		} finally {
			if (request.getAttribute("detail") == null) {
				DataPackage dp = getCopyDetail(user);
				request.setAttribute("detail", dp);
			}
		}
		return actionMapping.findForward("single");
	}

	/**
	 * Ӫ��������������
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doSinglecopy(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			YxPlanDelegate delegate = new YxPlanDelegate();
			YxPlanVO vo = new YxPlanVO();
			YxPlanActionForm form = (YxPlanActionForm) actionForm;
			String oldid = form.getOrgyxplanid().toString();
			String copyitem = form.getCopyitem();
			/*
			 * ����[���ⷽ����־]��ֵ
			 */
			String[] temp = form.getSelectSpecialflag();
			String result = "";
			for (int i = 0; i < temp.length; i++) {
				if (i != temp.length - 1) {
					result = result + temp[i] + ",";
				} else {
					result = result + temp[i];
				}
			}
			// ����[�ɰ����û�״̬]��ֵ
			String[] selectuserstausflag = form.getSelectuserstausflag();
			String userstausflag = "";
			int lenght = selectuserstausflag == null ? 0
					: selectuserstausflag.length;
			for (int i = 0; i < lenght; i++) {
				if (i != lenght - 1) {
					userstausflag = userstausflag + selectuserstausflag[i]
							+ ",";
				} else {
					userstausflag = userstausflag + selectuserstausflag[i];
				}
			}
			form.setUserstausflag(userstausflag);

			getValues(user);
			form.setSpecialflagName(this.specialflagName);
			request.setAttribute("VALUE", this.specialflagValue);
			form.setSpecialflag(result);

			BeanUtils.copyProperties(vo, form);
			vo.setOperatorcode(user.getOpercode());
			delegate.doSinglecopy(oldid, copyitem, vo, true, "", user);

			IntegrationBean integrationBean = new IntegrationBean(user);

			String huaweiIP = integrationBean.getHuaweiIP();
			String huaweiPort = integrationBean.getHuaweiPort();
			String huaweiWebRoot = integrationBean.getHuaweiWebRoot();

			if (huaweiWebRoot == null)
				huaweiWebRoot = "/boss";
			String huaweiContextPath = huaweiIP != null ? "http://" + huaweiIP
					: ""; /* fixed value by huawei */
			if (huaweiIP != null && huaweiPort != null
					&& !"80".equals(huaweiPort))
				huaweiContextPath = huaweiContextPath + ":" + huaweiPort;
			huaweiContextPath = huaweiContextPath + huaweiWebRoot;

			String url = huaweiContextPath + "/product/privilegeCopyAction.do"
					+ "?actionType=queryInit&yxplanid=" + oldid.toString()
					+ "&newyxplanid=" + vo.getYxplanid().toString();
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"�����Ѹ�����ɣ�������ϸ��δ������ɣ�������£�������һ�������������µĸ��Ʋ���");
			request.setAttribute("copyitem", copyitem.split(","));
			request.setAttribute("url", url);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			return actionMapping.findForward("single");
		} finally {
			if (request.getAttribute("detail") == null) {
				DataPackage dp = getCopyDetail(user);
				request.setAttribute("detail", dp);
			}
		}
		return actionMapping.findForward("copyresult");
	}

	public ActionForward doSingle(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		if (request.getAttribute("detail") == null) {
			DataPackage dp = getCopyDetail(user);
			request.setAttribute("detail", dp);
		}
//		Ĭ��ֵ �Ƿ�Ԥ�� ��
		((YxPlanActionForm)actionForm).setBookflag(new Byte("0"));
		// �������ⷽ����־
		getValues(user);
		((YxPlanActionForm) actionForm)
				.setSpecialflagName(this.specialflagName);
		request.setAttribute("VALUE", this.specialflagValue);
		return actionMapping.findForward("single");
	}

	public DataPackage getCopyDetail(User user) throws Exception {
		DictitemDelegate delegate = new DictitemDelegate();
		DictitemListVO listVO = new DictitemListVO();
		listVO.set_se_groupid("PC_YXPLANCOPYITEM");
		listVO.set_pageno(null);
		listVO.set_pagesize(null);
		DataPackage dp = delegate.doQuery(listVO, user);
		return dp;
	}

	/**
	 * �ϴ�����������Ӫ�������ļ�(�޸�)
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @author added by yijianrong
	 */
	public ActionForward doBatchupdate(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		YxPlanActionForm form = (YxPlanActionForm) actionForm;
		FormFile inputFile = form.getInputFile();
		BaseCheckFormat iCheckFormat = new YxplanCheck();
		// ����ļ����ʹ�С,���������͵�
		if (inputFile == null || inputFile.getFileSize() == 0) {
			// iCheckFormat.checkFile(inputFile,null);
			// request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
			// "�ϴ��ļ�����Ϊ��");
			form.setReInfo("�ϴ��ļ�����Ϊ��");
			return (actionMapping.findForward("batch"));
		}
		iCheckFormat.checkFile(inputFile, null);
		// ����ļ�ÿ�и�ʽ
		String result = "";
		// �ж��Ƿ�Ϊ�Զ������
		if ("2".equals(form.getBatchaction())) {
			result = batchDisposal(inputFile, iCheckFormat, false, true, user);
		} else {
			result = batchDisposal(inputFile, iCheckFormat, false, false, user);
		}
		form.setReInfo(result);
		return (actionMapping.findForward("batch"));
	}

	/**
	 * ��������
	 */
	private String batchDisposal(FormFile file, BaseCheckFormat iCheckFormat,
			boolean iscreate, boolean iscustom, User user) throws Exception {
		InputStream stream = file.getInputStream();
		InputStreamReader read = new InputStreamReader(stream, "gbk");
		BufferedReader rin = new BufferedReader(read);
		String line;
		String filetitle = null;// �ļ�ͷ
		int count = 0;// ��¼��ǰ��鵽������
		StringBuffer result = new StringBuffer("");
		YxPlanDelegate delegate = new YxPlanDelegate();
		try {
			while ((line = rin.readLine()) != null) {
				if (line.trim().length() > 0) {
					++count;
					if (count == 1 && iscustom) {// ����ǵ�һ�и��ļ�ͷ��ֵ
						filetitle = line;
					}
					try {
						// �Զ������
						if (iscustom && count == 1) {
							 checkHead(line);
						}
						if (iscustom && count > 1) {
							line = buildLine(filetitle, line);
							iCheckFormat.checkLine(line, count, iscustom, user);
						}
						// ������ݸ�ʽ
						if (!iscustom || (iscustom && count > 1)) {
							iCheckFormat.checkLine(line, count, iscustom, user);
						}
					} catch (Exception ex) {
						result.append("�� " + count + " ����¼��ʽ����ȷ��"
								+ ex.getMessage() + "\r\n");
						continue;
					}
					// ����Ӫ�����������Ա
					try {
						if (iscreate)
							delegate.doBatchCreate(buildVO(line, user,
									new YxPlanVO()), user);
						else if (!iscustom || (iscustom && count > 1)) {
							String pk=line.substring(0,line.indexOf("|"));
							YxPlanVO vo = delegate.doFindByPk(new Long(pk.trim()), user);
							if(vo==null)
							{
								throw new Exception("Ӫ������ID: "+pk+"�ڿ���в�����");
							}
							delegate.doBatchUpdate(buildVO(line, user, vo),
									user);
						}
					} catch (Exception ex) {
						result.append("�� " + count + " ��" + ex.getMessage()
								+ "\r\n");
						ex.printStackTrace();
					}
				}
			}
		} catch (Exception ex) {

		} finally {
			rin.close();
			read.close();
		}
		if (result.toString().equals(""))
			if (iscreate)
				result.append("��¼��ȫ�������ɹ�");
			else
				result.append("��¼��ȫ�����³ɹ�");
		return result.toString();
	}
	/**
	 * �Զ����޸�ʱ����ļ�ͷ
	 * 
	 * @param filetitle
	 * @param line
	 * @param count
	 * @return 
	 * @throws Exception
	 */
	public void checkHead(String line) throws Exception {
		String batchtile = "Ӫ��������ʶ|Ӫ����������|ȫʡ��ʶ|��������|ͣ������|�����ʶ|�Ƿ���Ҫ�����ײ�|������|�Ƿ�����ԤԼ|�����ô���|��С�Ż�������|�Ż�����ƫ����|����ʱ�䵥Ԫ|��Чʱ�����|Ӫ�����������ʶ|�Ƿ񱸷�|�Ƿ��ӡ������|�Ƿ�����Ż�|�Ƿ�Ӫҵ���Ż�|�Ƿ������Ա�Ż�|��Դ|Ӫ�����|Ӫ���������|�ϴ���ѷ������|�Żݷ�Χ|�ײ�����|�½�۷����ȼ�|�̶��������ʶ|���ⷽ����־|�Ƿ��û�״̬���|�ɰ����û�״̬|�ʷ�˵��|˵��|�Ż�����|�Żݻ������|�ײ���Ч����";
		String []batchtiles=StringUtils.splitPreserveAllTokens(batchtile, "|");
		String []beCheckedLine= StringUtils.splitPreserveAllTokens(line, "|");
		for(int i=0;i<beCheckedLine.length;i++)
		{
			boolean find = false;
			for(int j=0;j<batchtiles.length;j++)
			{
				if ("".equals(beCheckedLine[i].trim())) {
					throw new BusinessException("", "�Զ����ļ�ͷ�в������п�,�����һ��û������");
				}
				if (beCheckedLine[i].trim().equals(batchtiles[j])) {
					find = true;
					continue;
				}
			}
			if (!find) {
				throw new BusinessException("", "�Զ����ļ�ͷ: " + beCheckedLine[i] + " ����ȷ!");
			}
		}
	}
	/**
	 * �Զ����޸�ʱ�����ļ�ͷ�����������޸�һ�µ��ַ���
	 * 
	 * @param filetitle
	 * @param line
	 * @param count
	 * @return String
	 * @throws Exception
	 */
	public String buildLine(String filetitle, String line) throws Exception {
		String result = "";
		// ȫ���ļ�ͷ
		String batchtile = "Ӫ��������ʶ|Ӫ����������|ȫʡ��ʶ|��������|ͣ������|�����ʶ|�Ƿ���Ҫ�����ײ�|������|�Ƿ�����ԤԼ|�����ô���|��С�Ż�������|�Ż�����ƫ����|����ʱ�䵥Ԫ|��Чʱ�����|Ӫ�����������ʶ|�Ƿ񱸷�|�Ƿ��ӡ������|�Ƿ�����Ż�|�Ƿ�Ӫҵ���Ż�|�Ƿ������Ա�Ż�|��Դ|Ӫ�����|Ӫ���������|�ϴ���ѷ������|�Żݷ�Χ|�ײ�����|�½�۷����ȼ�|�̶��������ʶ|���ⷽ����־|�Ƿ��û�״̬���|�ɰ����û�״̬|�ʷ�˵��|˵��|�Ż�����|�Żݻ������|�ײ���Ч����";
		String[] batchtiles = StringUtils
				.splitPreserveAllTokens(batchtile, "|");
		String[] resultline = new String[batchtiles.length];
		try {
			String[] filetitles = StringUtils.splitPreserveAllTokens(filetitle,
					"|");
			String[] lines = StringUtils.splitPreserveAllTokens(line, "|");
			if (filetitles.length == lines.length) {
				for (int i = 0; i < filetitles.length; i++) {
					for (int j = 0; j < batchtiles.length; j++) {
						if (filetitles[i].trim().equals(batchtiles[j].trim())) {
							resultline[j] = lines[i];
						}
					}
				}
			} else {
				throw new BusinessException("", "�������ļ�ͷ���峤�Ȳ�һ��!");
			}
			// ���������ַ���
			for (int i = 0; i < resultline.length; i++) {
				String str = resultline[i] == null ? "" : resultline[i];
				if (i != resultline.length - 1) {
					result = result + str + "|";
				} else {
					result = result + str;
				}

			}
		} catch (Exception e) {
			String msg = e.getMessage();
			e.printStackTrace();
			throw new BusinessException("", msg);

		}
		return result;
	}

	private DictitemDelegate gotDelegate() throws Exception {
		if (dictDelegate == null) {
			return new DictitemDelegate();
		} else {
			return dictDelegate;
		}
	}

	/**
	 * �����ַ�������YxPlanVO
	 * 
	 * @param fields
	 * @param user
	 * @return
	 * @throws Exception
	 *             Ӫ��������ʶ0|Ӫ����������1|ȫʡ��ʶ2|��������3|ͣ������4|�����ʶ5|
	 *             �Ƿ���Ҫ�����ײ�8|������9|�Ƿ�����ԤԼ10|�����ô���11|��С�Ż�������12|�Ż�����ƫ����13|
	 *             ����ʱ�䵥Ԫ14|��Чʱ�����15|Ӫ�����������ʶ16|�Ƿ񱸷�17|�Ƿ��ӡ������18|
	 *             �Ƿ�����Ż�19|�Ƿ�Ӫҵ���Ż�20|�Ƿ������Ա�Ż�21|��Դ22|Ӫ�����23|
	 *             Ӫ���������24|�ϴ���ѷ������25|@���ⷽ����־26@|�Żݷ�Χ27| *�¼��ֶ�:05-11* 28
	 *             �ײ�����|29 �½�۷����ȼ�| �̶��������ʶ30|�ʷ�˵��31|˵��32|�Ż�����33
	 *             ������Ѷ�6|������ѿ�Խ����7|
	 */
	public YxPlanVO buildVO(String line, User user,YxPlanVO result) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			String[] fields = StringUtils.splitPreserveAllTokens(line, "|");
			if(hasValue(fields[0]))
			result.setYxplanid(new Long(fields[0].trim()));// Ӫ��������ʶ
			if(hasValue(fields[1]))
			result.setYxplanname(fields[1].trim());// Ӫ����������
			if(hasValue(fields[2]))
			result.setYxplancode(fields[2].trim());// ȫʡ��ʶ
			if (!"".equals(fields[3].trim())) {
				result.setStartdate(format.parse(fields[3].trim()));// ��������
			}
			if (!"".equals(fields[4].trim())) {
				result.setStopdate(format.parse(fields[4].trim()));// ͣ������
			}
			result.setCheckercode(user.getOpercode());// �����˹���
			result.setOperatorcode(user.getOpercode());// ����Ա����
			if (fields[5].trim().length() > 0)
				result.setAreacode(fields[5].trim());// �����ʶ
//			if (fields[6].trim().length() > 0)
//				result.setMinconsume(new Double(fields[6].trim()));// ������Ѷ�
//			if (fields[7].trim().length() > 0)
//				result.setConsumecycle(new Long(fields[7].trim()));// ������ѿ�Խ����
			if (fields[8-2].trim().length() > 0)
				result.setBindpackageflag(new Byte(fields[8-2].trim()));// �Ƿ���Ҫ�����ײ�
			if (fields[9-2].trim().length() > 0)
				result.setBindmonths(new Long(fields[9-2].trim()));// ������
			if (fields[10-2].trim().length() > 0)
				result.setBookflag(new Byte(fields[10-2].trim()));// �Ƿ�����ԤԼ
			// if (fields[11].trim().length()>0) result.setRcprepayflag(new
			// Byte(fields[11]));//�Ƿ�Ԥ������
			if (fields[11-2].trim().length() > 0)
				result.setCouldusetimes(new Long(fields[11-2].trim()));// �����ô���
			if (fields[12-2].trim().length() > 0)
				result.setMindisccycle(new Long(fields[12-2].trim()));// ��С�Ż�������
			if (fields[13-2].trim().length() > 0)
				result.setDiscoffset(new Long(fields[13-2].trim()));// �Ż�����ƫ����
			if (fields[14-2].trim().length() > 0)
				result.setTimeunit(fields[14-2].trim());// ����ʱ�䵥Ԫ
			if (fields[15-2].trim().length() > 0)
				result.setStarttimetype(new Byte(fields[15-2].trim()));// ��Чʱ�����
			if (fields[16-2].trim().length() > 0)
				result.setYxplangroupid(new Long(fields[16-2].trim()));// Ӫ�����������ʶ
			result.setGroupflag(new Byte("0"));// �Ƿ�Ӫ��������
			if (fields[17-2].trim().length() > 0)
				result.setBackupflag(new Byte(fields[17-2].trim()));// �Ƿ񱸷�
			if (fields[18-2].trim().length() > 0)
				result.setPrintflag(new Byte(fields[18-2].trim()));// �Ƿ��ӡ������
			if (fields[19-2].trim().length() > 0)
				result.setFeecalcprivflag(new Byte(fields[19-2].trim()));// �Ƿ�����Ż�
			if (fields[20-2].trim().length() > 0)
				result.setRecfeeprivflag(new Byte(fields[20-2].trim()));// �Ƿ�Ӫҵ���Ż�
			// if (fields[22].trim().length()>0) result.setStopuserrentflag(new
			// Byte(fields[22]));//ͣ��״̬�Ƿ���ȡ�����
			if (fields[21-2].trim().length() > 0)
				result.setIsoutmemberpriv(new Byte(fields[21-2].trim()));// �Ƿ������Ա�Ż�
			if (fields[22-2].trim().length() > 0)
				result.setSource(fields[22].trim());// ��Դ
			if (fields[23-2].trim().length() > 0)
				result.setSalestype(new Long(fields[23-2].trim()));// Ӫ�����
			if (fields[24-2].trim().length() > 0)
				result.setPlankind(fields[24-2].trim());// Ӫ���������
			if (fields[24-2].trim().length() > 0) {
				result.setPlanbigkind(getDescription(fields[24-2].trim(), user));
			} else if ("".equals(fields[24-2].trim())) {
				result.setPlanbigkind(null);
			}
			if (fields[25-2].trim().length() > 0)
				result.setUploadcalcfeekind(new Byte(fields[25-2].trim()));// �ϴ���ѷ������
			if (fields[26-2].trim().length() > 0)
				result.setDiscscope(fields[26-2].trim());// �Żݷ�Χ
			// 5-11 add
			if (fields[27-2].trim().length() > 0)
				result.setPlantype(fields[27-2].trim());// �Żݷ�Χ
			if (fields[28-2].trim().length() > 0)
				result.setFeeprio(new Byte(fields[28-2].trim()));// �Żݷ�Χ
			if (fields[29-2].trim().length() > 0)
				result.setFixfeespecflag(fields[29-2].trim());// �̶��������ʶ
			if (fields[30-2].trim().length() > 0)
				result.setSpecialflag(fields[30-2].trim());// ���ⷽ����־

			// �����Ƿ��û�״̬���&�ɰ����û�״̬���
			if (fields[31-2].trim().length() > 0)
				result.setCheckus(new Short(fields[31-2].trim()));// �Ƿ��û�״̬���
			if (fields[32-2].trim().length() > 0)
				result.setUserstausflag(fields[32-2].trim());// �ɰ����û�״̬

			if (fields[33-2].trim().length() > 0)
				result.setFeecomment(fields[33-2].trim());// �ʷ�˵��
			if (fields[34-2].trim().length() > 0)
				result.setRemark(fields[34-2].trim());// ˵��
			if(fields[33].trim().length()>0)
				result.setPrivelgepro(fields[33].trim());
			if(fields[34].trim().length()>0)
				result.setYxplanshortname(fields[34].trim());
			if(fields[35].trim().length()>0)
				result.setUsedbillcyc(Long.valueOf(fields[35].trim()));
			return result;
		} catch (Exception e) {
			String msg = "�ڲ�����buildVO��װ�쳣!" + e.getMessage();
			e.printStackTrace();
			throw new BusinessException("", msg);

		}
	}

	private Short getDescription(String dictid, User user) throws Exception {
		DictitemListVO listVO = new DictitemListVO();
		listVO.set_se_dictid(dictid);
		listVO.set_se_groupid("PC_YXPLANKIND");
		Collection col = gotDelegate().doQuery(listVO, user).getDatas();
		Iterator it = col.iterator();
		if (it.hasNext()) {
			DictitemVO dictVO = (DictitemVO) it.next();
			return new Short(dictVO.getDescription());
		} else {
			throw new Exception("�̶�����[Ӫ���������]��ֵ: " + dictid + " ����ȷ:");
		}

	}

	/**
	 * ���̶�����[���ⷽ����־]$PC_SPECIALPLANΪһ������
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public String[] listName(User user, String ValueOrName) throws Exception {
		String[] strResult;
		DictitemListVO listVO = new DictitemListVO();
		listVO.set_se_groupid("PC_SPECIALPLAN");
		listVO.set_orderby("dictid");
		listVO.set_desc("0");
		DataPackage dataPack = gotDelegate().doQuery(listVO, user);
		if (dataPack.getRowCount() >= 0) {
			Collection col = dataPack.getDatas();
			Iterator it = col.iterator();
			strResult = new String[dataPack.getRowCount()];
			if ("value".equals(ValueOrName)) {
				for (int i = 0; i < dataPack.getRowCount(); i++) {
					strResult[i] = ((DictitemVO) it.next()).getDictid();
				}
			} else if ("name".equals(ValueOrName))
				for (int i = 0; i < dataPack.getRowCount(); i++) {
					strResult[i] = ((DictitemVO) it.next()).getDictname();
				}
			else {
				throw new BusinessException("", "���ò������ݴ���!");
			}
			return strResult;
		} else {
			throw new BusinessException("", "�̶�����[���ⷽ����־]û��ֵ!");
		}

	}

	/**
	 * ȡֵ
	 * 
	 * @param user
	 * @throws Exception
	 */
	private void getValues(User user) throws Exception {
		if (this.specialflagValue == null) {
			this.specialflagValue = listName(user, "value");
		}
		if (this.specialflagName == null) {
			this.specialflagName = listName(user, "name");
		}
	}

	/**
	 * �Ѵ���checkBox��ֵ���⴦��һ��,��ԭ [���ⷽ����־]ֵ��ԭ����λ�ò��Ұѿ�λ�������" " ֵ
	 * 
	 * @param aStr
	 * @return
	 */
	private String[] revertValues(String aStr) {
		if (aStr != null) {
			String strTmp[] = StringUtils.split(aStr, ",");
			String result[] = new String[this.specialflagValue.length];
			for (int i = 0; i < this.specialflagValue.length; i++) {
				boolean abool = false;
				for (int j = 0; j < strTmp.length; j++) {
					if (this.specialflagValue[i].equals(strTmp[j])) {
						result[i] = specialflagValue[i];
						abool = true;
					}
				}
				if (!abool) {
					result[i] = " ";
				}
				abool = false;
			}
			return result;
		} else {
			String[] strNoValues = new String[this.specialflagValue.length];
			return strNoValues;
		}

	}

	/*
	 * ���ε�����ʱ�ٷſ� protected void getContentVO(HttpServletRequest request, User
	 * user, ActionForm actionForm) throws Exception {
	 * 
	 * String pk = request.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK); if
	 * (pk == null) throw new NullPointerException("pk is required."); YxPlanVO
	 * contentVO = (YxPlanVO) (getContentVO(request, user)); if (contentVO ==
	 * null) throw new NullPointerException("VO not found, pk " + pk + " of " +
	 * ClassUtils.getShortClassName(actionForm.getClass())); YxPlanActionForm
	 * form = (YxPlanActionForm) actionForm; // ��ԭ[���ⷽ����־]��ֵ getValues(user);
	 * form.setSpecialflagName(this.specialflagName);
	 * request.setAttribute("VALUE", this.specialflagValue); String[] strResult =
	 * revertValues(contentVO.getSpecialflag());
	 * form.setSelectSpecialflag(strResult);
	 * BeanUtils.copyProperties(actionForm, contentVO); }
	 */
	/**
	 * ����[���ⷽ����־]
	 * 
	 * @param values
	 * @param user
	 * @return
	 * @throws Exception
	 */
	private String transSpecialFlag(String values, User user) throws Exception {
		getValues(user);
		String result = "";
		if (values != null) {
			String strValue[] = StringUtils.split(values, ",");
			for (int i = 0; i < strValue.length; i++) {
				for (int j = 0; j < this.specialflagValue.length; j++) {
					if (this.specialflagValue[j].equals(strValue[i])) {
						result = result + this.specialflagName[j] + ",";
					}
				}
			}
			return result.substring(0, result.length() - 1);
		} else {
			return "";
		}
	}

	/**
	 * ȡ��dp��ֵ��������
	 * 
	 * @param dp
	 * @param user
	 * @return
	 * @throws Exception
	 */
	private DataPackage dealDate(DataPackage dp, User user) throws Exception {
		DataPackage dp2 = new DataPackage();
		dp2.setPageNo(dp.getPageNo());
		dp2.setPageSize(dp.getPageSize());
		dp2.setRowCount(dp.getRowCount());
		Collection col = dp.getDatas();
		Iterator it = col.iterator();
		Collection col2 = new ArrayList();
		while (it.hasNext()) {
			YxPlanVO vo = (YxPlanVO) it.next();
			if (vo.getSpecialflag() != null
					&& !"".equals(vo.getSpecialflag().trim())) {
				vo.setSpecialflag(transSpecialFlag(vo.getSpecialflag(), user));
			}
			col2.add(vo);
		}
		dp2.setDatas(col2);
		return dp2;
	}

	public ActionForward doChangebig(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		YxPlanActionForm form = (YxPlanActionForm) actionForm;
		request.setAttribute("FLAG", form.get_ne_planbigkind());
		if (AAUtils.isAjaxRequest(request)) {
			AAUtils.addZonesToRefresh(request, "big");
		}
		return (actionMapping.findForward("list"));
	}

	public ActionForward doChangebig2(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		YxPlanActionForm form = (YxPlanActionForm) actionForm;
		request.setAttribute("FLAG", form.getPlanbigkind());
		if (AAUtils.isAjaxRequest(request)) {
			AAUtils.addZonesToRefresh(request, "big");
		}
		return (actionMapping.findForward("content"));
	}
	public static void main(String []args)
	{
		String str="Ӫ��������ʶ|Ӫ����������|ȫʡ��ʶ|��������|ͣ������|�����ʶ|�Ƿ���Ҫ�����ײ�|������|�Ƿ�����ԤԼ|�����ô���|��С�Ż�";
		String pk=str.substring(0,str.indexOf("|"));
		System.out.println(str.indexOf("|"));
		System.out.println(pk);
	}
	private boolean hasValue(String str)
	{
		return !StringUtils.isBlank(str);
	}
}
