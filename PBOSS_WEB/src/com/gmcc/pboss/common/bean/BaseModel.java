package com.gmcc.pboss.common.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * ���������,���Խ��в�����װ
 * @author Jimmy
 *
 */
public class BaseModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1834655531663137381L;
	protected Map<String,Object> datas  = new HashMap<String,Object>();
	
	/**
	 * �����µĲ���
	 * @param key
	 * @param data
	 */
	public void add(String key,Object data){
		datas.put(key, data);
	}
	/**
	 * 
	 * @param key
	 */
	public Object get(String key){
		return datas.get(key);
	}
	public Map<String, Object> getDatas() {
		return datas;
	}
	public void setDatas(Map<String, Object> datas) {
		this.datas = datas;
	}
	
	
}
