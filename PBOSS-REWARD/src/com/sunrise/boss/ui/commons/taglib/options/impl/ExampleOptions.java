package com.sunrise.boss.ui.commons.taglib.options.impl;

import java.util.HashMap;
import java.util.Map;

import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.taglib.options.Options;

public class ExampleOptions implements Options {

    /*
     * @return Map 返回一个Map用于前台选择下拉框显示
     */
    public Map valueList(User user) {
    	Map map = new HashMap();
    	map.put("111","1111");
    	map.put("222","2222");
    	map.put("333","3333");
    	map.put("444","4444");
		return map;    	
    }

    
    
    /**
     * 如果用到单选弹出框，返回的是DataPackage，并且DataPackage.getDatas() 里必须是Node类的vo
     * @author mys
     */
	public Object valueObject(Object params, Object code, Object name, User user) {

		DataPackage dp = new DataPackage();		
		return dp;
	}
    
}
