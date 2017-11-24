/**
 * auto-generated code
 * Fri Oct 02 10:38:11 CST 2009
 */
 package com.gmcc.pboss.web.resource.resdisform;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.gmcc.pboss.business.base.smstmpl.SmstmplVO;
import com.gmcc.pboss.business.resource.resdisform.ProductDetailVO;
import com.gmcc.pboss.business.resource.resdisform.ResdisformDBParam;
import com.gmcc.pboss.business.resource.resdisform.ResdisformVO;
import com.gmcc.pboss.business.resource.resdisform.ResdisformVOHelper;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.base.smstmpl.Smstmpl;
import com.gmcc.pboss.control.base.smstmpl.SmstmplBO;
import com.gmcc.pboss.control.resource.resdisform.Resdisform;
import com.gmcc.pboss.control.resource.resdisform.ResdisformBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: ResdisformAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class ResdisformAction extends BaseAction{
	private String actionUrl;
	public String getActionUrl() {
		return actionUrl;
	}


	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}


	public ResdisformAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new ResdisformForm());
		this.setParam(new ResdisformWebParam());

        //ָ��VO��
        setClsVO(ResdisformVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"discomcode","disid"};
		this.setClsControl(Resdisform.class);
		this.setClsQueryParam(ResdisformDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	
	//��Ʒ��ϸ
	public String doProductDetail(){
		try{
			
			Resdisform bo = (ResdisformBO)BOFactory.build(ResdisformBO.class,super.getDBAccessUser());
			String[] selectItem = param.get_selectitem();
			String[] params = selectItem[0].split("\\|");
			DataPackage dp = bo.doQueryProductDetail(params[0], params[1],(ResdisformDBParam)super.getParam());
			super.setDp(dp);
		}catch(Exception e){
			super.addActionError(e.getMessage());
		}
		return "productdetail";
	}
	//��Ʒ��ϸ
	public String doExportTxt(){
		try{
			Resdisform bo = (ResdisformBO)BOFactory.build(ResdisformBO.class,super.getDBAccessUser());
			String[] selectItem = param.get_selectitem();
			String[] params = selectItem[0].split("\\|");
			ResdisformDBParam resdisformParam = (ResdisformDBParam)super.getParam();
			resdisformParam.setQueryAll(true);
			resdisformParam.set_pageno("0");
			resdisformParam.setSelectFieldsUseVOType(true);
			
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			export.setFileName("��Դ��ϸ");
			export.addOutputProperty("comcategory", "��Ʒ����",export.CODE2NAME, "$IM_FXCOMCATEGORY");
			export.addOutputProperty("batchno", "��Ʒ����");
			export.addOutputProperty("boxnum", "����");
			export.addOutputProperty("comresid", "����");
			
			export.voClassArray = new Class[] { ProductDetailVO.class };
			prepareResponse(export.getFileName());
			export.queryMethodName = "doProductDetail";

			export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
					"��Ʒ����", "��Ʒ����", "����", "����"});
			super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);

		}catch(Exception e){
			super.addActionError(e.getMessage());
		}
		return null;
	}
	
	//������ҳ��
	public String doGoDeploy(){
		try{
			Resdisform bo = (ResdisformBO)BOFactory.build(ResdisformBO.class,super.getDBAccessUser());
			List<ResdisformVO> list = new ArrayList<ResdisformVO>();
			String[] selectItem = param.get_selectitem();
			String[] pk = null;
			ResdisformVO vo = null;
			String discomcode = "";//�����̱���
			Set discomcodeSet = new HashSet();
			
			for(int i = 0;i<selectItem.length;i++){
				pk = selectItem[i].split("\\|");
				vo = new ResdisformVO();
				vo.setDiscomcode(pk[0]);
				vo.setDisid(pk[1]);
				vo = bo.doFindByPk(vo);
				if( null != vo){
					list.add(vo);
					if(vo.getDiscomcode() != null && !"".equals(vo.getDiscomcode())){
						discomcodeSet.add(vo.getDiscomcode());
					}
				}
			}			
			super.getRequest().setAttribute("resdisformList",list);//���䵥�б�
																					
			ResdisformForm form = (ResdisformForm)super.getForm();
			form.setIssuecode(super.getDBAccessUser().getOprcode());
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			form.setIssutime(format.parse(format.format(new Date())));
			
//			��������ȡ��ϵͳ�������ñ�IB_GL_SYSPARAM������������Ϊ��pboss_fx����������ʶ��30��������޼�¼�����ֵΪ��������������ա�
		/*	Sysparam sysparamBO = (SysparamBO) BOFactory.build(SysparamBO.class,super.getDBAccessUser());
			SysparamVO sysparamVO = new SysparamVO();
			sysparamVO.setParamtype("pboss_fx");
			sysparamVO.setSystemid(new Long(30));
			sysparamVO = sysparamBO.doFindByPk(sysparamVO);
			if( null != sysparamVO){
				form.setSmscontent(sysparamVO.getParamvalue());
			}*/
			//��������ȡ�Զ���ģ���CH_SMS_SMSTMPL�������ű�ʶȡ��IM_SMPISSUE���������������ȡ�����ֶΣ���������ݻ������ֶ�Ϊ�գ��������������
			Smstmpl smstmplBO = (Smstmpl) BOFactory.build(SmstmplBO.class,getDBAccessUser());
			SmstmplVO smstmplVO=smstmplBO.doFindByPk("IM_SMPISSUE");
			if(smstmplVO!=null){
				form.setSmscontent(smstmplVO.getScontent());
			}
			
			
//			���������̱��루LOGISCODE����ѯ������CH_PW_WAY������ȡ�������ϣ��������������ѯ������Ա������Ϣ��(CH_PW_EMPLOYEE)
//			��ƥ���Ƿ�Ϊ�����ֶ�Ϊ�ǣ���ISNET=1����ƥ���ù�״̬Ϊ�ڸڣ���EMPSTATUS=0������ȡ���������������������ֻ����루����������룩��
//			����ѯ������ϱ��浽Session�У�
			
			ResdisformDBParam resdisformParam = new ResdisformDBParam();
			
			int pageSize = 20;
			resdisformParam.setQueryAll(true);

			resdisformParam.set_sin_logiscode(discomcodeSet);
			resdisformParam.setSelectFieldsString("employeeid,employeename, officeTel,wayid,wayname ,logiscode,deploy");
			DataPackage employeeDP = bo.doQueryEmployee(resdisformParam);	
			
			DataPackage dp = new DataPackage();	
			resdisformParam.set_pagesize("20");
			if(employeeDP != null && employeeDP.getDatas() !=null){
				List employeeList = employeeDP.getDatas();
				int end = employeeList.size()>=pageSize? pageSize:employeeList.size();
				super.getRequest().getSession().setAttribute("employeeList",employeeList);	
				dp.setDatas(employeeList.subList(0, end));
			}
			
			
			//��Ϊ��ҳ��Ϣ��ȡ����Ա����employeeDP��ȡ��
			if( null != employeeDP ){
				dp.setPageNo(employeeDP.getPageNo());				
				dp.setRowCount(employeeDP.getRowCount());
			}
			dp.setPageSize(pageSize);
			super.setDp(dp);
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return "deploy";
	}
	
	//������Ϣ��ҳʱ�ã����ݴ�SESSION��ȡ��
	public String doQueryEmployeeByPage(){
		try{
			
			ResdisformDBParam resdisformParam = (ResdisformDBParam) super.getParam();
			
			int pageNo = Integer.parseInt(resdisformParam.get_pageno());
			int pageSize = 20;
			List employeeList = (List)super.getRequest().getSession().getAttribute("employeeList");
			int end = employeeList.size()>=pageSize*(pageNo)? pageSize*(pageNo):employeeList.size();
						
			DataPackage dp = new DataPackage();
			dp.setDatas(employeeList.subList(pageSize*(pageNo-1), end));
			dp.setPageNo(pageNo);
			dp.setPageSize(pageSize);
			dp.setRowCount(employeeList.size());
			super.setDp(dp);
			
		}catch(Exception e){
			super.addActionError(e.getMessage());
		}
		return "deploy";
	}
	
	//�Ƿ�Ե�������
	public String doDeployOrNot(){
		try{
			super.getResponse().getWriter();
			String selectedValue = super.getRequest().getParameter("selected");//��������
			String notSelectedValue = super.getRequest().getParameter("notSelected");//����������
			Map employeeMap = new HashMap();
			if(selectedValue != null && selectedValue.contains(";") ){
				if(selectedValue.endsWith(";"))
					selectedValue = selectedValue.substring(0,selectedValue.lastIndexOf(";"));
				String[] selectedEmployee = selectedValue.split(";");
				for(int i = 0;i<selectedEmployee.length;i++){
					employeeMap.put(selectedEmployee[i], "1");//ѡ�е�ֵΪ1
				}
			}
			
			if(notSelectedValue != null && notSelectedValue.contains(";")){
				if(notSelectedValue.endsWith(";"))
					notSelectedValue = notSelectedValue.substring(0,notSelectedValue.lastIndexOf(";"));
				String[] notSelectedEmployee = notSelectedValue.split(";");
				for(int i = 0;i<notSelectedEmployee.length;i++){
					employeeMap.put(notSelectedEmployee[i], "0");//δѡ�е�ֵΪ0
				}
			}
			
			List<Map> employeeList = (List<Map>)super.getRequest().getSession().getAttribute("employeeList");
			for(Map map:employeeList){				
				if( null != employeeMap.get(map.get("employeeid"))){
					map.put("deploy", employeeMap.get(map.get("employeeid")));
				}				
			}

			super.getResponse().getWriter().write("true");
		}catch(Exception e){
			super.addActionError(e.getMessage());
		}
		return null;
	}
	
	//ȫ��ѡ�񣬻�ȡ��
	public String doChooseOrCancelAll(){
		try{
			String type = super.getRequest().getParameter("type");
			List<Map> employeeList = (List<Map>)super.getRequest().getSession().getAttribute("employeeList");
			if("choose".equals(type)){
				for(Map map :employeeList){
					map.put("deploy", "1");
				}
			}else if("cancel".equals(type)){
				for(Map map :employeeList){
					map.put("deploy", "0");
				}
			}
			
		}catch(Exception e){			
			super.addActionError(e.getMessage());
		}
		return doQueryEmployeeByPage();
	}
	
	
	//����
	public String doDeploy(){
		try{
			String selectItem = param.get_selectitem()[0];
			selectItem = selectItem.replaceAll("\\s+", "");
			String[] pk = selectItem.split(",");
			String key[] = null;
			Resdisform bo = (ResdisformBO)BOFactory.build(ResdisformBO.class,super.getDBAccessUser());
			
			List<Map> employeeList = (List<Map>)super.getRequest().getSession().getAttribute("employeeList");
			List<String> employeeIDList = new ArrayList<String>();
			
			for(Map map:employeeList){
				if("1".equals(map.get("deploy"))){
					employeeIDList.add((String)map.get("employeeid"));
				}
			}
			ResdisformVOHelper voHelper=new ResdisformVOHelper();
			BeanUtils.copyProperties(voHelper, (ResdisformForm)super.getForm());
			String result = bo.batchUpdate(pk, voHelper,employeeIDList);
			
			ResdisformVO vo = null;
			List<ResdisformVO> list = new ArrayList<ResdisformVO>();
			for(int i = 0;i<pk.length;i++){
				key = pk[i].split("\\|");
				vo = new ResdisformVO();
				vo.setDiscomcode(key[0]);
				vo.setDisid(key[1]);
				vo = bo.doFindByPk(vo);
				if( null != vo){
					list.add(vo);
				}
			}			
			super.getRequest().setAttribute("resdisformList",list);//���䵥�б�
																				
				super.addActionMessage("�������  "+result);

			super.setCMD(super.WEB_CMD_SAVE);
		}catch(Exception e){
			super.addActionError(e.getMessage());
		}
		return "deploy";
	}
	public String signlist() throws Exception {
		try{
			Resdisform bo=(Resdisform)BOFactory.build(ResdisformBO.class,super.getDBAccessUser());
			ResdisformWebParam param=(ResdisformWebParam)super.getParam();
			DataPackage dp = bo.doQuery(param);
			super.setDp(dp);
		}catch(Exception e){
			super.addActionError(e.getMessage());
		}
		return "signlist";
	}
	/**
	 * ǩ��
	 * @return
	 * @throws Exception
	 */
	public String sign() throws Exception {
		Resdisform resdisform=(Resdisform)BOFactory.build(ResdisformBO.class,super.getDBAccessUser());
		String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
		
		if(selectArray == null) {
			addActionError("�޷���ȡѡ����Ŀ��");
			return "list";
		}
		Serializable pkVO=null;
		ResdisformVO vo=null;
		for(String str:selectArray){
			pkVO=getSelectedPkVO(str);
			vo=resdisform.doFindByPk(pkVO);
			vo.setDisformstate("SIGNED");
			vo.setSigntime(new Date());
			vo.setSigncode(super.getDBAccessUser().getOprcode());
			resdisform.doUpdate(vo);
		}
		return super.doList();
	}
	
	
	
	
}