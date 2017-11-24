package com.gmcc.pboss.common.dao;

import java.io.Serializable;
import java.util.List;

import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;
import com.gmcc.pboss.common.support.QueryResult;

public interface BaseDao {

	/**
	 * ȡ���ж���
	 */
	public List getAll();

	/**
	 * ������ȡ����
	 * 
	 * @param id
	 *            ����
	 * @return
	 */
	public Object get(Serializable id);
	
	/**
	 * ʹ��������ѯ����:���������Ωһ,���׳�IllegalStateException,���󲻴����򷵻�null
	 * @param propertyNames -- ������������(������values���������ͬ,�����׳�IllegalStateException)
	 * @param values -- ����ֵ����
	 * @return ���ϲ�ѯ������Ωһ����
	 */
	public Object getOne(String[] propertyNames, Object[] values);

	/**
	 * ��������Ƿ����
	 * 
	 * @param id
	 *            ����
	 * @return
	 */
	boolean exists(Serializable id);

	/**
	 * ����
	 * 
	 * @param object
	 * @return
	 */
	public Object save(Object object);
	
	/**
	 * ����
	 * @param object
	 * @return
	 */
	public void update(Object object);

	/**
	 * ������ɾ��
	 * 
	 * @param id
	 */
	public void remove(Serializable id);

	/**
	 * ֱ��ɾ������
	 * 
	 * @param obj
	 */
	public void removeObject(Object obj);

	/**
	 * ͨ��ɾ��һ�����
	 * 
	 * @param objss
	 */
	public void removeAllObject(List objs);
	

	/**
	 * ȥ���ظ�ֵ
	 * 
	 * @return
	 */
	public List getAllDistinct();

	/**
	 * ���ݲ�����ѯ
	 */
	public QueryResult getAll(QueryParameterProcessor processor, QueryParameter parameter);

	/**
	 * ���ݲ�����ѯ��¼����,����Ӧ���ݲ�ͬ�Ĳ�ѯ��������д�˷���
	 */
	public int getAllRows(QueryParameterProcessor processor, QueryParameter parameter);
	
	/**
	 * ʹ��SQLQuery
	 * ���ݲ�����ѯ
	 */
	public int getAllRowsSQL(QueryParameterProcessor processor, QueryParameter parameter);
	/**
	 * ʹ��SQLQuery
	 * ���ݲ�����ѯ��¼����,����Ӧ���ݲ�ͬ�Ĳ�ѯ��������д�˷���
	 */
	public QueryResult getAllSQL(QueryParameterProcessor processor, QueryParameter parameter);
	
	/**
	 * ˢ��SessionFactory
	 */
	public void reloadSessionFactory();

	

}
