/**
* auto-generated code
* Tue Aug 21 08:42:57 CST 2012
*/
package com.sunrise.boss.ui.cms.monitor;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.monitor.persistent.MonitorListVO;
import com.sunrise.boss.business.cms.monitor.persistent.MonitorVO;
import com.sunrise.boss.business.cms.operation.persistent.OperationVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.admin.acl.ACLDelegate;
import com.sunrise.boss.delegate.admin.operator.OperatorDelegate;
import com.sunrise.boss.delegate.cms.monitor.MonitorDelegate;
import com.sunrise.boss.delegate.cms.operation.OperationDelegate;
import com.sunrise.boss.delegate.common.sysparam.SysparamDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: MonitorAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class MonitorAction extends BaseAction {
	public static final String CH_ADT_MONITOR_VIEW ="CH_ADT_MONITOR_VIEW"; //;�����ƵĹ��������ѯ���е��еĳ������
	public static final String CH_ADT_MONITOR_CON ="CH_ADT_MONITOR_CON";//�ֹ�˾������ɼ����зֹ�˾
	public static final String CH_ADT_ADJUST_COUNTY ="CH_ADT_ADJUST_COUNTY";//�ֹ�˾������������ֹ�˾�ɼ�
    public MonitorAction() {
            setVoClass(MonitorVO.class);
        // TODO: ������������������
            this.pkNameArray = new String[1]; 
            pkNameArray[0] = "abatchno"; 
    }
    
    private void doCheckpermit(ActionForm actionForm, User user)throws Exception{
    	MonitorForm form = (MonitorForm)actionForm;    	
    	ACLDelegate acldelegate = new ACLDelegate();    	
		if(form.getProvpermited()==-1){    			
	    	boolean permited = acldelegate.checkPermission(user.getOpercode(), CH_ADT_MONITOR_VIEW);
	    	if(permited){//���в�ѯȫʡ�������Ȩ��
	    		form.setProvpermited(1);
	    	}else{
	    		form.set_ne_cityid(user.getCityid());
	    		form.setProvpermited(0);
	    	}
		}
		if(form.getCitypermited()==-1){
			boolean citypermit = acldelegate.checkPermission(user.getOpercode(), CH_ADT_MONITOR_CON);
	    	if(citypermit){
	    		form.setCitypermited(1);
	    	}else{
	    		form.setCitypermited(0);
	    	}
		}
		if(form.getCountypermited()==-1){
			boolean countypermit = acldelegate.checkPermission(user.getOpercode(), CH_ADT_ADJUST_COUNTY);
	    	if(countypermit){
	    		form.setCountypermited(1);
	    		OperatorDelegate odelegate = new OperatorDelegate();
	    		String countyid = odelegate.doQuerycountyid(user.getOpercode(), user);
	    		if(countyid!=null){
	    			form.set_countyid(countyid);
	    			form.set_se_countyid(countyid);
	    		}else{
	    			throw new BusinessException(null, "��¼�����޷ֹ�˾��Ϣ");
	    		}
	    	}else{
	    		form.setCountypermited(0);
	    	}
		}
    }
    
    /**
     * �״ν���ҳ�治��ѯ
     */
    public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception{
    	Page.setPageSize(request, (BaseActionForm) actionForm);
    	request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
    	
    	try{
    		this.doCheckpermit(actionForm, user);
    	}catch(BusinessException ex){
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.toString());
    	}catch(Exception ex){
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
    	}
    	
    	MonitorForm form = (MonitorForm)actionForm;
    	form.setSupportPaymonth(this.isSupportPaymonth(user));
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	String today = sdf.format(new Date());
    	String monthfirstday = today.substring(0, today.length()-2)+"01";
    	form.set_dnl_conoptime(monthfirstday);
    	form.set_dnm_conoptime(today);
    	form.set_lastdate2(today);
    	
    	return (actionMapping.findForward("list"));
    }
    
    public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception{
    	Page.setPageSize(request, (BaseActionForm) actionForm);
    	request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
    	try{
    		try{
        		this.doCheckpermit(actionForm, user);
        	}catch(BusinessException ex){
        		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.toString());
        	}
        	
    		MonitorForm form = (MonitorForm)actionForm;
    		MonitorListVO listvo = new MonitorListVO();
    		this.setListVO(listvo, form);	
    		if(listvo.get_dnl_conoptime()!=null && !("".equals(listvo.get_dnl_conoptime()))){
        		listvo.set_dnl_conoptime(listvo.get_dnl_conoptime()+" 00:00:00");
        	}       		
			if(listvo.get_dnm_conoptime()!=null && !("".equals(listvo.get_dnm_conoptime()))){
				listvo.set_dnm_conoptime(listvo.get_dnm_conoptime()+" 23:59:59");
			}
    		if(listvo.get_orderby()==null || listvo.get_orderby().trim().length()==0){
    			listvo.set_orderby("conoptime");
    			listvo.set_desc("1");
    		}        	
        	MonitorDelegate delegate = new MonitorDelegate();
        	DataPackage dp = delegate.doQuery(listvo, user);
        	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
    	}catch(Exception ex){
    		ex.printStackTrace();
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
    	}
    	return (actionMapping.findForward("list"));
    }
    
    public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception{
    	CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�����ʱ������");
		export.appendHeadLine(new String[] { "��������:", user.getOpercode() });
		export.appendHeadLine(new String[] { "����ʱ��:", format.format(new Date()) });
		export.addOutputProperty("cityid", "���б�ʶ", export.CODE2NAME, "#CITYCOMPANY_AREA");
		export.addOutputProperty("abatchno", "���κ�");
		export.addOutputProperty("conoprcode", "����ȷ�Ϲ���"); 
		export.addOutputProperty("conoptime", "����ȷ��ʱ��", export.DATE, "yyyy-MM-dd HH:mm:ss"); 
		export.addOutputProperty("rewardmonth", "�����·�");
		export.addOutputProperty("countyid", "�ֹ�˾", export.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("upperopnid", "ҵ�����", export.CODE2NAME, "#OPERATION");
		export.addOutputProperty("lastdate", "����ȷ������", export.DATE, "yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("status", "����״̬", export.CODE2NAME, "#ADT_STATUS");
		if(this.isSupportPaymonth(user)){
			export.addOutputProperty("paymonth", "�����·�");
		}
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);		
		export.voClassArray = new Class[] { MonitorVO.class };
		export.queryMethodName = "doList";
		if (export.headtitle == null) {
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response, user, this);
		
    	return null;
    }
    
    public ActionForward doCreateaccount(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception{
    	response.setCharacterEncoding("UTF-8");
    	PrintWriter out = response.getWriter();
    	try{
    		String retmsg = "";
    		MonitorForm form = (MonitorForm)actionForm;
    		if(form.get_lastdate2()==null || form.get_lastdate2().trim().length()==0){
    			retmsg += "[���ݽ�ֹȷ������]����Ϊ��";
    		}
    		String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    		if(form.get_lastdate2().compareTo(today)>0){
    			retmsg += "[���ݽ�ֹȷ������]���ܴ��ڵ�ǰ����"+today;
    		}
    		if(form.get_rewardmonth()!=null && form.get_rewardmonth().trim().length()!=0){
    			String month = new SimpleDateFormat("yyyyMM").format(new Date());
    			if(form.get_rewardmonth().compareTo(month)>0){
    				retmsg += "[�����·�]���ܴ���ϵͳ��ǰ�·�"+month;        			
    			}
    		} 
    		if(!"".equals(retmsg)){
    			out.write(retmsg);
    			return null;
    		}
    		
    		MonitorListVO listvo = new MonitorListVO();
    		this.setListVO(listvo, form);
    		
    		MonitorDelegate delegate = new MonitorDelegate();
    		retmsg = delegate.doCreateaccount(listvo, user);
    		out.write(retmsg);
    	}catch(Exception ex){
    		System.err.println("�����ʽ��Ȳ�ѯ -ȷ�ϳ���ʧ�ܣ�ԭ��"+ex.getMessage());
    		out.write(ex.getMessage());
    	}
    	return null;
    }
    
    //�Ƿ�֧�ָ����·�
    public boolean isSupportPaymonth(User user) throws Exception{
    	SysparamDelegate sysparamDelegate = new SysparamDelegate();
		String value = sysparamDelegate.doFindByID(95L, "channel", user);
		if(value!=null){
			if("1".equals(value)){
				return true;
			}else{
				return false;
			}
		}else{
			return false;//������ϵͳ����������Ϊ��
		}
    }
}
