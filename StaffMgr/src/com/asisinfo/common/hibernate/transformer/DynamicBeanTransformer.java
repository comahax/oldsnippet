package com.asisinfo.common.hibernate.transformer;

import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.transform.ResultTransformer;

import com.asisinfo.common.model.DynamicBean;
import com.asisinfo.common.model.DynamicProperty;

public class DynamicBeanTransformer  implements ResultTransformer{
	private static final long serialVersionUID = 1L;
	
	private Map beanConfig;
	
	private String[] declaredFieldName;
	
	private String[] resultFields;//目标类的字段名称
	
	public DynamicBeanTransformer(Map<String,String> config){
		this.beanConfig = config;
		declaredFieldName = new String[config.size()];
		beanConfig.keySet().toArray(declaredFieldName);
	}

	public Object transformTuple(Object[] tuple, String[] aliases) {
		DynamicBean result = new DynamicBean(beanConfig);
		for(int i=0;i<declaredFieldName.length;i++){
			result.put(declaredFieldName[i], null);
		}

		try {
			if (resultFields == null) {
				resultFields = new String[aliases.length];
				for (int i = 0; i < aliases.length; i++) {
					String alias = aliases[i];
					if (alias != null) {
						//这里填充所需要设置的属性名称
						resultFields[i] = getFieldNameByAlias(alias);
					}
				}
			}
			
			for (int i = 0; i < aliases.length; i++) {
				if (resultFields[i] != null&&tuple[i]!=null) {
					Object val = tuple[i];
					String toType = (String)beanConfig.get(resultFields[i]);
					try {
						if(toType!=null){
							val = DynamicProperty.convert(val, toType);
						}
						result.put(resultFields[i], val);
					} catch (Exception e) {
						throw new Exception("无法将"+tuple[i]+"转换成"+resultFields[i]+":"+toType);
					} 
				}
			}
		} catch (Exception e) {
			throw new HibernateException("不能转换为DynamicBean,config="
					+ beanConfig,e);
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
		for (String fieldName : declaredFieldName) {
			if (fieldName.toLowerCase().equals(proName)) {
				return fieldName;
			}
		}
		return null;
	}
	
	public List transformList(List collection) {
		return collection;
	}
}
