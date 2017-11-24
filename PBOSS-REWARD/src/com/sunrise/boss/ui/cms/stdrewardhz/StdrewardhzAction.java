/**
* auto-generated code
* Sun Feb 01 17:08:50 CST 2009
*/
package com.sunrise.boss.ui.cms.stdrewardhz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.stdreward.persistent.StdrewardListVO;
import com.sunrise.boss.business.cms.stdreward.persistent.StdrewardVO;
import com.sunrise.boss.business.cms.stdrewardhz.persistent.StdrewardhzListVO;
import com.sunrise.boss.business.cms.stdrewardhz.persistent.StdrewardhzVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamListVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.cms.stdreward.StdrewardDelegate;
import com.sunrise.boss.delegate.cms.stdrewardhz.StdrewardhzDelegate;
import com.sunrise.boss.delegate.common.sysparam.SysparamDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: StdrewardhzAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class StdrewardhzAction extends BaseAction {
	
	private static final String RELATEITEM_NUM = "00000000";
	
    public StdrewardhzAction() {
            setVoClass(StdrewardhzVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[4]; 
           pkNameArray[0] = "region"; 
           pkNameArray[1] = "rewardid"; 
           pkNameArray[2] = "slv"; 
           pkNameArray[3] = "years"; 
    }
    
    public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	try{
	    	Page.setPageSize(request, (BaseActionForm) actionForm);
	    	StdrewardhzForm form = (StdrewardhzForm) actionForm;
	    	StdrewardListVO listVO = new StdrewardListVO();
	    	setListVO(listVO, form);
	    	listVO.set_ne_rewardproj("4");
			if(StringUtils.isEmpty(listVO.get_orderby())){
				listVO.set_orderby("rewardid");
			}
	    	StdrewardDelegate delegate = new StdrewardDelegate();
	    	DataPackage dp = delegate.doQuery(listVO, user);
	    	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
    	}catch(Exception ex){
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "删除失败:"
					+ ex.getMessage());
    	}
		return actionMapping.findForward("list");
    }
    
    public ActionForward doDelete(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	try{
	    	String[] selectArray = ((StdrewardhzForm) actionForm).get_selectitem();
	    	StdrewardhzDelegate delegate = new StdrewardhzDelegate();
	    	for (int i = 0; i < selectArray.length; i++) {
				StdrewardhzVO stdrewardhzvo = new StdrewardhzVO();
				stdrewardhzvo.setRewardid(new Long(selectArray[i]));
				if (selectArray[0].indexOf('|') == -1) { // 单一主键
					delegate.doRemove(stdrewardhzvo, user);
				}
			}
    	}catch(Exception ex){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "删除失败:"
					+ ex.getMessage());
		}
    	return doList(actionMapping, actionForm, request, response, user);
    }
    
    public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	
    	String pk = request.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
    	StdrewardhzForm form = (StdrewardhzForm) actionForm;
    	
    	request.getSession().setAttribute("OLDSTARLIST", new ArrayList());
		request.getSession().setAttribute("NEWSTARLIST", new ArrayList());

    	if(StringUtils.isNotEmpty(pk) && !"null".equalsIgnoreCase(pk)){//pk存在为编辑状态
    		//Load Stdreward
    		StdrewardDelegate stdrewarddelegate = new StdrewardDelegate();
    		StdrewardVO stdrewardvo = stdrewarddelegate.doFindByPk(new Long(pk), user);
    		BeanUtils.copyProperties(form, stdrewardvo);
    		//Load Stdrewardhz
    		StdrewardhzDelegate stdrewardhzdelegate = new StdrewardhzDelegate();
    		StdrewardhzListVO listvo = new StdrewardhzListVO();
    		listvo.set_ne_rewardid(pk);
    		listvo.set_orderby("rewardid");
    		listvo.set_pagesize("0");
    		form.setOldstarlist((List)stdrewardhzdelegate.doQuery(listvo, user).getDatas());
    		request.getSession().setAttribute("OLDSTARLIST", form.getOldstarlist());
    		request.getSession().setAttribute("NEWSTARLIST", form.getOldstarlist());
    		request.setAttribute("STARLIST", form.getOldstarlist());
    	}
    	
    	return actionMapping.findForward("contentprov");
    }
    
    public ActionForward doAddstar(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	StdrewardhzForm form = (StdrewardhzForm) actionForm;
    	form.setOldstarlist((List)request.getSession().getAttribute("OLDSTARLIST"));
    	form.setNewstarlist((List)request.getSession().getAttribute("NEWSTARLIST"));
    	
    	StdrewardhzVO vo = new StdrewardhzVO();
    	BeanUtils.copyProperties(vo, form);
    	
    	List newstarlist = new ArrayList();
    	newstarlist.addAll(form.getNewstarlist());
    	
    	Iterator itt = newstarlist.iterator();
    	boolean flag = false;
    	while(itt.hasNext()){
    		StdrewardhzVO compvo = (StdrewardhzVO)itt.next();
    		if(compvo.getRegion().equals(vo.getRegion())&&compvo.getSlv().equals(vo.getSlv())&&compvo.getYears().equals(vo.getYears())){
    			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "在列表中有相同的记录存在!");
    			flag = true;
    			break;
    		}
    	}
    	if(flag == false){
    		vo.setRewardid(null);
    		vo.setState("NEW");
    		vo.setRelateitem("00"+RELATEITEM_NUM);
    		newstarlist.add(vo);
    	}
    	
    	form.setSlv(null);
    	form.setRegion(null);
    	form.setLmtstd(null);
    	form.setYears(null);
    	
    	form.setNewstarlist(newstarlist);
    	request.getSession().setAttribute("OLDSTARLIST", form.getOldstarlist());
		request.getSession().setAttribute("NEWSTARLIST", form.getNewstarlist());
		request.setAttribute("STARLIST", form.getNewstarlist());
		return actionMapping.findForward("contentprov");
    } 
    
    public ActionForward doEditstar(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	StdrewardhzForm form = (StdrewardhzForm) actionForm;
    	form.setOldstarlist((List)request.getSession().getAttribute("OLDSTARLIST"));
    	form.setNewstarlist((List)request.getSession().getAttribute("NEWSTARLIST"));
    	
    	String[] pks = ((String)request.getParameter("pks")).split("\\|");
    	StdrewardhzVO vo = new StdrewardhzVO();
    	vo.setRewardid(StringUtils.isEmpty(pks[0])? null : new Long(pks[0]));
    	vo.setRegion(pks[1]);
    	vo.setSlv(new Short(pks[2]));
    	vo.setYears(new Short(pks[3]));
    	vo.setRelateitem(pks[4]);
    	
    	if(pks[4].substring(0, 2).equals("00")){
    		form.setIsRelateitem(false);
    		form.setIsHealth(false);
    	}else if(pks[4].substring(0, 2).equals("10")){
    		form.setIsRelateitem(true);
    		form.setIsHealth(false);
    	}else if(pks[4].substring(0, 2).equals("01")){
    		form.setIsRelateitem(false);
    		form.setIsHealth(true);
    	}else{
    		form.setIsRelateitem(true);
    		form.setIsHealth(true);
    	}
    	
    	List newstarlist = new ArrayList();
    	newstarlist.addAll(form.getNewstarlist());
    	
    	Iterator itt = newstarlist.iterator();
    	while(itt.hasNext()){
    		StdrewardhzVO compvo = (StdrewardhzVO)itt.next();
    		if(compvo.getRegion().equals(vo.getRegion())&&compvo.getSlv().equals(vo.getSlv())&&compvo.getYears().equals(vo.getYears())){
    			BeanUtils.copyProperties(form, compvo);
    			break;
    		}
    	}
    	
    	form.setNewstarlist(newstarlist);
    	request.getSession().setAttribute("OLDSTARLIST", form.getOldstarlist());
		request.getSession().setAttribute("NEWSTARLIST", form.getNewstarlist());
		request.setAttribute("STARLIST", form.getNewstarlist());
		return actionMapping.findForward("contentprov");
    }
    
    
    public ActionForward doDeletestar(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	StdrewardhzForm form = (StdrewardhzForm) actionForm;
    	form.setOldstarlist((List)request.getSession().getAttribute("OLDSTARLIST"));
    	form.setNewstarlist((List)request.getSession().getAttribute("NEWSTARLIST"));
    	
    	List newstarlist = new ArrayList();
    	newstarlist.addAll(form.getNewstarlist());
    	
    	String[] vos = form.get_selectitem();
    	for(int i=0;i<vos.length;i++){
    		String[] pks = vos[i].split("\\|");
    		StdrewardhzVO vo = new StdrewardhzVO();
        	vo.setRewardid(StringUtils.isEmpty(pks[0])? null : new Long(pks[0]));
        	vo.setRegion(pks[1]);
        	vo.setSlv(new Short(pks[2]));
        	vo.setYears(new Short(pks[3]));
        	Iterator itt = newstarlist.iterator();
        	while(itt.hasNext()){
        		StdrewardhzVO compvo = (StdrewardhzVO)itt.next();
        		if(compvo.getRegion().equals(vo.getRegion())&&compvo.getSlv().equals(vo.getSlv())&&compvo.getYears().equals(vo.getYears())){
        			newstarlist.remove(compvo);
        			break;
        		}
        	}
    	}
    	
    	form.setNewstarlist(newstarlist);
    	request.getSession().setAttribute("OLDSTARLIST", form.getOldstarlist());
		request.getSession().setAttribute("NEWSTARLIST", form.getNewstarlist());
		request.setAttribute("STARLIST", form.getNewstarlist());
		return actionMapping.findForward("contentprov");
    }
    
    public ActionForward doSavestar(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	StdrewardhzForm form = (StdrewardhzForm) actionForm;
    	form.setOldstarlist((List)request.getSession().getAttribute("OLDSTARLIST"));
    	form.setNewstarlist((List)request.getSession().getAttribute("NEWSTARLIST"));
    	
    	StdrewardhzVO vo = new StdrewardhzVO();
    	BeanUtils.copyProperties(vo, form);
    	if(form.getIsRelateitem()&&form.getIsHealth()){ //勾上则肯定为市公司页面
    		vo.setRelateitem("11"+RELATEITEM_NUM);
    	}else if (form.getIsRelateitem()&&!form.getIsHealth()){
    		vo.setRelateitem("10"+RELATEITEM_NUM);
    	}else if (!form.getIsRelateitem()&&form.getIsHealth()){
    		if(form.isCity()){
    			vo.setRelateitem("01"+RELATEITEM_NUM);
    		}
    	}else{
    		if(form.isCity()){
    			vo.setRelateitem("00"+RELATEITEM_NUM);
    		}
    	}
    		//没勾上则判断一下是否来源于市公司
    	
    	List newstarlist = new ArrayList();
    	newstarlist.addAll(form.getNewstarlist());
    	
    	Iterator itt = newstarlist.iterator();
    	while(itt.hasNext()){
    		StdrewardhzVO compvo = (StdrewardhzVO)itt.next();
    		if(compvo.getRegion().equals(vo.getRegion())&&compvo.getSlv().equals(vo.getSlv())&&compvo.getYears().equals(vo.getYears())){
    			Long rewardid = compvo.getRewardid();
    			newstarlist.remove(compvo);
    			vo.setRewardid(rewardid);
    			vo.setState("EDIT");
    			newstarlist.add(vo);
    			break;
    		}
    	}
    	
    	form.setSlv(null);
    	form.setRegion(null);
    	form.setLmtstd(null);
    	form.setYears(null);
    	form.setIsRelateitem(false);
    	form.setIsHealth(false);
    	
    	form.setNewstarlist(newstarlist);
    	request.getSession().setAttribute("OLDSTARLIST", form.getOldstarlist());
		request.getSession().setAttribute("NEWSTARLIST", form.getNewstarlist());
		request.setAttribute("STARLIST", form.getNewstarlist());
		return actionMapping.findForward("contentprov");
    }
    
    public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	StdrewardhzForm form = (StdrewardhzForm) actionForm;
    	form.setOldstarlist((List)request.getSession().getAttribute("OLDSTARLIST"));
    	form.setNewstarlist((List)request.getSession().getAttribute("NEWSTARLIST"));
    	
    	List newstarlist = new ArrayList();
    	newstarlist.addAll(form.getNewstarlist());
    	List oldstarlist = new ArrayList();
    	oldstarlist.addAll(form.getOldstarlist());
    	
    	if(newstarlist.size() == 0){
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "合作上限奖酬金列表不能为空!");
    		return actionMapping.findForward("contentprov");
    	}
    	
    	StdrewardVO stdrewardvo = new StdrewardVO();
    	BeanUtils.copyProperties(stdrewardvo, form);
    	StdrewardhzDelegate delegate = new StdrewardhzDelegate();
    	stdrewardvo = delegate.doSave(stdrewardvo, oldstarlist, newstarlist, form.isCity(), user);
    	
    	BeanUtils.copyProperties(form, stdrewardvo);
    	form.setNewstarlist(newstarlist);
    	request.getSession().setAttribute("OLDSTARLIST", form.getNewstarlist());
		request.getSession().setAttribute("NEWSTARLIST", form.getNewstarlist());
		request.setAttribute("STARLIST", form.getNewstarlist());
    	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功!");
		return actionMapping.findForward("contentprov");
    }
    
    public ActionForward doShowcity(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	
    	String pk = request.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
    	StdrewardhzForm form = (StdrewardhzForm) actionForm;
    	
    	request.getSession().setAttribute("OLDSTARLIST", new ArrayList());
		request.getSession().setAttribute("NEWSTARLIST", new ArrayList());

    	if(StringUtils.isNotEmpty(pk) && !"null".equalsIgnoreCase(pk)){//pk存在为编辑状态
    		//Load Stdreward
    		StdrewardDelegate stdrewarddelegate = new StdrewardDelegate();
    		StdrewardVO stdrewardvo = stdrewarddelegate.doFindByPk(new Long(pk), user);
    		BeanUtils.copyProperties(form, stdrewardvo);
    		//Load Stdrewardhz
    		StdrewardhzDelegate stdrewardhzdelegate = new StdrewardhzDelegate();
    		StdrewardhzListVO listvo = new StdrewardhzListVO();
    		listvo.set_ne_rewardid(pk);
    		listvo.set_se_region(user.getCityid());
    		listvo.set_orderby("rewardid");
    		DataPackage dp = stdrewardhzdelegate.doQuery(listvo, user);
    		if(dp.getDatas().size() == 0){
    			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "在省公司合作年限奖酬金标准中，没有设置的本市公司合作年限奖酬金标准，请联系省公司相关人员!");
    			return actionMapping.findForward("contentcity");
    		}
    		form.setHealth(new Double(stdrewardhzdelegate.doQueryHealth(user)));
    		form.setOldstarlist((List)dp.getDatas());
    		
    		request.getSession().setAttribute("OLDSTARLIST", form.getOldstarlist());
    		request.getSession().setAttribute("NEWSTARLIST", form.getOldstarlist());
    		request.setAttribute("STARLIST", form.getOldstarlist());
    	}else{
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "缺少酬金标识参数传入,请重新点击链接!");
    		return actionMapping.findForward("contentcity");
    	}
    	
    	
    	SysparamDelegate sysparamDelegate=new SysparamDelegate();
    	SysparamListVO sysparamListVO=new SysparamListVO();
    	sysparamListVO.set_ne_systemid("73");
    	sysparamListVO.set_se_paramtype("channel");
    	DataPackage package1=sysparamDelegate.doQuery(sysparamListVO, user);
    	if(package1.getDatas().size()==0){
    		form.setIntvmonth(0);
    	}else{
    		Iterator it = package1.getDatas().iterator();
    		if (it.hasNext()) {
    			SysparamVO vo=(SysparamVO)it.next();
    			form.setIntvmonth(Integer.parseInt(vo.getParamvalue()));
    		}else{
    			form.setIntvmonth(0);
    		}
    	}
    	
    	return actionMapping.findForward("contentcity");
    }
    
    public ActionForward doEditstarcity(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	this.doEditstar(actionMapping, actionForm, request, response, user);
//    	StdrewardhzForm form = (StdrewardhzForm) actionForm;
//    	SysparamDelegate sysparamDelegate=new SysparamDelegate();
//		SysparamListVO sysparamListVO=new SysparamListVO();
//		sysparamListVO.set_ne_systemid("73");
//		sysparamListVO.set_se_paramtype("channel");
//		DataPackage package1=sysparamDelegate.doQuery(sysparamListVO, user);
//		if(package1.getDatas().size()==0){
//			form.setIntvmonth(0);
//		}else{
//			Iterator it = package1.getDatas().iterator();
//			if (it.hasNext()) {
//				SysparamVO vo=(SysparamVO)it.next();
//				form.setIntvmonth(Integer.parseInt(vo.getParamvalue()));
//			}else{
//				form.setIntvmonth(0);
//			}
//		}
    	return actionMapping.findForward("contentcity");
    }
    
    public ActionForward doSavestarcity(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	StdrewardhzForm form = (StdrewardhzForm) actionForm;
    	form.setCity(true);
    	this.doSavestar(actionMapping, actionForm, request, response, user);
    	form.setCitystd(null);
//    	form.setIntvmonth(form.getIntvmonth());
    	return actionMapping.findForward("contentcity");
    }
    
    public ActionForward doSavecity(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	StdrewardhzForm form = (StdrewardhzForm) actionForm;
    	form.setCity(true);
    	this.doSave(actionMapping, form, request, response, user);
    	return actionMapping.findForward("contentcity");
    }
    
    public ActionForward doSaveintvmonth(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	StdrewardhzForm form = (StdrewardhzForm) actionForm;
//    	form.setIntvmonth(1);
    	
    	String pk = form.getRewardid().toString();
//    	StdrewardhzForm form = (StdrewardhzForm) actionForm;
    	
    	request.getSession().setAttribute("OLDSTARLIST", new ArrayList());
		request.getSession().setAttribute("NEWSTARLIST", new ArrayList());

    	if(StringUtils.isNotEmpty(pk) && !"null".equalsIgnoreCase(pk)){//pk存在为编辑状态
    		//Load Stdreward
    		StdrewardDelegate stdrewarddelegate = new StdrewardDelegate();
    		StdrewardVO stdrewardvo = stdrewarddelegate.doFindByPk(new Long(pk), user);
    		BeanUtils.copyProperties(form, stdrewardvo);
    		//Load Stdrewardhz
    		StdrewardhzDelegate stdrewardhzdelegate = new StdrewardhzDelegate();
    		StdrewardhzListVO listvo = new StdrewardhzListVO();
    		listvo.set_ne_rewardid(pk);
    		listvo.set_se_region(user.getCityid());
    		listvo.set_orderby("rewardid");
    		DataPackage dp = stdrewardhzdelegate.doQuery(listvo, user);
    		if(dp.getDatas().size() == 0){
    			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "在省公司合作年限奖酬金标准中，没有设置的本市公司合作年限奖酬金标准，请联系省公司相关人员!");
    			return actionMapping.findForward("contentcity");
    		}
    		form.setHealth(new Double(stdrewardhzdelegate.doQueryHealth(user)));
    		form.setOldstarlist((List)dp.getDatas());
    		
    		request.getSession().setAttribute("OLDSTARLIST", form.getOldstarlist());
    		request.getSession().setAttribute("NEWSTARLIST", form.getOldstarlist());
    		request.setAttribute("STARLIST", form.getOldstarlist());
    	}else{
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "缺少酬金标识参数传入,请重新点击链接!");
    		return actionMapping.findForward("contentcity");
    	}
    	
    	
    	SysparamDelegate sysparamDelegate=new SysparamDelegate();
    	SysparamListVO sysparamListVO=new SysparamListVO();
    	sysparamListVO.set_ne_systemid("73");
    	sysparamListVO.set_se_paramtype("channel");
    	DataPackage package1=sysparamDelegate.doQuery(sysparamListVO, user);
    	if(package1.getDatas().size()==0){
    		form.setIntvmonth(0);
    	}else{
    		Iterator it = package1.getDatas().iterator();
    		if (it.hasNext()) {
    			SysparamVO vo=(SysparamVO)it.next();
    			vo.setParamvalue(String.valueOf(form.getIntvmonth()));
    			sysparamDelegate.doUpdate(vo, user);
    		}else{
    			form.setIntvmonth(0);
    		}
    	}
    	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功!");
    	return actionMapping.findForward("contentcity");
    	
    }
    
}
