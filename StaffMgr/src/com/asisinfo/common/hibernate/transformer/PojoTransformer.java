package com.asisinfo.common.hibernate.transformer;

import java.lang.reflect.Field;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.HibernateException;
import org.hibernate.transform.ResultTransformer;

/**
 * 实现数据库结果集到pojo对象的转换
 * @author johnson_hong 2013-03-01
 * @see ResultTransformer
 */

public class PojoTransformer implements ResultTransformer {
	private static final long serialVersionUID = 1L;

	private Class resultClass;
	private Field[] fields;//目标类的所有字段
	
	private String[] resultFields;//目标类的字段名称

	public PojoTransformer(Class resultClass) {
		if (resultClass == null)
			throw new IllegalArgumentException("resultClass cannot be null");
		this.resultClass = resultClass;
		this.fields = resultClass.getDeclaredFields();
	}

	// 结果转换时，HIBERNATE调用此方法
	public Object transformTuple(Object[] tuple, String[] aliases) {
		Object result;

		try {
			if (resultFields == null) {// 首先初始化，取得目标POJO类的所有SETTER方法
				resultFields = new String[aliases.length];
				for (int i = 0; i < aliases.length; i++) {
					String alias = aliases[i];
					if (alias != null) {
						//这里填充所需要设置的属性名称
						resultFields[i] = getFieldNameByAlias(alias);
					}
				}
			}
			result = resultClass.newInstance();

			// 这里使用SETTER方法填充POJO对象
			for (int i = 0; i < aliases.length; i++) {
				if (resultFields[i] != null&&tuple[i]!=null) {
						try {
							BeanUtils.copyProperty(result, resultFields[i], tuple[i]);
						} catch (Exception e) {
							throw new Exception("无法将"+tuple[i]+"设置到"+resultClass.getName()+"的"+resultFields[i]);
						} 
				}
			}
		} catch (Exception e) {
			throw new HibernateException("不能转换为目标类型: "
					+ resultClass.getName(),e);
		}

		return result;
	}

	// 根据数据库字段名在POJO查找JAVA属性名，参数就是数据库字段名，如：USER_ID
	private String getFieldNameByAlias(String alias) {
		// 把字段名中所有的下杠去除
		String proName = alias.toLowerCase();
		String fieldName = null;
		fieldName = getFieldName(proName);//先不处理别名直接查找属性
		if(fieldName==null){//查找不到再去除下划线查找
			fieldName = getFieldName(proName.replaceAll("_", ""));
		}
		if(fieldName==null){//否则尝试去前缀和下划线查找
			if (proName.indexOf("_") > 0) {
				proName = proName.substring(proName.indexOf("_") + 1);
			}
			fieldName = getFieldName(proName.replaceAll("_", ""));
		}
		return fieldName;
	}

	private String getFieldName(String proName){
		for (Field field : fields) {
			if (field.getName().toLowerCase().equals(proName)) {
				return field.getName();
			}
		}
		return null;
	}
	
	public List transformList(List collection) {
		return collection;
	}

}
