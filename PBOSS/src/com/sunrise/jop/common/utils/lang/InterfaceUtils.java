package com.sunrise.jop.common.utils.lang;

import java.util.*;

import com.sunrise.jop.common.spring.*;

/**
 * ע��ӿڣ�ʵ����Ķ�Ӧ��ϵ��
 * InterfaceUtils �����������Ӧ��ϵ���������ӿڵ�Ĭ��ʵ�����ʵ����
 * ������Spring�����н���ע�ᡣʵ�ֽӿں�ʵ�������ȫ���
 * 
 * @author He Kun (Sunrise,Guangzhou, CN)
 *
 */
public class InterfaceUtils {
	
	private Map interfaceClassMapping = new HashMap();
	private static InterfaceUtils interfaceUtils = new InterfaceUtils();
	
	private InterfaceUtils(){
		
	}
	
	public static InterfaceUtils getInstance() {
		if(SpringContextManager.containsBean((InterfaceUtils.class.getName()))) {
			InterfaceUtils utils = (InterfaceUtils)SpringContextManager.getBean(InterfaceUtils.class.getName());
			return utils;
		}else			
			return interfaceUtils;
	}
	
	public Map getInterfaceClassMapping() {
		return interfaceClassMapping;
	}
	
	/**
	 * ע��ӿڣ�ʵ����Ķ�Ӧ��ϵ��InterfaceUtils �����������Ӧ��ϵ���������ӿڵ�Ĭ��ʵ�����ʵ����
	 * ������Spring�����н���ע�ᡣʵ�ֽӿں�ʵ�������ȫ���
	 * @param interfaceClassMapping
	 */
	public void setInterfaceClassMapping(Map interfaceClassMapping) {
		this.interfaceClassMapping = interfaceClassMapping;
	}
	
	public Class  getImplClass(Class interfaceClass) {
		Class clazz = null;
		
		if(interfaceClass.isInterface()) { //����ǽӿڣ��򴴽�Ĭ�ϵ�ʵ�����ʵ��
			Object o =interfaceClassMapping.get(interfaceClass.getName());			
			if(o==null) {				
				throw new IllegalArgumentException("No impl class is registered for  " + interfaceClass);
			}
			
			try {
				if(o instanceof String) {
					String clazzName = (String)o;
					clazz = Class.forName(clazzName);
				}else if(o instanceof Class)
					clazz = (Class)o;
				else
					throw new IllegalArgumentException("Only String and Class is allowed for InterfaceUtils's key and value! But found:" + o.getClass());
				
			} catch (ClassNotFoundException e) {
				throw new IllegalArgumentException(e.getMessage());
			}
		}else {
			clazz = interfaceClass;
		}
		return clazz;
	}
	
	/**
	 * ����һ���ӿڣ� �������õĽӿ�ʵ���ഴ��һ������
	 * @param interfaceClass
	 * @return
	 * @throws IllegalArgumentException
	 */
	public Object createImplObject(Class interfaceClass)   {
		Object object = null;
		Class clazz = getImplClass(interfaceClass);
		
		try {
			object = clazz.newInstance();
		}catch(Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		return object;
	}
	
	/**
	 * ����һ���ӿڣ� �������õĽӿ�ʵ���ഴ��һ������
	 * ��ʵ������createImplObject������ͬ��
	 * @param interfaceClass
	 * @return
	 * @throws IllegalArgumentException 
	 */
	public Object createObject(Class interfaceClass)   {
		InterfaceUtils util = null;
		
		if( SpringContextManager.getDefaultBeanFactory().containsBean(InterfaceUtils.class.getName())) {
			util = (InterfaceUtils) SpringContextManager.getBean(InterfaceUtils.class.getName());
		}else
			util = interfaceUtils;
		
		return util.createImplObject(interfaceClass);		
	}
	
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put(List.class.getName(), LinkedList.class.getName());
		map.put(Map.class.getName(), LinkedHashMap.class.getName());
		
		InterfaceUtils interfaceUtils = new InterfaceUtils();
		interfaceUtils.setInterfaceClassMapping(map);
		
		Object o1 = interfaceUtils.createImplObject(List.class);
		Object o2 = interfaceUtils.createImplObject(Map.class);
		
		System.out.println("o1 " + o1.getClass().getName());
		System.out.println("o2 " + o2.getClass().getName());		
	}
}
