package com.sunrise.boss.ui.commons.taglib.morecode2name;

import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

public interface MoreCode2Name {

    /**
     * MoreCode2NameTag标签会调用以下3个方法 translateMore，getAllName，getAllCode，
     * MoreCheckTag标签会调用以下4个方法 getList，getObject，getAllName，getAllCode，
     * @param code Object    要被翻译的code
     * @return String        翻译后的字符串
     * @author mys
     */
    public String translateMore(Object code,User user)throws Exception;    
    
    public String getAllName() throws Exception;
    
    public String getAllCode() throws Exception;
    
    
    /**
     * 用于morecheck, 显示的列表集，
     * @param params
     * @throws Exception
     * @author mys
     */
    public Object getList(Object params, User user) throws Exception;
     
    
    /**
     * 用于morecheck, 显示的列表集,比如返回DataPackage
     * @author mys
     */
    public Object getObject(Object params, User user) throws Exception;
}
