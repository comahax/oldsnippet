package com.sunrise.boss.ui.commons.taglib.options.impl;

import java.util.HashMap;
import java.util.Map;

import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.taglib.options.Options;

public class ExampleOptions implements Options {

    /*
     * @return Map ����һ��Map����ǰ̨ѡ����������ʾ
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
     * ����õ���ѡ�����򣬷��ص���DataPackage������DataPackage.getDatas() �������Node���vo
     * @author mys
     */
	public Object valueObject(Object params, Object code, Object name, User user) {

		DataPackage dp = new DataPackage();		
		return dp;
	}
    
}
