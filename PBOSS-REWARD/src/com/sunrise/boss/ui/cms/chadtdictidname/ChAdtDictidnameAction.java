/**
 * auto-generated code
 * Mon Dec 19 14:58:12 CST 2011
 */
package com.sunrise.boss.ui.cms.chadtdictidname;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.business.cms.chadtdictidname.persistent.ChAdtDictidnameListVO;
import com.sunrise.boss.business.cms.chadtdictidname.persistent.ChAdtDictidnameVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.admin.dictitem.DictitemDelegate;
import com.sunrise.boss.delegate.cms.chadtdictidname.ChAdtDictidnameDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>
 * Title: ChAdtDictidnameAction
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author limin
 * @version 1.0
 */
public class ChAdtDictidnameAction extends BaseAction {
	public ChAdtDictidnameAction() {
		setVoClass(ChAdtDictidnameVO.class);
		// TODO: 给出主键的名字数组
		this.pkNameArray = new String[2];
		pkNameArray[0] = "dictid";
		pkNameArray[1] = "groupid";
	}

	@Override
	protected ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		DictitemListVO listVO = new DictitemListVO();
    	setListVO(listVO, actionForm);     	
    	DictitemDelegate delegate = new DictitemDelegate();
    	DataPackage dp = delegate.doQuery(listVO,user);
    	
    	
    	ChAdtDictidnameDelegate chAdtDictidnameDelegate = new ChAdtDictidnameDelegate();
    	ChAdtDictidnameListVO chAdtDictidnameListVO = new ChAdtDictidnameListVO();
    	DataPackage dp1 = new DataPackage();
    	List list = new ArrayList();
    	
    	if(dp!=null && dp.getDatas()!=null && dp.getDatas().size()>0){
        	for(Iterator<DictitemVO> it = dp.getDatas().iterator();it.hasNext();){
        		DictitemVO dictitemVO = it.next();
        		chAdtDictidnameListVO.set_se_dictid(dictitemVO.getDictid());
        		chAdtDictidnameListVO.set_se_groupid(dictitemVO.getGroupid());
        		dp1=chAdtDictidnameDelegate.doQuerySelf(chAdtDictidnameListVO, user);
        		ChAdtDictidnameForm chAdtDictidnameForm = new ChAdtDictidnameForm();
        		
        		chAdtDictidnameForm.setGroupid(dictitemVO.getGroupid());
        		chAdtDictidnameForm.setDictid(dictitemVO.getDictid());
        		chAdtDictidnameForm.setDescription(dictitemVO.getDescription());
        		chAdtDictidnameForm.setDictitemdictname(dictitemVO.getDictname());
        		
		        		if(dp1!=null && dp1.getDatas()!=null && dp1.getDatas().size()>0){
		        			if(((ChAdtDictidnameVO)dp1.getDatas().iterator().next()).getDictname()!=null){
		        				chAdtDictidnameForm.setDictname(((ChAdtDictidnameVO)dp1.getDatas().iterator().next()).getDictname());   
		        			}                		             		
		                }
        			list.add(chAdtDictidnameForm);
            	}
        	}
    		dp1.setDatas(list);    	

		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp1);

		return (actionMapping.findForward("list"));
	}

	
	
	@Override
	protected ActionForward doView(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		return (actionMapping.findForward("list"));
	}

	@Override
	protected ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		try{
			String dictid = request.getParameter("dictid");
			String groupid = request.getParameter("groupid");
			String dictnameid = request.getParameter("dictnameidlimin");
			ChAdtDictidnameVO chAdtDictidnameVO = new ChAdtDictidnameVO();
			ChAdtDictidnameListVO listVO = new ChAdtDictidnameListVO();
			listVO.set_se_dictid(dictid);
			listVO.set_se_groupid(groupid);
			ChAdtDictidnameDelegate delegate = new ChAdtDictidnameDelegate();
			DataPackage dp = delegate.doQuerySelf(listVO, user);
			chAdtDictidnameVO.setDictid(dictid);
			chAdtDictidnameVO.setGroupid(groupid);
			chAdtDictidnameVO.setDictname(dictnameid);
			chAdtDictidnameVO.setOprcode(user.getOpercode());			
			chAdtDictidnameVO.setOptime(Calendar.getInstance().getTime());
			
			if(dp!=null && dp.getDatas()!=null && dp.getDatas().size()>0){				
				delegate.doUpdate(chAdtDictidnameVO, user);
			}else{
				delegate.doCreate(chAdtDictidnameVO, user);
			}
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功!");
		}catch(Exception e){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存失败!");
			//throw e;
		}
		return this.doList(actionMapping, actionForm, request, response, user);
	}

}
