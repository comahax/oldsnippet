package com.sunrise.boss.common.base.db;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sunrise.boss.ui.commons.User;

/**
 * 
 * <p>
 * Title: DAOFactory
 * </p>
 * 
 * <p>
 * Description:DAO����, ����ί�е�DAOʵ��.
 * ʹ�� build(Class daoClazz,User user) �����DAOʵ��, �����create,update,remove�����Զ����ɹ�����־�������־.
 * <br> ����, ��ӦVO����ʵ�� ManageLog �ӿ�,���� OperationLog �ӿ�. 
 * </p>
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * 
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author J, He Kun 
 * @version 1.0
 */
public class DAOFactory {
	
	private static final Log log = LogFactory.getLog(DAOFactory.class);
	
	private static final ThreadLocal threadUser = new ThreadLocal();
	
	/**
	 * ����ί�е�DAOʵ��
	 * @param daoClazz
	 * @param dbFlag
	 * @return
	 */
	public static BaseDAO build(Class daoClazz, String dbFlag) {

		/**
		 * @todo ����dbFlag���ж����ĸ����ݿ�
		 */
		return buildDAO(daoClazz, dbFlag);

	}
	
	/**
	 * ����ί�е�DAOʵ��
	 * @param daoClazz
	 * @param user
	 * @return
	 */
	public static BaseDAO build(Class daoClazz,User user) {

		/**
		 * @todo ����dbFlag���ж����ĸ����ݿ�
		 */
		return buildDAO(daoClazz, user);

	}	
	
	/**
	 * buildDAO
	 * @param daoClazz
	 * @param dbFlag
	 * @return
	 */
	private static BaseDAO buildDAO(Class daoClazz, String dbFlag) {
		try {
			Object dao = daoClazz.newInstance();
			if(dao instanceof BaseDAO) {
				BaseDAO logDAO = (BaseDAO)dao;
				logDAO.setDbFlag(dbFlag);
			}
			return (BaseDAO)dao;
			
		} catch (Exception e) {	
			if(log.isErrorEnabled()) log.error(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static BaseDAO buildDAO(Class daoClazz, User user) {
		
		try {
			Object dao = daoClazz.newInstance();
			if(dao instanceof BaseLogDAO) {
				BaseLogDAO logDAO = (BaseLogDAO)dao;
				logDAO.setUser(user);
			}else{
				((BaseDAO)dao).setDbFlag(user.getCityid());
			}
			return (BaseDAO)dao;
			
		} catch (Exception e) {	
			if(log.isErrorEnabled()) log.error(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static User getUser() {
		User user = (User)threadUser.get();
		if(log.isDebugEnabled()) log.debug("get dao user " + user );
		return user;
	}
}
