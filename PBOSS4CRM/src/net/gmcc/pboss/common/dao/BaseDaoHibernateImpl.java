package net.gmcc.pboss.common.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * 数据访问：DAO接口的Hibernate实现 
 */

@Transactional
public class BaseDaoHibernateImpl extends HibernateDaoSupport implements IBaseDao {	
	private SimpleJdbcTemplate simpleJdbcTemplate;
	private DataSource dataSource;
	
	public void save(final Object entity) throws DataAccessException {
		Assert.notNull(entity);
		getHibernateTemplate().save(entity);
	}

	public void saveAll(final Collection<?> entities) throws DataAccessException{
		Iterator<?> entitiesIter = entities.iterator();
		while(entitiesIter.hasNext()){
			getCurrentSession().save(entitiesIter.next());
		}
	}
	
	public void saveOrUpdate(final Object entity) throws DataAccessException {
		Assert.notNull(entity);
		getHibernateTemplate().saveOrUpdate(entity);
	}
	
	public void saveOrUpdateAll(final Collection<?> entities) throws DataAccessException{
		getHibernateTemplate().saveOrUpdateAll(entities);
	}
	
	public void update(Object entity) throws DataAccessException {
		Assert.notNull(entity);
		getHibernateTemplate().update(entity, LockMode.NONE);
//		getHibernateTemplate().merge(entity);
//		getHibernateTemplate().update(entity);
//		getHibernateTemplate().refresh(entity);
	}
	
	public void delete(Object entity)throws DataAccessException {
		Assert.notNull(entity);
//		getHibernateTemplate().delete(entity);
		getHibernateTemplate().delete(entity,LockMode.NONE);
//		this.flush();//lock active
//		getHibernateTemplate().delete(entity,LockMode.UPGRADE);
	}
	
	public <T> void delete(Class<T> entityClass, Serializable id) throws DataAccessException {
		Assert.notNull(id);
		T obj = this.get(entityClass, id);
		if (obj != null) {
			delete(obj);
		}
	}

	public void deleteAll(final Collection<?> entities)throws DataAccessException {
		getHibernateTemplate().deleteAll(entities);
	}
	
	public <T> T find(Class<T> entityClass, Serializable id)throws DataAccessException {
		return this.get(entityClass, id);
	}
	
	public List<?> find(String hql, Object... values) throws DataAccessException  {
		Assert.hasText(hql);
		return super.getHibernateTemplate().find(hql, values);
	}

	public <T> T get(Class<T> entityClass, Serializable id) throws DataAccessException {
		Assert.notNull(id);
		return getHibernateTemplate().get(entityClass, id);
	}
	
	public <T> T getElse(Class<T> entityClass, Serializable id, T t) throws DataAccessException{
		T x = this.get(entityClass, id);
		return x!=null?x:t;
	}

	public <T> List<T> findAll(Class<T> entityClass) throws DataAccessException {
		return getHibernateTemplate().loadAll(entityClass);
	}

	public void flush()throws DataAccessException {
		getHibernateTemplate().flush();
	}

	public void clear()throws DataAccessException {
		getHibernateTemplate().clear();
		
	}

	public Query createQuery(String hql, Object... values) throws DataAccessException {
		Assert.hasText(hql);
		Query query = getSession().createQuery(hql);
		if(null != values){
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query;
	}
	
	public SQLQuery createSQLQuery(String sql, Object... values) throws DataAccessException {
		Assert.hasText(sql);
		SQLQuery query = getSession().createSQLQuery(sql);
		if(null != values){
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query;
	}
	
	public SimpleJdbcTemplate getSimpleJdbcTemplate(){
		if(this.simpleJdbcTemplate==null){
			this.simpleJdbcTemplate = new SimpleJdbcTemplate(this.getDataSource());
		}
		return this.simpleJdbcTemplate;
	}

	public <T> T findSingleBySQL(final String sql, final Class<T> resultClass, final Object... values) throws DataAccessException{
		SimpleJdbcTemplate simple = getSimpleJdbcTemplate();
		if(simple != null){
			return simple.queryForObject(sql, resultClass, values);
		}
		return null;
	}
	
	public Session getCurrentSession() throws DataAccessException  {
		return super.getSession();
	}
	
	public void closeCurrentSession() throws DataAccessException {
		Session son = getCurrentSession();
		if(son!=null && son.isOpen()){
			son.close();
		}
	}
	
	public DataSource getDataSource(){
		return this.dataSource;
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
    
    public <T> T queryForObject(String sql, Class<T> clazz, T defValue, Object... args){
    	try {
    		return getSimpleJdbcTemplate().queryForObject(sql, clazz, args);
		} catch (Exception e) {
			e.printStackTrace();
			return defValue;
		}
    	
    }
    
    public Long queryForLong(String sql, Long defValue, Object... args){
    	return queryForObject(sql, Long.class, defValue, args);
    }
    
    public Integer queryForInt(String sql, int defValue, Object... args){
    	return queryForObject(sql, Integer.class, defValue, args);
    }
    
    public String queryForString(String sql, String defValue, Object... args){
    	return queryForObject(sql, String.class, defValue, args);
    }
}
