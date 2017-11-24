package com.sunrise.jop.infrastructure.db;

import java.io.*;
import java.util.*;

public interface BaseDAO {

	/**
	 * ��ѯ����,��ѯ��������
	 */
	public static final int QUERY_TYPE_ALL = 0;

	public static final int QUERY_TYPE_COUNT = 10;

	public static final int QUERY_TYPE_DATA = 20;

	public static final int MAX_QUERY_COUNT = 10000;

	public abstract Class getVoClass();

	public abstract void setVoClass(Class voClass);

	public abstract String getDbFlag();

	public abstract void setDbFlag(String dbFlag);

	/**
	 * ��ȡ�����ݿ�·�����ӿ�
	 * 
	 * @return
	 */

	public void setSessionManager(SessionManager sessionManager);

	/**
	 * ��������е�����
	 * 
	 * @throws Exception
	 */
	public abstract void evict() throws Exception;

	public abstract void evict(Serializable id) throws Exception;

	public abstract Object create(Object vo) throws Exception;

	public abstract void removeByPk(Serializable pk) throws Exception;

	/**
	 * ɾ����¼
	 * 
	 * @param vo
	 *            Ҫɾ����VO
	 * @throws Exception
	 *             ɾ��ʧ��
	 */
	public abstract void remove(Object vo) throws Exception;

	public abstract Object update(Object vo) throws Exception;

	public abstract Object saveOrUpdate(Object vo) throws Exception;

	public abstract Object findByPk(Serializable pk) throws Exception;

	public abstract Object findByUniqueKey(String uniqueKeyPropertyName,
			Serializable id) throws Exception;

	public abstract Collection findAll() throws Exception;

	/**
	 * ȡ�ñ���ĳһ���ֶε����ֵ��������޼�¼�򷵻�null
	 */
	public abstract Object getMaxValue(String prop) throws Exception;

	/**
	 * ȡ�ñ���ĳһ���ֶε����ֵ��������޼�¼�򷵻�null
	 */
	public abstract Object getMaxid(String id, String value, String prop)
			throws Exception;

	/**
	 * ���ݱ��е�һ���ֶΣ��� prop = value����ѯ���������ĵ�һ����¼ ��ע�⣬�����prop�����������еļ������ԣ�����
	 * many-to-one ��Щ ������Щ������PK������
	 */
	public abstract Object findByProperty(String prop, Object value)
			throws Exception;

	/**
	 * ���ݱ��е�һ���ֶΣ��� prop = value����ѯ���������ļ�¼�� ��ע�⣬�����prop�����������еļ������ԣ����� many-to-one
	 * ��Щ ������Щ������PK������
	 */
	public abstract int countByProperty(String prop, Object value)
			throws Exception;

	/**
	 * ������ҳ������������Ӧ��ѯ��������where���Ӿ䡣������ҳ���ֶ� _se_name ��ֵΪ gaven�������ɵ������Ӿ�Ϊ��name =
	 * 'gaven'���ж���ֶεģ����������ɵ�������AND��ϵ�� ���һ���ֶ��ж��ֵ�ģ�������ֶ����ɵ�����ΪOR��ϵ�������ﻹδʵ��OR�Ĺ�ϵ��
	 * ��ҳ�ϵ��ֶ�Ҫ��һ�������������ֶ�����ǰ׺ + '_' + �ֶ�����ǰ׺��'_' + ���� + ����
	 * 
	 * <pre>
	 *   ǰ׺�б�
	 *   ���� ��  �ǿ�  &lt;   &lt;=   =   &gt;=   &gt;   &lt;&gt;   in   not in
	 *   �ִ� _sn _snn _sl _snm _se _snl _sm _sne _sin _snin
	 *   ���� _nn _nnn _nl _nnm _ne _nnl _nm _nne _nin _nnin
	 *   ���� _dn _dnn _dl _dnm _de _dnl _dm _dne _din _dnin
	 *   �ַ������������㣺
	 *   (like) (not like) (= ���Դ�Сд) (&lt;&gt; ���Դ�Сд) (like ���Դ�Сд) (not like ���Դ�Сд) (start with) (end with)
	 *   _sk    _snk       _sei          _snei         _ski             _snki                _ssw				_sew
	 *   ֱ�ӵ�SQL������
	 *   _sql_
	 *   
	 *   params._queryexpress��Ϊtrue�������ִ�Сд��ʱ��ֻ��ѯ���ݣ�����ѯ������Ŀ������
	 * </pre>
	 */
	public abstract DataPackage query(Object params) throws Exception;

	public abstract int count(Object params) throws Exception;

	/**
	 * ��ѯ����typeΪ10ʱ��ֻ���¼���������������� ��typeΪ0ʱ������������
	 */
	public abstract DataPackage query(Object params, int type) throws Exception;

	/**
	 * ����ѯ����
	 */
	public abstract DataPackage unionQuery(Object params[], Class vo[],
			String joins[][]) throws Exception;

	/**
	 * ����ѯ����
	 */
	public abstract DataPackage unionQuery(Object params[], Class vo[],
			String joins[][], int type) throws Exception;

	/**
	 * ȡ���ݿ⵱ǰ����
	 */
	public abstract java.util.Date getCurrentTime() throws Exception;

	public abstract Object queryUniqueByNamedSqlQuery(String name, Object params)
			throws Exception;

	/**
	 * �����õ�named Sql Query ���в�ѯ����ѯΨһ���
	 * 
	 * @param name
	 *            hbm.xml �����õ� Sql Query ������
	 * @return
	 * @throws Exception
	 */
	public abstract Object queryUniqueByNamedSqlQuery(String name,
			Object params, Class returnType) throws Exception;

	/**
	 * �����õ�named Sql Query ���в�ѯ, ֻ��ѯ��¼��������ȡ���� DataPackage.getRowCount()
	 * 
	 * @param name
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public abstract DataPackage queryCountByNamedSqlQuery(String name,
			Object params) throws Exception;

	/**
	 * �����õ�named Sql Query ���в�ѯ�� ��¼������¼���϶���ѯ, �޸��Ӳ�ѯ��������¼���ϲ���ҳ��ȫ���鴦��
	 * 
	 * @param name
	 *            hbm.xml �����õ� Sql Query ������
	 * @return
	 * @throws Exception
	 */
	public abstract DataPackage queryByNamedSqlQuery(String name)
			throws Exception;

	/**
	 * �����õ�named Sql Query ���в�ѯ�� ��¼������¼���϶���ѯ����params�е��������з�ҳ������
	 * 
	 * @param name
	 *            hbm.xml �����õ� Sql Query ������
	 * @param params
	 *            ����ListVO�淶�Ĳ�ѯ��������
	 * @return
	 * @throws Exception
	 */
	public abstract DataPackage queryByNamedSqlQuery(String name, Object params)
			throws Exception;

	/**
	 * �����õ�named Sql Query ���в�ѯ��
	 * 
	 * @param name
	 *            hbm.xml �����õ� Sql Query ������
	 * @param params
	 *            ����ListVO�淶�Ĳ�ѯ��������
	 * @param type
	 *            ��ѯ���ͣ���ѯ��¼��(QUERY_TYPE_COUNT),��ѯ��¼(QUERY_TYPE_DATA),���߶���ѯ(
	 *            QUERY_TYPE_ALL)
	 * @return
	 * @throws Exception
	 */
	public abstract DataPackage queryByNamedSqlQuery(String name,
			Object params, int type) throws Exception;

	/**
	 * ����sql���в�ѯ. ��ѯΨһ�����
	 * 
	 * @param sql
	 *            Ҫ��ѯ��sql���
	 * @return
	 * @throws Exception
	 */
	public Object queryUniqueBySql(String queryString, Object params,
			Class returnType) throws Exception;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sunrise.jop.infrastructure.db.hibernate3.BaseDAO#queryUniqueBySql
	 * (java.lang.String, java.lang.Object, java.lang.Class)
	 */
	public Object queryUniqueBySql(String queryString, Object param,
			Class returnType, String queryName) throws Exception;

	/**
	 * ����sql���в�ѯ. ��¼������¼�������߶���ѯ
	 * 
	 * @param sql
	 *            Ҫ��ѯ��sql���
	 * @return
	 * @throws Exception
	 */
	public DataPackage queryBySql(String queryString) throws Exception;

	/**
	 * ����sql���в�ѯ. ��¼������¼�������߶���ѯ
	 * 
	 * @param sql
	 *            Ҫ��ѯ��sql���
	 * @param params
	 *            ����ListVO�淶�Ĳ�ѯ��������
	 * @return
	 * @throws Exception
	 */
	public DataPackage queryBySql(String queryString, Object params)
			throws Exception;

	public DataPackage queryBySql(String queryString, Object params, int type)
			throws Exception;

	/**
	 * ��SQL��������sum��ѯ
	 * 
	 * @param name
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public String querySumByNamedSql(String name, Object params) throws Exception;

	/**
	 * sum��ѯ
	 * 
	 * @param queryString
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public String querySumBySql(String queryString, Object params)
			throws Exception;

	/**
	 * ����SEQUENCE����ȡ��seq nextval��ֵ
	 * 
	 * @param seq
	 */
	public Object getSequence(String seqname) throws Exception;

}