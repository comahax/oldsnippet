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
		//以下几个方法是必须的 
		//指定VO类   
		setVoClass(EmployeeVO.class);
		//指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称 
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

			//区分地市
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
			//查询是否在计酬中
			DictparamDelegate param=new DictparamDelegate();
			DictparamVO paramVO=new DictparamVO();
			paramVO.setDkey("BBC_ISREWARDING");
			paramVO.setDvalue("1");
			paramVO=param.doFindByPk(paramVO, user);
			if(paramVO!=null){
				request.setAttribute("CALC","TRUE");
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "系统正在计酬，计酬期间系统暂不支持新增/修改操作");
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
		
		// 20111201 add by liuchao 根据导入的每行手机号码的值在im_pr_nores表中查询
//		NoresDelegate noresDelegate=new NoresDelegate();
//		NoresListVO noresListVO=new NoresListVO();
//		noresListVO.set_se_mobileno(form.getTelephone());
//		DataPackage noreDataPackage = noresDelegate.doQuery(noresListVO, user);
//		if(noreDataPackage.getRowCount()==0){
//			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
//			"手机号码有误,不在号码表中");
//			return (actionMapping.findForward("content"));
//		}
		
		EmployeeDelegate eDelegate = new EmployeeDelegate();
		EmployeeVO evo = new EmployeeVO();
		BeanUtils.copyProperties(evo, form);
		try {
			String cmdState = ((BaseActionForm) actionForm).getCmdState();
			if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {// 更新
				evo=eDelegate.doUpdateWaypro(evo, user);
			} else {
				eDelegate.doCreateWaypro(evo, user);
			}
			if (eDelegate.doMessage(user)) {
				if ((WebConstant.COMMAND_STRING_EDIT.equals(cmdState)
						&& evo.isChanged() == true) ||
						(WebConstant.COMMAND_STRING_NEW.equals(cmdState))) {
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							"数据正等待用户确认,如需查询,请点击'短信二次确认数据查询'!");
				} else {
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							"保存成功!");
				}
			} else {
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
						"保存成功!");
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
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "数据正等待用户确认,如需查询,请点击'短信二次确认数据查询'!");
		}else
		{
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "操作成功!");
		}
		return this.doList(actionMapping, actionForm, request, response, user);
	}
	
	/*
	 *后台文件导出
	 */
	public ActionForward doDownload2(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		try {
			String chCityid = SessionFactoryRouter.conversionCityid(user
					.getCityid());
			if (chCityid == null || "".equals(chCityid)) {
				throw new Exception("该工号不属于任何地市！");
			}
			String filename = getFilePath2(actionForm, user, request);
			// filename = request.getParameter("down");
			if (filename == null || "".equals(filename.trim())) {
				throw new Exception("文件路径为空！");
			}
			FtpInfo ftpInfo =null;
			ftpInfo = ResPubUtil.getFtpInfo(user);
				 
			FtpAccess ftp = new FtpAccess(ftpInfo);
			String localPath = FtpBusUtils.getDownloadRealPath(servlet);
			ftp.ftp.setFileType(ftp.ftp.BINARY_FILE_TYPE);
			localPath = ftp.downloadFile(localPath, filename);
			if (localPath == null) {
				throw new Exception("服务器文件不存在，下载失败！" + ftp.ftp.getReplyString());
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
//		参数说明：@filebasepath@是动态参数，可以查参数表ch_adt_dictparam；@cityid@是地市标识，例如江门的cityid是JM；@yyyymm@是结算月份，可供选择。
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
			throw new Exception("服务器路径系统参数不存在，请核对！");
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
		export.setFileName("推广专员信息");
		export.appendHeadLine(new String[] { "导出工号:", user.getOpercode() });
		export.appendHeadLine(new String[] { "导出时间",
				format.format(new Date(System.currentTimeMillis())) });
		export.addOutputProperty("employeeid", "人员编码");
		export.addOutputProperty("wayid", "所属渠道编码");
		export.addOutputProperty("employeename", "人员姓名");
		export.addOutputProperty("isnet", "人员类型", CommonExportBean.CODE2NAME,
				"$CH_ISNET");
//		export.addOutputProperty("subname", "人员代号");
		export.addOutputProperty("empstatus", "状态", CommonExportBean.CODE2NAME,
				"$CH_EMPSTATUS");
//		export.addOutputProperty("cardid", "身份证号码");
		export.addOutputProperty("telephone", "手机号码");
		export.addOutputProperty("pvtemail", "个人电子邮箱");
		export.addOutputProperty("intime", "启用日期", CommonExportBean.DATE,
				"yyyy-MM-dd");
		export.addOutputProperty("outtime", "停用日期", CommonExportBean.DATE,
				"yyyy-MM-dd");
		export.addOutputProperty("state", "是否加入数据业务运营渠道",
				CommonExportBean.CODE2NAME, "#ISUNPB");
		export.addOutputProperty("istenseed", "是否加入十万种子",
				CommonExportBean.CODE2NAME, "#IS_UNV_YN");
		export.addOutputProperty("isinternal", "是否内部员工",
				CommonExportBean.CODE2NAME, "#IS_UNV_YN");
		export.addOutputProperty("emplevel", "专员层级",
				CommonExportBean.CODE2NAME, "$CH_BBCUNPBLEVEL");
		export.addOutputProperty("empattr", "专员属性",
				CommonExportBean.CODE2NAME, "#EMPROLE");
		export.addOutputProperty("empattrmemo", "专员身份注释");
		export.addOutputProperty("cityid", CommonExportBean.CODE2NAME,
		"#CITYCOMPANY");
		export.addOutputProperty("regdate", "注册日期", CommonExportBean.DATE,
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
		export.writeTxtTitle(response.getOutputStream(), new String[] { "人员编码",
				"所属渠道编码", "人员姓名", "人员类型", "状态",  "手机号码",
				"个人电子邮箱", "启用日期", "停用日期", "是否加入数据业务运营渠道", "是否加入十万种子计划", "是否内部员工",
				"专员层级","专员身份","专员身份注释","地市","注册日期","成员属性" });

		BaseActionForm baseActionForm = (BaseActionForm) actionForm;
		baseActionForm.set_orderby("employeeid");

		WayproemployeeForm form = (WayproemployeeForm) actionForm;
		//选择全部地市
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