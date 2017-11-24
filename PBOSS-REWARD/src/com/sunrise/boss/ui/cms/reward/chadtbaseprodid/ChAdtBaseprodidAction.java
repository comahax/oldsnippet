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
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[2]; 
           pkNameArray[0] = "cityid"; 
           pkNameArray[1] = "prodid"; 
    }
    
    //查询
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
    
    
    //编辑
    public ActionForward doEdit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	request.getParameter("");
    	getContentVO(request, user, actionForm);
    	ChAdtBaseprodidForm tform=(ChAdtBaseprodidForm)actionForm;
		 return (actionMapping.findForward("content"));
    } 
    
    
    
    
    
    
    //新增
    public ActionForward doNew(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	ChAdtBaseprodidForm tform=(ChAdtBaseprodidForm)actionForm;
    	String cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
    	tform.setCityid(cityid);
		return super.doNew(actionMapping, actionForm, request, response, user);
    } 
    
    
    //删除
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
    
    
    //编辑
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
					"产品标识为【"+tform.getProdid()+"】,地市为【"+tform.getCityid()+"】的数据已存在");
			return (actionMapping.findForward("content")); 
    		
    	} else{
    		if (!tform.getCityid().equals(cityid)){
    			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
    					"您只能操作工号对应的地市【"+cityid+"】的数据,而新增的数据的地市为：【"+tform.getCityid()+"】,请修改");
    			return (actionMapping.findForward("content")); 
    		}  
    		tform.setCreatetime(new Date());
    		}
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"产品标识为【"+tform.getProdid()+"】的数据新增成功");
        	return super.doSave(actionMapping, actionForm, request, response, user);
    	 
    } 
    
    
    //导出Excel
    public ActionForward doExport(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("套餐产品列表设置");
		export.appendHeadLine(new String[] { "导出工号:", user.getOpercode() });
		export.appendHeadLine(new String[] { "导出时间:", format.format(new Date()) });
		export.addOutputProperty("prodid", "产品标识");
		export.addOutputProperty("prodname", "产品名称"); 
		export.addOutputProperty("wrapfee", "套餐值"); 
		export.addOutputProperty("oprtype", "套餐类别", export.CODE2NAME, "$BASEPRODID_OPRTYPE");
		export.addOutputProperty("type", "套餐类型", export.CODE2NAME, "$BASEPRODID_TYPE");
		export.addOutputProperty("tertype", "购机类型", export.CODE2NAME, "$BASEPRODID_TERTYPE");
		export.addOutputProperty("cityid", "地市标识",export.CODE2NAME,"#CITYNAME3");
		export.addOutputProperty("createtime", "创建时间",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("adtremark", "备注");
		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		export.voClassArray = new Class[] {voClass};
		export.queryMethodName = "doList";
		if (export.headtitle == null) {
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response, user, this);
    	return null;
	}
    
    
    //导入
    public ActionForward doImport(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception { 
		return actionMapping.findForward("batch");
		
	}
    
    
    
    
    
    
    
    
}
