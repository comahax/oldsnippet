/**
* auto-generated code
* Tue Jul 31 17:05:40 CST 2012
*/
package com.sunrise.boss.ui.cms.et.chetadtrecord;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.et.chetadtrecord.persistent.ChEtAdtrecordListVO;
import com.sunrise.boss.business.cms.et.chetadtrecord.persistent.ChEtAdtrecordVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.et.chetadtrecord.ChEtAdtrecordDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ChEtAdtrecordAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChEtAdtrecordAction extends BaseAction { 
	public ChEtAdtrecordAction() {
            setVoClass(ChEtAdtrecordVO.class);
        // TODO: ������������������
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seq"; 
           //pkNameArray[1] = "srcseq"; 
    }
	//��Ӫ�����ɹ���ϸ��ѯ
	public ActionForward doSuclist(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception { 
		try {
			Page.setPageSize(request, (BaseActionForm) actionForm);
			ChEtAdtrecordForm form = (ChEtAdtrecordForm) actionForm; 
			form.set_ne_adtflag("1");
			ChEtAdtrecordListVO listVO = new ChEtAdtrecordListVO();
			setListVO(listVO, form);  
			ChEtAdtrecordDelegate delegate = new ChEtAdtrecordDelegate();
			DataPackage pack = delegate.doQuery(listVO, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
			if(null == form.get_pageno() || "".equals(form.get_pageno())){
	    		form.set_pageno(String.valueOf(pack.getPageNo()));
	    	}
    	} catch (Exception e) {
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
    		return (actionMapping.findForward("success"));
		}
		return (actionMapping.findForward("success"));
	}
	
	//��Ӫ�����ʧ����ϸ��ѯ
	public ActionForward doFaillist(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception { 
		try {
			Page.setPageSize(request, (BaseActionForm) actionForm);
			ChEtAdtrecordForm form = (ChEtAdtrecordForm) actionForm; 
			ChEtAdtrecordListVO listVO = new ChEtAdtrecordListVO();
			form.set_ne_adtflag("0"); 
			setListVO(listVO, form);  
			ChEtAdtrecordDelegate delegate = new ChEtAdtrecordDelegate();
			DataPackage pack = delegate.doQuery(listVO, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
			if(null == form.get_pageno() || "".equals(form.get_pageno())){
	    		form.set_pageno(String.valueOf(pack.getPageNo()));
	    	}
    	} catch (Exception e) {
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
    		return (actionMapping.findForward("fail"));
		}
		return (actionMapping.findForward("fail"));
	}
	
	 public ActionForward doSuctxt(ActionMapping actionMapping,
	    		ActionForm actionForm, HttpServletRequest request,
	    		HttpServletResponse response, User user) throws Exception {
	    	CommonExportBean export = new CommonExportBean(user);
			export.setFileName("��Ӫ�����ɹ���ϸ����");
			
			ChEtAdtrecordForm form = (ChEtAdtrecordForm) actionForm;
			form.set_pagesize("0");
			
			export.addOutputProperty("seq", "���к�");
			export.addOutputProperty("srcseq","����Դ���к�");
			export.addOutputProperty("oid","������");
			export.addOutputProperty("opnid","ҵ�����");
			export.addOutputProperty("calcmonth","�����·�");
			export.addOutputProperty("wayid","��������");
			export.addOutputProperty("oprcode","������");
			export.addOutputProperty("oprtime", "����ʱ��", CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
			export.addOutputProperty("mobile","�������");
			export.addOutputProperty("subsid","�û�����");
			export.addOutputProperty("brand","�û�Ʒ��");
			export.addOutputProperty("yxplanid","����Ӫ������");
			export.addOutputProperty("startdate", "��Чʱ��", CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
			export.addOutputProperty("ruleid","�������");
			export.addOutputProperty("ruleitemid","����ϸ��");
			export.addOutputProperty("noncyc","�������");
			export.addOutputProperty("batchno","�������κ�");
			export.addOutputProperty("adtcode","У�����");
			export.addOutputProperty("adtremark","У��������");
			export.addOutputProperty("src","���ݹ���ԭ�ļ�");
			export.addOutputProperty("adtflag","У���ʶ");
			export.addOutputProperty("createtime", "����ʱ��", CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
			export.addOutputProperty("bakinfo","��ע");	
			
			export.addOutputProperty("texe1","��չ�ֶ�1");  
			export.addOutputProperty("texe2","��չ�ֶ�2");  
			export.addOutputProperty("texe3","��չ�ֶ�3");  
			export.addOutputProperty("texe4","��չ�ֶ�4");  
			export.addOutputProperty("texe5","��չ�ֶ�5");  
			export.addOutputProperty("texe6","��չ�ֶ�6");  
			export.addOutputProperty("texe7","��չ�ֶ�7");  
			export.addOutputProperty("texe8","��չ�ֶ�8");  
			
			export.queryMethodName="doSuclist";
			export.voClassArray = new Class[]{ChEtAdtrecordVO.class};
			response.setHeader("pragma", "no-cache");
			response.setHeader("Cache-control", "public");
			String fn = "attachment; filename=" + export.getFileName() + ".txt";
			response.setHeader("Content-Disposition", new String(fn.getBytes("GBK"), "ISO-8859-1"));
			response.setContentType("text/plain");
			export.writeTxtTitle(response.getOutputStream(), new String[] {"���к�", "����Դ���к�",
				"������", "ҵ�����", "�����·�", "��������", "������", "����ʱ��",
				"�������", "�û�����", "�û�Ʒ��", "����Ӫ������",
				"��Чʱ��", "�������", "����ϸ��",  "�������", "���κ�", "У�����", 
				"У��������", "���ݹ���ԭ�ļ�", "У���ʶ", "����ʱ��", "��ע", 
				"��չ�ֶ�1", "��չ�ֶ�2", "��չ�ֶ�3", "��չ�ֶ�4","��չ�ֶ�5","��չ�ֶ�6","��չ�ֶ�7","��չ�ֶ�8"});
			
			super.ExportQuery(actionMapping, actionForm, request, response,	user, export);
			return actionMapping.findForward(null);
	    }
	 public ActionForward doFailtxt(ActionMapping actionMapping,
	    		ActionForm actionForm, HttpServletRequest request,
	    		HttpServletResponse response, User user) throws Exception {
	    	CommonExportBean export = new CommonExportBean(user);
			export.setFileName("��Ӫ�����ʧ����ϸ����");
			
			ChEtAdtrecordForm form = (ChEtAdtrecordForm) actionForm;
			form.set_pagesize("0");
			
			export.addOutputProperty("seq", "���к�");
			export.addOutputProperty("srcseq","����Դ���к�");
			export.addOutputProperty("oid","������");
			export.addOutputProperty("opnid","ҵ�����");
			export.addOutputProperty("calcmonth","�����·�");
			export.addOutputProperty("wayid","��������");
			export.addOutputProperty("oprcode","������");
			export.addOutputProperty("oprtime", "����ʱ��", CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
			export.addOutputProperty("mobile","�������");
			export.addOutputProperty("subsid","�û�����");
			export.addOutputProperty("brand","�û�Ʒ��");
			export.addOutputProperty("yxplanid","����Ӫ������");
			export.addOutputProperty("startdate", "��Чʱ��", CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
			export.addOutputProperty("ruleid","�������");
			export.addOutputProperty("ruleitemid","����ϸ��");
			export.addOutputProperty("noncyc","�������");
			export.addOutputProperty("batchno","�������κ�");
			export.addOutputProperty("adtcode","У�����");
			export.addOutputProperty("adtremark","У��������");
			export.addOutputProperty("src","���ݹ���ԭ�ļ�");
			export.addOutputProperty("adtflag","У���ʶ");
			export.addOutputProperty("createtime", "����ʱ��", CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
			export.addOutputProperty("bakinfo","��ע");	
			
			export.addOutputProperty("texe1","��չ�ֶ�1");  
			export.addOutputProperty("texe2","��չ�ֶ�2");  
			export.addOutputProperty("texe3","��չ�ֶ�3");  
			export.addOutputProperty("texe4","��չ�ֶ�4");  
			export.addOutputProperty("texe5","��չ�ֶ�5");  
			export.addOutputProperty("texe6","��չ�ֶ�6");  
			export.addOutputProperty("texe7","��չ�ֶ�7");  
			export.addOutputProperty("texe8","��չ�ֶ�8");  
			
			export.queryMethodName="doFaillist";
			export.voClassArray = new Class[]{ChEtAdtrecordVO.class};
			response.setHeader("pragma", "no-cache");
			response.setHeader("Cache-control", "public");
			String fn = "attachment; filename=" + export.getFileName() + ".txt";
			response.setHeader("Content-Disposition", new String(fn.getBytes("GBK"), "ISO-8859-1"));
			response.setContentType("text/plain");
			export.writeTxtTitle(response.getOutputStream(), new String[] {"���к�", "����Դ���к�",
				"������", "ҵ�����", "�����·�", "��������", "������", "����ʱ��",
				"�������", "�û�����", "�û�Ʒ��", "����Ӫ������",
				"��Чʱ��", "�������", "����ϸ��",  "�������", "���κ�", "У�����", 
				"У��������", "���ݹ���ԭ�ļ�", "У���ʶ", "����ʱ��", "��ע", 
				"��չ�ֶ�1", "��չ�ֶ�2", "��չ�ֶ�3", "��չ�ֶ�4","��չ�ֶ�5","��չ�ֶ�6","��չ�ֶ�7","��չ�ֶ�8"});
			
			super.ExportQuery(actionMapping, actionForm, request, response,	user, export);
			return actionMapping.findForward(null);
	    }
}
