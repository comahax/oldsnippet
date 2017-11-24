/**
* auto-generated code
* Sat Nov 16 10:49:38 CST 2013
*/
package com.sunrise.boss.ui.cms.reward.chadtwayspecialreward;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.reward.chadtwayspecialreward.persistent.ChAdtWayspecialrewardListVO;
import com.sunrise.boss.business.cms.reward.chadtwayspecialreward.persistent.ChAdtWayspecialrewardVO;
import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.reward.chadtwayspecialreward.ChAdtWayspecialrewardDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ChAdtWayspecialrewardAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class ChAdtWayspecialrewardAction extends BaseAction {
    public ChAdtWayspecialrewardAction() {
            setVoClass(ChAdtWayspecialrewardVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "wayid"; 
    }
    
    public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	ChAdtWayspecialrewardForm form = (ChAdtWayspecialrewardForm) actionForm;
		Page.setPageSize(request, (ChAdtWayspecialrewardForm) form);
		
		ChAdtWayspecialrewardListVO chadtwayspecialrewardlistvo = new ChAdtWayspecialrewardListVO();
		setListVO(chadtwayspecialrewardlistvo, actionForm);
		Date date = new Date(System.currentTimeMillis());
		if(chadtwayspecialrewardlistvo.get_dnl_createdate()!=null && !("".equals(chadtwayspecialrewardlistvo.get_dnl_createdate())))
			chadtwayspecialrewardlistvo.set_dnl_createdate(chadtwayspecialrewardlistvo.get_dnl_createdate()+" 00:00:00");
		if(chadtwayspecialrewardlistvo.get_dnm_createdate()!=null && !("".equals(chadtwayspecialrewardlistvo.get_dnm_createdate())))
			chadtwayspecialrewardlistvo.set_dnm_createdate(chadtwayspecialrewardlistvo.get_dnm_createdate()+" 23:59:59");
		
		chadtwayspecialrewardlistvo.set_se_cityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
    	
    	ChAdtWayspecialrewardDelegate chadtwayspecialrewardDelegate = new ChAdtWayspecialrewardDelegate();
		DataPackage pack = chadtwayspecialrewardDelegate.doQuery(chadtwayspecialrewardlistvo, user);
		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
		return (actionMapping.findForward("list"));
    }
    
    public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	ChAdtWayspecialrewardForm form = (ChAdtWayspecialrewardForm) actionForm;
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar   ca   =   Calendar.getInstance();
		ca.setTime(new Date());
		ca.set(Calendar.DAY_OF_MONTH,   1);
		Date   firstDate   =   ca.getTime();
		ca.add(Calendar.MONTH,   1);
		ca.add(Calendar.DAY_OF_MONTH,   -1);
		Date   lastDate   =   ca.getTime();
		
		if(form.get_dnl_createdate()==null || ("".equals(form.get_dnl_createdate())))
			form.set_dnl_createdate(df.format(firstDate));
		if(form.get_dnm_createdate()==null || ("".equals(form.get_dnm_createdate())))
			form.set_dnm_createdate(df.format(lastDate));
		
		return (actionMapping.findForward("list"));
    }
    
    public ActionForward doNew(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	ChAdtWayspecialrewardForm form = (ChAdtWayspecialrewardForm) actionForm;
    	form.setCityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
		form.setCreatedate(new Date());
    	
		return super.doNew(actionMapping, actionForm, request, response, user);
    }
    
    public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	try {
    		ChAdtWayspecialrewardForm form = (ChAdtWayspecialrewardForm) actionForm;
//        	form.setCityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
//    		form.setCreatedate(new Date());
        	WayDelegate waydelegate=new WayDelegate();
    		WayListVO wayListVO = new WayListVO();
    		wayListVO.set_se_wayid(form.getWayid());
//    		wayListVO.set_ne_waystate(Short.valueOf("1"));
//    		wayListVO.set_se_waytype("AG");
    		DataPackage waydp = waydelegate.doQuery(wayListVO, user);
    		if(waydp.getRowCount()==0){
//    			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "查询不到渠道信息，渠道无效");
//    			return (actionMapping.findForward("content"));
    			throw new Exception("查询不到渠道信息，渠道无效");
    		}
    		
    		ChAdtWayspecialrewardDelegate chadtwayspecialrewardDelegate=new ChAdtWayspecialrewardDelegate();
			ChAdtWayspecialrewardListVO listvo=new ChAdtWayspecialrewardListVO();
			listvo.set_se_wayid(form.getWayid());
			listvo.set_se_cityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
			DataPackage dp=chadtwayspecialrewardDelegate.doQuery(listvo, user);
			if(dp!=null&&dp.getDatas().size()>0){
				throw new Exception("当前渠道已存在");
			}
    		
    		super.doSave(actionMapping, actionForm, request, response, user);
    	} catch (Exception ex) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
		}
		return (actionMapping.findForward("content"));
    	
    }
    
    public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception{ 
    	CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("特殊计酬渠道设置");
		export.appendHeadLine(new String[] { "导出工号:", user.getOpercode() });
		export.appendHeadLine(new String[] { "导出时间:", format.format(new Date()) });
		export.addOutputProperty("wayid", "渠道编码");
		export.addOutputProperty("wayspetype", "渠道类型", export.CODE2NAME, "$CH_WAYSPETYPE");
//		export.addOutputProperty("cityid", "地市标识", export.CODE2NAME, "#CITYNAME");
		export.addOutputProperty("createdate", "创建时间", export.DATE, "yyyy-MM-dd");
		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);		
		export.voClassArray = new Class[] { ChAdtWayspecialrewardVO.class };
		export.queryMethodName = "doList";
		if (export.headtitle == null) {
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response, user, this);
    	
    	return null;
    }
    
    public ActionForward doImport(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		return actionMapping.findForward("batch");
	}
}
