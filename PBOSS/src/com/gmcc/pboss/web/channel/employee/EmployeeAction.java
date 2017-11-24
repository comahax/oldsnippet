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
	private String processType;//�������� MANAGER:�����������
	// ϵͳ���������������Ա��������ҵ��
	private String param92;
	
	/**���������Ա���������Ŀ�ѡ�ֶ�*/
	private String[][] employeeOptionFeilds = new String[][] {
			{"employeeid", "��Ա���",null,""},{"employeename", "����",null,""},{"birthday", "��������",ExportDataCreator.DATE,"yyyy-MM-dd"},
			{"sex", "�Ա�",ExportDataCreator.CODE2NAME,"$CH_SEX"},{"empstatus", "�ù�״̬",ExportDataCreator.CODE2NAME,"$CH_EMPSTATUS"},
			{"cardid", "���֤����",null,""},{"telephone", "��ϵ�绰",null,""},{"cityid", "���й�˾",ExportDataCreator.CODE2NAME,"#CITYCOMPANY"},
			{"countyid", "�ֹ�˾",ExportDataCreator.CODE2NAME,"#CNTYCOMPANY"},{"svccode", "������������",ExportDataCreator.CODE2NAME,"#SERVCENT"},
			{"wayid", "��������",ExportDataCreator.CODE2NAME,"#WAYIDINFO"},
			{"wayid", "�������",null,""},{"intime", "��ְʱ��",ExportDataCreator.DATE,"yyyy-MM-dd"},
			{"employtype", "�ù�����",ExportDataCreator.CODE2NAME,"$CH_EMPLOYTYPE"},{"bail", "��֤��",null,""},{"officetel", "���������",null,""},
			{"isnet", "�Ƿ�Ϊ����",ExportDataCreator.CODE2NAME,"$CH_ISNET"},
			{"netpass", "����ȷ����",null,""},{"selectmobile", "����ѡ���ֻ���",null,""}
	};
	/**�����������������Ŀ�ѡ�ֶ�*/
	private String[][] magOptionFeilds = new String[][] {
			{"employeeid", "��ԱID",null,""},{"oprcode2", "BOSS����",null,""},{"employeename", "����",null,""},{"sex", "�Ա�",ExportDataCreator.CODE2NAME,"$CH_SEX"},
			{"telephone", "�ֻ���",null,""},{"cityid", "���й�˾",ExportDataCreator.CODE2NAME,"#CITYCOMPANY"},{"countyid", "�ֹ�˾",ExportDataCreator.CODE2NAME,"#CNTYCOMPANY"},
			{"svccode", "������������",ExportDataCreator.CODE2NAME,"#SERVCENT"},{"mareacode", "΢����",ExportDataCreator.CODE2NAME,"#MICROAREA"},{"wayid", "������(��������)",ExportDataCreator.CODE2NAME,"#WAYIDINFO"},{"station","��λ",ExportDataCreator.CODE2NAME,"POSTINFO"},
			{"intime", "��ְʱ��",ExportDataCreator.DATE,"yyyy-MM-dd"},{"employtype", "�ù�����",ExportDataCreator.CODE2NAME,"$CH_EMPLOYTYPE"},{"empstatus", "�ù�״̬",ExportDataCreator.CODE2NAME,"$CH_EMPSTATUS"},
			{"birthday", "��������",ExportDataCreator.DATE,"yyyy-MM-dd"},{"edulevel", "�Ļ��̶�",ExportDataCreator.CODE2NAME,"$CH_EDULEVEL"},{"nativehome", "����",ExportDataCreator.CODE2NAME,"$CH_NATIVE"},
			{"polivisage", "������ò",ExportDataCreator.CODE2NAME,"$CH_POLIVISAGE"},{"homeaddr", "��ͥ��ַ",null,""},{"cardid", "���֤����",null,""},{"pvtemail", "���˵�������",null,""},{"ofcphone", "��˾ר����ϵ��ʽ",null,""},
			{"speciality", "רҵ",null,""},{"officetel", "�����ֻ�����",null,""},{"gradschool", "��ҵԺУ",null,""},{"gradtime", "��ҵʱ��",ExportDataCreator.DATE,"yyyy-MM-dd"},{"contacttype","�Ͷ���ϵ",ExportDataCreator.CODE2NAME,"$CH_CONTACTTYPE"},
			{"posittype", "��λ����",ExportDataCreator.CODE2NAME,"POSITTYPE"},{"joblevel", "ְ��",ExportDataCreator.CODE2NAME,"$CH_JOBLEVEL"},{"department", "���ڲ���",null,""},{"worktime", "�μӹ�������",null,""},
			{"company", "��������˾",null,""},{"hereworktime", "����˾��������",null,""},{"ismarried", "����״��",ExportDataCreator.CODE2NAME,"$CH_ISMARRIED"}
	};
	public EmployeeAction() {
		super();

		//????????��?����??��?????
		this.setForm(new EmployeeForm());
		this.setParam(new EmployeeWebParam());

        //???��VO?��
        setClsVO(EmployeeVO.class);
        //???��?��?��??����?????????????��?��???��?��???��?????????��?��??��???????
        this.pkNameArray=new String[]{"employeeid"};
		this.setClsControl(Employee.class);
		this.setClsQueryParam(EmployeeWebParam.class) ;

		/**
		 * ???????��??????????????????BaseAction??CRUD???��?��?????��??Delegate????��??��??????��????��
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
		if ("MANAGER".equals(this.processType)) {// ���������б�
			try {
				DataPackage dp = bo.doManagerQuery(loginUser.getWayid(),
						(EmployeeWebParam) param);
				super.setDp(dp);
			} catch (Exception e) {
				super.addActionError(e.getMessage());
			}
			return "managerlist";
		} else if("ZJTY".equals(this.processType)){//�Խ���Ӫ���б�
			try {
				DataPackage dp = bo.doZjtyQuery(loginUser.getWayid(),
						(EmployeeWebParam) param);
				super.setDp(dp);
			} catch (Exception e) {
				super.addActionError(e.getMessage());
			}
			return "zjtylist";
		}
			else{// ���������Ա�����б�
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
			super.addActionError("��������"+e.getMessage());
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
			//��ѯ��������Դ
			WayVO vo=way.doFindByPk(form.getWayid());
			form.setWayidAndName(form.getWayid()+" "+vo.getWayname());
			super.getRequest().setAttribute("countyid",(form.getCountyid() == null || "".equals(form.getCountyid()))? "1<>1":form.getCountyid());
			return "managercontent";
		}
		else if("ZJTY".equals(this.processType)){
			EmployeeForm employeeForm = (EmployeeForm) super.getForm();
			Way way = (Way) BOFactory.build(WayBO.class, super.getDBAccessUser());
			//��ѯ��������Դ
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
			//��ѯ��������Դ
			WayVO vo=way.doFindByPk(employeeForm.getWayid());
			if(vo!=null && vo.getWaysubtype()!=null)
			{
				employeeForm.setWaysubtype(vo.getWaysubtype());
			}
			
//			ȫԱ����ģʽ��ѡ������  ȷ��by��ï
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
							throw new Exception("���� ����Ա["+ employeeForm.getEmployeeid() + "]�Ѿ�����");
						}
					}
					employeeForm.setWaytype("ET");
					employeeForm.setEmployeeid(employeeForm.getOprcode2());//Ĭ�ϸ�ֵΪ¼��Ĺ���
					super.doSave();
					return "managercontent";
				}
				// employeeForm.setEmployeeid(employeeForm.getOprcode());
				Operator operator = (Operator) BOFactory.build(OperatorBO.class, super.getDBAccessUser());
				if (!"".equals(employeeForm.getOprcode2())){
				if( null == operator.doFindByPk(employeeForm.getOprcode2())){//��֤��Ա�Ƿ��ڲ���Ա����
					throw new Exception("���� ����Ա["+ employeeForm.getOprcode2() + "] ���ڹ��ű��� ");
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
							throw new Exception("���� ����Ա["+ employeeForm.getEmployeeid() + "]�Ѿ�����");
						}
					}
					EmployeeVO vo = new EmployeeVO();
					BeanUtils.copyProperties(vo, employeeForm);
					vo = bo.doCreateSociety(vo, super.getDBAccessUser());
					BeanUtils.copyProperties(getForm(), vo);
					setCMD(WEB_CMD_SAVE);
					addActionMessage("����ɹ�");
					return "zjtycontent";
				}
				// employeeForm.setEmployeeid(employeeForm.getOprcode());
				Operator operator = (Operator) BOFactory.build(OperatorBO.class, super.getDBAccessUser());
				if (!"".equals(employeeForm.getOprcode2())){
				if( null == operator.doFindByPk(employeeForm.getOprcode2())){//��֤��Ա�Ƿ��ڲ���Ա����
					throw new Exception("���� ����Ա["+ employeeForm.getOprcode2() + "] ���ڹ��ű��� ");
				}
				}
				EmployeeVO vo = new EmployeeVO();
				BeanUtils.copyProperties(vo, employeeForm);
				vo = bo.doUpdate(vo,super.getDBAccessUser());
				BeanUtils.copyProperties(getForm(), vo);
				setCMD(WEB_CMD_SAVE);
				addActionMessage("����ɹ�");
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
//					//			ȫԱ����ģʽ��ѡ������  ȷ��by��ï
//					// ����ģʽ ����Begin
//					String[] agentmodeArr = (String[])request.getParameterValues("agentmode_checkbox");
//					Empmodel modelBO = (Empmodel)BOFactory.build(EmpmodelBO.class, super.getDBAccessUser());
//					
//					modelVO = new EmpmodelVO();
//					// ������¼����Ա����ģʽ��
//					modelVO.setEmployeeid(vo.getEmployeeid());
//					modelVO.setModel("3"); //����ģʽ����3��ȫԱ����ģʽ��
//					
//					if(agentmodeArr != null && agentmodeArr.length > 0) {
//						//����й�ѡȫԱ����ģʽ,
//						modelVO.setState(Short.parseShort("0"));//״̬�ֶ�Ϊ0����
//					}else {
//						//���δ��ѡȫԱ����ģʽ,
//						modelVO.setState(Short.parseShort("1"));//״̬�ֶ�Ϊ1�˳�
//					}
//					modelVO = modelBO.doCreate(modelVO);
//					
//					// ����ģʽ ����End
					
				} else {
					Employee bo = (EmployeeBO) BOFactory.build(
							EmployeeBO.class, super.getDBAccessUser());
					EmployeeVO vo = new EmployeeVO();
					BeanUtils.copyProperties(vo, employeeForm);
					vo = bo.doUpdate(vo,super.getDBAccessUser());
					BeanUtils.copyProperties(getForm(), vo);
////					ȫԱ����ģʽ��ѡ������  ȷ��by��ï
//					// ����ģʽ ����Begin
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
//					if(empmodelid != null && modelState != null && modelState == 0) { // ��Ա����ģʽ��¼������״̬Ϊ0����
//						if(agentmodeArr != null && agentmodeArr.length > 0) {
//							// �����ѡȫԱ����ģʽ����ʲô������Ҫ��
//						}else{
//							// ���δ��ѡȫԱ����ģʽ
//							DataPackage dp = modelBO.doQuery(modelParam);
//							List<EmpmodelVO> list = dp.getDatas();
//							if(list.size() > 0) {
//								//����д��ڼ�¼������¼�¼�е�״̬�ֶε���1���˳�����
//								modelVO = list.get(0);
//								modelVO.setState(Short.parseShort("1"));
//								modelVO = modelBO.doUpdate(modelVO);
//							}
//						}
//					} else if(empmodelid != null && modelState != null && modelState == 1){ // ��Ա����ģʽ��¼������״̬Ϊ1�˳�
//						if(agentmodeArr != null && agentmodeArr.length > 0) {
//							// �����ѡȫԱ����ģʽ
//							DataPackage dp = modelBO.doQuery(modelParam);
//							List<EmpmodelVO> list = dp.getDatas();
//							if(list.size() > 0) {
//								//����д��ڼ�¼������¼�¼�е�״̬�ֶε���0����������
//								modelVO = list.get(0);
//								modelVO.setState(Short.parseShort("0"));
//								modelVO = modelBO.doUpdate(modelVO);
//							}
//						}
//					}else if((empmodelid != null && modelState == null) 
//							|| empmodelid == null){ // ��Ա����ģʽ��¼������״̬Ϊ�� ���� ��Ա����ģʽ��¼������
//						// ��������¼����Ա����ģʽ��
//						modelVO = new EmpmodelVO();
//						modelVO.setEmployeeid(vo.getEmployeeid());
//						modelVO.setModel("3"); //����ģʽ����3��ȫԱ����ģʽ��
//						if(agentmodeArr != null && agentmodeArr.length > 0) {
//							//����й�ѡȫԱ����ģʽ��,״̬Ϊ0������
//							modelVO.setState(Short.parseShort("0"));
//						}else{
//							//���δ��ѡȫԱ����ģʽ��,״̬Ϊ1�˳���
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
				// ����ģʽ ����End
				setCMD(WEB_CMD_SAVE);
				addActionMessage("����ɹ�");
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
	 * ����������Ϣ������
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
			export.setFileName("����������Ϣ����");
			// export.addOutputProperty(0,"business","Ӫҵ��",null,null);
//			export.addOutputProperty("employeeid", "��ԱID");
//			export.addOutputProperty("oprcode2", "BOSS����");
//			export.addOutputProperty("employeename", "����");
//			export.addOutputProperty("sex", "�Ա�",export.CODE2NAME, "$CH_SEX");
//			export.addOutputProperty("telephone", "��ϵ�绰");
//			export.addOutputProperty("cityid", "���й�˾",export.CODE2NAME, "#CITYCOMPANY");
//			export.addOutputProperty("countyid", "�ֹ�˾",export.CODE2NAME, "#CNTYCOMPANY");
//			export.addOutputProperty("svccode", "������������",export.CODE2NAME, "#SERVCENT");
//			export.addOutputProperty("wayid", "������������������",export.CODE2NAME, "#WAYIDINFO");
//			export.addOutputProperty("station", "��λ",export.CODE2NAME, "POSTINFO");
//			export.addOutputProperty("intime", "��ְʱ��",export.DATE,"yyyy-MM-dd");
//			export.addOutputProperty("employtype", "�ù�����",export.CODE2NAME, "$CH_EMPLOYTYPE");

			String selectedFields = getRequest().getParameter("selectedFields");
			String[] sfArray = selectedFields.split(",");
			for(int i = 0;i < sfArray.length;i++) {
				int k = Integer.parseInt(sfArray[i]);
				export.addOutputProperty(magOptionFeilds[k][0],magOptionFeilds[k][1],magOptionFeilds[k][2],magOptionFeilds[k][3]);
			}
			
			export.appendEndLine(new String[] { "��������:",user.getOprcode() });
			export.appendEndLine(new String[] { "��������:", user.getWayid() });
			
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
			return super.doExcel();
		}catch(Exception e){
			super.addActionError(e.getMessage());
		}
		return null;
	}
	
	
	/**
	 * ��Ͻ���㵼������
	 * @return
	 */
	public String doMgrWayExcel() {
		try{
			HttpServletRequest request = ServletActionContext.getRequest();
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			export.setFileName("��Ͻ������Ϣ");
			export.addOutputProperty("wayid", "��������");
			export.addOutputProperty("wayname", "��������");
			export.addOutputProperty("officetel", "���������");
//			export.addOutputProperty("isopen", "��ͨ��־", export.CODE2NAME,"$CH_ISOPEN");
			export.addOutputProperty("waysubtype", "�����������",export.CODE2NAME, "#WAYTYPE");
			export.addOutputProperty("upperwayid", "�ϼ�����",export.CODE2NAME, "#WAYIDINFO");
			export.addOutputProperty("latitude", "γ��");
			export.addOutputProperty("longtitude", "����");
			export.addOutputProperty("starlevel", "�Ǽ�", export.CODE2NAME,"$CH_STARLEVEL");
			export.addOutputProperty("pt", "������", export.CODE2NAME,"$CH_PT");
			export.addOutputProperty("isstraitprd", "�Ƿ�ֱ��",export.CODE2NAME, "$CH_STRAITPRD");
			export.addOutputProperty("catetype", "��������", export.CODE2NAME,"$CH_CATETYPE");
			export.addOutputProperty("cityid", "���й�˾", export.CODE2NAME,"#CITYCOMPANY");
			export.addOutputProperty("countyid", "�ֹ�˾", export.CODE2NAME,"#CNTYCOMPANY");
			export.addOutputProperty("svccode", "������������", export.CODE2NAME,"#SERVCENT");
			export.addOutputProperty("mareacode", "΢����", export.CODE2NAME,"#CH_MICROAREA");
			export.addOutputProperty("adtypecode", "��������",export.CODE2NAME, "$CH_ADTYPE");
			export.addOutputProperty("adacode", "��������", export.CODE2NAME,"#CH_ADIMAREA");
			export.addOutputProperty("formtype", "ҵ̬����", export.CODE2NAME,"$CH_FORMTYPE");
			export.addOutputProperty("starttime", "������ʼʱ��", export.DATE,"yyyy-MM-dd");
			export.addOutputProperty("buzarea", "�ƶ�ר�����");
			export.addOutputProperty("logiscode", "����������");
			export.addOutputProperty("waymagcode", "������������");
			export.addOutputProperty("bchlevel", "�ּ�", export.CODE2NAME,"$CH_BCHLEVEL");
			export.addOutputProperty("waystate", "״̬", export.CODE2NAME,"$CH_VALIDFLAG");

			export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
			export.appendHeadLine(new String[] { "��������:", user.getWayid() });
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
	 * ��Ͻ�����ѯ
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
	
		//ͨ���������ȡ��CITYID,����,COUNTYID������
	//���: countyid:countyname,cityid:cityname
	public void doGetWayInfo1(){
		try{
			String result = "";
			EmployeeForm employeeForm = (EmployeeForm) super.getForm();
			String wayid = employeeForm.getWayid();
			Way wayBO = (WayBO) BOFactory.build(WayBO.class, super.getDBAccessUser());
			//��ѯPBOSS���ݿ������,��������һ��.
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
				//����WAYSUBTYPE��ֵ
				result+=(null==wayVO.getWaysubtype()?"":wayVO.getWaysubtype());
			}
			System.out.println(result);
			super.getResponse().getWriter().write(result);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	
	//���������Ա����TXT
	public String  doExporttxt(){
		try{
			EmployeeWebParam employeeParam = (EmployeeWebParam) super.getParam();
			employeeParam.setQueryAll(true);
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			export.setFileName("���������Ա");
			String selectedFields = getRequest().getParameter("selectedFields");
			// sfArray���� ��ÿ����ѡ�ֶ���employeeOptionFeilds��һάԪ�ص��±�ֵ
			String[] sfArray = selectedFields.split(",");
			// titleArray ��ѡ�ֶ���������
			String[] titleArray = new String[sfArray.length];
			for(int i = 0;i < sfArray.length;i++) {
				int k = Integer.parseInt(sfArray[i]);
				export.addOutputProperty(employeeOptionFeilds[k][0],employeeOptionFeilds[k][1],employeeOptionFeilds[k][2],employeeOptionFeilds[k][3]);
				titleArray[i] = employeeOptionFeilds[k][1];
			}
			/*export.addOutputProperty("employeeid", "��Ա���");
			export.addOutputProperty("employeename", "����");
			export.addOutputProperty("birthday", "��������",export.DATE,"yyyy-MM-dd");
			export.addOutputProperty("sex", "�Ա�",export.CODE2NAME,"$CH_SEX");
			export.addOutputProperty("empstatus", "�ù�״̬",export.CODE2NAME,"$CH_EMPSTATUS");
			export.addOutputProperty("cardid", "���֤����");
			export.addOutputProperty("telephone", "��ϵ�绰");
			export.addOutputProperty("cityid", "���й�˾",export.CODE2NAME,"#CITYCOMPANY");
			export.addOutputProperty("countyid", "�ֹ�˾",export.CODE2NAME,"#CNTYCOMPANY");
			export.addOutputProperty("svccode", "������������",export.CODE2NAME,"#SERVCENT");
			export.addOutputProperty("wayid", "�������",export.CODE2NAME,"#WAYIDINFO");
			export.addOutputProperty("intime", "��ְʱ��",export.DATE,"yyyy-MM-dd");
			export.addOutputProperty("employtype", "�ù�����",export.CODE2NAME,"$CH_EMPLOYTYPE");
			export.addOutputProperty("bail", "��֤��");
			export.addOutputProperty("officetel", "���������");
			export.addOutputProperty("isnet", "�Ƿ�Ϊ����",export.CODE2NAME,"$CH_ISNET");
			export.addOutputProperty("isopen", "��ͨ�����־",export.CODE2NAME,"$CH_ISOPEN");
			export.addOutputProperty("netpass", "����ȷ����");
			export.addOutputProperty("selectmobile", "����ѡ���ֻ���");*/
			
			
			export.voClassArray = new Class[] { EmployeeVO.class };
			prepareResponse(export.getFileName());
			export.queryMethodName = "doList";

			export.writeTxtTitle(getResponse().getOutputStream(), titleArray);
			super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
			
			
		}catch(Exception e){
			super.addActionError("�������������ԱTXT����"+e.getMessage());
		}
		return null;
	}
	

	//���������Ա����Excel
	public String  doExportExcel(){
		try{
			EmployeeWebParam employeeParam = (EmployeeWebParam) super.getParam();
			employeeParam.setQueryAll(true);
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			export.setFileName("���������Ա");
			String selectedFields = getRequest().getParameter("selectedFields");
			// sfArray���� ��ÿ����ѡ�ֶ���employeeOptionFeilds��һάԪ�ص��±�ֵ
			String[] sfArray = selectedFields.split(",");
			// titleArray ��ѡ�ֶ���������
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
			super.addActionError("�������������ԱExcel����"+e.getMessage());
		}
		return null;
	}
	
	
	
  
	//���ɼ�ƽ̨�����ֻ���,¼��Ĳɼ�ƽ̨�ֻ��Ŷ����ڸڵ���Щ��Ա��Ψһ��  
	public String doCheckOfficetel(){
		try{
			String result = "";
			EmployeeForm form = (EmployeeForm) super.getForm();
			Employee bo = (EmployeeBO) BOFactory.build(
					EmployeeBO.class, super.getDBAccessUser());
			EmployeeWebParam param = new EmployeeWebParam();
			param.set_ne_empstatus("0");//0���ڸ�
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
	//�����������--���ֻ��ţ�¼������ڸ���ԱΨһ����֤
	public String doCheckOfficetel2(){
		try{
			String result = "";
			EmployeeForm form = (EmployeeForm) super.getForm();
			Employee bo = (EmployeeBO) BOFactory.build(
					EmployeeBO.class, super.getDBAccessUser());
			EmployeeWebParam param = new EmployeeWebParam();
			param.set_ne_empstatus("0");//0���ڸ�
			param.set_se_officetel(form.getOfficetel());
			param.set_sne_employeeid(form.getEmployeeid()); 
			SysparamBO sysparamBO = (SysparamBO) BOFactory.build(SysparamBO.class,super.getDBAccessUser());
			
			// ϵͳ����76��1:����������������� 0:��������û�в������� ��:��������û�в������� 
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
	 * ����ֻ������Ƿ��ڱ�������Ψһ
	 * 
	 * @param officetel
	 * @param user
	 */
	//ע:�տ�������Ա��֪������߼�.©����.�¸��汾����.
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
	 * ���������Ա�����ѯ
	 * 
	 */
	public String doSocietylist() throws Exception {
		User loginUser = (User) ActionContext.getContext().getSession().get(
				WebConstant.SESSION_ATTRIBUTE_USER);
		Employee bo = (EmployeeBO) BOFactory.build(EmployeeBO.class, super
				.getDBAccessUser());
		AGWay agway = (AGWay)BOFactory.build(AGWayBO.class, getDBAccessUser());
		EmployeeWebParam listVO = (EmployeeWebParam)super.getParam();
		listVO.set_se_waytype("AG");// ��ͨ��������,���������
		DataPackage dp = bo.doQuerybywayid(loginUser.getWayid(),listVO);
		// pack.setPageSize(20);
		// ���
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
	 * �Խ���Ӫ��Ա�����ѯ
	 * 
	 */
	public String doZjtylist() throws Exception {
		User loginUser = (User) ActionContext.getContext().getSession().get(
				WebConstant.SESSION_ATTRIBUTE_USER);
		Employee bo = (EmployeeBO) BOFactory.build(EmployeeBO.class, super
				.getDBAccessUser());
		AGWay agway = (AGWay)BOFactory.build(AGWayBO.class, getDBAccessUser());
		EmployeeWebParam listVO = (EmployeeWebParam)super.getParam();
		listVO.set_se_waytype("AG");// ��ͨ��������,���������
		DataPackage dp = bo.doZjtyQuery(loginUser.getWayid(),listVO);
		// pack.setPageSize(20);
		// ���
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
	 * ȡ���������
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
			super.addActionMessage("ϵͳ���յ�����˶���������˶�������Ҫ������ʱ�䣬�����ĵȴ�!");
		} catch (Exception e) {
			super.addActionError(e.getMessage());
			throw e;
		} finally {
			return this.doSocietylist();
		}
	}
	/**
	 * �Խ���Ӫ��Ա��Ϣ������
	 * @return
	 */
//	{"employeeid", "��Ա���",null,""},{"employeename", "����",null,""},{"birthday", "��������",ExportDataCreator.DATE,"yyyy-MM-dd"},
//	{"sex", "�Ա�",ExportDataCreator.CODE2NAME,"$CH_SEX"},{"empstatus", "�ù�״̬",ExportDataCreator.CODE2NAME,"$CH_EMPSTATUS"},
//	{"cardid", "���֤����",null,""},{"telephone", "��ϵ�绰",null,""},{"cityid", "���й�˾",ExportDataCreator.CODE2NAME,"#CITYCOMPANY"},
//	{"countyid", "�ֹ�˾",ExportDataCreator.CODE2NAME,"#CNTYCOMPANY"},{"svccode", "������������",ExportDataCreator.CODE2NAME,"#SERVCENT"},
//	{"wayid", "�������",ExportDataCreator.CODE2NAME,"#WAYIDINFO"},{"intime", "��ְʱ��",ExportDataCreator.DATE,"yyyy-MM-dd"},
//	{"employtype", "�ù�����",ExportDataCreator.CODE2NAME,"$CH_EMPLOYTYPE"},{"bail", "��֤��",null,""},{"officetel", "���������",null,""},
//	{"isnet", "�Ƿ�Ϊ����",ExportDataCreator.CODE2NAME,"$CH_ISNET"},{"isopen", "��ͨ�����־",ExportDataCreator.CODE2NAME,"$CH_ISOPEN"},
//	{"netpass", "����ȷ����",null,""},{"selectmobile", "����ѡ���ֻ���",null,""}
	public String doZjtyExcel(){
		try{
			EmployeeWebParam employeeParam = (EmployeeWebParam)super.getParam();
			employeeParam.setQueryAll(true);
			HttpServletRequest request = ServletActionContext.getRequest();
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			export.setFileName("�Խ���Ӫ��Ա����");
			// export.addOutputProperty(0,"business","Ӫҵ��",null,null);
			export.addOutputProperty("employeeid", "��ԱID");
			export.addOutputProperty("employeename", "����");
			export.addOutputProperty("oprcode2", "BOSS����");
			export.addOutputProperty("birthday", "��������",export.DATE,"yyyy-MM-dd");
			export.addOutputProperty("sex", "�Ա�",export.CODE2NAME, "$CH_SEX");
			export.addOutputProperty("empstatus", "�ù�״̬",export.CODE2NAME, "$CH_EMPSTATUS");
			export.addOutputProperty("cardid", "���֤����");
			export.addOutputProperty("telephone", "��ϵ�绰");
			export.addOutputProperty("cityid", "���й�˾",export.CODE2NAME, "#CITYCOMPANY");
			export.addOutputProperty("countyid", "�ֹ�˾",export.CODE2NAME, "#CNTYCOMPANY");
			export.addOutputProperty("svccode", "������������",export.CODE2NAME, "#SERVCENT");
			export.addOutputProperty("wayid", "�������",export.CODE2NAME, "#WAYIDINFO");
			export.addOutputProperty("intime", "��ְʱ��",export.DATE,"yyyy-MM-dd");
			export.addOutputProperty("employtype", "�ù�����",export.CODE2NAME, "$CH_EMPLOYTYPE");
			export.addOutputProperty("bail", "��֤��");
			export.addOutputProperty("officetel", "���������");
			export.addOutputProperty("isnet", "�Ƿ�Ϊ����",export.CODE2NAME, "$CH_ISNET");
			export.addOutputProperty("isopen", "��ͨ�����־",export.CODE2NAME, "$CH_ISOPEN");
			export.addOutputProperty("netpass", "����ȷ����");
			export.addOutputProperty("selectmobile", "����ѡ���ֻ���");

			export.appendEndLine(new String[] { "��������:",user.getOprcode() });
			export.appendEndLine(new String[] { "��������:", user.getWayid() });
			
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
			return super.doExcel();
		}catch(Exception e){
			super.addActionError(e.getMessage());
		}
		return null;
	}
	
	//�Խ���Ӫ��Ա����TXT
	public String  doZjtyTxt(){
		try{
			EmployeeWebParam employeeParam = (EmployeeWebParam) super.getParam();
			employeeParam.setQueryAll(true);
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			export.setFileName("�Խ���Ӫ��Ա����");
//			String selectedFields = getRequest().getParameter("selectedFields");
//			// sfArray���� ��ÿ����ѡ�ֶ���employeeOptionFeilds��һάԪ�ص��±�ֵ
//			String[] sfArray = selectedFields.split(",");
//			// titleArray ��ѡ�ֶ���������
//			String[] titleArray = new String[sfArray.length];
//			for(int i = 0;i < sfArray.length;i++) {
//				int k = Integer.parseInt(sfArray[i]);
//				export.addOutputProperty(employeeOptionFeilds[k][0],employeeOptionFeilds[k][1],employeeOptionFeilds[k][2],employeeOptionFeilds[k][3]);
//				titleArray[i] = employeeOptionFeilds[k][1];
//			}
			export.addOutputProperty("employeeid", "��ԱID");
			export.addOutputProperty("employeename", "����");
			export.addOutputProperty("oprcode2", "BOSS����");
			export.addOutputProperty("birthday", "��������",export.DATE,"yyyy-MM-dd");
			export.addOutputProperty("sex", "�Ա�",export.CODE2NAME, "$CH_EMPSTATUS");
			export.addOutputProperty("empstatus", "�ù�״̬",export.CODE2NAME, "$CH_SEX");
			export.addOutputProperty("cardid", "���֤����");
			export.addOutputProperty("telephone", "��ϵ�绰");
			export.addOutputProperty("cityid", "���й�˾",export.CODE2NAME, "#CITYCOMPANY");
			export.addOutputProperty("countyid", "�ֹ�˾",export.CODE2NAME, "#CNTYCOMPANY");
			export.addOutputProperty("svccode", "������������",export.CODE2NAME, "#SERVCENT");
			export.addOutputProperty("wayid", "�������",export.CODE2NAME, "#WAYIDINFO");
			export.addOutputProperty("intime", "��ְʱ��",export.DATE,"yyyy-MM-dd");
			export.addOutputProperty("employtype", "�ù�����",export.CODE2NAME, "$CH_EMPLOYTYPE");
			export.addOutputProperty("bail", "��֤��");
			export.addOutputProperty("officetel", "���������");
			export.addOutputProperty("isnet", "�Ƿ�Ϊ����",export.CODE2NAME, "$CH_ISNET");
			export.addOutputProperty("isopen", "��ͨ�����־",export.CODE2NAME, "$CH_ISOPEN");
			export.addOutputProperty("netpass", "����ȷ����");
			export.addOutputProperty("selectmobile", "����ѡ���ֻ���");
			
			
			export.voClassArray = new Class[] { EmployeeVO.class };
			prepareResponse(export.getFileName());
			export.queryMethodName = "doList";

			export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"��ԱID","����","BOSS����","��������","�Ա�","�ù�״̬","���֤����","��ϵ�绰",
				"���й�˾","�ֹ�˾","������������","�������","��ְʱ��","�ù�����","��֤��","���������",
				"�Ƿ�Ϊ����","��ͨ�����־","����ȷ����","����ѡ���ֻ���"});
			super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
			
			
		}catch(Exception e){
			super.addActionError("�Խ���Ӫ��Ա����TXT����"+e.getMessage());
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