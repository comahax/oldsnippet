/**
 * @author He Kun (Henry He), Guangzhou, China
 * 2006-9-18
 */
package com.sunrise.boss.common.base.db;

import java.beans.*;
import java.io.*;
import java.lang.reflect.*;

import org.apache.commons.beanutils.*;
import org.apache.commons.logging.*;
import org.hibernate.*;

import com.sunrise.boss.business.common.dblog.*;
import com.sunrise.boss.business.common.managelog.persistent.*;
import com.sunrise.boss.ui.commons.*;
import com.sunrise.pub.tools.*;

/**
 * BaseLogDAO
 * <br> Description: ��create ,update, remove �Ǽǹ�����־�������־. 
 * 
 * <br> Company: Sunrise,Guangzhou</br>
 * @author He Kun
 * @since 1.0
 * @version 1.0
 * 2006-9-18
 */
public class BaseLogDAO extends BaseDAO {
	
	private static final Log log = LogFactory.getLog(BaseLogDAO.class);
	
	private User user;
	/**
	 * @param voClass
	 */
	public BaseLogDAO(Class voClass) {
		super(voClass);		
	}

	/**
	 * @param voClass
	 * @param dbFlag
	 */
	public BaseLogDAO(Class voClass, String dbFlag) {
		super(voClass, dbFlag);		
	}
	
	public BaseLogDAO(Class voClass, User user) {
		super(voClass);	
		this.user = user;		
	}
	
	public Object create(Object vo) throws Exception 
	{
		Object retVO = null;
		try {
			retVO = super.create(vo);
			
			registerLog("create", retVO, user);			
		}catch (HibernateException ex) {
            /**
             * һ����˵��Hibernate�����쳣ʱ����HibernateException��װ֮���׳���
             * ���ﳢ�Խ⿪HibernateException�İ�װ����ʾ�����Ĵ���ԭ��
             */
            if (ex.getCause() != null) {
                throw new Exception(ex.getCause());
            }
            else {
                throw ex;
            }
        }
        return retVO;
	}
	
	public Object update(Object vo) throws Exception 
	{
		Object retVO = null;
		try {
			retVO = super.update(vo);
			
			registerLog("update", retVO, user);	
		} catch (HibernateException ex) {
            /**
             * һ����˵��Hibernate�����쳣ʱ����HibernateException��װ֮���׳���
             * ���ﳢ�Խ⿪HibernateException�İ�װ����ʾ�����Ĵ���ԭ��
             */
            if (ex.getCause() != null) {
                throw new Exception(ex.getCause());
            }
            else {
                throw ex;
            }
        }
        return retVO;
	}
	
	public void removeByPk(Serializable pk) throws Exception {
		Object obj = super.findByPk(pk);
		remove(obj);
	}
	
	public void remove(Object vo) throws Exception 
	{		
		try {
			super.remove(vo);
			
			registerLog("remove", vo, user);
			
		}catch (HibernateException ex) {
            /**
             * һ����˵��Hibernate�����쳣ʱ����HibernateException��װ֮���׳���
             * ���ﳢ�Խ⿪HibernateException�İ�װ����ʾ�����Ĵ���ԭ��
             */
            if (ex.getCause() != null) {
                throw new Exception(ex.getCause());
            }
            else {
                throw ex;
            }
        }
	}
	
	private void registerLog(String methodName, Object vo ,User user) throws Exception {				
		Class voClass = vo.getClass();
		
		if(vo instanceof ManageLog) {
			if(log.isDebugEnabled()) log.debug("create managelog for " + voClass.getName());
			
			registerManangeLog(methodName,vo,user);
		}
		
		if(vo instanceof OperationLog) {
			if(log.isDebugEnabled()) log.debug("create operationlog for " + voClass.getName());
			
			OperationLog operationLog = (OperationLog)vo;
			Class logVOClass = operationLog.logVOClass();
			if(log.isDebugEnabled()) log.debug("logVOClass " + logVOClass.getName());	
			
			Object logvo = logVOClass.newInstance();
			registerOperationLog(methodName, vo, logvo,user);
		}		
	}
	
	/**
	 * �Ǽǹ�����־
	 * @param method
	 * @param vo
	 * @param user
	 */
	private void registerManangeLog(String method,Object vo,User user) {
		if(log.isDebugEnabled()) log.debug("methodName " + method);		
		if(log.isDebugEnabled()) log.debug("user  " + user);
		if("create".equals(method)) 
			manageLogCreate(vo,user);
		if("remove".equals(method)) 
			manageLogRemove(vo,user);
		if("update".equals(method))
			manageLogUpdate(vo,user);
	}
	
	protected void manageLogCreate(Object vo,User user) {
		ManageLogDAO mdao = new ManageLogDAO();
		mdao.setDbFlag(user.getCityid());
		String oprType = OperAction.INSERT;
		try {
			mdao.manageLog(user, vo.getClass().getName(), oprType, null, vo, OperState.SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void manageLogRemove(Object vo,User user) {
		ManageLogDAO mdao = new ManageLogDAO();
		mdao.setDbFlag(user.getCityid());
		String oprType = OperAction.DELETE;
		try {
			mdao.manageLog(user, vo.getClass().getName(), oprType, null, vo, OperState.SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void manageLogUpdate(Object vo,User user) {
		ManageLogDAO mdao = new ManageLogDAO();
		mdao.setDbFlag(user.getCityid());
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
			if(log.isDebugEnabled()) log.debug("methodName " + method);		
			if(log.isDebugEnabled()) log.debug("user  " + user);
			
			logvo = setLogProperties(logvo, method,user);			
			BeanUtils.copyProperties(logvo, vo);
			
			BaseDAO dao = new BaseDAO(logvo.getClass(), user.getCityid());
			dao.create( logvo );
			
		} catch (Exception e) {		
			if(log.isWarnEnabled()) log.warn("Operation log can't be created. vo class " + vo.getClass().getName(), e );
		}
	}
	
	/**
	 * ����־�Ĺ������Խ�������
	 * ����setLogProperties������ԭ��Ϊprivate�����ڱ��Ϊprotected�� add by yangxuehong 2006��9��23��
	 */
	protected Object setLogProperties(Object obj, String methodName,User user) throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException, SequenceException {
		
		Serializable s = (Serializable)obj;
		
		PropertyDescriptor optimePty = PropertyUtils.getPropertyDescriptor(s, "optime");
		java.util.Date optimeValue = new java.util.Date();
		String optimeString = PublicUtils.formatUtilDate(optimeValue, "yyyy-MM-dd HH:mm:ss");
		
		if(optimePty!=null) {
			Class optimeType = optimePty.getPropertyType();
			if(java.sql.Date.class.isAssignableFrom(optimeType)) {
				optimeValue = new java.sql.Date(System.currentTimeMillis());
				optimeString = PublicUtils.formatUtilDate(optimeValue, "yyyy-MM-dd");
			}else if(java.sql.Timestamp.class.isAssignableFrom(optimeType)) {
				optimeValue = new java.sql.Timestamp(System.currentTimeMillis());
				optimeString = PublicUtils.formatUtilDate(optimeValue, "yyyy-MM-dd HH:mm:ss");
			}
				
		}
		
		BeanUtils.setProperty( s, "optime",optimeString);	
		BeanUtils.setProperty( s, "oprtype", methodName);	
		BeanUtils.setProperty(s, "oprcode",user.getOpercode());	
		BeanUtils.setProperty(s, "success", OperState.SUCCESS);
		
		//���ӶԷ������ֲ�������(OPRCHANNEL)����־��¼,added by yjr(2007-01-05)
		if (BeanUtils.describe(s).containsKey("oprchannel")){
			BeanUtils.setProperty(s, "oprchannel", user.getWayid());//��ԭ���Ĺ��Ÿĳ����� added by yangxuehong
		}
		return s;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
		this.setDbFlag(user.getCityid());
	}
}
