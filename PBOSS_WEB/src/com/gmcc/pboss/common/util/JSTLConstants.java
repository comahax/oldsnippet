package com.gmcc.pboss.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.util.Assert;

/**
 * Class to reveal java constants to JSTL Expression Language Uses reflection to
 * scan the declared fields of a Constants class Adds these fields to the Map.
 * Map is unmodifiable after initialization.
 * 
 */
public class JSTLConstants extends HashMap {
	private boolean initialised = false;

	public JSTLConstants() {
		Class c = this.getClass();
		Object[] fields = getDeclaredField(c);
		for (int i = 0; i < fields.length; i++) {

			Field field = (Field) fields[i];
			int modifier = field.getModifiers();
			if (Modifier.isFinal(modifier) && !Modifier.isPrivate(modifier))
				try {
					this.put(field.getName(), field.get(this));
				} catch (IllegalAccessException e) {
				}
		}
		initialised = true;
	}

	public void clear() {
		if (!initialised)
			super.clear();
		else
			throw new UnsupportedOperationException("Cannot modify this map");
	}

	public Object put(Object key, Object value) {
		if (!initialised)
			return super.put(key, value);
		else
			throw new UnsupportedOperationException("Cannot modify this map");
	}

	public void putAll(Map m) {
		if (!initialised)
			super.putAll(m);
		else
			throw new UnsupportedOperationException("Cannot modify this map");
	}

	public Object remove(Object key) {
		if (!initialised)
			return super.remove(key);
		else
			throw new UnsupportedOperationException("Cannot modify this map");
	}
	/**
	 * 支持接口与父类字段
	 * @param clazz
	 * @return
	 * @throws NoSuchFieldException
	 */
	public static Object[] getDeclaredField(Class clazz) {
		Assert.notNull(clazz);
		Object[] fields = null;
		// 继承层次处理
		for (Class superClass = clazz; superClass != Object.class; superClass = superClass
				.getSuperclass()) {
			fields = ArrayUtils.addAll(fields, superClass.getDeclaredFields());
		}
		// 接口处理
		Class[] all = clazz.getInterfaces();
		for (int i=0; i<all.length;i++) {
			Class c = all[i];
			fields = ArrayUtils.addAll(fields, c.getDeclaredFields());
		}
		return fields;
	}
}
