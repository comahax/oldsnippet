/**
* auto-generated code
* Tue Jun 03 21:10:10 CST 2014
*/
package com.sunrise.boss.ui.cms.reward.chadtbaseprodid;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.sunrise.boss.business.cms.reward.chadtbaseprodid.persistent.ChAdtBaseprodidListVO;
import com.sunrise.boss.business.cms.reward.chadtbaseprodid.persistent.ChAdtBaseprodidVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.reward.chadtbaseprodid.ChAdtBaseprodidDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ChAdtBaseprodidAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ChAdtBaseprodidAction extends BaseAction {
    public ChAdtBaseprodidAction() {
            setVoClass(ChAdtBaseprodidVO.class);
        // TODO: ������������������
           this.pkNameArray = new String[2]; 
           pkNameArray[0] = "cityid"; 
           pkNameArray[1] = "prodid"; 
    }
    
    //��ѯ
    public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
    	ChAdtBaseprodidForm tform=(ChAdtBaseprodidForm)actionForm; 
    	ChAdtBaseprodidListVO listVO = new ChAdtBaseprodidListVO();
    	String cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
    	listVO.set_se_cityid(cityid);
    	tform.setCityid(cityid);
		return super.doList(actionMapping, tform, request, response, user);
	
	
	}
    
    
    //�༭
    public ActionForward doEdit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	request.getParameter("");
    	getContentVO(request, user, actionForm);
    	ChAdtBaseprodidForm tform=(ChAdtBaseprodidForm)actionForm;
		 return (actionMapping.findForward("content"));
    } 
    
    
    
    
    
    
    //����
    public ActionForward doNew(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	ChAdtBaseprodidForm tform=(ChAdtBaseprodidForm)actionForm;
    	String cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
    	tform.setCityid(cityid);
		return super.doNew(actionMapping, actionForm, request, response, user);
    } 
    
    
    //ɾ��
    public ActionForward doDelete(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ChAdtBaseprodidForm tform = (ChAdtBaseprodidForm) actionForm;
		String selectitem[] = tform.get_selectitem();
		ChAdtBaseprodidDelegate delegate = new ChAdtBaseprodidDelegate();
		String cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
		for (int i = 0; i < selectitem.length; i++) { 
			String pk = selectitem[i].split("\\|")[0];
			if (cityid.equals(pk)) {
				Serializable serializable = getDeletePkVO(selectitem[i]);
				ChAdtBaseprodidVO vo = delegate.doFindByPk(serializable, user);
				delegate.doRemove(vo, user);
			}
		}
		return this.doList(actionMapping, actionForm, request, response, user);
	}  
    
    
    //�༭
    public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	
    	ChAdtBaseprodidForm tform = (ChAdtBaseprodidForm)actionForm; 
    	ChAdtBaseprodidListVO listVO = new ChAdtBaseprodidListVO();
    	listVO.set_se_cityid(tform.getCityid());
    	listVO.set_se_prodid(tform.getProdid());
    	ChAdtBaseprodidDelegate delegate = new ChAdtBaseprodidDelegate(); 
    	DataPackage  dp = delegate.doQuery(listVO, user);
    	String cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
    	if (dp.getRowCount()>0){ 
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"��Ʒ��ʶΪ��"+tform.getProdid()+"��,����Ϊ��"+tform.getCityid()+"���������Ѵ���");
			return (actionMapping.findForward("content")); 
    		
    	} else{
    		if (!tform.getCityid().equals(cityid)){
    			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
    					"��ֻ�ܲ������Ŷ�Ӧ�ĵ��С�"+cityid+"��������,�����������ݵĵ���Ϊ����"+tform.getCityid()+"��,���޸�");
    			return (actionMapping.findForward("content")); 
    		}  
    		tform.setCreatetime(new Date());
    		}
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"��Ʒ��ʶΪ��"+tform.getProdid()+"�������������ɹ�");
        	return super.doSave(actionMapping, actionForm, request, response, user);
    	 
    } 
    
    
    //����Excel
    public ActionForward doExport(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�ײͲ�Ʒ�б�����");
		export.appendHeadLine(new String[] { "��������:", user.getOpercode() });
		export.appendHeadLine(new String[] { "����ʱ��:", format.format(new Date()) });
		export.addOutputProperty("prodid", "��Ʒ��ʶ");
		export.addOutputProperty("prodname", "��Ʒ����"); 
		export.addOutputProperty("wrapfee", "�ײ�ֵ"); 
		export.addOutputProperty("oprtype", "�ײ����", export.CODE2NAME, "$BASEPRODID_OPRTYPE");
		export.addOutputProperty("type", "�ײ�����", export.CODE2NAME, "$BASEPRODID_TYPE");
		export.addOutputProperty("tertype", "��������", export.CODE2NAME, "$BASEPRODID_TERTYPE");
		export.addOutputProperty("cityid", "���б�ʶ",export.CODE2NAME,"#CITYNAME3");
		export.addOutputProperty("createtime", "����ʱ��",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("adtremark", "��ע");
		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		export.voClassArray = new Class[] {voClass};
		export.queryMethodName = "doList";
		if (export.headtitle == null) {
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response, user, this);
    	return null;
	}
    
    
    //����
    public ActionForward doImport(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception { 
		return actionMapping.findForward("batch");
		
	}
    
    
    
    
    
    
    
    
}
