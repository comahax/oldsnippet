/**
* auto-generated code
* Tue Aug 21 10:38:32 CST 2012
*/
package com.sunrise.boss.ui.cms.paymentbatch;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.sunrise.boss.business.cms.paymentbatch.persistent.PaymentbatchListVO;
import com.sunrise.boss.business.cms.paymentbatch.persistent.PaymentbatchVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.admin.acl.ACLDelegate;
import com.sunrise.boss.delegate.cms.paymentbatch.PaymentbatchDelegate;
import com.sunrise.boss.delegate.common.sysparam.SysparamDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: PaymentbatchAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class PaymentbatchAction extends BaseAction {
	public static final String CH_ADT_MONITOR_VIEW ="CH_ADT_MONITOR_VIEW"; //;此令牌的工号允许查询所有地市的出帐情况
	
    public PaymentbatchAction() {
            setVoClass(PaymentbatchVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "batchno"; 
    }
    //是否具有省级权限
    private void chechProvppermit(PaymentbatchForm form, User user) throws Exception{
    	ACLDelegate delegate = new ACLDelegate();
    	boolean permited = delegate.checkPermission(user.getOpercode(), CH_ADT_MONITOR_VIEW);
    	if(permited){//具有查询全省出酬进度权限
    		form.setProvpermited(1);
    	}else{
    		form.set_ne_cityid(user.getCityid());
    		form.setProvpermited(0);
    	}
    }
    //是否支持付款月份
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
			return false;//不存在系统参数则设置为零
		}
    }
    
    /**
     * 首次进入页面不查询
     */
    public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception{
    	Page.setPageSize(request, (BaseActionForm) actionForm);
    	//request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
    	PaymentbatchForm form = (PaymentbatchForm)actionForm;
    	//是否具有省级权限
    	this.chechProvppermit(form, user);
    	//是否支持付款月份
    	form.setSupportPaymonth(this.isSupportPaymonth(user));
    	return (actionMapping.findForward("list"));
    }
    
    public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception{
    	Page.setPageSize(request, (BaseActionForm) actionForm);
    	//request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
    	try{
    		PaymentbatchForm form = (PaymentbatchForm)actionForm;
    		if(form.getProvpermited()==-1){
    			this.chechProvppermit(form, user);
    		}
    		form.setSupportPaymonth(this.isSupportPaymonth(user));
    		
    		PaymentbatchListVO listvo = new PaymentbatchListVO();
    		this.setListVO(listvo, form);
    		if(listvo.get_dnl_paymentoprtime()!=null && !("".equals(listvo.get_dnl_paymentoprtime()))){
        		listvo.set_dnl_paymentoprtime(listvo.get_dnl_paymentoprtime()+" 00:00:00");
        	}       		
			if(listvo.get_dnm_paymentoprtime()!=null && !("".equals(listvo.get_dnm_paymentoprtime()))){
				listvo.set_dnm_paymentoprtime(listvo.get_dnm_paymentoprtime()+" 23:59:59");
			}		
			if(listvo.get_orderby()==null || listvo.get_orderby().trim().length()==0){
				listvo.set_orderby("paymentoprtime");
				listvo.set_desc("1");
    		}       	
        	PaymentbatchDelegate delegate = new PaymentbatchDelegate();
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
		export.setFileName("付款批次查询");
		export.appendHeadLine(new String[] { "导出工号:", user.getOpercode() });
		export.appendHeadLine(new String[] { "导出时间:", format.format(new Date()) });
		
		export.addOutputProperty("batchno", "批次号");
		export.addOutputProperty("cityid", "地市标识", CommonExportBean.CODE2NAME, "#CITYCOMPANY_AREA");
		export.addOutputProperty("paymentflag", "出账结算报表", CommonExportBean.CODE2NAME, "#ADT_PAYMENTFLAG");
		export.addOutputProperty("paymentoprcode", "付款申请操作工号");  
		export.addOutputProperty("paymentoprtime", "付款申请操作时间", CommonExportBean.DATE, "yyyy-MM-dd HH:mm:ss");  
		export.addOutputProperty("listflag", "银行支付清单", CommonExportBean.CODE2NAME, "#ADT_LISTFLAG");
		export.addOutputProperty("endflag", "是否完成付款", CommonExportBean.CODE2NAME, "#ADT_ENDFLAG");
		PaymentbatchForm form = (PaymentbatchForm)actionForm;
		if(form.isSupportPaymonth()){
			export.addOutputProperty("paymonth", "付款月份");
		}
		export.addOutputProperty("endoprcode", "付款操作工号");  
		export.addOutputProperty("endtime", "付款操作时间", CommonExportBean.DATE, "yyyy-MM-dd HH:mm:ss");
		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);		
		export.voClassArray = new Class[] { PaymentbatchVO.class };
		export.queryMethodName = "doList";
		if (export.headtitle == null) {
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response, user, this);
		
    	return null;
    }

    /**
     * 【完成付款】操作
     */
    public ActionForward doPayment(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user){
    	PrintWriter out = null;
    	try {
			response.setCharacterEncoding("UTF-8");
			out = response.getWriter();
			String batchno = request.getParameter("batchno");
			PaymentbatchDelegate delegate = new PaymentbatchDelegate();
			PaymentbatchVO vo = delegate.doFindByPk(batchno, user);
			if (vo.getPaymentflag() == null || vo.getListflag() == null
					|| vo.getPaymentflag() == 0 || vo.getListflag() == 0) {
				out.write("报表平台尚未生成报表，请在生成报表，核对无误后再做【确认】操作");
				out.flush();
				return null;
			}
			vo.setEndflag(Short.valueOf("2"));
			vo.setEndoprcode(user.getOpercode());
			vo.setEndtime(new Date());
			delegate.doUpdate(vo, user);
			
//			delegate.doPayment(Short.valueOf("6"), batchno, user);
//			Thread thread = new Thread(new UpdateIsflagThread(batchno, user));
//			thread.start();
			out.write("SUCCESS");
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
			out.write("【确认】操作失败");
			out.flush();
		} finally {
			if (out != null) {
				out.close();
			}
		}
    	return null;
    }
    
    private class UpdateIsflagThread implements Runnable {
    	private String batchno = "";
    	private User user = null;
    	public UpdateIsflagThread (String batchno, User user) {
    		this.batchno = batchno;
    		this.user = user;
    	}
    	
		public void run() {
			try {
				PaymentbatchDelegate delegate = new PaymentbatchDelegate();
				delegate.doPayment(Short.valueOf("6"), batchno, user);
				PaymentbatchVO vo = delegate.doFindByPk(batchno, user);
				vo.setEndflag(Short.valueOf("1"));
				delegate.doUpdate(vo, user);
			} catch (Exception e) {
				System.out.println("更新CH_ADT_DCORD、CH_ADT_CITYRECORD表isflag状态为6失败");
				e.printStackTrace();
			}
		}
    }
}
