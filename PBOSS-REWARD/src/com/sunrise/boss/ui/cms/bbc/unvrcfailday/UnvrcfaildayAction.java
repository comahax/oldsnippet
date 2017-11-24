/**
* auto-generated code
* Wed Dec 07 14:34:03 CST 2011
*/
package com.sunrise.boss.ui.cms.bbc.unvrcfailday;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.bbc.unvrcfailday.persistent.UnvrcfaildayVO;
import com.sunrise.boss.business.cms.bbc.unvrcfailday.persistent.VUnvrcfaildayVO;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.unvrcfailday.persistent.UnvrcfaildayListVO;
import com.sunrise.boss.delegate.cms.bbc.unvrcfailday.UnvrcfaildayDelegate;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: UnvrcfaildayAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class UnvrcfaildayAction extends BaseDelegateAction  {
    public UnvrcfaildayAction() {
            setVoClass(UnvrcfaildayVO.class);
        // TODO: ������������������
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "failid"; 
    }
    
    public ActionForward doList(ActionMapping actionMapping,
    		ActionForm actionForm, HttpServletRequest request,
    		HttpServletResponse response, User user) throws Exception {
    	Page.setPageSize(request, (BaseActionForm) actionForm);
    	try{
    		UnvrcfaildayForm form = (UnvrcfaildayForm)actionForm;
        	UnvrcfaildayListVO listvo = new UnvrcfaildayListVO();
        	this.setListVO(listvo, form);
        	if(listvo.get_dnl_rcdate()!=null && !("".equals(listvo.get_dnl_rcdate()))){
        		listvo.set_dnl_rcdate(listvo.get_dnl_rcdate()+" 00:00:00");
        	}       		
			if(listvo.get_dnm_rcdate()!=null && !("".equals(listvo.get_dnm_rcdate()))){
				listvo.set_dnm_rcdate(listvo.get_dnm_rcdate()+" 23:59:59");
			}				
        	listvo.set_orderby("failid");
        	UnvrcfaildayDelegate delegate = new UnvrcfaildayDelegate();
        	DataPackage dp = delegate.doQueryWithEmpinfo(listvo, user);
        	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);    
    	}catch(Exception e){
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
    	}
    		
    	return actionMapping.findForward("list");
    }
    
    public ActionForward doTxt(ActionMapping actionMapping,
    		ActionForm actionForm, HttpServletRequest request,
    		HttpServletResponse response, User user) throws Exception {
    	CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("��н��������ҵ���Ƽ�ʧ����ϸ��ѯ");
		export.appendHeadLine(new String[] { "��������:", user.getOpercode() });
		export.appendHeadLine(new String[] { "����ʱ��", format.format(new Date(System.currentTimeMillis())) });
		//export.addOutputProperty("failid","���");
		export.addOutputProperty("rcno","רԱ����");
		export.addOutputProperty("mobileno","�ͻ�����");
		export.addOutputProperty("opnid","ҵ�����");
		export.addOutputProperty("opnname","ҵ������");
		export.addOutputProperty("rcmonth","�Ƽ��·�");
		export.addOutputProperty("rcdate", "�Ƽ�ʱ��", CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("reason","ʧ��ԭ��");
		export.addOutputProperty("ossrc","ҵ��ƽ̨��Դ", CommonExportBean.CODE2NAME, "#CH_UNV_OSSRC");
		export.addOutputProperty("wayid","��������");
		export.addOutputProperty("wayname","��������");
		export.addOutputProperty("empattr2", "��Ա����", CommonExportBean.CODE2NAME, "$CH_EMPATTR2");		
		export.voClassArray = new Class[]{VUnvrcfaildayVO.class};
		export.queryMethodName="doList";
		response.setCharacterEncoding("GBK");
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain;charset=gbk");
		
		export.writeTxtTitle(response.getOutputStream(), new String[] {"רԱ����","�ͻ�����",
			"ҵ�����","ҵ������","�Ƽ��·�","�Ƽ�ʱ��","ʧ��ԭ��","ҵ��ƽ̨��Դ","��������",
			"��������","��Ա����"});
		
		super.ExportQuery(actionMapping, actionForm, request, response,	user, export);
		return actionMapping.findForward(null);
    }
    
    /**
	 * ����Excel�ļ�
	 * �ڽ�������������Ϳɵ���EXCEL
	 * <input type="button" class="button_4" onmouseover="buttonover(this);" onclick="doExport('TOEXCEL')" 
              onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
              value="<bean:message bundle="public" key="button_export_excel"/>" /> 
	 */
	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("��н��������ҵ���Ƽ�ʧ����ϸ��ѯ");
		export.appendHeadLine(new String[] { "��������:", user.getOpercode() });
		export.appendHeadLine(new String[] { "����ʱ��", format.format(new Date(System.currentTimeMillis())) });
		export.addOutputProperty("rcno","רԱ����");
		export.addOutputProperty("mobileno","�ͻ�����");
		export.addOutputProperty("opnid","ҵ�����");
		export.addOutputProperty("opnname","ҵ������");
		export.addOutputProperty("rcmonth","�Ƽ��·�");
		export.addOutputProperty("rcdate", "�Ƽ�ʱ��", CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("reason","ʧ��ԭ��");
		export.addOutputProperty("ossrc","ҵ��ƽ̨��Դ", CommonExportBean.CODE2NAME, "#CH_UNV_OSSRC");
		export.addOutputProperty("wayid","��������");
		export.addOutputProperty("wayname","��������");
		export.addOutputProperty("empattr2", "��Ա����", CommonExportBean.CODE2NAME, "$CH_EMPATTR2");
		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		export.voClassArray = new Class[]{VUnvrcfaildayVO.class};
		export.queryMethodName = "doList";
		if(export.headtitle==null){
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response, user, this);
		
		return actionMapping.findForward(null);
	}
}
