/**
 * auto-generated code
 * Wed Jul 08 11:39:56 CST 2009
 */
 package com.gmcc.pboss.web.channel.employee;

import java.text.SimpleDateFormat;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.channel.citycompany.CitycompanyVO;
import com.gmcc.pboss.business.channel.cntycompany.CntycompanyVO;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.channel.empmodel.EmpmodelVO;
import com.gmcc.pboss.business.channel.way.AGWayVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.common.export.ExportDataCreator;
import com.gmcc.pboss.control.base.operator.Operator;
import com.gmcc.pboss.control.base.operator.OperatorBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.citycompany.Citycompany;
import com.gmcc.pboss.control.channel.citycompany.CitycompanyBO;
import com.gmcc.pboss.control.channel.cntycompany.Cntycompany;
import com.gmcc.pboss.control.channel.cntycompany.CntycompanyBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.nosect.Nosect;
import com.gmcc.pboss.control.channel.nosect.NosectBO;
import com.gmcc.pboss.control.channel.way.AGWay;
import com.gmcc.pboss.control.channel.way.AGWayBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.channel.way.WayDelegate;
import com.opensymphony.xwork2.ActionContext;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;


/**
 * <p>Title: EmployeeAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class EmployeeAction extends BaseAction{
	private String processType;//处理类型 MANAGER:渠道经理管理
	// 系统参数：社会渠道人员管理批量业务
	private String param92;
	
	/**社会渠道人员批量导出的可选字段*/
	private String[][] employeeOptionFeilds = new String[][] {
			{"employeeid", "人员编号",null,""},{"employeename", "姓名",null,""},{"birthday", "出生年月",ExportDataCreator.DATE,"yyyy-MM-dd"},
			{"sex", "性别",ExportDataCreator.CODE2NAME,"$CH_SEX"},{"empstatus", "用工状态",ExportDataCreator.CODE2NAME,"$CH_EMPSTATUS"},
			{"cardid", "身份证号码",null,""},{"telephone", "联系电话",null,""},{"cityid", "地市公司",ExportDataCreator.CODE2NAME,"#CITYCOMPANY"},
			{"countyid", "分公司",ExportDataCreator.CODE2NAME,"#CNTYCOMPANY"},{"svccode", "服务销售中心",ExportDataCreator.CODE2NAME,"#SERVCENT"},
			{"wayid", "渠道名称",ExportDataCreator.CODE2NAME,"#WAYIDINFO"},
			{"wayid", "渠道编号",null,""},{"intime", "入职时间",ExportDataCreator.DATE,"yyyy-MM-dd"},
			{"employtype", "用工性质",ExportDataCreator.CODE2NAME,"$CH_EMPLOYTYPE"},{"bail", "保证金",null,""},{"officetel", "公务机号码",null,""},
			{"isnet", "是否为店主",ExportDataCreator.CODE2NAME,"$CH_ISNET"},
			{"netpass", "网点确认码",null,""},{"selectmobile", "空中选号手机号",null,""}
	};
	/**渠道经理批量导出的可选字段*/
	private String[][] magOptionFeilds = new String[][] {
			{"employeeid", "人员ID",null,""},{"oprcode2", "BOSS工号",null,""},{"employeename", "姓名",null,""},{"sex", "性别",ExportDataCreator.CODE2NAME,"$CH_SEX"},
			{"telephone", "手机号",null,""},{"cityid", "地市公司",ExportDataCreator.CODE2NAME,"#CITYCOMPANY"},{"countyid", "分公司",ExportDataCreator.CODE2NAME,"#CNTYCOMPANY"},
			{"svccode", "服务销售中心",ExportDataCreator.CODE2NAME,"#SERVCENT"},{"mareacode", "微区域",ExportDataCreator.CODE2NAME,"#MICROAREA"},{"wayid", "服务厅(所属渠道)",ExportDataCreator.CODE2NAME,"#WAYIDINFO"},{"station","岗位",ExportDataCreator.CODE2NAME,"POSTINFO"},
			{"intime", "入职时间",ExportDataCreator.DATE,"yyyy-MM-dd"},{"employtype", "用工性质",ExportDataCreator.CODE2NAME,"$CH_EMPLOYTYPE"},{"empstatus", "用工状态",ExportDataCreator.CODE2NAME,"$CH_EMPSTATUS"},
			{"birthday", "出生日期",ExportDataCreator.DATE,"yyyy-MM-dd"},{"edulevel", "文化程度",ExportDataCreator.CODE2NAME,"$CH_EDULEVEL"},{"nativehome", "籍贯",ExportDataCreator.CODE2NAME,"$CH_NATIVE"},
			{"polivisage", "政治面貌",ExportDataCreator.CODE2NAME,"$CH_POLIVISAGE"},{"homeaddr", "家庭地址",null,""},{"cardid", "身份证号码",null,""},{"pvtemail", "个人电子邮箱",null,""},{"ofcphone", "公司专用联系方式",null,""},
			{"speciality", "专业",null,""},{"officetel", "公务手机号码",null,""},{"gradschool", "毕业院校",null,""},{"gradtime", "毕业时间",ExportDataCreator.DATE,"yyyy-MM-dd"},{"contacttype","劳动关系",ExportDataCreator.CODE2NAME,"$CH_CONTACTTYPE"},
			{"posittype", "岗位级别",ExportDataCreator.CODE2NAME,"POSITTYPE"},{"joblevel", "职级",ExportDataCreator.CODE2NAME,"$CH_JOBLEVEL"},{"department", "所在部门",null,""},{"worktime", "参加工作年限",null,""},
			{"company", "所属劳务公司",null,""},{"hereworktime", "本公司工作年限",null,""},{"ismarried", "婚姻状况",ExportDataCreator.CODE2NAME,"$CH_ISMARRIED"}
	};
	public EmployeeAction() {
		super();

		//????????·?·¨??±?????
		this.setForm(new EmployeeForm());
		this.setParam(new EmployeeWebParam());

        //???¨VO?à
        setClsVO(EmployeeVO.class);
        //???¨?÷?ü??×é?????????????÷?ü???ò?è???¨?????????÷?ü??×???????
        this.pkNameArray=new String[]{"employeeid"};
		this.setClsControl(Employee.class);
		this.setClsQueryParam(EmployeeWebParam.class) ;

		/**
		 * ???????¨??????????????????BaseAction??CRUD???á?÷?????¨??Delegate????°??é??????±????¨
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	@Override
	public String doList() throws Exception {
		User loginUser = (User) ActionContext.getContext().getSession().get(
				WebConstant.SESSION_ATTRIBUTE_USER);
		Employee bo = (EmployeeBO) BOFactory.build(EmployeeBO.class, super
				.getDBAccessUser());
		if ("MANAGER".equals(this.processType)) {// 渠道经理列表
			try {
				DataPackage dp = bo.doManagerQuery(loginUser.getWayid(),
						(EmployeeWebParam) param);
				super.setDp(dp);
			} catch (Exception e) {
				super.addActionError(e.getMessage());
			}
			return "managerlist";
		} else if("ZJTY".equals(this.processType)){//自建他营的列表
			try {
				DataPackage dp = bo.doZjtyQuery(loginUser.getWayid(),
						(EmployeeWebParam) param);
				super.setDp(dp);
			} catch (Exception e) {
				super.addActionError(e.getMessage());
			}
			return "zjtylist";
		}
			else{// 社会渠道人员管理列表
			try {
				DataPackage dp = bo.doQuerybywayid(loginUser.getWayid(),
						(EmployeeWebParam) param);
				super.setDp(dp);
			} catch (Exception e) {
				super.addActionError(e.getMessage());
			}
			return "list";
		}
	}
	
	@Override
	public String doDelete() throws Exception {
		// TODO Auto-generated method stub
		try{
			Employee bo = (EmployeeBO) BOFactory.build(
					EmployeeBO.class, super.getDBAccessUser());
			bo.doUpdateEmpstatus(((DBQueryParam) getParam()).get_selectitem(), new Short("1"));
		}catch(Exception e){
			super.addActionError("操作出错："+e.getMessage());
		}
		return this.doList();
	}

	@Override
	public String doEdit() throws Exception {
		// TODO Auto-generated method stub
		super.doEdit();
		
		if("MANAGER".equals(this.processType)){
			EmployeeForm form = (EmployeeForm)super.getForm();
			Way way = (Way) BOFactory.build(WayBO.class, super.getDBAccessUser());
			//查询本地数据源
			WayVO vo=way.doFindByPk(form.getWayid());
			form.setWayidAndName(form.getWayid()+" "+vo.getWayname());
			super.getRequest().setAttribute("countyid",(form.getCountyid() == null || "".equals(form.getCountyid()))? "1<>1":form.getCountyid());
			return "managercontent";
		}
		else if("ZJTY".equals(this.processType)){
			EmployeeForm employeeForm = (EmployeeForm) super.getForm();
			Way way = (Way) BOFactory.build(WayBO.class, super.getDBAccessUser());
			//查询本地数据源
			WayVO vo=way.doFindByPk(employeeForm.getWayid());
			if(vo!=null && vo.getWaysubtype()!=null)
			{
				employeeForm.setWaysubtype(vo.getWaysubtype());
			}
			return "zjtycontent";
		}
		else{
			
			EmployeeForm employeeForm = (EmployeeForm) super.getForm();
			Way way = (Way) BOFactory.build(WayBO.class, super.getDBAccessUser());
			//查询本地数据源
			WayVO vo=way.doFindByPk(employeeForm.getWayid());
			if(vo!=null && vo.getWaysubtype()!=null)
			{
				employeeForm.setWaysubtype(vo.getWaysubtype());
			}
			
//			全员代理模式复选框屏蔽  确认by李茂
//			Empmodel modelBO = (Empmodel)BOFactory.build(EmpmodelBO.class, super.getDBAccessUser());
//			
//			EmpmodelDBParam modelParam = new EmpmodelDBParam();
//			modelParam.set_se_employeeid(employeeForm.getEmployeeid());
//			modelParam.set_se_model("3");
//			modelParam.set_pagesize("0");
//			modelParam.setDataOnly(true);
//			DataPackage dp = modelBO.doQuery(modelParam);
//			List<EmpmodelVO> list = dp.getDatas();
//			if(list.size() > 0) {
//				EmpmodelVO modelVO = list.get(0);
//				employeeForm.setEmpmodelid(modelVO.getEmpmodelid());
//				employeeForm.setModel(modelVO.getModel());
//				employeeForm.setModelState(modelVO.getState());
//				setForm(employeeForm);			
//			}
			return "content";
		}
	}

	@Override
	public String doEditNew() throws Exception {
		// TODO Auto-generated method stub
		super.doEditNew();

		if("MANAGER".equals(this.processType))
			return "managercontent";
		else if("ZJTY".equals(this.processType)){
			return "zjtycontent";
		}
		else{
			return "content";
		}
	}

	@Override
	public String doNew() throws Exception {
		// TODO Auto-generated method stub
		super.doNew();
		EmployeeForm form = (EmployeeForm)super.getForm();
		form.setEmployeeid(super.getDBAccessUser().getOprcode());
		if("MANAGER".equals(this.processType))
		{
			form.setEmployeeid(null);
			super.getRequest().setAttribute("countyid","1<>1");
			return "managercontent";
		}
		else if("ZJTY".equals(this.processType)){
			return "zjtycontent";
		}
		else{
			return "content";
		}
	}

	@Override
	public String doSave() throws Exception {
		// TODO Auto-generated method stub
		try {
			if ("MANAGER".equals(this.processType)) {
				Employee bo = (EmployeeBO) BOFactory.build(EmployeeBO.class, super.getDBAccessUser());
				EmployeeForm employeeForm = (EmployeeForm) super.getForm();
				super.getRequest().setAttribute("countyid",(employeeForm.getCountyid() == null || "".equals(employeeForm.getCountyid()))? "1<>1":employeeForm.getCountyid());
				if (WEB_CMD_NEW.equals(CMD)) {
					
					EmployeeVO vo = new EmployeeVO();
					if (!"".equals(employeeForm.getOprcode2())) {
						vo.setEmployeeid(employeeForm.getOprcode2());
						vo = bo.doFindByPk(employeeForm.getOprcode2());
						if (null != vo){
							throw new Exception("错误： 该人员["+ employeeForm.getEmployeeid() + "]已经存在");
						}
					}
					employeeForm.setWaytype("ET");
					employeeForm.setEmployeeid(employeeForm.getOprcode2());//默认赋值为录入的工号
					super.doSave();
					return "managercontent";
				}
				// employeeForm.setEmployeeid(employeeForm.getOprcode());
				Operator operator = (Operator) BOFactory.build(OperatorBO.class, super.getDBAccessUser());
				if (!"".equals(employeeForm.getOprcode2())){
				if( null == operator.doFindByPk(employeeForm.getOprcode2())){//验证人员是否在操作员表中
					throw new Exception("错误： 该人员["+ employeeForm.getOprcode2() + "] 不在工号表中 ");
				}
				}
				super.doSave();
				return "managercontent";
			} else if ("ZJTY".equals(this.processType)) {
				Employee bo = (EmployeeBO) BOFactory.build(EmployeeBO.class, super.getDBAccessUser());
				EmployeeForm employeeForm = (EmployeeForm) super.getForm();
				super.getRequest().setAttribute("countyid",(employeeForm.getCountyid() == null || "".equals(employeeForm.getCountyid()))? "1<>1":employeeForm.getCountyid());
				if (WEB_CMD_NEW.equals(CMD)) {
					
//					EmployeeVO vo = new EmployeeVO();
					if (!"".equals(employeeForm.getOprcode2())) {
//						vo.setEmployeeid(employeeForm.getOprcode2());
						EmployeeVO vo = bo.doFindByPk(employeeForm.getOprcode2());
						if (null != vo){
							throw new Exception("错误： 该人员["+ employeeForm.getEmployeeid() + "]已经存在");
						}
					}
					EmployeeVO vo = new EmployeeVO();
					BeanUtils.copyProperties(vo, employeeForm);
					vo = bo.doCreateSociety(vo, super.getDBAccessUser());
					BeanUtils.copyProperties(getForm(), vo);
					setCMD(WEB_CMD_SAVE);
					addActionMessage("保存成功");
					return "zjtycontent";
				}
				// employeeForm.setEmployeeid(employeeForm.getOprcode());
				Operator operator = (Operator) BOFactory.build(OperatorBO.class, super.getDBAccessUser());
				if (!"".equals(employeeForm.getOprcode2())){
				if( null == operator.doFindByPk(employeeForm.getOprcode2())){//验证人员是否在操作员表中
					throw new Exception("错误： 该人员["+ employeeForm.getOprcode2() + "] 不在工号表中 ");
				}
				}
				EmployeeVO vo = new EmployeeVO();
				BeanUtils.copyProperties(vo, employeeForm);
				vo = bo.doUpdate(vo,super.getDBAccessUser());
				BeanUtils.copyProperties(getForm(), vo);
				setCMD(WEB_CMD_SAVE);
				addActionMessage("保存成功");
				return "zjtycontent";
				
			}
			else{
				HttpServletRequest request = this.getRequest();
				EmpmodelVO modelVO = null;
				EmployeeForm employeeForm = (EmployeeForm) super.getForm();
				if (WEB_CMD_NEW.equals(CMD)) {
					Employee bo = (EmployeeBO) BOFactory.build(
							EmployeeBO.class, super.getDBAccessUser());
					EmployeeVO vo = new EmployeeVO();
					
					BeanUtils.copyProperties(vo, employeeForm);
					vo = bo.doCreateSociety(vo, super.getDBAccessUser());
					BeanUtils.copyProperties(getForm(), vo);
//					//			全员代理模式复选框屏蔽  确认by李茂
//					// 工作模式 处理Begin
//					String[] agentmodeArr = (String[])request.getParameterValues("agentmode_checkbox");
//					Empmodel modelBO = (Empmodel)BOFactory.build(EmpmodelBO.class, super.getDBAccessUser());
//					
//					modelVO = new EmpmodelVO();
//					// 新增记录到人员工作模式表
//					modelVO.setEmployeeid(vo.getEmployeeid());
//					modelVO.setModel("3"); //工作模式等于3（全员代理模式）
//					
//					if(agentmodeArr != null && agentmodeArr.length > 0) {
//						//如果有勾选全员代理模式,
//						modelVO.setState(Short.parseShort("0"));//状态字段为0正常
//					}else {
//						//如果未勾选全员代理模式,
//						modelVO.setState(Short.parseShort("1"));//状态字段为1退出
//					}
//					modelVO = modelBO.doCreate(modelVO);
//					
//					// 工作模式 处理End
					
				} else {
					Employee bo = (EmployeeBO) BOFactory.build(
							EmployeeBO.class, super.getDBAccessUser());
					EmployeeVO vo = new EmployeeVO();
					BeanUtils.copyProperties(vo, employeeForm);
					vo = bo.doUpdate(vo,super.getDBAccessUser());
					BeanUtils.copyProperties(getForm(), vo);
////					全员代理模式复选框屏蔽  确认by李茂
//					// 工作模式 处理Begin
//					String[] agentmodeArr = (String[])request.getParameterValues("agentmode_checkbox");
//					Empmodel modelBO = (Empmodel)BOFactory.build(EmpmodelBO.class, super.getDBAccessUser());
//					
//					EmpmodelDBParam modelParam = new EmpmodelDBParam();
//					modelParam.set_se_employeeid(vo.getEmployeeid());
//					modelParam.set_se_model("3");
//					modelParam.set_pagesize("0");
//					modelParam.setDataOnly(true);
//					
//					Long empmodelid = employeeForm.getEmpmodelid();
//					Short modelState = employeeForm.getModelState();
//					if(empmodelid != null && modelState != null && modelState == 0) { // 人员工作模式记录存在且状态为0正常
//						if(agentmodeArr != null && agentmodeArr.length > 0) {
//							// 如果勾选全员代理模式，则什么都不需要做
//						}else{
//							// 如果未勾选全员代理模式
//							DataPackage dp = modelBO.doQuery(modelParam);
//							List<EmpmodelVO> list = dp.getDatas();
//							if(list.size() > 0) {
//								//如果有存在记录，则更新记录中的状态字段等于1（退出）。
//								modelVO = list.get(0);
//								modelVO.setState(Short.parseShort("1"));
//								modelVO = modelBO.doUpdate(modelVO);
//							}
//						}
//					} else if(empmodelid != null && modelState != null && modelState == 1){ // 人员工作模式记录存在且状态为1退出
//						if(agentmodeArr != null && agentmodeArr.length > 0) {
//							// 如果勾选全员代理模式
//							DataPackage dp = modelBO.doQuery(modelParam);
//							List<EmpmodelVO> list = dp.getDatas();
//							if(list.size() > 0) {
//								//如果有存在记录，则更新记录中的状态字段等于0（正常）。
//								modelVO = list.get(0);
//								modelVO.setState(Short.parseShort("0"));
//								modelVO = modelBO.doUpdate(modelVO);
//							}
//						}
//					}else if((empmodelid != null && modelState == null) 
//							|| empmodelid == null){ // 人员工作模式记录存在且状态为空 或者 人员工作模式记录不存在
//						// 则新增记录到人员工作模式表
//						modelVO = new EmpmodelVO();
//						modelVO.setEmployeeid(vo.getEmployeeid());
//						modelVO.setModel("3"); //工作模式等于3（全员代理模式）
//						if(agentmodeArr != null && agentmodeArr.length > 0) {
//							//如果有勾选全员代理模式，,状态为0正常。
//							modelVO.setState(Short.parseShort("0"));
//						}else{
//							//如果未勾选全员代理模式，,状态为1退出。
//							modelVO.setState(Short.parseShort("1"));
//						}
//						modelVO = modelBO.doCreate(modelVO);
//					}
				}
//				if(modelVO != null) {
//					employeeForm.setModelState(modelVO.getState());
//					employeeForm.setModel(modelVO.getModel());
//					setForm(employeeForm);
//				}
				// 工作模式 处理End
				setCMD(WEB_CMD_SAVE);
				addActionMessage("保存成功");
				return "content";

			}
		} catch (Exception e) {
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		if ("MANAGER".equals(this.processType)) {
			return "managercontent";
		}
		if ("ZJTY".equals(this.processType)) {
			return "zjtycontent";
		}
		return "content";
	}

	@Override
	public String doView() throws Exception {
		// TODO Auto-generated method stub
		super.doView();
		if("MANAGER".equals(this.processType))
			return "managercontent";
		else if("ZJTY".equals(this.processType)){
			return "zjtycontent";
		}else{
			return "content";
		}
	}

	public String getProcessType() {
		return processType;
	}

	public void setProcessType(String processType) {
		this.processType = processType;
	}
	
	/**
	 * 渠道经理信息管理导出
	 * @return
	 */
	public String doMgrExcel(){
		try{
			EmployeeWebParam employeeParam = (EmployeeWebParam)super.getParam();
			employeeParam.setQueryAll(true);
			HttpServletRequest request = ServletActionContext.getRequest();
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			export.setFileName("渠道经理信息管理");
			// export.addOutputProperty(0,"business","营业点",null,null);
//			export.addOutputProperty("employeeid", "人员ID");
//			export.addOutputProperty("oprcode2", "BOSS工号");
//			export.addOutputProperty("employeename", "姓名");
//			export.addOutputProperty("sex", "性别",export.CODE2NAME, "$CH_SEX");
//			export.addOutputProperty("telephone", "联系电话");
//			export.addOutputProperty("cityid", "地市公司",export.CODE2NAME, "#CITYCOMPANY");
//			export.addOutputProperty("countyid", "分公司",export.CODE2NAME, "#CNTYCOMPANY");
//			export.addOutputProperty("svccode", "服务销售中心",export.CODE2NAME, "#SERVCENT");
//			export.addOutputProperty("wayid", "服务厅（所属渠道）",export.CODE2NAME, "#WAYIDINFO");
//			export.addOutputProperty("station", "岗位",export.CODE2NAME, "POSTINFO");
//			export.addOutputProperty("intime", "入职时间",export.DATE,"yyyy-MM-dd");
//			export.addOutputProperty("employtype", "用工性质",export.CODE2NAME, "$CH_EMPLOYTYPE");

			String selectedFields = getRequest().getParameter("selectedFields");
			String[] sfArray = selectedFields.split(",");
			for(int i = 0;i < sfArray.length;i++) {
				int k = Integer.parseInt(sfArray[i]);
				export.addOutputProperty(magOptionFeilds[k][0],magOptionFeilds[k][1],magOptionFeilds[k][2],magOptionFeilds[k][3]);
			}
			
			export.appendEndLine(new String[] { "导出工号:",user.getOprcode() });
			export.appendEndLine(new String[] { "导出渠道:", user.getWayid() });
			
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
			return super.doExcel();
		}catch(Exception e){
			super.addActionError(e.getMessage());
		}
		return null;
	}
	
	
	/**
	 * 管辖网点导出导出
	 * @return
	 */
	public String doMgrWayExcel() {
		try{
			HttpServletRequest request = ServletActionContext.getRequest();
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			export.setFileName("管辖网点信息");
			export.addOutputProperty("wayid", "渠道编码");
			export.addOutputProperty("wayname", "渠道名称");
			export.addOutputProperty("officetel", "公务机号码");
//			export.addOutputProperty("isopen", "开通标志", export.CODE2NAME,"$CH_ISOPEN");
			export.addOutputProperty("waysubtype", "零售渠道类别",export.CODE2NAME, "#WAYTYPE");
			export.addOutputProperty("upperwayid", "上级渠道",export.CODE2NAME, "#WAYIDINFO");
			export.addOutputProperty("latitude", "纬度");
			export.addOutputProperty("longtitude", "经度");
			export.addOutputProperty("starlevel", "星级", export.CODE2NAME,"$CH_STARLEVEL");
			export.addOutputProperty("pt", "排他性", export.CODE2NAME,"$CH_PT");
			export.addOutputProperty("isstraitprd", "是否直供",export.CODE2NAME, "$CH_STRAITPRD");
			export.addOutputProperty("catetype", "连锁性质", export.CODE2NAME,"$CH_CATETYPE");
			export.addOutputProperty("cityid", "地市公司", export.CODE2NAME,"#CITYCOMPANY");
			export.addOutputProperty("countyid", "分公司", export.CODE2NAME,"#CNTYCOMPANY");
			export.addOutputProperty("svccode", "服务销售中心", export.CODE2NAME,"#SERVCENT");
			export.addOutputProperty("mareacode", "微区域", export.CODE2NAME,"#CH_MICROAREA");
			export.addOutputProperty("adtypecode", "区域类型",export.CODE2NAME, "$CH_ADTYPE");
			export.addOutputProperty("adacode", "行政区划", export.CODE2NAME,"#CH_ADIMAREA");
			export.addOutputProperty("formtype", "业态类型", export.CODE2NAME,"$CH_FORMTYPE");
			export.addOutputProperty("starttime", "合作开始时间", export.DATE,"yyyy-MM-dd");
			export.addOutputProperty("buzarea", "移动专区面积");
			export.addOutputProperty("logiscode", "所属物流商");
			export.addOutputProperty("waymagcode", "所属渠道经理");
			export.addOutputProperty("bchlevel", "分级", export.CODE2NAME,"$CH_BCHLEVEL");
			export.addOutputProperty("waystate", "状态", export.CODE2NAME,"$CH_VALIDFLAG");

			export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
			export.appendHeadLine(new String[] { "导出渠道:", user.getWayid() });
			export.queryMethodName = "doQuerywaybymgrid";
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
			export.voClassArray = new Class[]{AGWayVO.class};
			return super.doExcel();
			
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return null;
	}
	
	/*
	 * 管辖网点查询
	 */
	public String doQuerywaybymgrid() throws Exception {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			User user = (User) getDBAccessUser();
			EmployeeWebParam employeeParam = (EmployeeWebParam) super.getParam();
			WayDBParam wayParam = new WayDBParam();
			wayParam.set_se_waymagcode(employeeParam.get_se_employeeid());
			WayDelegate delegate = new WayDelegate();
			DataPackage dp = delegate.doQueryEmployee(wayParam, user);
			 
			super.setDp(dp);
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return null;
	}
	

	public String doGetWayInfo(){
		try{
			String result = "";
			EmployeeForm employeeForm = (EmployeeForm) super.getForm();
			String wayid = employeeForm.getWayid();
			Way wayBO = (WayBO) BOFactory.build(WayBO.class, super.getDBAccessUser());
			WayVO wayVO = wayBO.doFindByPk(wayid);
			 
			if( null != wayVO){
				employeeForm.setCityid(wayVO.getCityid());
				employeeForm.setCountyid(wayVO.getCountyid());
				super.getRequest().setAttribute("countyid", (wayVO.getCountyid() == null || "".equals(wayVO.getCountyid()))? "1<>1":wayVO.getCountyid());
			}
			
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return "managercontent";
	}
	
		//通过渠道编号取得CITYID,名称,COUNTYID与名称
	//输出: countyid:countyname,cityid:cityname
	public void doGetWayInfo1(){
		try{
			String result = "";
			EmployeeForm employeeForm = (EmployeeForm) super.getForm();
			String wayid = employeeForm.getWayid();
			Way wayBO = (WayBO) BOFactory.build(WayBO.class, super.getDBAccessUser());
			//查询PBOSS数据库的渠道,跟渠道树一致.
			WayVO wayVO = wayBO.doFindByPk(wayid);
			 
			if( null != wayVO){
				if( null != wayVO.getCountyid()){
					result += wayVO.getCountyid()+":";
					Cntycompany cntycompanyBO = (CntycompanyBO) BOFactory.build(CntycompanyBO.class,super.getDBAccessUser());
					CntycompanyVO cntycompanyVO = cntycompanyBO.doFindByPk(wayVO.getCountyid()); 
					result += (cntycompanyVO == null || null == cntycompanyVO.getCountycompname()) ? "":cntycompanyVO.getCountycompname();
					result +=",";
				}else{
					result += ":,";
				}
								
				if( null != wayVO.getCityid()){
					result +=wayVO.getCityid()+":";
					Citycompany citycompanyBO = (CitycompanyBO) BOFactory.build(CitycompanyBO.class, super.getDBAccessUser());
					CitycompanyVO ctitycompanyVO = citycompanyBO.doFindByPk(wayVO.getCityid());
					result += ( null == ctitycompanyVO || null == ctitycompanyVO.getCitycompname()) ? "":ctitycompanyVO.getCitycompname();
					result+=",";
				}else{
					result += ":,";
				}
				//增加WAYSUBTYPE的值
				result+=(null==wayVO.getWaysubtype()?"":wayVO.getWaysubtype());
			}
			System.out.println(result);
			super.getResponse().getWriter().write(result);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	
	//社会渠道人员导出TXT
	public String  doExporttxt(){
		try{
			EmployeeWebParam employeeParam = (EmployeeWebParam) super.getParam();
			employeeParam.setQueryAll(true);
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			export.setFileName("社会渠道人员");
			String selectedFields = getRequest().getParameter("selectedFields");
			// sfArray包含 ：每个已选字段在employeeOptionFeilds中一维元素的下标值
			String[] sfArray = selectedFields.split(",");
			// titleArray 已选字段中文名称
			String[] titleArray = new String[sfArray.length];
			for(int i = 0;i < sfArray.length;i++) {
				int k = Integer.parseInt(sfArray[i]);
				export.addOutputProperty(employeeOptionFeilds[k][0],employeeOptionFeilds[k][1],employeeOptionFeilds[k][2],employeeOptionFeilds[k][3]);
				titleArray[i] = employeeOptionFeilds[k][1];
			}
			/*export.addOutputProperty("employeeid", "人员编号");
			export.addOutputProperty("employeename", "姓名");
			export.addOutputProperty("birthday", "出生年月",export.DATE,"yyyy-MM-dd");
			export.addOutputProperty("sex", "性别",export.CODE2NAME,"$CH_SEX");
			export.addOutputProperty("empstatus", "用工状态",export.CODE2NAME,"$CH_EMPSTATUS");
			export.addOutputProperty("cardid", "身份证号码");
			export.addOutputProperty("telephone", "联系电话");
			export.addOutputProperty("cityid", "地市公司",export.CODE2NAME,"#CITYCOMPANY");
			export.addOutputProperty("countyid", "分公司",export.CODE2NAME,"#CNTYCOMPANY");
			export.addOutputProperty("svccode", "服务销售中心",export.CODE2NAME,"#SERVCENT");
			export.addOutputProperty("wayid", "渠道编号",export.CODE2NAME,"#WAYIDINFO");
			export.addOutputProperty("intime", "入职时间",export.DATE,"yyyy-MM-dd");
			export.addOutputProperty("employtype", "用工性质",export.CODE2NAME,"$CH_EMPLOYTYPE");
			export.addOutputProperty("bail", "保证金");
			export.addOutputProperty("officetel", "公务机号码");
			export.addOutputProperty("isnet", "是否为店主",export.CODE2NAME,"$CH_ISNET");
			export.addOutputProperty("isopen", "开通服务标志",export.CODE2NAME,"$CH_ISOPEN");
			export.addOutputProperty("netpass", "网点确认码");
			export.addOutputProperty("selectmobile", "空中选号手机号");*/
			
			
			export.voClassArray = new Class[] { EmployeeVO.class };
			prepareResponse(export.getFileName());
			export.queryMethodName = "doList";

			export.writeTxtTitle(getResponse().getOutputStream(), titleArray);
			super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
			
			
		}catch(Exception e){
			super.addActionError("导出社会渠道人员TXT出错："+e.getMessage());
		}
		return null;
	}
	

	//社会渠道人员导出Excel
	public String  doExportExcel(){
		try{
			EmployeeWebParam employeeParam = (EmployeeWebParam) super.getParam();
			employeeParam.setQueryAll(true);
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			export.setFileName("社会渠道人员");
			String selectedFields = getRequest().getParameter("selectedFields");
			// sfArray包含 ：每个已选字段在employeeOptionFeilds中一维元素的下标值
			String[] sfArray = selectedFields.split(",");
			// titleArray 已选字段中文名称
			String[] titleArray = new String[sfArray.length];
			for(int i = 0;i < sfArray.length;i++) {
				int k = Integer.parseInt(sfArray[i]);
				export.addOutputProperty(employeeOptionFeilds[k][0],employeeOptionFeilds[k][1],employeeOptionFeilds[k][2],employeeOptionFeilds[k][3]);
				titleArray[i] = employeeOptionFeilds[k][1];
			}
			
			export.voClassArray = new Class[] { EmployeeVO.class };
			//prepareResponse(export.getFileName());
			export.queryMethodName = "doList";

//			export.writeTxtTitle(getResponse().getOutputStream(), titleArray);
//			super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
			this.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
			super.doExcel();
			
		}catch(Exception e){
			super.addActionError("导出社会渠道人员Excel出错："+e.getMessage());
		}
		return null;
	}
	
	
	
  
	//检查采集平台捆绑手机号,录入的采集平台手机号对于在岗的这些人员是唯一的  
	public String doCheckOfficetel(){
		try{
			String result = "";
			EmployeeForm form = (EmployeeForm) super.getForm();
			Employee bo = (EmployeeBO) BOFactory.build(
					EmployeeBO.class, super.getDBAccessUser());
			EmployeeWebParam param = new EmployeeWebParam();
			param.set_ne_empstatus("0");//0表在岗
			param.set_se_officetel(form.getOfficetel());
//			param.set_sne_employeeid(form.getEmployeeid());
			
			
			
			
			
			
			
			DataPackage dp = bo.doQuery(param);
			if(dp == null || dp.getDatas() == null || dp.getDatas().size()==0){
//				result = "OK";
				if (checkTelCity(form.getOfficetel(),super.getDBAccessUser())) {
					result = "OK";
				} else {
					result = "NG";
				}
			}else{
				result = "NO";
			}
			super.getResponse().getWriter().write(result);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	//渠道经理管理--绑定手机号，录入对于在岗人员唯一的验证
	public String doCheckOfficetel2(){
		try{
			String result = "";
			EmployeeForm form = (EmployeeForm) super.getForm();
			Employee bo = (EmployeeBO) BOFactory.build(
					EmployeeBO.class, super.getDBAccessUser());
			EmployeeWebParam param = new EmployeeWebParam();
			param.set_ne_empstatus("0");//0表在岗
			param.set_se_officetel(form.getOfficetel());
			param.set_sne_employeeid(form.getEmployeeid()); 
			SysparamBO sysparamBO = (SysparamBO) BOFactory.build(SysparamBO.class,super.getDBAccessUser());
			
			// 系统参数76，1:渠道经理参与了配送 0:渠道经理没有参与配送 空:渠道经理没有参与配送 
			String sysstr = sysparamBO.doFindByID(76L, "channel");  
			
		       if(("1").equals(sysstr)){
				  param.set_nne_isnet("3"); 
			   } 
			    DataPackage dp = bo.doQuery(param); 
			    
			  if(dp.getDatas().size()>0){ 
				   result = "NO";  
			  }else if(dp == null || dp.getDatas() == null || dp.getDatas().size()==0){
 
				if (checkTelCity(form.getOfficetel(),super.getDBAccessUser())) {
					result = "OK";
				} else {
					result = "NG";
				}
			}
 
			super.getResponse().getWriter().write(result);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 检测手机号码是否在本地市内唯一
	 * 
	 * @param officetel
	 * @param user
	 */
	//注:刚开发的人员不知道这个逻辑.漏掉了.下个版本补上.
	private boolean checkTelCity(String officetel, DBAccessUser user) {
		try{
			Nosect control = (Nosect) BOFactory.build(NosectBO.class, user);
			String cityid = control.doQueryCityID(officetel);
			if (!user.getCityid().equals(cityid)) {
				return false;
			} else {
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 社会渠道人员管理查询
	 * 
	 */
	public String doSocietylist() throws Exception {
		User loginUser = (User) ActionContext.getContext().getSession().get(
				WebConstant.SESSION_ATTRIBUTE_USER);
		Employee bo = (EmployeeBO) BOFactory.build(EmployeeBO.class, super
				.getDBAccessUser());
		AGWay agway = (AGWay)BOFactory.build(AGWayBO.class, getDBAccessUser());
		EmployeeWebParam listVO = (EmployeeWebParam)super.getParam();
		listVO.set_se_waytype("AG");// 普通代理渠道,即社会渠道
		DataPackage dp = bo.doQuerybywayid(loginUser.getWayid(),listVO);
		// pack.setPageSize(20);
		// 解包
		Iterator it = dp.getDatas().iterator();
		while (it.hasNext()) {
			EmployeeVO empVO = (EmployeeVO) (it.next());
			short isnet = empVO.getIsnet() == null ? 0 : empVO.getIsnet()
					.shortValue();
			short isopen = empVO.getIsopen() == null ? 0 : empVO.getIsopen()
					.shortValue();
			short empstatus = empVO.getEmpstatus() == null ? 0 : empVO
					.getEmpstatus().shortValue();
			if ((isnet == 1 || isnet==0)&& isopen == 1 && empstatus == 1) {
				if(empVO.getOfficetel()!=null){
					if (agway.doHasRecords(empVO.getOfficetel()
							.trim(), getDBAccessUser())) {
						empVO.setCancelFlag("1");
					}
				}
			}
		}
		super.setDp(dp);
		return "list";
	}
	/**
	 * 自建他营人员管理查询
	 * 
	 */
	public String doZjtylist() throws Exception {
		User loginUser = (User) ActionContext.getContext().getSession().get(
				WebConstant.SESSION_ATTRIBUTE_USER);
		Employee bo = (EmployeeBO) BOFactory.build(EmployeeBO.class, super
				.getDBAccessUser());
		AGWay agway = (AGWay)BOFactory.build(AGWayBO.class, getDBAccessUser());
		EmployeeWebParam listVO = (EmployeeWebParam)super.getParam();
		listVO.set_se_waytype("AG");// 普通代理渠道,即社会渠道
		DataPackage dp = bo.doZjtyQuery(loginUser.getWayid(),listVO);
		// pack.setPageSize(20);
		// 解包
		Iterator it = dp.getDatas().iterator();
		while (it.hasNext()) {
			EmployeeVO empVO = (EmployeeVO) (it.next());
			short isnet = empVO.getIsnet() == null ? 0 : empVO.getIsnet()
					.shortValue();
			short isopen = empVO.getIsopen() == null ? 0 : empVO.getIsopen()
					.shortValue();
			short empstatus = empVO.getEmpstatus() == null ? 0 : empVO
					.getEmpstatus().shortValue();
			if ((isnet == 1 || isnet==0)&& isopen == 1 && empstatus == 1) {
				if(empVO.getOfficetel()!=null){
					if (agway.doHasRecords(empVO.getOfficetel()
							.trim(), getDBAccessUser())) {
						empVO.setCancelFlag("1");
					}
				}
			}
		}
		super.setDp(dp);
		return "zjtylist";
	}
	/*
	 * 取消网点服务
	 */
	public String doCancelservice() throws Exception {
		try {
			AGWay agway = (AGWay) BOFactory.build(AGWayBO.class,
					getDBAccessUser());
			HttpServletRequest request = getRequest();
			String employeeID = request.getParameter("employeeID") == null ? ""
					: request.getParameter("employeeID");
			if (!"".equals(employeeID)) {
				agway.doCancelService(employeeID, getDBAccessUser(), "button");
			}
			super.addActionMessage("系统已收到你的退订请求，完成退订过程需要几分钟时间，请耐心等待!");
		} catch (Exception e) {
			super.addActionError(e.getMessage());
			throw e;
		} finally {
			return this.doSocietylist();
		}
	}
	/**
	 * 自建他营人员信息管理导出
	 * @return
	 */
//	{"employeeid", "人员编号",null,""},{"employeename", "姓名",null,""},{"birthday", "出生年月",ExportDataCreator.DATE,"yyyy-MM-dd"},
//	{"sex", "性别",ExportDataCreator.CODE2NAME,"$CH_SEX"},{"empstatus", "用工状态",ExportDataCreator.CODE2NAME,"$CH_EMPSTATUS"},
//	{"cardid", "身份证号码",null,""},{"telephone", "联系电话",null,""},{"cityid", "地市公司",ExportDataCreator.CODE2NAME,"#CITYCOMPANY"},
//	{"countyid", "分公司",ExportDataCreator.CODE2NAME,"#CNTYCOMPANY"},{"svccode", "服务销售中心",ExportDataCreator.CODE2NAME,"#SERVCENT"},
//	{"wayid", "渠道编号",ExportDataCreator.CODE2NAME,"#WAYIDINFO"},{"intime", "入职时间",ExportDataCreator.DATE,"yyyy-MM-dd"},
//	{"employtype", "用工性质",ExportDataCreator.CODE2NAME,"$CH_EMPLOYTYPE"},{"bail", "保证金",null,""},{"officetel", "公务机号码",null,""},
//	{"isnet", "是否为店主",ExportDataCreator.CODE2NAME,"$CH_ISNET"},{"isopen", "开通服务标志",ExportDataCreator.CODE2NAME,"$CH_ISOPEN"},
//	{"netpass", "网点确认码",null,""},{"selectmobile", "空中选号手机号",null,""}
	public String doZjtyExcel(){
		try{
			EmployeeWebParam employeeParam = (EmployeeWebParam)super.getParam();
			employeeParam.setQueryAll(true);
			HttpServletRequest request = ServletActionContext.getRequest();
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			export.setFileName("自建他营人员管理");
			// export.addOutputProperty(0,"business","营业点",null,null);
			export.addOutputProperty("employeeid", "人员ID");
			export.addOutputProperty("employeename", "姓名");
			export.addOutputProperty("oprcode2", "BOSS工号");
			export.addOutputProperty("birthday", "出生日期",export.DATE,"yyyy-MM-dd");
			export.addOutputProperty("sex", "性别",export.CODE2NAME, "$CH_SEX");
			export.addOutputProperty("empstatus", "用工状态",export.CODE2NAME, "$CH_EMPSTATUS");
			export.addOutputProperty("cardid", "身份证号码");
			export.addOutputProperty("telephone", "联系电话");
			export.addOutputProperty("cityid", "地市公司",export.CODE2NAME, "#CITYCOMPANY");
			export.addOutputProperty("countyid", "分公司",export.CODE2NAME, "#CNTYCOMPANY");
			export.addOutputProperty("svccode", "服务销售中心",export.CODE2NAME, "#SERVCENT");
			export.addOutputProperty("wayid", "渠道编号",export.CODE2NAME, "#WAYIDINFO");
			export.addOutputProperty("intime", "入职时间",export.DATE,"yyyy-MM-dd");
			export.addOutputProperty("employtype", "用工性质",export.CODE2NAME, "$CH_EMPLOYTYPE");
			export.addOutputProperty("bail", "保证金");
			export.addOutputProperty("officetel", "公务机号码");
			export.addOutputProperty("isnet", "是否为店主",export.CODE2NAME, "$CH_ISNET");
			export.addOutputProperty("isopen", "开通服务标志",export.CODE2NAME, "$CH_ISOPEN");
			export.addOutputProperty("netpass", "网点确认码");
			export.addOutputProperty("selectmobile", "空中选号手机号");

			export.appendEndLine(new String[] { "导出工号:",user.getOprcode() });
			export.appendEndLine(new String[] { "导出渠道:", user.getWayid() });
			
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
			return super.doExcel();
		}catch(Exception e){
			super.addActionError(e.getMessage());
		}
		return null;
	}
	
	//自建他营人员导出TXT
	public String  doZjtyTxt(){
		try{
			EmployeeWebParam employeeParam = (EmployeeWebParam) super.getParam();
			employeeParam.setQueryAll(true);
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			export.setFileName("自建他营人员管理");
//			String selectedFields = getRequest().getParameter("selectedFields");
//			// sfArray包含 ：每个已选字段在employeeOptionFeilds中一维元素的下标值
//			String[] sfArray = selectedFields.split(",");
//			// titleArray 已选字段中文名称
//			String[] titleArray = new String[sfArray.length];
//			for(int i = 0;i < sfArray.length;i++) {
//				int k = Integer.parseInt(sfArray[i]);
//				export.addOutputProperty(employeeOptionFeilds[k][0],employeeOptionFeilds[k][1],employeeOptionFeilds[k][2],employeeOptionFeilds[k][3]);
//				titleArray[i] = employeeOptionFeilds[k][1];
//			}
			export.addOutputProperty("employeeid", "人员ID");
			export.addOutputProperty("employeename", "姓名");
			export.addOutputProperty("oprcode2", "BOSS工号");
			export.addOutputProperty("birthday", "出生日期",export.DATE,"yyyy-MM-dd");
			export.addOutputProperty("sex", "性别",export.CODE2NAME, "$CH_EMPSTATUS");
			export.addOutputProperty("empstatus", "用工状态",export.CODE2NAME, "$CH_SEX");
			export.addOutputProperty("cardid", "身份证号码");
			export.addOutputProperty("telephone", "联系电话");
			export.addOutputProperty("cityid", "地市公司",export.CODE2NAME, "#CITYCOMPANY");
			export.addOutputProperty("countyid", "分公司",export.CODE2NAME, "#CNTYCOMPANY");
			export.addOutputProperty("svccode", "服务销售中心",export.CODE2NAME, "#SERVCENT");
			export.addOutputProperty("wayid", "渠道编号",export.CODE2NAME, "#WAYIDINFO");
			export.addOutputProperty("intime", "入职时间",export.DATE,"yyyy-MM-dd");
			export.addOutputProperty("employtype", "用工性质",export.CODE2NAME, "$CH_EMPLOYTYPE");
			export.addOutputProperty("bail", "保证金");
			export.addOutputProperty("officetel", "公务机号码");
			export.addOutputProperty("isnet", "是否为店主",export.CODE2NAME, "$CH_ISNET");
			export.addOutputProperty("isopen", "开通服务标志",export.CODE2NAME, "$CH_ISOPEN");
			export.addOutputProperty("netpass", "网点确认码");
			export.addOutputProperty("selectmobile", "空中选号手机号");
			
			
			export.voClassArray = new Class[] { EmployeeVO.class };
			prepareResponse(export.getFileName());
			export.queryMethodName = "doList";

			export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"人员ID","姓名","BOSS工号","出生日期","性别","用工状态","身份证号码","联系电话",
				"地市公司","分公司","服务销售中心","渠道编号","入职时间","用工性质","保证金","公务机号码",
				"是否为店主","开通服务标志","网点确认码","空中选号手机号"});
			super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
			
			
		}catch(Exception e){
			super.addActionError("自建他营人员管理TXT出错："+e.getMessage());
		}
		return null;
	}
	
	public String doImport() {
		try {
			Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class, getDBAccessUser());
			param92 = sysparamBO.doFindByID("92", "channel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "toimport";
	}

	public String getParam92() {
		return param92;
	}

	public void setParam92(String param92) {
		this.param92 = param92;
	}
}