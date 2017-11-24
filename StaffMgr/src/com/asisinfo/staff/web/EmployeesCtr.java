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

    //ɾ����Ϣ
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
        //ʡ������Ա
        case gdadmin:
            break;
        //�м�����Ա
        case cityadmin:
            if(!loginEmp.getStaffattr().equals(bean.getStaffattr())){
                result.fails("ֻ����ɾ��������Ա������Ϣ��");
                return result;
            }
            break;
            
        //��ְͨ��
        case staff:
            try {
                if (staffperm.equals("staff")) {
                        result.fails("��ͨԱ��û�и�Ȩ��!");
                        return result;
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
                result.fails("�������ӳ�ʱ");
                return result;
            }
            break;
        }
        
        try {
        	boolean issameid = loginEmp.getStaffid() == bean.getStaffid() ? true :false;
            int i=getEmployeesService().queryStaffid(bean);

            getEmployeesService().deleteEmployeeAndNumber(bean,staffLog,i);            
         
            //if(issameid){ new IntegrationSessionFilter().findStaff(loginEmp.getStaffid(), request);}  //�޸ĵ�½����ʱ���¸��»���
            
        }catch (Exception e) {
            result.fails(e.getMessage());
            return result;
        }
        return result;
    }


    /**
     * ��ѯ
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
        	result.fails("û�и�Ա����Ϣ");
        	return result;
        }
        switch (RoleDecisionDevice.getLoginUserRole()) {
        //ʡ������Ա��ֱ�Ӳ�ѯ
        case gdadmin:
            break;
        //���й���Ա���жϲ�ѯ�ĵ����Ƿ��Ǹù���Ա�������У��ǵĻ���ȥ��ѯ
        case cityadmin:    	
        	bean.setStaffattr(emp.getStaffattr());
        	if(	bean.getStaffattr() != null && !"".equals(bean.getStaffattr().toString())){
        		break;      	
            }else{
            	result.fails("ֻ�����ѯ������Ա������Ϣ��");            	
                return result;
            }           
           
        //��ְͨ������ѯ���ֻ������Ƿ��˵��ֻ����룬�ǵĻ���ȥ��ѯ
        case staff:
        	bean.setStaffid(emp.getStaffid());
        	if(	bean.getStaffid() != null && !"".equals(bean.getStaffid().toString())){
        		break;    	
            }else{
            	result.fails("ֻ�����ѯ���˵���Ϣ��");           	
                return result;
            }     	
        	
        	/*try {
                if (StringUtils.isNotBlank(bean.getSvrnum())) {
                    boolean isMyNumber = getEmployeesService().isMyNumber(emp.getStaffid(),bean.getSvrnum());
                    if (!isMyNumber) {
                        result.fails("ֻ�����ѯ���˵��ֻ�������Ϣ��");
                        return result;
                    }
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
                result.fails("���緱æ��");
                return result;
            }*/
            //bean.setDept("");
            //bean.setStaffattr(emp.getStaffattr());
            //bean.setStaffname("");
            //bean.setStatus(emp.getStatus());
            
        default:
            result.fails("�Ƿ�����");
            return result;
        }
        try {
            totalCount = getEmployeesService().queryEmployeeAndNumberCount(bean);
            if (totalCount!=0) {
                list = getEmployeesService().queryEmployeeAndNumberList(bean);
            }
        } catch (Exception e) {
            logger.error("��ѯ�û��������"+e.getMessage());
            result.fails("��ѯ����");
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
     * ��ѯԱ���������
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
        //ʡ������Ա��ֱ�Ӳ�ѯ
        case gdadmin:
        	result.fails("Ա����Ϣ��ѯ����߱����������������Ա����������ز�ѯ��ť");
            return result;        	
            //���й���Ա���жϲ�ѯ�ĵ����Ƿ��Ǹù���Ա����Ա������Ĺ����أ��ǵĻ���ȥ��ѯ
        case cityadmin:
        	bean.setNumberattr(emp.getStaffattr());        	
        	if(bean.getNumberattr() != null && !"".equals(bean.getNumberattr().toString())){
        		if("999".equals(bean.getNumberattr().toString()) || "dgzx".equals(bean.getNumberattr().toString())
        				|| "jmzx".equals(bean.getNumberattr().toString()) || "stzx".equals(bean.getNumberattr().toString())
        				|| "gzzx".equals(bean.getNumberattr().toString()) || "www".equals(bean.getNumberattr().toString())
        				|| "zdgs".equals(bean.getNumberattr().toString()) || "fszx".equals(bean.getNumberattr().toString())
        				|| "szzx".equals(bean.getNumberattr().toString()) || "nfjd".equals(bean.getNumberattr().toString())){
        			bean.setNumberattr(""); 
        			result.fails("���зֹ�˾�˺Ų����ǹ���Ա�������ѯ21����Ա����������Ϣ��");
 	                return result;
        		}     	
        		break;
        	}else{
        		result.fails("��½�쳣�������µ�½��");
                return result;
        	}
        //��ְͨ������ѯ���ֻ������Ƿ��˵��ֻ����룬�ǵĻ���ȥ��ѯ
        case staff:
        	result.fails("ֻ�����ѯ���˵���Ϣ��");           	
            return result;            
        default:
            result.fails("��½�쳣�������µ�½��");
            return result;
        }
        try {
            totalCount = getEmployeesService().queryEmployeeAndNumberCount(bean);
            if (totalCount!=0) {
                list = getEmployeesService().queryEmployeeAndNumberList(bean);
            }
        } catch (Exception e) {
            logger.error("��ѯ�û��������"+e.getMessage());
            result.fails("��ѯ����");
            return result;
        }
        result.put("total", totalCount);
        result.put("rows", list);
        return result;
    }
    
    /**
     * �����ֻ�����
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
     * �����û����ֻ�����
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
        //ʡ������Ա
        case gdadmin:
            if (StringUtils.isNotBlank(bean.getStaffid())) {
                boolean isMyStaffid = getEmployeesService().isMyStaffid(bean.getStaffid());
                if(!isMyStaffid){
                    result.fails("��Ա������Ѵ���,������Ӹ�Ա�����룬��������Ա�����빦��");
                    return result;
                }
            }
            break;
        //�м�����Ա
        case cityadmin:
            if (StringUtils.isNotBlank(bean.getStaffid())) {
                boolean isMyStaffid = getEmployeesService().isMyStaffid(bean.getStaffid());
                if(!isMyStaffid){
                    result.fails("��Ա������Ѵ���,������Ӹ�Ա�����룬��������Ա������");
                    return result;
                }
                if (bean.getStaffattr()!=null&&!loginEmp.getStaffattr().equals(bean.getStaffattr())) {
                    result.fails("ֻ������ӱ�����Ա������Ϣ��");
                    return result;
                }
                boolean svrnums=employeesService.selectSvrnum(bean.getSvrnum());
                if(!svrnums){
                    result.fails("�ú����Ѵ��ڻ���Ϊ��");
                    return result;
                }
            }
            break;
        //��ְͨ��
        case staff:
            try {
                if (staffperm.equals("staff")) {
                        result.fails("��ͨԱ��û�и�Ȩ��!");
                        return result;
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
                result.fails("�������ӳ�ʱ");
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
        //ʡ������Ա
        case gdadmin:
            break;
        //�м�����Ա
        case cityadmin:
            break;
        //��ְͨ��
        case staff:
            try {
            	
            	if (staffperm.equals("staff")) {
                    result.fails("��ͨԱ��û�и�Ȩ��!");
                    return result;
            }
            } catch (Exception e) {
                logger.error(e.getMessage());
                result.fails("�������ӳ�ʱ");
                return result;
            }
            break;
        }
        try {
            //����Ψһ��У��
            if (bean.getIsprimary()==1) {
                boolean ok = getEmployeesService().checkPrimaryPhone(bean);
                if (!ok) {
                    result.fails("��Ա���Ѿ��������ţ�");
                    return result;
                }
            }
            boolean issameid = emp.getStaffid() == bean.getStaffid() ? true :false;
            getEmployeesService().updateEmployeeAndNumber(bean, staffLog);
            
           // if(issameid){ new IntegrationSessionFilter().findStaff(emp.getStaffid(), request);}  //�޸ĵ�½����ʱ���¸��»���
        } catch (Exception e) {
            logger.error(e.getMessage());
            result.fails("�������ӳ�ʱ");
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
