package com.sunrise.jop.infrastructure.db;

import org.apache.commons.lang.StringUtils;
import org.hibernate.SessionFactory;

import com.sunrise.jop.common.persistent.CommonDAO;
import com.sunrise.jop.common.spring.SpringContextManager;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.config.CoreConfigInfo;
import com.sunrise.jop.infrastructure.db.hibernate3.Hibernate3SessionManager;


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
 * @version 1.1 He Kun �����ع�����Spring��������DAOʵ����
 */
public class DAOFactory {	
	/**
	 * ����DAOʵ��
	 * @param daoClazz
	 * @param param
	 * @return
	 */
	public static BaseDAO build(Class daoClazz, DBAccessUser user) {
		return build(daoClazz, null, user);		
	}
	
	/**
	 * ���� CommonDAO ��ʵ��
	 * @param voClass
	 * @param user
	 * @return
	 */
	public static BaseDAO buildCommonDAO(Class voClass, DBAccessUser user) {
		return build(CommonDAO.class, voClass, user);
	}
	
	/**
	 * ����Spring bean�����ķ�ʽ���쵽ʵ�����Ա�Ϊdao�������湦�ܡ����������� applicationContext.xml��
	 * @param daoClazz
	 * @param user
	 * @return
	 */
	public static BaseDAO build(Class daoClazz, Class voClass, DBAccessUser user) {
		return build(daoClazz, voClass, user.getCityid());
	}	

	
	/**
	 * ����daoʵ����
	 * @param daoClazz
	 * @param dbFlag ����Դ��ʶ
	 * @return
	 */
	public static BaseDAO build(Class daoClazz, String dbFlag) {
		return build(daoClazz, null, dbFlag);
	}
	
	/**
	 * ���� CommonDAO ��ʵ��
	 * @param voClass
	 * @param dbFlag ����Դ��ʶ
	 * @return
	 */
	public static BaseDAO buildCommonDAO(Class voClass, String dbFlag) {
		return build(CommonDAO.class, voClass, dbFlag);
	}

	/**
	 * ����Spring bean�����ķ�ʽ���쵽ʵ�����Ա�Ϊdao�������湦�ܡ����������� applicationContext.xml��
	 * @param daoClazz
	 * @param voClass
	 * @param dbFlag
	 * @return
	 */
	public static BaseDAO build(Class daoClazz, Class voClass, String dbFlag) {
		AbstractDAO dao = null;
		try {
			SpringContextManager.registerBean(daoClazz.getName(), daoClazz);
			dao = (AbstractDAO)SpringContextManager.getBean(daoClazz.getName());
			
			Hibernate3SessionManager sessionManager = new Hibernate3SessionManager();
			
			if(dao.getVoClass()==null) {
				if(voClass==null)
					throw new IllegalArgumentException("voClass is empty when build DAO " + daoClazz.getName());
				else
					dao.setVoClass(voClass);
			}
			
			if( StringUtils.isBlank(dbFlag)) {
				throw new IllegalArgumentException("dbFlag( user.cityid ) is missing!" );
			}
			
			String dbName = dbFlag.startsWith("DB_")? dbFlag : "DB_" + dbFlag;
			SessionFactory sf ;
			if(SpringContextManager.containsBean(SpringContextManager.HIBERNATE_SESSION_FACTORY_NAME)){
				// �Ƕ���Ӫҵ����
				sf = (SessionFactory) SpringContextManager.getBean(SpringContextManager.HIBERNATE_SESSION_FACTORY_NAME );
			}else if(SpringContextManager.containsBean(SpringContextManager.HIBERNATE_SESSION_FACTORY_NAME + "_" + dbName)) {
				// ����Ӫҵ����
				sf = (SessionFactory) SpringContextManager.getBean(SpringContextManager.HIBERNATE_SESSION_FACTORY_NAME + "_" + dbName);
			}else {
				throw new JOPException("δ���õ���["+dbFlag+"]"+"�����ݿ����Ӳ���!");
			}
			
			if(sf.getClassMetadata(dao.getVoClass()) == null) {
				if(CoreConfigInfo.COMMON_DB_NAME.equals(dbFlag)) {
					throw new JOPException("��������δ�ҵ��ñ�["+dao.getVoClass().getName()+"],����hibernate_comm.cfg.xml����!");
				}else {
					sf = (SessionFactory) SpringContextManager.getBean(SpringContextManager.HIBERNATE_SESSION_FACTORY_NAME + "_" + CoreConfigInfo.COMMON_DB_NAME);
					if(sf.getClassMetadata(dao.getVoClass()) == null) {
						throw new JOPException("������͵��пⶼδ�ҵ��ñ�["+dao.getVoClass().getName()+"],����hibernate_comm.cfg.xml��hibernate.cfg.xml����!");
					}
				}
			}
			sessionManager.setSessionFactory(sf);
			BaseDAO delegateDAO = sessionManager.newDAO();
			//Ҫ������ί��dao���������������ԡ�
			
			dao.setDelegateDAO(delegateDAO);
			
			dao.setDbFlag(dbFlag); //����user�� ҵ��bean��Ҫ	
			if(dao.getVoClass()==null) {
				if(voClass == null) 
					throw new NullPointerException("voClass is required! But it's null! Perhaps you don't set voClass property to commonControl object!");
				else
					dao.setVoClass(voClass);
			}
		} catch (Exception e) {	
			throw new JOPException("Can't build dao of " + daoClazz.getName()+", cause:" + e.getMessage(),e);
		}
		return  dao;	
	}	
}
