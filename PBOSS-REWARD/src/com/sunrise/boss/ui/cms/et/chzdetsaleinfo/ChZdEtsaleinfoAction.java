/**
* auto-generated code
* Wed May 15 11:11:33 CST 2013
*/
package com.sunrise.boss.ui.cms.et.chzdetsaleinfo;

import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.chzdplatforminfo.persistent.ChZdPlatforminfoListVO;
import com.sunrise.boss.business.cms.et.chzdetsaleinfo.persistent.ChZdEtsaleinfoListVO;
import com.sunrise.boss.business.cms.et.chzdetsaleinfo.persistent.ChZdEtsaleinfoVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.delegate.cms.chzdplatforminfo.ChZdPlatforminfoDelegate;
import com.sunrise.boss.delegate.cms.et.chzdetsaleinfo.ChZdEtsaleinfoDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.taglib.code2name.Code2NameConfiger;
import com.sunrise.boss.ui.commons.taglib.code2name.Node;

/**
 * <p>Title: ChZdEtsaleinfoAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class ChZdEtsaleinfoAction extends BaseAction {
	
	public static final String CH_TERREWARDTYPE_PRO ="CH_TERREWARDTYPE_PRO";//省公司令牌
	
    public ChZdEtsaleinfoAction() {
            setVoClass(ChZdEtsaleinfoVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seq"; 
    }
    
    public static void load4list(HttpServletRequest request, User user) throws Exception{
    	ChZdPlatforminfoDelegate chzdplatforminfodelegate = new ChZdPlatforminfoDelegate();
    	ChZdPlatforminfoListVO chzdplatforminfolistvo = new ChZdPlatforminfoListVO();
    	chzdplatforminfolistvo.set_pagesize("0");
    	DataPackage zdplatformdb = chzdplatforminfodelegate.doQueryForZdplatform(chzdplatforminfolistvo, user);
    	LinkedList zdplatformset = new LinkedList();
    	if(zdplatformdb!=null && zdplatformdb.getDatas().size()>0){
    		Iterator it = zdplatformdb.getDatas().iterator();    		
			if(it.hasNext()) {
				Object obj = (Object)it.next();
				Node node = new Node();
				node.setCode(obj.toString());
				node.setName(obj.toString());
				zdplatformset.add(node);
			}
    	}
    	request.setAttribute("zdplatformset", zdplatformset);
    	DataPackage producttypedb = chzdplatforminfodelegate.doQueryForProducttype(chzdplatforminfolistvo, user);
    	LinkedList producttypeset = new LinkedList();
    	if(producttypedb!=null && producttypedb.getDatas().size()>0){
    		Iterator it = producttypedb.getDatas().iterator();    		
			if(it.hasNext()) {
				Object obj = (Object)it.next();
				Node node = new Node();
				node.setCode(obj.toString());
				node.setName(obj.toString());
				producttypeset.add(node);
			}
    	}
    	request.setAttribute("producttypeset", producttypeset);
    	
    	LinkedList bnoset = new LinkedList();
		Node node1 = new Node();
		node1.setCode("01");
		node1.setName("01");
		bnoset.add(node1);
		Node node2 = new Node();
		node2.setCode("16");
		node2.setName("16");
		bnoset.add(node2);		
		request.setAttribute("bnoset", bnoset);
    }
    
    public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {    	
    	try {
			Page.setPageSize(request, (BaseActionForm) actionForm);
			ChZdEtsaleinfoForm form = (ChZdEtsaleinfoForm) actionForm; 
			if(null == form.get_se_batchno() || "".equals(form.get_se_batchno())){
				form.set_se_batchno(form.getB_month()+form.getB_no());
				//System.out.println(form.getB_month()+form.getB_no());
			}
			ChZdEtsaleinfoListVO listVO = new ChZdEtsaleinfoListVO();
			setListVO(listVO, form);  
			ChZdEtsaleinfoDelegate delegate = new ChZdEtsaleinfoDelegate();
			if(null == form.get_se_city() || "".equals(form.get_se_city())){
    			form.set_se_city((String)Code2NameConfiger.getName("REGIONNAME",SessionFactoryRouter.conversionCityid(user.getCityid()),user.getCityid()));
    		}
			DataPackage pack = delegate.doQuery(listVO, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
			
			load4list(request,user);			
			if(null == form.get_pageno() || "".equals(form.get_pageno())){
	    		form.set_pageno(String.valueOf(pack.getPageNo()));
	    	}			
    	} catch (Exception e) {
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
    		return (actionMapping.findForward("list"));
		}
		return (actionMapping.findForward("list"));
    }
    
    public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {    	
    	try {
    		ChZdEtsaleinfoForm form = (ChZdEtsaleinfoForm) actionForm;
    		if(null == form.get_se_city() || "".equals(form.get_se_city())){
    			form.set_se_city((String)Code2NameConfiger.getName("REGIONNAME",SessionFactoryRouter.conversionCityid(user.getCityid()),user.getCityid()));
    		}
			load4list(request,user);			
    	} catch (Exception e) {
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
    		return (actionMapping.findForward("list"));
		}
		return (actionMapping.findForward("list"));
    }
}
