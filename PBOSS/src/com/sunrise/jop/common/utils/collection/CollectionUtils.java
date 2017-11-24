/**
 * 
 */
package com.sunrise.jop.common.utils.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author He Kun
 *
 */
public class CollectionUtils {

	public static List toList(Collection c) {
		List list = new ArrayList(c.size());
		Iterator i = c.iterator();
		while( i.hasNext()) {
			list.add( i.next());
		}
		return list;
	}
}
