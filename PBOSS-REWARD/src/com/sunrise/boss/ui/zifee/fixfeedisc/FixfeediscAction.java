package com.sunrise.boss.ui.zifee.fixfeedisc;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.lang.ClassUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hk.qlog.Locator;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.business.zifee.fixfeedisc.persistent.PcPsFixfeediscVO;
import com.sunrise.boss.business.zifee.fixfeedisc.persistent.PcPsFixfeediscListVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.zifee.fixfeedisc.FixfeediscDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.User;


/**
 * <p>Title: FixfeediscAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public class FixfeediscAction extends BaseDelegateAction {
    public FixfeediscAction() {
        this.voClass = PcPsFixfeediscVO.class;
        // TODO: 给出主键的名字数组
        this.pkNameArray = new String[1];
        pkNameArray[0] = "fixfeediscid";        
    }
    /**
     * 保存
     */
    public ActionForward doSave(ActionMapping actionMapping,
                                   ActionForm actionForm,
                                   HttpServletRequest request,
                                   HttpServletResponse response, User user) throws
            Exception {
    	try{
    	PcPsFixfeediscVO contentVO = (PcPsFixfeediscVO)voClass.newInstance();
//        BeanUtils.copyProperties(contentVO, actionForm);

        setSaveVO(contentVO, actionForm); //在此格式化处理好 vo 以保存

        FixfeediscDelegate delegate = new FixfeediscDelegate();
        String cmdState = ((BaseActionForm)actionForm).getCmdState();
        if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {//更新
            delegate.doUpdate(contentVO, user);
            BeanUtils.copyProperties(actionForm, contentVO); //把更新后的值赋给form，用于web显示
            request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");  
        } else {//新增
        	Object vo = null;
        	if(pkNameArray.length==1){ //单一主键
        		Object pk = BeanUtils.getProperty(contentVO, pkNameArray[0]);
        		if(pk!=null){
        			vo = delegate.doFindByPk((Serializable) pk, user);
        		}
        	}else{//复合主建
        		Object pkVO = voClass.newInstance();
        		BeanUtils.copyProperties(pkVO, contentVO);
        		vo = delegate.doFindByPk((Serializable) pkVO, user);	
        	}
            if(vo==null){
            	String msg = isDiscAcctid(String.valueOf(contentVO.getYxplanid()),String.valueOf(contentVO.getAcctid()),user);
                if(!"NotExists".equals(msg)){
                	request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_NEW);
                	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_COMMAND, WebConstant.COMMAND_STRING_NEW);
                	msg = "保存失败,该营销方案已配置了帐单科目:"+String.valueOf(contentVO.getAcctid())+"的优惠,不能再新增!";
                	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, msg);
                	return (actionMapping.findForward("content"));
                }
            	delegate.doCreate(contentVO, user);	
            	BeanUtils.copyProperties(actionForm, contentVO); //把更新后的值赋给form，用于web显示
                request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");    	
            }else{
            	request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
            	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存失败,已存在相同的固定费优惠标识！"); 
            }    
        }
        return (actionMapping.findForward("content"));
    	}catch(Exception ex)
    	{
    		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,WebConstant.COMMAND_STRING_NEW);
        	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
    		return (actionMapping.findForward("content"));
    	}
    }
    public ActionForward doList(ActionMapping actionMapping,
                                   ActionForm actionForm,
                                   HttpServletRequest request,
                                   HttpServletResponse response, User user) throws
            Exception {
        Page.setPageSize(request, (BaseActionForm) actionForm);
        PcPsFixfeediscListVO listVO = new PcPsFixfeediscListVO();
//        BeanUtils.copyProperties(listVO, actionForm);

        setListVO(listVO, actionForm); //设置好listVO，作Ordinary为查询条件

        FixfeediscDelegate delegate = new FixfeediscDelegate();
        DataPackage dp = delegate.doQuery(listVO, user);
        request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
        return (actionMapping.findForward("list"));
    }
    public void setListVO(Object listVO, final ActionForm listForm) {
        try {
            PcPsFixfeediscListVO pfListVO=(PcPsFixfeediscListVO) listVO;
            com.sunrise.boss.common.utils.bean.BeanUtils.copyProperties(listVO, listForm);
            pfListVO.set_orderby("yxplanid");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
	
	/**
	 * 删除.
	 */
	public ActionForward doDelete(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
		try {
			FixfeediscDelegate delegate = new FixfeediscDelegate();	
			   
			   for (int i = 0; i < selectArray.length; i++) {
				   PcPsFixfeediscVO vo = null;
		            if (selectArray[0].indexOf('|') == -1) { //单一主键
		            	vo = delegate.doFindByPk(getDeletePK(selectArray[i]),user);
		            } else { //复合主键
		            	vo = delegate.doFindByPk(getDeletePkVO(selectArray[i]),user);
		            }				   
				    delegate.doRemove(vo,user);
			   }
		}catch(BusinessException e) {
        	 request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.toString());
        }catch(Exception e) {
        	throw e;
        } 
	   
	    return doList(actionMapping, actionForm, request, response, user);
	}	
	
	/**
	 * 根据voClass名称获取其Delegate类的一个实例
	 * @return
	 * @throws Exception
	 */
	public Object getDelegate() throws Exception {
		if(delegateClass!=null)
			return delegateClass.newInstance();
		String delegateClassName = "com.sunrise.boss.delegate.zifee.fixfeedisc.FixfeediscDelegate";
		delegateClass = Class.forName(delegateClassName);
		return delegateClass.newInstance();
		/*
		 * end of add
		 */
	}
	 /*
     * 检查帐单科目是否已经定义了优惠
     */
	public String isDiscAcctid(String yxplanid,String acctid,User user) throws Exception{
		if(yxplanid!=null && acctid!=null){
			PcPsFixfeediscListVO listVO = new PcPsFixfeediscListVO();
			listVO.set_ne_yxplanid(yxplanid);
			listVO.set_ne_acctid(acctid);
			
			FixfeediscDelegate delegate = new FixfeediscDelegate();	
			DataPackage pack = delegate.doQuery(listVO,user);
			if(pack.getRowCount()>0) 
	    	{
	    		if( pack.getDatas() != null ){
					List dpList = (List)pack.getDatas();
					if(dpList.size()>0){
						return "Exists";
					}
	    		}
	    	}
		}
		return "NotExists";
	}
}

