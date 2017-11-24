/**
 * auto-generated code
 * Tue Jun 05 08:32:39 CST 2012
 */
 package com.gmcc.pboss.web.channel.checkedapplystat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gmcc.pboss.business.channel.checkedapply.CheckedapplyDBParam;
import com.gmcc.pboss.business.channel.checkedapply.CheckedapplyVO;
import com.gmcc.pboss.business.channel.checkedapply.ViewCDDetailVO;
import com.gmcc.pboss.business.channel.checkedapply.ViewCDVO;
import com.gmcc.pboss.business.channel.checkedapplydetail.CheckedapplydetailDBParam;
import com.gmcc.pboss.business.channel.checkedapplydetail.CheckedapplydetailVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.checkedapply.Checkedapply;
import com.gmcc.pboss.control.channel.checkedapply.CheckedapplyBO;
import com.gmcc.pboss.control.channel.checkedapplydetail.Checkedapplydetail;
import com.gmcc.pboss.control.channel.checkedapplydetail.CheckedapplydetailBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: CheckedapplyAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class CheckedapplyStatAction extends BaseAction{
	private static final Long APPSTATUS_SYSID = 83L;
	private static final String APPSTATUS_SYSTYPE = "channel";
	public CheckedapplyStatAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new CheckedapplyForm());
		this.setParam(new CheckedapplyDBParam());

        //ָ��VO��
        setClsVO(CheckedapplyVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"applyno"};
		this.setClsControl(Checkedapply.class);
		this.setClsQueryParam(CheckedapplyDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	private boolean hasMutilAppstauts()throws Exception{
		Sysparam sysBO = (Sysparam)BOFactory.build(SysparamBO.class, this.getDBAccessUser());
		String sysvalue = sysBO.doFindByID(APPSTATUS_SYSID, APPSTATUS_SYSTYPE);
		if(sysvalue!=null && "1".equals(sysvalue.trim())){
			//��ϵͳ����Ϊ��systemid=83, paramtype=��channel��)����ֵΪ1ʱ������״̬�̶������á�CH_APPSTATUS_GZ��
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public String doList() throws Exception {
		// TODO Auto-generated method stub
		try{
			Checkedapply checkedapplyBO = (Checkedapply) BOFactory.build(CheckedapplyBO.class, getDBAccessUser());
			CheckedapplyDBParam checkedapplyDBParam = (CheckedapplyDBParam)getParam();
			if(this.hasMutilAppstauts()){//��ϵͳ����Ϊ��systemid=83, paramtype=��channel��)����ֵΪ1ʱ������״̬�̶������á�CH_APPSTATUS_GZ��				
				checkedapplyDBParam.setAPPSTATUS_MULTI(true);
			}else{
				checkedapplyDBParam.setAPPSTATUS_MULTI(false);
			}
			checkedapplyDBParam.set_se_cityid(this.getDBAccessUser().getCityid());//���ܲ�ѯ����������������
			//Ĭ�ϰ��������ʼʱ���ѯ
			if(null == checkedapplyDBParam.get_dnl_aptime() )
				checkedapplyDBParam.set_dnl_aptime(PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd")+" 00:00:00");
			if(null == checkedapplyDBParam.get_dnm_aptime() )
				checkedapplyDBParam.set_dnm_aptime(PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd")+" 23:59:59");
			
			DataPackage temPackage = checkedapplyBO.doQueryCheckedapplyStat(checkedapplyDBParam);
			
			this.setDp(temPackage);
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return WEB_RESULT_LIST;
	}
	
	public String doListdetail() throws Exception {
		CheckedapplyDBParam checkedapplyDBParam = (CheckedapplyDBParam)this.getParam();		
		WayDBParam wayDBParam = new WayDBParam();
		BeanUtils.copyProperties(wayDBParam, checkedapplyDBParam);
		
		String queryRange = checkedapplyDBParam.getQueryRange();
		DataPackage temPackage = null;
		
		if(checkedapplyDBParam.isExcel()){
			wayDBParam.setQueryAll(true);
		}else{
			wayDBParam.set_pagesize("20");
		}
		wayDBParam.getQueryConditions().put("cityid", getDBAccessUser().getCityid());
		Checkedapply checkedapplyBO = (Checkedapply) BOFactory.build(CheckedapplyBO.class, getDBAccessUser());
		if("all".equals(queryRange)){//ȫ��
			temPackage = checkedapplyBO.doQueryByNamedSqlQueryWay("queryQueryRangeAll",wayDBParam);
		}else if("add".equals(queryRange)){//����
			//wayDBParam.setSelectFieldsString("wayid");CheckedapplydetailBO
			Checkedapplydetail checkedapplydetailBO = (Checkedapplydetail) BOFactory.build(CheckedapplydetailBO.class, getDBAccessUser());
			CheckedapplydetailDBParam checkedapplydetailDBParam = new CheckedapplydetailDBParam();
			checkedapplydetailDBParam.setQueryAll(true);
			DataPackage cadDP = checkedapplydetailBO.doQuery(checkedapplydetailDBParam);
			ArrayList<String> wayidList = new ArrayList<String>();
			Map<String, String> wayidMap = new HashMap<String, String>();
			if(cadDP != null && !"".equals(cadDP)){
				List datas = cadDP.getDatas();
				
				if(datas != null && !"".equals(datas) && datas.size()>0){
					for(int i=0 ; i<datas.size() ; i++){
						CheckedapplydetailVO checkedapplydetailVO = (CheckedapplydetailVO)datas.get(i);
						String wayid = checkedapplydetailVO.getWayid();
						if(!wayidMap.containsKey(wayid)){
							wayidList.add(wayid);
							wayidMap.put(wayid, wayid);
						}
					}
				}
			}
			wayDBParam.set_sin_wayid(wayidList);
			
			temPackage = checkedapplyBO.doQueryByNamedSqlQueryWay("queryQueryRangeAll",wayDBParam);
		}
		
		setDp(temPackage);
		return WEB_RESULT_CONTENT;
	}
	
	//����Excel
	public String doExportExcel(){
		try{
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			
			super.getParam().setQueryAll(true);
			export.setFileName("��Ȩ����ͳ��");
			
			export.voClassArray = new Class[] {ViewCDVO.class};
			export.queryMethodName = "doQueryCheckedapplyStat";
			
			export.addOutputProperty("cityid", "���й�˾",export.CODE2NAME,"#CITYCOMPANY");
			export.addOutputProperty("applytype", "��������",export.CODE2NAME,"$CH_CHECKTYPE");
			if(this.hasMutilAppstauts()){//��ϵͳ����Ϊ��systemid=83, paramtype=��channel��)����ֵΪ1ʱ������״̬�̶������á�CH_APPSTATUS_GZ��				
				export.addOutputProperty("status", "����״̬",export.CODE2NAME,"$CH_APPSTATUS_GZ");
			}else{
				export.addOutputProperty("status", "����״̬",export.CODE2NAME,"$CH_APPSTATUS");
			}			
			export.addOutputProperty("istopstat", "Ŀ��������");
			export.addOutputProperty("nettypestat", "ʡ������������");
			export.addOutputProperty("nettype1stat", "��Ǳ��������");
			export.addOutputProperty("statstat", "�ϼ�");
			
			//export.wri
			this.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
			super.doExcel();
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return null;
	}
	
	//����Excel��ϸ
	public String doExportExcelDetail(){
		try{
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			
			super.getParam().setQueryAll(true);
			export.setFileName("����Excel��ϸ");
			
			export.voClassArray = new Class[] {ViewCDDetailVO.class};
			export.queryMethodName = "doQueryCheckedapplyDetail";
			
			export.addOutputProperty("cityid", "���й�˾",export.CODE2NAME,"#CITYCOMPANY");
			export.addOutputProperty("applytype", "��������",export.CODE2NAME,"$CH_CHECKTYPE");
			if(this.hasMutilAppstauts()){//��ϵͳ����Ϊ��systemid=83, paramtype=��channel��)����ֵΪ1ʱ������״̬�̶������á�CH_APPSTATUS_GZ��				
				export.addOutputProperty("status", "����״̬",export.CODE2NAME,"$CH_APPSTATUS_GZ");
			}else{
				export.addOutputProperty("status", "����״̬",export.CODE2NAME,"$CH_APPSTATUS");
			}		
			export.addOutputProperty("istop", "��������");
			export.addOutputProperty("wayid", "��������");
			export.addOutputProperty("wayname", "��������");
			export.addOutputProperty("countyid", "�ֹ�˾����");
			export.addOutputProperty("oprtime", "���ʱ��");
			export.addOutputProperty("oprcode2", "�����");
			if(this.hasMutilAppstauts()){//��ϵͳ����Ϊ��systemid=83, paramtype=��channel��)����ֵΪ1ʱ���������״̬�̶������á�$CH_WAYSTATUS_GZ��				
				export.addOutputProperty("waystatus", "�������״̬",export.CODE2NAME,"$CH_WAYSTATUS_GZ");
			}else{
				export.addOutputProperty("waystatus", "�������״̬",export.CODE2NAME,"$CH_WAYSTATUS");
			}
			export.addOutputProperty("oprcode", "���빤��");
			//export.addOutputProperty("wtype", "��������",export.CODE2NAME,"$CH_WTYPE");
			export.addOutputProperty("chktype", "���˷�ʽ",export.CODE2NAME,"$CH_ASSESSMTHD");
						
			//export.wri
			this.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
			super.doExcel();
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return null;
	}
	
	public String doQueryCheckedapplyDetail() throws Exception {
		try {
			CheckedapplyDBParam checkedapplyDBParam = (CheckedapplyDBParam)getParam();
			
			//ȫ����ѯ
			checkedapplyDBParam.setQueryAll(true);
			
			Checkedapply checkedapplyBO = (Checkedapply) BOFactory.build(CheckedapplyBO.class, getDBAccessUser());
			DataPackage temPackage = checkedapplyBO.doQueryCheckedapplyDetail(checkedapplyDBParam);
			
			setDp(temPackage);
		} catch (Exception e) {
			e.printStackTrace();
			setActionMessage(e.getMessage());
		}
		return "list";
	}
	
	public String doQueryCheckedapplyStat() throws Exception {
		try {
			CheckedapplyDBParam checkedapplyDBParam = (CheckedapplyDBParam)getParam();
			
			//ȫ����ѯ
			checkedapplyDBParam.setQueryAll(true);
			
			Checkedapply checkedapplyBO = (Checkedapply) BOFactory.build(CheckedapplyBO.class, getDBAccessUser());
			DataPackage temPackage = checkedapplyBO.doQueryCheckedapplyStat(checkedapplyDBParam);
			
			setDp(temPackage);
		} catch (Exception e) {
			e.printStackTrace();
			setActionMessage(e.getMessage());
		}
		return "list";
	}
	
	public String doExportExcelWay(){
		try{
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			
			super.getParam().setQueryAll(true);
			export.setFileName("�鿴����Ȩ��������");
			
			export.voClassArray = new Class[] {WayVO.class};
			export.queryMethodName = "doListdetail";
			CheckedapplyDBParam checkedapplyDBParam = (CheckedapplyDBParam)this.getParam();
			//ȫ����ѯ
			checkedapplyDBParam.setExcel(true);
			
			export.addOutputProperty("wayid", "��������");
			export.addOutputProperty("wayname", "��������");
			export.addOutputProperty("waysubtype", "�����������",export.CODE2NAME,"WAYSUBTYPE");
			export.addOutputProperty("upperwayid", "�ϼ�����",export.CODE2NAME,"#WAY");
			export.addOutputProperty("latitude", "����γ��");
			
			export.addOutputProperty("longtitude", "������");
			export.addOutputProperty("starlevel", "�Ǽ�",export.CODE2NAME,"$CH_STARLEVEL");
			export.addOutputProperty("pt", "������",export.CODE2NAME,"$CH_PT");
			export.addOutputProperty("isstraitprd", "�Ƿ�ֱ��",export.CODE2NAME,"$CH_STRAITPRD");
			export.addOutputProperty("catetype", "��������",export.CODE2NAME,"$CH_CATETYPE");
			export.addOutputProperty("cityid", "���й�˾",export.CODE2NAME,"#CITYCOMPANY");
			
			export.addOutputProperty("countyid", "�ֹ�˾",export.CODE2NAME,"#CNTYCOMPANY");
			export.addOutputProperty("svccode", "������������",export.CODE2NAME,"#SERVCENT");
			export.addOutputProperty("mareacode", "΢����",export.CODE2NAME,"#MICROAREA");
			export.addOutputProperty("adtypecode", "��������",export.CODE2NAME,"$CH_ADTYPE");
			export.addOutputProperty("adacode", "��������",export.CODE2NAME,"#ADIMAREA");
			export.addOutputProperty("formtype", "ҵ̬����",export.CODE2NAME,"$CH_FORMTYPE");
			
			export.addOutputProperty("starttime", "����ʱ��");
			export.addOutputProperty("logiscode", "����������");
			export.addOutputProperty("waymagcode", "������������");
			export.addOutputProperty("bchlevel", "�ּ�",export.CODE2NAME,"$CH_BCHLEVEL");
			export.addOutputProperty("waystate", "����״̬",export.CODE2NAME,"$CH_WAYSTATE");
			export.addOutputProperty("address", "��ϸ��ַ");
			
			/*export.addOutputProperty("cityid", "���й�˾",export.CODE2NAME,"#CITYCOMPANY");
			export.addOutputProperty("applytype", "��������",export.CODE2NAME,"$CH_CHECKTYPE");
			export.addOutputProperty("status", "����״̬",export.CODE2NAME,"$CH_APPSTATUS");
			export.addOutputProperty("istopstat", "Ŀ��������");
			export.addOutputProperty("nettypestat", "ʡ������������");
			export.addOutputProperty("nettype1stat", "��Ǳ��������");
			export.addOutputProperty("statstat", "�ϼ�");*/
			
			//export.wri
			this.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
			super.doExcel();
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return null;
	}
}