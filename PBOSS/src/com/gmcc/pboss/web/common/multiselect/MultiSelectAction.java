package com.gmcc.pboss.web.common.multiselect;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.communication.advgroup.AdvgroupDBParam;
import com.gmcc.pboss.business.communication.advgroup.AdvgroupVO;
import com.gmcc.pboss.business.communication.advgroupobj.AdvgroupobjDBParam;
import com.gmcc.pboss.business.communication.advgroupobj.AdvgroupobjVO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.communication.advgroup.Advgroup;
import com.gmcc.pboss.control.communication.advgroup.AdvgroupBO;
import com.gmcc.pboss.control.communication.advgroupobj.Advgroupobj;
import com.gmcc.pboss.control.communication.advgroupobj.AdvgroupobjBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.AAUtilsForStruts2;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: AdvgroupAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class MultiSelectAction extends BaseAction{
	public static String SPLITCHAR = ","; // 分隔符：逗号
	
	public static String WAYTYPE_AG = "AG"; // 渠道类型：社会渠道
	public static String STATE_WAY_EFFECTIVE = "1"; // 渠道状态：有效
	public static String STATUS_EMP_USEFUL = "0"; // 人员状态：可用
	
	public static String OBJ_ACCOUNT = "100"; // 显示人员数
	public static String WAY_ACCOUNT = "100"; // 显示渠道数
	public static String GROUP_ACCOUNT = "100"; // 显示群组数
	
	public static String WAYLIST = "wayList"; // 可选渠道列表
	public static String GROUPLIST = "groupList"; // 可选分组列表
	public static String OBJLIST = "objList"; // 可选人员列表
	public static String DATALIST = "dataList"; // 已选人员列表
	
	public MultiSelectAction() {
		this.setForm(new MultiSelectForm());
	}
	
	public String doShowopr() throws Exception {
		MultiSelectForm form = (MultiSelectForm)getForm();
		Employee employee = (Employee)BOFactory.build(EmployeeBO.class, getDBAccessUser());
		EmployeeDBParam param = new EmployeeDBParam();
		
		//获取供选择的选项列表
		param.set_se_waytype(WAYTYPE_AG);
		param.set_ne_empstatus(STATUS_EMP_USEFUL);
		
		String employeeid = form.getEmployeeid();
		String employeename = form.getEmployeename();
		String isnet = form.getIsnet();
		String officetel = form.getOfficetel();
		if(!StringUtils.isEmpty(employeeid))param.set_se_employeeid(employeeid);
		if(!StringUtils.isEmpty(employeename))param.set_sk_employeename(employeename);
		if(!StringUtils.isEmpty(isnet))param.set_ne_isnet(isnet);
		if(!StringUtils.isEmpty(officetel))param.set_sk_officetel(officetel);
		
		param.set_pagesize(OBJ_ACCOUNT);
		DataPackage dp = employee.doQuery(param);
		List<EmployeeVO> objList = dp.getDatas();
		getRequest().setAttribute(OBJLIST, objList);
		
		if(AAUtilsForStruts2.isAjaxRequest()){
			AAUtilsForStruts2.addZonesToRefresh("zoneSource");
		}
		return "showopr";
	}
	
	public String doShowoprSel() throws Exception {
		if(AAUtilsForStruts2.isAjaxRequest()){
			MultiSelectForm form = (MultiSelectForm)getForm();
			Employee employee = (Employee)BOFactory.build(EmployeeBO.class, getDBAccessUser());
			
			EmployeeDBParam param = new EmployeeDBParam();
			//获取已选择的选项列表
			String selectedStr = form.getSelectedStr();
			List<String> opercodeList = new ArrayList<String>();
			if (!StringUtils.isEmpty(selectedStr)) {
				String[] opercodeArray = selectedStr.split(",");
				for(int i=0; i<opercodeArray.length; i++)
				{
					opercodeList.add(opercodeArray[i]);
				}
				param.set_sin_employeeid(opercodeList);
				param.set_pagesize("0");
				DataPackage dp = employee.doQuery(param);
				List<EmployeeVO> dataList = dp.getDatas(); 
				getRequest().setAttribute("dataList", dataList);
			}
			AAUtilsForStruts2.addZonesToRefresh("zoneData");
		}
		return "showopr";
	}
	
	public String doShowway() throws Exception {
		if(AAUtilsForStruts2.isAjaxRequest()){
			MultiSelectForm form = (MultiSelectForm)getForm();
			
			Way way = (Way)BOFactory.build(WayBO.class, getDBAccessUser());
			WayDBParam param = new WayDBParam();
			param.set_se_waytype(WAYTYPE_AG);
			param.set_ne_waystate(STATE_WAY_EFFECTIVE);
			param.set_se_cityid(getDBAccessUser().getCityid());
			param.set_pagesize(WAY_ACCOUNT);
			
			String wayid = form.getWayid();
			String wayname = form.getWayname();
			if(!StringUtils.isEmpty(wayid))param.set_se_wayid(wayid);
			if(!StringUtils.isEmpty(wayname))param.set_sk_wayname(wayname);
			
			DataPackage dp = way.doQuery(param);
			List<WayVO> wayList = dp.getDatas();
			getRequest().setAttribute(WAYLIST, wayList);
			
			AAUtilsForStruts2.addZonesToRefresh("zoneSource");
		}
		return "showopr";
	}
	
	public String doShowwayobj() throws Exception {
		if(AAUtilsForStruts2.isAjaxRequest()){
			MultiSelectForm form = (MultiSelectForm)getForm();
			
			Employee employee = (Employee)BOFactory.build(EmployeeBO.class, getDBAccessUser());
			EmployeeDBParam param = new EmployeeDBParam();
			
			//获取供选择的选项列表
			param.set_se_waytype(WAYTYPE_AG);
			param.set_pagesize(OBJ_ACCOUNT);
			param.set_ne_empstatus(STATUS_EMP_USEFUL);
			
			String wayidIn = form.getWayidIn();
			if(!StringUtils.isEmpty(wayidIn))param.set_se_wayid(wayidIn);
			
			DataPackage dp = employee.doQuery(param);
			List<EmployeeVO> objList = dp.getDatas();
			getRequest().setAttribute(OBJLIST, objList);
			
			AAUtilsForStruts2.addZonesToRefresh("zoneSource");
		}
		return "showopr";
	}
	
	public String doShowgroup() throws Exception {
		if(AAUtilsForStruts2.isAjaxRequest()){
			MultiSelectForm form = (MultiSelectForm)getForm();
			
			Advgroup advgroup = (Advgroup)BOFactory.build(AdvgroupBO.class, getDBAccessUser());
			AdvgroupDBParam param = new AdvgroupDBParam();
			param.set_pagesize(GROUP_ACCOUNT);
			
			Long groupid = form.getGroupid();
			String groupname = form.getGroupname();
			if(null!=groupid)param.set_ne_groupid(String.valueOf(groupid));
			if(!StringUtils.isEmpty(groupname))param.set_sk_groupname(groupname);
			DataPackage dp = advgroup.doQuery(param);
			
			List<AdvgroupVO> groupList = dp.getDatas();
			getRequest().setAttribute(GROUPLIST, groupList);
			
			AAUtilsForStruts2.addZonesToRefresh("zoneSource");
		}
		return "showopr";
	}
	
	public String doShowgroupobj() throws Exception {
		if(AAUtilsForStruts2.isAjaxRequest()){
			MultiSelectForm form = (MultiSelectForm)getForm();
			
			Advgroupobj advgroupobj = (Advgroupobj)BOFactory.build(AdvgroupobjBO.class, getDBAccessUser());
			AdvgroupobjDBParam param = new AdvgroupobjDBParam();
			String groupidIn = form.getGroupidIn();
			if(!StringUtils.isEmpty(groupidIn))param.set_ne_groupid(groupidIn);
			DataPackage dp = advgroupobj.doQuery(param);
			
			List<AdvgroupobjVO> advgroupobjList = dp.getDatas();
			List<String> objList = new ArrayList<String>();
			if(dp.getRowCount()>0)
			{
				List<String> employeeidList = new ArrayList<String>();
				for(int i=0; i<advgroupobjList.size(); i++)
				{
					employeeidList.add(String.valueOf(((AdvgroupobjVO)advgroupobjList.get(i)).getOid()));
				}
				
				Employee employee = (Employee)BOFactory.build(EmployeeBO.class, getDBAccessUser());
				EmployeeDBParam param2 = new EmployeeDBParam();
				param2.set_sin_employeeid(employeeidList);
				param2.set_ne_empstatus(STATUS_EMP_USEFUL);
				DataPackage dp2 = employee.doQuery(param2);
				objList = dp2.getDatas();
			}
			else
			{
				objList = null;
			}
			
			getRequest().setAttribute(OBJLIST, objList);
			
			AAUtilsForStruts2.addZonesToRefresh("zoneSource");
		}
		return "showopr";
	}
	
}