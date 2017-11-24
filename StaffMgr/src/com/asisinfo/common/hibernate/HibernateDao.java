package com.asisinfo.common.hibernate;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.asisinfo.common.utils.ReflectionUtils;
import com.asisinfo.common.pager.IPage;


/**
 * hibernate dao����,����pageHibernateTemplateʵ���˳��õ���ݿ����,ҵ��DaoӦ�ü̳и���.
 * HibernateDaoʵ���˷���Dao�ӿ��е�����ͨ�õķ��ͷ���,ͬʱ�������˶��ڸ߼���ѯ������sql��ѯ/ִ�еȳ�����ݿ������֧��
 * @param <T> ���Ͳ���
 * @author johnson_hong
 * @see PageHibernateTemplate
 * @see Dao
 */

public class HibernateDao<T>{
	
	protected Logger logger = LoggerFactory.getLogger(getClass());

	protected Class<T> entityClass;
	
	protected SessionFactory sessionFactory;
	
	/**
	 * �õ�Daoʹ�õ�sessionFactory����
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * ����Daoʹ�õ�sessionFactory����
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public HibernateDao(){
		this.entityClass = ReflectionUtils.getSuperClassGenricType(getClass());
	}
	
	private PageHibernateTemplate pageHibernateTemplate;
	
	public PageHibernateTemplate getPageHibernateTemplate() {
		if (pageHibernateTemplate==null){
			pageHibernateTemplate = new PageHibernateTemplate(getSessionFactory());
		}
		return pageHibernateTemplate;
	}

	/**
	 * ����һ��ʵ�������ݿ�,T����Ϊhibernateʵ��
	 * @param entity ��Ҫ�����ʵ��
	 */
	public void save(T entity){
		getPageHibernateTemplate().save(entity);
	}
	
	/**
	 * ɾ��һ��ʵ�����,�����󲻴��ڻ��׳�����ʱ�쳣��T����Ϊhibernateʵ��
	 * @param entity �־û�״̬��ʵ�����
	 */
	public void delete(T entity){
		getPageHibernateTemplate().delete(entity);
	}
	
	/**
	 * ͨ��idɾ�����,���������ɷ���dao�е����Ͳ���T������T����Ϊhibernateʵ��
	 * @param id ��Ҫɾ��Ķ����id
	 * @throws ObjectNotFoundException �����󲻴��ڻ��׳��쳣
	 */
	public void delete(Serializable id){
		Object entity = getPageHibernateTemplate().get(entityClass, id);
		if(entity==null)
			throw new ObjectNotFoundException(id, entityClass.getName());
		getPageHibernateTemplate().delete(entity);
	}
	
	/**
	 * ����һ��ʵ�����,T����Ϊhibernateʵ��
	 * @param entity
	 */
	public void update(T entity){
		getPageHibernateTemplate().update(entity);
	}
	
	/**
	 * �õ�ָ��id��ʵ�����
	 * @param Class ��������
	 * @param id
	 * @return Object���͵�ʵ���������Ҳ����򷵻�null
	 */
	public Object get(Class entityClass,Serializable id){
		return getPageHibernateTemplate().get(entityClass, id);
	}
	
	/**
	 * �õ�ָ��id��ʵ�����,T����Ϊhibernateʵ��
	 * @param id
	 * @return T���͵�ʵ���������Ҳ����򷵻�null
	 */
	public T get(Serializable id){
		return (T)getPageHibernateTemplate().get(entityClass, id);
	}
	
	/**
	 * ����hibernate��hql,���з�ҳ��ѯ�������Զ���һ��<tt>QueryOption</tt>���͵Ĳ�ѯѡ��
	 * @param hql hql�в��������?ռλ,Ҳ������ :key����ʽ��ʾ
	 * @param params ��ѯ����, ����object[]���͵Ĳ���(��Ӧ?ռλ��hql),�Լ�Map���͵Ĳ���(��Ӧ:keyռλ��hql)
	 * @param queryOption ��ѯѡ��
	 * @return ��װ��ݺͷ�ҳ��Ϣ��IPage����
	 * @see QueryOption
	 * @see IPage
	 */
	public IPage queryPage(String hql,Object params,
			QueryOption queryOption) {
		return getPageHibernateTemplate().queryPage(hql, params, queryOption);
	}

	/**
	 * ����һ������sql,���з�ҳ��ѯ�������Զ���һ��<tt>QueryOption</tt>���͵Ĳ�ѯѡ��
	 * @param nativeSql ����һ������sql,������?ռλ��,Ҳ������ :key����ʽ��ʾ
	 * @param resultClass ָ�����صļ�¼���ͣ�����֧�ֻ�������ͣ���׼javabean���ͣ�Map(ָ��MapĬ��ʵ��ΪHashMap)����HashMap,linkHashMap���ͣ�
	 * ���ò���ָ�����򷵻ؽ���е�һ����¼����ʾΪObject[]
	 * @param param ��ѯ����, ����object[]���͵Ĳ���(��Ӧ?ռλ��sql),�Լ�Map���͵Ĳ���(��Ӧ:keyռλ��sql)
	 * @param queryOption ��ѯѡ��
	 * @return ��װ��ݺͷ�ҳ��Ϣ��IPage����
	 * @see QueryOption
	 * @see IPage
	 */
	public IPage queryPageBySql(String nativeSql,Class resultClass,Object param,
			QueryOption queryOption) {
		return getPageHibernateTemplate().queryPageBySql(nativeSql, resultClass, param, queryOption);
	}
	
	/**
	 * ��ibatis�л�ȡָ��id��sql�����з�ҳ��ѯ
	 * @param sqlName  ��Ӧibatis�����ļ���sql��id
	 * @param resultClass ָ�����صļ�¼���ͣ�����֧�ֻ��������ͣ���׼��javabean���ͣ�Map(ָ��MapĬ��ʵ��ΪHashMap)����HashMap,LinkHashMap����
	 * ���ò���ָ�����򷵻ؽ���е�һ����¼�ᱻ��ʾΪObject[]
	 * @param param ��ѯ�������Map���͵ĵĲ���(Ҳ�����������ibatis֧�ֵ����������Ϊ����)����Ҫ����ibatis�����������ļ������ö�Ӧ��sql
	 * @param queryOption ��ѯѡ��
	 * @return ��װ��ݺͷ�ҳ��Ϣ��IPage����
	 * @see QueryOption
	 * @see IPage
	 */
	public IPage queryPageBySqlName(String sqlName,Class resultClass, Object param,
			QueryOption queryOption) {
		return getPageHibernateTemplate().queryPageBySqlName(sqlName, resultClass, param, queryOption);
	}
	
	/**
	 * ���ָ����sql,��ѯ����Ӧ�����м�¼�����ҽ���¼ת��Ϊָ��������
	 * @param nativeSql ����һ������sql,������?ռλ��,Ҳ������ :key����ʽ��ʾ
	 * @param resultClass ָ�����صļ�¼����
	 * @param param ��ѯ����
	 * @return sql��Ӧ�����м�¼�������List�ķ�ʽһ���Է���
	 * @see HibernateDao#queryPageBySql(String, Class, Object, QueryOption)
	 */
	public List queryListBySql(String nativeSql, Class resultClass, Object param){
		return getPageHibernateTemplate().queryListBySql(nativeSql, resultClass, param);
	}
	
	/** ��ibatis�л�ȡָ��id��sql,����ѯ����Ӧ�����м�¼
	 * @param sqlName ��Ӧibatis�����ļ���sql��id
	 * @param resultClass  ָ�����صļ�¼���ͣ�����֧�ֻ��������ͣ���׼��javabean���ͣ�Map(ָ��MapĬ��ʵ��ΪHashMap)����HashMap,LinkHashMap����
	 * ���ò���ָ�����򷵻ؽ���е�һ����¼�ᱻ��ʾΪObject[]
	 * @param param ��ѯ����
	 * @return ������������м�¼�������List�ķ�ʽһ���Է���
	 * @see HibernateDao#queryPageBySqlName(String, Class, Object, QueryOption)
	 */
	public List queryListBySqlName(String sqlName, Class resultClass, Object param){
		return getPageHibernateTemplate().queryListBySqlName(sqlName, resultClass, param);
	}
	
	/**
	 * ִ��һ��hql������ݿ����<code>INSERT</code>, 
     * <code>UPDATE</code>, <code>DELETE</code>����
	 * @param hql hql�в��������?ռλ,Ҳ������ :key����ʽ��ʾ
	 * @param params �������, ����object[]���͵Ĳ���(��Ӧ?ռλ��hql),�Լ�Map���͵Ĳ���(��Ӧ:keyռλ��hql)
	 * @return ��Ӱ��ļ�¼��
	 */
	public int execute(String hql,Object params){
		return getPageHibernateTemplate().execute(hql, params);
	}
	
	/**
	 * ִ��һ������sql������ݿ����<code>INSERT</code>, 
     * <code>UPDATE</code>, <code>DELETE</code>����
	 * @param nativeSql ����һ������sql,������?ռλ��,Ҳ������ :key����ʽ��ʾ
	 * @param params ����object[]���͵Ĳ���(��Ӧ?ռλ��sql),�Լ�Map���͵Ĳ���(��Ӧ:keyռλ��sql)
	 * @return ��Ӱ��ļ�¼��
	 */
	public int executeBySql(String nativeSql, Object params){
		return getPageHibernateTemplate().executeBySql(nativeSql, params);
	}
	
	public int executeBySql(String nativeSql, Object[] params,String[] types){
		return getPageHibernateTemplate().executeBySql(nativeSql, params,types);
	}
	
	/**
	 * @param sqlName ��Ӧibatis�����ļ���sql��id
	 * @param param ��ѯ�������Map���͵ĵĲ���(Ҳ�����������ibatis֧�ֵ����������Ϊ����)����Ҫ����ibatis�����������ļ������ö�Ӧ��sql
	 * @return ��Ӱ��ļ�¼��
	 */
	public int executeBySqlName(String sqlName, Object params){
		return getPageHibernateTemplate().executeBySqlName(sqlName, params);
	}
	
	/**
	 * ִ��һ��ibatis sql,ָ���������������
	 * @param sqlName ��Ӧibatis�����ļ���sql��id
	 * @param params ��ѯ����,����Map���͵ĵĲ���(Ҳ�����������ibatis֧�ֵ����������Ϊ������ÿ��������������һ��Ҫ�ж�Ӧ��������������ܺ�paramTypes�����Ӧ)��
	 * ��Ҫ����ibatis�����������ļ������ö�Ӧ��sql
	 * @param paramTypes ��ѯ���������
	 * @return ��Ӱ��ļ�¼��
	 */
	public int executeBySqlName(String sqlName, Object params,Map paramTypes){
		return getPageHibernateTemplate().executeBySqlName(sqlName,params,paramTypes);
	}
	
}
