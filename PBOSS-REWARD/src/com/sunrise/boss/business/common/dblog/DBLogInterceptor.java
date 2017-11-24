package com.sunrise.boss.business.common.dblog;

import java.beans.*;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.beanutils.*;
import org.apache.commons.logging.*;
import org.hibernate.criterion.*;

import com.sunrise.boss.business.common.managelog.persistent.*;
import com.sunrise.boss.common.base.db.*;
import com.sunrise.boss.common.dproxy.*;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.ui.commons.*;
import com.sunrise.pub.tools.SequenceException;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * <p>Title: DBLogInterceptor</p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
public class DBLogInterceptor extends AbstractInterceptor {
	
	private static final Log log = LogFactory.getLog(DBLogInterceptor.class);
	/**
	 * ʵ��After���ش���, ������־����.
	 */
	public void after(InvokeInfo info) throws Throwable {
		registerLog(info.getMethod(),info.getArgs());
	}

	/**
	 * �Ǽ���־
	 * @param method
	 * @param objs
	 * @throws Exception
	 */
	private void registerLog(Method method, Object[] objs) throws Exception {
		
		String methodName = method.getName();
		if (checkMethodName( methodName ) && isVO(objs[0])) {
			if(log.isDebugEnabled()) log.debug("methodName " + methodName);
			Object vo = objs[0];
			User user = DAOFactory.getUser();
			
			if(log.isDebugEnabled()) log.debug("user  " + user);
			
			Class voClass = objs[0].getClass();
			
			if(ManageLog.class.isAssignableFrom(voClass)) {
				if(log.isDebugEnabled()) log.debug("create managelog for " + voClass.getName());
				
				registerManangeLog(methodName,vo,user);
			}
			
			if(OperationLog.class.isAssignableFrom(voClass)) {
				if(log.isDebugEnabled()) log.debug("create operationlog for " + voClass.getName());
				
				OperationLog operationLog = (OperationLog)vo;
				Class logVOClass = operationLog.logVOClass();
				if(log.isDebugEnabled()) log.debug("logVOClass " + logVOClass.getName());	
				
				Object logvo = logVOClass.newInstance();
				registerOperationLog(methodName, vo, logvo,user);
			}
		}	
	}
	
	/**
	 * ע�������־
	 * @param method
	 * @param vo
	 * @param user
	 */
	private void registerManangeLog(String method,Object vo,User user) {
		if("create".equals(method)) 
			manageLogCreate(vo,user);
		if("remove".equals(method)) 
			manageLogRemove(vo,user);
		if("update".equals(method))
			manageLogUpdate(vo,user);
	}
	
	protected void manageLogCreate(Object vo,User user) {
		ManageLogDAO mdao = (ManageLogDAO)DAOFactory.build(ManageLogDAO.class, user);
		String oprType = OperAction.INSERT;
		try {
			mdao.manageLog(user, vo.getClass().getName(), oprType, null, vo, OperState.SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void manageLogRemove(Object vo,User user) {
		ManageLogDAO mdao = (ManageLogDAO)DAOFactory.build(ManageLogDAO.class, user);
		String oprType = OperAction.DELETE;
		try {
			mdao.manageLog(user, vo.getClass().getName(), oprType, null, vo, OperState.SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void manageLogUpdate(Object vo,User user) {
		ManageLogDAO mdao = (ManageLogDAO)DAOFactory.build(ManageLogDAO.class, user);
		String oprType = OperAction.UPDATE;
		try {
			//TODO: ������������, ��ʱ��������ȡ oldObject. 
			//BaseDAO baseDAO = new BaseDAO(vo.getClass());
			//Object oldVO = baseDAO.findByPk((Serializable)vo);
			Object oldVO = null;
			mdao.manageLog(user, vo.getClass().getName(), oprType, oldVO, vo, OperState.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �Ǽǲ�����־.
	 * @param method
	 * @param vo
	 * @param logvo
	 * @param user
	 */
	protected void registerOperationLog(String method,Object vo,Object logvo, User user) {		
		try {
			logvo = setLogProperties(logvo, method,user);			
			BeanUtils.copyProperties(logvo, vo);

//			BaseDAO dao = new BaseDAO(logvo.getClass(), user.getCityid());
			//change by liwenjing 
			BaseDAO dao=DAOFactory.build(logvo.getClass(), user.getCityid());
			dao.create( logvo );
			
		} catch (Exception e) {		
			if(log.isWarnEnabled()) log.warn("Operation log can't be created. vo class " + vo.getClass().getName(), e );
		}
	}
	
	/**
	 * ����ʧ��ʱ�ȼ�ʧ����־
	 */
	public void exceptionThrow(InvokeInfo info) throws Throwable {
		String methodName = info.getMethod().getName();
		Object vo = info.getArgs()[0];
		
		if (checkMethodName( methodName ) && isVO( vo )) {
			if(log.isDebugEnabled()) log.debug("Fail log " + info.getArgs()[0]);
		}
		super.exceptionThrow(info);
	}
	
	private String getOprtypeByMethod(String method) {
		if("create".equals(method)) return OperAction.INSERT;
		if("remove".equals(method)) return OperAction.DELETE;
		if("update".equals(method)) return OperAction.UPDATE;
		return "UNKOWN OP";
	}
//	/**
//	 * ����ӳ�����������
//	 */
//	private void copyProperties(Object dest, Object orig, HashMap map)
//			throws NoSuchMethodException, InvocationTargetException,
//			IllegalAccessException {
//
//		Map props = BeanUtils.describe(orig);
//
//		for (Iterator iter = props.keySet().iterator(); iter.hasNext();) {
//			String key = (String) iter.next();
//			Object value = props.get(key);
//
//			Object obj = map.get(key);
//			if (obj != null) {
//				String mapvalue = (String) obj;
//				BeanUtils.setProperty((Serializable) dest, mapvalue, value);
//			}
//		}
//	}

	/**
	 * ����־�Ĺ������Խ�������
	 */
	private Object setLogProperties(Object obj, String methodName,User user) throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException, SequenceException {
		
		Serializable s = (Serializable)obj;
		
		PropertyDescriptor optimePty = PropertyUtils.getPropertyDescriptor(s, "optime");
		java.util.Date optimeValue = new java.util.Date();
		if(optimePty!=null) {
			Class optimeType = optimePty.getPropertyType();
			if(java.sql.Date.class.isAssignableFrom(optimeType)) 
				optimeValue = new java.sql.Date(System.currentTimeMillis());
			else if(java.sql.Timestamp.class.isAssignableFrom(optimeType))
				optimeValue = new java.sql.Timestamp(System.currentTimeMillis());
		}
		BeanUtils.setProperty( s, "optime",optimeValue);	
		BeanUtils.setProperty( s, "oprtype", methodName);	
		BeanUtils.setProperty(s, "oprcode",user.getOpercode());	
		BeanUtils.setProperty(s, "success", OperState.SUCCESS);
		return s;
	}

	/**
	 * ��鷽����,��������ɾ���ĲŶ���־�����
	 */
	private boolean checkMethodName(String mName) {
		boolean result = false;

		if (mName.equalsIgnoreCase("create")
				|| mName.equalsIgnoreCase("update")
				|| mName.equalsIgnoreCase("remove")) {
			result = true;
		}
		return result;
	}

	/**
	 * ����Ƿ�ΪVO,ĿǰΪ���ж�
	 */
	private boolean isVO(Object obj) {
		boolean result = false;

		if (obj.getClass().getName().endsWith("VO")) {
			result = true;
		}
		return result;
	}

}
