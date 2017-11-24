package com.asisinfo.common.hibernate.transformer;

import java.util.List;

import org.apache.commons.beanutils.ConvertUtils;
import org.hibernate.transform.ResultTransformer;

/**
 * 实现单列的结果集到java常见数据类型的转换
 * @author johnson
 */
public class SimpleDataTransformer implements ResultTransformer{

	private static final long serialVersionUID = -9175033559748071093L;
	private Class resultClass;
	
	public SimpleDataTransformer(Class resultClass) {
		if(resultClass == null)
			throw new IllegalArgumentException("resultClass cannot be null");
		this.resultClass = resultClass;
	}
	
	public Object transformTuple(Object[] tuple, String[] aliases) {
		return ConvertUtils.convert(tuple[0], resultClass);
	}

	public List transformList(List collection) {
		return collection;
	}

}
