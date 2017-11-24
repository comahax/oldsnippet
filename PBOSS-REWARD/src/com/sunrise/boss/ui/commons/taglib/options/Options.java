package com.sunrise.boss.ui.commons.taglib.options;

import java.util.Map;

import com.sunrise.boss.ui.commons.User;

public interface Options {

    /*
     * @return Map 返回一个Map用于前台选择下拉框显示
     */
    public Map valueList(User user) ;
    
    public Object valueObject(Object params, Object code, Object name, User user);
}
