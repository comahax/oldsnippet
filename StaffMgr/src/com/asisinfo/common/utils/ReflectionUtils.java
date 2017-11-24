/**
 * Copyright (c) 2005-2009 springside.org.cn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * $Id: ReflectionUtils.java 969 2010-03-01 14:50:35Z calvinxiu $
 */
package com.asisinfo.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ���乤����.
 * 
 * �ṩ����˽�б���,��ȡ��������Class, ��ȡ������Ԫ�ص�����, ת���ַ������Util����.
 * 
 * @author calvin
 */
public class ReflectionUtils {

	private static Logger logger = LoggerFactory.getLogger(ReflectionUtils.class);

	/**
	 * ͨ����, ���Class�����������ĸ���ķ��Ͳ��������.
	 * ���޷��ҵ�, ����Object.class.
	 * eg.
	 * public UserDao extends HibernateDao<User>
	 *
	 * @param clazz The class to introspect
	 * @return the first generic declaration, or Object.class if cannot be determined
	 */
	@SuppressWarnings("unchecked")
	public static <T> Class<T> getSuperClassGenricType(final Class clazz) {
		return getSuperClassGenricType(clazz, 0);
	}

	/**
	 * ͨ����, ��ö���Classʱ�����ĸ���ķ��Ͳ��������.
	 * ���޷��ҵ�, ����Object.class.
	 * 
	 * ��public UserDao extends HibernateDao<User,Long>
	 *
	 * @param clazz clazz The class to introspect
	 * @param index the Index of the generic ddeclaration,start from 0.
	 * @return the index generic declaration, or Object.class if cannot be determined
	 */
	@SuppressWarnings("unchecked")
	public static Class getSuperClassGenricType(final Class clazz, final int index) {

		Type genType = clazz.getGenericSuperclass();

		if (!(genType instanceof ParameterizedType)) {
//			logger.warn(clazz.getSimpleName() + "'s superclass not ParameterizedType");
			return Object.class;
		}

		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

		if (index >= params.length || index < 0) {
			logger.warn("Index: " + index + ", Size of " + clazz.getSimpleName() + "'s Parameterized Type: "
					+ params.length);
			return Object.class;
		}
		if (!(params[index] instanceof Class)) {
			logger.warn(clazz.getSimpleName() + " not set the actual class on superclass generic parameter");
			return Object.class;
		}

		return (Class) params[index];
	}

	/**
	 * ѭ������ת��,��ȡ�����DeclaredField.
	 *
	 * @throws NoSuchFieldException ���û�и�Fieldʱ�׳�.
	 */
	public static Field getDeclaredField(Object object, String propertyName) throws NoSuchFieldException {
		return getDeclaredField(object.getClass(), propertyName);
	}

	/**
	 * ѭ������ת��,��ȡ�����DeclaredField.
	 *
	 * @throws NoSuchFieldException ���û�и�Fieldʱ�׳�.
	 */

	public static Field getDeclaredField(Class clazz, String propertyName) throws NoSuchFieldException {
		for (Class superClass = clazz; superClass != Object.class; superClass = superClass.getSuperclass()) {
			try {
				return superClass.getDeclaredField(propertyName);
			} catch (NoSuchFieldException e) {
				// Field���ڵ�ǰ�ඨ��,��������ת��
			}
		}
		throw new NoSuchFieldException("No such field: " + clazz.getName() + '.' + propertyName);
	}
	
	/**
	 * ������ȡ�������ֵ,����private,protected���η������.
	 *
	 * @throws NoSuchFieldException ���û�и�Fieldʱ�׳�.
	 */
	public static Object forceGetProperty(Object object, String propertyName) throws NoSuchFieldException {

		Field field = getDeclaredField(object, propertyName);

		boolean accessible = field.isAccessible();
		field.setAccessible(true);

		Object result = null;
		try {
			result = field.get(object);
		} catch (IllegalAccessException e) {
		}
		field.setAccessible(accessible);
		return result;
	}

	/**
	 * �������ö������ֵ,����private,protected���η������.
	 *
	 * @throws NoSuchFieldException ���û�и�Fieldʱ�׳�.
	 */
	public static void forceSetProperty(Object object, String propertyName, Object newValue)
			throws NoSuchFieldException {
		Field field = getDeclaredField(object, propertyName);
		boolean accessible = field.isAccessible();
		field.setAccessible(true);
		try {
			field.set(object, newValue);
		} catch (IllegalAccessException e) {
		}
		field.setAccessible(accessible);
	}

	/**
	 * �������ö�����,����private,protected���η������.
	 *
	 * @throws NoSuchMethodException ���û�и�Methodʱ�׳�.
	 */
	public static Object invokePrivateMethod(Object object, String methodName, Object... params)
			throws NoSuchMethodException {
		Class[] types = new Class[params.length];
		for (int i = 0; i < params.length; i++) {
			types[i] = params[i].getClass();
		}

		Class clazz = object.getClass();
		Method method = null;
		for (Class superClass = clazz; superClass != Object.class; superClass = superClass.getSuperclass()) {
			try {
				method = superClass.getDeclaredMethod(methodName, types);
				break;
			} catch (NoSuchMethodException e) {
				// �������ڵ�ǰ�ඨ��,��������ת��
			}
		}

		if (method == null)
			throw new NoSuchMethodException("No Such Method:" + clazz.getSimpleName() + methodName);

		boolean accessible = method.isAccessible();
		method.setAccessible(true);
		Object result = null;
		try {
			result = method.invoke(object, params);
		} catch (Exception e) {
			org.springframework.util.ReflectionUtils.handleReflectionException(e);
		}
		method.setAccessible(accessible);
		return result;
	}
}