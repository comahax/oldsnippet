package com.sunrise.boss.ui.commons.taglib.options;

import java.util.Map;

import com.sunrise.boss.ui.commons.User;

public interface Options {

    /*
     * @return Map ����һ��Map����ǰ̨ѡ����������ʾ
     */
    public Map valueList(User user) ;
    
    public Object valueObject(Object params, Object code, Object name, User user);
}
