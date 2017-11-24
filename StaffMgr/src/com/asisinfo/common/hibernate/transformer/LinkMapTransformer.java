package com.asisinfo.common.hibernate.transformer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.io.Serializable;

import org.hibernate.transform.BasicTransformerAdapter;


/**
 * 将结果集转换为LinkedHashMap,遍历map时的顺序和结果集的列的顺序可以保持一致
 * @author johnson
 */
public class LinkMapTransformer extends BasicTransformerAdapter implements Serializable {

	public static final LinkMapTransformer INSTANCE = new LinkMapTransformer();

	public LinkMapTransformer() {
	}


	public Object transformTuple(Object[] tuple, String[] aliases) {
		Map result = new LinkedHashMap(tuple.length);
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
		return other != null && LinkMapTransformer.class.isInstance( other );
	}

	
	public int hashCode() {
		// todo : we can remove this once the deprecated ctor can be made private...
		return getClass().getName().hashCode();
	}
}
