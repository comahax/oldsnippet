package com.sunrise.jop.infrastructure.control;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sunrise.jop.common.spring.SpringContextManager;
import com.sunrise.jop.infrastructure.db.DBAccessUser;

/**
 * <p>
 * Title: Control����
 * </p>
 * 
 * <p>
 * Description: ������������һ��AbstractControl����
 * </p>
 * Copyright: Copyright (c) 2005 </p>
 * <p>
 * Company: Sunrise
 * </p>
 * 
 * @author HuangBaiming && DuHuazheng
 * @author He Kun
 * 
 * @version 1.0
 * @version 2.0 ����Spring,ʹ�� beanFactory ��ȡ�������ҵ��Beanʵ����SpringΪ���Զ���װ����֧�֡�
 * @version 2.1 by hekun:���ж�TESTFLAG Ϊyes ʱ����EJB Ϊ�ж� EJBFLAG��ʶ��
 */
public class BOFactory {
	/**
		PROPAGATION_REQUIRED 	�������һ��������֧�ֵ�ǰ�������û����������һ���µ����� ʹ�� spring ����ʽ���� spring ʹ�� AOP ��֧������ʽ���񣬻�����������ԣ��Զ��ڷ�������֮ǰ�����Ƿ���һ�����񣬲��ڷ���ִ��֮����������ύ��ع����� �������� methodB ���� �൱�� Spring ��֤�� methodB ���������еĵ��ö���õ�һ����ͬ�����ӡ��ڵ��� methodB ʱ��û��һ�����ڵ��������Ի��һ���µ����ӣ�������һ���µ����� �������� MethodA ʱ���� MethodA ���ֻ���� MethodB. ִ��Ч���൱�� ���� MethodA ʱ��������û���������Կ���һ���µ����� . ���� MethodA �е��� MethodB ʱ���������Ѿ�����һ���������� methodB �ͼ��뵱ǰ���� 

		PROPAGATION_SUPPORTS �������һ������֧�ֵ�ǰ�������û��������������ִ�С����Ƕ�������ͬ��������������� PROPAGATION_SUPPORTS �벻ʹ������������ͬ�� �����ĵ��� methodB ʱ�� methodB �����Ƿ������ִ�еġ� ������ methdA ʱ ,methodB ������� methodA �������� , �����ִ�С� 

		PROPAGATION_MANDATORY ����Ѿ�����һ������֧�ֵ�ǰ�������û��һ������������׳��쳣�� ���������� methodB ʱ����Ϊ��ǰû��һ�������������׳��쳣 throw new IllegalTransactionStateException("Transaction propagation ''mandatory'' but no existing transaction found"); ������ methodA ʱ�� methodB ����뵽 methodA �������У������ִ�С� 

		PROPAGATION_REQUIRES_NEW ���ǿ���һ���µ��������һ�������Ѿ����ڣ���������ڵ�������� ���������� methodB ʱ���൱�ڰ� methodb ����Ϊ REQUIRED ������һ���µ����������ִ�С� ������ methodA ʱ �����Щ��һ�� . �൱�������Ч���� ������Ұ� ts1 ��Ϊ������� ts2 ��Ϊ�ڲ����񡣴�����Ĵ�����Կ����� ts2 �� ts1 ���������������񣬻�����ɡ� Ts2 �Ƿ�ɹ����������� ts1 ����� methodA �����ڵ��� methodB ������� doSomeThingB ����ʧ���ˣ��� methodB ���������Ľ����Ȼ���ύ�������� methodB ֮����������뵼�µĽ��ȴ���ع��ˡ� ʹ�� PROPAGATION_REQUIRES_NEW, ��Ҫʹ�� JtaTransactionManager ��Ϊ����������� 

		PROPAGATION_NOT_SUPPORTED ���Ƿ������ִ�У��������κδ��ڵ����� ���������� methodB ʱ���������κ�������ƣ��������ִ�С� ������ methodA ʱ���൱�������Ч�� ʹ�� PROPAGATION_NOT_SUPPORTED, Ҳ��Ҫʹ�� JtaTransactionManager ��Ϊ����������� 

		PROPAGATION_NEVER ���Ƿ������ִ�У��������һ����������׳��쳣 �������� methodB ����������ִ�С� ���� methodA ����׳��쳣 

		PROPAGATION_NESTED ���һ�����������ڣ���������һ��Ƕ�׵������� . ���û�л���� , �� TransactionDefinition.PROPAGATION_REQUIRED ����ִ�� ����һ��Ƕ������ , ʹ�� JDBC 3.0 ����ʱ , ����֧�� DataSourceTransactionManager ��Ϊ�������������Ҫ JDBC ������ java.sql.Savepoint �ࡣ��һЩ JTA �����������ʵ�ֿ���Ҳ�ṩ��ͬ���Ĺ��ܡ� ʹ�� PROPAGATION_NESTED ������Ҫ�� PlatformTransactionManager �� nestedTransactionAllowed ������Ϊ true; �� nestedTransactionAllowed ����ֵĬ��Ϊ false; ����������� methodB �������� REQUIRED ����ִ�С� ������� methodA �������൱�������Ч�� �� methodB ��������֮ǰ������ setSavepoint ���������浱ǰ��״̬�� savepoint ����� methodB ��������ʧ�ܣ���ָ���֮ǰ�����״̬��������Ҫע����ǣ���ʱ������û�н����ύ����������Ĵ��� (doSomeThingB() ���� ) ����ʧ�ܣ���ع����� methodB ���������в����� Ƕ������һ���ǳ���Ҫ�ĸ�������ڲ�������������������������ʧ��ʱ����ع��ڲ����������Ķ��������ڲ��������ʧ�ܲ����������������Ļع���
	 */
	
	public static final String PROPAGATION_REQUIRED ="PROPAGATION_REQUIRED";
	public static final String PROPAGATION_SUPPORTS ="PROPAGATION_SUPPORTS";
	public static final String PROPAGATION_MANDATORY ="PROPAGATION_MANDATORY";
	public static final String PROPAGATION_REQUIRES_NEW ="PROPAGATION_REQUIRES_NEW";
	public static final String PROPAGATION_NOT_SUPPORTED ="PROPAGATION_NOT_SUPPORTED";
	public static final String PROPAGATION_NEVER ="PROPAGATION_NEVER";
	public static final String PROPAGATION_NESTED ="PROPAGATION_NESTED";
	
	private static final Log log = LogFactory.getLog(BOFactory.class);

	private BOFactory() {
	}

	/**
	 * ��������,����һ��control���������Ȩ��Ӧ����ʹ�ã����磺����ת���� һ�������ʹ�� build(Class
	 * controlBeanClass,DBAccessUser user)��
	 * 
	 * @param controlBeanClass
	 *            ControlBean��
	 * @deprecated build(Class controlBeanClass,DBAccessUser user)
	 * 
	 */
	public static AbstractControl build(Class controlBeanClass) throws Exception {
		return build(controlBeanClass, null);
	}


	/**
	 * ��������,����һ��control
	 * 
	 * @param controlBeanClass
	 *            ControlBean��
	 * @param user
	 */
	public static AbstractControl build(Class controlBeanClass, DBAccessUser user) throws Exception {
		return build(controlBeanClass, user, PROPAGATION_REQUIRED);
	}

	public static AbstractControl build(Class controlBeanClass, DBAccessUser user, String transactionAttribute) throws Exception {
		return useBean(controlBeanClass, user, transactionAttribute);
	}
	
	/**
	 * ��Spring context�л�ȡ�Ѿ�ע���ҵ��Bean����Spring������Ϊ����������֧�֡� *
	 * 
	 * @param controlBeanClass
	 *            ҵ��Bean��
	 * @param user
	 * @see #com
	 * 
	 */
	private static AbstractControl useBean(Class controlBeanClass, DBAccessUser user, String transactionAttribute) throws Exception {
		/**
		 * ---------------------------- ��Spring���ɷ�ʽ2�� ��̬������ע��ҵ��bean
		 */
		AbstractControlBean control;
		if(PROPAGATION_REQUIRED.equals(transactionAttribute)){
			SpringContextManager.registerBean(controlBeanClass.getName(), controlBeanClass);
			control = (AbstractControlBean) SpringContextManager.getBean(controlBeanClass.getName());
		}else{
			SpringContextManager.registerBean(controlBeanClass.getName() + transactionAttribute, controlBeanClass);
			control = (AbstractControlBean) SpringContextManager.getBean(controlBeanClass.getName() + transactionAttribute);
		}
		control.setUser(user); // ����user�� ҵ��bean��Ҫ
		return (AbstractControl) control;

	}

	public static Object invokeCreate(Object obj) throws Exception {
		Class[] types = {};
		Method m = obj.getClass().getMethod("create", types);
		Object[] args = {};
		return m.invoke(obj, args);
	}
}
