package com.asisinfo.staff.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.jfree.util.Log;

import com.asisinfo.common.utils.RequestUtils;
import com.asisinfo.common.web.BaseController;
import com.asisinfo.common.web.IntegrationSessionFilter;
import com.asisinfo.common.web.ResultMap;
import com.asisinfo.staff.WebConstant;
import com.asisinfo.staff.bean.EmployeesNumber;
import com.asisinfo.staff.bean.StaffLog;
import com.asisinfo.staff.querybean.EmployeeQueryBean;
import com.asisinfo.staff.service.EmployeesService;
import com.asisinfo.staff.utils.RequestParameterWrapper;
import com.asisinfo.staff.utils.RoleDecisionDevice;


public class EmployeesCtr extends BaseController{

private EmployeesService employeesService;
private String staffperm;

    public String index(HttpServletRequest request,
            HttpServletResponse response){
        return "information/index";
    }

    //删除信息
    public Map deletesEmployees(HttpServletRequest request,
            HttpServletResponse response){
        ResultMap result = ResultMap.defaultResultMap();
        EmployeesNumber bean = RequestParameterWrapper.tranfer(request, EmployeesNumber.class);
        StaffLog staffLog = RequestParameterWrapper.tranfer(request,StaffLog.class);
        EmployeesNumber loginEmp = RoleDecisionDevice.getLoginUser();
        staffLog.setOperid(loginEmp.getStaffid());
        staffLog.setOperdate(new Date());
        staffperm = (String) request.getSession().getAttribute("loginperm");
        switch (RoleDecisionDevice.getLoginUserRole()) {
        //省级管理员
        case gdadmin:
            break;
        //市级管理员
        case cityadmin:
            if(!loginEmp.getStaffattr().equals(bean.getStaffattr())){
                result.fails("只允许删除本地市员工的信息！");
                return result;
            }
            break;
            
        //普通职工
        case staff:
            try {
                if (staffperm.equals("staff")) {
                        result.fails("普通员工没有该权限!");
                        return result;
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
                result.fails("网络连接超时");
                return result;
            }
            break;
        }
        
        try {
        	boolean issameid = loginEmp.getStaffid() == bean.getStaffid() ? true :false;
            int i=getEmployeesService().queryStaffid(bean);

            getEmployeesService().deleteEmployeeAndNumber(bean,staffLog,i);            
         
            //if(issameid){ new IntegrationSessionFilter().findStaff(loginEmp.getStaffid(), request);}  //修改登陆号码时重新更新缓存
            
        }catch (Exception e) {
            result.fails(e.getMessage());
            return result;
        }
        return result;
    }


    /**
     * 查询
     */
    public ResultMap querys(HttpServletRequest request,HttpServletResponse response){
        ResultMap result = ResultMap.defaultResultMap();
        staffperm = (String) request.getSession().getAttribute("loginperm");
        EmployeeQueryBean bean = RequestParameterWrapper.tranfer(request, EmployeeQueryBean.class);
        EmployeesNumber emp =(EmployeesNumber) request.getSession().getAttribute(WebConstant.USER_IN_SESSION);
       // request.getSession().setAttribute("loginperm", loginperm);
        int totalCount = 0;
        List<EmployeesNumber> list = new ArrayList<EmployeesNumber>();
        
        result.put("total", totalCount);
        result.put("rows", list);
        if(emp == null){
        	result.fails("没有该员工信息");
        	return result;
        }
        switch (RoleDecisionDevice.getLoginUserRole()) {
        //省级管理员：直接查询
        case gdadmin:
            break;
        //地市管理员：判断查询的地市是否是该管理员所属地市，是的话再去查询
        case cityadmin:    	
        	bean.setStaffattr(emp.getStaffattr());
        	if(	bean.getStaffattr() != null && !"".equals(bean.getStaffattr().toString())){
        		break;      	
            }else{
            	result.fails("只允许查询本地市员工的信息！");            	
                return result;
            }           
           
        //普通职工：查询该手机号码是否本人的手机号码，是的话再去查询
        case staff:
        	bean.setStaffid(emp.getStaffid());
        	if(	bean.getStaffid() != null && !"".equals(bean.getStaffid().toString())){
        		break;    	
            }else{
            	result.fails("只允许查询本人的信息！");           	
                return result;
            }     	
        	
        	/*try {
                if (StringUtils.isNotBlank(bean.getSvrnum())) {
                    boolean isMyNumber = getEmployeesService().isMyNumber(emp.getStaffid(),bean.getSvrnum());
                    if (!isMyNumber) {
                        result.fails("只允许查询本人的手机号码信息！");
                        return result;
                    }
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
                result.fails("网络繁忙！");
                return result;
            }*/
            //bean.setDept("");
            //bean.setStaffattr(emp.getStaffattr());
            //bean.setStaffname("");
            //bean.setStatus(emp.getStatus());
            
        default:
            result.fails("非法访问");
            return result;
        }
        try {
            totalCount = getEmployeesService().queryEmployeeAndNumberCount(bean);
            if (totalCount!=0) {
                list = getEmployeesService().queryEmployeeAndNumberList(bean);
            }
        } catch (Exception e) {
            logger.error("查询用户号码出错："+e.getMessage());
            result.fails("查询出错！");
            return result;
        }
        request.getSession().setAttribute("attrs", emp.getStaffattr());
		request.getSession().setAttribute("names", emp.getStaffname());
        request.getSession().setAttribute("loginperm", staffperm);
        result.put("total", totalCount);
        result.put("rows", list);
        return result;
    }
    
    /**
     * 查询员工号码归属
     */
    public ResultMap query(HttpServletRequest request,HttpServletResponse response){
        ResultMap result = ResultMap.defaultResultMap();
        staffperm = (String) request.getSession().getAttribute("loginperm");
        EmployeeQueryBean bean = RequestParameterWrapper.tranfer(request, EmployeeQueryBean.class);
        EmployeesNumber emp =(EmployeesNumber) request.getSession().getAttribute(WebConstant.USER_IN_SESSION);
        int totalCount = 0;
        List<EmployeesNumber> list = new ArrayList<EmployeesNumber>();
        result.put("total", totalCount);
        result.put("rows", list);
        switch (RoleDecisionDevice.getLoginUserRole()) {
        //省级管理员：直接查询
        case gdadmin:
        	result.fails("员工信息查询界面具备该条件，无需操作员工号码归属地查询按钮");
            return result;        	
            //地市管理员：判断查询的地市是否是该管理员所属员工号码的归属地，是的话再去查询
        case cityadmin:
        	bean.setNumberattr(emp.getStaffattr());        	
        	if(bean.getNumberattr() != null && !"".equals(bean.getNumberattr().toString())){
        		if("999".equals(bean.getNumberattr().toString()) || "dgzx".equals(bean.getNumberattr().toString())
        				|| "jmzx".equals(bean.getNumberattr().toString()) || "stzx".equals(bean.getNumberattr().toString())
        				|| "gzzx".equals(bean.getNumberattr().toString()) || "www".equals(bean.getNumberattr().toString())
        				|| "zdgs".equals(bean.getNumberattr().toString()) || "fszx".equals(bean.getNumberattr().toString())
        				|| "szzx".equals(bean.getNumberattr().toString()) || "nfjd".equals(bean.getNumberattr().toString())){
        			bean.setNumberattr(""); 
        			result.fails("地市分公司账号并且是管理员才允许查询21地市员工归属的信息！");
 	                return result;
        		}     	
        		break;
        	}else{
        		result.fails("登陆异常，请重新登陆！");
                return result;
        	}
        //普通职工：查询该手机号码是否本人的手机号码，是的话再去查询
        case staff:
        	result.fails("只允许查询本人的信息！");           	
            return result;            
        default:
            result.fails("登陆异常，请重新登陆！");
            return result;
        }
        try {
            totalCount = getEmployeesService().queryEmployeeAndNumberCount(bean);
            if (totalCount!=0) {
                list = getEmployeesService().queryEmployeeAndNumberList(bean);
            }
        } catch (Exception e) {
            logger.error("查询用户号码出错："+e.getMessage());
            result.fails("查询出错！");
            return result;
        }
        result.put("total", totalCount);
        result.put("rows", list);
        return result;
    }
    
    /**
     * 保存手机号码
     */
    public ResultMap saveNumber(HttpServletRequest request,
            HttpServletResponse response){
        ResultMap result = ResultMap.defaultResultMap();
        EmployeesNumber bean = RequestParameterWrapper.tranfer(request, EmployeesNumber.class);
        StaffLog staffLog = RequestParameterWrapper.tranfer(request,StaffLog.class);
        EmployeesNumber emp = RoleDecisionDevice.getLoginUser();
        staffLog.setOperid(emp.getStaffid());
        staffLog.setOperdate(new Date());
        try {
            getEmployeesService().saveNumber(bean,staffLog);
        } catch (Exception e) {
            result.fails(e.getMessage());
            return result;
        }
        return result;
    }
    /**
     * 保存用户和手机号码
     * @param request
     * @param response
     * @return
     */
    public ResultMap save(HttpServletRequest request,
            HttpServletResponse response){
        ResultMap result = ResultMap.defaultResultMap();
        EmployeesNumber bean = RequestParameterWrapper.tranfer(request, EmployeesNumber.class);
        StaffLog staffLog = RequestParameterWrapper.tranfer(request,StaffLog.class);
        EmployeesNumber loginEmp = RoleDecisionDevice.getLoginUser();
        staffLog.setOperid(loginEmp.getStaffid());
        staffLog.setOperdate(new Date());
        staffperm = (String) request.getSession().getAttribute("loginperm");
        switch (RoleDecisionDevice.getLoginUserRole()) {
        //省级管理员
        case gdadmin:
            if (StringUtils.isNotBlank(bean.getStaffid())) {
                boolean isMyStaffid = getEmployeesService().isMyStaffid(bean.getStaffid());
                if(!isMyStaffid){
                    result.fails("该员工编号已存在,如需添加该员工号码，请操作添加员工号码功能");
                    return result;
                }
            }
            break;
        //市级管理员
        case cityadmin:
            if (StringUtils.isNotBlank(bean.getStaffid())) {
                boolean isMyStaffid = getEmployeesService().isMyStaffid(bean.getStaffid());
                if(!isMyStaffid){
                    result.fails("该员工编号已存在,如需添加该员工号码，请操作添加员工号码");
                    return result;
                }
                if (bean.getStaffattr()!=null&&!loginEmp.getStaffattr().equals(bean.getStaffattr())) {
                    result.fails("只允许添加本地市员工的信息！");
                    return result;
                }
                boolean svrnums=employeesService.selectSvrnum(bean.getSvrnum());
                if(!svrnums){
                    result.fails("该号码已存在或不能为空");
                    return result;
                }
            }
            break;
        //普通职工
        case staff:
            try {
                if (staffperm.equals("staff")) {
                        result.fails("普通员工没有该权限!");
                        return result;
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
                result.fails("网络连接超时");
                return result;
            }
            break;
        }
        try {
            getEmployeesService().saveEmployeeAndNumber(bean, staffLog);
           

        }catch (Exception e) {
            result.fails(e.getMessage());
            return result;
        }
        return result;
    }

    public ResultMap update(HttpServletRequest request,
            HttpServletResponse response){
        ResultMap result = ResultMap.defaultResultMap();
        staffperm = (String) request.getSession().getAttribute("loginperm");
        EmployeesNumber bean = RequestParameterWrapper.tranfer(request, EmployeesNumber.class);
        StaffLog staffLog = RequestParameterWrapper.tranfer(request, StaffLog.class);
        EmployeesNumber emp = RoleDecisionDevice.getLoginUser();
        bean.setChgtime(new Date());
        staffLog.setChgtime(new Date());
        staffLog.setOperdate(new Date());
        staffLog.setOperid(emp.getStaffid());

        switch (RoleDecisionDevice.getLoginUserRole()) {
        //省级管理员
        case gdadmin:
            break;
        //市级管理员
        case cityadmin:
            break;
        //普通职工
        case staff:
            try {
            	
            	if (staffperm.equals("staff")) {
                    result.fails("普通员工没有该权限!");
                    return result;
            }
            } catch (Exception e) {
                logger.error(e.getMessage());
                result.fails("网络连接超时");
                return result;
            }
            break;
        }
        try {
            //主号唯一性校验
            if (bean.getIsprimary()==1) {
                boolean ok = getEmployeesService().checkPrimaryPhone(bean);
                if (!ok) {
                    result.fails("该员工已经存在主号！");
                    return result;
                }
            }
            boolean issameid = emp.getStaffid() == bean.getStaffid() ? true :false;
            getEmployeesService().updateEmployeeAndNumber(bean, staffLog);
            
           // if(issameid){ new IntegrationSessionFilter().findStaff(emp.getStaffid(), request);}  //修改登陆工号时重新更新缓存
        } catch (Exception e) {
            logger.error(e.getMessage());
            result.fails("网络连接超时");
            return result;
        }
        return result;
    }

    public EmployeesService getEmployeesService() {
        return employeesService;
    }

    public void setEmployeesService(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    public String getStaffperm() {
        return staffperm;
    }

    public void setStaffperm(String staffperm) {
        this.staffperm = staffperm;
    }


}
