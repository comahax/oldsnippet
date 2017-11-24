/**
 * @author He Kun (Henry He), Guangzhou, China
 * 2006-9-4
 */
package com.sunrise.boss.ui.base;

import java.io.*;
import java.lang.reflect.*;
import java.text.*;

import javax.servlet.http.*;

import org.apache.commons.beanutils.*;
import org.apache.commons.lang.*;
import org.apache.struts.action.*;

import com.hk.qlog.*;
import com.sunrise.boss.common.base.db.*;
import com.sunrise.boss.common.exception.business.*;
import com.sunrise.boss.ui.commons.*;
import com.sunrise.boss.common.utils.bean.BeanUtils;

/**
 * BaseDelegateAction
 * <br> Description: 将操作委托给具体的Delegate类,而不是CommonDelegate,以保证调用业务方法.
 * <br> Company: Sunrise,Guangzhou</br>
 * @author He Kun
 * @since 1.0
 * @version 1.0
 * 2006-9-4
 */
public class BaseDelegateAction extends BaseAction {
	
	protected Class delegateClass;
	/**
	 * 查询
	 */
	protected ActionForward doList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
//	    Page.setPageSize(request, (BaseActionForm) actionForm);        
               
        try {
        	Page.setPageSize(request, (BaseActionForm) actionForm);        	
        	BaseListVO listVO = getListVO(); 
        	setListVO(listVO, actionForm); //设置好listVO，作为查询条件
        	
        	Object delegate = getDelegate();
            
            String methodName = "doQuery";
            DataPackage pack = (DataPackage)invokeDelegateMethod(delegate,methodName,new Object[]{listVO, user});
            request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
        }catch(BusinessException e) {
        	 request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
        }catch(Exception e) {
        	throw e;
        } 
        return (actionMapping.findForward("list"));
	}
	
	/**
	 * 删除.
	 */
	protected ActionForward doDelete(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
		try {
			   Object delegate = getDelegate();		
		
			   String findByPK = "doFindByPk";
			   String methodName = "doRemove";
			   
			   for (int i = 0; i < selectArray.length; i++) {
				   Object vo = null;
		            if (selectArray[0].indexOf('|') == -1) { //单一主键
		            	vo = invokeDelegateMethod(delegate,findByPK,new Object[]{getDeletePK(selectArray[i]), user});
		            } else { //复合主键
		            	vo = invokeDelegateMethod(delegate,findByPK,new Object[]{getDeletePkVO(selectArray[i]), user});
		            }
				   
				   Object ret = invokeDelegateMethod(delegate,methodName,new Object[]{vo, user});
			   }
		}catch(BusinessException e) {
        	 request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.toString());
        }catch(Exception e) {
        	throw e;
        } 
	   
	    return doList(actionMapping, actionForm, request, response, user);
	}
	
	/**
	 * 根据主键构造一个VO实例. 
	 * @param voClass
	 * @param pkValues
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	protected Object getDeletePkVO(Class voClass , String pkString) throws Exception {
		Serializable vo = (Serializable)voClass.newInstance();
		String[] pkValues = pkString.split("\\|");
		for (int i = 0; i < pkValues.length; i++) {
            try {
            	String pkName = pkNameArray[i];
                String pkValue = pkValues[i];
				BeanUtils.setProperty(vo, pkName, pkValue);
				
			} catch (Exception e) {				
				e.printStackTrace();
			}
        }
		return vo;
	}
	
	/**
	 * 根据request中的pk参数查询一个vo的实例
	 */
	protected Object getContentVO(HttpServletRequest request, User user) throws Exception {
		String pk = null;
        String parameter = request.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
        //list.jsp跳转过来的情况
        if (parameter != null) pk = parameter;
        
        if(pk==null) return null;
		Object delegate = getDelegate();
		String methodName = "doFindByPk";
		
		Object vo = null;
		if(pk.indexOf("|") < 0 )
			vo = getDeletePK(pk);
		else
			vo = getDeletePkVO(voClass, pk);	
		
		Object ret = invokeDelegateMethod(delegate,methodName,new Object[]{vo, user});
		return ret;
	}
	
	//doEdit, doView 不需要覆写, 只覆写 getContentVO(HttpServletRequest request, User user) 即可
	
	/**
	 * 保存
	 */
	protected ActionForward doSave(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		
		
	   Object contentVO = voClass.newInstance();
       setSaveVO(contentVO, actionForm); //在此格式化处理好 vo 以保存
       
       //if(pkNameArray.length > 1)
       //   throw new RuntimeException("Multiple pk not supported by default doSave. Try to implement this method.");
       
       //Object pk = PropertyUtils.getProperty(contentVO, pkNameArray[0]);
       Object delegate = getDelegate();
       String methodName = "doFindByPk";
       
       Object existObj = null;
       
   	    if(pkNameArray.length==1){ //单一主键
		   Object pk = (Object)BeanUtils.getProperty(contentVO, pkNameArray[0]);
		   if(pk!=null){
			   existObj = invokeDelegateMethod(delegate,methodName,new Object[]{(Serializable)pk, user});
		   }
	      }else{//复合主建
		     Object pkVO = voClass.newInstance();
		     BeanUtils.copyProperties(pkVO, contentVO);
		     existObj = invokeDelegateMethod(delegate,methodName,new Object[]{pkVO, user});
	     } 
       
       
 	   if(existObj!=null) {
 		   org.apache.commons.beanutils.BeanUtils.copyProperties(existObj, contentVO);
    	   contentVO = existObj;
	   }  
       
       
       String cmdState = ((BaseActionForm)actionForm).getCmdState();
	   try {
	       if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {
	    	   
	    	   methodName = "doUpdate";
	    	   contentVO = invokeDelegateMethod(delegate,methodName,new Object[]{contentVO, user});
	          
	       } else {
	    	   if(existObj!=null) {
	    		    request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
	           		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "相同记录已存在"); 
	           		onDuplicatePk(actionMapping,actionForm, request, response, user);
	           		return (actionMapping.findForward("content"));
	    	   }else {
	    		   methodName = "doCreate";
	        	   contentVO = invokeDelegateMethod(delegate,methodName,new Object[]{contentVO, user});  
	    	   }
	       }
	       BeanUtils.copyProperties(actionForm, contentVO); //把更新后的值赋给form，用于web显示
	       ((BaseActionForm)actionForm).setCmdState(WebConstant.COMMAND_STRING_EDIT);
	       request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
		}catch(BusinessException e) {
        	 request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.toString());
        }catch(Exception e) {
        	throw e;
        } 
       
       return (actionMapping.findForward("content"));
	}
	
	/**
	 * 模板方法, 允许子类设置主键重复时的错误消息
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 */
	protected void onDuplicatePk(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) {
		
	}

	/**
	 * 根据voClass名称获取其Delegate类的一个实例
	 * @return
	 * @throws Exception
	 */
	protected Object getDelegate() throws Exception {
		
//		if(delegateClass!=null) return delegateClass.newInstance();
//		
//		String voClassName = voClass.getName();	
//		
//		int startIndex = voClassName.indexOf("business") + "business".length() + 1;
//		int endIndex = voClassName.substring(startIndex).indexOf(".") + startIndex;
//		String moduleName =  voClassName.substring(startIndex, endIndex);
//		
//		String voShortName = ClassUtils.getShortClassName(voClassName);
//		String caseName = voShortName.substring(0, voShortName.length() -2 );
//		String delePackName = "com.sunrise.boss.delegate." + moduleName + "." + caseName.toLowerCase();
//		String delegateClassName = delePackName + "." + caseName + "Delegate" ;
//		delegateClass = Class.forName(delegateClassName);
//		
//		return delegateClass.newInstance();
		/*
		 * add by yangxuehong 9月14日14:4:01
		 */
		if(delegateClass!=null)
			return delegateClass.newInstance();
		
		String pg = ClassUtils.getPackageName(voClass);
		String shortName = ClassUtils.getShortClassName(voClass);
		StringBuffer tmpStrBuf = new StringBuffer();
		String delegateClassName = tmpStrBuf.append(pg.substring(0,pg.length()-10).replaceFirst("business", "delegate"))
											.append(shortName.substring(0,shortName.length()-2))
											.append("Delegate")
											.toString();
		delegateClass = Class.forName(delegateClassName);
		return delegateClass.newInstance();
		/*
		 * end of add
		 */
	}

	/**
	 * 根据voClass名称获取其ListVO类的一个实例
	 * @return
	 * @throws Exception
	 */
	protected BaseListVO getListVO() throws Exception {
		String voClassName = voClass.getName();
		String listVoName = voClassName.substring(0, voClassName.length() - 2) + "ListVO";	
		Object listVO = Class.forName(listVoName).newInstance();
		return (BaseListVO)listVO;
	}
	
	protected Object invokeDelegateMethod(Object delegate,String methodName,Object[] args) throws Exception {
		try {
			return MethodUtils.invokeMethod(delegate,methodName ,args);
			
		} catch (NoSuchMethodException e) {
			
			String message = "No {0}( {1} , {2}) method found in delegate class "
							+ "{3}"
							+ ". You are required to implement it."; 
			
			String actionMethod = Locator.getCallingMethod(1);
			MessageFormat format = new MessageFormat(message);
			message = format.format( new Object[]{
										methodName
										,ClassUtils.getShortClassName(args[0].getClass())
										,"opcode"
										,ClassUtils.getShortClassName(delegate.getClass().getName())
										,actionMethod
										}
						);
			throw new RuntimeException( message );
		} catch (IllegalAccessException e) {					
				throw new RuntimeException(e.getCause());
		} catch (InvocationTargetException e) {		
			if(e.getTargetException() instanceof BusinessException)
				throw (BusinessException)e.getTargetException();
			else
				throw new RuntimeException(e.getTargetException());
		}catch(Exception e) {
			throw e;
		}
	}
}
