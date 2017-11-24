package com.asisinfo.common.hibernate;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.type.Type;
import org.hibernate.type.TypeFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.asisinfo.common.hibernate.transformer.DynamicBeanTransformer;
import com.asisinfo.common.hibernate.transformer.HashMapTransformer;
import com.asisinfo.common.hibernate.transformer.LinkMapTransformer;
import com.asisinfo.common.hibernate.transformer.PojoTransformer;
import com.asisinfo.common.hibernate.transformer.SimpleDataTransformer;
import com.asisinfo.common.ibatis.IbatisSqlMapConfigHelper;
import com.asisinfo.common.ibatis.SQLStore;
import com.asisinfo.common.model.DynamicBean;
import com.asisinfo.common.model.DynamicProperty;
import com.asisinfo.common.pager.IPage;
import com.asisinfo.common.pager.Page;

/**
 * ��װ�����hibernate������HibernateDao�г��иö���
 * @author johnson
 *
 */
/**
 * @author johnson
 *
 */
public class PageHibernateTemplate extends HibernateTemplate{
	
	public PageHibernateTemplate() {
		super();
	}

	public PageHibernateTemplate(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	public PageHibernateTemplate(SessionFactory sessionFactory, boolean allowCreate) {
		super(sessionFactory,allowCreate);
	}

	public IPage queryPage(final String hql, final Object params,
			final QueryOption queryOption) {
		IPage page = (IPage) executeWithNativeSession(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				return doPaging(session, hql, false,null,queryOption, params);
			}
		});
		return page;
	}
	
	public IPage queryPageBySql(final String nativeSql, final Class resultClass, final Object param,
			final QueryOption queryOption) {
		IPage page = (IPage) executeWithNativeSession(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				return doPaging(session, nativeSql, true,resultClass,queryOption, param);
			}
		});
		return page;
	}
	
	public IPage queryPageBySqlName(String sqlName, final Class resultClass, final Object param,
			final QueryOption queryOption) {
		final SQLStore getter = IbatisSqlMapConfigHelper.getSQLStore(sqlName, param);
		final String ibatisSql = getter.getSql();
		IPage page = (IPage) executeWithNativeSession(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				return doPaging(session, ibatisSql, true,resultClass, queryOption, getter.getValue());
			}
		});
		return page;
	}
	
	
	public List queryListBySql(String nativeSql, Class resultClass, Object param) {
		QueryOption queryOption = QueryOption.getInstance();
		queryOption.setPagingType(QueryOption.PAGE_NONE);
		IPage page = queryPageBySql(nativeSql, resultClass, param, queryOption);
		return page.getThisPageElements();
	}
	
	public List queryListBySqlName(String sqlName, Class resultClass, Object param) {
		QueryOption queryOption = QueryOption.getInstance();
		queryOption.setPagingType(QueryOption.PAGE_NONE);
		IPage page = queryPageBySqlName(sqlName, resultClass, param, queryOption);
		return page.getThisPageElements();
	}
	
	public int execute(final String hql,final Object params){
		Integer result = (Integer) executeWithNativeSession(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				return doUpdate(session, hql, false, params);
			}
		});
		return result.intValue();
	}
	
	public int executeBySql(final String nativeSql, final Object params){
		Integer result = (Integer) executeWithNativeSession(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				return doUpdate(session, nativeSql, true, params);
			}
		});
		return result.intValue();
	}
	
	public int executeBySql(final String nativeSql, final Object[] params,String[] typeStr){
		final Object[] types = new Object[params.length];
		for (int i = 0; i < params.length; i++) {
			if(params[i]!=null)
				types[i] = params[i].getClass();
			else{

				try {
					types[i] = DynamicProperty.getClassForType(typeStr[i]);
				} catch (Exception e) {
					types[i] = String.class;
				}
			}
		}
		
		Integer result = (Integer) executeWithNativeSession(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				return doUpdate(session, nativeSql, true, params,types);
			}
		});
		return result.intValue();
	}
	
	public int executeBySqlName(String sqlName, final Object params){
		final SQLStore getter = IbatisSqlMapConfigHelper.getSQLStore(sqlName, params);
		final String ibatisSql = getter.getSql();
		Integer result = (Integer) executeWithNativeSession(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				return doUpdate(session, ibatisSql, true, getter.getValue());
			}
		});
		return result.intValue();
	}
	
	public int executeBySqlName(String sqlName, final Object params,Map paramType){
		final SQLStore getter = IbatisSqlMapConfigHelper.getSQLStore(sqlName, params);
		final String ibatisSql = getter.getSql();
		final Object[] values = getter.getValue();
		final String[] propName = getter.getPropName();
		final Object[] types = new Object[values.length];
		for (int i = 0; i < values.length; i++) {
			if(values[i]!=null)
				types[i] = values[i].getClass();
			else{
				//����ibats�õ������б����п�ֵ����Ҫ��ȡ���ֶε�����
				String propType = (String) paramType.get(propName[i]);
				try {
					types[i] = DynamicProperty.getClassForType(propType);
				} catch (Exception e) {
					types[i] = String.class;
				}
			}
		}
		Integer result = (Integer) executeWithNativeSession(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				return doUpdate(session, ibatisSql, true, values,types);
			}
		});
		return result.intValue();
	}
	
	public boolean tableExists(String tabName) {
		String sql = "select count(*) from ";
		String dialect = ((org.hibernate.impl.SessionFactoryImpl) getSessionFactory()).getDialect().getClass().getName().toLowerCase();
		if (dialect.indexOf("informix") != -1) {
			sql += "systables where tabname = ?";
		}
		else if (dialect.indexOf("oracle") != -1) {
			sql += "user_tables where table_name = ?";
		}
		else {
			throw new UnsupportedOperationException("Unsupported dialect:"
					+ dialect);
		}
		Integer result = 0;
		List resultList = queryListBySql(sql, Integer.class, new Object[]{tabName});
		if(resultList.size()>0)
			result = (Integer) resultList.get(0);
		return result>0;
	}
	
	
	
	/**
	 * �Զ����count��sql������distint,��group by�ȸ��ӵ�sql���ܲ�֧�֣�����ɴ����count���,
	 * �����������еİ���Щ�ؼ��ֵ���䶼�����Զ���ɣ����������ÿ��Լ���У�飬���ڲ�֧�ֵ�sql�׳��쳣����ָ��ԭ��
	 */
	
	private String getCountQueryStrAuto(String queryStr) {
		StringBuffer countQueryStr = new StringBuffer();
		countQueryStr.append(" select count (*) ").append(
					removeSelect(removeOrders(queryStr)));
		return countQueryStr.toString();
	}
	
	private String getCountQueryStrForce(String queryStr) {
		StringBuffer countQueryStr = new StringBuffer();
		String dialect = ((org.hibernate.impl.SessionFactoryImpl) getSessionFactory()).getDialect().getClass().getName().toLowerCase();
		if (dialect.indexOf("informix") != -1) {
			countQueryStr.append("select count(*) from table(multiset(");
			countQueryStr.append(queryStr).append("))");
		}
		else if (dialect.indexOf("oracle") != -1) {
			countQueryStr.append("select count(*) from(");
			countQueryStr.append(queryStr).append(")");
		}
		else {
			throw new UnsupportedOperationException("Unsupported dialect:"
					+ dialect);
		}
		return countQueryStr.toString();
	}
	
	private Integer doUpdate(Session session,String queryStr,boolean isNativeSql,Object paramObj){
		return doUpdate(session, queryStr, isNativeSql, paramObj, null);
	}
	
	/**
	 * @param session
	 * @param queryStr
	 * @param isNativeSql
	 * @param paramObj
	 * @param paramType map�������飬��ʶÿ�������Ӧ��java class����
	 * @return
	 */
	private Integer doUpdate(Session session,String queryStr,boolean isNativeSql,Object paramObj,Object paramType){
		Query query = createQueryFromConditon(session, queryStr, isNativeSql, paramObj,paramType);
		int result = query.executeUpdate();
		return Integer.valueOf(result);
	}
	
	private IPage doPaging(Session session,String queryStr,boolean isNativeSql,
			Class resultClass,QueryOption queryOption,Object paramObj){
		IPage page = new Page();
		Query query = createQueryFromConditon(session, queryStr, isNativeSql, paramObj);
		
		if(resultClass!=null){
			query.setResultTransformer(getTransformer(resultClass,queryOption));
		}
		
		if(queryOption!=null){
			page.setPageNo(queryOption.getPageNo());
			page.setPageSize(queryOption.getPageSize());
			if(QueryOption.PAGE_LIST.equals(queryOption.getPagingType())){
				List list = query.list();
				page.setTotal(list.size());
				list = list.subList(page.getThisPageFirstElementNo()-1, page.getThisPageLastElementNo());
				page.setThisPageElements(list);
			}else if(QueryOption.PAGE_AUTO.equals(queryOption.getPagingType())){
				//count
				int resultCount = countQueryResult(session, queryStr, isNativeSql, paramObj, true);
				page.setTotal(resultCount);
				//query
				query.setFirstResult((page.getThisPageNo() - 1) * page.getPageSize())
				.setMaxResults(page.getPageSize());
				page.setThisPageElements(query.list());
			}else if(QueryOption.PAGE_NEST.equals(queryOption.getPagingType())){
				//count
				int resultCount = countQueryResult(session, queryStr, isNativeSql, paramObj, false);
				page.setTotal(resultCount);
				//query
				query.setFirstResult((page.getThisPageNo() - 1) * page.getPageSize())
				.setMaxResults(page.getPageSize());
				page.setThisPageElements(query.list());
			}else{
				List list = query.list();
				page.setTotal(list.size());
				page.setThisPageElements(list);
			}
		}else{
			List list = query.list();
			page.setTotal(list.size());
			page.setThisPageElements(list);
		}
		return page;
	}
	
	private Query createQueryFromConditon(Session session,String queryStr,boolean isNativeSql,Object paramObj){
		return createQueryFromConditon(session, queryStr, isNativeSql, paramObj, null);
	}
	
	/** ��ʼ����ѯ����*/
	private Query createQueryFromConditon(Session session,String queryStr,boolean isNativeSql,Object paramObj,Object paramType){
		Query query = null;
		if(isNativeSql)
			query = session.createSQLQuery(queryStr);
		else
			query = session.createQuery(queryStr);
		if(paramObj!=null){
			if(paramObj instanceof Object[]){
				Object[] params = (Object[]) paramObj;
				Object[] types = (Object[]) paramType;
				for (int i = 0; i < params.length; i++) {
					if(types!=null){
						Class clazz = (Class)types[i];
						Type hibType = TypeFactory.basic( clazz.getName());
						query.setParameter(i, params[i],hibType);
					}else{
						query.setParameter(i, params[i]);
					}
				}
			}else if(paramObj instanceof Map){
				Map params = (Map) paramObj;
				Map types = (Map) paramType;
				Set<String> keys = params.keySet();
				for(String key:keys){
					if(types!=null){
						Class clazz = (Class)types.get(key);
						Type hibType = TypeFactory.basic( clazz.getName());
						query.setParameter(key, params.get(key),hibType);
					}else{
						query.setParameter(key, params.get(key));
					}
				}
			}
		}	
		return query;
	}
	
	
	private int countQueryResult(Session session,String queryStr,boolean isNativeSql,Object paramObj,boolean isAuto){
		int totalCount = 0;
		String countStr = "";
		if(isAuto){
			countStr = getCountQueryStrAuto(queryStr);
		}else{
			if(!isNativeSql)
				throw new UnsupportedOperationException("ֻ��native sql֧��PageCondition.PAGE_FORCE_COUNT");
			
			countStr = getCountQueryStrForce(queryStr);
		}	
		try {
			Query countQuery = createQueryFromConditon(session, countStr, isNativeSql, paramObj);
			totalCount = Integer.parseInt(countQuery.uniqueResult().toString());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("�޷�ͨ�������Խ�����count����:"+countStr,e);
		}
		return totalCount;
	}
	
//	private boolean validateQueryStr(String queryStr) {
//		String lowerqueryStr = queryStr.toLowerCase();
//		if (lowerqueryStr.matches("group\\s*by") || lowerqueryStr.indexOf("distinct") > 0)
//			return false;
//		else
//			return true;
//	}

	private static String removeSelect(String queryStr) {
		int beginPos = queryStr.toLowerCase().indexOf("from");
		return queryStr.substring(beginPos);
	}

	private static String removeOrders(String queryStr) {
		Pattern p = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*",
				Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(queryStr);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, "");
		}
		m.appendTail(sb);
		return sb.toString();
	}
	
	private ResultTransformer getTransformer(Class resultClass,QueryOption opt){
		ResultTransformer transformer = null; 
		if(resultClass == Map.class||resultClass == HashMap.class){
			transformer = HashMapTransformer.INSTANCE;
		}else if(resultClass == LinkedHashMap.class){
			transformer = LinkMapTransformer.INSTANCE;
		}else if(isSimpleData(resultClass)){
			transformer = new SimpleDataTransformer((Class)resultClass);
		}else if(resultClass== DynamicBean.class){
			Map config = opt.getDynamicBeanConfig();
			transformer = new DynamicBeanTransformer(config);
		}else{
			transformer = new PojoTransformer((Class)resultClass);		
		}
		return transformer;
	}
	
	//�Ƿ��ǳ����������(����ӳ�䵥�����)
	private boolean isSimpleData(Class resultClass){
		return resultClass == Integer.class||
		resultClass == Long.class||
		resultClass == Double.class||
		resultClass == Float.class||
		resultClass == Byte.class||
		resultClass == String.class||
		resultClass == Timestamp.class||
		resultClass == java.util.Date.class||
		resultClass == BigDecimal.class||
		resultClass == BigInteger.class;
	}
}
