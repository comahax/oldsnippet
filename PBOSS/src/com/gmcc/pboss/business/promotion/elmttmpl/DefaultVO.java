package com.gmcc.pboss.business.promotion.elmttmpl;

import java.util.HashMap;
import java.util.Iterator;

import open.tool.rule.data.VO;

import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * 
 * @author zhangsiwei
 * 
 */
public class DefaultVO extends VO {
	private HashMap<String, ?> keys;

	public HashMap<String, ?> getKeys() {
		return keys;
	}

	public void setKeys(HashMap<String, ?> keys) {
		this.keys = keys;
	}

	public boolean equals(Object o) {
		if(!(o instanceof DefaultVO)) {
			return false;
		}else {
			DefaultVO otherVo = (DefaultVO)o; 
			HashMap<String,?> otherKeys = otherVo.getKeys();
			for(String key : otherKeys.keySet()) {
				if(!this.keys.containsKey(key))
					return false;
				else if(!(this.keys.get(key).equals(otherKeys.get(key)))) {
					return false;
				}
			}
		}
		return true;
	}
	public int hashCode() {
		HashCodeBuilder hcb = new HashCodeBuilder();
		for (String key : keys.keySet()) {
			hcb.append(keys.get(key));
		}
		return hcb.toHashCode();
	}

}
