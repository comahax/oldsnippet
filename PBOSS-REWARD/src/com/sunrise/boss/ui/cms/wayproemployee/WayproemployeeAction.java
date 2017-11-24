/**
 * auto-generated code
 * Sat Aug 26 10:46:06 CST 2006
 */
package com.sunrise.boss.ui.cms.wayproemployee;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.audit.common.CityIDMap;
import com.sunrise.boss.business.cms.bbc.bbcemplevel.persistent.BbcEmplevelVO;
import com.sunrise.boss.business.cms.chadtdictparam.persistent.ChAdtDictparamListVO;
import com.sunrise.boss.business.cms.chadtdictparam.persistent.ChAdtDictparamVO;
import com.sunrise.boss.business.cms.dictparam.persistent.DictparamVO;
import com.sunrise.boss.business.cms.empconfirm.persistent.EmpconfirmVO;
import com.sunrise.boss.business.cms.employee.persistent.EmployeeListVO;
import com.sunrise.boss.business.cms.employee.persistent.EmployeeVO;
import com.sunrise.boss.business.cms.employee.persistent.VEmployeeVO;
import com.sunrise.boss.business.cms.empmodel.persistent.EmpmodelListVO;
import com.sunrise.boss.business.cms.empmodel.persistent.EmpmodelVO;
import com.sunrise.boss.business.cms.nores.persistent.NoresListVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.cms.waycompact.persistent.WaycompactListVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamListVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.bbc.bbcemplevel.BbcEmplevelDelegate;
import com.sunrise.boss.delegate.cms.chadtdictparam.ChAdtDictparamDelegate;
import com.sunrise.boss.delegate.cms.dictparam.DictparamDelegate;
import com.sunrise.boss.delegate.cms.empconfirm.EmpconfirmDelegate;
import com.sunrise.boss.delegate.cms.employee.EmployeeDelegate;
import com.sunrise.boss.delegate.cms.empmodel.EmpmodelDelegate;
import com.sunrise.boss.delegate.cms.nores.NoresDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.cms.waycompact.WaycompactDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.delegate.common.sysparam.SysparamDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.cms.employee.EmployeeForm;
import com.sunrise.boss.ui.cms.reward.rewardrecord.RewardrecordForm;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.ftp.FtpAccess;
import com.sunrise.boss.ui.commons.ftp.FtpBusUtils;
import com.sunrise.boss.ui.commons.ftp.FtpInfo;
import com.sunrise.boss.ui.resmanage.common.ResPubUtil;

/**
 * <p>Title: WayseatdetAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class WayproemployeeAction extends BaseDelegateAction {

	public WayproemployeeAction() {
		//���¼��������Ǳ���� 
		//ָ��VO��   
		setVoClass(EmployeeVO.class);
		//ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ����� 
		this.pkNameArray = new String[1];
		pkNameArray[0] = "employeeid";
	}

	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		Page.setPageSize(request, (BaseActionForm) actionForm);
		try {
			WayproemployeeForm form = (WayproemployeeForm) actionForm;
			EmployeeListVO eListvo = new EmployeeListVO();
			setListVO(eListvo, form);
			if(eListvo.get_dnl_regdate()!=null && !("".equals(eListvo.get_dnl_regdate())))
				eListvo.set_dnl_regdate(eListvo.get_dnl_regdate()+" 00:00:00");
			if(eListvo.get_dnm_regdate()!=null && !("".equals(eListvo.get_dnm_regdate())))
				eListvo.set_dnm_regdate(eListvo.get_dnm_regdate()+" 23:59:59");

			//���ֵ���
			String citycompid = form.get_ne_citycompid();
			User userNew = null;
			if (!StringUtils.isEmpty(citycompid) && !citycompid.equals("all")) {
				userNew = new User();
				BeanUtils.copyProperties(userNew, user);
				userNew.setCityid(SessionFactoryRouter
						.conversionCityid2Num(citycompid));
			} else {
				userNew = user;
			}
			//��ѯ�Ƿ��ڼƳ���
			DictparamDelegate param=new DictparamDelegate();
			DictparamVO paramVO=new DictparamVO();
			paramVO.setDkey("BBC_ISREWARDING");
			paramVO.setDvalue("1");
			paramVO=param.doFindByPk(paramVO, user);
			if(paramVO!=null){
				request.setAttribute("CALC","TRUE");
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "ϵͳ���ڼƳ꣬�Ƴ��ڼ�ϵͳ�ݲ�֧������/�޸Ĳ���");
			}
			EmployeeDelegate delegate = new EmployeeDelegate();
			DataPackage dp = delegate.doWayproemployeeQuery(eListvo, userNew);

			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return actionMapping.findForward("list");
	}

	public ActionForward doEdit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		WayproemployeeForm form = (WayproemployeeForm) actionForm;
		try {
			String employeeid = request
					.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
			EmployeeDelegate eDelegate = new EmployeeDelegate();
			BeanUtils.copyProperties(form, eDelegate.doFindByPk(employeeid,
					user));

			EmpmodelDelegate empDelegate = new EmpmodelDelegate();
			EmpmodelListVO empListvo = new EmpmodelListVO();
			empListvo.set_se_employeeid(((EmployeeForm) actionForm)
					.getEmployeeid());
			empListvo.set_se_model("3");
			empListvo.set_ne_state("0");
			DataPackage empDp = empDelegate.doQuery(empListvo, user);
			if (empDp.getDatas() != null && empDp.getDatas().size() != 0) {
				((EmployeeForm) actionForm).setIsunpb(true);
			} else {
				((EmployeeForm) actionForm).setIsunpb(false);
			}
			BbcEmplevelDelegate emplevelDelegate = new BbcEmplevelDelegate();
			BbcEmplevelVO belVO = new BbcEmplevelVO();
			belVO.setEmployeeid(employeeid);
			belVO = emplevelDelegate.doFindByPk(belVO.getEmployeeid(), user);
			if (belVO == null) {
				form.setEmplevel("");
			} else {
				form.setEmplevel(belVO.getEmplevel());
			}
			String command = getCommandString(request);
			form.setCmdState(command);
			request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
					WebConstant.COMMAND_STRING_EDIT);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return (actionMapping.findForward("content"));
	}

	public ActionForward doNew(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		WayproemployeeForm form = (WayproemployeeForm) actionForm;
		Date date = new Date(System.currentTimeMillis());
		Date limitDate = new Date(199, 11, 31);
		form.setIntime(date);
		form.setOuttime(limitDate);
		form.setRegdate(date);
		return super.doNew(actionMapping, actionForm, request, response, user);
	}

	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		WayproemployeeForm form = (WayproemployeeForm) actionForm;
		
		// 20111201 add by liuchao ���ݵ����ÿ���ֻ������ֵ��im_pr_nores���в�ѯ
//		NoresDelegate noresDelegate=new NoresDelegate();
//		NoresListVO noresListVO=new NoresListVO();
//		noresListVO.set_se_mobileno(form.getTelephone());
//		DataPackage noreDataPackage = noresDelegate.doQuery(noresListVO, user);
//		if(noreDataPackage.getRowCount()==0){
//			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
//			"�ֻ���������,���ں������");
//			return (actionMapping.findForward("content"));
//		}
		
		EmployeeDelegate eDelegate = new EmployeeDelegate();
		EmployeeVO evo = new EmployeeVO();
		BeanUtils.copyProperties(evo, form);
		try {
			String cmdState = ((BaseActionForm) actionForm).getCmdState();
			if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {// ����
				evo=eDelegate.doUpdateWaypro(evo, user);
			} else {
				eDelegate.doCreateWaypro(evo, user);
			}
			if (eDelegate.doMessage(user)) {
				if ((WebConstant.COMMAND_STRING_EDIT.equals(cmdState)
						&& evo.isChanged() == true) ||
						(WebConstant.COMMAND_STRING_NEW.equals(cmdState))) {
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							"�������ȴ��û�ȷ��,�����ѯ,����'���Ŷ���ȷ�����ݲ�ѯ'!");
				} else {
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							"����ɹ�!");
				}
			} else {
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
						"����ɹ�!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return actionMapping.findForward("content");
	}

	public ActionForward doDelete(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
		EmployeeDelegate eDelegate = new EmployeeDelegate();
		EmpmodelDelegate mDelegate = new EmpmodelDelegate();
		for (int i = 0; i < selectArray.length; i++) {
			EmployeeVO vo = (EmployeeVO) eDelegate.doFindByPk(selectArray[i],
					user);
			if (vo.getEmpstatus().shortValue() == 0) {
				vo.setEmpstatus(new Short("1"));
				eDelegate.doUpdateWaypro(vo, user);
			}
			EmpmodelListVO mListvo = new EmpmodelListVO();
			mListvo.set_se_employeeid(selectArray[i]);
			mListvo.set_se_model("3");
		}
		if(eDelegate.doMessage(user)){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "�������ȴ��û�ȷ��,�����ѯ,����'���Ŷ���ȷ�����ݲ�ѯ'!");
		}else
		{
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "�����ɹ�!");
		}
		return this.doList(actionMapping, actionForm, request, response, user);
	}
	
	/*
	 *��̨�ļ�����
	 */
	public ActionForward doDownload2(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		try {
			String chCityid = SessionFactoryRouter.conversionCityid(user
					.getCityid());
			if (chCityid == null || "".equals(chCityid)) {
				throw new Exception("�ù��Ų������κε��У�");
			}
			String filename = getFilePath2(actionForm, user, request);
			// filename = request.getParameter("down");
			if (filename == null || "".equals(filename.trim())) {
				throw new Exception("�ļ�·��Ϊ�գ�");
			}
			FtpInfo ftpInfo =null;
			ftpInfo = ResPubUtil.getFtpInfo(user);
				 
			FtpAccess ftp = new FtpAccess(ftpInfo);
			String localPath = FtpBusUtils.getDownloadRealPath(servlet);
			ftp.ftp.setFileType(ftp.ftp.BINARY_FILE_TYPE);
			localPath = ftp.downloadFile(localPath, filename);
			if (localPath == null) {
				throw new Exception("�������ļ������ڣ�����ʧ�ܣ�" + ftp.ftp.getReplyString());
			}
			request.setAttribute("filename", FtpBusUtils.getDownloadFilename(
					servlet, filename.trim()));
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			return doList(actionMapping, actionForm, request, response, user);
		}
		return (actionMapping.findForward("down"));
	}
	
	private java.util.Date getDefaultDate(int i) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, i);
		return c.getTime();
	}
	
	private String getFilePath2(ActionForm actionForm,User user,
			HttpServletRequest request)throws Exception{
//		@filebasepath@/adt/@cityid@/src/collect/boss/statements/statements_@cityid@_@yyyymm@.gz
//		����˵����@filebasepath@�Ƕ�̬���������Բ������ch_adt_dictparam��@cityid@�ǵ��б�ʶ�����罭�ŵ�cityid��JM��@yyyymm@�ǽ����·ݣ��ɹ�ѡ��
//	@bbc_filebasepath@/bbc/@bbc_cityid@/std/collect/sell/employee_all_@yyyymm@.tar.gz
		
		StringBuffer filepath=new StringBuffer("");
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		String month=format.format(this.getDefaultDate(-1));
		String chCityid=SessionFactoryRouter.conversionCityid(user.getCityid());
		
		ChAdtDictparamDelegate chAdtdictparamDelegate = new ChAdtDictparamDelegate();
		ChAdtDictparamListVO listvo = new ChAdtDictparamListVO();
		listvo.set_se_dkey("bbc_filebasepath");
		DataPackage dp = chAdtdictparamDelegate.doQuery(listvo, user);
		if(dp.getRowCount()==0)
		{
			throw new Exception("������·��ϵͳ���������ڣ���˶ԣ�");
		}
		String path = ((ChAdtDictparamVO)((List)dp.getDatas()).get(0)).getDvalue();
		filepath.append(path);
		
		filepath.append("/bbc/gd/std/collect/sell/");
		filepath.append("employee_all_");
		filepath.append(month);
		filepath.append(".tar.gz");
		return filepath.toString();
		
	}

	public ActionForward doImport(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		return actionMapping.findForward("batch");
	}

	public ActionForward doTxt(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�ƹ�רԱ��Ϣ");
		export.appendHeadLine(new String[] { "��������:", user.getOpercode() });
		export.appendHeadLine(new String[] { "����ʱ��",
				format.format(new Date(System.currentTimeMillis())) });
		export.addOutputProperty("employeeid", "��Ա����");
		export.addOutputProperty("wayid", "������������");
		export.addOutputProperty("employeename", "��Ա����");
		export.addOutputProperty("isnet", "��Ա����", CommonExportBean.CODE2NAME,
				"$CH_ISNET");
//		export.addOutputProperty("subname", "��Ա����");
		export.addOutputProperty("empstatus", "״̬", CommonExportBean.CODE2NAME,
				"$CH_EMPSTATUS");
//		export.addOutputProperty("cardid", "���֤����");
		export.addOutputProperty("telephone", "�ֻ�����");
		export.addOutputProperty("pvtemail", "���˵�������");
		export.addOutputProperty("intime", "��������", CommonExportBean.DATE,
				"yyyy-MM-dd");
		export.addOutputProperty("outtime", "ͣ������", CommonExportBean.DATE,
				"yyyy-MM-dd");
		export.addOutputProperty("state", "�Ƿ��������ҵ����Ӫ����",
				CommonExportBean.CODE2NAME, "#ISUNPB");
		export.addOutputProperty("istenseed", "�Ƿ����ʮ������",
				CommonExportBean.CODE2NAME, "#IS_UNV_YN");
		export.addOutputProperty("isinternal", "�Ƿ��ڲ�Ա��",
				CommonExportBean.CODE2NAME, "#IS_UNV_YN");
		export.addOutputProperty("emplevel", "רԱ�㼶",
				CommonExportBean.CODE2NAME, "$CH_BBCUNPBLEVEL");
		export.addOutputProperty("empattr", "רԱ����",
				CommonExportBean.CODE2NAME, "#EMPROLE");
		export.addOutputProperty("empattrmemo", "רԱ���ע��");
		export.addOutputProperty("cityid", CommonExportBean.CODE2NAME,
		"#CITYCOMPANY");
		export.addOutputProperty("regdate", "ע������", CommonExportBean.DATE,
		"yyyy-MM-dd");
		export.addOutputProperty("empattr2", CommonExportBean.CODE2NAME,
		"$CH_EMPATTR2");
		export.voClassArray = new Class[] { VEmployeeVO.class };
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(
				fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain");
		export.writeTxtTitle(response.getOutputStream(), new String[] { "��Ա����",
				"������������", "��Ա����", "��Ա����", "״̬",  "�ֻ�����",
				"���˵�������", "��������", "ͣ������", "�Ƿ��������ҵ����Ӫ����", "�Ƿ����ʮ�����Ӽƻ�", "�Ƿ��ڲ�Ա��",
				"רԱ�㼶","רԱ���","רԱ���ע��","����","ע������","��Ա����" });

		BaseActionForm baseActionForm = (BaseActionForm) actionForm;
		baseActionForm.set_orderby("employeeid");

		WayproemployeeForm form = (WayproemployeeForm) actionForm;
		//ѡ��ȫ������
		String citycompid = form.get_ne_citycompid();
		if (null != citycompid && citycompid.equals("all")) {
			Map cityidMap = SessionFactoryRouter.getCityidMap();
			String citynum = "";
			Map cityidMap2 = new HashMap();
			cityidMap2.put("750", "1");
			cityidMap2.put("756", "2");
			cityidMap2.put("755", "3");
			cityidMap2.put("757", "4");
			cityidMap2.put("754", "5");
			cityidMap2.put("752", "6");
			cityidMap2.put("759", "7");
			cityidMap2.put("758", "8");
			cityidMap2.put("751", "9");
			cityidMap2.put("753", "10");
			cityidMap2.put("769", "11");
			cityidMap2.put("760", "12");
			cityidMap2.put("668", "13");
			cityidMap2.put("660", "14");
			cityidMap2.put("768", "15");
			cityidMap2.put("663", "16");
			cityidMap2.put("662", "17");
			cityidMap2.put("763", "18");
			cityidMap2.put("762", "19");
			cityidMap2.put("766", "20");
			cityidMap2.put("200", "21");
			for (Iterator iter = cityidMap2.keySet().iterator(); iter.hasNext();) {
				citynum = (String) iter.next();
				User userTemp = new User();
				BeanUtils.copyProperties(userTemp, user);
				userTemp.setCityid(citynum);
				super.ExportQuery(actionMapping, actionForm, request, response,
						userTemp, export);
			}
		} else {
			super.ExportQuery(actionMapping, actionForm, request, response,
					user, export);
		}
		return actionMapping.findForward(null);
	}
}