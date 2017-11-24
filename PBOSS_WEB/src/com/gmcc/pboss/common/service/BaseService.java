package com.gmcc.pboss.common.service;

import java.io.Serializable;

import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.exception.TransactionProcessionException;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;

public interface BaseService {

	/**
	 * ��ȡ�б�
	 * 
	 * @param parameter
	 * @return
	 */
	QueryResult getAll(QueryParameter parameter);

	/**
	 * ��������ȡ����
	 * 
	 * @param id
	 * @return
	 */
	Object get(Serializable id);

	/**
	 * ʹ��������ѯ����:���������Ωһ,���׳�IllegalStateException,���󲻴����򷵻�null
	 * @param propertyNames -- ������������(������values���������ͬ,�����׳�IllegalStateException)
	 * @param values -- ����ֵ����
	 * @return ���ϲ�ѯ������Ωһ����
	 */
	Object getOne(String[] propertyNames, String[] values);
	
	/**
	 * �������
	 * 
	 * @param object
	 * @return
	 */
	Object save(Object object);

	/**
	 * ������ɾ������
	 * 
	 * @param id
	 */
	void remove(Serializable id);

	/**
	 * ɾ������
	 * 
	 * @param id
	 */
	void removeObject(Object id);
	
	
	/**
	 * û���������ҵ����ڣ�serviceTypeΪ��INITIATE(��¼ʱ��)��QUERY
	 * ����Щ������û�ж����ݿ��������ɾ���Ĳ���
	 * @param member �û���¼Session 
	 * @param parameter ҵ���������
	 * @param serviceType ҵ������
	 * @return
	 */
	public ServiceResult transact(LoginMember member,QueryParameter parameter, short serviceType);
	
	/**
	 * �����������ҵ����ڣ�serviceTypeΪ��INITIATE��MODIFY��CANCEL
	 * ����Щ�����ж����ݿ��������ɾ���Ĳ�������action�в���÷����׳����쳣��
	 * �쳣������Ϊ: ServiceRetCode.EXCEPTION = 4
	 * @param member
	 * @param parameter
	 * @param serviceType
	 * @return
	 * @throws TransactionProcessionException �������쳣
	 */
	public ServiceResult transactionProcessing(LoginMember member,QueryParameter parameter, short serviceType)
						throws TransactionProcessionException;
	
	/**
	 * ��ѯҵ�����һ��ҵ���в�ѯ�������в�ѯ�������󣬸÷������ڼ��ϲ�ѯ
	 * @param member
	 * @param parameter
	 * @return
	 */
	public ServiceResult query(LoginMember member, QueryParameter parameter);
	
	/**
	 * ��ѯҵ�����һ��ҵ���в�ѯ�������в�ѯ�������󣬸÷������ڵ��������ѯ
	 * @param member
	 * @param parameter
	 * @return
	 */
	public ServiceResult queryForOne(LoginMember member, QueryParameter parameter);
	
	/**
	 * ��ͨҵ��
	 * @param member
	 * @param parameter
	 * @return
	 */
	public ServiceResult initiate(LoginMember member, QueryParameter parameter);
	
	/** 
	 * �޸�ҵ��
	 * @param member
	 * @param parameter
	 * @return
	 */
	public ServiceResult modify(LoginMember member, QueryParameter parameter);
	
	/**
	 * ȡ��ҵ��
	 * @param member
	 * @param parameter
	 * @return
	 */
	public ServiceResult cancel(LoginMember member, QueryParameter parameter);
	
	/**
	 * ����ҵ��ͨ��parameter�е�operation��ѡ�������Զ���ӿ�
	 * @param member
	 * @param parameter
	 * @return
	 */
	public ServiceResult other(LoginMember member, QueryParameter parameter);
}
