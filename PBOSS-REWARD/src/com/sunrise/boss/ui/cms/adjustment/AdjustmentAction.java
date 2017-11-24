/**
* auto-generated code
* Fri Aug 17 16:14:58 CST 2012
*/
package com.sunrise.boss.ui.cms.adjustment;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.adjustment.persistent.AdjustmentVO;
import com.sunrise.boss.business.cms.adjustment.persistent.VAdjustmentListVO;
import com.sunrise.boss.business.cms.adjustment.persistent.VAdjustmentVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamListVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.admin.acl.ACLDelegate;
import com.sunrise.boss.delegate.admin.operator.OperatorDelegate;
import com.sunrise.boss.delegate.cms.adjustment.AdjustmentDelegate;
import com.sunrise.boss.delegate.common.sysparam.SysparamDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: AdjustmentAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class AdjustmentAction extends BaseAction {
	public static final String CH_ADT_MONITOR_CON ="CH_ADT_ADJUST_UP";//�ֹ�˾������ɼ����зֹ�˾
	public static final String CH_ADT_ADJUST_COUNTY ="CH_ADT_ADJUST_COUNTY";//�ֹ�˾������������ֹ�˾�ɼ�
    public AdjustmentAction() {
            setVoClass(AdjustmentVO.class);
        // TODO: ������������������
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "id"; 
    }
    
    private void doCheckpermit(ActionForm actionForm, User user)throws Exception{
    	AdjustmentForm form = (AdjustmentForm)actionForm;
    	ACLDelegate acldelegate = new ACLDelegate();    	
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
    	
    	AdjustmentForm form = (AdjustmentForm)actionForm;
    	SysparamDelegate sysparamDelegate = new SysparamDelegate();
    	SysparamListVO sysparamListVO = new SysparamListVO();
    	sysparamListVO.set_se_paramtype("channel");
    	sysparamListVO.set_ne_systemid("91");
    	DataPackage sysparamDP = sysparamDelegate.doQuery(sysparamListVO, user);
    	
		if(sysparamDP != null && sysparamDP.getDatas() != null && sysparamDP.getDatas().size() > 0){
			for(Iterator<SysparamVO> it = sysparamDP.getDatas().iterator();it.hasNext();){
				SysparamVO sysparamVO= it.next();
				form.set_hasfees(sysparamVO.getParamvalue());
			}
		}else{
				form.set_hasfees("0");//������ϵͳ����������Ϊ��
		}
		
		sysparamListVO.set_ne_systemid("93");
		sysparamDP = sysparamDelegate.doQuery(sysparamListVO, user);
		if(sysparamDP != null && sysparamDP.getDatas() != null && sysparamDP.getDatas().size() > 0){
			for(Iterator<SysparamVO> it = sysparamDP.getDatas().iterator();it.hasNext();){
				SysparamVO sysparamVO= it.next();				
				form.set_hasupperopnid(sysparamVO.getParamvalue());
			}
		}else{
				form.set_hasupperopnid("0");//�����ڲ�����Ĭ�ϲ�֧��ҵ�����
		}
		
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
        	
    		AdjustmentForm form = (AdjustmentForm)actionForm;
    		AdjustmentDelegate delegate = new AdjustmentDelegate();
    		VAdjustmentListVO listvo = new VAdjustmentListVO();
    		//this.setListVO(listvo, form);
    		this.fillListVO(listvo, form);
    		if(listvo.get_orderby()==null || listvo.get_orderby().trim().length()==0){
    			listvo.set_orderby("countyid,rewardmonth,id");
    		}    		
    		DataPackage dp = delegate.doQuery(listvo, user);
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);    		
    	}catch(Exception ex){
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage()!=null?ex.getMessage():ex.getCause().getMessage());
    		ex.printStackTrace();
    	}    	
    	return (actionMapping.findForward("list"));
    }
    
    private void fillListVO(VAdjustmentListVO listvo, AdjustmentForm form){
    	this.setListVO(listvo, form);
    	if(form.get_se_upperopnid()!=null && (form.get_se_upperopnid())[0].length()>0 && !"null".equals((form.get_se_upperopnid())[0])){
    		listvo.set_sin_upperopnid(Arrays.asList(form.get_se_upperopnid()));
    	}    	
    }
    
    public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception{ 
    	AdjustmentForm form = (AdjustmentForm)actionForm;
    	CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�������ݵ�������-���ݵ���");
		export.appendHeadLine(new String[] { "��������:", user.getOpercode() });
		export.appendHeadLine(new String[] { "����ʱ��:", format.format(new Date()) });
		export.addOutputProperty("id", "���");
		export.addOutputProperty("countyid", "�ֹ�˾", export.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("rewardmonth", "�����·�");		
		export.addOutputProperty("wayid", "��������");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("starlevel", "�����Ǽ�", export.CODE2NAME, "$CH_STARLEVEL");
		if("1".equals(form.get_hasupperopnid())){
			export.addOutputProperty("upperopnid", "ҵ�����");
		}
		export.addOutputProperty("paysum", "Ӧ�����ϼ�",export.NUMBER,"0.0000");
		export.addOutputProperty("rpmoney", "�������",export.NUMBER,"0.0000");
		export.addOutputProperty("invoicesum", "��Ʊ���",export.NUMBER,"0.0000");
		export.addOutputProperty("taxmoney", "˰��",export.NUMBER,"0.0000");
		if("1".equals(form.get_hasfees())){
			export.addOutputProperty("fees", "������",export.NUMBER,"0.0000");
		}		
		export.addOutputProperty("realpay", "˰��ʵ�����",export.NUMBER,"0.0000");
		export.addOutputProperty("remark", "��ע");
		

		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);		
		export.voClassArray = new Class[] { VAdjustmentVO.class };
		if(form.getExporttype()==2){//���������������ϸ
			export.queryMethodName = "doShowreport";
		}else{//1 ������ϸ
			export.queryMethodName = "doList";
		}		
		if (export.headtitle == null) {
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response, user, this);    	
    	return null;
    }
    
    //�Ƿ�֧�ָ����·�
    private boolean isSupportPaymonth(User user) throws Exception{
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
    
    public ActionForward doShowreport(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception{
    	try{
    		Page.setPageSize(request, (BaseActionForm) actionForm);
    		AdjustmentForm form = (AdjustmentForm)actionForm;
    		if(form.getCountypermited()==1 &&(form.get_se_countyid()==null || "".equals(form.get_se_countyid().trim()))){
    			//�ֹ�˾Ȩ�ޣ����÷ֹ�˾ֵ
    			OperatorDelegate odelegate = new OperatorDelegate();
	    		String countyid = odelegate.doQuerycountyid(user.getOpercode(), user);
	    		form.set_se_countyid(countyid);
    		}
    		if(!form.suppertUpper()){//��֧��ҵ����࣬��ҵ�����ͽ����·�����Ϊ�գ�������Ϊ�ڽ����޸������ύ����
    			form.set_se_rewardmonth(null);
    			form.set_se_upperopnid(null);
    		}
    		//�Ƿ�֧�ָ����·�
    		form.setSupportPaymonth(this.isSupportPaymonth(user));
    		AdjustmentDelegate delegate = new AdjustmentDelegate();
    		VAdjustmentListVO listvo = new VAdjustmentListVO();
    		//this.setListVO(listvo, form);
    		this.fillListVO(listvo, form);
    		if(listvo.get_orderby()==null || listvo.get_orderby().trim().length()==0){
    			listvo.set_orderby("countyid,rewardmonth,id");
    		} 
    		listvo.set_checked(0);////�Ѻ˶�    		
    		DataPackage dp = delegate.doQuery(listvo, user);
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
    	}catch(Exception ex){
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
    		ex.printStackTrace();
    	}
    	
    	return (actionMapping.findForward("showreport"));
    }
    
    public ActionForward doSaveunchecked(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	Page.setPageSize(request, (BaseActionForm) actionForm);
    	request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));   
    	try{
    		AdjustmentForm form = (AdjustmentForm)actionForm;
    		AdjustmentDelegate delegate = new AdjustmentDelegate();
    		VAdjustmentListVO listvo = new VAdjustmentListVO();
    		//this.setListVO(listvo, form);
    		this.fillListVO(listvo, form);
    		String retinfo = delegate.doSaveUnchecked(listvo, user);
    		if(retinfo.indexOf("-1:")==-1){//����ɹ�
    			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�����������"+retinfo+"��");
    		}else{//ʧ�ܻ����쳣
    			String retinfos[] = retinfo.split(":");
    			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ʧ�ܣ�ԭ��"+retinfos[2]);    			
    		}
    	}catch(Exception ex){
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
    	}
		return this.doList(actionMapping, actionForm, request, response, user);
	}
    
    public ActionForward doSaveallunchecked(ActionMapping actionMapping,
    		ActionForm actionForm, HttpServletRequest request,
    		HttpServletResponse response, User user)throws Exception{
    	Page.setPageSize(request, (BaseActionForm) actionForm);
    	request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(user.getCityid())); 
    	try{
    		AdjustmentForm form = (AdjustmentForm)actionForm;
    		AdjustmentDelegate delegate = new AdjustmentDelegate();
    		VAdjustmentListVO listvo = new VAdjustmentListVO();
    		//this.setListVO(listvo, form);
    		this.fillListVO(listvo, form);
    		String retinfo = delegate.doSaveAllUnchecked(listvo, user);
    		if(retinfo.indexOf("-1:")==-1){//����ɹ�
    			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�����������"+retinfo+"��");
    			System.out.println("����ɹ�����������"+retinfo+"��");
    		}else{//ʧ�ܻ����쳣
    			String retinfos[] = retinfo.split(":");
    			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ʧ�ܣ�ԭ��"+retinfos[1]);    			
    		}
    	}catch(Exception ex){
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
    	}
    	return this.doList(actionMapping, actionForm, request, response, user);
    }
    
    public ActionForward doDeleteallchecked(ActionMapping actionMapping,
    		ActionForm actionForm, HttpServletRequest request,
    		HttpServletResponse response, User user)throws Exception{
    	Page.setPageSize(request, (BaseActionForm) actionForm);
    	request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
    	try{
    		AdjustmentForm form = (AdjustmentForm)actionForm;
    		AdjustmentDelegate delegate = new AdjustmentDelegate();
    		VAdjustmentListVO listvo = new VAdjustmentListVO();
    		//this.setListVO(listvo, form);
    		this.fillListVO(listvo, form);
    		String retinfo = delegate.doDeleteAllChecked(listvo, user);
    		if(retinfo.indexOf("-1:")==-1){//����ɹ�
    			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ���ɾ������"+retinfo+"��");
    			System.out.println("����ɹ���ɾ������"+retinfo+"��");
    		}else{//ʧ�ܻ����쳣
    			String retinfos[] = retinfo.split(":");
    			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ʧ�ܣ�ԭ��"+retinfos[1]);    			
    		}
    	}catch(Exception ex){
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
    	}
    	return this.doList(actionMapping, actionForm, request, response, user);
    }
    
    public ActionForward doDelete(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	Page.setPageSize(request, (BaseActionForm) actionForm);
    	request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));   
    	try{
    		int count = 0;
    		String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
    		AdjustmentDelegate delegate = new AdjustmentDelegate();
    		for(int i=0; i<selectArray.length; i++){
    			String[] info = selectArray[i].split("\\|");
    			AdjustmentVO vo = delegate.doFindByPk(Long.parseLong(info[0]), user);
    			if(vo!=null){
    				delegate.doRemove(vo, user);
    				count++;
    			}    			
    		}
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "ɾ����¼"+count+"��");
    	}catch(Exception ex){
    		ex.printStackTrace();
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
    	}
		return this.doList(actionMapping, actionForm, request, response, user);
	}
    
    public ActionForward doBatch(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	AdjustmentForm form = (AdjustmentForm)actionForm;
    	request.getSession().setAttribute("_hasfees", form.get_hasfees());
    	request.getSession().setAttribute("_hasupperopnid", form.get_hasupperopnid());    	
		return actionMapping.findForward("batch");
	}
    
    public ActionForward doCreatereport(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	response.setCharacterEncoding("UTF-8");
    	PrintWriter out = response.getWriter();
    	try{
    		AdjustmentForm form = (AdjustmentForm)actionForm;
    		AdjustmentDelegate delegate = new AdjustmentDelegate();
    		VAdjustmentListVO listvo = new VAdjustmentListVO();
    		if(form.isSupportPaymonth() && StringUtils.isEmpty(form.get_paymonth())){
    			throw new Exception("�������·ݡ�����������Ϊ��");
    		}
    		//this.setListVO(listvo, form);
    		this.fillListVO(listvo, form);
        	String result = delegate.doCreatereport(listvo,user);
        	out.write("��������֧���������κţ�"+result);
        	return null;
    	}catch(Exception ex){
    		out.write("��������֧������ʧ�ܣ�"+ex.getMessage());
    	}    	
		return null;
	}
}
