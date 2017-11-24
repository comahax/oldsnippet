/**
* auto-generated code
* Thu Dec 22 09:33:15 CST 2011
*/
package com.sunrise.boss.ui.cms.reward.stdrewardcq;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.reward.stdrewardcq.persistent.StdrewardcqListVO;
import com.sunrise.boss.business.cms.reward.stdrewardcq.persistent.StdrewardcqVO;
import com.sunrise.boss.business.cms.stdreward.persistent.StdrewardListVO;
import com.sunrise.boss.business.cms.stdreward.persistent.StdrewardVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.reward.stdrewardcq.StdrewardcqDelegate;
import com.sunrise.boss.delegate.cms.stdreward.StdrewardDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: StdrewardcqAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class StdrewardcqAction extends BaseAction {
    public StdrewardcqAction() {
            setVoClass(StdrewardcqVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[2]; 
           pkNameArray[0] = "region"; 
           pkNameArray[1] = "rewardid"; 
    }
    
    public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	
    	StdrewardcqForm form=(StdrewardcqForm)actionForm;
    	StdrewardcqDelegate stdrewardcqDelegate=new StdrewardcqDelegate();
    	StdrewardcqListVO stdrewardcqListVO=new StdrewardcqListVO();
    	if(!"".equals(form.get_se_region())){
    		stdrewardcqListVO.set_se_region(form.get_se_region());
    	}
    	stdrewardcqListVO.set_pageno("");
    	DataPackage dp=stdrewardcqDelegate.doQuery2(stdrewardcqListVO, user);
    	request.setAttribute("dp", dp);
		return (actionMapping.findForward("list"));
    }
    
    
 // 保存
	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		StdrewardcqForm form=(StdrewardcqForm)actionForm;
		
		
		StdrewardDelegate stdrewardDelegate=new StdrewardDelegate();
		StdrewardListVO stdrewardListVO=new StdrewardListVO();
		stdrewardListVO.set_ne_rewardtype("60");
		DataPackage dataPackage=stdrewardDelegate.doQuery(stdrewardListVO, user);
		
		if (dataPackage != null && dataPackage.getDatas().size() > 0) {
			Iterator it = dataPackage.getDatas().iterator();
			if (it.hasNext()) {
				StdrewardVO stdrewardVO=(StdrewardVO)it.next();
				form.setRewardid(stdrewardVO.getRewardid());
			}
		}else{
//			throw new Exception("没有查询到对应的rewardid.");
//			return (actionMapping.findForward("content"));
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "没有查询到对应的rewardid.");
			return (actionMapping.findForward("content"));
		}
		
		StdrewardcqDelegate stdrewardcqDelegate=new StdrewardcqDelegate();
		StdrewardcqListVO listVO=new StdrewardcqListVO();
		listVO.set_ne_rewardid(form.getRewardid().toString());
		listVO.set_se_region(form.getRegion());
		DataPackage dataPackage2=stdrewardcqDelegate.doQuery(listVO, user);
		
		if (dataPackage2 != null && dataPackage2.getDatas().size() > 0 ) {
//			throw new Exception("相同rewardid和region记录已存在,不再作插入操作.");
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "相同rewardid和region记录已存在,不再作插入操作.");
			return (actionMapping.findForward("content"));
		}
		
		return super.doSave(actionMapping, actionForm, request, response, user);
	}
    
}
