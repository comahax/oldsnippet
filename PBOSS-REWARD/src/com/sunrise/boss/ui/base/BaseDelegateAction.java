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
 * <br> Description: ������ί�и������Delegate��,������CommonDelegate,�Ա�֤����ҵ�񷽷�.
 * <br> Company: Sunrise,Guangzhou</br>
 * @author He Kun
 * @since 1.0
 * @version 1.0
 * 2006-9-4
 */
public class BaseDelegateAction extends BaseAction {
	
	protected Class delegateClass;
	/**
	 * ��ѯ
	 */
	protected ActionForward doList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
//	    Page.setPageSize(request, (BaseActionForm) actionForm);        
               
        try {
        	Page.setPageSize(request, (BaseActionForm) actionForm);        	
        	BaseListVO listVO = getListVO(); 
        	setListVO(listVO, actionForm); //���ú�listVO����Ϊ��ѯ����
        	
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
	 * ɾ��.
	 */
	protected ActionForward doDelete(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
		try {
			   Object delegate = getDelegate();		
		
			   String findByPK = "doFindByPk";
			   String methodName = "doRemove";
			   
			   for (int i = 0; i < selectArray.length; i++) {
				   Object vo = null;
		            if (selectArray[0].indexOf('|') == -1) { //��һ����
		            	vo = invokeDelegateMethod(delegate,findByPK,new Object[]{getDeletePK(selectArray[i]), user});
		            } else { //��������
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
	 * ������������һ��VOʵ��. 
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
	 * ����request�е�pk������ѯһ��vo��ʵ��
	 */
	protected Object getContentVO(HttpServletRequest request, User user) throws Exception {
		String pk = null;
        String parameter = request.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
        //list.jsp��ת���������
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
	
	//doEdit, doView ����Ҫ��д, ֻ��д getContentVO(HttpServletRequest request, User user) ����
	
	/**
	 * ����
	 */
	protected ActionForward doSave(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		
		
	   Object contentVO = voClass.newInstance();
       setSaveVO(contentVO, actionForm); //�ڴ˸�ʽ������� vo �Ա���
       
       //if(pkNameArray.length > 1)
       //   throw new RuntimeException("Multiple pk not supported by default doSave. Try to implement this method.");
       
       //Object pk = PropertyUtils.getProperty(contentVO, pkNameArray[0]);
       Object delegate = getDelegate();
       String methodName = "doFindByPk";
       
       Object existObj = null;
       
   	    if(pkNameArray.length==1){ //��һ����
		   Object pk = (Object)BeanUtils.getProperty(contentVO, pkNameArray[0]);
		   if(pk!=null){
			   existObj = invokeDelegateMethod(delegate,methodName,new Object[]{(Serializable)pk, user});
		   }
	      }else{//��������
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
	           		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "��ͬ��¼�Ѵ���"); 
	           		onDuplicatePk(actionMapping,actionForm, request, response, user);
	           		return (actionMapping.findForward("content"));
	    	   }else {
	    		   methodName = "doCreate";
	        	   contentVO = invokeDelegateMethod(delegate,methodName,new Object[]{contentVO, user});  
	    	   }
	       }
	       BeanUtils.copyProperties(actionForm, contentVO); //�Ѹ��º��ֵ����form������web��ʾ
	       ((BaseActionForm)actionForm).setCmdState(WebConstant.COMMAND_STRING_EDIT);
	       request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
		}catch(BusinessException e) {
        	 request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.toString());
        }catch(Exception e) {
        	throw e;
        } 
       
       return (actionMapping.findForward("content"));
	}
	
	/**
	 * ģ�巽��, �����������������ظ�ʱ�Ĵ�����Ϣ
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 */
	protected void onDuplicatePk(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) {
		
	}

	/**
	 * ����voClass���ƻ�ȡ��Delegate���һ��ʵ��
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
		 * add by yangxuehong 9��14��14:4:01
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
	 * ����voClass���ƻ�ȡ��ListVO���һ��ʵ��
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
