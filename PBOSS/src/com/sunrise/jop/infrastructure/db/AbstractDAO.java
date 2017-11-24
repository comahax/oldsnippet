package com.sunrise.jop.infrastructure.db;

import java.io.*;
import java.util.*;

import com.sunrise.jop.common.spring.*;

/**
 * AbstractDAO, ��dao��Ϊί�е������DAOʵ���࣬�Ա������������л���ͬ��OR���
 * @author He Kun (Sunrise,Guangzhou, CN)
 *
 */
public abstract class AbstractDAO implements BaseDAO {

	private Class voClass;
	private BaseDAO delegateDAO;

	public AbstractDAO(Class voClass) {
		//ί�е������DAOʵ���࣬�Ա������������л���ͬ��OR���
		this.setVoClass(voClass);
	}
	
	public AbstractDAO() {
		this(null);
	}

	/**
	 * ���巽������������ṩSessionManager�ľ���ʵ����ʵ��
	 */
	public SessionManager getSessionManager() {
		return getSessionFactoryRouter().getSessionManager(delegateDAO.getVoClass(),delegateDAO.getDbFlag());
	}
	
	public void setSessionManager(SessionManager sessionManager) {		
	}
	
	public SessionFactoryRouter getSessionFactoryRouter() {	
		return (SessionFactoryRouter)SpringContextManager.getBean(SessionFactoryRouter.class.getName());
	}
	
	public int count(Object param) throws Exception {
		return delegateDAO.count(param);
	}

	public int countByProperty(String prop, Object value) throws Exception {
		return delegateDAO.countByProperty(prop, value);
	}

	public Object create(Object vo) throws Exception {
		return delegateDAO.create(vo);
	}

	public void evict() throws Exception {
		delegateDAO.evict();
	}

	public void evict(Serializable id) throws Exception {
		delegateDAO.evict(id);
	}

	public Collection findAll() throws Exception {
		return delegateDAO.findAll();
	}

	public Object findByPk(Serializable pk) throws Exception {
		return delegateDAO.findByPk(pk);
	}

	public Object findByProperty(String prop, Object value) throws Exception {
		return delegateDAO.findByProperty(prop, value);
	}

	public Object findByUniqueKey(String uniqueKeyPropertyName, Serializable id) throws Exception {
		return delegateDAO.findByUniqueKey(uniqueKeyPropertyName, id);
	}

	public Date getCurrentTime() throws Exception {
		return delegateDAO.getCurrentTime();
	}

	public String getDbFlag() {
		return delegateDAO.getDbFlag();
	}

	public Object getMaxid(String id, String value, String prop) throws Exception {
		return delegateDAO.getMaxid(id, value, prop);
	}

	public Object getMaxValue(String prop) throws Exception {
		return delegateDAO.getMaxValue(prop);
	}

	public Object getSequence(String seqname) throws Exception {
		return delegateDAO.getSequence(seqname);
	}

	public Class getVoClass() {
		if(delegateDAO ==null)
			return this.voClass;
		else
			return delegateDAO.getVoClass();
	}

	public DataPackage query(Object param, int type) throws Exception {
		return delegateDAO.query(param, type);
	}

	public DataPackage query(Object param) throws Exception {
		return delegateDAO.query(param);
	}

	public DataPackage queryByNamedSqlQuery(String name, Object param, int type) throws Exception {
		return delegateDAO.queryByNamedSqlQuery(name, param, type);
	}

	public DataPackage queryByNamedSqlQuery(String name, Object param) throws Exception {
		return delegateDAO.queryByNamedSqlQuery(name, param);
	}

	public DataPackage queryByNamedSqlQuery(String name) throws Exception {
		return delegateDAO.queryByNamedSqlQuery(name);
	}

//	public DataPackage queryBySql(String queryString, Object param) throws Exception {
//		return delegateDAO.queryBySql(queryString, param);
//	}

//	public DataPackage queryBySql(String queryString) throws Exception {
//		return delegateDAO.queryBySql(queryString);
//	}

	public DataPackage queryCountByNamedSqlQuery(String name, Object param) throws Exception {
		return delegateDAO.queryCountByNamedSqlQuery(name, param);
	}

	public Object queryUniqueByNamedSqlQuery(String name, Object param, Class returnType) throws Exception {
		return delegateDAO.queryUniqueByNamedSqlQuery(name, param, returnType);
	}

	public Object queryUniqueByNamedSqlQuery(String name, Object param) throws Exception {
		return delegateDAO.queryUniqueByNamedSqlQuery(name, param);
	}

//	public Object queryUniqueBySql(String queryString, Object param, Class returnType) throws Exception {
//		return delegateDAO.queryUniqueBySql(queryString, param, returnType);
//	}

	public void remove(Object vo) throws Exception {
		delegateDAO.remove(vo);
	}

	public void removeByPk(Serializable pk) throws Exception {
		delegateDAO.removeByPk(pk);
	}

	public void setDbFlag(String dbFlag) {
		delegateDAO.setDbFlag(dbFlag);
	}

	public void setVoClass(Class voClass) {
		if(delegateDAO == null)
			this.voClass = voClass;
		else
			delegateDAO.setVoClass(voClass);
	}

	public DataPackage unionQuery(Object[] param, Class[] vo, String[][] joins, int type) throws Exception {
		return delegateDAO.unionQuery(param, vo, joins, type);
	}

	public DataPackage unionQuery(Object[] param, Class[] vo, String[][] joins) throws Exception {
		return delegateDAO.unionQuery(param, vo, joins);
	}

	public Object update(Object vo) throws Exception {
		return delegateDAO.update(vo);
	}
	
	public Object saveOrUpdate(Object vo) throws Exception {
		return delegateDAO.saveOrUpdate(vo);
	}

	public DataPackage queryBySql(String queryString) throws Exception {
		return delegateDAO.queryBySql(queryString);
	}
	
	public DataPackage queryBySql(String queryString, Object params) throws Exception {
		return delegateDAO.queryBySql(queryString,params);
	}
	
	public DataPackage queryBySql(String queryString, Object params, int type)	throws Exception{
		return delegateDAO.queryBySql(queryString,params,type);
	}
	
	public String querySumByNamedSql(String name, Object params) throws Exception {
		return delegateDAO.querySumByNamedSql(name,params);
	}
	
	public String querySumBySql(String queryString, Object params)	throws Exception{
		return delegateDAO.querySumBySql(queryString,params);
	}
	
	public Object queryUniqueBySql(String queryString, Object param, Class returnType) throws Exception {
		return delegateDAO.queryUniqueBySql(queryString, param, returnType);
	}
	
	public Object queryUniqueBySql(String queryString, Object param, Class returnType, String queryName) throws Exception {
		return delegateDAO.queryUniqueBySql(queryString, param, returnType,queryName);		
	}
	
	public BaseDAO getDelegateDAO() {
		return delegateDAO;
	}

	public void setDelegateDAO(BaseDAO delegateDAO) {
		this.delegateDAO = delegateDAO;
		this.delegateDAO.setVoClass(this.voClass);
	}
}
