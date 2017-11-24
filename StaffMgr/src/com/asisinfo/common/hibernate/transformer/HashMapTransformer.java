package com.asisinfo.common.hibernate.transformer;

import java.util.HashMap;
import java.util.Map;
import java.io.Serializable;

import org.hibernate.transform.BasicTransformerAdapter;


/**
 * 将结果集转为HashMap
 * @author johnson
 */
public class HashMapTransformer extends BasicTransformerAdapter implements Serializable {


	public static final HashMapTransformer INSTANCE = new HashMapTransformer();

	public HashMapTransformer() {
	}


	public Object transformTuple(Object[] tuple, String[] aliases) {
		Map result = new HashMap(tuple.length);
		for ( int i=0; i<tuple.length; i++ ) {
			String alias = aliases[i];
			if ( alias!=null ) {
				result.put( alias.toLowerCase(), PropTranslate.tranProp(tuple[i]));
			}
		}
		return result;
	}

	private Object readResolve() {
		return INSTANCE;
	}

	public boolean equals(Object other) {
		// todo : we can remove this once the deprecated ctor can be made private...
		return other != null && HashMapTransformer.class.isInstance( other );
	}

	
	public int hashCode() {
		// todo : we can remove this once the deprecated ctor can be made private...
		return getClass().getName().hashCode();
	}
	
}
