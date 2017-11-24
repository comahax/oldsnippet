/**
* auto-generated code
* Wed Aug 29 19:13:31 CST 2012
*/
package com.sunrise.boss.ui.cms.vchpwoperation;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.vchpwoperation.persistent.VChPwOperationListVO;
import com.sunrise.boss.business.cms.vchpwoperation.persistent.VChPwOperationVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.vchpwoperation.VChPwOperationDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: VChPwOperationAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class VChPwOperationAction extends BaseAction {
    public VChPwOperationAction() {
            setVoClass(VChPwOperationVO.class);
        // TODO: ������������������
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "opnid5"; 
    }
  //���ҵ�������ѯ
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		Page.setPageSize(request, (BaseActionForm) actionForm);
		try {
	        VChPwOperationListVO listVO = new VChPwOperationListVO(); 
	        VChPwOperationForm form =(VChPwOperationForm)actionForm;
	        setListVO(listVO, form); // ���ú�listVO����Ϊ��ѯ����
			VChPwOperationDelegate delegate = new VChPwOperationDelegate(); 
			DataPackage pack = delegate.doQuery(listVO, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);			
		}catch (Exception e) { 
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
    		e.printStackTrace();
		}
		return actionMapping.findForward("list");
	} 

	
	/**
	 * ����Excel�ļ�,�ϴ�������������
	 */
	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {  
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("���ҵ�������ѯ"); 
		export.appendHeadLine(new String[] { "��������:", user.getOpercode() });
		export.appendHeadLine(new String[] { "����ʱ��:",format.format(new Date()) }); 
		export.addOutputProperty("opnid5","ҵ�����"); 
		export.addOutputProperty("name5","ҵ������");
		export.addOutputProperty("opnid","ҵ���������",CommonExportBean.CODE2NAME,"#OPERATION");  
		export.addOutputProperty("name2","ҵ��С������"); 
		export.addOutputProperty("startdate","��Ч����",CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("enddate","ʧЧ����",CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");  
		export.addOutputProperty("busibelong","ҵ�����",CommonExportBean.CODE2NAME,"$CH_CBBUSIBELONG"); 
	    request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export); 
		export.voClassArray = new Class[] { VChPwOperationVO.class };
		export.queryMethodName = "doList";
		if (export.headtitle == null) {
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response, user, this);
		return null;
	} 
 

}
